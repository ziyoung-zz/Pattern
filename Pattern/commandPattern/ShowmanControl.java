package test;

public class ShowmanControl {
	
	Command[] enterCommand = new Command[5];
	Command[] exeuntCommand = new Command[5];
	
	public ShowmanControl(){
	
		NoCommand noCommand = new NoCommand();
		
		for(int i=0; i<5 ; i++){
			
			this.enterCommand[i] = noCommand;
			this.exeuntCommand[i] = noCommand;

		}
	}
	
	public void setCommand(int slot, Command enterCommand, Command exeuntCommand){
		this.enterCommand[slot] = enterCommand;
		this.exeuntCommand[slot] = exeuntCommand;
	}
	
	public void executeEnterCommand(int slot){
		this.enterCommand[slot].excute();
	}
	
	public void executeExeuntCommand(int slot){
		this.exeuntCommand[slot].excute();
	}
}
