package presentationTier;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class ImagePanel extends MediaPanel
{
	private static final long serialVersionUID = 1L;
	private BufferedImage _bufferedImage;
	
	public ImagePanel(BufferedImage bufferedImage)
	{
		setBufferedImage(bufferedImage);
	}
	
	public void actualize(BufferedImage bufferedImage)
	{
		setBufferedImage(bufferedImage);
		revalidate();
		repaint();
	}
	
	protected void paintComponent(Graphics graphics)
	{
		super.paintComponent(graphics);
		
		//Choosing fitting mode depending on image and screen proportions
		boolean fitToWidth =
				(getWidth() / getHeight())
				< (getBufferedImage().getWidth() / getBufferedImage().getHeight());
				
		graphics.drawImage(
			_bufferedImage.getScaledInstance(
				fitToWidth
					? getWidth()
					: -1,
				fitToWidth
					? -1
					: getHeight(),
				BufferedImage.SCALE_SMOOTH
			),
			0,//(getWidth() - getBufferedImage().getWidth()) / 2,
			0,
			this
		);
	}

	public BufferedImage getBufferedImage()
	{
		return _bufferedImage;
	}

	public void setBufferedImage(BufferedImage bufferedImage)
	{
		_bufferedImage = bufferedImage;
	}
}