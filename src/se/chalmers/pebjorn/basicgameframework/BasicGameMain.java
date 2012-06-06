package se.chalmers.pebjorn.basicgameframework;

/**
 * Call the static method to start the game.
 * @author Plankton555
 * @version v0.3 (2012-02-14)
 */
public class BasicGameMain {
	
	/**
	 * Starts a new game.
	 * @param game The implemented game extending AbstractGame.
	 * @param msPerFrame Update interval in milliseconds.
	 */
	public static void startGame(AbstractGame game, int msPerFrame)
	{
		GameController gameController = new GameController(game, msPerFrame);
		new Thread(gameController).start();
	}

}
