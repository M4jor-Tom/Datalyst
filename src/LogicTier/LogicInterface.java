package logicTier;

import java.awt.image.BufferedImage;

import entitiesPackage.Resource;

public interface LogicInterface
{
	public void setUpCurrent();
	public void setDownCurrent();

	public BufferedImage getBufferedImage();

	public Resource getResource();
}