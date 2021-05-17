package entitiesPackage;

import java.io.File;

public class LocalVideoResource extends resourcePackage.VideoResource
{
	public LocalVideoResource(int localId, File file)
	{
		super(localId, null, file, "");
	}
}