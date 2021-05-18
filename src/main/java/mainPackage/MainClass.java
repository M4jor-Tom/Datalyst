package mainPackage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dataTier.DataInterface;
import logicTier.Logic;
import logicTier.LogicInterface;
import mediaTier.DevScraper;
import mediaTier.LocalDirectory;
import mediaTier.MediaInterface;
import mediaTier.PixScraper;
import presentationTier.ImageNavigator;
import presentationTier.View;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainClass
{
	public static void main(String[] args)
	{
		//DATA-TIER
		DataInterface mysqlManager = null;//new MySQLManager();
		
		//MEDIA-TIER
		MediaInterface testImagesBase = new LocalDirectory("C:\\GoogleDrive\\DCIM\\Images\\");
		//MediaInterface testVideoBase = new LocalDirectory("D:\\gDrive\\DCIM\\Videos\\");
		MediaInterface[] webScrapers = new MediaInterface[2];

		ObjectMapper objectMapper = new ObjectMapper();

		Map<String, String> cookies = new HashMap<>();
		try
		{
			cookies = objectMapper.readValue(
					new File("C:\\Users\\tom-v\\Desktop\\cookies.json"),
					new TypeReference<Map<String, String>>() {}
			);
			System.out.println("Cookie read success !");
		}
		catch(JsonProcessingException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			System.out.println("Json file \"cookies.json\" not found");
		}
		webScrapers[0] = new PixScraper(cookies, "https://www.pixiv.net/bookmark.php");
		//webScrapers[0] = new PixScraper(cookies, "https://www.pixiv.net/en/users/[upk]/bookmarks/artworks");
		webScrapers[1] = new DevScraper("[uid]", "[pwd]");
		
		//LOGIC-TIER
		LogicInterface imageLogic = new Logic(testImagesBase, webScrapers, mysqlManager);
		//LogicInterface videoLogic = new Logic(testVideoBase, webScrapers, mysqlManager);
		
		//VIEW-TIER
		View imageNavigator = new ImageNavigator(imageLogic);
		//View videoNavigator = new VideoNavigator(videoLogic);
		imageNavigator.run();
		//videoNavigator.run();
	}
}