package mediaTier;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import resourcePackage.*;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import entitiesPackage.DevResource;

public class PixScraper extends WebScraper implements MediaInterface
{
	public PixScraper(String userName, String password)
	{
		super(
			"https://accounts.pixiv.net/login?return_to=https%3A%2F%2Fwww.pixiv.net%2Fen%2F&lang=en&source=pc&view_type=page",
			"post_key",
			userName,
			password
		);
	}
	
	public void login(String username, String password)
	{
		try
		{
			Connection.Response loginForm = Jsoup.connect(getLoginUrl())
				.userAgent(USER_AGENT)
				.data("username", username)
				.data("password", password)
				.method(Connection.Method.GET)
				.execute();
			
			//This is the document containing response html
			Document loginDoc = loginForm.parse();
			
			//Save the cookies to be passed on to next request
			setCookies(loginForm.cookies());
			
			//Prepare login credentials
			String authToken = loginDoc.select(getTokenSelector()).first().attr("value");

			HashMap<String, String> formData = new HashMap<>();
			formData.put("captcha", "");
			formData.put("g_recaptcha_response", "");
			formData.put("password", password);
			formData.put("pixiv_id", username);
			formData.put("post_key", authToken);
			formData.put("source", "pc");
			formData.put("ref", "");
			formData.put("return_to", "https://www.pixiv.net/en/");
			formData.put("recaptcha_enterprise_score_token", "");

			//Now send the form for login
			Connection.Response homePage = Jsoup.connect("https://accounts.pixiv.net/api/login?lang=en")
			     .cookies(getCookies())
			     .data(formData)
			     .method(Connection.Method.POST)
			     .userAgent(USER_AGENT)
			     .ignoreContentType(true)
			     .execute();

			System.out.println(homePage.parse().html());  
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void actualizeResources()
	{
		try
		{	
			System.out.println("Finding images...");

			//Get bookmarks list
			Elements bookmarks = getDocument("https://www.pixiv.net/en/users/39103457/bookmarks/artworks")
				.getElementsByTag("a");
			
			System.out.println(bookmarks);
			
			//Getting number of images for loading info
			int resourcesCount = bookmarks.size();

			//Preparing return variable
			ArrayList<Resource> resources = new ArrayList<>();
			int found = 0;
			for(Element bookmark: bookmarks)
				if(
					//Filter through bookmarks page to get good <a href>
					/*bookmark.hasAttr("data-hook")
					&& bookmark.attr("data-hook").equals("deviation_link")*/true
				)
				{
					//Getting full resolution image from artwork visualization page
					Element image = getDocument(bookmark.attr("href"))
						.select("img[aria-hidden]")
						.get(0);
					
					//Loading image into a resource
					resources.add(
						new DevResource(
							Resource.UNDEFINED,
							new URL(image.attr("src")),
							image.attr("alt")
						)
					);
					
					//Printing count of found images
					System.out.print("\b\b\b\b\b\b\b\b\b\b\b" + ++found + "/" + resourcesCount);
				}
			setResources(resources);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}