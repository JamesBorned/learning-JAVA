public class Movie {
    public Movie(String nameOfMovie, String duration){
        this.NameOfMovie = nameOfMovie;
        this.Duration = duration;
    }
     MovieSessions = new
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

    public Session getMovieSession(Session session, Movie movie){

    }

    private String NameOfMovie;
    private String Duration;
}
