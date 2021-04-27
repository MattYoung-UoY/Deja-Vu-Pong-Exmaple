package pong.entities;

import dejavu.engine.graphics.Loader;
import dejavu.engine.graphics.Quad;

public class Bat {

	private float scaleX = 0.05f, scaleY = 0.25f;
	private Quad batQuad;
	
	public static final float SPEED = 0.015f;
	
	public Bat(float xPos) {
		batQuad = new Quad(xPos, 0f + (scaleY/2), 0f, scaleX, scaleY, Loader.loadTexture("/black.png"));
	}
	
	public void moveBat(float dy) {
		if(dy > 0 && batQuad.getY() >= 1f)
			batQuad.increasePosition(0, 1 - batQuad.getY());
		else if(dy < 0 && batQuad.getY() - batQuad.getScaleY() <= -1f)
			batQuad.increasePosition(0, -1 - (batQuad.getY() - batQuad.getScaleY()));
		else
			batQuad.increasePosition(0, dy);
	}
	
	public Quad getBatQuad() {return batQuad;}
	
}
