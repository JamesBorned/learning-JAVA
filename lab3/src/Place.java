import java.util.ArrayList;
public class Place {
    public Place(int row, int number, int price){
        this.Row = row;
        this.Number = number;
        this.Price = price;
    }

    private ArrayList<String> freePlaces = new ArrayList<>();

    public ArrayList<String> initFreePlaces(){
        for(int i = 0; i < freePlaces.size(); ++i){
            initFreePlaces().set(i, "free");
        }
        return freePlaces;
    }

    public String isOccuiped() {
        for (int i = 0; i < freePlaces.size(); ++i) {
            if (freePlaces.get(this.Number).equals("free")) {
                return "    ";
            } else {
                return "OCCUP";
            }
        }
        return "    ";
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
