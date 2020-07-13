package Recomendation;
//import edu.duke.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
//import org.apache.commons.csv.*;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.nio.file.Paths;


public class FirstRatings {
    public ArrayList<Movie> loadMovies(String fileName)
    {
        String path = Paths.get("").toAbsolutePath().toString();
        String route = "\\src\\data\\";
        boolean hayComilla = false;

        ArrayList<Movie> res = new ArrayList<Movie>();
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(path + route + fileName));
            String row;

            while ((row = csvReader.readLine()) != null) {
                String data[];
                ArrayList<String> arr = new ArrayList<String>();

                data = row.split(",");
                String aux = "";

                if (!data[0].equals("id")) {
                    for (String s  : data){

                        if(!hayComilla && !s.contains("\""))
                        {
                            arr.add(s);
                        }
                        if(s.startsWith("\"") || hayComilla)
                        {
                            hayComilla = true;
                            aux = aux + s;

                            if(s.endsWith("\"")) {
                                //aux = aux + s;
                                hayComilla = false;
                                arr.add(aux);
                            }
                        }
                    }

                    String id = arr.get(0);
                    String title = arr.get(1);
                    String year = arr.get(2);
                    String country = arr.get(3);
                    String genres = arr.get(4);
                    String director = arr.get(5);
                    String minutes = arr.get(6);
                    String poster = arr.get(7);

                    Movie current = new Movie(id, title, year, genres, director, country, minutes, poster);

                    res.add(current);
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return res;
    }

    public void testLoadMovies(){
        ArrayList<Movie> movies = loadMovies("ratedmoviesfull.csv");
    }

    public void testHowManyComedies()
    {
        ArrayList<Movie> movies = loadMovies("ratedmoviesfull.csv");
        int counter = 0;

        for(Movie current : movies)
        {
            if(current.getGenres().contains("Comedy"))
                counter++;
        }
        System.out.println("There are " + counter + " Comedies");
    }

    public void testHowMoviesHasMoreThan150Minutes()
    {
        ArrayList<Movie> movies = loadMovies("ratedmoviesfull.csv");
        int counter = 0;

        for(Movie current : movies)
        {
            if(current.getMinutes() > 150)
                counter++;
        }

        System.out.println("There are " + counter + " movies where has greater than 150 minutes");
    }

    public HashMap<String, Integer> maximunMoviesByDirector()
    {
        ArrayList<Movie> movies = loadMovies("ratedmoviesfull.csv");
        HashMap<String, Integer> directors = new HashMap<String, Integer>();

        for(Movie current : movies)
        {
            String director = current.getDirector();
            int cantidad = 1;

            if(!directors.containsKey(director))
            {
                directors.put(director, cantidad);
            }
            else{
                cantidad = directors.get(director);
                cantidad++;
                directors.put(director, cantidad);
            }
        }
        System.out.println("Maximun movies by director " + directors.toString());

        //director with max cantity of movies
        //String director = directors.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
        String director = Collections.max(directors.entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue()).getKey();
        System.out.println("Director with max movies " + director + " : " + directors.get(director) + " movies");

        return directors;
    }

    public ArrayList<Rater> loadRaters(String fileName)
    {
        String path = Paths.get("").toAbsolutePath().toString();
        String route = "\\src\\data\\";
        String actual = "";

        ArrayList<Rater> res = new ArrayList<Rater>();
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(path + route + fileName));
            String row;

            while ((row = csvReader.readLine()) != null) {
                String data[];
                ArrayList<String> arr = new ArrayList<String>();

                data = row.split(",");
                String aux = "";

                if (!data[0].equals("rater_id")) {
                    String current = data[0];

                    for (String s : data) {
                        if(!arr.contains(s))
                            arr.add(s);
                    }
                }
                if (!arr.isEmpty()) {
                    if(!actual.equals(arr.get(0)))
                    {
                        actual = arr.get(0);
                        String raterId = arr.get(0);
                        String item = arr.get(1);
                        double value = Double.parseDouble(arr.get(2));

                        Rater currentRater = new Rater(raterId);
                        currentRater.addRating(item, value);

                        res.add(currentRater);
                    }
                    else
                    {
                        String item = arr.get(1);
                        double value = Double.parseDouble(arr.get(2));

                        res.get(res.size() - 1).addRating(item, value);
                    }

                }
            }
            System.out.println(res);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return res;
    }

    public int maxRatingsByRater()
    {
        int res = 0;

        return res;
    }
}
