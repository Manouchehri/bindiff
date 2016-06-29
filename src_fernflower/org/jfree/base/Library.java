package org.jfree.base;

public class Library {
   private String name;
   private String version;
   private String licenceName;
   private String info;

   public Library(String var1, String var2, String var3, String var4) {
      this.name = var1;
      this.version = var2;
      this.licenceName = var3;
      this.info = var4;
   }

   protected Library() {
   }

   public String getName() {
      return this.name;
   }

   public String getVersion() {
      return this.version;
   }

   public String getLicenceName() {
      return this.licenceName;
   }

   public String getInfo() {
      return this.info;
   }

   protected void setInfo(String var1) {
      this.info = var1;
   }

   protected void setLicenceName(String var1) {
      this.licenceName = var1;
   }

   protected void setName(String var1) {
      this.name = var1;
   }

   protected void setVersion(String var1) {
      this.version = var1;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(var1 != null && this.getClass() == var1.getClass()) {
         Library var2 = (Library)var1;
         if(this.name != null) {
            if(!this.name.equals(var2.name)) {
               return false;
            }
         } else if(var2.name != null) {
            return false;
         }

         return true;
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.name != null?this.name.hashCode():0;
   }
}
