package org.jfree.base;

import org.jfree.*;
import org.jfree.base.config.*;
import org.jfree.util.*;

public class BaseBoot extends AbstractBoot
{
    private static BaseBoot singleton;
    private BootableProjectInfo bootableProjectInfo;
    static Class class$org$jfree$base$log$DefaultLogModule;
    
    private BaseBoot() {
        this.bootableProjectInfo = JCommon.INFO;
    }
    
    public static ModifiableConfiguration getConfiguration() {
        return (ModifiableConfiguration)getInstance().getGlobalConfig();
    }
    
    protected synchronized Configuration loadConfiguration() {
        return this.createDefaultHierarchicalConfiguration("/org/jfree/base/jcommon.properties", "/jcommon.properties", true);
    }
    
    public static synchronized AbstractBoot getInstance() {
        if (BaseBoot.singleton == null) {
            BaseBoot.singleton = new BaseBoot();
        }
        return BaseBoot.singleton;
    }
    
    protected void performBoot() {
        ObjectUtilities.setClassLoaderSource(getConfiguration().getConfigProperty("org.jfree.ClassLoader"));
        this.getPackageManager().addModule(((BaseBoot.class$org$jfree$base$log$DefaultLogModule == null) ? (BaseBoot.class$org$jfree$base$log$DefaultLogModule = class$("org.jfree.base.log.DefaultLogModule")) : BaseBoot.class$org$jfree$base$log$DefaultLogModule).getName());
        this.getPackageManager().load("org.jfree.jcommon.modules.");
        this.getPackageManager().initializeModules();
    }
    
    protected BootableProjectInfo getProjectInfo() {
        return this.bootableProjectInfo;
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
