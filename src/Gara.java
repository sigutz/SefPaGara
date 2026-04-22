import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gara {
    Scanner scanner = new Scanner(System.in);
    // Source - https://stackoverflow.com/a/32295974
    // Posted by satish, modified by community. See post 'Timeline' for change history
    // Retrieved 2026-04-22, License - CC BY-SA 4.0

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


    private String nume;
    public Float sold = 10000.0f;
    private List<Locomotiva> locomotive_tip = new ArrayList<>();
    private List<Vagon> vagoane_tip = new ArrayList<>();

    private List<Fiare> inventar = new ArrayList<>();

    public Gara() {
        System.out.println("Introduceti numele dumneavoastra domn Inginer: ");
        nume = scanner.nextLine();

        locomotive_tip.add(new Locomotiva(new String("Pasager Disel"), 1000, 50.0f, Cuplaj.Crab, 3000, Motor.Disel, 60.0f));
        locomotive_tip.add(new Locomotiva(new String("Marfar Disel"), 2000, 100.0f, Cuplaj.Crab, 9000, Motor.Disel, 65.0f));
        locomotive_tip.add(new Locomotiva(new String("Pasager Electric"), 1500, 50.0f, Cuplaj.Crab, 1000, Motor.Electric, 150.0f));

        vagoane_tip.add(new VagonPasager(new String("Clasa 1"), 100, 20.0f, Cuplaj.Crab, 100, TipVagonPasager.Clasa1));
        vagoane_tip.add(new VagonPasager(new String("Clasa 2"), 100, 20.0f, Cuplaj.Crab, 200, TipVagonPasager.Clasa2));
        vagoane_tip.add(new VagonPasager(new String("Cuseta 1"), 100, 20.0f, Cuplaj.Crab, 50, TipVagonPasager.Cuseta1));
        vagoane_tip.add(new VagonPasager(new String("Cuseta 2"), 100, 20.0f, Cuplaj.Crab, 80, TipVagonPasager.Cuseta2));
        vagoane_tip.add(new VagonPasager(new String("Restaurant"), 100, 20.0f, Cuplaj.Crab, 150, TipVagonPasager.Restaurant));
    }

    private void afisLocomotiveTip() {
        for (int i=0; i<locomotive_tip.size(); i++){
            System.out.println(i + ". " + locomotive_tip.get(i));

        }
    }

    private void afisVagoaneTip() {
        for (int i=0; i<vagoane_tip.size(); i++){
            System.out.println(i + ". " + vagoane_tip.get(i));
        }
    }

    private void afisInventar(){
        System.out.println("Balanta: " + sold);
        for (int i=0; i<inventar.size(); i++){
            System.out.println(i + ". " + inventar.get(i));
        }
    }

    private void afisLocomotiveInventar(){
        for (int i=0; i<inventar.size(); i++){
            if (inventar.get(i) instanceof Locomotiva)
                System.out.println(i + ". " + inventar.get(i));
        }
    }

    private void afisVagoaneInventar(){
        for (int i=0; i<inventar.size(); i++){
            if (inventar.get(i) instanceof Vagon)
                System.out.println(i + ". " + inventar.get(i));
        }
    }

    private void cumparaLocomotiva() {
        System.out.println("Balanta: " + sold);

        afisLocomotiveTip();

        System.out.println("Selecteaza locomotiva:");

        Integer nr_locomotiva = scanner.nextInt();


        while (nr_locomotiva < 0 || nr_locomotiva > locomotive_tip.size()){
            System.out.println("Optiune Invalida. Selecteaza locomotiva: ");
            nr_locomotiva = scanner.nextInt();
        }

        scanner.nextLine();

        if ( sold > locomotive_tip.get(nr_locomotiva).getPret()){
            System.out.println("Introduceti numele nou al locomotivei:");
            String numeLocomotiva = scanner.nextLine();

            Locomotiva nou = locomotive_tip.get(nr_locomotiva).copiaza();
            nou.setNume(numeLocomotiva);

            inventar.add(nou);
            sold-= nou.getPret();
        }

    }

    private void cumparaVagon() {
        System.out.println("Balanta: " + sold);

        afisVagoaneTip();

        System.out.println("Selecteaza vagon:");

        Integer nr_vagon = scanner.nextInt();

        while (nr_vagon < 0 || nr_vagon > vagoane_tip.size()){
            System.out.println("Optiune Invalida. Selecteaza vagon: ");
            nr_vagon = scanner.nextInt();
        }

        scanner.nextLine();

        if ( sold > vagoane_tip.get(nr_vagon).getPret()){
            System.out.println("Introduceti numele nou al locomotivei:");
            String numeVagon = scanner.nextLine();

            Vagon nou = vagoane_tip.get(nr_vagon).copiaza();
            nou.setNume(numeVagon);

            inventar.add(nou);
            sold-= nou.getPret();
        }
    }

    private void createTren() {
        afisLocomotiveInventar();
        System.out.println("Selecteaza locomotiva");
    }

    private void meniuCumpara() {
        System.out.println("Balanta: " + sold);
        Boolean run = true;
        while (run) {
            clearScreen();
            System.out.println("1. Afisare locomotive tip ");
            System.out.println("2. Afisare vagoane tip ");
            System.out.println("3. Cumpara locomotiva");
            System.out.println("4. Cumpara vagon");
            System.out.println("5. Afisare inventar");
            System.out.println("0. Exit ");

            Integer choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    afisLocomotiveTip();
                    break;
                case 2:
                    afisVagoaneTip();
                    break;
                case 3:
                    cumparaLocomotiva();
                    break;
                case 4:
                    cumparaVagon();
                    break;
                case 5:
                    afisInventar();
                case 0:
                    run = false;
                    break;
                default:
                    System.out.println("Optiune invalida");
                    break;
            }
        }
    }


    public void Run() {
        Boolean run = true;
        while (run) {

            System.out.println("1. Afisare locomotive tip ");
            System.out.println("2. Afisare vagoane tip ");
            System.out.println("3. Meniu Shop ");
            System.out.println("0. Exit ");

            Integer choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    afisLocomotiveTip();
                    break;
                case 2:
                    afisVagoaneTip();
                    break;
                case 3:
                    meniuCumpara();
                    break;
                case 0:
                    run = false;
                    break;
                default:
                    System.out.println("Optiune invalida");
                    break;
            }
        }
    }
}