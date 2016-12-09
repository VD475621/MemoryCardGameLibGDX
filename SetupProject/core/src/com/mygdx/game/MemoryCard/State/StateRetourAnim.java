package com.mygdx.game.MemoryCard.State;


import com.mygdx.game.MemoryCard.Game.Carte;

public class StateRetourAnim extends StateCarte {

	public StateRetourAnim(){
		SOF = StateOfCarte.RetourAnim;
	}
	@Override
	public void NextState(Carte carte) {
		// TODO Auto-generated method stub
		carte.setState(new StateVerso());
	}
	@Override
	public void execute(Carte carte) {
		// TODO Auto-generated method stub
		
	}

}
