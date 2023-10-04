package step.learning;

import com.google.inject.Guice;
import com.google.inject.Injector;
import step.learning.ioc.ConfigModule;
import step.learning.ioc.IocDemo;
import step.learning.async.AsyncDemo;
import step.learning.async.TaskDemo;
import step.learning.DZ.Dz_8.NumberAppenderTask;
import step.learning.DZ.Dz_9.InflationCalculator;



public class App {
    public static void main(String[] args) {
        //Injector injector = Guice.createInjector(new ConfigModule());
        //IocDemo iocDemo = injector.getInstance(IocDemo.class);
        //iocDemo.run();

        Guice.createInjector(new ConfigModule()).getInstance(TaskDemo.class).run();
    }
}