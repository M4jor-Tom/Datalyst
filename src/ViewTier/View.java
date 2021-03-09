package ViewTier;

import LogicTier.LogicInterface;

public class View
{
	private LogicInterface _logicInterface;
	
	public View(LogicInterface logicInterface)
	{
		setLogicInterface(logicInterface);
	}

	public LogicInterface getLogicInterface()
	{
		return _logicInterface;
	}

	public void setLogicInterface(LogicInterface logicInterface)
	{
		_logicInterface = logicInterface;
	}
}