import java.util.Map;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;;

public final class ControllerHack2023 {

    private final ModelHack2023 model;

    private final ViewHack2023 view;

    private List<Integer> x;
    private List<Integer> y;
    private List<Double> d;

    public ControllerHack2023(ModelHack2023 model, ViewHack2023 view) {
        this.model = model;
        this.view = view;
        x = new ArrayList<Integer>();
        y = new ArrayList<Integer>();
        d = new ArrayList<Double>();

    }

    // Updates
    private static void updateViewToMatchModel(ModelHack2023 model, ViewHack2023 view, List<Integer> x, List<Integer> y,
            List<Double> distances) throws IOException, InterruptedException {

        for (Map.Entry<List<Integer>, Double> person : model.people().entrySet()) {
            view.updateUI(person.getKey().get(0), person.getKey().get(1), model.people().get(person.getKey()),
                    view.viewImage());
        }
        view.updateVideo(x, y, distances);

    }

    public List<Integer> xCoordinate() {
        return this.x;
    }

    public List<Integer> yCoordinate() {
        return this.y;
    }

    public List<Double> distancesArray() {
        return this.d;
    }

    public void xAdd(int horizontal) {
        this.x.add(horizontal);
    }

    public void xClear() {
        this.x.clear();
    }

    public void yAdd(int vertical) {
        this.y.add(vertical);
    }

    public void yClear() {
        this.y.clear();
    }

    public void dAdd(double meters) {
        this.d.add(meters);
    }

    public void dClear() {
        this.d.clear();
    }

    public void processNewImage(List<Integer> x, List<Integer> y, List<Double> distances)
            throws IOException, InterruptedException {
        this.model.people().clear();
        Iterator<Integer> i = x.iterator();
        Iterator<Integer> j = y.iterator();
        Iterator<Double> k = d.iterator();
        while (i.hasNext()) {
            List<Integer> coordinates = new ArrayList<Integer>();
            coordinates.add((Integer) i.next());
            coordinates.add((Integer) j.next());
            this.model.people().put(coordinates, (Double) k.next());
        }

        updateViewToMatchModel(this.model, this.view, x, y, d);
    }

}