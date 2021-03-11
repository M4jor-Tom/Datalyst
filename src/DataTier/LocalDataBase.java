package DataTier;

import java.util.ArrayList;

import EntitiesPackage.Resource;

public class LocalDataBase implements DataInterface
{
	private String _localPath;
	
	public LocalDataBase(String localPath)
	{
		setLocalPath(localPath);
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
	public ArrayList<Resource> getResouces()
	{
		return null;
	}
}