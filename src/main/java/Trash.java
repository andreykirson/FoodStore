import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Trash implements Store{
   private List<Food> bucket = new ArrayList<>();

    /**
     * @param food
     * @return
     */
    @Override
    public boolean accept(Food food) {
        Date currentDate = new Date();
        double remainingShelfLife = food.remainingShelfLife(currentDate, food);
        return (remainingShelfLife > 0.75);
    }

    /**
     * @param food
     */

    public void add(Food food) {
        if (accept(food)) {
            bucket.add(food);
        }
    }

    /**
     *
     * @return
     */
    @Override
    public int size () {
        return bucket.size();
    }
}
