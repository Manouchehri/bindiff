package org.ibex.nestedvm;

import java.io.ByteArrayOutputStream;
import org.ibex.nestedvm.ClassFileCompiler;
import org.ibex.nestedvm.Compiler$Exn;
import org.ibex.nestedvm.RuntimeCompiler$1;
import org.ibex.nestedvm.RuntimeCompiler$SingleClassLoader;
import org.ibex.nestedvm.UnixRuntime;
import org.ibex.nestedvm.util.Seekable;
import org.ibex.nestedvm.util.Seekable$File;

public class RuntimeCompiler {
   public static Class compile(Seekable var0) {
      return compile(var0, (String)null);
   }

   public static Class compile(Seekable var0, String var1) {
      return compile(var0, var1, (String)null);
   }

   public static Class compile(Seekable var0, String var1, String var2) {
      String var3 = "nestedvm.runtimecompiled";

      byte[] var4;
      try {
         var4 = runCompiler(var0, var3, var1, var2, (String)null);
      } catch (Compiler$Exn var6) {
         if(var6.getMessage() == null && var6.getMessage().indexOf("constant pool full") == -1) {
            throw var6;
         }

         var4 = runCompiler(var0, var3, var1, var2, "lessconstants");
      }

      return (new RuntimeCompiler$SingleClassLoader((RuntimeCompiler$1)null)).fromBytes(var3, var4);
   }

   private static byte[] runCompiler(Seekable var0, String var1, String var2, String var3, String var4) {
      ByteArrayOutputStream var5 = new ByteArrayOutputStream();

      try {
         ClassFileCompiler var6 = new ClassFileCompiler(var0, var1, var5);
         var6.parseOptions("nosupportcall,maxinsnpermethod=256");
         var6.setSource(var3);
         if(var2 != null) {
            var6.parseOptions(var2);
         }

         if(var4 != null) {
            var6.parseOptions(var4);
         }

         var6.go();
      } finally {
         var0.seek(0);
      }

      var5.close();
      return var5.toByteArray();
   }

   public static void main(String[] var0) {
      if(var0.length == 0) {
         System.err.println("Usage: RuntimeCompiler mipsbinary");
         System.exit(1);
      }

      UnixRuntime var1 = (UnixRuntime)compile(new Seekable$File(var0[0]), "unixruntime").newInstance();
      System.err.println("Instansiated: " + var1);
      System.exit(UnixRuntime.runAndExec(var1, var0));
   }
}
