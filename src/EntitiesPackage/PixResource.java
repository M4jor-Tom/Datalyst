package EntitiesPackage;

import java.io.File;
import java.net.URL;

public class PixResource extends ImageResource implements PreReferenced
{
	private int _page;
	
	public PixResource(int localId, URL url, int page, File file)
	{
		super(localId, url, file);
		setPage(page);
	}

	@Override
	public void setForeignIdFromUrl()
	{
		setForeignId(0);
	}

	public int getPage()
	{
		return _page;
	}

	public void setPage(int page)
	{
		_page = page;
	}
}