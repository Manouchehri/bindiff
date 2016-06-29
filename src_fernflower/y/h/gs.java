package y.h;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import y.h.aB;
import y.h.aX;
import y.h.bs;
import y.h.eU;
import y.h.fd;
import y.h.fj;
import y.h.gZ;
import y.h.hf;

public class gs implements aX, bs, fd, hf {
   private final byte a;

   public gs(byte var1) {
      this.a = var1;
   }

   public Object a(fj var1, Object var2, fj var3) {
      return this.a(var2);
   }

   protected Object a(Object var1) {
      if(var1 != null) {
         try {
            if(var1 instanceof Cloneable) {
               Class var2 = var1.getClass();
               Method var7 = var2.getMethod("clone", (Class[])null);
               if(Modifier.isPublic(var7.getModifiers())) {
                  return var7.invoke(var1, (Object[])null);
               }
            }
         } catch (InvocationTargetException var4) {
            Throwable var3 = var4.getTargetException();
            if(var3 instanceof RuntimeException) {
               throw (RuntimeException)var3;
            }
         } catch (NoSuchMethodException var5) {
            ;
         } catch (IllegalAccessException var6) {
            ;
         }

         switch(this.a) {
         case 0:
            return var1;
         case 1:
            return null;
         case 2:
         default:
            throw new IllegalArgumentException("Cloning failed.");
         }
      } else {
         return null;
      }
   }

   public Object a(fj var1, ObjectInputStream var2) {
      return this.a(var2);
   }

   protected Object a(ObjectInputStream var1) {
      try {
         return var1.readObject();
      } catch (ClassNotFoundException var3) {
         if(this.a == 1) {
            return null;
         } else {
            throw new IOException(var3.getMessage());
         }
      }
   }

   public void a(fj var1, Object var2, ObjectOutputStream var3) {
      this.a(var2, var3);
   }

   protected void a(Object var1, ObjectOutputStream var2) {
      if(var1 == null || var1 instanceof Serializable) {
         var2.writeObject(var1);
         if(!fj.z) {
            return;
         }
      }

      if(this.a == 2) {
         throw new IOException("Could not write userData.");
      } else {
         var2.writeObject((Object)null);
      }
   }

   public void a(aB var1, Object var2, ObjectOutputStream var3) {
      this.a(var2, var3);
   }

   public Object a(aB var1, ObjectInputStream var2) {
      return this.a(var2);
   }

   public Object a(aB var1, Object var2, aB var3) {
      return this.a(var2);
   }

   public void a(gZ var1, Object var2, ObjectOutputStream var3) {
      this.a(var2, var3);
   }

   public Object a(gZ var1, ObjectInputStream var2) {
      return this.a(var2);
   }

   public Object a(gZ var1, Object var2, gZ var3) {
      return this.a(var2);
   }

   public Object a(eU var1, Object var2, eU var3) {
      return this.a(var2);
   }
}
