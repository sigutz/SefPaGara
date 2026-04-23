import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Gara {
    Scanner scanner = new Scanner(System.in);

    // --- CULORI PENTRU CONSOLA ---
    public static final String RESET = "\u001B[0m";
    public static final String VERDE = "\u001B[32m";
    public static final String GALBEN = "\u001B[33m";
    public static final String ALBASTRU = "\u001B[36m"; // Cyan
    public static final String ROSU = "\u001B[31m";
    public static final String VIOLET = "\u001B[35m";

    private void afiseazaTitluMeniu(String titlu) {
        System.out.println(ALBASTRU + "==================================================" + RESET);
        System.out.println(ALBASTRU + "   " + titlu + RESET);
        System.out.println(ALBASTRU + "==================================================" + RESET);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


    private String nume;
    public Float sold = 10000.0f;
    private List<Locomotiva> locomotive_tip = new ArrayList<>();
    private List<Vagon> vagoane_tip = new ArrayList<>();

    private List<Fiare> inventar = new ArrayList<>();

    // Liste noi pentru angajati si trenuri
    private List<Angajat> piata_muncii = new ArrayList<>(); // Cei pe care ii poti angaja
    private List<Angajat> angajati_gara = new ArrayList<>(); // Cei deja angajati la tine
    private List<Tren> trenuri_active = new ArrayList<>(); // Trenurile pe care le-ai creat

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

        piata_muncii.add(new Angajat("Ion Mecanicul", 4500.0f, new Date(), 100.0f));
        piata_muncii.add(new Angajat("Maria Controlor", 3500.0f, new Date(), 90.0f));
        piata_muncii.add(new Angajat("Vasile Fochist", 3000.0f, new Date(), 85.0f));
        piata_muncii.add(new Angajat("Elena Sef Tren", 5000.0f, new Date(), 100.0f));

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

    private void afisPiataMuncii() {
        System.out.println("--- Candidați disponibili ---");
        for (int i = 0; i < piata_muncii.size(); i++) {
            System.out.println(i + ". " + piata_muncii.get(i));
        }
    }

    private void afisAngajatiGara() {
        System.out.println("--- Personalul Gării Tale ---");
        for (int i = 0; i < angajati_gara.size(); i++) {
            System.out.println(i + ". " + angajati_gara.get(i));
        }
    }

    private void angajeaza() {
        System.out.println("Balanta: " + sold);
        afisPiataMuncii();
        System.out.println("Selecteaza angajatul dorit (platesti o taxa de angajare egala cu salariul lui):");

        int nr_angajat = scanner.nextInt();
        scanner.nextLine(); // Golim buffer-ul

        if (nr_angajat >= 0 && nr_angajat < piata_muncii.size()) {
            Angajat candidat = piata_muncii.get(nr_angajat);
            if (sold >= candidat.getSalariu()) {
                Angajat nou = candidat.copiaza();
                angajati_gara.add(nou);
                sold -= candidat.getSalariu();
                System.out.println(nou.getNume() + " a fost angajat(ă) cu succes!");
            } else {
                System.out.println("Nu ai suficient sold pentru a-l angaja!");
            }
        } else {
            System.out.println("Optiune Invalida.");
        }
    }

    private void createTren() {
        System.out.println("\n--- CREARE TREN NOU ---");
        System.out.println("Introdu numele noului tren:");
        String numeTren = scanner.nextLine();

        // 1. SELECTARE LOCOMOTIVĂ
        afisInventar(); // Le afisam pe toate ca sa vad starea lor
        System.out.println("Selecteaza indexul locomotivei (-1 pentru anulare):");
        int nr_loc = scanner.nextInt();
        scanner.nextLine();

        if (nr_loc == -1) { return; }

        if (nr_loc < 0 || nr_loc >= inventar.size() || !(inventar.get(nr_loc) instanceof Locomotiva)) {
            System.out.println("Selectie invalida. Trebuie sa alegi o Locomotiva.");
            return;
        }

        Locomotiva locSelectata = (Locomotiva) inventar.get(nr_loc);
        if (locSelectata.isOcupat()) {
            System.out.println("Aceasta locomotiva este deja atasata altui tren!");
            return;
        }

        Tren trenNou = new Tren(numeTren, locSelectata);

        // 2. ADĂUGARE VAGOANE
        boolean gataVagoane = false;
        while (!gataVagoane) {
            System.out.println("\nAdaugare Vagoane la " + numeTren);
            afisInventar();
            System.out.println("Selecteaza vagon (-1 pentru a trece la angajati):");
            int nr_vagon = scanner.nextInt();
            scanner.nextLine();

            if (nr_vagon == -1) {
                gataVagoane = true;
            } else if (nr_vagon >= 0 && nr_vagon < inventar.size() && inventar.get(nr_vagon) instanceof Vagon) {
                Vagon vagonSelectat = (Vagon) inventar.get(nr_vagon);

                if (vagonSelectat.isOcupat()) {
                    System.out.println("Acest vagon este deja folosit!");
                } else {
                    // Nu mai facem .copiaza() aici, folosim referinta directa pentru a-i schimba starea in tot jocul
                    trenNou.add_vagon(vagonSelectat);
                    System.out.println("Vagon atasat cu succes!");
                }
            } else {
                System.out.println("Index invalid. Alege un vagon.");
            }
        }

        // 3. ASIGNARE ANGAJAȚI
        boolean gataAngajati = false;
        while (!gataAngajati) {
            System.out.println("\nAsignare Echipaj la " + numeTren);
            afisAngajatiGara();

            System.out.println("Selecteaza angajatul (-1 pentru a finaliza trenul):");
            int nr_angajat = scanner.nextInt();
            scanner.nextLine();

            if (nr_angajat == -1) {
                gataAngajati = true;
            } else if (nr_angajat >= 0 && nr_angajat < angajati_gara.size()) {
                Angajat angajatSelectat = angajati_gara.get(nr_angajat);

                if (angajatSelectat.isOcupat()) {
                    System.out.println("Acest angajat este deja in cursa!");
                } else {
                    trenNou.add_angajat(angajatSelectat);
                    System.out.println("Angajat asignat cu succes!");
                }
            } else {
                System.out.println("Index invalid.");
            }
        }

        // 4. SALVARE TREN
        trenuri_active.add(trenNou);
        System.out.println("\nTrenul a fost creat cu succes!");
        System.out.println(trenNou.toString());
    }

    private void stergeTren() {
        System.out.println("\n--- STERGE TREN ---");
        if (trenuri_active.isEmpty()) {
            System.out.println("Nu exista trenuri active de sters.");
            return;
        }

        for (int i = 0; i < trenuri_active.size(); i++) {
            System.out.println(i + ". " + trenuri_active.get(i).toString());
        }

        System.out.println("Introdu indexul trenului pe care vrei sa il dezasamblezi (-1 pentru anulare):");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index >= 0 && index < trenuri_active.size()) {
            Tren trenDeSters = trenuri_active.get(index);
            trenDeSters.dezmembreaza(); // Eliberam locomotive, vagoane si angajati
            trenuri_active.remove(index); // Scoatem trenul din lista
            System.out.println("Trenul a fost sters. Resursele au fost reintroduse in gara.");
        } else if (index != -1) {
            System.out.println("Index invalid.");
        }
    }

    private void meniuCumpara() {
        Boolean run = true;
        while (run) {
            System.out.println("\n");
            afiseazaTitluMeniu("MAGAZIN & RESURSE UMANE");
            System.out.println(" Balanta curenta: " + GALBEN + sold + " RON" + RESET);
            System.out.println(ALBASTRU + "--------------------------------------------------" + RESET);

            System.out.println("  " + VERDE + "[1]" + RESET + " Cumpara Locomotiva");
            System.out.println("  " + VERDE + "[2]" + RESET + " Cumpara Vagon");
            System.out.println("  " + VERDE + "[3]" + RESET + " Angajeaza Personal");
            System.out.println("  " + VERDE + "[4]" + RESET + " Vezi Inventarul (Fiare in garaj)");
            System.out.println("  " + VERDE + "[5]" + RESET + " Vezi Personalul Garzii (Liberi)");
            System.out.println(ALBASTRU + "--------------------------------------------------" + RESET);
            System.out.println("  " + ROSU + "[0]" + RESET + " Inapoi la Meniul Principal");
            System.out.println(ALBASTRU + "==================================================" + RESET);
            System.out.print("Alege o optiune: ");

            Integer choice = scanner.nextInt();
            scanner.nextLine(); // Curatam buffer-ul

            switch (choice) {
                case 1:
                    cumparaLocomotiva();
                    break;
                case 2:
                    cumparaVagon();
                    break;
                case 3:
                    angajeaza();
                    break;
                case 4:
                    System.out.println("\n" + VIOLET + "--- INVENTAR FIARE ---" + RESET);
                    afisInventar();
                    break;
                case 5:
                    System.out.println("\n" + VIOLET + "--- PERSONAL LIBER IN GARA ---" + RESET);
                    afisAngajatiGara();
                    break;
                case 0:
                    run = false;
                    break;
                default:
                    System.out.println(ROSU + "[!] Optiune invalida!" + RESET);
                    break;
            }
        }
    }


    public void Run() {
        Boolean run = true;
        while (run) {
            System.out.println("\n");
            afiseazaTitluMeniu("MENIU PRINCIPAL - GARA TA");
            System.out.println(" Balanta curenta: " + GALBEN + sold + " RON" + RESET);
            System.out.println(ALBASTRU + "--------------------------------------------------" + RESET);

            System.out.println("  " + VERDE + "[1]" + RESET + " Catalog Locomotive");
            System.out.println("  " + VERDE + "[2]" + RESET + " Catalog Vagoane");
            System.out.println("  " + VERDE + "[3]" + RESET + " Meniu Magazin & Angajari");
            System.out.println("  " + VERDE + "[4]" + RESET + " Creeaza un Tren Nou");
            System.out.println("  " + VERDE + "[5]" + RESET + " Vizualizeaza Trenuri Active");
            System.out.println("  " + VERDE + "[6]" + RESET + " Stergere Tren");

            System.out.println(ALBASTRU + "--------------------------------------------------" + RESET);
            System.out.println("  " + ROSU + "[0]" + RESET + " Iesire joc");
            System.out.println(ALBASTRU + "==================================================" + RESET);
            System.out.print("Alege o optiune: ");

            Integer choice = scanner.nextInt();
            scanner.nextLine(); // Curatam buffer-ul

            switch (choice) {
                case 1:
                    System.out.println("\n" + VIOLET + "--- Catalog Locomotive ---" + RESET);
                    afisLocomotiveTip();
                    break;
                case 2:
                    System.out.println("\n" + VIOLET + "--- Catalog Vagoane ---" + RESET);
                    afisVagoaneTip();
                    break;
                case 3:
                    meniuCumpara();
                    break;
                case 4:
                    createTren();
                    break;
                case 5:
                    afiseazaTrenuriActive();
                    break;
                case 6:
                    stergeTren();
                    break;
                case 0:
                    System.out.println(GALBEN + "La revedere, domnule Inginer!" + RESET);
                    run = false;
                    break;
                default:
                    System.out.println(ROSU + "[!] Optiune invalida! Incearca din nou." + RESET);
                    break;
            }
        }
    }

    private void afiseazaTrenuriActive() {
        afiseazaTitluMeniu("TRENURI ACTIVE IN GARA");
        if (trenuri_active.isEmpty()) {
            System.out.println(ROSU + "Nu ai niciun tren format inca." + RESET);
        } else {
            for (int i = 0; i < trenuri_active.size(); i++) {
                System.out.println(VERDE + i + ". " + RESET + trenuri_active.get(i).toString());
            }
        }
    }
}