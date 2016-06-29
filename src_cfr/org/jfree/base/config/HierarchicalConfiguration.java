/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.base.config;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import java.util.TreeSet;
import org.jfree.base.config.ModifiableConfiguration;
import org.jfree.util.Configuration;
import org.jfree.util.PublicCloneable;

public class HierarchicalConfiguration
implements ModifiableConfiguration,
PublicCloneable {
    private Properties configuration = new Properties();
    private transient Configuration parentConfiguration;

    public HierarchicalConfiguration() {
    }

    public HierarchicalConfiguration(Configuration configuration) {
        this();
        this.parentConfiguration = configuration;
    }

    @Override
    public String getConfigProperty(String string) {
        return this.getConfigProperty(string, null);
    }

    @Override
    public String getConfigProperty(String string, String string2) {
        String string3 = this.configuration.getProperty(string);
        if (string3 != null) return string3;
        if (!this.isRootConfig()) return this.parentConfiguration.getConfigProperty(string, string2);
        return string2;
    }

    @Override
    public void setConfigProperty(String string, String string2) {
        if (string == null) {
            throw new NullPointerException();
        }
        if (string2 == null) {
            this.configuration.remove(string);
            return;
        }
        this.configuration.setProperty(string, string2);
    }

    private boolean isRootConfig() {
        if (this.parentConfiguration != null) return false;
        return true;
    }

    public boolean isLocallyDefined(String string) {
        return this.configuration.containsKey(string);
    }

    protected Properties getConfiguration() {
        return this.configuration;
    }

    public void insertConfiguration(HierarchicalConfiguration hierarchicalConfiguration) {
        hierarchicalConfiguration.setParentConfig(this.getParentConfig());
        this.setParentConfig(hierarchicalConfiguration);
    }

    protected void setParentConfig(Configuration configuration) {
        if (this.parentConfiguration == this) {
            throw new IllegalArgumentException("Cannot add myself as parent configuration.");
        }
        this.parentConfiguration = configuration;
    }

    protected Configuration getParentConfig() {
        return this.parentConfiguration;
    }

    @Override
    public Enumeration getConfigProperties() {
        return this.configuration.keys();
    }

    @Override
    public Iterator findPropertyKeys(String string) {
        TreeSet treeSet = new TreeSet();
        this.collectPropertyKeys(string, this, treeSet);
        return Collections.unmodifiableSet(treeSet).iterator();
    }

    private void collectPropertyKeys(String string, Configuration configuration, TreeSet treeSet) {
        Enumeration enumeration = configuration.getConfigProperties();
        do {
            Object object;
            if (!enumeration.hasMoreElements()) {
                if (!(configuration instanceof HierarchicalConfiguration)) return;
                object = (HierarchicalConfiguration)configuration;
                if (object.parentConfiguration == null) return;
                this.collectPropertyKeys(string, object.parentConfiguration, treeSet);
                return;
            }
            object = (String)enumeration.nextElement();
            if (!object.startsWith(string) || treeSet.contains(object)) continue;
            treeSet.add(object);
        } while (true);
    }

    protected boolean isParentSaved() {
        return true;
    }

    protected void configurationLoaded() {
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        if (!this.isParentSaved()) {
            objectOutputStream.writeBoolean(false);
            return;
        }
        objectOutputStream.writeBoolean(true);
        objectOutputStream.writeObject(this.parentConfiguration);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        boolean bl2 = objectInputStream.readBoolean();
        this.parentConfiguration = bl2 ? (ModifiableConfiguration)objectInputStream.readObject() : null;
        this.configurationLoaded();
    }

    @Override
    public Object clone() {
        HierarchicalConfiguration hierarchicalConfiguration = (HierarchicalConfiguration)super.clone();
        hierarchicalConfiguration.configuration = (Properties)this.configuration.clone();
        return hierarchicalConfiguration;
    }
}

