public class Hall {
    public Hall(int numberOfHall, int amountOfPlaces, int numberOfRows){
        this.NumberOfHall = numberOfHall;
        this.AmountOfPlaces = amountOfPlaces;
        this.NumberOfRows = numberOfRows;
        places = new Place[this.NumberOfRows][this.AmountOfPlaces/this.NumberOfRows];
    }

    private Place places[][];

    public void initHall(int price){
        for(int i = 0; i < NumberOfRows; ++i){
            for(int j = 0; j < AmountOfPlaces/NumberOfRows; ++j){
                this.places[i][j] = new Place(i, AmountOfPlaces/NumberOfRows - j, price);
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
        Place place = this.places[row][col];
        return " "+place.getNumber()+'\n'+place.isOccupied();
    }

    public void printHallPlan() {
        System.out.println("  +----+----+----+----+----+----+----+----+");
        for (int row = NumberOfRows; row > -1; row--){
            System.out.print(row);
            for (int col = 0; col < AmountOfPlaces/NumberOfRows; col++){
                System.out.print("|"+getPlace(row,col));
            }
            System.out.println("|");
            System.out.println("  +----+----+----+----+----+----+----+----+");
        }
        System.out.println();
    }
    private int NumberOfHall;
    private int AmountOfPlaces;
    private int NumberOfRows = 1;
}
