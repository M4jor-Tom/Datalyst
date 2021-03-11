package EntitiesPackage;

import java.io.File;
import java.net.URL;

public class DevRessource extends ImageRessource
{
	public DevRessource(int localId, URL url, File file)
	{
		super(localId, url, file);
	}

	@Override
	public void setForeignIdFromUrl()
	{
		setForeignId(0);
	}
}