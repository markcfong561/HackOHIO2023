import java.util.Random;
import java.io.IOException;

public class MainHack2023 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Random rand = new Random();

        int randSize = rand.nextInt(10);

        int[] x = new int[randSize];
        int[] y = new int[randSize];
        double[] distances = new double[randSize];

        for (int i : x) {
            x[i] = rand.nextInt(320);
        }

        for (int j : y) {
            y[j] = rand.nextInt(240);
        }

        for (int k = 0; k < distances.length; k++) {
            distances[k] = rand.nextDouble(100.0);
        }

        ModelHack2023 model = new ModelHack2023();
        ViewHack2023 view = new ViewHack2023();
        ControllerHack2023 controller = new ControllerHack2023(model, view);

        view.registerObserver(controller);

        int j = 0;
        while (true) {
            controller.xAdd(x[j]);
            controller.yAdd(y[j]);
            controller.dAdd(distances[j]);
            j++;

            controller.processNewImage(controller.xCoordinate(), controller.yCoordinate(), controller.distancesArray());

        }

    }
}