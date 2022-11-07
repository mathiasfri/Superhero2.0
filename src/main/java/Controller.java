import java.util.ArrayList;
import java.util.Collections;

public class Controller
{
    private Database database;
    private Filehandler filehandler;
    private boolean dataEdited = false;
    public Controller()
    {
        filehandler = new Filehandler();
        database = new Database();
    }

    public ArrayList<Superhero> getSuperheroes()
    {
        return database.getSuperheroes();
    }

    public void addSuperhero(String heroName, String realName, String superpower, int age, double strength){
        dataEdited = true;
        database.addSuperhero(heroName, realName, superpower, age, strength);
    }
    public Superhero findSuperhero(String superheroSearch)
    {
        return database.searchSuperHeroes(superheroSearch);
    }

    public void saveToFile() {
        if (dataEdited)
        filehandler.saveToFile(getSuperheroes());
    }

    public void loadFile(){
        database.loadFile(filehandler.loadFile());
    }

    public void sortByRealName()
    {
        Collections.sort(filehandler.loadFile(), new RealNameComparator());
    }

    public void sortByHeroName()
    {
        Collections.sort(filehandler.loadFile(), new HeroNameComparator());
    }

    public void sortByAge()
    {
        Collections.sort(filehandler.loadFile(), new AgeComparator());
    }

    public void sortBySuperpowers()
    {
        Collections.sort(filehandler.loadFile(), new SuperpowerComparator());
    }

    public void sortByStrength()
    {
        Collections.sort(filehandler.loadFile(), new StrengthComparator());
    }
}
