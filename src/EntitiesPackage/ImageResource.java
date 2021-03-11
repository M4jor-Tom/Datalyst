package EntitiesPackage;

import java.io.File;
import java.net.URL;

abstract public class ImageResource extends PreReferencedResource
{
	public ImageResource(int localId, URL url, File file)
	{
		super(localId, url, file);
	}
}