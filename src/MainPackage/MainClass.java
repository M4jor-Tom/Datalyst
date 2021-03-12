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
		MediaInterface[] webScrappers = new MediaInterface[2];
		webScrappers[0] = new PixScraper();
		webScrappers[1] = new DevScraper();
		
		//LOGIC-TIER
		LogicInterface logic = new Logic(testImagesBase, webScrappers, mysqlManager);
		
		//VIEW-TIER
		View window = new View(logic);
		window.run();
	}
}