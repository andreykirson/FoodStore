import org.junit.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ControlQualityTest {

    @Test
    public void whenAddToWarehouse() throws ParseException {

        Food banana = new Food("banana", new SimpleDateFormat("yyyy-MM-dd").parse("2021-09-30"),
                new SimpleDateFormat("yyyy-MM-dd").parse("2020-09-01"), 100, 0.3);
        ControlQuality controlQuality = new ControlQuality();
        List<Food> foods = new ArrayList<>();
        foods.add(banana);
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        List<Store> stores = new ArrayList<>();
        stores.add(warehouse);
        stores.add(shop);
        stores.add(trash);
        controlQuality.sort(foods, stores);
        assertThat(stores.get(0).size(), is(1));
    }

    @Test
    public void whenAddToTrash() throws ParseException {

        Food banana = new Food("banana", new SimpleDateFormat("yyyy-MM-dd").parse("2020-09-20"),
                new SimpleDateFormat("yyyy-MM-dd").parse("2020-09-01"), 100, 0.3);
        List<Food> foods = new ArrayList<>();
        foods.add(banana);
        ControlQuality controlQuality = new ControlQuality();
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        List<Store> stores = new ArrayList<>();
        stores.add(warehouse);
        stores.add(shop);
        stores.add(trash);
        controlQuality.sort(foods, stores);
        assertThat(stores.get(1).size(), is(1));
    }

    @Test
    public void whenAddToShop() throws ParseException {
        Food banana = new Food("banana", new SimpleDateFormat("yyyy-MM-dd").parse("2020-09-08"),
                new SimpleDateFormat("yyyy-MM-dd").parse("2020-09-06"), 100, 0.3);
        List<Food> foods = new ArrayList<>();
        foods.add(banana);
        ControlQuality controlQuality = new ControlQuality();
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        List<Store> stores = new ArrayList<>();
        stores.add(warehouse);
        stores.add(shop);
        stores.add(trash);
        controlQuality.sort(foods, stores);
        assertThat(stores.get(2).size(), is(1));
    }

    @Test
    public void whenResort() throws ParseException {
        Food banana = new Food("banana", new SimpleDateFormat("yyyy-MM-dd").parse("2020-09-08"),
                new SimpleDateFormat("yyyy-MM-dd").parse("2020-09-06"), 100, 0.3);
        List<Food> foods = new ArrayList<>();
        foods.add(banana);
        ControlQuality controlQuality = new ControlQuality();
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        List<Store> stores = new ArrayList<>();
        stores.add(warehouse);
        stores.add(shop);
        stores.add(trash);
        controlQuality.sort(foods, stores);
        controlQuality.resort(stores);
        assertThat(stores.get(2).size(), is(1));
    }






}