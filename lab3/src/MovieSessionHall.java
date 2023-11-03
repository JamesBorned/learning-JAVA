public class MovieSessionHall {
    public MovieSessionHall(MovieSession movieSession, Hall hall){
        this.MovieSession = movieSession;
        this.Hall = hall;
    }

    public MovieSession getMovieSession(){
        return MovieSession;
    }

    public void setMovieSession(MovieSession movieSession){
        this.MovieSession = movieSession;
    }

    public Hall getHall(){
        return Hall;
    }

    public void setHall(Hall hall){
        this.Hall = hall;
    }

    private MovieSession MovieSession;
    private Hall Hall;
}
