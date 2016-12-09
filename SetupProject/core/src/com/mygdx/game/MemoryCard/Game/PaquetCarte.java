package com.mygdx.game.MemoryCard.Game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.mygdx.game.MemoryCard.State.StateCarte;

import java.util.ArrayList;
import java.util.Random;



public class PaquetCarte {
	private ArrayList<Carte> cartes;
	private int nb_carte;
	private int width_card = 80;
    private int height_card = 40;
    private Texture img;

    TextureAtlas atlasVerso;
    Animation versoAnimation;

    TextureAtlas atlasRotating;
    Animation rotateAnimation;

	public PaquetCarte(int nb){
		this.nb_carte = nb;
		cartes = new ArrayList<Carte>();
		int j=1;
		for(int i=0; i<nb_carte;i+=2){
			cartes.add(new Carte(j,50,50,width_card, height_card));
			cartes.add(new Carte(j,50,50,width_card, height_card));
			j++;
		}

        img = new Texture("Cards.png");

        atlasVerso = new TextureAtlas("verso.txt");
        versoAnimation = new Animation(1 / 8f, atlasVerso.getRegions());
        versoAnimation.setPlayMode(Animation.PlayMode.NORMAL);

        atlasRotating = new TextureAtlas("animation_card.txt");
        rotateAnimation = new Animation(1 / 8f, atlasRotating.getRegions());
        rotateAnimation.setPlayMode(Animation.PlayMode.LOOP);

        int k=0;
        for(int i=0;i<4;i++){
            for(j=0;j<6;j++)
            {
                System.out.println(k);
                cartes.get(k).setX(i*width_card +150);
                cartes.get(k).setY(j*height_card +height_card*2 +40);
                cartes.get(k).addAnimation("verso",versoAnimation);
                cartes.get(k).addAnimation("rotating",rotateAnimation);
                cartes.get(k).setImg(img);
                k++;
            }
        }

		MelangerCarte();
	}
	
	public boolean Existe(int paires[], int nb){
		for(int i : paires){
			if(i == nb)
				return true;
		}
		return false;
	}
	
	public void MelangerCarte(){
		Carte temp;
		Random rn = new Random();
		for(int i=0;i<this.nb_carte*2;i++){
			int c1 = rn.nextInt(this.nb_carte);
			int c2 = rn.nextInt(this.nb_carte);
			//System.out.println(c1 + "  " + c2);
			temp = this.cartes.get(c1);
			this.cartes.set(c1, this.cartes.get(c2));
			this.cartes.set(c2, temp);
			//System.out.println(cartes.get(c1).getId() + "  " + cartes.get(c2).getId());
		}
	}

	public int getNb_carte() {
		return nb_carte;
	}

	public ArrayList<Carte> getCartes() {
		return cartes;
	}
	
	public boolean TouteCarteRetourner(){
		for(int i=0;i<nb_carte;i++)
			if(this.cartes.get(i).getState().getSOF() != StateCarte.StateOfCarte.Recto)
				return false;
		return true;
	}

    public void update(float deltaTime){
        for(Carte c : cartes)
            c.update(deltaTime);
    }

    public void draw(SpriteBatch batch){
        for(Carte c : cartes)
            c.draw(batch);
    }
}
