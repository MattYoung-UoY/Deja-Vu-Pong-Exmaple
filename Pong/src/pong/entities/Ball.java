package pong.entities;

import java.util.Random;

import dejavu.engine.graphics.Loader;
import dejavu.engine.graphics.Quad;

public class Ball {

	private Quad ballQuad;
	private Random rand;
	
	private float initX, initY, dirY;
	private boolean left;
	
	private static final float SCALE = 0.1f, SPEED = 0.025f;
	
	public Ball(float initX, float initY){
		rand = new Random();
		randomizeDir();
		ballQuad = new Quad(initX - SCALE/2, initY + SCALE/2, 0,  SCALE, SCALE, Loader.loadTexture("/black.png"));
		this.initX = initX;
		this.initY = initY;
	}
	
	public void update() {
		if(left) ballQuad.increasePosition(-SPEED / (Math.abs(dirY) + 1), SPEED * dirY / (Math.abs(dirY) + 1));
		else ballQuad.increasePosition(SPEED / (Math.abs(dirY) + 1), SPEED * dirY / (Math.abs(dirY) + 1));
		
		if(ballQuad.getX() <= -1 || ballQuad.getX() >= 1) reset();
		
		if(ballQuad.getY() > 1) {
			float extra = ballQuad.getY() - 1;
			dirY *= -1;
			ballQuad.increasePosition(0, -2 * extra);
		}else if(ballQuad.getY() - ballQuad.getScaleY() < -1) {
			float extra = (ballQuad.getY() - ballQuad.getScaleY()) + 1;
			dirY *= -1;
			ballQuad.increasePosition(0, -2 * extra);
		}
	}
	
	public void reset() {
		randomizeDir();
		ballQuad.increasePosition((initX - ballQuad.getX()) - SCALE/2, (initY - ballQuad.getY()) + SCALE/2);
	}
	
	public void randomizeDir() {
		switch (rand.nextInt(2)) {
		case 0:
			left = true;
			break;
		case 1:
			left = false;
		}
		
		dirY = (6*rand.nextFloat()) - 3;
	}
	
	public Quad getBallQuad() {return ballQuad;}
	
}
