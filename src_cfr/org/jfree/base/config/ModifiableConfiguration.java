/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.base.config;

import java.util.Enumeration;
import java.util.Iterator;
import org.jfree.util.Configuration;

public interface ModifiableConfiguration
extends Configuration {
    public void setConfigProperty(String var1, String var2);

    @Override
    public Enumeration getConfigProperties();

    @Override
    public Iterator findPropertyKeys(String var1);
}

