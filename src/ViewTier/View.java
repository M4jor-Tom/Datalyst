package ViewTier;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import LogicTier.LogicInterface;

public class View
{
	private LogicInterface _logicInterface;
	
	//SWING
	private int _width, _height;
	private JLabel _imageLabel;
	
	public View(LogicInterface logicInterface, int width, int height)
	{
		//3-Tier setting
		setLogicInterface(logicInterface);
		setHeight(height);
		setWidth(width);
	}
	
	public void run()
	{
		//JFrame instantiation
		JFrame jFrame = new JFrame();
		
		//Image instantiation
		setImageLabel(new JLabel(getLogicInterface().getImageIcon()));
		
		//JButtons instantiation
		JButton
			leftButton = new JButton("<"),
			rightButton = new JButton(">");
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.add(leftButton);
		buttonsPanel.add(rightButton);
		
		//JButtons listeners
		leftButton.addActionListener(
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					getLogicInterface().setDownCurrent();
					getImageLabel().setIcon(getLogicInterface().getImageIcon());
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
					getImageLabel().setIcon(getLogicInterface().getImageIcon());
				}
			}
		);
		
		//Adding Label and Panel to JFrame
		jFrame.add(getImageLabel());
		jFrame.add(buttonsPanel);
		
		//JFrame settings
		jFrame.setSize(getWidth(), getHeight());
		
		//JFrame ready
		jFrame.setLayout(new CardLayout());
		jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
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

	public int getWidth()
	{
		return _width;
	}

	public void setWidth(int width)
	{
		_width = width;
	}

	public int getHeight()
	{
		return _height;
	}

	public void setHeight(int height)
	{
		_height = height;
	}

	public JLabel getImageLabel()
	{
		return _imageLabel;
	}

	public void setImageLabel(JLabel imageLabel)
	{
		_imageLabel = imageLabel;
	}
}