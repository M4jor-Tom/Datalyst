package EntitiesPackage;

public class PixRessource extends PreReferencedRessource
{
	public PixRessource(int localId, Ressource predecessor, String url)
	{
		super(localId, predecessor, url);
	}

	@Override
	public void setForeignIdFromUrl()
	{
		setForeignId(0);
	}
}