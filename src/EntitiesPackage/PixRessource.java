package EntitiesPackage;

public class PixRessource extends PreReferencedRessource
{
	private int _page;
	
	public PixRessource(int localId, String url, int page)
	{
		super(localId, url);
		setPage(page);
	}

	@Override
	public void setForeignIdFromUrl()
	{
		setForeignId(0);
	}
}