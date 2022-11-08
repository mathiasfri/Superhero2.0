import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    Database helte;

    @BeforeEach
    void addSuperhero() {
        helte = new Database();
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
}