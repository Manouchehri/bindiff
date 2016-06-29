/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.util;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Iterator;

public interface Configuration
extends Serializable,
Cloneable {
    public String getConfigProperty(String var1);

    public String getConfigProperty(String var1, String var2);

    public Iterator findPropertyKeys(String var1);

    public Enumeration getConfigProperties();

    public Object clone();
}

