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


}
