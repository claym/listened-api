package io.listened.api.configuration;

import io.listened.common.model.Genre;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

/**
 * Created by Clay on 7/25/2015.
 */
@Configuration
public class RepositoryConfiguration extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Genre.class);
        config.setReturnBodyForPutAndPost(true);
        config.setReturnBodyOnCreate(true);
        config.setReturnBodyOnUpdate(true);
    }

}
