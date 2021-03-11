package EntitiesPackage;

import java.io.File;
import java.net.URL;

abstract public class PreReferencedRessource extends Ressource
{
	private int _foreignId;
	
	public PreReferencedRessource(int localId, URL url, File file)
	{
		super(localId, url, file);
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