/*
 * Name: Movie
 * Date: April 19, 2016
 * Version: v0.1
 * Author: Mr. R. Misiak
 * Description: Creates a Movie object that has-an Actor.
 */
package part3;

import java.util.ArrayList;

public class Movie {

    // VARIABLE DECLARATIONS
    private static final int ACTION_GENRE = 1;
    private static final int COMEDY_GENRE = 2;
    private static final int THRILLER_GENRE = 3;
    private static final int HORROR_GENRE = 4;
    private static final int ROMANCE_GENRE = 5;
    private static final int DRAMA_GENRE = 6;

    private String title;
    private int yearMade;
    private double rating;
    private int length;
    public ArrayList<Actor> actorList = new ArrayList();
    private int id;
    private static int lastID = 0;
    private int genre;

    // EMPTY CONSTRUCTOR
    public Movie() {
        this("Unknown", -1, -1, -1, -1);
    }

    // PRIMARY KEY CONSTRUCTOR
    public Movie(int id) {
        this();
        this.id = id;
    }

    // SECONDARY KEYS CONSTRUCTOR
    public Movie(String title, int yearMade, double rating, int length, int genre) {
        this.title = title;
        this.yearMade = yearMade;
        this.rating = rating;
        this.length = length;
        this.genre = genre;
        if (this.id < 1) {
            this.id = ++lastID;
        }
    }

    // GETTER AND SETTER FOR GENRE
    public String getGenre() {
        if (this.genre == ACTION_GENRE) {
            return "Action";
        } else if (this.genre == COMEDY_GENRE) {
            return "Comedy";
        } else if (this.genre == THRILLER_GENRE) {
            return "Thriller";
        } else if (this.genre == HORROR_GENRE) {
            return "Horror";
        } else if (this.genre == ROMANCE_GENRE) {
            return "Romance";
        } else if (this.genre == DRAMA_GENRE) {
            return "Drama";
        } else {
            return "None";
        }
    }

    public void setGenre(int genre) {
        if (genre <= 6 && genre >= 0) {
            this.genre = genre;
        } else {
            this.genre = -1;
        }
    }

    // GETTER / SETTER FOR TITLE
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null) {
            this.title = "Unknown";
        } else {
            this.title = title;
        }
    }

    // GETTER / SETTER FOR YEAR MADE
    public int getYearMade() {
        return yearMade;
    }

    public void setYearMade(int yearMade) {
        if (yearMade < 1940 || yearMade > 2016) {
            this.yearMade = -1;
        } else {
            this.yearMade = yearMade;
        }
    }

    // GETTER / SETTER FOR RATING
    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        if (rating < 0 || rating > 10) {
            System.out.println("ERROR - Invalid Rating");
        } else {
            this.rating = rating;
        }
    }

    // GETTER / SETTER FOR ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0) {
            System.out.println("ERROR - Invalid Entry");
        } else {
            this.id = id;
        }
    }

    // GETTER FOR IS A FEATURE FILM
    public boolean getIsAFeatureFilm() {
        return length >= 40;
    }

    // GETTER / SETTER FOR LENGTH
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        if (length > 200 || length < 0) {
            System.out.println("ERROR - Invalid Movie Length");
        } else {
            this.length = length;
        }
    }

    // ADDING ACTOR TO THE ARRAYLIST
    public void add(Actor actor) {
        if (actor == null) {
            System.out.println("ERROR - Can't Add NULL Actor");
        } else if (!actor.isValid()) {
            System.out.println("ERROR - Can't Add Invalid Actor");
        } else if (this.actorList.contains(actor)) {
            System.out.println("ERROR - The song is already in the list");
        } else {
            this.actorList.add(actor);
        }
    }

    // REMOVING ACTOR FROM ARRAYLIST
    
    public void remove(Actor actor){
        actorList.remove(actor);
    }

    // GETTING ACTOR FROM ARRAYLIST
    public Actor get(int id) {
        for (int i = 0; i < actorList.size(); i++) {
            if (actorList.get(i).getID() == id) {
                return actorList.get(i);
            }
        }
        return null;
    }

    public Actor get(String firstName, String lastName) {
        for (int i = 0; i < actorList.size(); i++) {
            if (actorList.get(i).getFirstName().equals(firstName) && actorList.get(i).getLastName().equals(lastName)) {
                return actorList.get(i);
            }
        }
        return null;
    }

    // CHECKS IF ONE MOVIE EQUALS ANOTHER
    //  @Override
    public boolean equals(Movie movie) {
        if (movie == null) {
            return false;
        }
        if (this.id != movie.getId()) {
            return false;
        }
        if (!movie.getTitle().equals(title)) {
            return false;
        }
        if (this.length != movie.getLength()) {
            return false;
        }
        return this.rating == movie.getRating();
    }

    // CHECKING MOVIE VALIDITY
    public boolean isValid() {
        if (title == null || title.length() < 1) {
            return false;
        } else if (id < 0) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Movie{" + "title=" + title + ", yearMade=" + yearMade + ", movieLength=" + rating + '}';
    }

        // 1. Actor can't be = null
    // 2. Actor must be VALID!
    //      a.isValid();
    //          - firstName, lastName, SIN, age
    // 3. No duplicates!
    //      .equals()! (+ contains)
}
