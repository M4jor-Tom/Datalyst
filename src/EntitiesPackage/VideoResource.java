package entitiesPackage;

import java.io.File;
import java.net.URL;

public class VideoResource extends MediaResource
{
	public VideoResource(int localId, URL url, File file, String name)
	{
		super(localId, url, file, name);
	}
}