import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.manipulation.Ordering;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    Database helte;
    Controller controller;
    UserInterface ui;

    @BeforeEach
    void addSuperhero() {
        ui = new UserInterface();
        helte = new Database();
        controller = new Controller();

        helte.addSuperhero("Malou", "Super Malou", "Spiser meget", 1999, 193.943);
        helte.addSuperhero("Hund", "Super Hund", "Flyvende", 1756, 34.567);

    }


    @Test
    public void testFejlFindeSuper() {
        Superhero superhero = helte.searchSuperHeroes("Mango");

        assertNotEquals(helte.getSuperheroes().get(0), superhero);
    }

    @Test
    void searchSuperHeroes() {

        Superhero superhero = helte.searchSuperHeroes("Malou");

        assertEquals(helte.getSuperheroes().get(0), superhero);
    }
    @Test
    public void testAgeComparator() {
        helte.sortByAge();
        int expectedAge = 1756;
        assertEquals(expectedAge, helte.getSuperheroes().get(0).getAge());

    }
    @Test
    public void testHeroNameComparator() {
        helte.sortByHeroName();
        String expectedName = "Hund";
        assertEquals(expectedName, helte.getSuperheroes().get(0).getHeroName());
    }
    @Test
    public void testRealNameComparator() {
        helte.sortByRealName();
        String expectedRealName = "Super Hund";
        assertEquals(expectedRealName, helte.getSuperheroes().get(0).getRealName());
    }
    @Test
public void testSuperPowerComparator() {
        helte.sortBySuperpowers();
        String expecSuperPower = "Flyvende";
        assertEquals(expecSuperPower, helte.getSuperheroes().get(0).getSuperpower());
}
@Test
public void testStrengthComparator() {
        helte.sortByStrength();
        double expectedStrength = 34.567;
        assertEquals(expectedStrength, helte.getSuperheroes().get(0).getStrength());
}
}