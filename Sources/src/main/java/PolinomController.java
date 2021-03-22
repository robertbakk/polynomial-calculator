import java.awt.event.*;

public class PolinomController {

    private PolinomModel m_model;
    private PolinomView m_view;

    PolinomController(PolinomModel model, PolinomView view) {
        m_model = model;
        m_view = view;

        view.addAdunareListener(new AdunareListener());
        view.addDiferentaListener(new DiferentaListener());
        view.addInmultireListener(new InmultireListener());
        view.addImpartireListener(new ImpartireListener());
        view.addDerivareListener(new DerivareListener());
        view.addIntegrareListener(new IntegrareListener());
        view.addClearListener(new ClearListener());
    }

    class AdunareListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String polinom1 = "";
            String polinom2 = "";
            boolean reusit = false;
            try {
                polinom1 = m_view.getPolinom1();
                polinom2 = m_view.getPolinom2();
                Polinom A = new Polinom(polinom1);
                reusit = true;
                Polinom B = new Polinom(polinom2);
                m_model.adunare(A, B);
                m_view.setRezultat1(m_model.getRez1().toString());
                m_view.setRezultat2("");

            } catch (NumberFormatException nfex) {
                m_view.showError("Date de intrare incorecte: " + (reusit ? polinom2 : polinom1));
            }
        }
    }

    class DiferentaListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String polinom1 = "";
            String polinom2 = "";
            boolean reusit = false;
            try {
                polinom1 = m_view.getPolinom1();
                polinom2 = m_view.getPolinom2();
                Polinom A = new Polinom(polinom1);
                reusit = true;
                Polinom B = new Polinom(polinom2);
                m_model.diferenta(A, B);
                m_view.setRezultat1(m_model.getRez1().toString());
                m_view.setRezultat2("");

            } catch (NumberFormatException nfex) {
                m_view.showError("Date de intrare incorecte: " + (reusit ? polinom2 : polinom1));
            }
        }
    }

    class InmultireListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String polinom1 = "";
            String polinom2 = "";
            boolean reusit = false;
            try {
                polinom1 = m_view.getPolinom1();
                polinom2 = m_view.getPolinom2();
                Polinom A = new Polinom(polinom1);
                reusit = true;
                Polinom B = new Polinom(polinom2);
                m_model.inmultire(A, B);
                m_view.setRezultat1(m_model.getRez1().toString());
                m_view.setRezultat2("");

            } catch (NumberFormatException nfex) {
                m_view.showError("Date de intrare incorecte: " + (reusit ? polinom2 : polinom1));
            }
        }
    }

    class ImpartireListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String polinom1 = "";
            String polinom2 = "";
            boolean reusit = false;
            try {
                polinom1 = m_view.getPolinom1();
                polinom2 = m_view.getPolinom2();
                Polinom A = new Polinom(polinom1);
                reusit = true;
                Polinom B = new Polinom(polinom2);
                m_model.impartire(A, B);
                m_view.setRezultat1(m_model.getRez1().toString());
                m_view.setRezultat2(m_model.getRez2().toString());

            } catch (NumberFormatException nfex) {
                m_view.showError("Date de intrare incorecte: " + (reusit ? polinom2 : polinom1));
            }
        }
    }

    class DerivareListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String polinom1 = "";
            String polinom2 = "";
            boolean reusit = false;
            try {
                polinom1 = m_view.getPolinom1();
                polinom2 = m_view.getPolinom2();
                Polinom A = new Polinom(polinom1);
                reusit = true;
                Polinom B = new Polinom(polinom2);
                m_model.derivare(A);
                m_view.setRezultat1(m_model.getRez1().toString());
                m_model.derivare(B);
                m_view.setRezultat2(m_model.getRez1().toString());

            } catch (NumberFormatException nfex) {
                m_view.showError("Date de intrare incorecte: " + (reusit ? polinom2 : polinom1));
            }
        }
    }

    class IntegrareListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String polinom1 = "";
            String polinom2 = "";
            boolean reusit = false;
            try {
                polinom1 = m_view.getPolinom1();
                polinom2 = m_view.getPolinom2();
                Polinom A = new Polinom(polinom1);
                reusit = true;
                Polinom B = new Polinom(polinom2);
                m_model.integrare(A);
                m_view.setRezultat1(m_model.getRez1().toString()+"+C");
                m_model.integrare(B);
                m_view.setRezultat2(m_model.getRez1().toString()+"+C");

            } catch (NumberFormatException nfex) {
                m_view.showError("Date de intrare incorecte: " + (reusit ? polinom2 : polinom1));
            }
        }
    }

    class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            m_view.reset();
        }
    }
}
