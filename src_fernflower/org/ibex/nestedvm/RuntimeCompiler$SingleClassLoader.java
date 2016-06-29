package org.ibex.nestedvm;

import org.ibex.nestedvm.RuntimeCompiler$1;

class RuntimeCompiler$SingleClassLoader extends ClassLoader {
   private RuntimeCompiler$SingleClassLoader() {
   }

   public Class loadClass(String var1, boolean var2) {
      return super.loadClass(var1, var2);
   }

   public Class fromBytes(String var1, byte[] var2) {
      return this.fromBytes(var1, var2, 0, var2.length);
   }

   public Class fromBytes(String var1, byte[] var2, int var3, int var4) {
      Class var5 = super.defineClass(var1, var2, var3, var4);
      this.resolveClass(var5);
      return var5;
   }

   RuntimeCompiler$SingleClassLoader(RuntimeCompiler$1 var1) {
      this();
   }
}
