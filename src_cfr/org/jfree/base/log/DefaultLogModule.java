/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.base.log;

import org.jfree.base.log.DefaultLog;
import org.jfree.base.log.LogConfiguration;
import org.jfree.base.modules.AbstractModule;
import org.jfree.base.modules.SubSystem;
import org.jfree.util.Configuration;
import org.jfree.util.Log;
import org.jfree.util.LogTarget;
import org.jfree.util.PrintStreamLogTarget;

public class DefaultLogModule
extends AbstractModule {
    static Class class$org$jfree$util$PrintStreamLogTarget;

    public DefaultLogModule() {
        this.loadModuleInfo();
    }

    @Override
    public void initialize(SubSystem subSystem) {
        if (LogConfiguration.isDisableLogging()) {
            return;
        }
        Class class_ = class$org$jfree$util$PrintStreamLogTarget == null ? (DefaultLogModule.class$org$jfree$util$PrintStreamLogTarget = DefaultLogModule.class$("org.jfree.util.PrintStreamLogTarget")) : class$org$jfree$util$PrintStreamLogTarget;
        if (!LogConfiguration.getLogTarget().equals(class_.getName())) return;
        DefaultLog.installDefaultLog();
        Log.getInstance().addTarget(new PrintStreamLogTarget());
        if ("true".equals(subSystem.getGlobalConfig().getConfigProperty("org.jfree.base.LogAutoInit"))) {
            Log.getInstance().init();
        }
        Log.info("Default log target started ... previous log messages could have been ignored.");
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

