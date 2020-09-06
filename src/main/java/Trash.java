import java.util.ArrayList;
import java.util.List;

public class Trash {
   private List<Food> bucket = new ArrayList<>();

    /**
     * @param food
     */

    public void add(Food food) {
        bucket.add(food);
    }

    public int size () {
        return bucket.size();
    }
}
