package Recomendation;

import java.util.ArrayList;

public class Rater {
    private String myID;
    private ArrayList<Rating> myRatings = new ArrayList<Rating>();

    public Rater(String myID) {
        this.myID = myID;
    }

    public void addRating(String item, double rating)
    {
        Rating r = new Rating(item, rating);
        myRatings.add(r);
    }

    public String getId()
    {
        return myID;
    }

    public double getRating(String item)
    {
        for (Rating current : myRatings) {
            if(current.getItem() == item)
            {
                return current.getValue();
            }
        }

        return -1;
    }

    public int numRatings()
    {
        return myRatings.size();
    }

    public ArrayList<String> getItemsRated()
    {
        ArrayList<String> res = new ArrayList<String>();
        for (Rating current : myRatings) {

            res.add(current.toString());
        }
        return res;
    }

    public String toString()
    {
        return    "RaterID: " + myID
                + " Ratings : " + myRatings.size()
                + " MyRatings : " + myRatings + "\n";
    }
}
