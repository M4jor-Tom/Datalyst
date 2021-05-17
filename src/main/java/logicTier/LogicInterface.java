package logicTier;

import java.awt.image.BufferedImage;

public interface LogicInterface
{
	public void setUpCurrent();
	public void setDownCurrent();

	public BufferedImage getBufferedImage();

	public resourcePackage.Resource getResource();
}