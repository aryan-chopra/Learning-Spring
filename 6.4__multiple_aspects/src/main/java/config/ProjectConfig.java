package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan(
        basePackages = {"services", "aspects"}
)
@EnableAspectJAutoProxy
public class ProjectConfig {
}
