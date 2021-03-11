package viewTier;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import logicTier.LogicInterface;

public class View
{
	private LogicInterface _logicInterface;
	
	//SWING
	private ImagePanel _imagePanel;
	
	public View(LogicInterface logicInterface)
	{
		//3-Tier setting
		setLogicInterface(logicInterface);
	}
	
	public void run()
	{
		//JFrame instantiation
		JFrame jFrame = new JFrame();
		
		//Image instantiation
		setImagePanel(new ImagePanel(getLogicInterface().getBufferedImage()));
		
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
		
		//Adding Label and Panel to JFrame
		jFrame.setLayout(new BorderLayout());
		jFrame.getContentPane().add(getImagePanel(), BorderLayout.CENTER);//getImageLabel(), BorderLayout.CENTER);
		jFrame.getContentPane().add(leftButton, BorderLayout.LINE_START);
		jFrame.getContentPane().add(rightButton, BorderLayout.LINE_END);
		
		//JFrame settings
		jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		//JFrame ready
		jFrame.setVisible(true);
	}

	public LogicInterface getLogicInterface()
	{
		return _logicInterface;
	}

	public void setLogicInterface(LogicInterface logicInterface)
	{
		_logicInterface = logicInterface;
	}

	public ImagePanel getImagePanel()
	{
		return _imagePanel;
	}

	public void setImagePanel(ImagePanel imagePanel)
	{
		_imagePanel = imagePanel;
	}
}