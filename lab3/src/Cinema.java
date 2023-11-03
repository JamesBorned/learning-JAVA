import java.util.ArrayList;

public class Cinema {
    public Cinema(String nameOfCinema, String address, int numberOfHalls){
        this.NameOfCinema = nameOfCinema;
        this.Address = address;
        this.NumberOfHalls = numberOfHalls;
    }

    ArrayList<Hall> HallsOfCinema = new ArrayList<>();
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

    private String NameOfCinema;
    private String Address;
    private int NumberOfHalls;
}
