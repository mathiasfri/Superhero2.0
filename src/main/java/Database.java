import java.util.ArrayList;
import java.util.Collections;

public class Database
{
    private ArrayList<Superhero> superheroes = new ArrayList<>();

    public void addSuperhero(String heroName, String realName, String superpower, int age, double strength)
    {
        superheroes.add(new Superhero(heroName, realName, superpower, age, strength));
    }

    public ArrayList<Superhero> getSuperheroes()
    {
        return superheroes;
    }

    public void loadFile(ArrayList<Superhero> superheroes)
    {
        this.superheroes = superheroes;
    }

    public Superhero searchSuperHeroes(String name)
    {
        for (int n = 0; n < superheroes.size(); n++)
        {
            if (superheroes.get(n).getHeroName().equals(name))
            {
                return superheroes.get(n);
            }
        }
        return null;
    }

    public void caseRemoveSuperhero(String userSearch)
    {
        for (int i = 0; i < superheroes.size(); i++)
        {
            Superhero s = superheroes.get(i);
            if (s.getHeroName().contains(userSearch))
            {
                System.out.println(((i) + 1) + ":\n" + s);
            }
        }
    }

    public void caseRemoveSuperHero1(int userSearch)
    {
        superheroes.remove(userSearch - 1);
    }

    public Database sortByRealName()
    {
        Collections.sort(getSuperheroes(), new RealNameComparator());
        return null;
    }

    public Database sortByHeroName()
    {
        Collections.sort(getSuperheroes(), new HeroNameComparator());
        return null;
    }

    public Database sortByAge()
    {
        Collections.sort(getSuperheroes(), new AgeComparator());
        return null;

    }

    public Database sortBySuperpowers()
    {
        Collections.sort(getSuperheroes(), new SuperpowerComparator());
        return null;
    }

    public Database sortByStrength()
    {
        Collections.sort(getSuperheroes(), new StrengthComparator());
        return null;
    }
}
