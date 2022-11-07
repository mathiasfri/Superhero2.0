import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

public class Filehandler {
    private File file = new File("Superhero.csv");

    public void saveToFile(ArrayList<Superhero> superheroes) {
        try{
            PrintStream printStream = new PrintStream(file);
            for (Superhero superhero: superheroes){
                printStream.println(superhero.getHeroName() +',' +
                        superhero.getRealName() + ',' +
                        superhero.getSuperpower() + ',' +
                        superhero.getAge() + ',' +
                        superhero.getStrength());
            }
            printStream.close();
        }catch(FileNotFoundException e){
        }

    }
}
