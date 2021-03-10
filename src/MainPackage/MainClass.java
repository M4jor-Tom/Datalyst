package MainPackage;

//Program's classes
import EntitiesPackage.*;

//3-Tier
import DataTier.*;
import LogicTier.*;
import ViewTier.*;

public class MainClass
{
	public static void main(String[] args)
	{
		DataInterface localDataBase = new LocalDataBase();
		DataInterface[] webScrappers = new DataInterface[1];//[2];
		webScrappers[0] = new PixScrapper();
		//[TODO]
		//webScrappers[1] = new DevScrapper();
		
		LogicInterface logic = new Logic(localDataBase, webScrappers);
		
		View window = new View(logic, 800, 500);
	}
}