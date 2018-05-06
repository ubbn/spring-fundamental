import com.home.repository.CustomerRepository;
import com.home.repository.CustomerRepositoryImpl;
import com.home.service.CustomerService;
import com.home.service.CustomerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    /**
     * Here dependent repository is injected through setter,
     * it can be done in constructor injector
     * @return
     */
    @Bean(name = "fooCustomerService")
    public CustomerService getCustomerService(){
        CustomerServiceImpl service = new CustomerServiceImpl();
        service.setCustomerRepository(getCustomerRepository());

        return service;
    }

    @Bean(name = "fooCustomerRepository")
    public CustomerRepository getCustomerRepository(){
        return new CustomerRepositoryImpl();
    }

}
