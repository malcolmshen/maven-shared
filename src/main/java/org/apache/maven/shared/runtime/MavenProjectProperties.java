package org.apache.maven.shared.runtime;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.io.Serializable;

/**
 * Encapsulates the unique identifier for a Maven project.
 * <p>
 * More specifically, this object holds a project's group id, artifact id and version. This information is typically
 * generated by Maven and stored within the file
 * <code>/META-INF/maven/&lt;groupId&gt;/&lt;artifactId&gt;/pom.properties</code> in the packaged project.
 * </p>
 * 
 * @author <a href="mailto:markhobson@gmail.com">Mark Hobson</a>
 * @version $Id$
 */
public class MavenProjectProperties implements Serializable
{
    // constants --------------------------------------------------------------

    /**
     * The serial version ID.
     */
    private static final long serialVersionUID = 5233832086526764232L;

    // fields -----------------------------------------------------------------

    /**
     * The Maven project group id.
     */
    private final String groupId;

    /**
     * The Maven project artifact id.
     */
    private final String artifactId;

    /**
     * The Maven project version.
     */
    private final String version;

    // constructors -----------------------------------------------------------

    /**
     * Creates a new <code>MavenProjectProperties</code> with the specified Maven project group id, artifact id and
     * version properties.
     * 
     * @param groupId
     *            the group id, not null
     * @param artifactId
     *            the artifact id, not null
     * @param version
     *            the version, not null
     */
    public MavenProjectProperties( String groupId, String artifactId, String version )
    {
        if ( groupId == null )
            throw new IllegalArgumentException( "groupId cannot be null" );

        if ( artifactId == null )
            throw new IllegalArgumentException( "artifactId cannot be null" );

        if ( version == null )
            throw new IllegalArgumentException( "version cannot be null" );

        this.groupId = groupId;
        this.artifactId = artifactId;
        this.version = version;
    }

    // public methods ---------------------------------------------------------

    /**
     * Gets the group id for these Maven project properties.
     * 
     * @return the group id
     */
    public String getGroupId()
    {
        return groupId;
    }

    /**
     * Gets the artifact id for these Maven project properties.
     * 
     * @return the artifact id
     */
    public String getArtifactId()
    {
        return artifactId;
    }

    /**
     * Gets the version for these Maven project properties.
     * 
     * @return the version
     */
    public String getVersion()
    {
        return version;
    }

    // Object methods ---------------------------------------------------------

    /*
     * @see java.lang.Object#hashCode()
     */
    public int hashCode()
    {
        int hashCode = groupId.hashCode();

        hashCode = ( hashCode * 31 ) + artifactId.hashCode();

        hashCode = ( hashCode * 31 ) + version.hashCode();

        return hashCode;
    }

    /*
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals( Object object )
    {
        if ( !( object instanceof MavenProjectProperties ) )
            return false;

        MavenProjectProperties info = (MavenProjectProperties) object;

        return ( groupId.equals( info.getGroupId() ) && artifactId.equals( info.getArtifactId() ) && version.equals( info.getVersion() ) );
    }

    /*
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
        StringBuffer buffer = new StringBuffer();

        buffer.append( getClass().getName() );
        buffer.append( "[" );
        buffer.append( "groupId=" ).append( groupId ).append( "," );
        buffer.append( "artifactId=" ).append( artifactId ).append( "," );
        buffer.append( "version=" ).append( version );
        buffer.append( "]" );

        return buffer.toString();
    }
}
