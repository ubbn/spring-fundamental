import com.home.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfigAnno.class);
        CustomerService customerService = appContext.getBean("fooCustomerService", CustomerService.class);

        System.out.println(customerService.findAll().get(0).getFirstname());
    }
}
