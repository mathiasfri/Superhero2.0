import com.beust.ah.A;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FilehandlerTest {
    Filehandler filehandler;
    File file;

    @BeforeEach
    void setUp(){
        filehandler = new Filehandler();
        file = filehandler.getFile();
    }

    @Test
    void loadFile() {
        ArrayList<Superhero> superheroes = filehandler.loadFile();

        assertNotEquals(4, superheroes.size());
        //Antallet er hvorvidt hvor mange superhelte som er på listen, hvis det ikke er korrekt antal, så viil den slå fejl
    }

    @Test
    void saveFile(){
        long t1 = file.lastModified();
        ArrayList<Superhero> files = new ArrayList<>();
        filehandler.saveToFile(files);
        long t2 = file.lastModified();
        assertNotEquals(t1,t2);
    }

    //Anden metode til SaveFile, ved brug af lastModified()
     /*@Test
    void saveFile(){
        long t1 = file.lastModified();
        for (int i = 0; i < 1000; i++){
            helte.getSuperheroes();
            helte.searchSuperHeroes("heroName");
        }
        long t2 = file.lastModified();
        assertEquals(t1,t2);
    }*/

}