package test;

public class CircusShow {
	
	public static void main(String[] args) {
	
		ShowmanControl showman = new ShowmanControl();
		
		Lion lion = new Lion();
		LionEnterCommand lionEnter = new LionEnterCommand(lion);
		LionExeuntCommand lionExeunt = new LionExeuntCommand(lion);
		
		Juggler juggler = new Juggler();
		JugglerEnterCommand jugglerEnter = new JugglerEnterCommand(juggler);
		JugglerExeuntCommand jugglerExeunt = new JugglerExeuntCommand(juggler);
		
		Pierrot pierrot  = new Pierrot();
		PierrotEnterCommand pierrotEnter = new PierrotEnterCommand(pierrot);
		PierrotExeuntCommand pierrotExeunt = new PierrotExeuntCommand(pierrot);
		
		Command[] finaleEnterCommand = {lionEnter,jugglerEnter,pierrotEnter};
		Command[] finaleExeuntCommand = {lionExeunt,jugglerExeunt,pierrotExeunt};
		
		FinaleCommand finaleEnter = new FinaleCommand(finaleEnterCommand);
		FinaleCommand finaleExeunt = new FinaleCommand(finaleExeuntCommand);
		
		showman.setCommand(0, lionEnter, lionExeunt);
		showman.setCommand(1, jugglerEnter, jugglerExeunt);
		showman.setCommand(2, pierrotEnter, pierrotExeunt);
		
		System.out.println("CIRCUS SHOW BEGIN");
		showman.executeEnterCommand(0);
		showman.executeExeuntCommand(0);
		
		showman.executeEnterCommand(1);
		showman.executeExeuntCommand(1);
		
		showman.executeEnterCommand(2);
		showman.executeExeuntCommand(2);
		
		System.out.println("FINALE BEGINE");
		
		finaleEnter.excute();
		finaleExeunt.excute();
		
		System.out.println("FINALE END");
		
		System.out.println("CIRCUS SHOW END");
		
	}

}
