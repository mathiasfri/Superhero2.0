import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Filehandler
{
    private File file = new File("Superhero.csv");

    public void saveToFile(ArrayList<Superhero> superheroes)
    {
        try
        {
            PrintStream printStream = new PrintStream(file);
            for (Superhero superhero : superheroes)
            {
                printStream.println(superhero.getHeroName() + ',' +
                        superhero.getRealName() + ',' +
                        superhero.getSuperpower() + ',' +
                        superhero.getAge() + ',' +
                        superhero.getStrength());
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Superhero> loadFile()
    {
        ArrayList<Superhero> loadHeroFile = new ArrayList<>();
        try
        {
            Scanner input = new Scanner(file);
            while (input.hasNext())
            {
                String line = input.nextLine();
                String[] attributes = line.split(",");
                Superhero superhero = new Superhero(attributes[0],
                        attributes[1],
                        attributes[2],
                        Integer.parseInt(attributes[3]),
                        Double.parseDouble(attributes[4]));

                loadHeroFile.add(superhero);
            }
            input.close();
            return loadHeroFile;

        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }

    public File getFile()
    {
        return file;
    }
}