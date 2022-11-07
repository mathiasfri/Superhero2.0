import java.util.ArrayList;

public class Controller
{
    private Database database;
    private Filehandler filehandler;
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
        database.addSuperhero(heroName, realName, superpower, age, strength);
    }
    public Superhero findSuperhero(String superheroSearch)
    {
        return database.searchSuperHeroes(superheroSearch);
    }

    public void saveToFile() {
        filehandler.saveToFile(getSuperheroes());
    }
}
