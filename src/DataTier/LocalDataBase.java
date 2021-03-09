package DataTier;

import EntitiesPackage.Ressource;

public class LocalDataBase implements DataInterface
{
	@Override
	public Ressource[] getRessouces()
	{
		return null;
	}

	@Override
	public int getFetchSize()
	{
		return 0;
	}
}