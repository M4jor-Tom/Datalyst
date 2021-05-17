package entitiesPackage;

public interface PreReferenced
{
	public int getForeignId();
	public void setForeignId(int foreignId);
	
	public void setForeignIdFromUrl();
}