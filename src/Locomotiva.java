enum Motor {
    Disel,
    Electric
}

public class Locomotiva extends Fiare {
    private Integer capacitate_tone;
    private Motor tipMotor;
    private Float kmOraMax;

    public Locomotiva(String nume, Integer tonaj, Float pret, Cuplaj cuplaj, Integer capacitate_tone, Motor tipMotor, Float kmOraMax) {
        super(nume, tonaj, pret, cuplaj);
        this.capacitate_tone = capacitate_tone;
        this.tipMotor = tipMotor;
        this.kmOraMax = kmOraMax;
    }

    public Locomotiva(Locomotiva altaLocomotiva) {
        super(altaLocomotiva.getNume(), altaLocomotiva.getTonaj(), altaLocomotiva.getPret(), altaLocomotiva.getCuplaj());
        this.capacitate_tone = altaLocomotiva.capacitate_tone;
        this.tipMotor = altaLocomotiva.tipMotor;
        this.kmOraMax = altaLocomotiva.kmOraMax;
    }

    public Locomotiva copiaza() {
        return new Locomotiva(this);
    }

    @Override
    public String toString() {
        return super.toString() + "\n-> capcaitate tone: " + capacitate_tone.toString() + "\n -> motor: " + tipMotor.toString() +"\n -> km/h : " + kmOraMax.toString();
    }
}
