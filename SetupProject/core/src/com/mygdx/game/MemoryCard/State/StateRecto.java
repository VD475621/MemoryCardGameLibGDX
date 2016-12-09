package com.mygdx.game.MemoryCard.State;


import com.mygdx.game.MemoryCard.Game.Carte;

public class StateRecto extends StateCarte {

	public StateRecto(){
		SOF = StateOfCarte.Recto;
	}
	@Override
	public void NextState(Carte carte) {
		// TODO Auto-generated method stub
		carte.setState(new StateRetourAnim());
	}
	@Override
	public void execute(Carte carte) {
		// TODO Auto-generated method stub
		
	}

}
