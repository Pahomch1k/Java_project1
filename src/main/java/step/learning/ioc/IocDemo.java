package step.learning.ioc;

import com.google.inject.Inject;
import step.learning.ioc.services.hash.HashService;

public class IocDemo {
    @Inject
    private HashService hashService ;

    public void run(){
        System.out.println("Ioc Demo");
        System.out.println(hashService.hash("Ioc Demo"));
    }
}
