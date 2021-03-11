package EntitiesPackage;

abstract public class PreReferencedRessource extends Ressource
{
	private int _foreignId;
	
	public PreReferencedRessource(int localId, String url)
	{
		super(localId, url);
		setForeignIdFromUrl();
	}

	public int getForeignId()
	{
		return _foreignId;
	}

	public void setForeignId(int foreignId)
	{
		_foreignId = foreignId;
	}
	
	abstract public void setForeignIdFromUrl();
}