package pong.gameStates;

import java.awt.Color;

import dejavu.engine.GameLauncher;
import dejavu.engine.gameStates.GameState;
import dejavu.engine.io.Keys;
import pong.entities.Bat;

public class PlayState extends GameState{

	private Bat playerBat = new Bat(-0.8f), opponentBat = new Bat(0.8f);
	
	public PlayState() {
		super(Color.WHITE);
		this.addQuad(playerBat.getBatQuad());
		this.addQuad(opponentBat.getBatQuad());
	}

	@Override
	public void init() {
		
	}

	@Override
	public void update() {
		if(Keys.isKeyDown(Keys.KEY_ESCAPE)) GameLauncher.closeGame();
		
		if(Keys.isKeyDown(Keys.KEY_W)) playerBat.getBatQuad().increasePosition(0, 0.01f);
		else if(Keys.isKeyDown(Keys.KEY_S)) playerBat.getBatQuad().increasePosition(0, -0.01f);
	}

	@Override
	public void cleanUp() {
		
	}

}
