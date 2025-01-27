package io.github.some_example_name.lwjgl3;
import java.util.Random;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class GameMaster extends ApplicationAdapter{
	

	private SpriteBatch batch;
	private TextureObject[] droplets; // Declaring array of drops of type TextureObject 
	private TextureObject bucket;
	
	private ShapeRenderer shape;
	private Circle circle;
	private Triangle triangle;

	Random random = new Random(); // Random Generator 
	
	
	
	@Override
	public void create() {
		
		batch = new SpriteBatch();
		
		droplets = new TextureObject[10]; // Allocating a memory of 10 for 10 drops - of type TextureObject 
		
		
		//Creating 10 drops in different locations around the screen using a random number generator 
		
        for (int i = 0; i < droplets.length; i++) {
            float randomX = random.nextFloat() * (Gdx.graphics.getWidth() - 64); // Random X value 
            float randomSpeed = 1 + random.nextFloat() * 5; // Random speed between 1 and 5
            droplets[i] = new TextureObject("droplet.png", randomX, 400, randomSpeed, batch);
        }

	
		bucket = new TextureObject("bucket.png", Gdx.graphics.getWidth()/2, 0, 0, batch);
		
		System.out.println(bucket.getPosX());
		System.out.println(bucket.getTexture());
		
		shape = new ShapeRenderer();
		circle = new Circle("green", 50, 500, 200, 200);
		triangle = new Triangle("red", 100, 100, 70, 200);
		
		
	}
	
	@Override
	public void render(){
		
	ScreenUtils.clear(0,0,0.2f,1);
	batch.begin();
	
	// Draw all droplets
    for (TextureObject droplet : droplets) {
        droplet.drawTexture();
    }
    
    //Draw the bucket 
	bucket.drawTexture();
	
	batch.end();
	
	
	for (TextureObject droplet : droplets) {
		
		//Get the current position and subtract by dropSPeed to update the new Position 
		droplet.setPosY(droplet.getPosY() - droplet.getDropSpeed());
		
		// if drop's position is lesser than or equals to 0 then set it back to 400
		if (droplet.getPosY() <= 0) {
			droplet.setPosY(400);
			droplet.setPosX(random.nextFloat() * (Gdx.graphics.getWidth() - 64));
		}
	}
	
	
		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			bucket.setPosX(bucket.getPosX() - 200 * Gdx.graphics.getDeltaTime());
			if (bucket.getPosX() <= 0) {
				bucket.setPosX(0);
			}
		}
		if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			bucket.setPosX(bucket.getPosX() + 200 * Gdx.graphics.getDeltaTime());
			if (bucket.getPosX() >= Gdx.graphics.getWidth() - bucket.getTexture().getWidth()) {
				bucket.setPosX(Gdx.graphics.getWidth() - bucket.getTexture().getWidth());
			}
		}

		
	       shape.begin(ShapeRenderer.ShapeType.Filled);
	       
	       circle.drawShape(shape);
	       triangle.drawShape(shape);
	       System.out.println(triangle);
	       
	       shape.end();
	       
	       // Handle movement
	       circle.movement();
	       triangle.movement();

		}
	
	
	
	
//	Completely deletes cached data from the game once game window is closed. 
	
	public void disposal() { 
		for (TextureObject droplet: droplets) {
			droplet.dispose();
		}
		bucket.dispose();
		batch.dispose();
		circle.dispose();
		triangle.dispose();
	}
	
	
	


}
	
