import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Spring automatically scans give package, so need to specify each bean separately
 */
@Configuration
@ComponentScan({"com.home"})
public class AppConfigAnno {
}
