package mediaTier;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import entitiesPackage.DevResource;
import entitiesPackage.Resource;

public class DevScraper extends WebScraper implements MediaInterface
{
	
	public DevScraper(String userName, String password)
	{
		super(
			"https://www.deviantart.com/users/login",
			"csrf_token",
			userName,
			password
		);
	}
	
	@Override
	public void login(String username, String password)
	{
		try
		{
			Connection.Response loginForm = Jsoup.connect(getLoginUrl())
				.userAgent(USER_AGENT)
				.data("username", username)
				.data("password", password)
				.execute();
			
			//This is the document containing response html
			Document loginDoc = loginForm.parse();
			
			//Save the cookies to be passed on to next request
			setCookies(loginForm.cookies());

			//Prepare login credentials
			String authToken = loginDoc.select(getTokenSelector()).first().attr("value");

			HashMap<String, String> formData = new HashMap<>();
			formData.put("referer", "https://www.deviantart.com/");
			formData.put("csrf_token", authToken);
			formData.put("challenge", "0");
			formData.put("username", username);
			formData.put("password", password);
			formData.put("remember", "on");

			//Now send the form for login
			Connection.Response homePage = Jsoup.connect("https://www.deviantart.com/_sisu/do/signin")
				.cookies(getCookies())
			    .data(formData)
			    .method(Connection.Method.POST)
			    .userAgent(USER_AGENT)
			    .execute();

			setCookies(homePage.cookies());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void actualizeResources()
	{
		try
		{
			//Get bookmarks list
			Elements bookmarks = getDocument("https://www.deviantart.com/snoiot/favourites")
				.getElementsByTag("a");

			//Preparing return variable
			ArrayList<Resource> resources = new ArrayList<>();
			for(Element bookmark: bookmarks)
				if(
					//Filter through bookmarks page to get good <a href>
					bookmark.hasAttr("data-hook")
					&& bookmark.attr("data-hook").equals("deviation_link")
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
				}
			setResources(resources);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}