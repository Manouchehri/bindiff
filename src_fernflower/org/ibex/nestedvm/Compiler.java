package org.ibex.nestedvm;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;
import java.util.Hashtable;
import java.util.StringTokenizer;
import org.ibex.nestedvm.ClassFileCompiler;
import org.ibex.nestedvm.Compiler$Exn;
import org.ibex.nestedvm.Compiler$Option;
import org.ibex.nestedvm.JavaSourceCompiler;
import org.ibex.nestedvm.Registers;
import org.ibex.nestedvm.util.ELF;
import org.ibex.nestedvm.util.ELF$SHeader;
import org.ibex.nestedvm.util.ELF$Symbol;
import org.ibex.nestedvm.util.ELF$Symtab;
import org.ibex.nestedvm.util.Seekable;
import org.ibex.nestedvm.util.Seekable$File;

public abstract class Compiler implements Registers {
   ELF elf;
   final String fullClassName;
   String source = "unknown.mips.binary";
   boolean fastMem = true;
   int maxInsnPerMethod = 128;
   int maxBytesPerMethod;
   int methodMask;
   int methodShift;
   boolean pruneCases = true;
   boolean assumeTailCalls = true;
   boolean debugCompiler = false;
   boolean printStats = false;
   boolean runtimeStats = false;
   boolean supportCall = true;
   boolean nullPointerCheck = false;
   String runtimeClass = "org.ibex.nestedvm.Runtime";
   String hashClass = "java.util.Hashtable";
   boolean unixRuntime;
   boolean lessConstants;
   boolean singleFloat;
   int pageSize = 4096;
   int totalPages = 65536;
   int pageShift;
   boolean onePage;
   Hashtable jumpableAddresses;
   ELF$Symbol userInfo;
   ELF$Symbol gp;
   private boolean used;
   private static String[] options = new String[]{"fastMem", "Enable fast memory access - RuntimeExceptions will be thrown on faults", "nullPointerCheck", "Enables checking at runtime for null pointer accessses (slows things down a bit, only applicable with fastMem)", "maxInsnPerMethod", "Maximum number of MIPS instructions per java method (128 is optimal with Hotspot)", "pruneCases", "Remove unnecessary case 0xAABCCDD blocks from methods - may break some weird code", "assumeTailCalls", "Assume the JIT optimizes tail calls", "optimizedMemcpy", "Use an optimized java version of memcpy where possible", "debugCompiler", "Output information in the generated code for debugging the compiler - will slow down generated code significantly", "printStats", "Output some useful statistics about the compilation", "runtimeStats", "Keep track of some statistics at runtime in the generated code - will slow down generated code significantly", "supportCall", "Keep a stripped down version of the symbol table in the generated code to support the call() method", "runtimeClass", "Full classname of the Runtime class (default: Runtime) - use this is you put Runtime in a package", "hashClass", "Full classname of a Hashtable class (default: java.util.HashMap) - this must support get() and put()", "unixRuntime", "Use the UnixRuntime (has support for fork, wai, du, pipe, etc)", "pageSize", "The page size (must be a power of two)", "totalPages", "Total number of pages (total mem = pageSize*totalPages, must be a power of two)", "onePage", "One page hack (FIXME: document this better)", "lessConstants", "Use less constants at the cost of speed (FIXME: document this better)", "singleFloat", "Support single precision (32-bit) FP ops only"};
   static Class class$org$ibex$nestedvm$Compiler;
   static Class class$java$lang$String;

   public void setSource(String var1) {
      this.source = var1;
   }

   void maxInsnPerMethodInit() {
      if((this.maxInsnPerMethod & this.maxInsnPerMethod - 1) != 0) {
         throw new Compiler$Exn("maxBytesPerMethod is not a power of two");
      } else {
         this.maxBytesPerMethod = this.maxInsnPerMethod * 4;

         for(this.methodMask = ~(this.maxBytesPerMethod - 1); this.maxBytesPerMethod >>> this.methodShift != 1; ++this.methodShift) {
            ;
         }

      }
   }

   void pageSizeInit() {
      if((this.pageSize & this.pageSize - 1) != 0) {
         throw new Compiler$Exn("pageSize not a multiple of two");
      } else if((this.totalPages & this.totalPages - 1) != 0) {
         throw new Compiler$Exn("totalPages not a multiple of two");
      } else {
         while(this.pageSize >>> this.pageShift != 1) {
            ++this.pageShift;
         }

      }
   }

   private static void usage() {
      System.err.println("Usage: java Compiler [-outfile output.java] [-o options] [-dumpoptions] <classname> <binary.mips>");
      System.err.println("-o takes mount(8) like options and can be specified multiple times");
      System.err.println("Available options:");

      for(int var0 = 0; var0 < options.length; var0 += 2) {
         System.err.print(options[var0] + ": " + wrapAndIndent(options[var0 + 1], 16 - options[var0].length(), 18, 62));
      }

      System.exit(1);
   }

   public static void main(String[] var0) {
      String var1 = null;
      String var2 = null;
      String var3 = null;
      String var4 = null;
      String var5 = null;
      String var6 = null;
      boolean var7 = false;

      for(int var8 = 0; var0.length - var8 > 0; ++var8) {
         if(var0[var8].equals("-outfile")) {
            ++var8;
            if(var8 == var0.length) {
               usage();
            }

            var1 = var0[var8];
         } else if(var0[var8].equals("-d")) {
            ++var8;
            if(var8 == var0.length) {
               usage();
            }

            var2 = var0[var8];
         } else if(var0[var8].equals("-outformat")) {
            ++var8;
            if(var8 == var0.length) {
               usage();
            }

            var6 = var0[var8];
         } else if(var0[var8].equals("-o")) {
            ++var8;
            if(var8 == var0.length) {
               usage();
            }

            if(var3 != null && var3.length() != 0) {
               if(var0[var8].length() != 0) {
                  var3 = var3 + "," + var0[var8];
               }
            } else {
               var3 = var0[var8];
            }
         } else if(var0[var8].equals("-dumpoptions")) {
            var7 = true;
         } else if(var4 == null) {
            var4 = var0[var8];
         } else if(var5 == null) {
            var5 = var0[var8];
         } else {
            usage();
         }
      }

      if(var4 == null || var5 == null) {
         usage();
      }

      Seekable$File var9 = new Seekable$File(var5);
      Object var10 = null;
      FileOutputStream var11 = null;
      Object var12 = null;
      if(var6 != null && !var6.equals("class")) {
         if(!var6.equals("javasource") && !var6.equals("java")) {
            System.err.println("Unknown output format: " + var6);
            System.exit(1);
         } else {
            var10 = var1 == null?new OutputStreamWriter(System.out):new FileWriter(var1);
            var12 = new JavaSourceCompiler(var9, var4, (Writer)var10);
         }
      } else if(var1 != null) {
         var11 = new FileOutputStream(var1);
         var12 = new ClassFileCompiler(var9, var4, var11);
      } else if(var2 != null) {
         File var13 = new File(var2);
         if(!var13.isDirectory()) {
            System.err.println(var2 + " doesn\'t exist or is not a directory");
            System.exit(1);
         }

         var12 = new ClassFileCompiler(var9, var4, var13);
      } else {
         System.err.println("Refusing to write a classfile to stdout - use -outfile foo.class");
         System.exit(1);
      }

      ((Compiler)var12).parseOptions(var3);
      ((Compiler)var12).setSource(var5);
      if(var7) {
         System.err.println("== Options ==");

         for(int var19 = 0; var19 < options.length; var19 += 2) {
            System.err.println(options[var19] + ": " + ((Compiler)var12).getOption(options[var19]).get());
         }

         System.err.println("== End Options ==");
      }

      try {
         ((Compiler)var12).go();
      } catch (Compiler$Exn var17) {
         System.err.println("Compiler Error: " + var17.getMessage());
         System.exit(1);
      } finally {
         if(var10 != null) {
            ((Writer)var10).close();
         }

         if(var11 != null) {
            var11.close();
         }

      }

   }

   public Compiler(Seekable var1, String var2) {
      this.fullClassName = var2;
      this.elf = new ELF(var1);
      if(this.elf.header.type != 2) {
         throw new IOException("Binary is not an executable");
      } else if(this.elf.header.machine != 8) {
         throw new IOException("Binary is not for the MIPS I Architecture");
      } else if(this.elf.ident.data != 2) {
         throw new IOException("Binary is not big endian");
      }
   }

   abstract void _go();

   public void go() {
      if(this.used) {
         throw new RuntimeException("Compiler instances are good for one shot only");
      } else {
         this.used = true;
         if(this.onePage && this.pageSize <= 4096) {
            this.pageSize = 4194304;
         }

         if(this.nullPointerCheck && !this.fastMem) {
            throw new Compiler$Exn("fastMem must be enabled for nullPointerCheck to be of any use");
         } else if(this.onePage && !this.fastMem) {
            throw new Compiler$Exn("fastMem must be enabled for onePage to be of any use");
         } else if(this.totalPages == 1 && !this.onePage) {
            throw new Compiler$Exn("totalPages == 1 and onePage is not set");
         } else {
            if(this.onePage) {
               this.totalPages = 1;
            }

            this.maxInsnPerMethodInit();
            this.pageSizeInit();
            ELF$Symtab var1 = this.elf.getSymtab();
            if(var1 == null) {
               throw new Compiler$Exn("Binary has no symtab (did you strip it?)");
            } else {
               this.userInfo = var1.getGlobalSymbol("user_info");
               this.gp = var1.getGlobalSymbol("_gp");
               if(this.gp == null) {
                  throw new Compiler$Exn("no _gp symbol (did you strip the binary?)");
               } else {
                  if(this.pruneCases) {
                     this.jumpableAddresses = new Hashtable();
                     this.jumpableAddresses.put(new Integer(this.elf.header.entry), Boolean.TRUE);
                     ELF$SHeader var3 = this.elf.sectionWithName(".text");
                     if(var3 == null) {
                        throw new Compiler$Exn("No .text segment");
                     }

                     this.findBranchesInSymtab(var1, this.jumpableAddresses);

                     for(int var4 = 0; var4 < this.elf.sheaders.length; ++var4) {
                        ELF$SHeader var5 = this.elf.sheaders[var4];
                        String var6 = var5.name;
                        if(var5.addr != 0 && (var6.equals(".data") || var6.equals(".sdata") || var6.equals(".rodata") || var6.equals(".ctors") || var6.equals(".dtors"))) {
                           this.findBranchesInData(new DataInputStream(var5.getInputStream()), var5.size, this.jumpableAddresses, var3.addr, var3.addr + var3.size);
                        }
                     }

                     this.findBranchesInText(var3.addr, new DataInputStream(var3.getInputStream()), var3.size, this.jumpableAddresses);
                  }

                  if(this.unixRuntime && this.runtimeClass.startsWith("org.ibex.nestedvm.")) {
                     this.runtimeClass = "org.ibex.nestedvm.UnixRuntime";
                  }

                  for(int var7 = 0; var7 < this.elf.sheaders.length; ++var7) {
                     String var8 = this.elf.sheaders[var7].name;
                     if((this.elf.sheaders[var7].flags & 2) != 0 && !var8.equals(".text") && !var8.equals(".data") && !var8.equals(".sdata") && !var8.equals(".rodata") && !var8.equals(".ctors") && !var8.equals(".dtors") && !var8.equals(".bss") && !var8.equals(".sbss")) {
                        throw new Compiler$Exn("Unknown section: " + var8);
                     }
                  }

                  this._go();
               }
            }
         }
      }
   }

   private void findBranchesInSymtab(ELF$Symtab var1, Hashtable var2) {
      ELF$Symbol[] var3 = var1.symbols;
      int var4 = 0;

      for(int var5 = 0; var5 < var3.length; ++var5) {
         ELF$Symbol var6 = var3[var5];
         if(var6.type == 2 && var2.put(new Integer(var6.addr), Boolean.TRUE) == null) {
            ++var4;
         }
      }

      if(this.printStats) {
         System.err.println("Found " + var4 + " additional possible branch targets in Symtab");
      }

   }

   private void findBranchesInText(int var1, DataInputStream var2, int var3, Hashtable var4) {
      int var5 = var3 / 4;
      int var6 = var1;
      int var7 = 0;
      int[] var8 = new int[32];
      int[] var9 = new int[32];

      for(int var10 = 0; var10 < var5; var6 += 4) {
         int var11 = var2.readInt();
         int var12 = var11 >>> 26 & 255;
         int var13 = var11 >>> 21 & 31;
         int var14 = var11 >>> 16 & 31;
         int var15 = var11 << 16 >> 16;
         int var16 = var11 & '\uffff';
         int var18 = var11 & 67108863;
         int var19 = var11 & 63;
         label69:
         switch(var12) {
         case 0:
            switch(var19) {
            case 9:
               if(var4.put(new Integer(var6 + 8), Boolean.TRUE) == null) {
                  ++var7;
               }
               break label69;
            case 12:
               if(var4.put(new Integer(var6 + 4), Boolean.TRUE) == null) {
                  ++var7;
               }
            default:
               break label69;
            }
         case 1:
            switch(var14) {
            case 16:
            case 17:
               if(var4.put(new Integer(var6 + 8), Boolean.TRUE) == null) {
                  ++var7;
               }
            case 0:
            case 1:
               if(var4.put(new Integer(var6 + var15 * 4 + 4), Boolean.TRUE) == null) {
                  ++var7;
               }
            default:
               break label69;
            }
         case 3:
            if(var4.put(new Integer(var6 + 8), Boolean.TRUE) == null) {
               ++var7;
            }
         case 2:
            if(var4.put(new Integer(var6 & -268435456 | var18 << 2), Boolean.TRUE) == null) {
               ++var7;
            }
            break;
         case 4:
         case 5:
         case 6:
         case 7:
            if(var4.put(new Integer(var6 + var15 * 4 + 4), Boolean.TRUE) == null) {
               ++var7;
            }
         case 8:
         case 10:
         case 11:
         case 12:
         case 13:
         case 14:
         case 16:
         default:
            break;
         case 9:
            if(var6 - var9[var13] <= 128) {
               int var20 = (var8[var13] << 16) + var15;
               if((var20 & 3) == 0 && var20 >= var1 && var20 < var1 + var3 && var4.put(new Integer(var20), Boolean.TRUE) == null) {
                  ++var7;
               }

               if(var14 == var13) {
                  var9[var13] = 0;
               }
            }
            break;
         case 15:
            var8[var14] = var16;
            var9[var14] = var6;
            break;
         case 17:
            switch(var13) {
            case 8:
               if(var4.put(new Integer(var6 + var15 * 4 + 4), Boolean.TRUE) == null) {
                  ++var7;
               }
            }
         }

         ++var10;
      }

      var2.close();
      if(this.printStats) {
         System.err.println("Found " + var7 + " additional possible branch targets in Text segment");
      }

   }

   private void findBranchesInData(DataInputStream var1, int var2, Hashtable var3, int var4, int var5) {
      int var6 = var2 / 4;
      int var7 = 0;

      for(int var8 = 0; var8 < var6; ++var8) {
         int var9 = var1.readInt();
         if((var9 & 3) == 0 && var9 >= var4 && var9 < var5 && var3.put(new Integer(var9), Boolean.TRUE) == null) {
            ++var7;
         }
      }

      var1.close();
      if(var7 > 0 && this.printStats) {
         System.err.println("Found " + var7 + " additional possible branch targets in Data segment");
      }

   }

   static final String toHex(int var0) {
      return "0x" + Long.toString((long)var0 & 4294967295L, 16);
   }

   static final String toHex8(int var0) {
      String var1 = Long.toString((long)var0 & 4294967295L, 16);
      StringBuffer var2 = new StringBuffer("0x");

      for(int var3 = 8 - var1.length(); var3 > 0; --var3) {
         var2.append('0');
      }

      var2.append(var1);
      return var2.toString();
   }

   static final String toOctal3(int var0) {
      char[] var1 = new char[3];

      for(int var2 = 2; var2 >= 0; --var2) {
         var1[var2] = (char)(48 + (var0 & 7));
         var0 >>= 3;
      }

      return new String(var1);
   }

   private Compiler$Option getOption(String var1) {
      var1 = var1.toLowerCase();

      try {
         for(int var2 = 0; var2 < options.length; var2 += 2) {
            if(options[var2].toLowerCase().equals(var1)) {
               return new Compiler$Option(this, options[var2]);
            }
         }

         return null;
      } catch (NoSuchFieldException var3) {
         return null;
      }
   }

   public void parseOptions(String var1) {
      if(var1 != null && var1.length() != 0) {
         StringTokenizer var2 = new StringTokenizer(var1, ",");

         while(true) {
            while(var2.hasMoreElements()) {
               String var3 = var2.nextToken();
               String var4;
               String var5;
               if(var3.indexOf("=") != -1) {
                  var4 = var3.substring(0, var3.indexOf("="));
                  var5 = var3.substring(var3.indexOf("=") + 1);
               } else if(var3.startsWith("no")) {
                  var4 = var3.substring(2);
                  var5 = "false";
               } else {
                  var4 = var3;
                  var5 = "true";
               }

               Compiler$Option var6 = this.getOption(var4);
               if(var6 == null) {
                  System.err.println("WARNING: No such option: " + var4);
               } else if(var6.getType() == (class$java$lang$String == null?(class$java$lang$String = class$("java.lang.String")):class$java$lang$String)) {
                  var6.set(var5);
               } else if(var6.getType() == Integer.TYPE) {
                  try {
                     var6.set(parseInt(var5));
                  } catch (NumberFormatException var8) {
                     System.err.println("WARNING: " + var5 + " is not an integer");
                  }
               } else {
                  if(var6.getType() != Boolean.TYPE) {
                     throw new Error("Unknown type: " + var6.getType());
                  }

                  var6.set(new Boolean(var5.toLowerCase().equals("true") || var5.toLowerCase().equals("yes")));
               }
            }

            return;
         }
      }
   }

   private static Integer parseInt(String var0) {
      int var1 = 1;
      var0 = var0.toLowerCase();
      if(!var0.startsWith("0x") && var0.endsWith("m")) {
         var0 = var0.substring(0, var0.length() - 1);
         var1 = 1048576;
      } else if(!var0.startsWith("0x") && var0.endsWith("k")) {
         var0 = var0.substring(0, var0.length() - 1);
         var1 = 1024;
      }

      int var2;
      if(var0.length() > 2 && var0.startsWith("0x")) {
         var2 = Integer.parseInt(var0.substring(2), 16);
      } else {
         var2 = Integer.parseInt(var0);
      }

      return new Integer(var2 * var1);
   }

   private static String wrapAndIndent(String var0, int var1, int var2, int var3) {
      StringTokenizer var4 = new StringTokenizer(var0, " ");
      StringBuffer var5 = new StringBuffer();

      int var6;
      for(var6 = 0; var6 < var1; ++var6) {
         var5.append(' ');
      }

      String var7;
      for(var6 = 0; var4.hasMoreTokens(); var6 += var7.length()) {
         var7 = var4.nextToken();
         if(var7.length() + var6 + 1 > var3 && var6 > 0) {
            var5.append('\n');

            for(int var8 = 0; var8 < var2; ++var8) {
               var5.append(' ');
            }

            var6 = 0;
         } else if(var6 > 0) {
            var5.append(' ');
            ++var6;
         }

         var5.append(var7);
      }

      var5.append('\n');
      return var5.toString();
   }

   static String dateTime() {
      try {
         return (new Date()).toString();
      } catch (RuntimeException var1) {
         return "<unknown>";
      }
   }

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw new NoClassDefFoundError(var2.getMessage());
      }
   }
}
