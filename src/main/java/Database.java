import java.util.ArrayList;

public class Database
{
    private ArrayList<Superhero> superheroes = new ArrayList<>();

    public void addSuperhero(String heroName, String realName, String superpower, int age)
    {
        superheroes.add(new Superhero(heroName, realName, superpower, age));
    }

    public ArrayList<Superhero> searchSuperHeroes(String superheroSearch)
    {
        ArrayList<Superhero> superhelte = new ArrayList<>();
        for (Superhero superhero : superheroes) {
            if(superhero.getHeroName().contains(superheroSearch)) {
                superhelte.add(superhero);

            } else if(superhero.getRealName().contains(superheroSearch)){
                superhelte.add(superhero);

            }  else if(superhero.getSuperpower().contains(superheroSearch)) {
                superhelte.add(superhero);

            } else if(Integer.toString(superhero.getAge()).contains(superheroSearch)) {
                superhelte.add(superhero);
            }
        }
        return superhelte;
    }


    public ArrayList<Superhero> getSuperheroes()
    {
        return superheroes;
    }
}
