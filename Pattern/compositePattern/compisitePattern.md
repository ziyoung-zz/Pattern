# composite Pattern
- 객체들을 트리 구조로 구셩하여 부분과 전체를 나타내는 계층구조로 만든다.
- 클라이언트에서 개별 객체와 다른 객체들로 구성된 복합 객체(Composite)를 똑같은 방법으로 다룰 수 있다.

### 예제
간단한 파일시스템을 구현하였다

노드인터페이스
```java
public interface Node {
	public void getName();
}
```
노드인터페이스를 구현하는 파일클래스와 디렉토리 클래스
파일과 폴더 항목을 같은 구조에 집어넣어 부분-전체 계층구조를 생성할 수 있다.
이러한 구조는 부분(파일과 폴더)들이 모여있지만, 모든 것을 하나로 묶어서 전체로 다룰 수 있다.
```java
public class File implements Node {
	String name;
	public File(String name){
		this.name = name;
	}
	@Override
	public void getName() {
		System.out.println(name);
	}
}
public class Directory implements Node {
	
	private ArrayList<File> fileList = new ArrayList<>();	
	
	public void addFile(File file){
		fileList.add(file);
	}
	public void removeFile(File file){
		fileList.remove(file);
	}
		
	@Override
	public void getName() {
		for(File file : fileList){
			file.getName();
		}
	}

}
```
메인클래스
파일과 디렉토리를 같은 함수 getName()을 사용하여 정보를 출력할 수있다.
```java
public class MainClass {

	public static void main(String[] args) {
		File f1 = new File("A");
		File f2 = new File("A2");
		File f3 = new File("A3");
		f1.getName();
		
		Directory dir = new Directory();
		dir.addFile(f1);
		dir.addFile(f2);
		dir.addFile(f3);
		dir.getName();
	}
}
```

