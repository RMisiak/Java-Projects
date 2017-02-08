/*
 * Name: MovieClient
 * Date: April 19, 2016
 * Version: v0.1
 * Author: Mr. R. Misiak
 * Description: Test client for Movie and Actor classes.
 */
package part3;

/**
 *
 * @author 1misiakrya
 */
public class MovieClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // ACTOR TESTING
        // TEST #1 - CREATING EMPTY ACTOR
        Actor k = new Actor();

        // INVALID ACTOR
        assert (k.getAge() == -1);
        assert (k.getFirstName().equals("Unknown"));
        assert (k.getLastName().equals("Unknown"));

        // INVALID FIRST
        k.setFirstName(null);
        assert (k.getFirstName().equals("Unknown"));

        // VALID FIRST NAME
        k.setFirstName("John");
        assert (k.getFirstName().equals("John"));

        // INVALID LAST
        k.setLastName(null);
        assert (k.getLastName().equals("Unknown"));

        // VALID LAST
        k.setLastName("Doe");
        assert (k.getLastName().equals("Doe"));

        // INVALID SEX
        k.setSex(2);
        assert (k.getSex().equals("Unknown"));

        // VALID SEX
        k.setSex(0);
        assert (k.getSex().equals("Male"));
        k.setSex(1);
        assert (k.getSex().equals("Female"));

        // INVALID AGE
        k.setAge(-2);
        assert (k.getAge() == -1);
        k.setAge(125);
        assert (k.getAge() == -1);

        // IS AN ADULT / VALID AGE
        k.setAge(19);
        assert (k.getAge() == 19);
        assert (k.isAnAdult());
        k.setAge(18);
        assert (k.getAge() == 18);
        assert (k.isAnAdult());
        k.setAge(17);
        assert (k.getAge() == 17);
        assert (!k.isAnAdult());

        // ACTOR.equals based on ID
        Actor a = new Actor(5);
        Actor b = new Actor(5);
        assert (a.equals(b));

        // Based on first & last names & age
        a = new Actor("John", "Doe", 19, 0);
        b = a;
        assert (a.equals(b));

        // Two different actors
        b = new Actor();
        assert (!a.equals(b));

        // MOVIE TESTING
        // CREATING MOVIE
        Movie m = new Movie();

        // INVALID MOVIE
        assert (m.getTitle().equals("Unknown"));
        assert (m.getRating() == -1);
        assert (m.getYearMade() == -1);
        assert (m.getLength() == -1);

        // INVALID TITLE
        m.setTitle(null);
        assert (m.getTitle().equals("Unknown"));

        // VALID TITLE
        m.setTitle("J");
        assert (m.getTitle().equals("J"));

        // INVALID YEAR MADE
        m.setYearMade(-2);
        assert (m.getYearMade() == -1);
        m.setYearMade(2017);
        assert (m.getYearMade() == -1);

        // VALID YEAR MADE
        m.setYearMade(1994);
        assert (m.getYearMade() == 1994);

        // INVALID RATING
        m.setRating(-2);
        assert (m.getRating() == -1);
        m.setRating(11);
        assert (m.getRating() == -1);

        // VALID RATING
        m.setRating(5);
        assert (m.getRating() == 5);

        // INVALID LENGTH
        m.setLength(-10);
        assert (m.getLength() == -1);
        m.setLength(201);
        assert (m.getLength() == -1);

        // VALID LENGTH
        m.setLength(90);
        assert (m.getLength() == 90);

        // INVALID GENRE
        m.setGenre(7);
        assert (m.getGenre().equals("None"));
        m.setGenre(-1);
        assert (m.getGenre().equals("None"));

        // VALID GENRE
        m.setGenre(3);
        assert (m.getGenre().equals("Thriller"));

        // ADD ACTOR
        // VALID ADDITION
        m = new Movie();
        a = new Actor("John", "Doe", 17, 0);
        assert (a.isValid());
        assert (m.actorList.isEmpty());
        m.add(a);
        assert (m.actorList.size() == 1);
        assert (m.actorList.contains(a));

        // ADDING AN EXISTING ACTOR
        b = a;
        m.add(b);
        assert (m.actorList.size() == 1);

        // INVALID ACTOR - FIRST NAME
        b = new Actor("", "Doe", 17, 0);
        assert (!b.isValid());
        m.add(b);
        assert (m.actorList.size() == 1);
        assert (!m.actorList.contains(b));

        // INVALID ACTOR - LAST NAME
        Actor c = new Actor("John", "", 19, 0);
        assert (!c.isValid());
        m.add(c);
        assert (m.actorList.size() == 1);
        assert (!m.actorList.contains(c));

        // INVALID ACTOR - ID
        Actor d = new Actor(-2);
        assert (!d.isValid());
        m.add(d);
        assert (m.actorList.size() == 1);
        assert (!m.actorList.contains(d));

        // ACTOR.equals based on ID
        a = new Actor(5);
        b = new Actor(5);
        assert (a.equals(b));

        // !ACTOR.equals based on names and age
        a = new Actor("Jane", "Doe", 17, 0);
        b = new Actor("Jane", "Doe", 17, 0);
        assert (!a.equals(b));
        
        // ACTOR.equals based on names and age
        b = a;
        assert (a.equals(b));

        // MOVIE.equals based on ID
        Movie n = new Movie(5);
        Movie o = new Movie(5);
        assert (n.equals(o));

        // MOVIE.equals based on everything
        n = new Movie("Runaways", 1998, 9, 120, 1);
        o = n;
        assert (n.equals(o));

        // Two different movies
        o = new Movie();
        assert (!n.equals(o));

        // GET ACTOR
        a = new Actor(15);
        m.add(a);
        System.out.println("");
        System.out.println(m.get(15));

        // REMOVE ACTOR
        System.out.println("");
        Actor aa = new Actor("John", "Doe", 17, 0);
        m.add(aa);
        assert (m.actorList.contains(aa));
        assert (m.actorList.size() == 3);
        System.out.println(m.get("John", "Doe"));
        m.remove(aa);
        assert (m.actorList.size() == 2);
        assert (!m.actorList.contains(aa));

    }
}
