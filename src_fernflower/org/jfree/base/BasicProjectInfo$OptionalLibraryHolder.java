package org.jfree.base;

import java.lang.reflect.Method;
import org.jfree.base.Library;
import org.jfree.util.ObjectUtilities;

class BasicProjectInfo$OptionalLibraryHolder {
   private String libraryClass;
   private transient Library library;

   public BasicProjectInfo$OptionalLibraryHolder(String var1) {
      if(var1 == null) {
         throw new NullPointerException("LibraryClass must not be null.");
      } else {
         this.libraryClass = var1;
      }
   }

   public BasicProjectInfo$OptionalLibraryHolder(Library var1) {
      if(var1 == null) {
         throw new NullPointerException("Library must not be null.");
      } else {
         this.library = var1;
         this.libraryClass = var1.getClass().getName();
      }
   }

   public String getLibraryClass() {
      return this.libraryClass;
   }

   public Library getLibrary() {
      if(this.library == null) {
         this.library = this.loadLibrary(this.libraryClass);
      }

      return this.library;
   }

   protected Library loadLibrary(String var1) {
      if(var1 == null) {
         return null;
      } else {
         try {
            Class var2 = ObjectUtilities.getClassLoader(this.getClass()).loadClass(var1);

            try {
               Method var3 = var2.getMethod("getInstance", (Class[])null);
               return (Library)var3.invoke((Object)null, (Object[])null);
            } catch (Exception var4) {
               return (Library)var2.newInstance();
            }
         } catch (Exception var5) {
            return null;
         }
      }
   }
}
