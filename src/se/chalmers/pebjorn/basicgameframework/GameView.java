package se.chalmers.pebjorn.basicgameframework;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;

/**
 * An abstract game view. Let the game view extend this class.
 * @author Plankton555
 * @version v0.3 (2011-12-29)
 */
@SuppressWarnings("serial")
public abstract class GameView extends JPanel {

	/**
	 * Creates a double buffered GameView with default size 500x500 pixels, and default
	 * background color white.
	 */
	public GameView()
	{
		super(true);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(500, 500));
	}
}
