package com.brokencodes.vd.configurations;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;

public class VdNamingStrategy extends SpringPhysicalNamingStrategy {

    private static final String PREFIX = "vd_";

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return new Identifier(PREFIX + super.toPhysicalTableName(name, jdbcEnvironment).getText(), name.isQuoted());
    }

}
