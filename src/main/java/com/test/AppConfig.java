package com.test;

//import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import lombok.Getter;


    public class AppConfig extends Configuration {

        @JsonProperty("swagger")
        public SwaggerBundleConfiguration swaggerBundleConfiguration = new SwaggerBundleConfiguration();

        @Getter
        @JsonProperty("db")
        private final DataSourceFactory dataSourceFactory = new DataSourceFactory();


    }
