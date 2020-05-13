package test.statePattern;

public class Cyclops {
	
	private State state;
	private State normalState;
	private State battleState;
	
	
	public Cyclops(){
		this.normalState = new NormalState();
		this.battleState = new BattleState();
		this.state = this.normalState;
	}
	
	public void setState(String mode){
		if(mode.equals("NORMAL")){
			this.state = this.normalState;
		}else if(mode.equals("BATTLE")){
			this.state = this.battleState;
		}
	}
	
	public void blink(){
		this.state.blink();
	}
}
