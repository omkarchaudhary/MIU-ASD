package game;

public class Application {

	public static void main(String[] args) {
//		Game game = new Game();
//		game.play();
//		game.play();
//		game.play();
//		game.play();
//		game.play();
		Game game = new Game();
		GameState gameState = new Level1(game);
		game.setGameState(gameState);
		gameState.addPoints(9);
		gameState.addPoints(13);
		gameState.addPoints(17);
		gameState.addPoints(25);
	}

}
