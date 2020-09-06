import java.util.ArrayList;
import java.util.List;

public class Warehouse {

    private List<Food> store = new ArrayList<>();

    /**
     * @param food
     */

    public void add(Food food) {
        store.add(food);
    }

    /**
     *
     * @return
     */

    public int size () {
        return store.size();
    }


}
