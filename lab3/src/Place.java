import java.util.ArrayList;
public class Place {
    public Place(int row, int number, int price, String occupancy){
        this.Row = row;
        this.Number = number;
        this.Price = price;
        this.Occupancy = occupancy;
    }

//    private ArrayList<ArrayList<String>> freePlaces = new ArrayList<>();
//
//    public ArrayList<ArrayList<String>> getFreePlaces(){
//        return freePlaces;
//    }
//    public void initFreePlaces() {
//        for (int i = 0; i < this.getFreePlaces().size(); ++i) {
//            for (int j = 0; j < this.getFreePlaces().get(i).size(); ++j) {
//                this.getFreePlaces().get(i).add("free");
//            }
//        }
//    }

    public String isOccupied() {
        if (this.getOccupancy().equals("free")) {
            return "     ";
        }
        else if (this.getOccupancy().equals("occupied")){
            return "OCCUP";
        }
        return "";
    }

    public boolean choosePlace() {
        if (this.isOccupied() == "     "){
            this.setOccupancy("occupied");
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

    public String getOccupancy(){
        return Occupancy;
    }

    public void setOccupancy(String occupancy){
        this.Occupancy = occupancy;
    }

    private int Row;
    private int Number;
    private int Price;
    private String Occupancy;
}
