import java.util.Random;

public class MainHack2023 {
    public static void main(String[] args) {
        Random rand = new Random();

        int randSize = rand.nextInt(10);
        
        int[] x = new int[randSize];
        int[] y = new int[randSize];
        double[] distances = new double[randSize];

        for (int i : x) {
            x[i] = rand.nextInt(1200);
        }

        for (int j : y) {
            y[i] = rand.nextInt(500);
        }

        for (int k : distances) {
            distances[k] = rand.nextDouble(100.0);
        }

        ModelHack2023 model = new ModelHack2023();
        ViewHack2023 view = new ViewHack2023();
        ControllerHack2023 controller = new ControllerHack2023(model, view);

        view.registerObserver(controller);
    }
}