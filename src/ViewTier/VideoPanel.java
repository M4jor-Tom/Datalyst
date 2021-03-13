package viewTier;

import java.awt.BorderLayout;
import java.awt.Component;
import java.io.File;
import java.io.IOException;

import javax.media.CannotRealizeException;
import javax.media.Manager;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.swing.JPanel;

public class VideoPanel extends JPanel
{
	public VideoPanel(File file)
    {
        setLayout(new BorderLayout());

		try
		{
			Player mediaPlayer = Manager.createRealizedPlayer(file.toURI().toURL());

	        Component video = mediaPlayer.getVisualComponent();
	        Component controls = mediaPlayer.getControlPanelComponent();
	        
	        add(video, BorderLayout.CENTER);
	        add(controls, BorderLayout.SOUTH);
		}
		catch(NoPlayerException | CannotRealizeException | IOException e)
		{
			e.printStackTrace();
		}
    }
}