package LogicTier;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import DataTier.DataInterface;
import EntitiesPackage.Resource;

public class Logic implements LogicInterface
{
	DataInterface _localDataInterface;
	DataInterface[] _webDataInterfaces;
	int _current;
	ArrayList<Resource> _resources;
	BufferedImage _bufferedImage;
	
	public Logic(DataInterface localDataInterface, DataInterface[] webDataInterfaces)
	{
		setLocalDataInterface(localDataInterface);
		setWebDataInterfaces(webDataInterfaces);

		setCurrent(0);
		setResources(getLocalDataInterface().getResouces());
		updateBuffererdImage();
	}
	
	public DataInterface getLocalDataInterface()
	{
		return _localDataInterface;
	}
	
	public void setLocalDataInterface(DataInterface localDataInterface)
	{
		_localDataInterface = localDataInterface;
	}
	
	public void setWebDataInterfaces(DataInterface[] webDataInterfaces)
	{
		_webDataInterfaces = new DataInterface[webDataInterfaces.length];
		for(int i = 0; i < webDataInterfaces.length; i++)
			_webDataInterfaces[i] = webDataInterfaces[i];
	}
	
	public int getCurrent()
	{
		return _current;
	}
	
	public void setCurrent(int current)
	{
		_current = current;
	}

	@Override
	public void setUpCurrent()
	{
		if(getCurrent() < getResourcesCount())
		{
			setCurrent(getCurrent() + 1);
			updateBuffererdImage();
		}
	}

	@Override
	public void setDownCurrent()
	{
		if(getCurrent() > 0)
		{
			setCurrent(getCurrent() - 1);
			updateBuffererdImage();
		}
	}
	
	public ArrayList<Resource> getResources()
	{
		return getLocalDataInterface().getResouces();
	}
	
	public void setResources(ArrayList<Resource> ressources)
	{
		_resources = new ArrayList<>();
		_resources = ressources;
	}

	public int getResourcesCount()
	{
		return getResources().size();
	}

	public Resource getResource()
	{
		return getResources().get(getCurrent());
	}

	@Override
	public BufferedImage getBufferedImage()
	{
		return _bufferedImage;
	}

	public void updateBuffererdImage()
	{
		//Getting current Resource
		Resource currentRessource = getLocalDataInterface().getResouces().get(getCurrent());
		
		File file = null;
		URL url = null;
		
		//Deciding how to get BufferedImage object
		if((file = currentRessource.getFile()) != null)
		{
			try
			{
				_bufferedImage = ImageIO.read(file);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		else if((url = currentRessource.getUrl()) != null)
		{
			try
			{
				_bufferedImage = ImageIO.read(url);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}