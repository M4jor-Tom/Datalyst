package DataTier;

import java.io.File;
import java.util.ArrayList;

import EntitiesPackage.LocalResource;
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
		ArrayList<Resource> resourcesList = new ArrayList<>();
		//TEST
		resourcesList.add(new ImageResource(0, null, new File(getLocalPath() + "imgres.jpg")));
		return resourcesList;
	}
}