/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.base;

import org.jfree.JCommon;
import org.jfree.base.AbstractBoot;
import org.jfree.base.BootableProjectInfo;
import org.jfree.base.config.ModifiableConfiguration;
import org.jfree.base.modules.PackageManager;
import org.jfree.ui.about.ProjectInfo;
import org.jfree.util.Configuration;
import org.jfree.util.ObjectUtilities;

public class BaseBoot
extends AbstractBoot {
    private static BaseBoot singleton;
    private BootableProjectInfo bootableProjectInfo = JCommon.INFO;
    static Class class$org$jfree$base$log$DefaultLogModule;

    private BaseBoot() {
    }

    public static ModifiableConfiguration getConfiguration() {
        return (ModifiableConfiguration)BaseBoot.getInstance().getGlobalConfig();
    }

    @Override
    protected synchronized Configuration loadConfiguration() {
        return this.createDefaultHierarchicalConfiguration("/org/jfree/base/jcommon.properties", "/jcommon.properties", true);
    }

    public static synchronized AbstractBoot getInstance() {
        if (singleton != null) return singleton;
        singleton = new BaseBoot();
        return singleton;
    }

    @Override
    protected void performBoot() {
        ObjectUtilities.setClassLoaderSource(BaseBoot.getConfiguration().getConfigProperty("org.jfree.ClassLoader"));
        Class class_ = class$org$jfree$base$log$DefaultLogModule == null ? (BaseBoot.class$org$jfree$base$log$DefaultLogModule = BaseBoot.class$("org.jfree.base.log.DefaultLogModule")) : class$org$jfree$base$log$DefaultLogModule;
        this.getPackageManager().addModule(class_.getName());
        this.getPackageManager().load("org.jfree.jcommon.modules.");
        this.getPackageManager().initializeModules();
    }

    @Override
    protected BootableProjectInfo getProjectInfo() {
        return this.bootableProjectInfo;
    }

    static Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException var1_1) {
            throw new NoClassDefFoundError(var1_1.getMessage());
        }
    }
}

