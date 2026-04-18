import java.util.ArrayList;
import java.util.List;

public class Gara {
    private String nume;
    private List<Locomotiva> locomotive_tip = new ArrayList<>();
    private List<Vagon> vagoane_tip = new ArrayList<>();

    {
        locomotive_tip.add(new Locomotiva(new String("Sf. Maria"), 1000, 50.0f, Cuplaj.Crab, 3000, Motor.Disel, 60.0f));
        locomotive_tip.add(new Locomotiva(new String("Sf. Ana"), 2000, 100.0f, Cuplaj.Crab, 9000, Motor.Disel, 65.0f));
        locomotive_tip.add(new Locomotiva(new String("Stefan cel Mare"), 1500, 50.0f, Cuplaj.Crab, 1000, Motor.Electric, 150.0f));

        vagoane_tip.add(new VagonPasager(new String("Da"), ))

    }

}
