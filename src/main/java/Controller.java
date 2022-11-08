import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Controller {
    private Database database;
    private Filehandler filehandler;
    private boolean dataEdited = false;


    public Controller() {
        filehandler = new Filehandler();
        database = new Database();

    }


    public ArrayList<Superhero> getSuperheroes() {
        return database.getSuperheroes();
    }

    public void addSuperhero(String heroName, String realName, String superpower, int age, double strength) {
        dataEdited = true;
        database.addSuperhero(heroName, realName, superpower, age, strength);
    }

    public Superhero findSuperhero(String superheroSearch) {
        return database.searchSuperHeroes(superheroSearch);
    }

    public void saveToFile() {
        if(dataEdited){
            filehandler.saveToFile(getSuperheroes());
        }
    }

    public void loadFile() {
        database.loadFile(filehandler.loadFile());
    }

    public void sortByRealName() {
        Collections.sort(getSuperheroes(), new RealNameComparator());
    }

    public void sortByHeroName() {
        Collections.sort(getSuperheroes(), new HeroNameComparator());
    }

    public void sortByAge() {
        Collections.sort(getSuperheroes(), new AgeComparator());

    }

    public void sortBySuperpowers() {
        Collections.sort(getSuperheroes(), new SuperpowerComparator());
    }

    public void sortByStrength() {
        Collections.sort(getSuperheroes(), new StrengthComparator());
    }


}
