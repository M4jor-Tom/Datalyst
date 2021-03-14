package viewTier;

import logicTier.LogicInterface;

abstract public class View
{
	private LogicInterface _logicInterface;
	
	public View(LogicInterface logicInterface)
	{
		//3-Tier setting
		setLogicInterface(logicInterface);
	}
	
	public abstract void run();

	public LogicInterface getLogicInterface()
	{
		return _logicInterface;
	}

	public void setLogicInterface(LogicInterface logicInterface)
	{
		_logicInterface = logicInterface;
	}
}