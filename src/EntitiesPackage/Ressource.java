package EntitiesPackage;

import DataTier.DataInterface;

abstract public class Ressource
{
	private int _localId;
	private Ressource _predecessor;
	private String _url;
	private DataInterface[] _webLocations;
	
	public Ressource(int localId, Ressource predecessor, String url)
	{
		setlocalId(localId);
		setPredecessor(predecessor);
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
	
	public Ressource getPredecessor()
	{
		return _predecessor;
	}

	public void setPredecessor(Ressource predecessor)
	{
		_predecessor = predecessor;
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