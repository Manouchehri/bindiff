/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.util;

import org.jfree.util.Configuration;

public interface ExtendedConfiguration
extends Configuration {
    public boolean isPropertySet(String var1);

    public int getIntProperty(String var1);

    public int getIntProperty(String var1, int var2);

    public boolean getBoolProperty(String var1);

    public boolean getBoolProperty(String var1, boolean var2);
}

