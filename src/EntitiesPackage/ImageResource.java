package entitiesPackage;

import java.io.File;
import java.net.URL;

public class ImageResource extends MediaResource
{
	public ImageResource(int localId, URL url, File file, String name)
	{
		super(localId, url, file, name);
	}
}