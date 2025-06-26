package config;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan(
        basePackages = {"proxies", "repositories", "services", "utils"}
)
public class ProjectConfig {
}
