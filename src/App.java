import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Passagerare[] passagerare = new Passagerare[20];

        int vuxenPris = 299;
        int barnPris = 149;
        int pris = 0;

        int vinst = 0;
        boolean avsluta = false;

        String[] meny = { "Lägg till en passagerare", "Skriv ut lediga platser", "Hitta en bokning", "Beräkna vinst",
                "Avboka en plats", "Avsluta programmet" };

        while (true) {
            ShowMenu(meny);
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
                    System.out.println("Ange ålder:");
                    int ålder = 0;
                    while (true) {
                        try {
                            ålder = scanner.nextInt();
                            if (ålder < 18) {
                                pris = barnPris;
                            } else {
                                pris = vuxenPris;
                            }
                            break;
                        } catch (InputMismatchException a) {
                            System.out.println("Skriv in siffror tack!");
                            scanner.nextLine();
                        }
                    }

                    System.out.println("Ange namn:");
                    String namn = scanner.next();

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

                    vinst = LäggTill(passagerare, perNummer, vinst, pris, namn, ålder);
                    break;
                case 2:
                    System.out.println("\n" + "Passagerare: ");
                    SkrivUt(passagerare);
                    System.out.println("");
                    break;

                case 3:
                    System.out.println("Skriv in din personnummer tack");
                    int bokadPerNummer = 0;
                    while (true) {
                        try {
                            bokadPerNummer = scanner.nextInt();
                            break;
                        } catch (InputMismatchException a) {
                            System.out.println("Försök igen");
                            scanner.nextLine();
                        }
                    }
                    HittaBokning(passagerare, bokadPerNummer);

                    break;

                case 4:
                    System.out.println(BeräknaVinst(vinst));
                    break;

                case 5:
                    System.out.println("Skriv in din personnummer tack");
                    int avbokningPerNummer = 0;
                    while (true) {
                        try {
                            avbokningPerNummer = scanner.nextInt();
                            break;
                        } catch (InputMismatchException a) {
                            System.out.println("Försök igen");
                            scanner.nextLine();
                        }
                    }
                    vinst = Avboka(passagerare, avbokningPerNummer, vinst);
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

    static void ShowMenu(String[] meny) {
        for (int i = 0; i < meny.length; i++) {
            System.out.println(i + 1 + ". " + meny[i]);
        }
    }

    static int LäggTill(Passagerare[] passagerare, int perNummer, int vinst, int pris, String namn, int ålder) {

        Passagerare nyPassagerare = new Passagerare();
        nyPassagerare.namn = namn;
        nyPassagerare.personnummer = perNummer;
        nyPassagerare.ålder = ålder;
        nyPassagerare.prisKlass = pris;

        for (int i = 0; i < passagerare.length; i++) {
            if (passagerare[i] == null) {
                passagerare[i] = nyPassagerare;
                vinst += nyPassagerare.prisKlass;
                break;
            }
            if (i == passagerare.length - 1) {
                System.out.println("Inga platser kvar");
            }
        }
        return vinst;
    }

    static void SkrivUt(Passagerare[] passagerare) {
        for (int i = 0; i < passagerare.length; i++) {
            if (passagerare[i] != null) {
                System.out.println(i + 1 + ". " + passagerare[i].namn + "Per. nummer: " + passagerare[i].personnummer);
            } else {
                System.out.println(i + 1 + ". Ledig plats");
            }
        }
    }

    static void HittaBokning(Passagerare[] passagerare, int perNummer) {
        for (int i = 0; i < passagerare.length; i++) {
            if (passagerare[i].personnummer == perNummer) {
                System.out.println("Du har sittplatsen: " + i + 1 + " på bussen");
                break;
            }
            if (i == passagerare.length - 1) {
                System.out.println("Du har ingen sittplats på bussen, du är alltid välkommen att boka hos oss!");
                break;
            }
        }

    }

    static int Avboka(Passagerare[] passagerare, int perNummer, int vinst) {
        for (int i = 0; i < passagerare.length; i++) {
            if (perNummer == passagerare[i].personnummer) {
                vinst -= passagerare[i].prisKlass;
                passagerare[i] = null;
                System.out.println("Avbokning genomförd! Välkommen åter");
                break;
            }
            if (i == passagerare.length - 1) {
                System.out.println("Du har ingen plats registrerat med denna personnummer på bussen");
            }
        }
        return vinst;
    }

    static int BeräknaVinst(int vinst) {
        return vinst;
    }
}
