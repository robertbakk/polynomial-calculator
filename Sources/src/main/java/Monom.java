public class Monom implements Comparable {
    private double coef;
    private int exp;

    public Monom(double coef, int exp) {
        this.coef = coef;
        this.exp = exp;
    }

    public double getCoef() {
        return this.coef;
    }

    public int getExp() {
        return this.exp;
    }

    public int compareTo(Object x) {
        return this.getExp() < ((Monom) x).getExp() ? 1 : -1;
    }
}

