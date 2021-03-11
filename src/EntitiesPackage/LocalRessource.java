package EntitiesPackage;

import java.io.File;

public class LocalRessource extends ImageResource
{
	public LocalRessource(int localId, File file)
	{
		super(localId, null, file);
	}
}