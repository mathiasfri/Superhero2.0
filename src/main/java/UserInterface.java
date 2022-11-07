import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Scanner sc;
    private Controller controller;
    private int menuInput;
    private String superheroSearch;

    public UserInterface() {
        sc = new Scanner(System.in);
        controller = new Controller();

    }

    public void startProgram() {
        while (menuInput != 9) {
            System.out.println("---------------------------------------------------");
            System.out.println("Velkommen til din SuperHelte database!");
            System.out.println("Menu - Vælg en valgmulighed");
            System.out.println("""
                    1. Opret en Superhelt
                    2. Se liste over superhelte
                    3. Søg efter superhelt
                    4. Rediger superhelt
                    5. Fjern superhelt fra database
                    6. Gem Superhelt
                    9. Afslut
                    """);

            try {
                menuInput = Integer.parseInt(sc.nextLine());

                switch (menuInput) {
                    case 1: caseCreateSuperhero();
                        break;
                    case 2: caseListSuperheroes();
                        break;
                    case 3: caseSearchSuperhero();
                        break;
                    case 4: caseEditSuperhero();
                        break;
                    case 5: caseRemoveSuperhero();
                        break;
                    case 6: caseSaveSuperhero();
                        break;
                    case 9:
                        System.out.print("Du har nu afsluttet. Farvel");
                        System.exit(0);
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
        System.out.println("Din superhelt er fundet i databasen: ");
        if (værdi == null) {
            System.out.println("Superhelten findes ikke i databasen");
        }
    }

    public void caseEditSuperhero() {
        System.out.println("Skriv superheltenavnet for den superhelt, som du vil redigere: ");
        superheroSearch = sc.nextLine();
        editSuperhero();
    }

    public void caseRemoveSuperhero() {
        System.out.println("\tSøg efter superhelt du vil SLETTE: ");
        String søgeNavn = sc.nextLine();

        for (int i = 0; i < controller.getSuperheroes().size(); i++) {
            System.out.println(i + 1 + ":\n" + controller.getSuperheroes().get(i) + "\n");
        }

        if (søgeNavn != null) {
            System.out.println("\t Vi har fundet din superhelt: \n"
                    + søgeNavn);
        } else if (søgeNavn == null) {
            System.out.println("\tKunne ikke finde superhelten. \n");
        }

        System.out.println("\tVil du slette denne superhero? Indtast ja / nej.");
        String svar = sc.nextLine();
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
        while (!sc.hasNextLine()) {  //Loop
            String text = sc.nextLine();
            System.out.println(text + " er ikke et heltal. Prøv igen.\n");
            sc.next();
        }
        return sc.nextLine();
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
        int i = 1;

        for (Superhero superhero : controller.getSuperheroes()) {
            System.out.println(i++ + ": \n" + superhero);
        }
    }
    private void caseSaveSuperhero() {
        controller.saveToFile();
    }

    public void editSuperhero() {
        String superheroEdit = sc.nextLine();
        ArrayList<Superhero> sortedArray = new ArrayList<>();

        int i = 1;

        for (Superhero superhero : controller.getSuperheroes()) {
            if (superhero.getHeroName().contains(superheroEdit)) {
                sortedArray.add(superhero);
            } else {
                System.out.println("Der findes ingen superhelte i databasen med dette navn.\n");
            }
        }

        for (Superhero sa : sortedArray) {
            System.out.println(i++ + ": \n" + sa);
        }

        if (!sortedArray.isEmpty()) {
            System.out.println("Skriv nummeret på den superhelt du vil redigere: \n");
            String editNumber = Integer.toString(sc.nextInt());
            Superhero superHeroEdit = sortedArray.get(Integer.parseInt(editNumber) - 1);

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
