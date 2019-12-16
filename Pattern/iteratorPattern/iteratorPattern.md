# iterator pattern
- 집합체 내에서 어떤 식으로 일이 처리되는지에 대해서는 전혀 모르는 상태에서 그 안에 들어있는 모든 항목들에 대해 반복작업을 수행할 수 있게 해주는 패턴이다
- 반복자(Iterator)를 만들어서 이터레이터 패턴을 사용하면 컬렉션 객체 안에 들어있는 모든 항목에 접근하는 방식을 통일할 수 있다.
- 모든 항목에 일일이 접근하는 작업을 컬렉션 객체가 아닌 반복자 객체에서 맡게된다.  집합체의 인터페이스 및 구현이 간단해질 뿐 아니라, 집합체에서는 반복작업에서 손 때고 원래 자신이 할 일(객체 컬렉션을 관리하는 역할)에만 전념할 수 있게 된다.

# Example
인터페이스 생성한다.
```java
public interface Iterator {
	public boolean hasNext();
	public Object next();
}
public interface Containor {
	public Iterator getIterator();
}
```
인터페이스를 구현하는 클래스를 생성한다.
배열을 사용하여 영화컨테이너를 만들었다.
```java
public class Movie {
	private String name;
	public Movie(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
}
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
```
메인클래스
배열이아닌 다른 방법(벡터,어레이리스트)를 사용하더라도 이터레이터를 이용하여 같은 방법으로 접근할 수 있다.
```java
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
```
