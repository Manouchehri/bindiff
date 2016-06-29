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

   public PackageState(Module var1) {
      this(var1, 0);
   }

   public PackageState(Module var1, int var2) {
      if(var1 == null) {
         throw new NullPointerException("Module must not be null.");
      } else if(var2 != 1 && var2 != -2 && var2 != 2 && var2 != 0) {
         throw new IllegalArgumentException("State is not valid");
      } else {
         this.module = var1;
         this.state = var2;
      }
   }

   public boolean configure(SubSystem var1) {
      if(this.state == 0) {
         try {
            this.module.configure(var1);
            this.state = 1;
            return true;
         } catch (NoClassDefFoundError var3) {
            Log.warn(new Log$SimpleMessage("Unable to load module classes for ", this.module.getName(), ":", var3.getMessage()));
            this.state = -2;
         } catch (Exception var4) {
            if(Log.isDebugEnabled()) {
               Log.warn("Unable to configure the module " + this.module.getName(), var4);
            } else if(Log.isWarningEnabled()) {
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

   public boolean initialize(SubSystem var1) {
      if(this.state == 1) {
         try {
            this.module.initialize(var1);
            this.state = 2;
            return true;
         } catch (NoClassDefFoundError var3) {
            Log.warn(new Log$SimpleMessage("Unable to load module classes for ", this.module.getName(), ":", var3.getMessage()));
            this.state = -2;
         } catch (ModuleInitializeException var4) {
            if(Log.isDebugEnabled()) {
               Log.warn("Unable to initialize the module " + this.module.getName(), var4);
            } else if(Log.isWarningEnabled()) {
               Log.warn("Unable to initialize the module " + this.module.getName());
            }

            this.state = -2;
         } catch (Exception var5) {
            if(Log.isDebugEnabled()) {
               Log.warn("Unable to initialize the module " + this.module.getName(), var5);
            } else if(Log.isWarningEnabled()) {
               Log.warn("Unable to initialize the module " + this.module.getName());
            }

            this.state = -2;
         }
      }

      return false;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof PackageState)) {
         return false;
      } else {
         PackageState var2 = (PackageState)var1;
         return this.module.getModuleClass().equals(var2.module.getModuleClass());
      }
   }

   public int hashCode() {
      return this.module.hashCode();
   }
}
