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

    private Movie Movie;
    private Session Session;
}
