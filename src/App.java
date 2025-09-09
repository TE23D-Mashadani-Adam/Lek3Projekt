import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int[] passagerare = new int[20];

        int pris = 299;
        int vinst = 0;
        boolean avsluta = false;

        String[] meny = { "Lägg till en passagerare", "Skriv ut lediga platser", "Beräkna vinst",
                "Avsluta programmet" };

        while (true) {
            for (int i = 0; i < meny.length; i++) {
                System.out.println(i + 1 + ". " + meny[i]);
            }
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
                    vinst = LäggTill(passagerare, perNummer, vinst, pris);
                    break;

                case 2:
                    SkrivUt(passagerare);
                    break;

                case 3:
                    System.out.println(BeräknaVinst(vinst));
                    break;
                default:
                    avsluta = true;
                    break;
            }
            if (avsluta) {
                System.out.println("Program avslutad!");
                break;
            }
        }

    }

    static int LäggTill(int[] passagerare, int perNummer, int vinst, int pris) {
        for (int i = 0; i < passagerare.length; i++) {
            if (passagerare[i] == 0) {
                passagerare[i] = perNummer;
                vinst += pris;
                break;
            }
            if (i == passagerare.length - 1) {
                System.out.println("Inga platser kvar");
            }
        }
        return vinst;
    }

    static void SkrivUt(int[] passagerare) {
        for (int i = 0; i < passagerare.length; i++) {
            System.out.println(i + 1 + ". " + passagerare[i]);
        }
    }

    static int BeräknaVinst(int vinst) {
        return vinst;
    }
}
