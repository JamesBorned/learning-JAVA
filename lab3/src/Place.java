public class Place {
    public Place(int row, int number){
        this.Row = row;
        this.Number = number;
    }
    public int getRow(){
        return Row;
    }

    public void setRow(int row){
        this.Row = row;
    }

    public int getNumber(){
        return Number;
    }

    public void setNumber(int number){
        this.Number = number;
    }

    private int Row;
    private int Number;
}
