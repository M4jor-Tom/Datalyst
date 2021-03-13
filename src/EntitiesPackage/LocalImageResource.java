package entitiesPackage;

import java.io.File;

public class LocalImageResource extends ImageResource
{
	public LocalImageResource(int localId, File file)
	{
		super(localId, null, file, "");
	}
}