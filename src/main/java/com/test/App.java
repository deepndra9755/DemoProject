package com.test;

import com.test.api.EmployeeResource;
import com.test.api.StudentResource;
//import com.test.api.UserResource;
import com.test.api.UserResource;
import com.test.dao.IEmpDaoImpl;
import com.test.dao.StudentDaoImpl;
import com.test.dao.UserAddressDao;
import com.test.dao.UserDao;
import com.test.service.EmpServiceImpl;
import com.test.service.StudentServiceImpl;
import com.test.service.UserService;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.db.ManagedDataSource;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import lombok.NonNull;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.postgres.PostgresPlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import javax.sql.DataSource;
import java.text.SimpleDateFormat;

public class App extends Application<AppConfig> {

    private Jdbi jdbi;

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    @Override
    public void run(AppConfig configuration, Environment environment) throws Exception {

        // db
        final DataSourceFactory dataSourceFactory = configuration.getDataSourceFactory();
        final DataSource dataSource = dataSourceFactory.build(environment.metrics(), "test");
        this.initJdbi(configuration, environment, dataSource);

        // Employee
        final IEmpDaoImpl iEmpDao = jdbi.onDemand(IEmpDaoImpl.class);
        final EmpServiceImpl empService = new EmpServiceImpl(iEmpDao);
        environment.jersey().register(new EmployeeResource(empService));

        //Student
        final StudentDaoImpl studentDao = jdbi.onDemand(StudentDaoImpl.class);
        final StudentServiceImpl studentService = new StudentServiceImpl(studentDao);
        environment.jersey().register(new StudentResource(studentService));

        //User
        final UserDao userDao = jdbi.onDemand(UserDao.class);
        final UserAddressDao userAddressDao = jdbi.onDemand(UserAddressDao.class);
        final UserService userService = new UserService(userDao, userAddressDao);
        environment.jersey().register(new UserResource(userService));
        environment.getObjectMapper().setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));

        // New Exception Mapper
        environment.jersey().register(new MetisExceptionMapper());

    }

    @Override
    public void initialize(Bootstrap<AppConfig> bootstrap) {
//         Swagger
        // Swagger config
        bootstrap.addBundle(new AssetsBundle("/myassets"));
        bootstrap.addBundle(
                new SwaggerBundle<AppConfig>() {
                    @Override
                    protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(
                            AppConfig configuration) {
                        return configuration.swaggerBundleConfiguration;
                    }
                });

    }

    private void initJdbi(@NonNull AppConfig config, @NonNull Environment environment, DataSource source) {
        JdbiFactory factory = new JdbiFactory();
        this.jdbi = factory.build(environment, config.getDataSourceFactory(),
                        (ManagedDataSource) source, "postgresql")
                .installPlugin(new SqlObjectPlugin())
                .installPlugin(new PostgresPlugin());
        jdbi.registerArrayType(String.class, "text");
    }

}
