package org.jfree.base.modules;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import org.jfree.base.AbstractBoot;
import org.jfree.base.log.PadMessage;
import org.jfree.base.modules.DefaultModuleInfo;
import org.jfree.base.modules.Module;
import org.jfree.base.modules.ModuleInfo;
import org.jfree.base.modules.PackageManager$PackageConfiguration;
import org.jfree.base.modules.PackageSorter;
import org.jfree.base.modules.PackageState;
import org.jfree.util.Configuration;
import org.jfree.util.Log;
import org.jfree.util.Log$SimpleMessage;
import org.jfree.util.ObjectUtilities;

public final class PackageManager {
   private static final int RETURN_MODULE_LOADED = 0;
   private static final int RETURN_MODULE_UNKNOWN = 1;
   private static final int RETURN_MODULE_ERROR = 2;
   private final PackageManager$PackageConfiguration packageConfiguration;
   private final ArrayList modules;
   private final ArrayList initSections;
   private AbstractBoot booter;
   private static HashMap instances;

   public static PackageManager createInstance(AbstractBoot var0) {
      PackageManager var1;
      if(instances == null) {
         instances = new HashMap();
         var1 = new PackageManager(var0);
         instances.put(var0, var1);
         return var1;
      } else {
         var1 = (PackageManager)instances.get(var0);
         if(var1 == null) {
            var1 = new PackageManager(var0);
            instances.put(var0, var1);
         }

         return var1;
      }
   }

   private PackageManager(AbstractBoot var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.booter = var1;
         this.packageConfiguration = new PackageManager$PackageConfiguration();
         this.modules = new ArrayList();
         this.initSections = new ArrayList();
      }
   }

   public boolean isModuleAvailable(ModuleInfo var1) {
      PackageState[] var2 = (PackageState[])((PackageState[])this.modules.toArray(new PackageState[this.modules.size()]));

      for(int var3 = 0; var3 < var2.length; ++var3) {
         PackageState var4 = var2[var3];
         if(var4.getModule().getModuleClass().equals(var1.getModuleClass())) {
            return var4.getState() == 2;
         }
      }

      return false;
   }

   public void load(String var1) {
      if(!this.initSections.contains(var1)) {
         this.initSections.add(var1);
         Configuration var2 = this.booter.getGlobalConfig();
         Iterator var3 = var2.findPropertyKeys(var1);
         int var4 = 0;

         while(var3.hasNext()) {
            String var5 = (String)var3.next();
            if(var5.endsWith(".Module")) {
               String var6 = var2.getConfigProperty(var5);
               if(var6 != null && var6.length() > 0) {
                  this.addModule(var6);
                  ++var4;
               }
            }
         }

         Log.debug("Loaded a total of " + var4 + " modules under prefix: " + var1);
      }
   }

   public synchronized void initializeModules() {
      PackageSorter.sort(this.modules);

      int var1;
      PackageState var2;
      for(var1 = 0; var1 < this.modules.size(); ++var1) {
         var2 = (PackageState)this.modules.get(var1);
         if(var2.configure(this.booter)) {
            Log.debug(new Log$SimpleMessage("Conf: ", new PadMessage(var2.getModule().getModuleClass(), 70), " [", var2.getModule().getSubSystem(), "]"));
         }
      }

      for(var1 = 0; var1 < this.modules.size(); ++var1) {
         var2 = (PackageState)this.modules.get(var1);
         if(var2.initialize(this.booter)) {
            Log.debug(new Log$SimpleMessage("Init: ", new PadMessage(var2.getModule().getModuleClass(), 70), " [", var2.getModule().getSubSystem(), "]"));
         }
      }

   }

   public synchronized void addModule(String var1) {
      ArrayList var2 = new ArrayList();
      DefaultModuleInfo var3 = new DefaultModuleInfo(var1, (String)null, (String)null, (String)null);
      if(this.loadModule(var3, new ArrayList(), var2, false)) {
         for(int var4 = 0; var4 < var2.size(); ++var4) {
            Module var5 = (Module)var2.get(var4);
            this.modules.add(new PackageState(var5));
         }
      }

   }

   private int containsModule(ArrayList var1, ModuleInfo var2) {
      int var4;
      if(var1 != null) {
         ModuleInfo[] var3 = (ModuleInfo[])((ModuleInfo[])var1.toArray(new ModuleInfo[var1.size()]));

         for(var4 = 0; var4 < var3.length; ++var4) {
            if(var3[var4].getModuleClass().equals(var2.getModuleClass())) {
               return 0;
            }
         }
      }

      PackageState[] var5 = (PackageState[])((PackageState[])this.modules.toArray(new PackageState[this.modules.size()]));

      for(var4 = 0; var4 < var5.length; ++var4) {
         if(var5[var4].getModule().getModuleClass().equals(var2.getModuleClass())) {
            if(var5[var4].getState() == -2) {
               return 2;
            }

            return 0;
         }
      }

      return 1;
   }

   private void dropFailedModule(PackageState var1) {
      if(!this.modules.contains(var1)) {
         this.modules.add(var1);
      }

   }

   private boolean loadModule(ModuleInfo var1, ArrayList var2, ArrayList var3, boolean var4) {
      try {
         Class var5 = ObjectUtilities.getClassLoader(this.getClass()).loadClass(var1.getModuleClass());
         Module var6 = (Module)var5.newInstance();
         if(!this.acceptVersion(var1, var6)) {
            Log.warn("Module " + var6.getName() + ": required version: " + var1 + ", but found Version: \n" + var6);
            PackageState var13 = new PackageState(var6, -2);
            this.dropFailedModule(var13);
            return false;
         } else {
            int var7 = this.containsModule(var3, var6);
            PackageState var14;
            if(var7 == 2) {
               Log.debug("Indicated failure for module: " + var6.getModuleClass());
               var14 = new PackageState(var6, -2);
               this.dropFailedModule(var14);
               return false;
            } else {
               if(var7 == 1) {
                  if(var2.contains(var6)) {
                     Log.error(new Log$SimpleMessage("Circular module reference: This module definition is invalid: ", var6.getClass()));
                     var14 = new PackageState(var6, -2);
                     this.dropFailedModule(var14);
                     return false;
                  }

                  var2.add(var6);
                  ModuleInfo[] var8 = var6.getRequiredModules();

                  for(int var9 = 0; var9 < var8.length; ++var9) {
                     if(!this.loadModule(var8[var9], var2, var3, true)) {
                        Log.debug("Indicated failure for module: " + var6.getModuleClass());
                        PackageState var10 = new PackageState(var6, -2);
                        this.dropFailedModule(var10);
                        return false;
                     }
                  }

                  ModuleInfo[] var15 = var6.getOptionalModules();

                  for(int var16 = 0; var16 < var15.length; ++var16) {
                     if(!this.loadModule(var15[var16], var2, var3, true)) {
                        Log.debug(new Log$SimpleMessage("Optional module: ", var15[var16].getModuleClass(), " was not loaded."));
                     }
                  }

                  if(this.containsModule(var3, var6) == 1) {
                     var3.add(var6);
                  }

                  var2.remove(var6);
               }

               return true;
            }
         }
      } catch (ClassNotFoundException var11) {
         if(var4) {
            Log.warn(new Log$SimpleMessage("Unresolved dependency for package: ", var1.getModuleClass()));
         }

         Log.debug(new Log$SimpleMessage("ClassNotFound: ", var11.getMessage()));
         return false;
      } catch (Exception var12) {
         Log.warn(new Log$SimpleMessage("Exception while loading module: ", var1), var12);
         return false;
      }
   }

   private boolean acceptVersion(ModuleInfo var1, Module var2) {
      if(var1.getMajorVersion() == null) {
         return true;
      } else {
         int var3;
         if(var2.getMajorVersion() == null) {
            Log.warn("Module " + var2.getName() + " does not define a major version.");
         } else {
            var3 = this.acceptVersion(var1.getMajorVersion(), var2.getMajorVersion());
            if(var3 > 0) {
               return false;
            }

            if(var3 < 0) {
               return true;
            }
         }

         if(var1.getMinorVersion() == null) {
            return true;
         } else {
            if(var2.getMinorVersion() == null) {
               Log.warn("Module " + var2.getName() + " does not define a minor version.");
            } else {
               var3 = this.acceptVersion(var1.getMinorVersion(), var2.getMinorVersion());
               if(var3 > 0) {
                  return false;
               }

               if(var3 < 0) {
                  return true;
               }
            }

            if(var1.getPatchLevel() == null) {
               return true;
            } else {
               if(var2.getPatchLevel() == null) {
                  Log.debug("Module " + var2.getName() + " does not define a patch level.");
               } else if(this.acceptVersion(var1.getPatchLevel(), var2.getPatchLevel()) > 0) {
                  Log.debug("Did not accept patchlevel: " + var1.getPatchLevel() + " - " + var2.getPatchLevel());
                  return false;
               }

               return true;
            }
         }
      }
   }

   private int acceptVersion(String var1, String var2) {
      int var3 = Math.max(var1.length(), var2.length());
      char[] var4;
      char[] var5;
      if(var1.length() > var2.length()) {
         var4 = var1.toCharArray();
         var5 = new char[var3];
         int var6 = var1.length() - var2.length();
         Arrays.fill(var5, 0, var6, ' ');
         System.arraycopy(var5, var6, var2.toCharArray(), 0, var2.length());
      } else if(var1.length() < var2.length()) {
         var5 = var2.toCharArray();
         var4 = new char[var3];
         char[] var8 = new char[var3];
         int var7 = var2.length() - var1.length();
         Arrays.fill(var8, 0, var7, ' ');
         System.arraycopy(var8, var7, var1.toCharArray(), 0, var1.length());
      } else {
         var5 = var2.toCharArray();
         var4 = var1.toCharArray();
      }

      return (new String(var4)).compareTo(new String(var5));
   }

   public PackageManager$PackageConfiguration getPackageConfiguration() {
      return this.packageConfiguration;
   }

   public Module[] getAllModules() {
      Module[] var1 = new Module[this.modules.size()];

      for(int var2 = 0; var2 < this.modules.size(); ++var2) {
         PackageState var3 = (PackageState)this.modules.get(var2);
         var1[var2] = var3.getModule();
      }

      return var1;
   }

   public Module[] getActiveModules() {
      ArrayList var1 = new ArrayList();

      for(int var2 = 0; var2 < this.modules.size(); ++var2) {
         PackageState var3 = (PackageState)this.modules.get(var2);
         if(var3.getState() == 2) {
            var1.add(var3.getModule());
         }
      }

      return (Module[])((Module[])var1.toArray(new Module[var1.size()]));
   }

   public void printUsedModules(PrintStream var1) {
      Module[] var2 = this.getAllModules();
      ArrayList var3 = new ArrayList();
      ArrayList var4 = new ArrayList();

      int var5;
      for(var5 = 0; var5 < var2.length; ++var5) {
         if(this.isModuleAvailable(var2[var5])) {
            var3.add(var2[var5]);
         } else {
            var4.add(var2[var5]);
         }
      }

      var1.print("Active modules: ");
      var1.println(var3.size());
      var1.println("----------------------------------------------------------");

      for(var5 = 0; var5 < var3.size(); ++var5) {
         Module var6 = (Module)var3.get(var5);
         var1.print(new PadMessage(var6.getModuleClass(), 70));
         var1.print(" [");
         var1.print(var6.getSubSystem());
         var1.println("]");
         var1.print("  Version: ");
         var1.print(var6.getMajorVersion());
         var1.print("-");
         var1.print(var6.getMinorVersion());
         var1.print("-");
         var1.print(var6.getPatchLevel());
         var1.print(" Producer: ");
         var1.println(var6.getProducer());
         var1.print("  Description: ");
         var1.println(var6.getDescription());
      }

   }
}
