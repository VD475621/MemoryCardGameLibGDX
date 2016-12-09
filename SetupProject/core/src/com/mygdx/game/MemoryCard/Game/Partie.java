package com.mygdx.game.MemoryCard.Game;

import com.mygdx.game.MemoryCard.State.StateCarte;

import java.util.Scanner;

public class Partie {
	private PaquetCarte p;
	
	public Partie(){
		p = new PaquetCarte(24);
		//p.MelangerCarte();
		for(Carte c : p.getCartes()){
			System.out.println(c.getId() + " ");
		}
	}
	
	void Lancer() throws InterruptedException{
		boolean finish = false;
		long t= System.currentTimeMillis();
		int i=1;
		//long end = t+ (5000);
		long end = t+ (30000);
		//long end = t+ (60000*5);
		long score=0;
		Scanner in;
		int c1, c2;
		System.out.println("Debut de la Partie");
		while(!finish && System.currentTimeMillis() < end){
			System.out.println("Tourner une carte : ");
			in = new Scanner(System.in);
			c1 = in.nextInt();
			p.getCartes().get(c1).Clicked(50, 50);
			p.getCartes().get(c1).Clicked(50, 50);
			System.out.println(p.getCartes().get(c1).getState().getSOF());
			
			
			System.out.println("Tourner une carte : ");
			in = new Scanner(System.in);
			c2= in.nextInt();
			p.getCartes().get(c2).Clicked(50, 50);
			p.getCartes().get(c2).Clicked(50, 50);
			System.out.println(p.getCartes().get(c2).getState().getSOF());
			
			if(p.getCartes().get(c1).getState().getSOF() != StateCarte.StateOfCarte.Recto
					 && p.getCartes().get(c2).getState().getSOF() != StateCarte.StateOfCarte.Recto){
				if(p.getCartes().get(c1).EqualTo(p.getCartes().get(c2))){
					System.out.println("Ces cartes sont paires");
					score+=100;
					System.out.println(score);
				}
				else{
					System.out.println("Ces cartes ne sont pas paires");
					p.getCartes().get(c1).getState().NextState(p.getCartes().get(c1));
					System.out.println(p.getCartes().get(c1).getState().getSOF());
					p.getCartes().get(c1).getState().NextState(p.getCartes().get(c1));
					System.out.println(p.getCartes().get(c1).getState().getSOF());
					
					p.getCartes().get(c2).getState().NextState(p.getCartes().get(c2));
					System.out.println(p.getCartes().get(c2).getState().getSOF());
					p.getCartes().get(c2).getState().NextState(p.getCartes().get(c2));
					System.out.println(p.getCartes().get(c2).getState().getSOF());
				}
			}
			else
				System.out.println("Ces cartes sont deja retournees");
			
			//System.out.println(i++);
			
			finish = p.TouteCarteRetourner();
			//Thread.sleep(1000);
		}
		if(System.currentTimeMillis() > end)
			System.out.println("Fin Timer");
		System.out.println("Fin de la Partie");
		
	}
}
