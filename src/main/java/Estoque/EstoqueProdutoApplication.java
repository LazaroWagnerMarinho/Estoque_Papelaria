package Estoque;

import Estoque.db.EstoqueDao;
import Estoque.health.DatabaseHealthCheck;
import Estoque.resources.EstoqueResource;
import Estoque.resources.HtmlPageResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

public class EstoqueProdutoApplication extends Application<EstoqueProdutoConfiguration> {

    public static void main(String[] args) throws Exception {
        new EstoqueProdutoApplication().run(args);
    }

    @Override
    public void initialize(final Bootstrap<EstoqueProdutoConfiguration> bootstrap) {
        bootstrap.addBundle(new MigrationsBundle<EstoqueProdutoConfiguration>() {
            @Override
            public PooledDataSourceFactory getDataSourceFactory(final EstoqueProdutoConfiguration configuration){
                return configuration.getDataSourceFactory();
            }
        });
        bootstrap.addBundle(new AssetsBundle("/assets/"));
    }

    @Override
    public void run(final EstoqueProdutoConfiguration configuration,
                    final Environment environment) throws Exception{
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment,configuration.getDataSourceFactory(),"mysql");
        final EstoqueDao dao = jdbi.onDemand(EstoqueDao.class);

        environment.jersey().register(new HtmlPageResource());
        environment.jersey().register(new EstoqueResource(dao));

        environment.healthChecks().register("health",
                new DatabaseHealthCheck(jdbi, configuration.getDataSourceFactory().getValidationQuery()));
    }


    @Override
    public String getName() {
        return "EstoqueProduto";
    }
}
