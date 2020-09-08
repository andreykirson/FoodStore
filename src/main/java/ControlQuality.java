import java.util.ArrayList;
import java.util.List;

public class ControlQuality {

    public void sort(List<Food> foods, List<Store> stores) {
        for (Food f : foods) {
            for (Store s:stores) {
                s.add(f);
            }
        }
    }

    public void resort(List<Store> stores) {
        List<Food> foods = new ArrayList<>();

        for (Store store:stores) {
            while (store.size() != 0) {
                foods.add(store.get());
            }
        }
        sort(foods, stores);
        System.out.println("товары пересортированы");
    }

}
