package ViewTier;

import java.awt.CardLayout;

import javax.swing.*;

import LogicTier.LogicInterface;

public class View
{
	private LogicInterface _logicInterface;
	
	//SWING
	private int _width, _height;
	
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
		JLabel imageLabel = new JLabel(new ImageIcon(getLogicInterface().getImage()));
		jFrame.add(imageLabel);
		
		//JButtons instantiation
		JButton
			leftButton = new JButton("<"),
			rightButton = new JButton(">");
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.add(leftButton);
		buttonsPanel.add(rightButton);
		
		//JButtons added to JFrame
		jFrame.add(buttonsPanel);
		
		//JFrame settings
		jFrame.setSize(getWidth(), getHeight());
		
		//JFrame ready
		jFrame.setLayout(new CardLayout(5, 5));
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
}