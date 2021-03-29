package logicTier;

import resourcePackage.*;

import java.awt.image.BufferedImage;

public interface LogicInterface
{
	public void setUpCurrent();
	public void setDownCurrent();

	public BufferedImage getBufferedImage();

	public Resource getResource();
}