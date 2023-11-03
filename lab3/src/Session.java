import java.util.ArrayList;

public class Session {
    public Session(String date, String time, int numberOfTickets){
        this.Date = date;
        this.Time = time;
        this.NumberOfTickets = numberOfTickets;
    }

    private ArrayList<MovieSessionHall> movieSessionHalls = new ArrayList<>();
    public ArrayList<MovieSessionHall> getMovieSessionHalls(){
        return movieSessionHalls;
    }
    public String getDate(){
        return Date;
    }

    public void setDate(String date){
        this.Date = date;
    }

    public String getTime(){
        return Time;
    }

    public void setTime(String time){
        this.Time = time;
    }

    public int getNumberOfTickets(){
        return NumberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets){
        this.NumberOfTickets = numberOfTickets;
    }

    public Hall getSessionHall(MovieSession movieSession){
        for (int i = 0; i < movieSessionHalls.size(); ++i){
            if (movieSessionHalls.get(i).getMovieSession() == movieSession) {
                return movieSessionHalls.get(i).getHall();
            }
        }
        return null;
    }

    private String Date;
    private String Time;
    private int NumberOfTickets;
}
