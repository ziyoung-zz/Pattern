package test.composite;

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
