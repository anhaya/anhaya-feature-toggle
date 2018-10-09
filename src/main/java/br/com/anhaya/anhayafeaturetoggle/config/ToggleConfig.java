package br.com.anhaya.anhayafeaturetoggle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.togglz.core.Feature;
import org.togglz.core.manager.TogglzConfig;
import org.togglz.core.repository.StateRepository;
import org.togglz.core.repository.file.FileBasedStateRepository;
import org.togglz.core.user.NoOpUserProvider;
import org.togglz.core.user.UserProvider;

import java.io.File;

@Configuration
public class ToggleConfig implements TogglzConfig {

    @Bean
    public Class<? extends Feature> getFeatureClass() {
        return AvailableFeatures.class;
    }

    @Bean
    public StateRepository getStateRepository() {
        return new FileBasedStateRepository(new File("features.properties"));
    }

    @Bean
    public UserProvider getUserProvider() {
        return new NoOpUserProvider();
    }
}
