package io.github.some_example_name.lwjgl3;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Triangle extends Entity{
	
	private ShapeRenderer shape;
	private float size;
	
	private float p1X;
    private float p1Y;

    private float p2X; 
    private float p2Y;

    private float p3X;
    private float p3Y;
	


    
	//Constructor - Allows you to initialize multiple objects of this class 
	public Triangle(String colour, float x, float y, float size, float speed){
		super(x, y, speed, colour);
		this.size = size;
	}
	
	//Default Constructor setting values to null
	public Triangle(){
		super();
		this.size = 0;
	}
	
	//Getters 
	public float getSize(){
		return this.size;
	}

	public void setSize(float s){
		this.size = s;
	}

	public void drawShape(ShapeRenderer shape) {
		
		p1X = getPosX() - size;
	    p1Y = getPosY() - size;

	    p2X = getPosX() + size;
	    p2Y = getPosY() - size;

	    p3X = getPosX();
	    p3Y = getPosY()+size;
	    
		shape.triangle(p1X, p1Y, p2X, p2Y, p3X, p3Y);
		shape.setColor(getColor());
	}
	public void movement() {
		if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.A)) {
	        	setPosX(getPosX() - getDropSpeed() * Gdx.graphics.getDeltaTime()); // Move triangle left 
	        	 if (getPosX() - getSize() <= 0) {
	        		 setPosX(getSize());
	           }
	    }
	    
		if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.D)) {
				setPosX(getPosX() + getDropSpeed() * Gdx.graphics.getDeltaTime()); // Move triangle right
				 if (getPosX() >= Gdx.graphics.getWidth() - getSize()) {
		        	setPosX(Gdx.graphics.getWidth() - getSize());
		        }
		}
       
	}
	public void dispose() {
		// TODO Auto-generated method stub
		this.shape.dispose();
	}
}
