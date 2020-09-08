import java.util.Date;
import java.util.Stack;

public class Shop implements Store {

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
        return (remainingShelfLife > 0.25 && remainingShelfLife <= 0.75);
    }

    /**
     * @param food
     */

    @Override
    public void add(Food food) {
        if (accept(food)) {
            double newPrice = food.getPrice() * food.getDiscount();
            food.setPrice(newPrice);
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
