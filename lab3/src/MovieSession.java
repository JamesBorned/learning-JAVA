public class MovieSession {
    public MovieSession(Movie movie, Session session){
        this.Movie = movie;
        this.Session = session;
    }

    public Movie getMovie(){
        return Movie;
    }

    public void setMovie(Movie movie){
        this.Movie = movie;
    }

    public Session getSession(){
        return Session;
    }

    public void setSession(Session session){
        this.Session = session;
    }

    public int getNumberOfMovieSession(){
        return NumberOfMovieSession;
    }

    public void setNumberOfMovieSession(int numberOfMovieSession){
        this.NumberOfMovieSession = numberOfMovieSession;
    }

    private Movie Movie;
    private Session Session;
    private int NumberOfMovieSession;
}
