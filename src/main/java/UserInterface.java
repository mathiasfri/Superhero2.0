import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class UserInterface {
    private Scanner sc;
    private Controller controller;
    private String superheroSearch;

    public UserInterface() {
        sc = new Scanner(System.in);
        controller = new Controller();
    }

    public void startProgram() {
        controller.loadFile();
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("---------------------------------------------------");
            System.out.println("Velkommen til din SuperHelte database!");
            System.out.println("Menu - Vælg en valgmulighed");
            System.out.println("""
                    1. Opret en Superhelt
                    2. Se liste over superhelte
                    3. Søg efter superhelt
                    4. Rediger superhelt
                    5. Fjern superhelt fra database
                    6. Sorter superhelt
                    7. Sorter med to kategorier
                    9. Afslut
                    """);

            try {
                switch (readInteger()) {
                    case 1:
                        caseCreateSuperhero();
                        break;
                    case 2:
                        caseListSuperheroes();
                        break;
                    case 3:
                        caseSearchSuperhero();
                        break;
                    case 4:
                        caseEditSuperhero();
                        break;
                    case 5:
                        caseRemoveSuperhero();
                        break;
                    case 6:
                        caseSortSuperheroes();
                        break;
                    case 7:
                        caseSortByPrimarySecondary();
                        break;
                    case 9:
                        controller.saveToFile();
                        System.out.print("Du har nu afsluttet. Farvel.");
                        isRunning = false;
                }
            } catch (Exception e) {
                System.out.println("Du har fået indtastet en forkert variabel. Prøv venligst igen.");
            }
        }
    }

    public void caseCreateSuperhero() {
        System.out.println("Hvad skal din superhelts heltenavn være?");
        String heroName = readString();

        System.out.println("Hvad er din superhelts rigtige navn?");
        String realName = readString();

        System.out.println("Hvad er din superhelts superkraft?");
        String superpower = readString();

        System.out.println("Hvad er din superhelts alder?");
        int age = readInteger();

        System.out.println("Hvor stærk er din superhelt?");
        double strength = readDouble();

        controller.addSuperhero(heroName, realName, superpower, age, strength);
    }

    public void caseListSuperheroes() {
        System.out.println("Liste over dine superhelte:\n");
        listSuperHeroes();
    }

    public void caseSearchSuperhero() {
        System.out.println("Skriv dit søgekriterie for din superhelt: ");
        superheroSearch = sc.nextLine();
        controller.findSuperhero(superheroSearch);
        Superhero værdi = controller.findSuperhero(superheroSearch);
        if(værdi != null) {
            System.out.println("Din superhelt er fundet i databasen: " + værdi);
        }
        if (værdi == null) {
            System.out.println("Superhelten findes ikke i databasen");
        }
    }

    public void caseEditSuperhero() {
        System.out.println("Skriv superheltenavnet for den superhelt, som du vil redigere: ");
        superheroSearch = sc.nextLine();
        editSuperhero();

    }
   /* public void caseRemoveSuperhero() { // Oprindelige kode for remove superhero.
        System.out.println("\tSøg efter superhelt du vil SLETTE: ");
        String userSearch = readString();


        for (int i = 0; i < controller.getSuperheroes().size(); i++) {
            Superhero s = controller.getSuperheroes().get(i);
            if (s.getHeroName().contains(userSearch)) {
                System.out.println(((i)+1) + ":\n" + s);
            }
        }
// Forstår ikke helt hvordan det her virker
        System.out.println("Skriv tallet for superhelten du vil fjerne");
        int userChoice = readInteger();
        controller.getSuperheroes().remove(userChoice -1);

    } */
    public void caseRemoveSuperhero() {
        System.out.println("\tSøg efter superhelt du vil SLETTE: ");
        String userChoice = readString();
        controller.caseRemoveSuperhero(userChoice);
        System.out.println("Skriv tallet for superhelten du vil fjerne");
        int userChoice1 = readInteger();
        controller.caseRemoveSuperhero1(userChoice1);


    }







    public void caseSortSuperheroes() {
        System.out.println("Hvilket kriterie vil du gerne sortere efter?");
        System.out.println("""
                1. Rigtige navn
                2. Superhelte navn
                3. Alder
                4. Superpower
                5. Styrke
                """);

        int sortChoice = readInteger();

        switch (sortChoice)
        {
            case 1:
                controller.sortByRealName();
                listSuperHeroes();
                break;

            case 2:
                controller.sortByHeroName();
                listSuperHeroes();
                break;

            case 3:
                controller.sortByAge();
                listSuperHeroes();
                break;

            case 4:
                controller.sortBySuperpowers();
                listSuperHeroes();
                break;

            case 5:
                controller.sortByStrength();
                listSuperHeroes();
                break;
        }
    }

    public void caseSortByPrimarySecondary() {
        System.out.println("Hvilket første kriterie vil du gerne sortere efter?");
        System.out.println("""
                1. Rigtige navn
                2. Superhelte navn
                3. Alder
                4. Superpower
                5. Styrke
                """);
        int sortChoice = readInteger();

        Comparator primary = null;
        switch (sortChoice) {
            case 1:
                primary = new RealNameComparator();
                break;
            case 2:
                primary = new HeroNameComparator();
                break;
            case 3:
                primary = new AgeComparator();
                break;
            case 4:
                primary = new SuperpowerComparator();
                break;

            case 5:
                primary = new StrengthComparator();
                break;
        }

        System.out.println("Hvilket andet kriterie vil du gerne sortere efter?");
        System.out.println("""
                1. Rigtige navn
                2. Superhelte navn
                3. Alder
                4. Superpower
                5. Styrke
                """);

        Comparator secondary = null;
        int sortChoice2 = readInteger();
        switch (sortChoice2) {
            case 1:
                secondary = new RealNameComparator();
                break;
            case 2:
                secondary = new HeroNameComparator();
                break;
            case 3:
                secondary = new AgeComparator();
                break;
            case 4:
                secondary = new SuperpowerComparator();
                break;
            case 5:
                secondary = new StrengthComparator();
                break;

        }
        Collections.sort(controller.getSuperheroes(), primary.thenComparing(secondary));
        listSuperHeroes();

    }

    // Read for scanner, to avoid errors
    public int readInteger() {
        while (!sc.hasNextInt()) {  //Loop
            String text = sc.nextLine();
            System.out.println(text + " er ikke et heltal. Prøv igen.\n");
            sc.next();
        }
        return sc.nextInt();
    }

    public String readString() {
        String input = sc.next();
        sc.nextLine();
        return input;
    }

    public double readDouble() {
        while (!sc.hasNextDouble()) {  //Loop
            String text = sc.nextLine();
            System.out.println(text + " er ikke et tal. Prøv igen.\n");
            sc.next();
        }
        return sc.nextDouble();
    }

    // Metoder
    public void listSuperHeroes() {


        for (Superhero superhero : controller.getSuperheroes()) {
            System.out.println(superhero);
        }
    }




    public void editSuperhero() {
        String superheroEdit = sc.nextLine();
        ArrayList<Superhero> array = new ArrayList<>();

        int i = 1;

        for (Superhero superhero : controller.getSuperheroes()) {
            if (superhero.getHeroName().contains(superheroEdit)) {
                array.add(superhero);
            } else {
                System.out.println("Der findes ingen superhelte i databasen med dette navn.\n");
            }
        }

        for (Superhero sa : array) {
            System.out.println(i++ + ": \n" + sa);
        }

        if (!array.isEmpty()) {
            System.out.println("Skriv nummeret på den superhelt du vil redigere: \n");
            String editNumber = Integer.toString(sc.nextInt());
            Superhero superHeroEdit = array.get(Integer.parseInt(editNumber) - 1);

            System.out.println("Redigerer følgende superhelt: \n\n" + superHeroEdit);
            System.out.println("Skriv ny information og tryk ENTER. Hvis du ikke vil redigere, tryk ENTER.");
            sc.nextLine();

            boolean tryAgain = true;

            while (tryAgain) {
                try {
                    System.out.print("Nyt superheltenavn: ");
                    String newName = sc.nextLine();
                    if (!newName.isEmpty()) {
                        superHeroEdit.setHeroName(newName);
                    }

                    System.out.print("Det nye rigtige navn på din superhelt: ");
                    String newRealName = sc.nextLine();
                    if (!newRealName.isEmpty()) {
                        superHeroEdit.setRealName(newRealName);
                    }

                    System.out.print("Ny superhelt superkraft: ");
                    String newSuperpower = sc.nextLine();
                    if (!newSuperpower.isEmpty()) {
                        superHeroEdit.setSuperpower(newSuperpower);
                    }

                    System.out.print("Nye alder på superhelt: ");
                    String newAge = sc.nextLine();
                    if (!newAge.isEmpty()) {
                        superHeroEdit.setAge(Integer.parseInt(newAge));
                    }

                    System.out.println("Nye styrke på din superhelt: ");
                    String newStrength = sc.nextLine();
                    if (!newStrength.isEmpty()) {
                        superHeroEdit.setStrength(Double.parseDouble(newStrength));
                    }

                    tryAgain = false;
                    System.out.println("Redigering gennemført.\n");
                } catch (Exception e) {
                    System.out.println("Du fik indtastet en forkert variabel. Start venligst forfra.\n");
                }

            }
        }

    }
}
