package pong.gameStates;

import java.awt.Color;

import dejavu.engine.GameLauncher;
import dejavu.engine.gameStates.GameState;
import dejavu.engine.io.Keys;
import pong.entities.Ball;
import pong.entities.Bat;

public class PlayState extends GameState{

	private Bat playerBat = new Bat(-0.8f), opponentBat = new Bat(0.8f);
	
	private Ball ball = new Ball(0, 0);
	
	public PlayState() {
		super(Color.WHITE);
		
		this.addQuad(playerBat.getBatQuad());
		this.addQuad(opponentBat.getBatQuad());
		
		this.addQuad(ball.getBallQuad());
	}

	@Override
	public void init() {
	}

	@Override
	public void update() {
		if(Keys.isKeyDown(Keys.KEY_ESCAPE)) GameLauncher.closeGame();
		
		if(Keys.isKeyDown(Keys.KEY_W)) 
			playerBat.moveBat(Bat.SPEED);
		else if(Keys.isKeyDown(Keys.KEY_S))
			playerBat.moveBat(-Bat.SPEED);
		
		float dp = ball.getBallQuad().getY() + (ball.getBallQuad().getScaleY()/2) - opponentBat.getBatQuad().getY();
		if(Math.abs(dp) > Bat.SPEED) {
			dp /= Math.abs(dp);
			opponentBat.moveBat(dp * Bat.SPEED);
		}
		
		ball.update();
		
	}

	@Override
	public void cleanUp() {
	}

}
