package pong;

import dejavu.engine.GameLauncher;
import pong.gameStates.PlayState;

public class Game {

	public static void main(String[] args) {
		GameLauncher.initGame(args, "Pong");
		GameLauncher.setInitialGameState(new PlayState());
		GameLauncher.startGame();
	}
	
}
