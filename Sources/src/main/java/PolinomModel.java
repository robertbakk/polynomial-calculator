import java.util.Collections;

public class PolinomModel {
    private Polinom rez1;
    private Polinom rez2;

    PolinomModel() {
        reset();
    }

    public void reset() {
        Polinom rez1 = new Polinom();
        Polinom rez2 = new Polinom();
    }

    public void adunare(Polinom x, Polinom y) {
        rez1 = new Polinom();
        for (Monom a : y.getMonoame())
            rez1.adaugaMonom(a);
        for (Monom a : x.getMonoame())
            rez1.adaugaMonom(a);
    }

    public void diferenta(Polinom x, Polinom y) {
        rez1 = new Polinom();
        for (Monom a : x.getMonoame())
            rez1.adaugaMonom(a);
        for (Monom a : y.getMonoame())
            rez1.adaugaMonom(new Monom(-a.getCoef(), a.getExp()));
    }

    public void inmultire(Polinom x, Polinom y) {
        rez1 = new Polinom();
        for (Monom a : y.getMonoame())
            for (Monom b : x.getMonoame())
                rez1.getMonoame().add(new Monom(a.getCoef() * b.getCoef(), a.getExp() + b.getExp()));
        rez1.restrangere();
    }

    public void impartire(Polinom x, Polinom y) {
        rez1 = new Polinom();
        rez2 = new Polinom();
        Polinom numarator = new Polinom();
        Polinom numitor = new Polinom();
        numarator = x;
        numitor = y;
        Collections.sort(numarator.getMonoame());
        Collections.sort(numitor.getMonoame());
        rez2 = numarator;
        while (numitor.toString() != "0" && rez2.toString() != "0" && numitor.getMonoame().get(0).getExp() <= rez2.getMonoame().get(0).getExp()) {
            PolinomModel op = new PolinomModel();
            double coeff = numarator.getMonoame().get(0).getCoef() / numitor.getMonoame().get(0).getCoef();
            int expp = numarator.getMonoame().get(0).getExp() - numitor.getMonoame().get(0).getExp();
            Monom elem = new Monom(coeff, expp);
            rez1.adaugaMonom(elem);
            Polinom unSingurMonom = new Polinom();
            unSingurMonom.adaugaMonom(elem);
            op.inmultire(numitor, unSingurMonom);
            Polinom deScazut = new Polinom();
            deScazut = op.getRez1();
            op.diferenta(numarator, deScazut);
            rez2 = op.getRez1();
            Collections.sort(rez2.getMonoame());
            rez2.restrangere();
            numarator = rez2;
        }
        rez1.restrangere();
        rez2.restrangere();
    }

    public void derivare(Polinom x) {
        rez1 = new Polinom();
        for (Monom a : x.getMonoame())
            rez1.adaugaMonom(new Monom(a.getExp() * a.getCoef(), a.getExp() - 1));
    }

    public void integrare(Polinom x) {
        rez1 = new Polinom();
        for (Monom a : x.getMonoame())
            rez1.adaugaMonom(new Monom(a.getCoef() / (a.getExp() + 1), a.getExp() + 1));
    }

    public Polinom getRez1() {
        return rez1;
    }

    public Polinom getRez2() {
        return rez2;
    }
}
