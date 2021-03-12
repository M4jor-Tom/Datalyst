package mediaTier;

import org.python.util.PythonInterpreter;

public abstract class WebScraper implements MediaInterface
{
	public void scrap()
	{
		PythonInterpreter pythonInterpreter = new PythonInterpreter();
		
		pythonInterpreter.exec("echo 1+2;");
	}
}