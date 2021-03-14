package viewTier;

import java.awt.BorderLayout;
import java.awt.Component;
import java.io.File;
import java.io.IOException;

import javax.media.*;

public class VideoPanel extends MediaPanel
{
	private static final long serialVersionUID = 1L;

	public VideoPanel(File file)
    {
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