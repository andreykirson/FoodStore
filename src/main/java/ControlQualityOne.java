import java.util.Date;

public class ControlQualityOne implements ControlQuality {

    /**
     * @param food
     * @param warehouse
     * @param shop
     * @param trash
     * 3.1. Если срок годности израсходован меньше чем на 25% направить в Warehouse.
     * 3.2 Если срок годности от 25% до 75% направить в Shop
     * 3.3. Если срок годности больше 75% то выставить скидку на продукт и отправить в Shop
     * 3.4. Если срок годности вышел. Отправить продукт в мусорку.
     */


    @Override
    public void controlAlgorithm(Food food, Warehouse warehouse, Shop shop, Trash trash) {
        Date currentDate = new Date();
        double remainingShelfLife = remainingShelfLife(currentDate, food);
        if (remainingShelfLife < 0.25) {
            warehouse.add(food);
        } else if (remainingShelfLife > 0.25 && remainingShelfLife < 0.75) {
            double newPrice = food.getPrice() * food.getDiscount();
            food.setPrice(newPrice);
            shop.add(food);
        } else {trash.add(food);}
    }


    /**
     *
     * @return
     */
    @Override
    public double shelfLife (Food food) {
        return ((food.getExpireDate().getTime() - food.getCreateDate().getTime()) / (1000 * 60 * 60 * 24));
    }

    /**
     *
     * @param currentDate
     * @return
     */

    @Override
    public double remainingShelfLife (Date currentDate, Food food) {
        double usedShelfLife;
        double shelfLife = shelfLife(food);
        double remainingShelfLifePeriod =  ((food.getExpireDate().getTime() - currentDate.getTime())/ (1000 * 60 * 60 * 24));
        if (remainingShelfLifePeriod < 0) {
            usedShelfLife = 1;
        } else {
            usedShelfLife = (1 - remainingShelfLifePeriod / shelfLife);
        }
        return usedShelfLife;
    }
}
