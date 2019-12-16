package iteratorPattern;

public class Main {

	public static void main(String[] args) {
		
		MovieContainor movieContainor = new MovieContainor(4);
		
		movieContainor.appendBook(new Movie("The Frozen2"));
		movieContainor.appendBook(new Movie("Ford v Ferari"));
		movieContainor.appendBook(new Movie("Knives Out"));
		movieContainor.appendBook(new Movie("Last Chrismas"));
        Iterator it = movieContainor.getIterator();
        while(it.hasNext()){
        	Movie movie = (Movie)it.next();
            System.out.println(movie.getName());
        }
		
	}
}
