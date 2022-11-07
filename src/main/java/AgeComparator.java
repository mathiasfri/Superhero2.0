import java.util.Comparator;

public class AgeComparator implements Comparator<Superhero>
{
    public int compare(Superhero s1, Superhero s2)
    {
        return Integer.compare(s1.getAge(), s2.getAge());
    }
}
