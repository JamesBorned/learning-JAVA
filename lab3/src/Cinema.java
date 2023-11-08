import java.util.ArrayList;

public class Cinema {
    public Cinema(String nameOfCinema, String address, int numberOfHalls){
        this.NameOfCinema = nameOfCinema;
        this.Address = address;
        this.NumberOfHalls = numberOfHalls;
        HallsOfCinema = new Hall[this.NumberOfHalls];
    }

    Hall[] HallsOfCinema;

    public String getNameOfCinema(){
        return NameOfCinema;
    }

    public void setNameOfCinema(String nameOfCinema){
        this.NameOfCinema = nameOfCinema;
    }

    public String getAddress(){
        return Address;
    }

    public void setAddress(String address){
        this.Address = address;
    }

    public int getNumberOfHalls(){
        return NumberOfHalls;
    }

    public void setNumberOfHalls(int numberOfHalls){
        this.NumberOfHalls = numberOfHalls;
    }

    public int getNumberOfPreferredCinema(){
        return NumberOfPreferredCinema;
    }

    public void setNumberOfPreferredCinema(int numberOfPreferredCinema){
        this.NumberOfPreferredCinema = numberOfPreferredCinema;
    }

    public int getNumberOfCinema(){
        return NumberOfCinema;
    }

    public void setNumberOfCinema(int numberOfCinema){
        this.NumberOfCinema = numberOfCinema;
    }

    private String NameOfCinema;
    private String Address;
    private int NumberOfHalls;
    private int NumberOfPreferredCinema;
    private int NumberOfCinema;
}
