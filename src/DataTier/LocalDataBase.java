package DataTier;

import java.util.ArrayList;

import EntitiesPackage.Ressource;

public class LocalDataBase implements DataInterface
{
	private String _localPath;
	
	public LocalDataBase(String localPath)
	{
		setLocalPath(_localPath);
	}
	
	public String getLocalPath()
	{
		return _localPath;
	}

	public void setLocalPath(String localPath)
	{
		_localPath = localPath;
	}

	@Override
	public ArrayList<Ressource> getRessouces()
	{
		return null;
	}
}