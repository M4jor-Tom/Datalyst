package entitiesPackage;

import resourcePackage.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import mediaTier.MediaInterface;

abstract public class MediaResource extends Resource
{
	private MediaInterface[] _webLocations;
	
	public MediaResource(int localId, URL url, File file, String name)
	{
		super(localId, url, file, name);
	}
	
	public MediaInterface[] getWebLocations()
	{
		return _webLocations;
	}

	public void setWebLocations(MediaInterface[] webLocations)
	{
		_webLocations = webLocations;
	}
}