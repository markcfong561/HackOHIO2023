import java.util.Map;
import java.util.HashMap;
import java.util.Pair;
import java.util.Set; 

public final class ControllerHack2023 {

    private final ModelHack2023 model;

    private final ViewHack2023 view; 

    private static void updateViewToMatchModel(ModelHack2023 model, ViewHack2023 view) {
        for (Map.Entry<Pair<Integer, Integer>, Double> person : model.people.entrySet()) {
            view.updateUI(person.getKey().getKey(), person.getKey().getValue(), model.people.get(person));
        }
        
    }



}