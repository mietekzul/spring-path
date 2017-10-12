package config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class ServiceConfiguration {

    @Autowired
    public IClientConfig ribbonClientConfig;

    @Bean
    public IPing ping(IClientConfig config) {
        return new PingUrl();
    }

    @Bean
    public IRule rule(IClientConfig config) {
        return new AvailabilityFilteringRule();
    }
}
