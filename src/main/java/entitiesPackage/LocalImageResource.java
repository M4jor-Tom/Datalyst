package entitiesPackage;

import java.io.File;

public class LocalImageResource extends resourcePackage.ImageResource
{
	public LocalImageResource(int localId, File file)
	{
		super(localId, null, file, "");
	}
}