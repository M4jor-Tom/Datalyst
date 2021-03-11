package MainPackage;

//3-Tier
import DataTier.*;
import LogicTier.*;
import ViewTier.*;

public class MainClass
{
	public static void main(String[] args)
	{
		//DATA-TIER
		DataInterface testImagesBase = new LocalDataBase("D:\\gDrive\\DCIM\\Images\\");
		DataInterface[] webScrappers = new DataInterface[2];
		webScrappers[0] = new PixScrapper();
		webScrappers[1] = new DevScrapper();
		
		//LOGIC-TIER
		LogicInterface logic = new Logic(testImagesBase, webScrappers);
		
		//VIEW-TIER
		View window = new View(logic, 800, 500);
	}
}