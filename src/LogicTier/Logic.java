package LogicTier;

import DataTier.DataInterface;
import EntitiesPackage.Ressource;

public class Logic implements LogicInterface
{
	Ressource[] _ressources;
	DataInterface _localDataInterface;
	DataInterface[] _webDataInterfaces;
	
	public Logic(DataInterface localDataInterface, DataInterface[] webDataInterfaces)
	{
		_localDataInterface = localDataInterface;
		
		_webDataInterfaces = new DataInterface[webDataInterfaces.length];
		for(int i = 0; i < webDataInterfaces.length; i++)
			_webDataInterfaces[i] = webDataInterfaces[i];
		
		int fetchSize = _localDataInterface.getFetchSize();
		_ressources = new Ressource[fetchSize];
		_ressources = fetch();
	}

	private Ressource[] fetch()
	{
		//[TODO]
		return null;
	}
}