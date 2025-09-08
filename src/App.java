import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int[] passagerare = new int[20];
        int pris = 299;

        String[] meny = { "Lägg till en passagerare", "Skriv ut lediga platser", "Beräkna vinsteb",
                "Avsluta programmet" };

        while (true) {
            for (int i = 0; i < meny.length; i++) {
                System.out.println(i + 1 + ". " + meny[i]);
            }
            scanner.nextLine();
        }

    }

    static void LäggTill() {
        
    }
}
