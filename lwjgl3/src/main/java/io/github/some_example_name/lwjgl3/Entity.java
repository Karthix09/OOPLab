package io.github.some_example_name.lwjgl3;

import com.badlogic.gdx.graphics.Color;

public class Entity {
	private float posX;
	private float posY;
	private float dropSpeed;
	private Color colour;
	
	
	//Constructor - For Texture Objects
	public Entity(float x, float y, float speed){
		this.posX = x;
		this.posY = y;
		this.dropSpeed = speed;
	}
	
	//Overloaded Constructor - For Shapes 
	public Entity(float x, float y, float speed, String colour){
			this.setColor(colour);
			this.posX = x;
			this.posY = y;
			this.dropSpeed = speed;
		}
	
		//Default Constructor setting values to null
		public Entity(){
			this.colour = Color.WHITE;
			this.posX = 0;
			this.posY = 0;
			this.dropSpeed = 0;
		}
		
		//Getters 
		public Color getColor(){
			return this.colour;
		}
		public float getPosX() {
			return this.posX;
		}
		public float getPosY() {
			return this.posY;
		}
		public float getDropSpeed() {
			return dropSpeed;
		}
		
		//Setters 
		public void setColor(String colour){
			if (colour == "green") {
				this.colour = Color.GREEN;
				return;
			}
			if (colour == "red") {
				this.colour = Color.RED;
				return;
			}
			else {
	            this.colour = Color.WHITE; // Default to white if input is null
	            return;
	        }
		}
		public void setPosX(float x) {
			this.posX = x;
		}
		public void setPosY(float y) {
			this.posY = y;
		}
		public void setDropSpeed(float speed) {
			this.dropSpeed = speed;
		}

}
