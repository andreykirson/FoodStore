
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class SortFood {

    private ConfigManager cfg;

    public Scheduler scheduler() throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();
        return scheduler;
    }

    public void cfg() {
        cfg = new ConfigManager("sortfood.properties");
    }



    public void init(ControlQuality controlQuality, List<Food> foods, List<Store> stores, Scheduler scheduler) throws SchedulerException {
        JobDataMap data = new JobDataMap();
        data.put("stores", stores);
        data.put("controlQuality", controlQuality);
        data.put("foods", foods);
        JobDetail job = newJob(SortJob.class)
                .usingJobData(data)
                .build();
        SimpleScheduleBuilder times = simpleSchedule()
                .withIntervalInSeconds(Integer.parseInt(cfg.get("time")))
                .repeatForever();
        Trigger trigger = newTrigger()
                .startNow()
                .withSchedule(times)
                .build();
        scheduler.scheduleJob(job, trigger);
    }

    public static class SortJob implements Job {

        @Override
        public void execute(JobExecutionContext context) {
            JobDataMap map = context.getJobDetail().getJobDataMap();
            List<Store> stores = (List<Store>) map.get("stores");
            List<Food> foods = (List<Food>) map.get("foods");
            ControlQuality controlQuality = (ControlQuality) map.get("controlQuality");
            controlQuality.sort(foods, stores);
            controlQuality.resort(stores);
        }
    }

    public static void main(String[] args) throws SchedulerException, ParseException {
        SortFood grab = new SortFood();
        grab.cfg();
        Scheduler scheduler = grab.scheduler();
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
        grab.init(controlQuality, foods, stores, scheduler);

    }
}
