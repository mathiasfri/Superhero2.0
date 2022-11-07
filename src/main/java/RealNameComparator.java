import java.util.Comparator;

public class RealNameComparator implements Comparator<Superhero>
{
    public int compare(Superhero s1, Superhero s2)
    {
        return s1.getRealName().compareTo(s2.getHeroName());
    }
}
