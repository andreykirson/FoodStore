import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Food> store = new ArrayList<>();

    /**
     * @param food
     */

    public void add(Food food) {
        store.add(food);
    }

    public int size () {
        return store.size();
    }

}
