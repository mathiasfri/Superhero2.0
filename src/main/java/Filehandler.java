import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Filehandler {
    private File file = new File("Superhero.csv");

    public void saveToFile(ArrayList<Superhero> superheroes) {
        try {
            PrintStream printStream = new PrintStream(file);
            for (Superhero superhero : superheroes) {
                printStream.println(superhero.getHeroName() + ',' +
                        superhero.getRealName() + ',' +
                        superhero.getSuperpower() + ',' +
                        superhero.getAge() + ',' +
                        superhero.getStrength());
            }

        } catch(FileNotFoundException e) {

        }
    }

    public ArrayList<Superhero> loadFile() {
        ArrayList<Superhero> loadHeroFile = new ArrayList<>();
        try {
            Scanner input = new Scanner(file);
            while (input.hasNext()) {
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

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

//TODO Startprogram , automatisk loadfile / Overskriver vis lavet ændringer

// Duplicate funktion på et andet tidspunkt
    /*
    if (duplicate = true) {
        //inputAlreadyThere(superheroes);
        superheroes.size();
        System.out.println("This already exists in the database");

    } */

// Duplicate funktion
/*    public void inputAlreadyThere(ArrayList<Superhero> superheroes) {
        Scanner sc = new Scanner(System.in);

        for (Superhero superhero : superheroes) {
            String searchWord;
            searchWord = sc.nextLine();

            if (superhero.getHeroName().contains(searchWord) || superhero.getRealName().contains(searchWord)
                    || superhero.getSuperpower().contains(searchWord)) {
            }


        }

    }*/