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
	private JLabel _imageLabel;
	
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
		setImageLabel(new JLabel(getLogicInterface().getImageIcon()));
		
		//JButtons instantiation
		JButton
			leftButton = new JButton("<"),
			rightButton = new JButton(">");
		
		//JButton decoration
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
		jFrame.setLayout(new BorderLayout());
		jFrame.getContentPane().add(getImageLabel(), BorderLayout.CENTER);
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

	public JLabel getImageLabel()
	{
		return _imageLabel;
	}

	public void setImageLabel(JLabel imageLabel)
	{
		_imageLabel = imageLabel;
	}
}