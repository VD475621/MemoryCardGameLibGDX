package com.mygdx.game.MemoryCard.State;


import com.mygdx.game.MemoryCard.Game.Carte;

public class StateAnimation extends StateCarte {
	
	public StateAnimation(){
		SOF = StateOfCarte.Animation;
	}
	
	@Override
	public void NextState(Carte carte) {
		// TODO Auto-generated method stub
		carte.setState(new StateRecto());
	}

	@Override
	public void execute(Carte carte) {
		// TODO Auto-generated method stub
		
	}

}
