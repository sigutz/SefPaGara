import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gara {
    Scanner scanner = new Scanner(System.in);

    private String nume;
    public Integer sold = 10000;
    private List<Locomotiva> locomotive_tip = new ArrayList<>();
    private List<Vagon> vagoane_tip = new ArrayList<>();

    private void afisLocomotiveTip(){
        for (Locomotiva locomotiva : locomotive_tip){
            System.out.println(locomotiva);
        }
    }

    private void afisVagoaneTip(){
        for (Vagon vagon: vagoane_tip){
            System.out.println(vagon);
        }
    }

    {
        System.out.println("Introduceti numele dumneavoastra domn Inginer: ");
        nume = scanner.nextLine();


        locomotive_tip.add(new Locomotiva(new String("Sf. Maria"), 1000, 50.0f, Cuplaj.Crab, 3000, Motor.Disel, 60.0f));
        locomotive_tip.add(new Locomotiva(new String("Sf. Ana"), 2000, 100.0f, Cuplaj.Crab, 9000, Motor.Disel, 65.0f));
        locomotive_tip.add(new Locomotiva(new String("Stefan cel Mare"), 1500, 50.0f, Cuplaj.Crab, 1000, Motor.Electric, 150.0f));

        vagoane_tip.add(new VagonPasager(new String("Clasa 1"), 100, 20.0f, Cuplaj.Crab, 100, TipVagonPasager.Clasa1));
        vagoane_tip.add(new VagonPasager(new String("Clasa 2"), 100, 20.0f, Cuplaj.Crab, 200, TipVagonPasager.Clasa2));
        vagoane_tip.add(new VagonPasager(new String("Cuseta 1"), 100, 20.0f, Cuplaj.Crab, 50, TipVagonPasager.Cuseta1));
        vagoane_tip.add(new VagonPasager(new String("Cuseta 2"), 100, 20.0f, Cuplaj.Crab, 80, TipVagonPasager.Cuseta2));
        vagoane_tip.add(new VagonPasager(new String("Restaurant"), 100, 20.0f, Cuplaj.Crab, 150, TipVagonPasager.Restaurant));

    }

    public void Run() {
        Boolean run = true;
        while (run){
            System.out.println("1. Afisare locomotive tip ");
            System.out.println("2. Afisare vagoane tip ");
            System.out.println("0. Exit ");

            Integer choice = scanner.nextInt();

            switch (choice){
                case 1:
                    afisLocomotiveTip();
                    break;
                case 2:
                    afisVagoaneTip();
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
