package step.learning.ioc;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import step.learning.ioc.services.hash.HashService;

public class IocDemo {
    private final HashService md5HashService;
    private final HashService sha256HashService;

    @Inject
    public IocDemo(@Named("MD5") HashService md5HashService, @Named("SHA256") HashService sha256HashService) {
        this.md5HashService = md5HashService;
        this.sha256HashService = sha256HashService;
    }

    public void run() {
        System.out.println("Ioc Demo");
        System.out.println("MD5: " + md5HashService.hash("Ioc Demo"));
        System.out.println("SHA256: " + sha256HashService.hash("Ioc Demo"));
    }
}