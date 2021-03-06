/*
 * Copyright (c) 2002-2019 "Neo4j,"
 * Neo4j Sweden AB [http://neo4j.com]
 *
 * This file is part of Neo4j.
 *
 * Neo4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.neo4j.server.plugins;

import org.apache.commons.configuration.AbstractConfiguration;

import java.util.Iterator;

import org.neo4j.kernel.configuration.Config;

/**
 * @deprecated Server plugins are deprecated for removal in the next major release. Please use unmanaged extensions instead.
 */
@Deprecated
public class ConfigAdapter extends AbstractConfiguration
{
    private final Config config;

    @Deprecated
    public ConfigAdapter( Config config )
    {
        this.config = config;
    }

    @Deprecated
    @Override
    public boolean isEmpty()
    {
        // non-null config is always non-empty as some properties have default values
        return config == null;
    }

    @Deprecated
    @Override
    public boolean containsKey( String key )
    {
        return config.getValue( key ).isPresent();
    }

    @Deprecated
    @Override
    public Object getProperty( String key )
    {
        return config.getValue( key ).orElse( null );
    }

    @Deprecated
    @Override
    public Iterator<String> getKeys()
    {
        return config.getConfigValues().keySet().iterator();
    }

    @Deprecated
    @Override
    protected void addPropertyDirect( String key, Object value )
    {
        config.augment( key, value.toString() );
    }
}
