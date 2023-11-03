public class Session {
    public Session(String date, String time, int numberOfTickets){
        this.Date = date;
        this.Time = time;
        this.NumberOfTickets = numberOfTickets;
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

    private String Date;
    private String Time;
    private int NumberOfTickets;
}
