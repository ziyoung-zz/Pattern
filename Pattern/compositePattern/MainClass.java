package test.composite;

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
