public class PolinomMVC {

    public static void main(String[] args) {

        PolinomModel model = new PolinomModel();
        PolinomView view = new PolinomView(model);
        PolinomController controller = new PolinomController(model, view);

        view.setVisible(true);
        view.setResizable(false);
    }
}
