package mainPackage;

import logicTier.*;
import mediaTier.*;
import viewTier.*;

public class MainClass
{
	public static void main(String[] args)
	{
		//MEDIA-TIER
		MediaInterface testImagesBase = new LocalDirectory("D:\\gDrive\\DCIM\\Images\\");
		MediaInterface[] webScrappers = new MediaInterface[2];
		webScrappers[0] = new PixScrapper();
		webScrappers[1] = new DevScrapper();
		
		//LOGIC-TIER
		LogicInterface logic = new Logic(testImagesBase, webScrappers);
		
		//VIEW-TIER
		View window = new View(logic, 800, 500);
		window.run();
	}
}