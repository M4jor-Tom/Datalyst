package ViewTier;

import javax.swing.*;
import LogicTier.LogicInterface;

public class View
{
	private LogicInterface _logicInterface;
	private JFrame _jframe;
	
	public View(LogicInterface logicInterface)
	{
		setLogicInterface(logicInterface);
		setJframe(new JFrame());
		
		//JFrame settings
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

	public JFrame getJframe()
	{
		return _jframe;
	}

	public void setJframe(JFrame jframe)
	{
		_jframe = jframe;
	}
}