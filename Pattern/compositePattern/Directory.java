package test.composite;

import java.util.ArrayList;

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
