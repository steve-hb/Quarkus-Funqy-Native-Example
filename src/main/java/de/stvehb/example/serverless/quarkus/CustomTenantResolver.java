package de.stvehb.example.serverless.quarkus;

import io.agroal.api.AgroalDataSource;
import io.quarkus.agroal.DataSource;
import io.quarkus.arc.Arc;
import io.quarkus.hibernate.orm.runtime.customized.QuarkusConnectionProvider;
import io.quarkus.hibernate.orm.runtime.tenant.TenantConnectionResolver;
import io.quarkus.hibernate.orm.runtime.tenant.TenantResolver;
import io.vertx.ext.web.RoutingContext;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.UUID;

/**
 * This class is responsible for managing the multi-tenant multi-database handling.
 * If you don't want to support this handling, just delete this class.
 */
@RequestScoped
public class CustomTenantResolver implements TenantResolver, TenantConnectionResolver {

	@Inject
	private RoutingContext routingContext;

	@Override
	public String getDefaultTenantId() {
		return null; // "base"
	}

	@Override
	public String resolveTenantId() {
		return UUID.randomUUID().toString(); // Resolve tenant id based on routing context
	}

	@Override
	public ConnectionProvider resolve(String tenantId) {
		// TODO: Create database if not exists
		return new QuarkusConnectionProvider(Arc.container().instance(AgroalDataSource.class, new DataSource.DataSourceLiteral(tenantId)).get());
	}
}
