package mediaTier;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import entitiesPackage.Resource;

public abstract class WebScraper implements MediaInterface
{
	public String _loginUrl;
	public String _tokenName;
	private Map<String, String> _cookies;
	final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36";
	
	public WebScraper(String loginUrl, String tokenName, String userName, String password)
	{
		setCookies(null);
		setLoginUrl(loginUrl);
		setTokenName(tokenName);
		login(userName, password);
	}
	
	public void login(String username, String password)
	{
		
	}
	
	public String getTokenSelector()
	{
		return "input[name='" + getTokenName() + "']";
	}
	
	public String getLoginUrl()
	{
		return _loginUrl;
	}
	
	public void setLoginUrl(String loginUrl)
	{
		_loginUrl = loginUrl;
	}
	
	public String getTokenName()
	{
		return _tokenName;
	}
	
	public void setTokenName(String tokenName)
	{
		_tokenName = tokenName;
	}

	public Map<String, String> getCookies()
	{
		return _cookies;
	}

	public void setCookies(Map<String, String> cookies)
	{
		if(cookies != null)
			_cookies = new HashMap<>();
		_cookies = cookies;
	}
}