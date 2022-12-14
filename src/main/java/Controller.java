import javax.xml.crypto.Data;
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
    public void caseRemoveSuperhero(String userChoice) {
        dataEdited = true;
        database.caseRemoveSuperhero(userChoice);
    }
    public void caseRemoveSuperhero1(int userChoice) {
        dataEdited = true;
        database.caseRemoveSuperHero1(userChoice);
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
       database.sortByRealName();
    }

    public void sortByHeroName() {
        database.sortByHeroName();
    }

    public void sortByAge() {
        database.sortByAge();

    }

    public void sortBySuperpowers() {
        database.sortBySuperpowers();
    }

    public void sortByStrength() {
        database.sortByStrength();
    }


}
