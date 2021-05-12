package presentationTier;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import logicTier.LogicInterface;

public class VideoNavigator extends MediaNavigator
{
	public VideoNavigator(LogicInterface logicInterface)
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
						//getImagePanel().actualize(getLogicInterface().getBufferedImage());
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
					//getImagePanel().actualize(getLogicInterface().getBufferedImage());
				}
			}
		);
	}

	@Override
	protected void instantiateMediaPanel()
	{
		setMediaPanel(new VideoPanel(getLogicInterface().getResource().getFile()));
	}
}