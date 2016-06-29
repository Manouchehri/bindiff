package org.jfree.base.modules;

import org.jfree.base.modules.ModuleInfo;

public class DefaultModuleInfo implements ModuleInfo {
   private String moduleClass;
   private String majorVersion;
   private String minorVersion;
   private String patchLevel;

   public DefaultModuleInfo() {
   }

   public DefaultModuleInfo(String var1, String var2, String var3, String var4) {
      if(var1 == null) {
         throw new NullPointerException("Module class must not be null.");
      } else {
         this.moduleClass = var1;
         this.majorVersion = var2;
         this.minorVersion = var3;
         this.patchLevel = var4;
      }
   }

   public String getModuleClass() {
      return this.moduleClass;
   }

   public void setModuleClass(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.moduleClass = var1;
      }
   }

   public String getMajorVersion() {
      return this.majorVersion;
   }

   public void setMajorVersion(String var1) {
      this.majorVersion = var1;
   }

   public String getMinorVersion() {
      return this.minorVersion;
   }

   public void setMinorVersion(String var1) {
      this.minorVersion = var1;
   }

   public String getPatchLevel() {
      return this.patchLevel;
   }

   public void setPatchLevel(String var1) {
      this.patchLevel = var1;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof DefaultModuleInfo)) {
         return false;
      } else {
         ModuleInfo var2 = (ModuleInfo)var1;
         return this.moduleClass.equals(var2.getModuleClass());
      }
   }

   public int hashCode() {
      int var1 = this.moduleClass.hashCode();
      return var1;
   }

   public String toString() {
      StringBuffer var1 = new StringBuffer();
      var1.append(this.getClass().getName());
      var1.append("={ModuleClass=");
      var1.append(this.getModuleClass());
      if(this.getMajorVersion() != null) {
         var1.append("; Version=");
         var1.append(this.getMajorVersion());
         if(this.getMinorVersion() != null) {
            var1.append("-");
            var1.append(this.getMinorVersion());
            if(this.getPatchLevel() != null) {
               var1.append("_");
               var1.append(this.getPatchLevel());
            }
         }
      }

      var1.append("}");
      return var1.toString();
   }
}
