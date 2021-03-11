package logicTier;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import entitiesPackage.Resource;
import mediaTier.MediaInterface;

public class Logic implements LogicInterface
{
	MediaInterface _localMediaInterface;
	MediaInterface[] _webMediaInterfaces;
	int _current;
	ArrayList<Resource> _resources;
	BufferedImage _bufferedImage;
	
	public Logic(MediaInterface localMediaInterface, MediaInterface[] webMediaInterfaces)
	{
		setLocalMediaInterface(localMediaInterface);
		setWebMediaInterfaces(webMediaInterfaces);

		setCurrent(0);
		setResources(getLocalMediaInterface().getResouces());
		updateBuffererdImage();
	}
	
	public MediaInterface getLocalMediaInterface()
	{
		return _localMediaInterface;
	}
	
	public void setLocalMediaInterface(MediaInterface localMediaInterface)
	{
		_localMediaInterface = localMediaInterface;
	}
	
	public void setWebMediaInterfaces(MediaInterface[] webMediaInterfaces)
	{
		_webMediaInterfaces = new MediaInterface[webMediaInterfaces.length];
		for(int i = 0; i < webMediaInterfaces.length; i++)
			_webMediaInterfaces[i] = webMediaInterfaces[i];
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
		if(getCurrent() < getResourcesCount() - 1)
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
		return getLocalMediaInterface().getResouces();
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

	public BufferedImage getBufferedImage()
	{
		return _bufferedImage;
	}
	
	@Override
	public ImageIcon getImageIcon()
	{
		return new ImageIcon(getBufferedImage());
	}

	public void updateBuffererdImage()
	{
		//Getting current Resource
		Resource currentRessource = getLocalMediaInterface().getResouces().get(getCurrent());
		
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