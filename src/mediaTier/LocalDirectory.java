package mediaTier;

import java.io.File;
import java.util.ArrayList;

import entitiesPackage.LocalResource;
import entitiesPackage.Resource;

public class LocalDirectory implements MediaInterface
{
	private String _localPath;
	
	public LocalDirectory(String localPath)
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

	public ArrayList<Resource> getResources()
	{
		File[] files = new File(getLocalPath()).listFiles();
		ArrayList<Resource> resourcesList = new ArrayList<>();
		
		for(final File file: files)
			if(!file.isDirectory())
				resourcesList.add(new LocalResource(0, file));
		
		return resourcesList;
	}
}