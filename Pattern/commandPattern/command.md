# Command Patern
![command-pattern].(./img/command-pattern.png)
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
