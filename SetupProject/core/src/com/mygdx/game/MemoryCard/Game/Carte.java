package com.mygdx.game.MemoryCard.Game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.MemoryCard.State.StateAnimation;
import com.mygdx.game.MemoryCard.State.StateCarte;
import com.mygdx.game.MemoryCard.State.StateVerso;

import java.util.HashMap;

public class Carte {
	private int id;
	private StateCarte state;
	private int x, y;
	private int width, height;
	private HashMap<String, Animation> animations;
	private TextureRegion currentFrame;
	private String currentAnimation;
    private float elapsedTime = 0;
    private Texture img;

	public Carte(int id, int x, int y, int w, int h){
		this.id = id;
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
		state = new StateVerso();
        animations = new HashMap<String, Animation>();
        currentAnimation = "verso";
	}
	
	public boolean EqualTo(Carte carte){
		if(this.id == carte.getId()){
			return true;
		}
		else{
			state.NextState(this);
			carte.getState().NextState(carte);
			return false;
		}
	}
	
	public void Clicked(int x, int y){
		if(x>=this.x && x<=this.x+this.width 
		&& y>=this.y && y<=this.y+this.height 
		&& this.state.getSOF() != StateCarte.StateOfCarte.Recto){
			state.NextState(this);
		}
		else{
			System.out.println("Carte deja tourner");
		}
			
	}
	
	public void NextState(){
		state.NextState(this);
	}
	
	public StateCarte getState() {
		return state;
	}

	public int getId() {
		return id;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setState(StateCarte state) {
		this.state = state;
	}

    public void addAnimation(String name, Animation animation) {
        animations.put(name, animation);
    }

    public void update(float deltaTime){
        elapsedTime+=deltaTime;
        state.execute(this);

        if(state.getSOF() == StateCarte.StateOfCarte.Verso)
            currentFrame = animations.get("verso").getKeyFrame(elapsedTime);
        else if(state.getSOF() == StateCarte.StateOfCarte.Animation
                || state.getSOF() == StateCarte.StateOfCarte.RetourAnim)
            currentFrame = animations.get("rotating").getKeyFrame(elapsedTime);
    }

    public void draw(SpriteBatch batch){
        if(state.getSOF() != StateCarte.StateOfCarte.Recto)
            batch.draw(currentFrame, this.x, this.y);
        else
            batch.draw(img,x,y);
    }

    public void setImg(Texture img) {
        this.img = img;
    }
}
