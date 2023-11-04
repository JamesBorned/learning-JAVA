import java.util.ArrayList;

public class Movie {
    public Movie(String nameOfMovie, String duration){
        this.NameOfMovie = nameOfMovie;
        this.Duration = duration;
        movieSessions = new ArrayList<MovieSession>();
    }
    private ArrayList<MovieSession> movieSessions;

    public void initMovieSessions(MovieSession movieSession){
        for (int i = 0; i < movieSessions.size(); ++i){
            if (movieSession.getMovie().NameOfMovie.equals(this.getNameOfMovie())){
                movieSessions.set(i, movieSession);
            }
        }
    }
    public ArrayList<MovieSession> getMovieSessions(){
        return movieSessions;
    }
    public String getNameOfMovie(){
        return NameOfMovie;
    }

    public void setNameOfMovie(String nameOfMovie){
        this.NameOfMovie = nameOfMovie;
    }

    public String getDuration(){
        return Duration;
    }

    public void setDuration(String duration){
        this.Duration = duration;
    }

    public Session getMovieSession(){
        for (int i = 0; i < movieSessions.size(); ++i){
            if (movieSessions.get(i).getMovie() == this) {
                return movieSessions.get(i).getSession();
            }
        }
        return null;
    }

    public int getSumNumberOfTickets(){
        int SumNumberOfTickets = 0;
        for (int i = 0; i < movieSessions.size(); ++i){
            if (movieSessions.get(i).getMovie() == this) {
                SumNumberOfTickets += movieSessions.get(i).getSession().getNumberOfTickets();
            }
        }
        return SumNumberOfTickets;
    }

    private String NameOfMovie;
    private String Duration;
}
