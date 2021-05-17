package mediaTier;

import entitiesPackage.DevResource;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
				.method(Connection.Method.GET)
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
			System.out.println("Finding images...");
			
			/*HashMap<String, String> lazyLoadData = new HashMap<>();
			lazyLoadData.put("version", "eclipse%3Bmajor");
			lazyLoadData.put("platform", "desktop");
			lazyLoadData.put("url", "https%3A%2F%2Fwww.deviantart.com%2Fsnoiot%2Ffavourites");
			lazyLoadData.put("referer", "https%3A%2F%2Fwww.deviantart.com%2F");
			lazyLoadData.put("client_id", "7e54069e-13c1-92a0-731d-087b77b7dc38");
			lazyLoadData.put("uuid", "99a57314: 986-413b-a034-ed6466646c54");
			lazyLoadData.put("requestid", "623mc08fb284af062b0bfdc4186c154a340d");
			lazyLoadData.put("view", "profile");
			lazyLoadData.put("component", "favourites");
			lazyLoadData.put("_brandId", "wix");
			lazyLoadData.put("_ms", "32102");
			lazyLoadData.put("evid", "98");
			lazyLoadData.put("itemid", "69332372");
			lazyLoadData.put("typeid", "21");
			lazyLoadData.put("offset", "50");
			lazyLoadData.put("_lv", "2.0.875");
			lazyLoadData.put("_", new Timestamp(System.currentTimeMillis() / 1000).toString());
			
			Connection.Response lazyLoader = Jsoup.connect("https://frog.wix.com/da-client")
				.cookies(getCookies())
				.data(lazyLoadData)
				.method(Connection.Method.POST)
				.userAgent(USER_AGENT)
				.execute();
			
			//setCookies(lazyLoader.cookies());*/

			//Get bookmarks list
			Elements bookmarks = getDocument("https://www.deviantart.com/snoiot/favourites")
				.getElementsByTag("a");
			
			//Getting number of images for loading info
			int resourcesCount = bookmarks.size();

			//Preparing return variable
			List<resourcePackage.Resource> resources = new ArrayList<>();
			int found = 0;
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
							resourcePackage.Resource.UNDEFINED,
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