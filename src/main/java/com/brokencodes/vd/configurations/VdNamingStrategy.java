package com.brokencodes.vd.configurations;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;

import java.text.MessageFormat;

/**
 * Adds vd_ as prefix for all table names - even when you provide a custom name for the table. For example,
 * <code>
 *      @JoinTable(name = "vd_tab_name", ...)
 *      private Set<TabName> tabName;
 * </code>
 * translates the name to: <code>vd_vd_tab_name</code>
 */
public class VdNamingStrategy extends SpringPhysicalNamingStrategy {

    private static final String TABLE_NAME_FORMAT = "vd_{0}";

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return new Identifier(
                MessageFormat.format(
                        TABLE_NAME_FORMAT,
                        super.toPhysicalTableName(name, jdbcEnvironment).getText()),
                name.isQuoted());
    }

}
