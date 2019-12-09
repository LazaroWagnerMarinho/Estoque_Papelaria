package Estoque.health;

import com.codahale.metrics.health.HealthCheck;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;

public class DatabaseHealthCheck extends HealthCheck {

    private final DBI dbi;
    private final String validationQuery;

    public DatabaseHealthCheck(DBI dbi, String validationQuery) {
        this.dbi = dbi;
        this.validationQuery = validationQuery;
    }

    @Override
    protected HealthCheck.Result check() {

        try {
            final Handle handle = dbi.open();

            handle.execute(validationQuery);

            handle.close();
        } catch (Exception e) {
            return HealthCheck.Result.unhealthy("Database is not running!");
        }

        return HealthCheck.Result.healthy();
    }
}
