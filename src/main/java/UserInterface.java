import java.util.Scanner;

public class UserInterface
{
    private Scanner sc;
    private Controller controller;
    private int menuInput;
    private String superheroSearch;
    private int removeNumber;
    public UserInterface () {
        sc = new Scanner(System.in);
        controller = new Controller();

    }

    public void startProgram()
    {
        while(menuInput != 9)
        {
            System.out.println("---------------------------------------------------");
            System.out.println("Velkommen til din SuperHelte database!");
            System.out.println("Menu - Vælg en valgmulighed");
            System.out.println("""
                    1. Opret en Superhelt
                    2. Se liste over superhelte
                    3. Søg efter superhelt
                    4. Rediger superhelt
                    5. Fjern superhelt fra database
                    9. Afslut
                    """);

            try {
                menuInput = Integer.parseInt(sc.nextLine());

                switch (menuInput) {
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

                    case 9:
                        System.out.print("Du har nu afsluttet. Farvel");
                        System.exit(0);
                }
            }
            catch(Exception e)
            {
                System.out.println("Du har fået indtastet en forkert variabel. Prøv venligst igen.");
            }
        }
    }

    public void caseCreateSuperhero()
    {
        boolean tryAgain = true;
        while (tryAgain) {
            try {
                System.out.println("Hvad skal din superhelts heltenavn være?");
                String heroName = sc.nextLine();

                System.out.println("Hvad er din superhelts rigtige navn?");
                String realName = sc.nextLine();

                System.out.println("Hvad er din superhelts superkraft?");
                String superpower = sc.nextLine();

                System.out.println("Hvad er din superhelts alder?");
                int age = Integer.parseInt(sc.nextLine());

                System.out.println("Hvor stærk er din superhelt?");
                double strength = Integer.parseInt(sc.nextLine());

                controller.addSuperhero(heroName, realName, superpower, age, strength);
                tryAgain = false;
            } catch (Exception e) {
                System.out.println("Du fik indtastet en forkert variabel. Start venligst forfra.\n");
            }
        }
    }

    public void caseListSuperheroes()
    {
        System.out.println("Liste over dine superhelte:\n");
        listSuperHeroes();
    }

    //TODO Hvilken search vil i bruge?
    public void caseSearchSuperhero() {
        System.out.println("Skriv dit søgekriterie for din superhelt: ");
        superheroSearch = sc.nextLine();
        controller.findSuperhero(superheroSearch);
        Superhero værdi = controller.findSuperhero(superheroSearch);
        System.out.println("Din superhelt er fundet i databasen: ");
        if (værdi == null) {
            System.out.println("Superhelten findes ikke i databasen");
            }
        /*//ArrayList<Superhero> superheroes = controller.findSuperhero(superheroSearch);
        for (ArrayList<Superhero> superheroes = controller.findSuperhero(superheroSearch)) {
            if (superheroes.size() == 0) {
                System.out.println("Din søgning gav intet resultat");
            } else {

                for (Superhero superhero : superheroes) {
                    System.out.println(superhero);
                    System.out.println();
                }
            }*/
        }

    //TODO Indsæt EditSuperhero metode
    public void caseEditSuperhero()
    {
        System.out.println("Skriv superheltenavnet for den superhelt, som du vil redigere: ");
        superheroSearch = sc.nextLine();
        controller.editSuperhero();
    }

    /*public void caseRemoveSuperhero() {
        System.out.println("Fjern en superhelt fra din database: \n");
        controller.getSuperheroes();
        System.out.print("Skriv nummeret på den superhelt, som du gerne vil fjerne fra databasen: ");
        removeNumber = Integer.parseInt(sc.nextLine());
    }*/
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
        }
        return sc.nextInt();
    }

    public double readDouble() {
        while (!sc.hasNextDouble()) {  //Loop
            String text = sc.nextLine();
            System.out.println(text + " er ikke et tal. Prøv igen.\n");
        }
        return sc.nextDouble();
    }

    // Metoder
    public void listSuperHeroes()
    {
        int i = 1;

        for (Superhero superhero : controller.getSuperheroes())
        {
            System.out.println(i++ + ": \n" + superhero);
        }
    }
}
