package mediaTier;

import entitiesPackage.LocalImageResource;
import entitiesPackage.LocalVideoResource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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

	public List<resourcePackage.Resource> getResources()
	{
		File[] files = new File(getLocalPath()).listFiles();
		List<resourcePackage.Resource> resourcesList = new ArrayList<>();
		
		for(final File file: files)
			if(!file.isDirectory())
			{
				try
				{
					if(Files.probeContentType(Paths.get(file.getPath())).contains("image"))
						resourcesList.add(new LocalImageResource(0, file));
					else if(Files.probeContentType(Paths.get(file.getPath())).contains("video"))
						resourcesList.add(new LocalVideoResource(0, file));
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		
		return resourcesList;
	}
}