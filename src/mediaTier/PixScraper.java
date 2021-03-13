package mediaTier;

import java.util.ArrayList;

import entitiesPackage.Resource;

public class PixScraper extends WebScraper implements MediaInterface
{
	public PixScraper(String userName, String password)
	{
		super(
			"https://accounts.pixiv.net/login?return_to=https%3A%2F%2Fwww.pixiv.net%2Fen%2F&lang=en&source=pc&view_type=page",
			"",
			userName,
			password
		);
	}
	@Override
	public void actualizeResources()
	{
		
	}
}