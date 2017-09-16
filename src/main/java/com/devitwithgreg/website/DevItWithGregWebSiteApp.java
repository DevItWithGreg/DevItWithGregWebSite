package com.devitwithgreg.website;

import com.devitwithgreg.website.config.ApplicationProperties;
import com.devitwithgreg.website.config.DefaultProfileUtil;
import com.devitwithgreg.website.config.serviceExecutor.ServiceExecutorProperties;
import com.devitwithgreg.website.service.cache.YouTubeCacheService;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.scheduledexecutor.IScheduledExecutorService;
import io.github.jhipster.config.JHipsterConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.MetricFilterAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.MetricRepositoryAutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.hazelcast.HazelcastAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

@ComponentScan
@EnableAutoConfiguration(exclude = {MetricFilterAutoConfiguration.class, MetricRepositoryAutoConfiguration.class, HazelcastAutoConfiguration.class})
@EnableConfigurationProperties({ApplicationProperties.class})
public class DevItWithGregWebSiteApp {

    private static final Logger log = LoggerFactory.getLogger(DevItWithGregWebSiteApp.class);

    private final Environment env;

    private YouTubeCacheService youTubeCacheService;

    private HazelcastInstance hazelcastInstance;

    private ServiceExecutorProperties serviceExecutorProperties;


    public DevItWithGregWebSiteApp(Environment env, YouTubeCacheService youTubeCacheService, HazelcastInstance hazelcastInstance, ServiceExecutorProperties serviceExecutorProperties) {
        this.env = env;
        this.youTubeCacheService = youTubeCacheService;
        this.hazelcastInstance = hazelcastInstance;
        this.serviceExecutorProperties = serviceExecutorProperties;
    }

    /**
     * Initializes DevItWithGregWebSite.
     * <p>
     * Spring profiles can be configured with a program arguments --spring.profiles.active=your-active-profile
     * <p>
     * You can find more information on how profiles work with JHipster on <a href="https://jhipster.github.io/profiles/">https://jhipster.github.io/profiles/</a>.
     */
    @PostConstruct
    public void initApplication() {
        Collection<String> activeProfiles = Arrays.asList(env.getActiveProfiles());
        if (activeProfiles.contains(JHipsterConstants.SPRING_PROFILE_DEVELOPMENT) && activeProfiles.contains(JHipsterConstants.SPRING_PROFILE_PRODUCTION)) {
            log.error("You have misconfigured your application! It should not run " +
                "with both the 'dev' and 'prod' profiles at the same time.");
        }
        if (activeProfiles.contains(JHipsterConstants.SPRING_PROFILE_DEVELOPMENT) && activeProfiles.contains(JHipsterConstants.SPRING_PROFILE_CLOUD)) {
            log.error("You have misconfigured your application! It should not " +
                "run with both the 'dev' and 'cloud' profiles at the same time.");
        }

        IScheduledExecutorService executorService = hazelcastInstance.getScheduledExecutorService(this.serviceExecutorProperties.getServiceExecutorName());
        executorService.scheduleOnMemberAtFixedRate(youTubeCacheService.getYouTubeChannelUpdater(), hazelcastInstance.getCluster().getLocalMember(), 0, this.serviceExecutorProperties.getExecutionDelay(), TimeUnit.MINUTES);
    }

    /**
     * Main method, used to run the application.
     *
     * @param args the command line arguments
     * @throws UnknownHostException if the local host name could not be resolved into an address
     */
    public static void main(String[] args) throws UnknownHostException {
        SpringApplication app = new SpringApplication(DevItWithGregWebSiteApp.class);
        DefaultProfileUtil.addDefaultProfile(app);
        Environment env = app.run(args).getEnvironment();
        String protocol = "http";
        if (env.getProperty("server.ssl.key-store") != null) {
            protocol = "https";
        }
        log.info("\n----------------------------------------------------------\n\t" +
                "Application '{}' is running! Access URLs:\n\t" +
                "Local: \t\t{}://localhost:{}\n\t" +
                "External: \t{}://{}:{}\n\t" +
                "Profile(s): \t{}\n----------------------------------------------------------",
            env.getProperty("spring.application.name"),
            protocol,
            env.getProperty("server.port"),
            protocol,
            InetAddress.getLocalHost().getHostAddress(),
            env.getProperty("server.port"),
            env.getActiveProfiles());
    }
}
