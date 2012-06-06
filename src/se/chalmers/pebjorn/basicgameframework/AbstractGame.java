package se.chalmers.pebjorn.basicgameframework;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * An abstract game class. To use this framework, extend this class.
 * 
 * @author Plankton555
 * @version v0.3 (2012-06-06)
 */
public abstract class AbstractGame {

	/**
	 * Gets the name of the game.
	 * 
	 * @return Name of the game.
	 */
	public abstract String getGameName();

	/**
	 * Sets a reference to the GameController. This method will be called once
	 * by the GameController.
	 * 
	 * @param controller
	 */
	public abstract void setGameController(GameController controller);

	/**
	 * Returns the game view. That is, the GameView to be updated in the game
	 * loop.
	 * 
	 * @return The GameView to be updated in the game loop.
	 */
	public abstract AbstractGameView getGameView();

	/**
	 * Returns the main game panel. That is, the JPanel that will be placed in
	 * the window frame.
	 * 
	 * @return The JPanel to be placed in the window frame.
	 */
	public abstract JPanel getGamePanel();

	/**
	 * Allows the game to perform any initialization it needs to before starting
	 * to run. This is where it can query for any required services and load any
	 * non-graphic related content.
	 */
	public abstract void initialize();

	/**
	 * loadContent will be called once per game and is the place to load all of
	 * your content.
	 */
	public abstract void loadContent();

	/**
	 * UnloadContent will be called once per game and is the place to unload all
	 * content. (Currently not used)
	 */
	public abstract void unloadContent();

	/**
	 * Allows the game to run logic such as updating the world, checking for
	 * collisions, gathering input, and playing audio.
	 * 
	 * @param clientBounds
	 *            The size of the game window.
	 */
	public abstract void update(Dimension clientBounds);

	/**
	 * This is called when the game should draw itself.
	 * 
	 * @param g
	 *            The graphics object.
	 * @param clientBounds
	 *            The size of the game window.
	 */
	public abstract void draw(Graphics g, Dimension clientBounds);
}
