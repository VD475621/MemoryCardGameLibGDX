package com.mygdx.game.MemoryCard.State;


import com.mygdx.game.MemoryCard.Game.Carte;

public abstract class StateCarte {
	public enum StateOfCarte {Verso, Animation, Recto, StateOfCarte, RetourAnim};
	protected StateOfCarte SOF;
	
	public StateOfCarte getSOF() {
		return SOF;
	}
	public void setSOF(StateOfCarte sOF) {
		SOF = sOF;
	}
	
	public abstract void execute(Carte carte);
	public abstract void NextState(Carte carte);
	
	
}
