import java.util.ArrayList;

public class Controller
{
    private Database database;
    public Controller()
    {
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


}
