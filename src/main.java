import Recomendation.FirstRatings;
import Recomendation.Movie;

import java.util.ArrayList;

class main {
    public static void main(String[] args) {
        System.out.println("hello!");

        FirstRatings f = new FirstRatings();
        ArrayList<Movie> movies = f.loadMovies("ratedmoviesfull.csv");
        System.out.println("There are " + movies.size() + "Movies");

        f.testHowManyComedies();
        f.testHowMoviesHasMoreThan150Minutes();
        f.maximunMoviesByDirector();
    }
}
