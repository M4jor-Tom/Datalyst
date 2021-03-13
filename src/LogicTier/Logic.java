package logicTier;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import dataTier.DataInterface;
import entitiesPackage.Resource;
import mediaTier.MediaInterface;

public class Logic implements LogicInterface
{
	MediaInterface _localMediaInterface;
	MediaInterface[] _webMediaInterfaces;
	int _current;
	ArrayList<Resource> _resources;
	ArrayList<BufferedImage> _bufferedImages;
	
	public Logic(MediaInterface localMediaInterface, MediaInterface[] webMediaInterfaces, DataInterface sqlManager)
	{
		//Setting up N-tier architecture
		setLocalMediaInterface(localMediaInterface);
		setWebMediaInterfaces(webMediaInterfaces);

		//Cursor set to 0
		setCurrent(0);

		//Merging all resources from both local and distant directories
		ArrayList<Resource> allResources = new ArrayList<>();
		allResources = getLocalMediaInterface().getResources();
		//allResources.addAll(getWebMediaInterfaces()[0].getResources());
		//allResources.addAll(getWebMediaInterfaces()[1].getResources());
		
		//Good to have for later to do some database fetching to sync everything
		setResources(allResources);
		
		//Good to have to preload images and to use app fast once opened
		setBufferedImagesFromRessources(allResources);
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

	
	/*private MediaInterface[] getWebMediaInterfaces()
	{
		return _webMediaInterfaces;
	}*/
	
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
		}
	}

	@Override
	public void setDownCurrent()
	{
		if(getCurrent() > 0)
		{
			setCurrent(getCurrent() - 1);
		}
	}
	
	public ArrayList<Resource> getResources()
	{
		return _resources;
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
		return _bufferedImages.get(getCurrent());
	}
	
	public ArrayList<BufferedImage> getBufferedImages()
	{
		return _bufferedImages;
	}
	
	public void setBufferedImages(ArrayList<BufferedImage> bufferedImages)
	{
		_bufferedImages = new ArrayList<>();
	}
	
	public void addBufferedImage(BufferedImage bufferedImage)
	{
		getBufferedImages().add(bufferedImage);
	}
	
	public void setBufferedImagesFromRessources(ArrayList<Resource> resources)
	{
		setBufferedImages(null);
		for(Resource resource: resources)
		{
			File file = null;
			URL url = null;
			
			//Deciding how to get BufferedImage object
			if((file = resource.getFile()) != null)
			{
				try
				{
					addBufferedImage(ImageIO.read(file));
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			else if((url = resource.getUrl()) != null)
			{
				try
				{
					addBufferedImage(ImageIO.read(url));
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	public ImageIcon getImageIcon()
	{
		return new ImageIcon(getBufferedImage());
	}
}