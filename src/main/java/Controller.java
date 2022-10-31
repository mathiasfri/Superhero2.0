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

    public ArrayList<Superhero> findSuperhero(String supeheroSearch)
    {
        return database.searchSuperHeroes(supeheroSearch);
    }
}
