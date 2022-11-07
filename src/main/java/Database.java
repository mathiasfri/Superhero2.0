import java.util.ArrayList;

public class Database
{
    ArrayList<Superhero> superheroes = new ArrayList<>();

    public void addSuperhero(String heroName, String realName, String superpower, int age, double strength)
    {
        superheroes.add(new Superhero(heroName, realName, superpower, age, strength));
    }

    public ArrayList<Superhero> getSuperheroes() {
        return superheroes;
    }

    public void loadFile(ArrayList<Superhero> superheroes){
        this.superheroes = superheroes;
    }

    public Superhero searchSuperHeroes(String name) {
        for (int n = 0; n < superheroes.size() + n++;) {
            if (superheroes.get(n).getHeroName().equals(name)) ;
            {
                return superheroes.get(n);
            }
        }
        return null;
    }





}
