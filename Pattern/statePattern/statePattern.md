# state Pattern
- 일련의 규칙에 따라 객체의 상태(State)를 변화시켜, 객체가 할 수 있는 행위를 바꾸는 패턴이다.
- 상태에 따라 행동이 변화하는 객체엔 모두 적용할 수 있다.
- 상태를 인터페이스로 분리시켜 상태들을 유연하게 관리할 수 있기 때문에 유지 보수에 효율적이다.
- 스트래티지 패턴과 비슷할수도 있지만 차이점이 있다. 스트레티지 패턴은 변화에 일정함이 없지만, 스테이트 패턴의 경우 각   state간의 일정한 규칙이 존재한다.

### 예제
배틀모드와 노멀모드가있는 사이클롭스를 간단하게 구현하자
state 인터페이스와 그를 구현하는 클래스(normal, battle)
```java
public interface State {
	public void blink();
}
public class NormalState implements State {
	@Override
	public void blink() {
		System.out.println("Normal blink");
	}
}
public class BattleState implements State {
	@Override
	public void blink() {
		System.out.println("Laser blink");
	}
}
```

스테이트를 변경할수있는 사이클롭스 클래스
```java
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
```
메인클래스
전투시에만 레이저가 나오는 싸이클롭스이다.
```java
public class StatePattern {

	public static void main(String[] args) {
		Cyclops cyclops = new Cyclops();		
		cyclops.blink();
		cyclops.setState("BATTLE");
		cyclops.blink();
		cyclops.setState("NORMAL");
		cyclops.blink();
	}
}
```