package ViewTier;

import javax.swing.*;
import LogicTier.LogicInterface;

public class View
{
	private LogicInterface _logicInterface;
	private int _width, _height;
	private JFrame _jframe;
	
	public View(LogicInterface logicInterface, int width, int height)
	{
		setLogicInterface(logicInterface);
		setJframe(new JFrame());
		
		//JFrame settings
		setHeight(height);
		setWidth(width);
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