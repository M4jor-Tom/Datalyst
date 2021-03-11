package viewTier;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class ImagePanel extends JPanel
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