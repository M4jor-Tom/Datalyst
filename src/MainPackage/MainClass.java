package mainPackage;

import dataTier.*;
import logicTier.*;
import mediaTier.*;
import viewTier.*;

public class MainClass
{
	public static void main(String[] args)
	{
		//DATA-TIER
		DataInterface mysqlManager = null;//new MySQLManager();
		
		//MEDIA-TIER
		MediaInterface testImagesBase = new LocalDirectory("D:\\gDrive\\DCIM\\Images\\");
		MediaInterface[] webScrapers = new MediaInterface[2];
		webScrapers[0] = null;//new PixScraper("[uid]", "[pwd]");
		webScrapers[1] = null;//new DevScraper("[uid]", "[pwd]");
		
		//LOGIC-TIER
		LogicInterface logic = new Logic(testImagesBase, webScrapers, mysqlManager);
		
		//VIEW-TIER
		View window = new View(logic);
		window.run();
	}
}