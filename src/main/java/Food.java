import java.util.Date;

/**
 *
 */


public class Food {
    private String Name;
    private Date expireDate;
    private Date createDate;
    private double price;
    private double discount;

    public Food(String name, Date expireDate, Date createDate, double price, double discount) {
        Name = name;
        this.expireDate = expireDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    /**
     *
     * @return
     */
    public double shelfLife (Food food) {
        return ((food.getExpireDate().getTime() - food.getCreateDate().getTime()) / (1000 * 60 * 60 * 24));
    }

    /**
     *
     * @param currentDate
     * @return
     */

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
