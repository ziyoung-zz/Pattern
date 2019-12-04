# Command Patern
![command-pattern](./command-pattern.png)
- 요청을 하는 객체와 그 요청을 수행하는 객체를 분리시킬수 있다.
-  이벤트가 발생했을 때 실행될 기능이 다양하면서도 변경이 필요한 경우에 이벤트를 발생시키는 클래스를 변경하지 않고 재사용하고자 할 때 유용하다.
- Command
실행될 기능에 대한 인터페이스
실행될 기능을 execute 메서드로 선언함
- ConcreteCommand
실제로 실행되는 기능을 구현
즉, Command라는 인터페이스를 구현함
- Invoker
기능의 실행을 요청하는 호출자 클래스
- Receiver
ConcreteCommand에서 execute 메서드를 구현할 때 필요한 클래스
즉, ConcreteCommand의 기능을 실행하기 위해 사용하는 수신자 클래스

### 예제

서커스 공연 프로그램이다.
사자,저글러,삐에로가 공연을하고 마지막 피날래 공연이 열린다.

```java
public interface Command {
	public void excute(); 
}
```
Command를 사용하여 입장후 공연하는 ConcreteCommand를 작성한다.
```java
public class JugglerEnterCommand implements Command {
	Juggler juggler;
	public JugglerEnterCommand(Juggler juggler){
		this.juggler = juggler;
	}
	@Override
	public void excute() {
		juggler.enter();
		juggler.juggle();
	}
}
public class LionEnterCommand implements Command {
	Lion lion;
	public LionEnterCommand(Lion lion){     this.lion = lion;	}
	@Override
	public void excute() {
		lion.enter();
		lion.roar();
	}
}
public class PierrotEnterCommand implements Command {
	Pierrot pierrot;
	public PierrotEnterCommand(Pierrot pierrot){    this.pierrot = pierrot;	}
	@Override
	public void excute() {
		pierrot.enter();
		pierrot.perform();
	}
}
```

마찬가지로 Command를 사용하여 퇴장하는 ConcreteCommand를 작성한다.
```java
public class JugglerExeuntCommand implements Command {
	Juggler juggler;
	public JugglerExeuntCommand(Juggler juggler){   this.juggler = juggler;}
	@Override
	public void excute() {
		juggler.exeunt();
	}
}
public class LionExeuntCommand implements Command {
	Lion lion;
	public LionExeuntCommand(Lion lion){    this.lion = lion;}
	@Override
	public void excute() {
		lion.exeunt();
	}
}
public class PierrotExeuntCommand implements Command {
	Pierrot pierrot;
	public PierrotExeuntCommand(Pierrot pierrot){   this.pierrot = pierrot;}
	@Override
	public void excute() {
		pierrot.exeunt();
	}
}
```
서커스 공연을 이끌어갈 Invoker 클래스 showman을 작성한다
```java
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
```
피날레커맨드는 매크로 커맨드로 작성한다.
(매크로 커맨드 : 여러개의 다른 명령들을 받아서 한번에 실행 시켜 주는 커맨드 객체 )
```java
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
```
최종적으로 서커스를 진행할 Client를 생성한다.
```java
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
```
