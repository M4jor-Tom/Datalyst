package EntitiesPackage;

import DataTier.DataInterface;

abstract public class Ressource
{
	private int _localId;
	private String _url;
	private DataInterface[] _webLocations;
	
	public Ressource(int localId, String url)
	{
		setlocalId(localId);
		setUrl(url);
	}

	public int getlocalId()
	{
		return _localId;
	}

	public void setlocalId(int localId)
	{
		_localId = localId;
	}

	public String getUrl()
	{
		return _url;
	}
	
	public void setUrl(String url)
	{
		_url = url;
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