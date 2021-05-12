package presentationTier;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import logicTier.LogicInterface;

public class ImageNavigator extends MediaNavigator
{
	public ImageNavigator(LogicInterface logicInterface)
	{
		super(logicInterface);
	}
	
	@Override
	protected void addActionListeners(JButton leftButton, JButton rightButton)
	{
		leftButton.addActionListener(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					getLogicInterface().setDownCurrent();
					getImagePanel().actualize(getLogicInterface().getBufferedImage());
				}
			}
		);
		rightButton.addActionListener(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					getLogicInterface().setUpCurrent();
					getImagePanel().actualize(getLogicInterface().getBufferedImage());
				}
			}
		);
	}

	@Override
	protected void instantiateMediaPanel()
	{
		setMediaPanel(new ImagePanel(getLogicInterface().getBufferedImage()));
	}
	
	private ImagePanel getImagePanel()
	{
		return (ImagePanel)getMediaPanel();
	}
}