package entitiesPackage;

import resourcePackage.*;

import java.io.File;

public class LocalVideoResource extends VideoResource
{
	public LocalVideoResource(int localId, File file)
	{
		super(localId, null, file, "");
	}
}