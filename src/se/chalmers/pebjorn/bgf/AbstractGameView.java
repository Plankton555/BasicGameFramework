package se.chalmers.pebjorn.bgf;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;

/**
 * An abstract game view. Let the game view extend this class.
 * 
 * @author Plankton555
 * @version v0.3 (2012-06-06)
 */
@SuppressWarnings("serial")
public abstract class AbstractGameView extends JPanel {

	/**
	 * Creates a double buffered GameView with default size 500x500 pixels, and
	 * default background color white.
	 */
	public AbstractGameView() {
		super(true);
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(500, 500));
	}
}
