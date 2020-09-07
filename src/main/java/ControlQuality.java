import java.util.List;

public class ControlQuality {

    public void controlAlgorithm(Food food, List<Store> stores) {
        for (Store s:stores) {
            s.add(food);
        }
    }
}
