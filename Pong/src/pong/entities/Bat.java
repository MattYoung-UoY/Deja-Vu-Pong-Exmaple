package pong.entities;

import dejavu.engine.graphics.Loader;
import dejavu.engine.graphics.Quad;

public class Bat {

	private float scaleX = 0.05f, scaleY = 0.25f;
	private Quad batQuad;
	
	public Bat(float xPos) {
		batQuad = new Quad(xPos, 0f, 0f, scaleX, scaleY, Loader.loadTexture("/black.png"));
	}
	
	public Quad getBatQuad() {
		return batQuad;
	}
	
}
