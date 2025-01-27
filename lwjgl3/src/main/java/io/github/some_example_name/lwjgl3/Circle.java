package io.github.some_example_name.lwjgl3;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Circle extends Entity{
	
	private ShapeRenderer shape;
	private float radius;

	
	
	
	//Constructor - Allows you to initialize multiple objects of this class 
	public Circle(String colour, float radius, float x, float y, float speed){
		super(x, y, speed, colour);
		this.radius = radius;
	}
	
	//Default Constructor setting values to null
	public Circle(){
		super();
		this.radius = 0;
	}
	
	//Getters 
	public ShapeRenderer getShape() {
		return this.shape;
	}

	public float getRadius(){
		return this.radius;
	}

	//Setters 
	public void setShape(ShapeRenderer shape){
		this.shape = shape;
	}

	public void setRadius(float r){
		this.radius = r;
	}

	
	public void drawShape(ShapeRenderer shape) {
		shape.circle(getPosX(), getPosY(), getRadius());
		shape.setColor(getColor());
	}
	
	public void movement() {
        if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.UP)) {
        	setPosY(getPosY() + getDropSpeed() * Gdx.graphics.getDeltaTime()); // Move circle up
        	
        	if (getPosY() >= Gdx.graphics.getHeight() - getRadius()) {
				setPosY(Gdx.graphics.getHeight() - getRadius());
			}
        }
        	
        if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.DOWN)) {
        	setPosY(getPosY() - getDropSpeed() * Gdx.graphics.getDeltaTime()); // Move circle down
        	
        	if (getPosY() - getRadius() <= 0) {
				setPosY(getRadius());
			}
        }
	}

	public void dispose() {
		// TODO Auto-generated method stub
		this.shape.dispose();
	}

}
