public class Hall {
    public Hall(int numberOfHall, int amountOfPlaces, int numberOfRows){
        this.NumberOfHall = numberOfHall;
        this.AmountOfPlaces = amountOfPlaces;
        this.NumberOfRows = numberOfRows;
        places = new Place[this.NumberOfRows][this.AmountOfPlaces/this.NumberOfRows];
    }

    private Place places[][];

    public Place[][] getPlaces(){
        return places;
    }

    public void setPlaces(Place[][] places){
        this.places = places;
    }

    public void initHall(int price){
        for(int i = 0; i < this.getNumberOfRows(); ++i){
            for(int j = 0; j < this.getAmountOfPlaces()/this.getNumberOfRows(); ++j){
                this.getPlaces()[i][j] = new Place(i, this.getAmountOfPlaces()/this.getNumberOfRows() - j, price,"free");
            }
        }
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

    public int getNumberOfRows(){
        return NumberOfRows;
    }

    public void setNumberOfRows(int numberOfRows){
        this.NumberOfRows = numberOfRows;
    }

    public String getPlace(int row, int col){
        Place place = this.getPlaces()[row][col];
        if (place.getOccupancy() == "free") {
            return " " + place.getNumber() + " " + "     ";
        }
        else {
            return " " + place.getNumber() + " " + "OCCUP";
        }
    }

    public void printHallPlan() {
        int offset = NumberOfRows;
        String split = "+--------";
        System.out.print("  ");
        for (int i = 0; i < this.getAmountOfPlaces()/this.getNumberOfRows(); ++i){
            System.out.printf(split);
        }
        System.out.print("+");
        System.out.print("\n");
        for (int row = this.getNumberOfRows(); row > 0; row--){
            offset = row;
            System.out.print(row);
            for (int col = 0; col < this.getAmountOfPlaces()/this.getNumberOfRows(); col++){
                System.out.print("|"+this.getPlace(row - offset,col));
            }
            System.out.println("|");
            System.out.print("  ");
            for (int i = 0; i < this.getAmountOfPlaces()/this.getNumberOfRows(); ++i){
                System.out.printf(split);
            }
            System.out.print("+");
            System.out.print("\n");
        }
        System.out.println();
    }

    public boolean areOccupied(){
        for (int i = 0; i < this.getPlaces().length; ++i){
            int row = i;
            for (int j = 0; j < this.getPlaces()[i].length; ++j){
                if (this.getPlaces()[row][j].isOccupied() == "    "){
                    return false;
                }
            }
        }
        return true;
    }
    private int NumberOfHall;
    private int AmountOfPlaces;
    private int NumberOfRows = 1;
}
