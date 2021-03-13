package entitiesPackage;

import java.net.URL;

public class PixResource extends ImageResource implements PreReferenced
{
	private int _pixId;
	private int _page;
	
	public PixResource(int localId, URL url, int page, String name)
	{
		super(localId, url, null, name);
		setPage(page);
		setForeignIdFromUrl();
	}

	public int getPage()
	{
		return _page;
	}

	public void setPage(int page)
	{
		_page = page;
	}

	@Override
	public int getForeignId()
	{
		return _pixId;
	}

	@Override
	public void setForeignId(int foreignId)
	{
		_pixId = foreignId;
	}

	@Override
	public void setForeignIdFromUrl()
	{
		setForeignId(0);
	}
}