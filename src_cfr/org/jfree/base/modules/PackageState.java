/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.base.modules;

import org.jfree.base.modules.Module;
import org.jfree.base.modules.ModuleInitializeException;
import org.jfree.base.modules.SubSystem;
import org.jfree.util.Log;
import org.jfree.util.Log$SimpleMessage;

public class PackageState {
    public static final int STATE_NEW = 0;
    public static final int STATE_CONFIGURED = 1;
    public static final int STATE_INITIALIZED = 2;
    public static final int STATE_ERROR = -2;
    private final Module module;
    private int state;

    public PackageState(Module module) {
        this(module, 0);
    }

    public PackageState(Module module, int n2) {
        if (module == null) {
            throw new NullPointerException("Module must not be null.");
        }
        if (n2 != 1 && n2 != -2 && n2 != 2 && n2 != 0) {
            throw new IllegalArgumentException("State is not valid");
        }
        this.module = module;
        this.state = n2;
    }

    public boolean configure(SubSystem subSystem) {
        if (this.state != 0) return false;
        try {
            this.module.configure(subSystem);
            this.state = 1;
            return true;
        }
        catch (NoClassDefFoundError var2_2) {
            Log.warn(new Log$SimpleMessage("Unable to load module classes for ", this.module.getName(), ":", var2_2.getMessage()));
            this.state = -2;
            return false;
        }
        catch (Exception var2_3) {
            if (Log.isDebugEnabled()) {
                Log.warn(new StringBuffer().append("Unable to configure the module ").append(this.module.getName()).toString(), var2_3);
            } else if (Log.isWarningEnabled()) {
                Log.warn(new StringBuffer().append("Unable to configure the module ").append(this.module.getName()).toString());
            }
            this.state = -2;
        }
        return false;
    }

    public Module getModule() {
        return this.module;
    }

    public int getState() {
        return this.state;
    }

    public boolean initialize(SubSystem subSystem) {
        if (this.state != 1) return false;
        try {
            this.module.initialize(subSystem);
            this.state = 2;
            return true;
        }
        catch (NoClassDefFoundError var2_2) {
            Log.warn(new Log$SimpleMessage("Unable to load module classes for ", this.module.getName(), ":", var2_2.getMessage()));
            this.state = -2;
            return false;
        }
        catch (ModuleInitializeException var2_3) {
            if (Log.isDebugEnabled()) {
                Log.warn(new StringBuffer().append("Unable to initialize the module ").append(this.module.getName()).toString(), var2_3);
            } else if (Log.isWarningEnabled()) {
                Log.warn(new StringBuffer().append("Unable to initialize the module ").append(this.module.getName()).toString());
            }
            this.state = -2;
            return false;
        }
        catch (Exception var2_4) {
            if (Log.isDebugEnabled()) {
                Log.warn(new StringBuffer().append("Unable to initialize the module ").append(this.module.getName()).toString(), var2_4);
            } else if (Log.isWarningEnabled()) {
                Log.warn(new StringBuffer().append("Unable to initialize the module ").append(this.module.getName()).toString());
            }
            this.state = -2;
        }
        return false;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PackageState)) {
            return false;
        }
        PackageState packageState = (PackageState)object;
        if (this.module.getModuleClass().equals(packageState.module.getModuleClass())) return true;
        return false;
    }

    public int hashCode() {
        return this.module.hashCode();
    }
}

