import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

public class Polinom {
    private ArrayList<Monom> monoame = new ArrayList<Monom>();

    public Polinom() {
        this.adaugaMonom(new Monom(0, 0));
    }

    public Polinom(String x) {
        crearePolinom(x);
    }

    public void crearePolinom(String x) {
        x += "+";
        x = x.replaceAll("-", "+-");    // inlocuieste semnele - cu +-
        x = x.replaceAll("x\\+", "x^1+");   // inlocuieste pe x+ cu x^1+
        x = x.replaceAll("(((?>[\\+\\-])|(?<=^))(?<!\\^)([0-9]?)+(\\.)?[0-9]+)(?=\\+)", "$1x^0"); // inlocuieste numarul de tip double <C> cu <Cx^0>
        x = x.replaceAll("^x", "1x");   // inlocuieste pe primul x din sir cu "1x"
        x = x.replaceAll("([\\+\\-])x", "$11x");    // inlocuieste toti +x sau -x cu +1x sau -1x
        x = x.replaceAll("\\s", ""); // elimina spatiile
        String[] s;
        s = x.split("\\+");

        for (String a : s) {
            if (!a.isEmpty()) {
                String[] coefSiExp = a.split("x\\^");
                if (coefSiExp.length == 2)
                    this.adaugaMonom(new Monom(Double.parseDouble(coefSiExp[0]), Integer.parseInt(coefSiExp[1])));
                else throw new NumberFormatException();
            }
        }
    }

    public ArrayList<Monom> getMonoame() {
        return monoame;
    }

    public void adaugaMonom(Monom x) {
        boolean gasit = false;
        for (Monom a : monoame) {
            if (a.getExp() == x.getExp()) {
                monoame.set(monoame.indexOf(a), new Monom(a.getCoef() + x.getCoef(), a.getExp())); // daca se gaseste alt monom cu acelasi coef, se face suma celor 2 monoame
                gasit = true;
            }
        }
        if (!gasit)
            monoame.add(x); // daca nu se gaseste alt monom cu acelasi coef, se adauga monomul la lista
    }

    public void restrangere() {
        Polinom rez = new Polinom();
        for (Monom b : monoame)
            rez.adaugaMonom(b);
        this.monoame = rez.monoame;
    }

    public String toString() {
        monoame.removeIf(a -> (a.getCoef() == 0));
        if (this.monoame.isEmpty())
            return "0";
        String str = "";
        Collections.sort(monoame);
        boolean first = true;
        for (Monom m : monoame) {
            String semn = "";
            if (first && m.getCoef() == 0)
                return "0";
            if (m.getCoef() > 0)
                if (!first)
                    semn = "+";
            if (m.getExp() == 0)
                str += semn + new DecimalFormat("#.####").format(m.getCoef());
            else if (m.getExp() == 1)
                str += semn + ((m.getCoef() != 1 && m.getCoef() != -1) ?
                        new DecimalFormat("#.####").format(m.getCoef()) :
                        m.getCoef() == -1 ? "-" : "") + "x";
            else
                str += semn + ((m.getCoef() != 1 && m.getCoef() != -1) ?
                        new DecimalFormat("#.####").format(m.getCoef()) :
                        m.getCoef() == -1 ? "-" : "") + "x^" + m.getExp();
            first = false;
        }
        return str;
    }
}
