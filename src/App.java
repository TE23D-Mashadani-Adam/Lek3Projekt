import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int[] passagerare = new int[20];
        int pris = 299;

        String[] meny = { "Lägg till en passagerare", "Skriv ut lediga platser", "Beräkna vinst",
                "Avsluta programmet" };

        while (true) {
            for (int i = 0; i < meny.length; i++) {
                System.out.println(i + 1 + ". " + meny[i]);
            }
            scanner.nextLine();
            int val = 0;

            while (true) {
                try {
                    val = scanner.nextInt();
                    break;
                } catch (InputMismatchException a) {
                    System.out.println("Välj snälla mellan 1-4");
                    scanner.nextLine();
                }
            }

            switch (val) {
                case 1:
                    System.out.println("Skriv personnummer (ååååmmdd):");
                    int perNummer = 0;
                    while (true) {
                        try {
                            perNummer = scanner.nextInt();
                            if (String.valueOf(perNummer).length() == 8) {
                                break;
                            } else {
                                System.out.println("Observera att numret ska innehålla 8 nummer");
                            }
                        } catch (InputMismatchException a) {
                            System.out.println("Skriv rätt personnummer");
                            scanner.nextLine();
                        }
                    }
                    LäggTill(passagerare, perNummer);
                    break;

                default:
                    break;
            }
        }

    }

    static void LäggTill(int[] passagerare, int perNummer) {
        for (int i = 0; i < passagerare.length; i++) {
            if (passagerare[i] == 0) {
                passagerare[i] = perNummer;
                break;
            }
            if (i == passagerare.length - 1) {
                System.out.println("Inga platser kvar");
            }
        }
    }

    static void SkrivUt(int[] passagerare) {
        for (int i = 0; i < passagerare.length; i++) {
            System.out.println(i + 1 + ". " + passagerare[i]);
        }
    }
}
