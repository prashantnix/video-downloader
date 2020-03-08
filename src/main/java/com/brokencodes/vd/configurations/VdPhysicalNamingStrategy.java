package com.brokencodes.vd.configurations;

import org.apache.commons.text.WordUtils;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

import java.text.MessageFormat;

public class VdPhysicalNamingStrategy implements PhysicalNamingStrategy {

    private static final String TABLE_NAME_PREFIX = "VD";

    @Override
    public Identifier toPhysicalCatalogName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return null;
    }

    @Override
    public Identifier toPhysicalSchemaName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return null;
    }

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return Identifier.toIdentifier(
                MessageFormat.format(
                        "{0}_{1}",
                        TABLE_NAME_PREFIX,
                        WordUtils.capitalizeFully(name.getText())
                ).toUpperCase()
        );
    }

    @Override
    public Identifier toPhysicalSequenceName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return null;
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return null;
    }

}
