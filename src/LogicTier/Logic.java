package LogicTier;

import java.util.ArrayList;

import DataTier.DataInterface;
import EntitiesPackage.Ressource;

public class Logic implements LogicInterface
{
	ArrayList<Ressource> _ressources;
	DataInterface _localDataInterface;
	DataInterface[] _webDataInterfaces;
	
	public Logic(DataInterface localDataInterface, DataInterface[] webDataInterfaces)
	{
		_localDataInterface = localDataInterface;
		
		_webDataInterfaces = new DataInterface[webDataInterfaces.length];
		for(int i = 0; i < webDataInterfaces.length; i++)
			_webDataInterfaces[i] = webDataInterfaces[i];

		_ressources = _localDataInterface.getRessouces();
	}

	public ArrayList<Ressource> getRessources()
	{
		return _ressources;
	}
}