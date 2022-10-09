import java.util.Map;
import java.util.HashMap;
import java.util.List;

public final class ModelHack2023 {

    private Map<List<Integer>, Double> people;

    public ModelHack2023() {

        this.people = new HashMap<List<Integer>, Double>();
    }

    public Map<List<Integer>, Double> people() {
        return this.people;
    }

}