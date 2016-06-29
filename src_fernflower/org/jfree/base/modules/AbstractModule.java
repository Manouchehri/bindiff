package org.jfree.base.modules;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.jfree.base.modules.AbstractModule$ReaderHelper;
import org.jfree.base.modules.DefaultModuleInfo;
import org.jfree.base.modules.Module;
import org.jfree.base.modules.ModuleInfo;
import org.jfree.base.modules.ModuleInitializeException;
import org.jfree.base.modules.ModuleInitializer;
import org.jfree.base.modules.SubSystem;
import org.jfree.util.ObjectUtilities;

public abstract class AbstractModule extends DefaultModuleInfo implements Module {
   private ModuleInfo[] requiredModules;
   private ModuleInfo[] optionalModules;
   private String name;
   private String description;
   private String producer;
   private String subsystem;

   public AbstractModule() {
      this.setModuleClass(this.getClass().getName());
   }

   protected void loadModuleInfo() {
      InputStream var1 = ObjectUtilities.getResourceRelativeAsStream("module.properties", this.getClass());
      if(var1 == null) {
         throw new ModuleInitializeException("File \'module.properties\' not found in module package.");
      } else {
         this.loadModuleInfo(var1);
      }
   }

   protected void loadModuleInfo(InputStream var1) {
      try {
         if(var1 == null) {
            throw new NullPointerException("Given InputStream is null.");
         } else {
            AbstractModule$ReaderHelper var2 = new AbstractModule$ReaderHelper(new BufferedReader(new InputStreamReader(var1, "ISO-8859-1")));
            ArrayList var3 = new ArrayList();
            ArrayList var4 = new ArrayList();

            while(var2.hasNext()) {
               String var5 = var2.next();
               if(var5.startsWith("module-info:")) {
                  this.readModuleInfo(var2);
               } else if(var5.startsWith("depends:")) {
                  var4.add(this.readExternalModule(var2));
               } else if(var5.startsWith("optional:")) {
                  var3.add(this.readExternalModule(var2));
               }
            }

            var2.close();
            this.optionalModules = (ModuleInfo[])((ModuleInfo[])var3.toArray(new ModuleInfo[var3.size()]));
            this.requiredModules = (ModuleInfo[])((ModuleInfo[])var4.toArray(new ModuleInfo[var4.size()]));
         }
      } catch (IOException var6) {
         throw new ModuleInitializeException("Failed to load properties", var6);
      }
   }

   private String readValue(AbstractModule$ReaderHelper var1, String var2) {
      StringBuffer var3 = new StringBuffer(var2.trim());
      boolean var4 = true;

      while(true) {
         while(this.isNextLineValueLine(var1)) {
            var2 = var1.next();
            String var5 = var2.trim();
            if(var5.length() == 0 && !var4) {
               var3.append("\n");
               var4 = true;
            } else {
               if(!var4) {
                  var3.append(" ");
               }

               var3.append(this.parseValue(var5));
               var4 = false;
            }
         }

         return var3.toString();
      }
   }

   private boolean isNextLineValueLine(AbstractModule$ReaderHelper var1) {
      if(!var1.hasNext()) {
         return false;
      } else {
         String var2 = var1.next();
         if(var2 == null) {
            return false;
         } else if(this.parseKey(var2) != null) {
            var1.pushBack(var2);
            return false;
         } else {
            var1.pushBack(var2);
            return true;
         }
      }
   }

   private void readModuleInfo(AbstractModule$ReaderHelper var1) {
      while(var1.hasNext()) {
         String var2 = var1.next();
         if(!Character.isWhitespace(var2.charAt(0))) {
            var1.pushBack(var2);
            return;
         }

         String var3 = var2.trim();
         String var4 = this.parseKey(var3);
         if(var4 != null) {
            String var5 = this.readValue(var1, this.parseValue(var3.trim()));
            if(var4.equals("name")) {
               this.setName(var5);
            } else if(var4.equals("producer")) {
               this.setProducer(var5);
            } else if(var4.equals("description")) {
               this.setDescription(var5);
            } else if(var4.equals("subsystem")) {
               this.setSubSystem(var5);
            } else if(var4.equals("version.major")) {
               this.setMajorVersion(var5);
            } else if(var4.equals("version.minor")) {
               this.setMinorVersion(var5);
            } else if(var4.equals("version.patchlevel")) {
               this.setPatchLevel(var5);
            }
         }
      }

   }

   private String parseKey(String var1) {
      int var2 = var1.indexOf(58);
      return var2 == -1?null:var1.substring(0, var2);
   }

   private String parseValue(String var1) {
      int var2 = var1.indexOf(58);
      return var2 == -1?var1:(var2 + 1 == var1.length()?"":var1.substring(var2 + 1));
   }

   private DefaultModuleInfo readExternalModule(AbstractModule$ReaderHelper var1) {
      DefaultModuleInfo var2 = new DefaultModuleInfo();

      while(var1.hasNext()) {
         String var3 = var1.next();
         if(!Character.isWhitespace(var3.charAt(0))) {
            var1.pushBack(var3);
            return var2;
         }

         String var4 = var3.trim();
         String var5 = this.parseKey(var4);
         if(var5 != null) {
            String var6 = this.readValue(var1, this.parseValue(var4));
            if(var5.equals("module")) {
               var2.setModuleClass(var6);
            } else if(var5.equals("version.major")) {
               var2.setMajorVersion(var6);
            } else if(var5.equals("version.minor")) {
               var2.setMinorVersion(var6);
            } else if(var5.equals("version.patchlevel")) {
               var2.setPatchLevel(var6);
            }
         }
      }

      return var2;
   }

   public String getName() {
      return this.name;
   }

   protected void setName(String var1) {
      this.name = var1;
   }

   public String getDescription() {
      return this.description;
   }

   protected void setDescription(String var1) {
      this.description = var1;
   }

   public String getProducer() {
      return this.producer;
   }

   protected void setProducer(String var1) {
      this.producer = var1;
   }

   public ModuleInfo[] getRequiredModules() {
      ModuleInfo[] var1 = new ModuleInfo[this.requiredModules.length];
      System.arraycopy(this.requiredModules, 0, var1, 0, this.requiredModules.length);
      return var1;
   }

   public ModuleInfo[] getOptionalModules() {
      ModuleInfo[] var1 = new ModuleInfo[this.optionalModules.length];
      System.arraycopy(this.optionalModules, 0, var1, 0, this.optionalModules.length);
      return var1;
   }

   protected void setRequiredModules(ModuleInfo[] var1) {
      this.requiredModules = new ModuleInfo[var1.length];
      System.arraycopy(var1, 0, this.requiredModules, 0, var1.length);
   }

   public void setOptionalModules(ModuleInfo[] var1) {
      this.optionalModules = new ModuleInfo[var1.length];
      System.arraycopy(var1, 0, this.optionalModules, 0, var1.length);
   }

   public String toString() {
      StringBuffer var1 = new StringBuffer();
      var1.append("Module : ");
      var1.append(this.getName());
      var1.append("\n");
      var1.append("ModuleClass : ");
      var1.append(this.getModuleClass());
      var1.append("\n");
      var1.append("Version: ");
      var1.append(this.getMajorVersion());
      var1.append(".");
      var1.append(this.getMinorVersion());
      var1.append(".");
      var1.append(this.getPatchLevel());
      var1.append("\n");
      var1.append("Producer: ");
      var1.append(this.getProducer());
      var1.append("\n");
      var1.append("Description: ");
      var1.append(this.getDescription());
      var1.append("\n");
      return var1.toString();
   }

   protected static boolean isClassLoadable(String var0) {
      try {
         Thread.currentThread().getContextClassLoader().loadClass(var0);
         return true;
      } catch (Exception var2) {
         return false;
      }
   }

   public void configure(SubSystem var1) {
      InputStream var2 = ObjectUtilities.getResourceRelativeAsStream("configuration.properties", this.getClass());
      if(var2 != null) {
         var1.getPackageManager().getPackageConfiguration().load(var2);
      }
   }

   protected void performExternalInitialize(String var1) {
      try {
         Class var2 = Thread.currentThread().getContextClassLoader().loadClass(var1);
         ModuleInitializer var3 = (ModuleInitializer)var2.newInstance();
         var3.performInit();
      } catch (ModuleInitializeException var4) {
         throw var4;
      } catch (Exception var5) {
         throw new ModuleInitializeException("Failed to load specified initializer class.", var5);
      }
   }

   public String getSubSystem() {
      return this.subsystem == null?this.getName():this.subsystem;
   }

   protected void setSubSystem(String var1) {
      this.subsystem = var1;
   }
}
