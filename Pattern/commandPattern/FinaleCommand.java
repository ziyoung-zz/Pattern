package test;

public class FinaleCommand implements Command {

	Command[] commands;
	
	public FinaleCommand(Command[] commands){
		this.commands = commands;
	}
	
	public void excute() {
		for(int slot =0 ; slot < commands.length ; slot++){
			commands[slot].excute();
		}
	}

}
