package EntitiesPackage;

import java.io.File;
import java.net.URL;

abstract public class ImageRessource extends PreReferencedRessource
{
	public ImageRessource(int localId, URL url, File file)
	{
		super(localId, url, file);
	}
}