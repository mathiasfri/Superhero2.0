import java.util.Comparator;

public class HeroNameComparator implements Comparator<Superhero>
{
    public int compare(Superhero s1, Superhero s2)
    {
        return s1.getHeroName().compareTo(s2.getHeroName());
    }
}
