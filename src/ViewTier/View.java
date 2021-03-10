package ViewTier;

import java.awt.CardLayout;

import javax.swing.*;
import LogicTier.LogicInterface;

public class View
{
	private LogicInterface _logicInterface;
	
	//SWING
	private int _width, _height;
	private JFrame _jframe;
	
	public View(LogicInterface logicInterface, int width, int height)
	{
		//3-Tier setting
		setLogicInterface(logicInterface);
		
		//JFrame instantiation
		setJframe(new JFrame());
		JButton
			leftButton = new JButton("<"),
			rightButton = new JButton(">");
		JPanel meanButtons = new JPanel();
		meanButtons.add(leftButton);
		meanButtons.add(rightButton);
		getJframe().add(meanButtons);
		
		//JFrame settings
		setHeight(height);
		setWidth(width);
		getJframe().setSize(getWidth(), getHeight());
		
		//JFrame ready
		getJframe().setLayout(new CardLayout(5, 5));
		getJframe().setVisible(true);
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

	public JFrame getJframe()
	{
		return _jframe;
	}

	public void setJframe(JFrame jframe)
	{
		_jframe = jframe;
	}
}