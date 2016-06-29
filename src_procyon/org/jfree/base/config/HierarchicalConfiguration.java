package org.jfree.base.config;

import org.jfree.util.*;
import java.util.*;
import java.io.*;

public class HierarchicalConfiguration implements ModifiableConfiguration, PublicCloneable
{
    private Properties configuration;
    private transient Configuration parentConfiguration;
    
    public HierarchicalConfiguration() {
        this.configuration = new Properties();
    }
    
    public HierarchicalConfiguration(final Configuration parentConfiguration) {
        this();
        this.parentConfiguration = parentConfiguration;
    }
    
    public String getConfigProperty(final String s) {
        return this.getConfigProperty(s, null);
    }
    
    public String getConfigProperty(final String s, final String s2) {
        String s3 = this.configuration.getProperty(s);
        if (s3 == null) {
            if (this.isRootConfig()) {
                s3 = s2;
            }
            else {
                s3 = this.parentConfiguration.getConfigProperty(s, s2);
            }
        }
        return s3;
    }
    
    public void setConfigProperty(final String s, final String s2) {
        if (s == null) {
            throw new NullPointerException();
        }
        if (s2 == null) {
            this.configuration.remove(s);
        }
        else {
            this.configuration.setProperty(s, s2);
        }
    }
    
    private boolean isRootConfig() {
        return this.parentConfiguration == null;
    }
    
    public boolean isLocallyDefined(final String s) {
        return this.configuration.containsKey(s);
    }
    
    protected Properties getConfiguration() {
        return this.configuration;
    }
    
    public void insertConfiguration(final HierarchicalConfiguration parentConfig) {
        parentConfig.setParentConfig(this.getParentConfig());
        this.setParentConfig(parentConfig);
    }
    
    protected void setParentConfig(final Configuration parentConfiguration) {
        if (this.parentConfiguration == this) {
            throw new IllegalArgumentException("Cannot add myself as parent configuration.");
        }
        this.parentConfiguration = parentConfiguration;
    }
    
    protected Configuration getParentConfig() {
        return this.parentConfiguration;
    }
    
    public Enumeration getConfigProperties() {
        return this.configuration.keys();
    }
    
    public Iterator findPropertyKeys(final String s) {
        final TreeSet<Object> set = new TreeSet<Object>();
        this.collectPropertyKeys(s, this, set);
        return Collections.unmodifiableSet((Set<?>)set).iterator();
    }
    
    private void collectPropertyKeys(final String s, final Configuration configuration, final TreeSet set) {
        final Enumeration configProperties = configuration.getConfigProperties();
        while (configProperties.hasMoreElements()) {
            final String s2 = configProperties.nextElement();
            if (s2.startsWith(s) && !set.contains(s2)) {
                set.add(s2);
            }
        }
        if (configuration instanceof HierarchicalConfiguration) {
            final HierarchicalConfiguration hierarchicalConfiguration = (HierarchicalConfiguration)configuration;
            if (hierarchicalConfiguration.parentConfiguration != null) {
                this.collectPropertyKeys(s, hierarchicalConfiguration.parentConfiguration, set);
            }
        }
    }
    
    protected boolean isParentSaved() {
        return true;
    }
    
    protected void configurationLoaded() {
    }
    
    private void writeObject(final ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        if (!this.isParentSaved()) {
            objectOutputStream.writeBoolean(false);
        }
        else {
            objectOutputStream.writeBoolean(true);
            objectOutputStream.writeObject(this.parentConfiguration);
        }
    }
    
    private void readObject(final ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        if (objectInputStream.readBoolean()) {
            this.parentConfiguration = (ModifiableConfiguration)objectInputStream.readObject();
        }
        else {
            this.parentConfiguration = null;
        }
        this.configurationLoaded();
    }
    
    public Object clone() {
        final HierarchicalConfiguration hierarchicalConfiguration = (HierarchicalConfiguration)super.clone();
        hierarchicalConfiguration.configuration = (Properties)this.configuration.clone();
        return hierarchicalConfiguration;
    }
}
