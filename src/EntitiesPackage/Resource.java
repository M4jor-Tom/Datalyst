package EntitiesPackage;

import java.io.File;
import java.net.URL;

import DataTier.DataInterface;

abstract public class Resource
{
	private int _localId;
	private URL _url;
	private File _file;
	private DataInterface[] _webLocations;
	
	public Resource(int localId, URL url, File file)
	{
		setlocalId(localId);
		setUrl(url);
		setFile(file);
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

	public DataInterface[] getWebLocations()
	{
		return _webLocations;
	}

	public void setWebLocations(DataInterface[] webLocations)
	{
		_webLocations = webLocations;
	}
}