package se.chalmers.pebjorn.bgf;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JFrame;

/**
 * The controller of the game. This class maintains the game loop and manages
 * the connection between game and view. This is the window frame.
 * 
 * @author Plankton555
 * @version v0.3 (2012-06-06)
 */
@SuppressWarnings("serial")
public class GameController extends JFrame implements Runnable {

	/** Reference to the view. */
	private final AbstractGameView view;
	/** Reference to the game. */
	private final IGame game;

	/** Determines whether the game should be paused or not. */
	private boolean pause;

	/** Determines the update interval. */
	private final int msPerFrame;

	private final Image screenBuffer;

	/** The number of times that update will run per cycle. */
	private int fastFwd = 1;

	/**
	 * Creates the controller.
	 * 
	 * @param game
	 *            The game to use.
	 * @param view
	 *            The view to use.
	 * @param msPerFrame
	 *            Time between update/draw calls.
	 */
	public GameController(IGame game, int msPerFrame) {
		super(game.getGameName());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.add(game.getGamePanel(), BorderLayout.CENTER);
		this.pack();
		this.setLocationRelativeTo(null); // Centers the window
		this.setVisible(true);
		this.setResizable(false);

		this.game = game;
		this.view = game.getGameView();
		this.msPerFrame = msPerFrame;

		this.screenBuffer = createImage(view.getWidth(), view.getHeight());

		this.game.setGameController(this);
		this.game.initialize();
		this.game.loadContent();
		pause = false;
	}

	/**
	 * Contains the game loop.
	 */
	@Override
	public void run() {
		while (true) {
			long startTimeNano = System.nanoTime();
			if (!pause) {
				for (int i = 0; i < fastFwd; i++) {
					game.update(view.getSize());
				}
				clearAndDraw();
			}
			long endTimeNano = System.nanoTime() - startTimeNano;
			try {
				// endTime is in nanoSeconds
				if (endTimeNano < msPerFrame * 1000000) {
					Thread.sleep(msPerFrame - endTimeNano / 1000000,
							(int) (endTimeNano % 1000000));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Clears the screen and draws the next one.
	 */
	private void clearAndDraw() {

		Graphics g = screenBuffer.getGraphics();
		g.setColor(view.getBackground());
		g.fillRect(0, 0, view.getWidth(), view.getHeight());
		g.setColor(Color.BLACK);

		game.draw(g, view.getSize());

		view.getGraphics().drawImage(screenBuffer, 0, 0, null);
	}

	/**
	 * Toggles the pause function.
	 */
	public void togglePause() {
		pause = !pause;
	}
	
	/**
	 * @return true if the game is paused, otherwise false.
	 */
	public boolean isPaused()
	{
		return pause;
	}

	/**
	 * @return The fast forward speed.
	 */
	public int getFastForward() {
		return fastFwd;
	}

	/**
	 * @param fastForward
	 *            The fast forward speed.
	 */
	public void setFastForward(int fastForward) {
		this.fastFwd = Math.max(1, fastForward);
	}

	/**
	 * @return The view.
	 */
	public AbstractGameView getView() {
		return view;
	}
}
