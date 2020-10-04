package congnghepm;

public class Anwser {
    private String an1;
    private double diem;
    private boolean typ1;
    public Anwser(String a,double b, boolean c) {
        this.an1 = a;
        this.diem = b;
        this.typ1 = c;
    }

    public boolean getTypee() {
        return typ1;
    }

    public double getDiem() {
        return diem;
    }

    public String getAn1() {
        return an1;
    }

    @Override
    public String toString() {
        return "Anwser{" +
                "an1='" + an1 + '\'' +
                ", diem=" + diem +
                ", typ1=" + typ1 +
                '}';
    }
}
