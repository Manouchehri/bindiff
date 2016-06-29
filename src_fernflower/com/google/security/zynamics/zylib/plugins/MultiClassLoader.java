package com.google.security.zynamics.zylib.plugins;

import java.util.Hashtable;

@Deprecated
public abstract class MultiClassLoader extends ClassLoader {
   private final Hashtable classes = new Hashtable();
   private char classNameReplacementChar;
   protected boolean monitorOn = false;
   protected boolean sourceMonitorOn = true;

   protected static void print(String var0) {
      System.out.println(var0);
   }

   protected String formatClassName(String var1) {
      return this.classNameReplacementChar == 0?String.valueOf(var1.replace('.', '/')).concat(".class"):String.valueOf(var1.replace('.', this.classNameReplacementChar)).concat(".class");
   }

   protected abstract byte[] loadClassBytes(String var1);

   protected void monitor(String var1) {
      if(this.monitorOn) {
         print(var1);
      }

   }

   public Class loadClass(String var1) {
      return this.loadClass(var1, true);
   }

   public synchronized Class loadClass(String var1, boolean var2) {
      this.monitor((new StringBuilder(38 + String.valueOf(var1).length())).append(">> MultiClassLoader.loadClass(").append(var1).append(", ").append(var2).append(")").toString());
      Class var3 = (Class)this.classes.get(var1);
      if(var3 != null) {
         this.monitor(">> returning cached result.");
         return var3;
      } else {
         try {
            var3 = super.findSystemClass(var1);
            this.monitor(">> returning system class (in CLASSPATH).");
            return var3;
         } catch (ClassNotFoundException var6) {
            this.monitor(">> Not a system class.");
            byte[] var4 = this.loadClassBytes(var1);
            if(var4 == null) {
               throw new ClassNotFoundException();
            } else {
               var3 = this.defineClass(var1, var4, 0, var4.length);
               if(var3 == null) {
                  throw new ClassFormatError();
               } else {
                  if(var2) {
                     this.resolveClass(var3);
                  }

                  this.classes.put(var1, var3);
                  this.monitor(">> Returning newly loaded class.");
                  return var3;
               }
            }
         }
      }
   }

   public void setClassNameReplacementChar(char var1) {
      this.classNameReplacementChar = var1;
   }
}
