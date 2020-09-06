import java.util.Date;

public interface ControlQuality {
    void controlAlgorithm (Food food, Warehouse warehouse, Shop shop, Trash trash);
    double shelfLife (Food food);
    double remainingShelfLife (Date currentDate, Food food);
}
