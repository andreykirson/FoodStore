import java.util.Date;
import java.util.Stack;

public class Warehouse implements Store {

    private Stack<Food> store = new Stack<>();

    /**
     *
     * @param food
     * @return
     */

    @Override
    public boolean accept(Food food) {
        Date currentDate = new Date();
        double remainingShelfLife = food.remainingShelfLife(currentDate, food);
        return (remainingShelfLife < 0.25);
    }

    /**
     * @param food
     */

    @Override
    public void add(Food food) {
        if (accept(food)) {
            store.push(food);
        }
    }

    /**
     *
     * @return
     */
    @Override
    public int size () {
        return store.size();
    }

    @Override
    public Food get() {
        return store.pop();
    }


}
