package org.jfree.base.log;

import org.jfree.base.modules.*;
import org.jfree.util.*;

public class DefaultLogModule extends AbstractModule
{
    static Class class$org$jfree$util$PrintStreamLogTarget;
    
    public DefaultLogModule() {
        this.loadModuleInfo();
    }
    
    public void initialize(final SubSystem subSystem) {
        if (LogConfiguration.isDisableLogging()) {
            return;
        }
        if (LogConfiguration.getLogTarget().equals(((DefaultLogModule.class$org$jfree$util$PrintStreamLogTarget == null) ? (DefaultLogModule.class$org$jfree$util$PrintStreamLogTarget = class$("org.jfree.util.PrintStreamLogTarget")) : DefaultLogModule.class$org$jfree$util$PrintStreamLogTarget).getName())) {
            DefaultLog.installDefaultLog();
            Log.getInstance().addTarget(new PrintStreamLogTarget());
            if ("true".equals(subSystem.getGlobalConfig().getConfigProperty("org.jfree.base.LogAutoInit"))) {
                Log.getInstance().init();
            }
            Log.info("Default log target started ... previous log messages could have been ignored.");
        }
    }
    
    static Class class$(final String s) {
        try {
            return Class.forName(s);
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
}
