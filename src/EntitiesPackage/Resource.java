package entitiesPackage;

import java.io.File;
import java.net.URL;

import mediaTier.MediaInterface;

abstract public class Resource
{
	private int _localId;
	private URL _url;
	private File _file;
	private MediaInterface[] _webLocations;
	private String _name;
	final public static int UNDEFINED = -1;
	
	public Resource(int localId, URL url, File file, String name)
	{
		setlocalId(localId);
		setUrl(url);
		setFile(file);
		setName(name);
	}

	public int getlocalId()
	{
		return _localId;
	}

	public void setlocalId(int localId)
	{
		_localId = localId;
	}

	public URL getUrl()
	{
		return _url;
	}
	
	public void setUrl(URL url)
	{
		_url = url;
	}

	public File getFile()
	{
		return _file;
	}

	public void setFile(File file)
	{
		_file = file;
	}

	public MediaInterface[] getWebLocations()
	{
		return _webLocations;
	}

	public void setWebLocations(MediaInterface[] webLocations)
	{
		_webLocations = webLocations;
	}

	public String getName()
	{
		return _name;
	}

	public void setName(String name)
	{
		_name = name;
	}
}