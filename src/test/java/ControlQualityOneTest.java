import org.junit.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ControlQualityOneTest {

    @Test
    public void whenAddToWarehouse() throws ParseException {

        Food banana = new Food("banana", new SimpleDateFormat("yyyy-MM-dd").parse("2021-09-30"),
                new SimpleDateFormat("yyyy-MM-dd").parse("2020-09-01"), 100, 0.3);
        ControlQuality controlQuality = new ControlQualityOne();
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        controlQuality.controlAlgorithm(banana, warehouse, shop, trash);
        assertThat(warehouse.size(), is(1));
    }

    @Test
    public void whenAddToTrash() throws ParseException {

        Food banana = new Food("banana", new SimpleDateFormat("yyyy-MM-dd").parse("2020-09-20"),
                new SimpleDateFormat("yyyy-MM-dd").parse("2020-09-01"), 100, 0.3);

        ControlQuality controlQuality = new ControlQualityOne();
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        controlQuality.controlAlgorithm(banana, warehouse, shop, trash);
        assertThat(shop.size(), is(1));
    }

    @Test
    public void whenAddToShop() throws ParseException {
        Food banana = new Food("banana", new SimpleDateFormat("yyyy-MM-dd").parse("2020-09-10"),
                new SimpleDateFormat("yyyy-MM-dd").parse("2020-09-06"), 100, 0.3);
        ControlQuality controlQuality = new ControlQualityOne();
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        controlQuality.controlAlgorithm(banana, warehouse, shop, trash);
        assertThat(trash.size(), is(1));
    }
}