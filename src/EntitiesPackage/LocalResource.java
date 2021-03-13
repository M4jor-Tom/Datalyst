package entitiesPackage;

import java.io.File;

public class LocalResource extends ImageResource
{
	public LocalResource(int localId, File file)
	{
		super(localId, null, file, "");
	}
}