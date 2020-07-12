package Recomendation;

public class Rating implements Comparable<Rating>{

    private String item;
    private double value;

    public Rating(String item, double value) {
        this.item = item;
        this.value = value;
    }

    public String getItem() {
        return item;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "item='" + item + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    @Override
    public int compareTo(Rating that){
        if(this.item.equals(that.item)) return 1;
        if(this.item.equals(that.value)) return -1;
        else return 0;
    }
}
