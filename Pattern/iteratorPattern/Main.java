package iteratorPattern;

public class Main {

	public static void main(String[] args) {
		
		MovieContainor movieContainor = new MovieContainor(4);
		
		movieContainor.appendMovie(new Movie("The Frozen2"));
		movieContainor.appendMovie(new Movie("Ford v Ferari"));
		movieContainor.appendMovie(new Movie("Knives Out"));
		movieContainor.appendMovie(new Movie("Last Chrismas"));
        Iterator it = movieContainor.getIterator();
        while(it.hasNext()){
        	Movie movie = (Movie)it.next();
            System.out.println(movie.getName());
        }
		
	}
}
