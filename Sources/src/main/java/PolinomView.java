import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class PolinomView extends JFrame {

    private JTextField polinom1 = new JTextField(30);
    private JTextField polinom2 = new JTextField(30);
    private JButton adunare = new JButton("Adunare");
    private JButton diferenta = new JButton("Scadere");
    private JButton inmultire = new JButton("Inmultire");
    private JButton impartire = new JButton("Impartire");
    private JButton derivare = new JButton("Derivare");
    private JButton integrare = new JButton("Integrare");
    private JTextField rezultat1 = new JTextField(20);
    private JTextField rezultat2 = new JTextField(20);
    private JButton clear = new JButton("Clear");

    private PolinomModel m_model;

    PolinomView(PolinomModel model) {

        m_model = model;

        rezultat1.setEditable(false);
        rezultat2.setEditable(false);

        JPanel primulPolinom = new JPanel();
        primulPolinom.setLayout(new FlowLayout(FlowLayout.CENTER));
        primulPolinom.add(polinom1);

        JPanel alDoileaPolinom = new JPanel();
        alDoileaPolinom.setLayout(new FlowLayout(FlowLayout.CENTER));
        alDoileaPolinom.add(polinom2);

        JPanel josPanel = new JPanel();
        josPanel.setLayout(new GridLayout(1, 2));

        JPanel stanga = new JPanel();
        stanga.setLayout(new GridLayout(4, 1));

        JPanel dreapta = new JPanel();
        dreapta.setLayout(new GridLayout(2, 1));

        JPanel addif = new JPanel();
        addif.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel adunarePanel = new JPanel();
        adunarePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        adunarePanel.add(adunare);

        JPanel diferentaPanel = new JPanel();
        diferentaPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        diferentaPanel.add(diferenta);

        JPanel inmimp = new JPanel();
        inmimp.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel inmultirePanel = new JPanel();
        inmultirePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        inmultirePanel.add(inmultire);

        JPanel impartirePanel = new JPanel();
        impartirePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        impartirePanel.add(impartire);

        JPanel derint = new JPanel();
        derint.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel derivarePanel = new JPanel();
        derivarePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        derivarePanel.add(derivare);

        JPanel integrarePanel = new JPanel();
        integrarePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        integrarePanel.add(integrare);

        JPanel clearPanel = new JPanel();
        clearPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        clearPanel.add(clear);

        JPanel primulRezultat = new JPanel();
        primulRezultat.setLayout(new FlowLayout(FlowLayout.CENTER));
        primulRezultat.add(rezultat1);

        JPanel alDoileaRezultat = new JPanel();
        alDoileaRezultat.setLayout(new FlowLayout(FlowLayout.CENTER));
        alDoileaRezultat.add(rezultat2);

        addif.add(adunarePanel);
        addif.add(diferentaPanel);
        inmimp.add(inmultirePanel);
        inmimp.add(impartirePanel);
        derint.add(derivarePanel);
        derint.add(integrarePanel);
        stanga.add(addif);
        stanga.add(inmimp);
        stanga.add(derint);
        stanga.add(clearPanel);
        dreapta.add(primulRezultat);
        dreapta.add(alDoileaRezultat);
        josPanel.add(stanga);
        josPanel.add(dreapta);

        this.add(primulPolinom, BorderLayout.NORTH);
        this.add(alDoileaPolinom, BorderLayout.CENTER);
        this.add(josPanel, BorderLayout.SOUTH);

        this.pack();

        this.setTitle("Calculator polinoame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void reset() {
        polinom1.setText("");
        polinom2.setText("");
        rezultat1.setText("");
        rezultat2.setText("");
    }

    String getPolinom1() {
        return polinom1.getText();
    }

    String getPolinom2() {
        return polinom2.getText();
    }

    void setRezultat1(String rez) {
        rezultat1.setText(rez);
    }

    void setRezultat2(String rez) {
        rezultat2.setText(rez);
    }

    void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }

    void addAdunareListener(ActionListener a) {
        adunare.addActionListener(a);
    }

    void addDiferentaListener(ActionListener a) {
        diferenta.addActionListener(a);
    }

    void addInmultireListener(ActionListener a) {
        inmultire.addActionListener(a);
    }

    void addImpartireListener(ActionListener a) {
        impartire.addActionListener(a);
    }

    void addDerivareListener(ActionListener a) {
        derivare.addActionListener(a);
    }

    void addIntegrareListener(ActionListener a) {
        integrare.addActionListener(a);
    }

    void addClearListener(ActionListener a) {
        clear.addActionListener(a);
    }
}
