package io.github.some_example_name.lwjgl3;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextureObject extends Entity{
	
	private Texture texture;
	private SpriteBatch batch;
	
	
	
//	Constructor
	TextureObject(String filePath, float x, float y, float speed, SpriteBatch batch){
		super(x, y, speed);
		this.texture = new Texture(Gdx.files.internal(filePath));
		this.batch = batch;
	}
	
	
	//Setters
	public void setTexture(Texture tex) {
		this.texture = tex;
	}
	
	//Drawing the objects 
	public void drawTexture() {
		batch.draw(this.texture, getPosX(), getPosY(), texture.getWidth(), texture.getHeight());
	}
	
	//Getters Gets the texture type
	public Texture getTexture() {
		return this.texture;
	}
	
	public void dispose() {
		// TODO Auto-generated method stub
		this.texture.dispose();
	}
	

}
