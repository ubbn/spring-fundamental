import com.home.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
        CustomerService service = appContext.getBean("fooCustomerService", CustomerService.class);

        System.out.println(service.findAll().get(0).getLastName());
    }
}
