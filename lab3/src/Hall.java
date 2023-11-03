public class Hall {
    public Hall(int numberOfHall, int amountOfPlaces){
        this.NumberOfHall = numberOfHall;
        this.AmountOfPlaces = amountOfPlaces;
    }
    public int getNumberOfHall(){
        return NumberOfHall;
    }

    public void setNumberOfHall(int numberOfHall){
        this.NumberOfHall = numberOfHall;
    }

    public int getAmountOfPlaces(){
        return AmountOfPlaces;
    }

    public void setAmountOfPlaces(int AmountOfPlaces){
        this.AmountOfPlaces = AmountOfPlaces;
    }

    private int NumberOfHall;
    private int AmountOfPlaces;
}
