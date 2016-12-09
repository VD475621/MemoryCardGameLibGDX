package com.mygdx.game.MemoryCard.State;


import com.mygdx.game.MemoryCard.Game.Carte;

public class StateVerso extends StateCarte {

	public StateVerso(){
		SOF = StateOfCarte.Verso;
	}
	@Override
	public void NextState(Carte carte) {
		// TODO Auto-generated method stub
		carte.setState(new StateAnimation());
	}
	@Override
	public void execute(Carte carte) {
		// TODO Auto-generated method stub
		
	}
}
