package iteratorPattern;

public class MovieContainor implements Containor {
	
	private Movie[] movies;
	private int last = 0;
	
	public MovieContainor(int size) {
		movies = new Movie[size];
	}
	
	public Movie getMovieAt(int index){
		return movies[index];
    }
    public void appendBook(Movie movie){
        this.movies[last] = movie;
        last++;
    }
    public int getLength(){
        return last;
    }
	
	@Override
	public Iterator getIterator() {
		return new MovieIterator(this);
	}
}
