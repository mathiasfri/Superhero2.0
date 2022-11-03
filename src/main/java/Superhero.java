public class Superhero
{
    private String heroName;
    private String realName;
    private String superpower;
    private int age;
    private double strength;

    public Superhero(String heroName, String realName, String superpower, int age, double strength)
    {
        this.heroName = heroName;
        this.realName = realName;
        this.superpower = superpower;
        this.age = age;
        this.strength = strength;
    }

    public String getHeroName(){
        return heroName;
    }

    public void setHeroName(String heroName){
        this.heroName = heroName;
    }

    public String getRealName(){
        return heroName;
    }

    public void setRealName(String realName){
        this.realName = realName;
    }

    public String getSuperpower(){
        return superpower;
    }

    public void setSuperpower(String superpower){
        this.superpower = superpower;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    @Override
    public String toString() {
        return
                "Superheltenavn: " + heroName + "\n" +
                        "Virkelige navn: " + realName + "\n" +
                        "Superkraft: " + superpower + "\n" +
                        "Alder: " + age + "\n";
    }
}
