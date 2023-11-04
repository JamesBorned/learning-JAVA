import java.util.ArrayList;
public class Place {
    public Place(int row, int number, int price){
        this.Row = row;
        this.Number = number;
        this.Price = price;
    }

    private ArrayList<ArrayList<String>> freePlaces = new ArrayList<>();

    public ArrayList<ArrayList<String>> initFreePlaces() {
        for (int i = 0; i < freePlaces.size(); ++i) {
            for (int j = 0; j < freePlaces.get(i).size(); ++j) {
                freePlaces.get(i).set(j, "free");
            }
        }
        return freePlaces;
    }

    public String isOccupied() {
        if (freePlaces.get(this.Row).get(this.Number).equals("free")) {
            return "    ";
        }
        else {
            return "OCCUP";
        }
    }

    public boolean isChoosed() {
        if (this.isOccupied() == "    "){
            freePlaces.get(this.Row).set(this.Number, "occupied");
            return true;
        }
        else {
            return false;
        }
    }
    public int getRow(){
        return Row;
    }

    public void setRow(int row){
        this.Row = row;
    }

    public int getPrice(){
        return Price;
    }

    public void setPrice(int price){
        this.Price = price;
    }

    public int getNumber(){
        return Number;
    }

    public void setNumber(int number){
        this.Number = number;
    }

    private int Row;
    private int Number;
    private int Price;
}
