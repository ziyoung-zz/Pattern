package iteratorPattern;

public class MovieIterator implements Iterator {

    private MovieContainor movieContainor;
    private int index;
    public MovieIterator(MovieContainor movieContainor){
        this.movieContainor=movieContainor;
        this.index = 0;
    }
    @Override
    public boolean hasNext(){
        if(index<movieContainor.getLength()){
            return true;
        }else{
            return false;
        }
    }
    @Override
    public Object next(){
        Movie movie = movieContainor.getMovieAt(index);
        index++;
        return movie;
    }
}
