public class Persoana {
    private static Integer u_id = 0;
    private String nume;
    private String cnp;

    public Persoana(String nume) {
        u_id++;
        this.nume = nume;
        this.cnp = u_id.toString();
    }

    public String getNume() {
        return nume;
    }
}
