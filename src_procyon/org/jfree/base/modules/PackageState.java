package org.jfree.base.modules;

import org.jfree.util.*;

public class PackageState
{
    public static final int STATE_NEW = 0;
    public static final int STATE_CONFIGURED = 1;
    public static final int STATE_INITIALIZED = 2;
    public static final int STATE_ERROR = -2;
    private final Module module;
    private int state;
    
    public PackageState(final Module module) {
        this(module, 0);
    }
    
    public PackageState(final Module module, final int state) {
        if (module == null) {
            throw new NullPointerException("Module must not be null.");
        }
        if (state != 1 && state != -2 && state != 2 && state != 0) {
            throw new IllegalArgumentException("State is not valid");
        }
        this.module = module;
        this.state = state;
    }
    
    public boolean configure(final SubSystem subSystem) {
        if (this.state == 0) {
            try {
                this.module.configure(subSystem);
                this.state = 1;
                return true;
            }
            catch (NoClassDefFoundError noClassDefFoundError) {
                Log.warn(new Log$SimpleMessage("Unable to load module classes for ", this.module.getName(), ":", noClassDefFoundError.getMessage()));
                this.state = -2;
            }
            catch (Exception ex) {
                if (Log.isDebugEnabled()) {
                    Log.warn("Unable to configure the module " + this.module.getName(), ex);
                }
                else if (Log.isWarningEnabled()) {
                    Log.warn("Unable to configure the module " + this.module.getName());
                }
                this.state = -2;
            }
        }
        return false;
    }
    
    public Module getModule() {
        return this.module;
    }
    
    public int getState() {
        return this.state;
    }
    
    public boolean initialize(final SubSystem subSystem) {
        if (this.state == 1) {
            try {
                this.module.initialize(subSystem);
                this.state = 2;
                return true;
            }
            catch (NoClassDefFoundError noClassDefFoundError) {
                Log.warn(new Log$SimpleMessage("Unable to load module classes for ", this.module.getName(), ":", noClassDefFoundError.getMessage()));
                this.state = -2;
            }
            catch (ModuleInitializeException ex) {
                if (Log.isDebugEnabled()) {
                    Log.warn("Unable to initialize the module " + this.module.getName(), ex);
                }
                else if (Log.isWarningEnabled()) {
                    Log.warn("Unable to initialize the module " + this.module.getName());
                }
                this.state = -2;
            }
            catch (Exception ex2) {
                if (Log.isDebugEnabled()) {
                    Log.warn("Unable to initialize the module " + this.module.getName(), ex2);
                }
                else if (Log.isWarningEnabled()) {
                    Log.warn("Unable to initialize the module " + this.module.getName());
                }
                this.state = -2;
            }
        }
        return false;
    }
    
    public boolean equals(final Object o) {
        return this == o || (o instanceof PackageState && this.module.getModuleClass().equals(((PackageState)o).module.getModuleClass()));
    }
    
    public int hashCode() {
        return this.module.hashCode();
    }
}
