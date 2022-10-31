import java.util.ArrayList;

public class Database
{
    private ArrayList<Superhero> superheroes = new ArrayList<>();

    public void addSuperhero(String heroName, String realName, String superpower, int age)
    {
        superheroes.add(new Superhero(heroName, realName, superpower, age));
    }

    public ArrayList<Superhero> getSuperheroes()
    {
        return superheroes;
    }
}
