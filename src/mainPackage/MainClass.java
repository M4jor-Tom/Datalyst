package mainPackage;

import java.util.HashMap;
import java.util.Map;

import dataTier.*;
import logicTier.*;
import mediaTier.*;
import presentationTier.*;

public class MainClass
{
	public static void main(String[] args)
	{
		//DATA-TIER
		DataInterface mysqlManager = null;//new MySQLManager();
		
		//MEDIA-TIER
		MediaInterface testImagesBase = new LocalDirectory("D:\\gDrive - tf\\DCIM\\Images\\");
		//MediaInterface testVideoBase = new LocalDirectory("D:\\gDrive\\DCIM\\Videos\\");
		MediaInterface[] webScrapers = new MediaInterface[2];
		Map<String, String> cookies = new HashMap<String, String>();
		webScrapers[0] = new PixScraper(cookies, "https://www.pixiv.net/en/users/[upk]/bookmarks/artworks");
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