/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.util;

import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import java.util.TreeSet;
import org.jfree.base.config.ModifiableConfiguration;

public class DefaultConfiguration
extends Properties
implements ModifiableConfiguration {
    @Override
    public String getConfigProperty(String string) {
        return this.getProperty(string);
    }

    @Override
    public String getConfigProperty(String string, String string2) {
        return this.getProperty(string, string2);
    }

    @Override
    public Iterator findPropertyKeys(String string) {
        TreeSet<String> treeSet = new TreeSet<String>();
        Enumeration enumeration = this.keys();
        while (enumeration.hasMoreElements()) {
            String string2 = (String)enumeration.nextElement();
            if (!string2.startsWith(string) || treeSet.contains(string2)) continue;
            treeSet.add(string2);
        }
        return Collections.unmodifiableSet(treeSet).iterator();
    }

    @Override
    public Enumeration getConfigProperties() {
        return this.keys();
    }

    @Override
    public void setConfigProperty(String string, String string2) {
        if (string2 == null) {
            this.remove(string);
            return;
        }
        this.setProperty(string, string2);
    }
}

