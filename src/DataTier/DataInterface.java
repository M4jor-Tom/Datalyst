package DataTier;

import EntitiesPackage.Ressource;

public interface DataInterface
{	
	public Ressource[] getRessouces();

	public int getFetchSize();
}