import java.util.Map;
import java.util.HashMap;
import java.util.Pair;

public final class ControllerHack2023 {

    private final ModelHack2023 model;

    private final ViewHack2023 view; 

    //Updates
    private void updateViewToMatchModel(ModelHack2023 model, ViewHack2023 view) {
        for (Map.Entry<Pair<Integer, Integer>, Double> person : model.people.entrySet()) {
            view.updateUI(person.getKey().getKey(), person.getKey().getValue(), model.people.get(person));
        }

    }

    private void processNewImage(int[] x, int[] y, double[] distances) {
        model.people.clear();
        for (int i : x) {
            Pair<Integer, Integer> coordinate = new Pair<Integer, Integer>(x[i], y[i]);
            model.people.put(coordinate, distances[i]);
        }
    }

}