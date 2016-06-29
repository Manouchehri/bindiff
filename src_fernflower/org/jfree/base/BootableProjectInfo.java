package org.jfree.base;

import java.util.ArrayList;
import org.jfree.base.BasicProjectInfo;
import org.jfree.base.Library;

public class BootableProjectInfo extends BasicProjectInfo {
   private String bootClass;
   private boolean autoBoot;

   public BootableProjectInfo() {
      this.autoBoot = true;
   }

   public BootableProjectInfo(String var1, String var2, String var3, String var4) {
      this();
      this.setName(var1);
      this.setVersion(var2);
      this.setLicenceName(var3);
      this.setInfo(var4);
   }

   public BootableProjectInfo(String var1, String var2, String var3, String var4, String var5) {
      this();
      this.setName(var1);
      this.setVersion(var2);
      this.setLicenceName(var5);
      this.setInfo(var3);
      this.setCopyright(var4);
   }

   public BootableProjectInfo[] getDependencies() {
      ArrayList var1 = new ArrayList();
      Library[] var2 = this.getLibraries();

      for(int var3 = 0; var3 < var2.length; ++var3) {
         Library var4 = var2[var3];
         if(var4 instanceof BootableProjectInfo) {
            var1.add(var4);
         }
      }

      Library[] var6 = this.getOptionalLibraries();

      for(int var7 = 0; var7 < var6.length; ++var7) {
         Library var5 = var6[var7];
         if(var5 instanceof BootableProjectInfo) {
            var1.add(var5);
         }
      }

      return (BootableProjectInfo[])((BootableProjectInfo[])var1.toArray(new BootableProjectInfo[var1.size()]));
   }

   public void addDependency(BootableProjectInfo var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.addLibrary(var1);
      }
   }

   public String getBootClass() {
      return this.bootClass;
   }

   public void setBootClass(String var1) {
      this.bootClass = var1;
   }

   public boolean isAutoBoot() {
      return this.autoBoot;
   }

   public void setAutoBoot(boolean var1) {
      this.autoBoot = var1;
   }
}
