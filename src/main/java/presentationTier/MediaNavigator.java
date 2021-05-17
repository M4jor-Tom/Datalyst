package presentationTier;

import logicTier.LogicInterface;

import javax.swing.*;
import java.awt.*;

abstract public class MediaNavigator extends View
{
	private MediaPanel _mediaPanel;
	
	//Actions for buttons
	protected abstract void addActionListeners(JButton leftButton, JButton rightButton);
	
	public MediaNavigator(LogicInterface logicInterface)
	{
		super(logicInterface);
	}

	@Override
	public void run()
	{
		//JFrame instantiation
		JFrame jFrame = new JFrame();
		
		//Media instantiation
		instantiateMediaPanel();
		
		//JButtons instantiation
		JButton
			leftButton = new JButton("<"),
			rightButton = new JButton(">");
		
		//JButton decoration
		leftButton.setFocusPainted(false);
		rightButton.setFocusPainted(false);
		leftButton.setBackground(new Color(0, 0, 0));
		rightButton.setBackground(new Color(0, 0, 0));
		leftButton.setForeground(new Color(255, 255, 255));
		rightButton.setForeground(new Color(255, 255, 255));
		
		//JButtons listeners
		addActionListeners(leftButton, rightButton);
		
		//Adding Label and Panel to JFrame
		jFrame.setLayout(new BorderLayout());
		jFrame.getContentPane().add(getMediaPanel(), BorderLayout.CENTER);//getImageLabel(), BorderLayout.CENTER);
		jFrame.getContentPane().add(leftButton, BorderLayout.LINE_START);
		jFrame.getContentPane().add(rightButton, BorderLayout.LINE_END);
		
		//JFrame settings
		jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		//JFrame ready
		jFrame.setVisible(true);
	}

	protected abstract void instantiateMediaPanel();

	public MediaPanel getMediaPanel()
	{
		return _mediaPanel;
	}

	public void setMediaPanel(MediaPanel mediaPanel)
	{
		_mediaPanel = mediaPanel;
	}
}