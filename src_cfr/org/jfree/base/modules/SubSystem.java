/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.base.modules;

import org.jfree.base.modules.PackageManager;
import org.jfree.util.Configuration;
import org.jfree.util.ExtendedConfiguration;

public interface SubSystem {
    public Configuration getGlobalConfig();

    public ExtendedConfiguration getExtendedConfig();

    public PackageManager getPackageManager();
}

