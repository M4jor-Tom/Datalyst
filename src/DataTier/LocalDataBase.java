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
		File[] files = new File(getLocalPath()).listFiles();
		ArrayList<Resource> resourcesList = new ArrayList<>();
		
		for(final File file: files)
			resourcesList.add(new LocalResource(0, file));
		
		return resourcesList;
	}
}