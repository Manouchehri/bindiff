package org.jfree.base;

import java.util.ArrayList;
import java.util.List;
import org.jfree.base.BasicProjectInfo$OptionalLibraryHolder;
import org.jfree.base.Library;

public class BasicProjectInfo extends Library {
   private String copyright;
   private List libraries;
   private List optionalLibraries;

   public BasicProjectInfo() {
      this.libraries = new ArrayList();
      this.optionalLibraries = new ArrayList();
   }

   public BasicProjectInfo(String var1, String var2, String var3, String var4) {
      this();
      this.setName(var1);
      this.setVersion(var2);
      this.setLicenceName(var3);
      this.setInfo(var4);
   }

   public BasicProjectInfo(String var1, String var2, String var3, String var4, String var5) {
      this(var1, var2, var5, var3);
      this.setCopyright(var4);
   }

   public String getCopyright() {
      return this.copyright;
   }

   public void setCopyright(String var1) {
      this.copyright = var1;
   }

   public void setInfo(String var1) {
      super.setInfo(var1);
   }

   public void setLicenceName(String var1) {
      super.setLicenceName(var1);
   }

   public void setName(String var1) {
      super.setName(var1);
   }

   public void setVersion(String var1) {
      super.setVersion(var1);
   }

   public Library[] getLibraries() {
      return (Library[])((Library[])this.libraries.toArray(new Library[this.libraries.size()]));
   }

   public void addLibrary(Library var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.libraries.add(var1);
      }
   }

   public Library[] getOptionalLibraries() {
      ArrayList var1 = new ArrayList();

      for(int var2 = 0; var2 < this.optionalLibraries.size(); ++var2) {
         BasicProjectInfo$OptionalLibraryHolder var3 = (BasicProjectInfo$OptionalLibraryHolder)this.optionalLibraries.get(var2);
         Library var4 = var3.getLibrary();
         if(var4 != null) {
            var1.add(var4);
         }
      }

      return (Library[])((Library[])var1.toArray(new Library[var1.size()]));
   }

   public void addOptionalLibrary(String var1) {
      if(var1 == null) {
         throw new NullPointerException("Library classname must be given.");
      } else {
         this.optionalLibraries.add(new BasicProjectInfo$OptionalLibraryHolder(var1));
      }
   }

   public void addOptionalLibrary(Library var1) {
      if(var1 == null) {
         throw new NullPointerException("Library must be given.");
      } else {
         this.optionalLibraries.add(new BasicProjectInfo$OptionalLibraryHolder(var1));
      }
   }
}
