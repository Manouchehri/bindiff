package org.ibex.nestedvm;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import org.ibex.classgen.CGConst;
import org.ibex.classgen.ClassFile;
import org.ibex.classgen.MethodGen;
import org.ibex.classgen.Type;
import org.ibex.classgen.ClassFile.Exn;
import org.ibex.classgen.MethodGen.Pair;
import org.ibex.classgen.MethodGen.PhantomTarget;
import org.ibex.classgen.MethodGen.Switch.Lookup;
import org.ibex.classgen.MethodGen.Switch.Table;
import org.ibex.classgen.Type.Class;
import org.ibex.nestedvm.Compiler;
import org.ibex.nestedvm.Compiler$Exn;
import org.ibex.nestedvm.util.ELF$SHeader;
import org.ibex.nestedvm.util.ELF$Symbol;
import org.ibex.nestedvm.util.Seekable;
import org.ibex.nestedvm.util.Seekable$File;

public class ClassFileCompiler extends Compiler implements CGConst {
   private static final boolean OPTIMIZE_CP = true;
   private OutputStream os;
   private File outDir;
   private PrintStream warn;
   private final Class me;
   private ClassFile cg;
   private MethodGen clinit;
   private MethodGen init;
   private static int initDataCount;
   private int startOfMethod;
   private int endOfMethod;
   private PhantomTarget returnTarget;
   private PhantomTarget defaultTarget;
   private PhantomTarget[] insnTargets;
   private MethodGen mg;
   private static final int UNREACHABLE = 1;
   private static final int SKIP_NEXT = 2;
   private boolean textDone;
   private static final Float POINT_5_F = new Float(0.5F);
   private static final Double POINT_5_D = new Double(0.5D);
   private static final Long FFFFFFFF = new Long(4294967295L);
   private static final int R = 0;
   private static final int F = 32;
   private static final int HI = 64;
   private static final int LO = 65;
   private static final int FCSR = 66;
   private static final int REG_COUNT = 67;
   private static final String[] regField = new String[]{"r0", "r1", "r2", "r3", "r4", "r5", "r6", "r7", "r8", "r9", "r10", "r11", "r12", "r13", "r14", "r15", "r16", "r17", "r18", "r19", "r20", "r21", "r22", "r23", "r24", "r25", "r26", "r27", "r28", "r29", "r30", "r31", "f0", "f1", "f2", "f3", "f4", "f5", "f6", "f7", "f8", "f9", "f10", "f11", "f12", "f13", "f14", "f15", "f16", "f17", "f18", "f19", "f20", "f21", "f22", "f23", "f24", "f25", "f26", "f27", "f28", "f29", "f30", "f31", "hi", "lo", "fcsr"};
   private static final int MAX_LOCALS = 4;
   private static final int LOAD_LENGTH = 3;
   private int[] regLocalMapping;
   private boolean[] regLocalWritten;
   private int nextAvailLocal;
   private int loadsStart;
   private int preSetRegStackPos;
   private int[] preSetRegStack;
   private int memWriteStage;
   private boolean didPreMemRead;
   private boolean preMemReadDoPreWrite;

   public ClassFileCompiler(String var1, String var2, OutputStream var3) {
      this((Seekable)(new Seekable$File(var1)), var2, (OutputStream)var3);
   }

   public ClassFileCompiler(Seekable var1, String var2, OutputStream var3) {
      this(var1, var2);
      if(var3 == null) {
         throw new NullPointerException();
      } else {
         this.os = var3;
      }
   }

   public ClassFileCompiler(Seekable var1, String var2, File var3) {
      this(var1, var2);
      if(var3 == null) {
         throw new NullPointerException();
      } else {
         this.outDir = var3;
      }
   }

   private ClassFileCompiler(Seekable var1, String var2) {
      super(var1, var2);
      this.warn = System.err;
      this.startOfMethod = 0;
      this.endOfMethod = 0;
      this.regLocalMapping = new int[67];
      this.regLocalWritten = new boolean[67];
      this.preSetRegStack = new int[8];
      this.me = Class.instance(this.fullClassName);
   }

   public void setWarnWriter(PrintStream var1) {
      this.warn = var1;
   }

   protected void _go() {
      try {
         this.__go();
      } catch (Exn var2) {
         var2.printStackTrace(this.warn);
         throw new Compiler$Exn("Class generation exception: " + var2.toString());
      }
   }

   private void __go() {
      if(!this.pruneCases) {
         throw new Compiler$Exn("-o prunecases MUST be enabled for ClassFileCompiler");
      } else {
         Class var1 = Class.instance(this.runtimeClass);
         this.cg = new ClassFile(this.me, var1, 49);
         if(this.source != null) {
            this.cg.setSourceFile(this.source);
         }

         this.cg.addField("pc", Type.INT, 2);
         this.cg.addField("hi", Type.INT, 2);
         this.cg.addField("lo", Type.INT, 2);
         this.cg.addField("fcsr", Type.INT, 2);

         int var2;
         for(var2 = 1; var2 < 32; ++var2) {
            this.cg.addField("r" + var2, Type.INT, 2);
         }

         for(var2 = 0; var2 < 32; ++var2) {
            this.cg.addField("f" + var2, this.singleFloat?Type.FLOAT:Type.INT, 2);
         }

         this.clinit = this.cg.addMethod("<clinit>", Type.VOID, Type.NO_ARGS, 10);
         this.init = this.cg.addMethod("<init>", Type.VOID, Type.NO_ARGS, 1);
         this.init.add((byte)42);
         this.init.add((byte)18, this.pageSize);
         this.init.add((byte)18, this.totalPages);
         this.init.add((byte)-73, this.me.method("<init>", Type.VOID, new Type[]{Type.INT, Type.INT}));
         this.init.add((byte)-79);
         this.init = this.cg.addMethod("<init>", Type.VOID, new Type[]{Type.BOOLEAN}, 1);
         this.init.add((byte)42);
         this.init.add((byte)18, this.pageSize);
         this.init.add((byte)18, this.totalPages);
         this.init.add((byte)27);
         this.init.add((byte)-73, this.me.method("<init>", Type.VOID, new Type[]{Type.INT, Type.INT, Type.BOOLEAN}));
         this.init.add((byte)-79);
         this.init = this.cg.addMethod("<init>", Type.VOID, new Type[]{Type.INT, Type.INT}, 1);
         this.init.add((byte)42);
         this.init.add((byte)27);
         this.init.add((byte)28);
         this.init.add((byte)3);
         this.init.add((byte)-73, this.me.method("<init>", Type.VOID, new Type[]{Type.INT, Type.INT, Type.BOOLEAN}));
         this.init.add((byte)-79);
         this.init = this.cg.addMethod("<init>", Type.VOID, new Type[]{Type.INT, Type.INT, Type.BOOLEAN}, 1);
         this.init.add((byte)42);
         this.init.add((byte)27);
         this.init.add((byte)28);
         this.init.add((byte)29);
         this.init.add((byte)-73, var1.method("<init>", Type.VOID, new Type[]{Type.INT, Type.INT, Type.BOOLEAN}));
         if(this.onePage) {
            this.cg.addField("page", Type.INT.makeArray(), 18);
            this.init.add((byte)42);
            this.init.add((byte)89);
            this.init.add((byte)-76, this.me.field("readPages", Type.INT.makeArray(2)));
            this.init.add((byte)18, 0);
            this.init.add((byte)50);
            this.init.add((byte)-75, this.me.field("page", Type.INT.makeArray()));
         }

         if(this.supportCall) {
            this.cg.addField("symbols", Class.instance(this.hashClass), 26);
         }

         var2 = 0;

         for(int var3 = 0; var3 < this.elf.sheaders.length; ++var3) {
            ELF$SHeader var4 = this.elf.sheaders[var3];
            String var5 = var4.name;
            if(var4.addr != 0) {
               var2 = Math.max(var2, var4.addr + var4.size);
               if(var5.equals(".text")) {
                  this.emitText(var4.addr, new DataInputStream(var4.getInputStream()), var4.size);
               } else if(!var5.equals(".data") && !var5.equals(".sdata") && !var5.equals(".rodata") && !var5.equals(".ctors") && !var5.equals(".dtors")) {
                  if(!var5.equals(".bss") && !var5.equals(".sbss")) {
                     throw new Compiler$Exn("Unknown segment: " + var5);
                  }

                  this.emitBSS(var4.addr, var4.size);
               } else {
                  this.emitData(var4.addr, new DataInputStream(var4.getInputStream()), var4.size, var5.equals(".rodata"));
               }
            }
         }

         this.init.add((byte)-79);
         int var23;
         if(this.supportCall) {
            Class var19 = Class.instance(this.hashClass);
            this.clinit.add((byte)-69, var19);
            this.clinit.add((byte)89);
            this.clinit.add((byte)89);
            this.clinit.add((byte)-73, var19.method("<init>", Type.VOID, Type.NO_ARGS));
            this.clinit.add((byte)-77, this.me.field("symbols", var19));
            ELF$Symbol[] var21 = this.elf.getSymtab().symbols;

            for(var23 = 0; var23 < var21.length; ++var23) {
               ELF$Symbol var6 = var21[var23];
               if(var6.type == 2 && var6.binding == 1 && (var6.name.equals("_call_helper") || !var6.name.startsWith("_"))) {
                  this.clinit.add((byte)89);
                  this.clinit.add((byte)18, var6.name);
                  this.clinit.add((byte)-69, Type.INTEGER_OBJECT);
                  this.clinit.add((byte)89);
                  this.clinit.add((byte)18, var6.addr);
                  this.clinit.add((byte)-73, Type.INTEGER_OBJECT.method("<init>", Type.VOID, new Type[]{Type.INT}));
                  this.clinit.add((byte)-74, var19.method("put", Type.OBJECT, new Type[]{Type.OBJECT, Type.OBJECT}));
                  this.clinit.add((byte)87);
               }
            }

            this.clinit.add((byte)87);
         }

         this.clinit.add((byte)-79);
         ELF$SHeader var20 = this.elf.sectionWithName(".text");
         MethodGen var22 = this.cg.addMethod("trampoline", Type.VOID, Type.NO_ARGS, 2);
         var23 = var22.size();
         var22.add((byte)42);
         var22.add((byte)-76, this.me.field("state", Type.INT));
         var22.add((byte)-103, var22.size() + 2);
         var22.add((byte)-79);
         var22.add((byte)42);
         var22.add((byte)42);
         var22.add((byte)-76, this.me.field("pc", Type.INT));
         var22.add((byte)18, this.methodShift);
         var22.add((byte)124);
         int var24 = var20.addr >>> this.methodShift;
         int var7 = var20.addr + var20.size + this.maxBytesPerMethod - 1 >>> this.methodShift;
         Table var8 = new Table(var24, var7 - 1);
         var22.add((byte)-86, var8);

         for(int var9 = var24; var9 < var7; ++var9) {
            var8.setTargetForVal(var9, var22.size());
            var22.add((byte)-73, this.me.method("run_" + toHex(var9 << this.methodShift), Type.VOID, Type.NO_ARGS));
            var22.add((byte)-89, var23);
         }

         var8.setDefaultTarget(var22.size());
         var22.add((byte)87);
         var22.add((byte)-69, Class.instance("org.ibex.nestedvm.Runtime$ExecutionException"));
         var22.add((byte)89);
         var22.add((byte)-69, Type.STRINGBUFFER);
         var22.add((byte)89);
         var22.add((byte)18, "Jumped to invalid address in trampoline (r2: ");
         var22.add((byte)-73, Type.STRINGBUFFER.method("<init>", Type.VOID, new Type[]{Type.STRING}));
         var22.add((byte)42);
         var22.add((byte)-76, this.me.field("r2", Type.INT));
         var22.add((byte)-74, Type.STRINGBUFFER.method("append", Type.STRINGBUFFER, new Type[]{Type.INT}));
         var22.add((byte)18, " pc: ");
         var22.add((byte)-74, Type.STRINGBUFFER.method("append", Type.STRINGBUFFER, new Type[]{Type.STRING}));
         var22.add((byte)42);
         var22.add((byte)-76, this.me.field("pc", Type.INT));
         var22.add((byte)-74, Type.STRINGBUFFER.method("append", Type.STRINGBUFFER, new Type[]{Type.INT}));
         var22.add((byte)18, ")");
         var22.add((byte)-74, Type.STRINGBUFFER.method("append", Type.STRINGBUFFER, new Type[]{Type.STRING}));
         var22.add((byte)-74, Type.STRINGBUFFER.method("toString", Type.STRING, Type.NO_ARGS));
         var22.add((byte)-73, Class.instance("org.ibex.nestedvm.Runtime$ExecutionException").method("<init>", Type.VOID, new Type[]{Type.STRING}));
         var22.add((byte)-65);
         this.addConstReturnMethod("gp", this.gp.addr);
         this.addConstReturnMethod("entryPoint", this.elf.header.entry);
         this.addConstReturnMethod("heapStart", var2);
         if(this.userInfo != null) {
            this.addConstReturnMethod("userInfoBase", this.userInfo.addr);
            this.addConstReturnMethod("userInfoSize", this.userInfo.size);
         }

         MethodGen var10;
         Class var25;
         if(this.supportCall) {
            var25 = Class.instance(this.hashClass);
            var10 = this.cg.addMethod("lookupSymbol", Type.INT, new Type[]{Type.STRING}, 4);
            var10.add((byte)-78, this.me.field("symbols", var25));
            var10.add((byte)43);
            var10.add((byte)-74, var25.method("get", Type.OBJECT, new Type[]{Type.OBJECT}));
            var10.add((byte)89);
            int var11 = var10.add((byte)-58);
            var10.add((byte)-64, Type.INTEGER_OBJECT);
            var10.add((byte)-74, Type.INTEGER_OBJECT.method("intValue", Type.INT, Type.NO_ARGS));
            var10.add((byte)-84);
            var10.setArg(var11, var10.size());
            var10.add((byte)87);
            var10.add((byte)2);
            var10.add((byte)-84);
         }

         var25 = Class.instance("org.ibex.nestedvm.Runtime$CPUState");
         var10 = this.cg.addMethod("setCPUState", Type.VOID, new Type[]{var25}, 4);
         MethodGen var26 = this.cg.addMethod("getCPUState", Type.VOID, new Type[]{var25}, 4);
         var10.add((byte)43);
         var26.add((byte)43);
         var10.add((byte)-76, var25.field("r", Type.INT.makeArray()));
         var26.add((byte)-76, var25.field("r", Type.INT.makeArray()));
         var10.add((byte)77);
         var26.add((byte)77);

         int var12;
         for(var12 = 1; var12 < 32; ++var12) {
            var10.add((byte)42);
            var10.add((byte)44);
            var10.add((byte)18, var12);
            var10.add((byte)46);
            var10.add((byte)-75, this.me.field("r" + var12, Type.INT));
            var26.add((byte)44);
            var26.add((byte)18, var12);
            var26.add((byte)42);
            var26.add((byte)-76, this.me.field("r" + var12, Type.INT));
            var26.add((byte)79);
         }

         var10.add((byte)43);
         var26.add((byte)43);
         var10.add((byte)-76, var25.field("f", Type.INT.makeArray()));
         var26.add((byte)-76, var25.field("f", Type.INT.makeArray()));
         var10.add((byte)77);
         var26.add((byte)77);

         for(var12 = 0; var12 < 32; ++var12) {
            var10.add((byte)42);
            var10.add((byte)44);
            var10.add((byte)18, var12);
            var10.add((byte)46);
            if(this.singleFloat) {
               var10.add((byte)-72, Type.FLOAT_OBJECT.method("intBitsToFloat", Type.FLOAT, new Type[]{Type.INT}));
            }

            var10.add((byte)-75, this.me.field("f" + var12, this.singleFloat?Type.FLOAT:Type.INT));
            var26.add((byte)44);
            var26.add((byte)18, var12);
            var26.add((byte)42);
            var26.add((byte)-76, this.me.field("f" + var12, this.singleFloat?Type.FLOAT:Type.INT));
            if(this.singleFloat) {
               var26.add((byte)-72, Type.FLOAT_OBJECT.method("floatToIntBits", Type.INT, new Type[]{Type.FLOAT}));
            }

            var26.add((byte)79);
         }

         String[] var27 = new String[]{"hi", "lo", "fcsr", "pc"};

         for(int var13 = 0; var13 < var27.length; ++var13) {
            var10.add((byte)42);
            var10.add((byte)43);
            var10.add((byte)-76, var25.field(var27[var13], Type.INT));
            var10.add((byte)-75, this.me.field(var27[var13], Type.INT));
            var26.add((byte)43);
            var26.add((byte)42);
            var26.add((byte)-76, this.me.field(var27[var13], Type.INT));
            var26.add((byte)-75, var25.field(var27[var13], Type.INT));
         }

         var10.add((byte)-79);
         var26.add((byte)-79);
         MethodGen var28 = this.cg.addMethod("_execute", Type.VOID, Type.NO_ARGS, 4);
         int var14 = var28.size();
         var28.add((byte)42);
         var28.add((byte)-73, this.me.method("trampoline", Type.VOID, Type.NO_ARGS));
         int var15 = var28.size();
         var28.add((byte)-79);
         int var16 = var28.size();
         var28.add((byte)76);
         var28.add((byte)-69, Class.instance("org.ibex.nestedvm.Runtime$FaultException"));
         var28.add((byte)89);
         var28.add((byte)43);
         var28.add((byte)-73, Class.instance("org.ibex.nestedvm.Runtime$FaultException").method("<init>", Type.VOID, new Type[]{Class.instance("java.lang.RuntimeException")}));
         var28.add((byte)-65);
         var28.addExceptionHandler(var14, var15, var16, Class.instance("java.lang.RuntimeException"));
         var28.addThrow(Class.instance("org.ibex.nestedvm.Runtime$ExecutionException"));
         MethodGen var17 = this.cg.addMethod("main", Type.VOID, new Type[]{Type.STRING.makeArray()}, 9);
         var17.add((byte)-69, this.me);
         var17.add((byte)89);
         var17.add((byte)-73, this.me.method("<init>", Type.VOID, Type.NO_ARGS));
         var17.add((byte)18, this.fullClassName);
         var17.add((byte)42);
         if(this.unixRuntime) {
            Class var18 = Class.instance("org.ibex.nestedvm.UnixRuntime");
            var17.add((byte)-72, var18.method("runAndExec", Type.INT, new Type[]{var18, Type.STRING, Type.STRING.makeArray()}));
         } else {
            var17.add((byte)-74, this.me.method("run", Type.INT, new Type[]{Type.STRING, Type.STRING.makeArray()}));
         }

         var17.add((byte)-72, Class.instance("java.lang.System").method("exit", Type.VOID, new Type[]{Type.INT}));
         var17.add((byte)-79);
         if(this.outDir != null) {
            if(!this.outDir.isDirectory()) {
               throw new IOException("" + this.outDir + " isn\'t a directory");
            }

            this.cg.dump(this.outDir);
         } else {
            this.cg.dump(this.os);
         }

      }
   }

   private void addConstReturnMethod(String var1, int var2) {
      MethodGen var3 = this.cg.addMethod(var1, Type.INT, Type.NO_ARGS, 4);
      var3.add((byte)18, var2);
      var3.add((byte)-84);
   }

   private void emitData(int var1, DataInputStream var2, int var3, boolean var4) {
      if((var1 & 3) == 0 && (var3 & 3) == 0) {
         int var6;
         for(int var5 = var1 + var3; var1 < var5; var3 -= var6) {
            var6 = Math.min(var3, 28000);
            StringBuffer var7 = new StringBuffer();

            for(int var8 = 0; var8 < var6; var8 += 7) {
               long var9 = 0L;

               int var11;
               for(var11 = 0; var11 < 7; ++var11) {
                  var9 <<= 8;
                  byte var12 = var8 + var11 < var3?var2.readByte():1;
                  var9 |= (long)var12 & 255L;
               }

               for(var11 = 0; var11 < 8; ++var11) {
                  var7.append((char)((int)(var9 >>> 7 * (7 - var11) & 127L)));
               }
            }

            String var13 = "_data" + ++initDataCount;
            this.cg.addField(var13, Type.INT.makeArray(), 26);
            this.clinit.add((byte)18, var7.toString());
            this.clinit.add((byte)18, var6 / 4);
            this.clinit.add((byte)-72, Class.instance("org.ibex.nestedvm.Runtime").method("decodeData", Type.INT.makeArray(), new Type[]{Type.STRING, Type.INT}));
            this.clinit.add((byte)-77, this.me.field(var13, Type.INT.makeArray()));
            this.init.add((byte)42);
            this.init.add((byte)-78, this.me.field(var13, Type.INT.makeArray()));
            this.init.add((byte)18, var1);
            this.init.add((byte)18, var4?1:0);
            this.init.add((byte)-74, this.me.method("initPages", Type.VOID, new Type[]{Type.INT.makeArray(), Type.INT, Type.BOOLEAN}));
            var1 += var6;
         }

         var2.close();
      } else {
         throw new Compiler$Exn("Data section on weird boundaries");
      }
   }

   private void emitBSS(int var1, int var2) {
      if((var1 & 3) != 0) {
         throw new Compiler$Exn("BSS section on weird boundaries");
      } else {
         var2 = var2 + 3 & -4;
         int var3 = var2 / 4;
         this.init.add((byte)42);
         this.init.add((byte)18, var1);
         this.init.add((byte)18, var3);
         this.init.add((byte)-74, this.me.method("clearPages", Type.VOID, new Type[]{Type.INT, Type.INT}));
      }
   }

   private boolean jumpable(int var1) {
      return this.jumpableAddresses.get(new Integer(var1)) != null;
   }

   private void emitText(int var1, DataInputStream var2, int var3) {
      if(this.textDone) {
         throw new Compiler$Exn("Multiple text segments");
      } else {
         this.textDone = true;
         if((var1 & 3) == 0 && (var3 & 3) == 0) {
            int var4 = var3 / 4;
            int var6 = -1;
            boolean var7 = true;
            boolean var8 = false;

            for(int var9 = 0; var9 < var4; var1 += 4) {
               int var5 = var7?var2.readInt():var6;
               var6 = var9 == var4 - 1?-1:var2.readInt();
               if(var1 >= this.endOfMethod) {
                  this.endMethod(var1, var8);
                  this.startMethod(var1);
               }

               label69: {
                  if(this.insnTargets[var9 % this.maxInsnPerMethod] != null) {
                     this.insnTargets[var9 % this.maxInsnPerMethod].setTarget(this.mg.size());
                     var8 = false;
                  } else if(var8) {
                     break label69;
                  }

                  try {
                     int var10 = this.emitInstruction(var1, var5, var6);
                     var8 = (var10 & 1) != 0;
                     var7 = (var10 & 2) != 0;
                  } catch (Compiler$Exn var11) {
                     var11.printStackTrace(this.warn);
                     this.warn.println("Exception at " + toHex(var1));
                     throw var11;
                  } catch (RuntimeException var12) {
                     this.warn.println("Exception at " + toHex(var1));
                     throw var12;
                  }

                  if(var7) {
                     var1 += 4;
                     ++var9;
                  }
               }

               ++var9;
            }

            this.endMethod(0, var8);
            var2.close();
         } else {
            throw new Compiler$Exn("Section on weird boundaries");
         }
      }
   }

   private void startMethod(int var1) {
      this.startOfMethod = var1 & this.methodMask;
      this.endOfMethod = this.startOfMethod + this.maxBytesPerMethod;
      this.mg = this.cg.addMethod("run_" + toHex(this.startOfMethod), Type.VOID, Type.NO_ARGS, 18);
      if(this.onePage) {
         this.mg.add((byte)42);
         this.mg.add((byte)-76, this.me.field("page", Type.INT.makeArray()));
         this.mg.add((byte)77);
      } else {
         this.mg.add((byte)42);
         this.mg.add((byte)-76, this.me.field("readPages", Type.INT.makeArray(2)));
         this.mg.add((byte)77);
         this.mg.add((byte)42);
         this.mg.add((byte)-76, this.me.field("writePages", Type.INT.makeArray(2)));
         this.mg.add((byte)78);
      }

      this.returnTarget = new PhantomTarget();
      this.insnTargets = new PhantomTarget[this.maxBytesPerMethod / 4];
      int[] var2 = new int[this.maxBytesPerMethod / 4];
      Object[] var3 = new Object[this.maxBytesPerMethod / 4];
      int var4 = 0;

      for(int var5 = var1; var5 < this.endOfMethod; var5 += 4) {
         if(this.jumpable(var5)) {
            var3[var4] = this.insnTargets[(var5 - this.startOfMethod) / 4] = new PhantomTarget();
            var2[var4] = var5;
            ++var4;
         }
      }

      Lookup var6 = new Lookup(var4);
      System.arraycopy(var2, 0, var6.vals, 0, var4);
      System.arraycopy(var3, 0, var6.targets, 0, var4);
      var6.setDefaultTarget(this.defaultTarget = new PhantomTarget());
      this.fixupRegsStart();
      this.mg.add((byte)42);
      this.mg.add((byte)-76, this.me.field("pc", Type.INT));
      this.mg.add((byte)-85, var6);
   }

   private void endMethod(int var1, boolean var2) {
      if(this.startOfMethod != 0) {
         if(!var2) {
            this.preSetPC();
            this.mg.add((byte)18, var1);
            this.setPC();
            this.jumpableAddresses.put(new Integer(var1), Boolean.TRUE);
         }

         this.returnTarget.setTarget(this.mg.size());
         this.fixupRegsEnd();
         this.mg.add((byte)-79);
         this.defaultTarget.setTarget(this.mg.size());
         if(this.debugCompiler) {
            this.mg.add((byte)-69, Class.instance("org.ibex.nestedvm.Runtime$ExecutionException"));
            this.mg.add((byte)89);
            this.mg.add((byte)-69, Type.STRINGBUFFER);
            this.mg.add((byte)89);
            this.mg.add((byte)18, "Jumped to invalid address: ");
            this.mg.add((byte)-73, Type.STRINGBUFFER.method("<init>", Type.VOID, new Type[]{Type.STRING}));
            this.mg.add((byte)42);
            this.mg.add((byte)-76, this.me.field("pc", Type.INT));
            this.mg.add((byte)-74, Type.STRINGBUFFER.method("append", Type.STRINGBUFFER, new Type[]{Type.INT}));
            this.mg.add((byte)-74, Type.STRINGBUFFER.method("toString", Type.STRING, Type.NO_ARGS));
            this.mg.add((byte)-73, Class.instance("org.ibex.nestedvm.Runtime$ExecutionException").method("<init>", Type.VOID, new Type[]{Type.STRING}));
            this.mg.add((byte)-65);
         } else {
            this.mg.add((byte)-69, Class.instance("org.ibex.nestedvm.Runtime$ExecutionException"));
            this.mg.add((byte)89);
            this.mg.add((byte)18, "Jumped to invalid address");
            this.mg.add((byte)-73, Class.instance("org.ibex.nestedvm.Runtime$ExecutionException").method("<init>", Type.VOID, new Type[]{Type.STRING}));
            this.mg.add((byte)-65);
         }

         this.endOfMethod = this.startOfMethod = 0;
      }
   }

   private void leaveMethod() {
      this.mg.add((byte)-89, this.returnTarget);
   }

   private void link(int var1) {
      this.preSetReg(31);
      if(this.lessConstants) {
         int var2 = var1 + 8 + '耀' & -65536;
         int var3 = var1 + 8 - var2;
         if(var3 < -32768 || var3 > 32767) {
            throw new Error("should never happen " + var3);
         }

         this.mg.add((byte)18, var2);
         this.mg.add((byte)18, var3);
         this.mg.add((byte)96);
      } else {
         this.mg.add((byte)18, var1 + 8);
      }

      this.setReg();
   }

   private void branch(int var1, int var2) {
      if((var1 & this.methodMask) == (var2 & this.methodMask)) {
         this.mg.add((byte)-89, this.insnTargets[(var2 - this.startOfMethod) / 4]);
      } else {
         this.preSetPC();
         this.mg.add((byte)18, var2);
         this.setPC();
         this.leaveMethod();
      }

   }

   private int doIfInstruction(byte var1, int var2, int var3, int var4) {
      this.emitInstruction(-1, var4, -1);
      int var5;
      if((var3 & this.methodMask) == (var2 & this.methodMask)) {
         this.mg.add(var1, this.insnTargets[(var3 - this.startOfMethod) / 4]);
      } else {
         var5 = this.mg.add(MethodGen.negate(var1));
         this.branch(var2, var3);
         this.mg.setArg(var5, this.mg.size());
      }

      if(!this.jumpable(var2 + 4)) {
         return 2;
      } else if(var2 + 4 == this.endOfMethod) {
         this.jumpableAddresses.put(new Integer(var2 + 8), Boolean.TRUE);
         this.branch(var2, var2 + 8);
         return 1;
      } else {
         var5 = this.mg.add((byte)-89);
         this.insnTargets[(var2 + 4 - this.startOfMethod) / 4].setTarget(this.mg.size());
         this.emitInstruction(-1, var4, 1);
         this.mg.setArg(var5, this.mg.size());
         return 2;
      }
   }

   private int emitInstruction(int var1, int var2, int var3) {
      MethodGen var4 = this.mg;
      if(var2 == -1) {
         throw new Compiler$Exn("insn is -1");
      } else {
         int var5 = 0;
         int var6 = var2 >>> 26 & 255;
         int var7 = var2 >>> 21 & 31;
         int var8 = var2 >>> 16 & 31;
         int var9 = var2 >>> 16 & 31;
         int var10 = var2 >>> 11 & 31;
         int var11 = var2 >>> 11 & 31;
         int var12 = var2 >>> 6 & 31;
         int var13 = var2 >>> 6 & 31;
         int var14 = var2 & 63;
         int var15 = var2 >>> 6 & 1048575;
         int var16 = var2 & 67108863;
         int var17 = var2 & '\uffff';
         int var18 = var2 << 16 >> 16;
         int var20;
         int var21;
         switch(var6) {
         case 0:
            switch(var14) {
            case 0:
               if(var2 != 0) {
                  this.preSetReg(0 + var10);
                  this.pushRegWZ(0 + var8);
                  var4.add((byte)18, var12);
                  var4.add((byte)120);
                  this.setReg();
               }

               return var5;
            case 1:
            case 5:
            case 10:
            case 11:
            case 14:
            case 15:
            case 20:
            case 21:
            case 22:
            case 23:
            case 28:
            case 29:
            case 30:
            case 31:
            case 40:
            case 41:
            default:
               throw new Compiler$Exn("Illegal instruction 0/" + var14);
            case 2:
               this.preSetReg(0 + var10);
               this.pushRegWZ(0 + var8);
               var4.add((byte)18, var12);
               var4.add((byte)124);
               this.setReg();
               return var5;
            case 3:
               this.preSetReg(0 + var10);
               this.pushRegWZ(0 + var8);
               var4.add((byte)18, var12);
               var4.add((byte)122);
               this.setReg();
               return var5;
            case 4:
               this.preSetReg(0 + var10);
               this.pushRegWZ(0 + var8);
               this.pushRegWZ(0 + var7);
               var4.add((byte)120);
               this.setReg();
               return var5;
            case 6:
               this.preSetReg(0 + var10);
               this.pushRegWZ(0 + var8);
               this.pushRegWZ(0 + var7);
               var4.add((byte)124);
               this.setReg();
               return var5;
            case 7:
               this.preSetReg(0 + var10);
               this.pushRegWZ(0 + var8);
               this.pushRegWZ(0 + var7);
               var4.add((byte)122);
               this.setReg();
               return var5;
            case 8:
               if(var1 == -1) {
                  throw new Compiler$Exn("pc modifying insn in delay slot");
               }

               this.emitInstruction(-1, var3, -1);
               this.preSetPC();
               this.pushRegWZ(0 + var7);
               this.setPC();
               this.leaveMethod();
               var5 |= 1;
               return var5;
            case 9:
               if(var1 == -1) {
                  throw new Compiler$Exn("pc modifying insn in delay slot");
               }

               this.emitInstruction(-1, var3, -1);
               this.link(var1);
               this.preSetPC();
               this.pushRegWZ(0 + var7);
               this.setPC();
               this.leaveMethod();
               var5 |= 1;
               return var5;
            case 12:
               this.preSetPC();
               var4.add((byte)18, var1);
               this.setPC();
               this.restoreChangedRegs();
               this.preSetReg(2);
               var4.add((byte)42);
               this.pushRegZ(2);
               this.pushRegZ(4);
               this.pushRegZ(5);
               this.pushRegZ(6);
               this.pushRegZ(7);
               this.pushRegZ(8);
               this.pushRegZ(9);
               var4.add((byte)-74, this.me.method("syscall", Type.INT, new Type[]{Type.INT, Type.INT, Type.INT, Type.INT, Type.INT, Type.INT, Type.INT}));
               this.setReg();
               var4.add((byte)42);
               var4.add((byte)-76, this.me.field("state", Type.INT));
               var20 = var4.add((byte)-103);
               this.preSetPC();
               var4.add((byte)18, var1 + 4);
               this.setPC();
               this.leaveMethod();
               var4.setArg(var20, var4.size());
               return var5;
            case 13:
               var4.add((byte)-69, Class.instance("org.ibex.nestedvm.Runtime$ExecutionException"));
               var4.add((byte)89);
               var4.add((byte)18, "BREAK Code " + toHex(var15));
               var4.add((byte)-73, Class.instance("org.ibex.nestedvm.Runtime$ExecutionException").method("<init>", Type.VOID, new Type[]{Type.STRING}));
               var4.add((byte)-65);
               var5 |= 1;
               return var5;
            case 16:
               this.preSetReg(0 + var10);
               this.pushReg(64);
               this.setReg();
               return var5;
            case 17:
               this.preSetReg(64);
               this.pushRegZ(0 + var7);
               this.setReg();
               return var5;
            case 18:
               this.preSetReg(0 + var10);
               this.pushReg(65);
               this.setReg();
               return var5;
            case 19:
               this.preSetReg(65);
               this.pushRegZ(0 + var7);
               this.setReg();
               return var5;
            case 24:
               this.pushRegWZ(0 + var7);
               var4.add((byte)-123);
               this.pushRegWZ(0 + var8);
               var4.add((byte)-123);
               var4.add((byte)105);
               var4.add((byte)92);
               var4.add((byte)-120);
               if(this.preSetReg(65)) {
                  var4.add((byte)95);
               }

               this.setReg();
               var4.add((byte)18, 32);
               var4.add((byte)125);
               var4.add((byte)-120);
               if(this.preSetReg(64)) {
                  var4.add((byte)95);
               }

               this.setReg();
               return var5;
            case 25:
               this.pushRegWZ(0 + var7);
               var4.add((byte)-123);
               var4.add((byte)18, FFFFFFFF);
               var4.add((byte)127);
               this.pushRegWZ(0 + var8);
               var4.add((byte)-123);
               var4.add((byte)18, FFFFFFFF);
               var4.add((byte)127);
               var4.add((byte)105);
               var4.add((byte)92);
               var4.add((byte)-120);
               if(this.preSetReg(65)) {
                  var4.add((byte)95);
               }

               this.setReg();
               var4.add((byte)18, 32);
               var4.add((byte)125);
               var4.add((byte)-120);
               if(this.preSetReg(64)) {
                  var4.add((byte)95);
               }

               this.setReg();
               return var5;
            case 26:
               this.pushRegWZ(0 + var7);
               this.pushRegWZ(0 + var8);
               var4.add((byte)92);
               var4.add((byte)108);
               if(this.preSetReg(65)) {
                  var4.add((byte)95);
               }

               this.setReg();
               var4.add((byte)112);
               if(this.preSetReg(64)) {
                  var4.add((byte)95);
               }

               this.setReg();
               return var5;
            case 27:
               this.pushRegWZ(0 + var8);
               var4.add((byte)89);
               this.setTmp();
               var20 = var4.add((byte)-103);
               this.pushRegWZ(0 + var7);
               var4.add((byte)-123);
               var4.add((byte)18, FFFFFFFF);
               var4.add((byte)127);
               var4.add((byte)92);
               this.pushTmp();
               var4.add((byte)-123);
               var4.add((byte)18, FFFFFFFF);
               var4.add((byte)127);
               var4.add((byte)94);
               var4.add((byte)109);
               var4.add((byte)-120);
               if(this.preSetReg(65)) {
                  var4.add((byte)95);
               }

               this.setReg();
               var4.add((byte)113);
               var4.add((byte)-120);
               if(this.preSetReg(64)) {
                  var4.add((byte)95);
               }

               this.setReg();
               var4.setArg(var20, var4.size());
               return var5;
            case 32:
               throw new Compiler$Exn("ADD (add with oveflow trap) not suported");
            case 33:
               this.preSetReg(0 + var10);
               if(var8 != 0 && var7 != 0) {
                  this.pushReg(0 + var7);
                  this.pushReg(0 + var8);
                  var4.add((byte)96);
               } else if(var7 != 0) {
                  this.pushReg(0 + var7);
               } else {
                  this.pushRegZ(0 + var8);
               }

               this.setReg();
               return var5;
            case 34:
               throw new Compiler$Exn("SUB (add with oveflow trap) not suported");
            case 35:
               this.preSetReg(0 + var10);
               if(var8 != 0 && var7 != 0) {
                  this.pushReg(0 + var7);
                  this.pushReg(0 + var8);
                  var4.add((byte)100);
               } else if(var8 != 0) {
                  this.pushReg(0 + var8);
                  var4.add((byte)116);
               } else {
                  this.pushRegZ(0 + var7);
               }

               this.setReg();
               return var5;
            case 36:
               this.preSetReg(0 + var10);
               this.pushRegWZ(0 + var7);
               this.pushRegWZ(0 + var8);
               var4.add((byte)126);
               this.setReg();
               return var5;
            case 37:
               this.preSetReg(0 + var10);
               this.pushRegWZ(0 + var7);
               this.pushRegWZ(0 + var8);
               var4.add((byte)-128);
               this.setReg();
               return var5;
            case 38:
               this.preSetReg(0 + var10);
               this.pushRegWZ(0 + var7);
               this.pushRegWZ(0 + var8);
               var4.add((byte)-126);
               this.setReg();
               return var5;
            case 39:
               this.preSetReg(0 + var10);
               if(var7 == 0 && var8 == 0) {
                  var4.add((byte)18, -1);
               } else {
                  if(var7 != 0 && var8 != 0) {
                     this.pushReg(0 + var7);
                     this.pushReg(0 + var8);
                     var4.add((byte)-128);
                  } else if(var7 != 0) {
                     this.pushReg(0 + var7);
                  } else {
                     this.pushReg(0 + var8);
                  }

                  var4.add((byte)2);
                  var4.add((byte)-126);
               }

               this.setReg();
               return var5;
            case 42:
               this.preSetReg(0 + var10);
               if(var7 != var8) {
                  this.pushRegZ(0 + var7);
                  this.pushRegZ(0 + var8);
                  var20 = var4.add((byte)-95);
                  var4.add((byte)3);
                  var21 = var4.add((byte)-89);
                  var4.setArg(var20, var4.add((byte)4));
                  var4.setArg(var21, var4.size());
               } else {
                  var4.add((byte)18, 0);
               }

               this.setReg();
               return var5;
            case 43:
               this.preSetReg(0 + var10);
               if(var7 != var8) {
                  if(var7 != 0) {
                     this.pushReg(0 + var7);
                     var4.add((byte)-123);
                     var4.add((byte)18, FFFFFFFF);
                     var4.add((byte)127);
                     this.pushReg(0 + var8);
                     var4.add((byte)-123);
                     var4.add((byte)18, FFFFFFFF);
                     var4.add((byte)127);
                     var4.add((byte)-108);
                     var20 = var4.add((byte)-101);
                  } else {
                     this.pushReg(0 + var8);
                     var20 = var4.add((byte)-102);
                  }

                  var4.add((byte)3);
                  var21 = var4.add((byte)-89);
                  var4.setArg(var20, var4.add((byte)4));
                  var4.setArg(var21, var4.size());
               } else {
                  var4.add((byte)18, 0);
               }

               this.setReg();
               return var5;
            }
         case 1:
            switch(var8) {
            case 0:
               if(var1 == -1) {
                  throw new Compiler$Exn("pc modifying insn in delay slot");
               }

               this.pushRegWZ(0 + var7);
               return this.doIfInstruction((byte)-101, var1, var1 + var18 * 4 + 4, var3);
            case 1:
               if(var1 == -1) {
                  throw new Compiler$Exn("pc modifying insn in delay slot");
               }

               this.pushRegWZ(0 + var7);
               return this.doIfInstruction((byte)-100, var1, var1 + var18 * 4 + 4, var3);
            case 16:
               if(var1 == -1) {
                  throw new Compiler$Exn("pc modifying insn in delay slot");
               }

               this.pushRegWZ(0 + var7);
               var20 = var4.add((byte)-100);
               this.emitInstruction(-1, var3, -1);
               this.link(var1);
               this.branch(var1, var1 + var18 * 4 + 4);
               var4.setArg(var20, var4.size());
               return var5;
            case 17:
               if(var1 == -1) {
                  throw new Compiler$Exn("pc modifying insn in delay slot");
               }

               var20 = -1;
               if(var7 != 0) {
                  this.pushRegWZ(0 + var7);
                  var20 = var4.add((byte)-101);
               }

               this.emitInstruction(-1, var3, -1);
               this.link(var1);
               this.branch(var1, var1 + var18 * 4 + 4);
               if(var20 != -1) {
                  var4.setArg(var20, var4.size());
               }

               if(var20 == -1) {
                  var5 |= 1;
               }

               return var5;
            default:
               throw new Compiler$Exn("Illegal Instruction 1/" + var8);
            }
         case 2:
            if(var1 == -1) {
               throw new Compiler$Exn("pc modifying insn in delay slot");
            }

            this.emitInstruction(-1, var3, -1);
            this.branch(var1, var1 & -268435456 | var16 << 2);
            var5 |= 1;
            break;
         case 3:
            if(var1 == -1) {
               throw new Compiler$Exn("pc modifying insn in delay slot");
            }

            int var24 = var1 & -268435456 | var16 << 2;
            this.emitInstruction(-1, var3, -1);
            this.link(var1);
            this.branch(var1, var24);
            var5 |= 1;
            break;
         case 4:
            if(var1 == -1) {
               throw new Compiler$Exn("pc modifying insn in delay slot");
            }

            if(var7 != var8) {
               if(var7 != 0 && var8 != 0) {
                  this.pushReg(0 + var7);
                  this.pushReg(0 + var8);
                  return this.doIfInstruction((byte)-97, var1, var1 + var18 * 4 + 4, var3);
               }

               this.pushReg(var8 == 0?0 + var7:0 + var8);
               return this.doIfInstruction((byte)-103, var1, var1 + var18 * 4 + 4, var3);
            }

            this.emitInstruction(-1, var3, -1);
            this.branch(var1, var1 + var18 * 4 + 4);
            var5 |= 1;
            break;
         case 5:
            if(var1 == -1) {
               throw new Compiler$Exn("pc modifying insn in delay slot");
            }

            this.pushRegWZ(0 + var7);
            if(var8 == 0) {
               return this.doIfInstruction((byte)-102, var1, var1 + var18 * 4 + 4, var3);
            }

            this.pushReg(0 + var8);
            return this.doIfInstruction((byte)-96, var1, var1 + var18 * 4 + 4, var3);
         case 6:
            if(var1 == -1) {
               throw new Compiler$Exn("pc modifying insn in delay slot");
            }

            this.pushRegWZ(0 + var7);
            return this.doIfInstruction((byte)-98, var1, var1 + var18 * 4 + 4, var3);
         case 7:
            if(var1 == -1) {
               throw new Compiler$Exn("pc modifying insn in delay slot");
            }

            this.pushRegWZ(0 + var7);
            return this.doIfInstruction((byte)-99, var1, var1 + var18 * 4 + 4, var3);
         case 8:
            throw new Compiler$Exn("ADDI (add immediate with oveflow trap) not suported");
         case 9:
            if(var7 != 0 && var18 != 0 && var7 == var8 && this.doLocal(var8) && var18 >= -32768 && var18 <= 32767) {
               this.regLocalWritten[var8] = true;
               var4.add((byte)-124, new Pair(this.getLocalForReg(var8), var18));
            } else {
               this.preSetReg(0 + var8);
               this.addiu(var7, var18);
               this.setReg();
            }
            break;
         case 10:
            this.preSetReg(0 + var8);
            this.pushRegWZ(0 + var7);
            var4.add((byte)18, var18);
            var20 = var4.add((byte)-95);
            var4.add((byte)3);
            var21 = var4.add((byte)-89);
            var4.setArg(var20, var4.add((byte)4));
            var4.setArg(var21, var4.size());
            this.setReg();
            break;
         case 11:
            this.preSetReg(0 + var8);
            this.pushRegWZ(0 + var7);
            var4.add((byte)-123);
            var4.add((byte)18, FFFFFFFF);
            var4.add((byte)127);
            var4.add((byte)18, new Long((long)var18 & 4294967295L));
            var4.add((byte)-108);
            var20 = var4.add((byte)-101);
            var4.add((byte)3);
            var21 = var4.add((byte)-89);
            var4.setArg(var20, var4.add((byte)4));
            var4.setArg(var21, var4.size());
            this.setReg();
            break;
         case 12:
            this.preSetReg(0 + var8);
            this.pushRegWZ(0 + var7);
            var4.add((byte)18, var17);
            var4.add((byte)126);
            this.setReg();
            break;
         case 13:
            this.preSetReg(0 + var8);
            if(var7 != 0 && var17 != 0) {
               this.pushReg(0 + var7);
               var4.add((byte)18, var17);
               var4.add((byte)-128);
            } else if(var7 != 0) {
               this.pushReg(0 + var7);
            } else {
               var4.add((byte)18, var17);
            }

            this.setReg();
            break;
         case 14:
            this.preSetReg(0 + var8);
            this.pushRegWZ(0 + var7);
            var4.add((byte)18, var17);
            var4.add((byte)-126);
            this.setReg();
            break;
         case 15:
            this.preSetReg(0 + var8);
            var4.add((byte)18, var17 << 16);
            this.setReg();
            break;
         case 16:
            throw new Compiler$Exn("TLB/Exception support not implemented");
         case 17:
            switch(var7) {
            case 0:
               this.preSetReg(0 + var8);
               this.pushReg(32 + var10);
               this.setReg();
               return var5;
            case 1:
            case 3:
            case 5:
            case 7:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 18:
            case 19:
            default:
               throw new Compiler$Exn("Invalid Instruction 17/" + var7);
            case 2:
               if(var11 != 31) {
                  throw new Compiler$Exn("FCR " + var11 + " unavailable");
               }

               this.preSetReg(0 + var8);
               this.pushReg(66);
               this.setReg();
               return var5;
            case 4:
               this.preSetReg(32 + var10);
               if(var8 != 0) {
                  this.pushReg(0 + var8);
               } else {
                  var4.add((byte)3);
               }

               this.setReg();
               return var5;
            case 6:
               if(var11 != 31) {
                  throw new Compiler$Exn("FCR " + var11 + " unavailable");
               }

               this.preSetReg(66);
               this.pushReg(0 + var8);
               this.setReg();
               return var5;
            case 8:
               this.pushReg(66);
               var4.add((byte)18, 8388608);
               var4.add((byte)126);
               return this.doIfInstruction((byte)((var2 >>> 16 & 1) == 0?-103:-102), var1, var1 + var18 * 4 + 4, var3);
            case 16:
            case 17:
               boolean var22 = var7 == 17;
               switch(var14) {
               case 0:
                  this.preSetDouble(32 + var13, var22);
                  this.pushDouble(32 + var11, var22);
                  this.pushDouble(32 + var9, var22);
                  var4.add((byte)(var22?99:98));
                  this.setDouble(var22);
                  return var5;
               case 1:
                  this.preSetDouble(32 + var13, var22);
                  this.pushDouble(32 + var11, var22);
                  this.pushDouble(32 + var9, var22);
                  var4.add((byte)(var22?103:102));
                  this.setDouble(var22);
                  return var5;
               case 2:
                  this.preSetDouble(32 + var13, var22);
                  this.pushDouble(32 + var11, var22);
                  this.pushDouble(32 + var9, var22);
                  var4.add((byte)(var22?107:106));
                  this.setDouble(var22);
                  return var5;
               case 3:
                  this.preSetDouble(32 + var13, var22);
                  this.pushDouble(32 + var11, var22);
                  this.pushDouble(32 + var9, var22);
                  var4.add((byte)(var22?111:110));
                  this.setDouble(var22);
                  return var5;
               case 5:
                  this.preSetDouble(32 + var13, var22);
                  this.pushDouble(32 + var11, var22);
                  var4.add((byte)(var22?92:89));
                  var4.add((byte)(var22?14:11));
                  var4.add((byte)(var22?-104:-106));
                  var20 = var4.add((byte)-99);
                  var4.add((byte)(var22?14:11));
                  if(var22) {
                     var4.add((byte)94);
                     var4.add((byte)88);
                  } else {
                     var4.add((byte)95);
                  }

                  var4.add((byte)(var22?103:102));
                  var4.setArg(var20, var4.size());
                  this.setDouble(var22);
                  return var5;
               case 6:
                  this.preSetReg(32 + var13);
                  this.pushReg(32 + var11);
                  this.setReg();
                  if(var22) {
                     this.preSetReg(32 + var13 + 1);
                     this.pushReg(32 + var11 + 1);
                     this.setReg();
                  }

                  return var5;
               case 7:
                  this.preSetDouble(32 + var13, var22);
                  this.pushDouble(32 + var11, var22);
                  var4.add((byte)(var22?119:118));
                  this.setDouble(var22);
                  return var5;
               case 32:
                  this.preSetFloat(32 + var13);
                  this.pushDouble(32 + var11, var22);
                  if(var22) {
                     var4.add((byte)-112);
                  }

                  this.setFloat();
                  return var5;
               case 33:
                  this.preSetDouble(32 + var13);
                  this.pushDouble(32 + var11, var22);
                  if(!var22) {
                     var4.add((byte)-115);
                  }

                  this.setDouble();
                  return var5;
               case 36:
                  Table var23 = new Table(0, 3);
                  this.preSetReg(32 + var13);
                  this.pushDouble(32 + var11, var22);
                  this.pushReg(66);
                  var4.add((byte)6);
                  var4.add((byte)126);
                  var4.add((byte)-86, var23);
                  var23.setTarget(2, var4.size());
                  if(!var22) {
                     var4.add((byte)-115);
                  }

                  var4.add((byte)-72, Class.instance("java.lang.Math").method("ceil", Type.DOUBLE, new Type[]{Type.DOUBLE}));
                  if(!var22) {
                     var4.add((byte)-112);
                  }

                  var20 = var4.add((byte)-89);
                  var23.setTarget(0, var4.size());
                  var4.add((byte)18, var22?POINT_5_D:POINT_5_F);
                  var4.add((byte)(var22?99:98));
                  var23.setTarget(3, var4.size());
                  if(!var22) {
                     var4.add((byte)-115);
                  }

                  var4.add((byte)-72, Class.instance("java.lang.Math").method("floor", Type.DOUBLE, new Type[]{Type.DOUBLE}));
                  if(!var22) {
                     var4.add((byte)-112);
                  }

                  var23.setTarget(1, var4.size());
                  var23.setDefaultTarget(var4.size());
                  var4.setArg(var20, var4.size());
                  var4.add((byte)(var22?-114:-117));
                  this.setReg();
                  return var5;
               case 50:
               case 60:
               case 62:
                  this.preSetReg(66);
                  this.pushReg(66);
                  var4.add((byte)18, -8388609);
                  var4.add((byte)126);
                  this.pushDouble(32 + var11, var22);
                  this.pushDouble(32 + var9, var22);
                  var4.add((byte)(var22?-104:-106));
                  switch(var14) {
                  case 50:
                     var20 = var4.add((byte)-102);
                     break;
                  case 60:
                     var20 = var4.add((byte)-100);
                     break;
                  case 62:
                     var20 = var4.add((byte)-99);
                     break;
                  default:
                     var20 = -1;
                  }

                  var4.add((byte)18, 8388608);
                  var4.add((byte)-128);
                  var4.setArg(var20, var4.size());
                  this.setReg();
                  return var5;
               default:
                  throw new Compiler$Exn("Invalid Instruction 17/" + var7 + "/" + var14);
               }
            case 20:
               switch(var14) {
               case 32:
                  this.preSetFloat(32 + var13);
                  this.pushReg(32 + var11);
                  var4.add((byte)-122);
                  this.setFloat();
                  return var5;
               case 33:
                  this.preSetDouble(32 + var13);
                  this.pushReg(32 + var11);
                  var4.add((byte)-121);
                  this.setDouble();
                  return var5;
               default:
                  throw new Compiler$Exn("Invalid Instruction 17/" + var7 + "/" + var14);
               }
            }
         case 18:
         case 19:
            throw new Compiler$Exn("coprocessor 2 and 3 instructions not available");
         case 20:
         case 21:
         case 22:
         case 23:
         case 24:
         case 25:
         case 26:
         case 27:
         case 28:
         case 29:
         case 30:
         case 31:
         case 39:
         case 44:
         case 45:
         case 47:
         case 50:
         case 51:
         case 52:
         case 53:
         case 54:
         case 55:
         default:
            throw new Compiler$Exn("Invalid Instruction: " + var6 + " at " + toHex(var1));
         case 32:
            this.preSetReg(0 + var8);
            this.addiu(0 + var7, var18);
            this.setTmp();
            this.preMemRead();
            this.pushTmp();
            this.memRead(true);
            this.pushTmp();
            var4.add((byte)2);
            var4.add((byte)-126);
            var4.add((byte)6);
            var4.add((byte)126);
            var4.add((byte)6);
            var4.add((byte)120);
            var4.add((byte)124);
            var4.add((byte)-111);
            this.setReg();
            break;
         case 33:
            this.preSetReg(0 + var8);
            this.addiu(0 + var7, var18);
            this.setTmp();
            this.preMemRead();
            this.pushTmp();
            this.memRead(true);
            this.pushTmp();
            var4.add((byte)2);
            var4.add((byte)-126);
            var4.add((byte)5);
            var4.add((byte)126);
            var4.add((byte)6);
            var4.add((byte)120);
            var4.add((byte)124);
            var4.add((byte)-109);
            this.setReg();
            break;
         case 34:
            this.preSetReg(0 + var8);
            this.addiu(0 + var7, var18);
            this.setTmp();
            this.pushRegWZ(0 + var8);
            var4.add((byte)18, 16777215);
            this.pushTmp();
            var4.add((byte)2);
            var4.add((byte)-126);
            var4.add((byte)6);
            var4.add((byte)126);
            var4.add((byte)6);
            var4.add((byte)120);
            var4.add((byte)124);
            var4.add((byte)126);
            this.preMemRead();
            this.pushTmp();
            this.memRead(true);
            this.pushTmp();
            var4.add((byte)6);
            var4.add((byte)126);
            var4.add((byte)6);
            var4.add((byte)120);
            var4.add((byte)120);
            var4.add((byte)-128);
            this.setReg();
            break;
         case 35:
            this.preSetReg(0 + var8);
            this.memRead(0 + var7, var18);
            this.setReg();
            break;
         case 36:
            this.preSetReg(0 + var8);
            this.addiu(0 + var7, var18);
            this.setTmp();
            this.preMemRead();
            this.pushTmp();
            this.memRead(true);
            this.pushTmp();
            var4.add((byte)2);
            var4.add((byte)-126);
            var4.add((byte)6);
            var4.add((byte)126);
            var4.add((byte)6);
            var4.add((byte)120);
            var4.add((byte)124);
            var4.add((byte)18, 255);
            var4.add((byte)126);
            this.setReg();
            break;
         case 37:
            this.preSetReg(0 + var8);
            this.addiu(0 + var7, var18);
            this.setTmp();
            this.preMemRead();
            this.pushTmp();
            this.memRead(true);
            this.pushTmp();
            var4.add((byte)2);
            var4.add((byte)-126);
            var4.add((byte)5);
            var4.add((byte)126);
            var4.add((byte)6);
            var4.add((byte)120);
            var4.add((byte)124);
            var4.add((byte)-110);
            this.setReg();
            break;
         case 38:
            this.preSetReg(0 + var8);
            this.addiu(0 + var7, var18);
            this.setTmp();
            this.pushRegWZ(0 + var8);
            var4.add((byte)18, -256);
            this.pushTmp();
            var4.add((byte)6);
            var4.add((byte)126);
            var4.add((byte)6);
            var4.add((byte)120);
            var4.add((byte)120);
            var4.add((byte)126);
            this.preMemRead();
            this.pushTmp();
            this.memRead(true);
            this.pushTmp();
            var4.add((byte)2);
            var4.add((byte)-126);
            var4.add((byte)6);
            var4.add((byte)126);
            var4.add((byte)6);
            var4.add((byte)120);
            var4.add((byte)124);
            var4.add((byte)-128);
            this.setReg();
            break;
         case 40:
            this.addiu(0 + var7, var18);
            this.setTmp();
            this.preMemRead(true);
            this.pushTmp();
            this.memRead(true);
            var4.add((byte)18, -16777216);
            this.pushTmp();
            var4.add((byte)6);
            var4.add((byte)126);
            var4.add((byte)6);
            var4.add((byte)120);
            var4.add((byte)124);
            var4.add((byte)2);
            var4.add((byte)-126);
            var4.add((byte)126);
            if(var8 != 0) {
               this.pushReg(0 + var8);
               var4.add((byte)18, 255);
               var4.add((byte)126);
            } else {
               var4.add((byte)18, 0);
            }

            this.pushTmp();
            var4.add((byte)2);
            var4.add((byte)-126);
            var4.add((byte)6);
            var4.add((byte)126);
            var4.add((byte)6);
            var4.add((byte)120);
            var4.add((byte)120);
            var4.add((byte)-128);
            this.memWrite();
            break;
         case 41:
            this.addiu(0 + var7, var18);
            this.setTmp();
            this.preMemRead(true);
            this.pushTmp();
            this.memRead(true);
            var4.add((byte)18, '\uffff');
            this.pushTmp();
            var4.add((byte)5);
            var4.add((byte)126);
            var4.add((byte)6);
            var4.add((byte)120);
            var4.add((byte)120);
            var4.add((byte)126);
            if(var8 != 0) {
               this.pushReg(0 + var8);
               var4.add((byte)18, '\uffff');
               var4.add((byte)126);
            } else {
               var4.add((byte)18, 0);
            }

            this.pushTmp();
            var4.add((byte)2);
            var4.add((byte)-126);
            var4.add((byte)5);
            var4.add((byte)126);
            var4.add((byte)6);
            var4.add((byte)120);
            var4.add((byte)120);
            var4.add((byte)-128);
            this.memWrite();
            break;
         case 42:
            this.addiu(0 + var7, var18);
            this.setTmp();
            this.preMemRead(true);
            this.pushTmp();
            this.memRead(true);
            var4.add((byte)18, -256);
            this.pushTmp();
            var4.add((byte)2);
            var4.add((byte)-126);
            var4.add((byte)6);
            var4.add((byte)126);
            var4.add((byte)6);
            var4.add((byte)120);
            var4.add((byte)120);
            var4.add((byte)126);
            this.pushRegWZ(0 + var8);
            this.pushTmp();
            var4.add((byte)6);
            var4.add((byte)126);
            var4.add((byte)6);
            var4.add((byte)120);
            var4.add((byte)124);
            var4.add((byte)-128);
            this.memWrite();
            break;
         case 43:
            this.preMemWrite1();
            this.preMemWrite2(0 + var7, var18);
            this.pushRegZ(0 + var8);
            this.memWrite();
            break;
         case 46:
            this.addiu(0 + var7, var18);
            this.setTmp();
            this.preMemRead(true);
            this.pushTmp();
            this.memRead(true);
            var4.add((byte)18, 16777215);
            this.pushTmp();
            var4.add((byte)6);
            var4.add((byte)126);
            var4.add((byte)6);
            var4.add((byte)120);
            var4.add((byte)124);
            var4.add((byte)126);
            this.pushRegWZ(0 + var8);
            this.pushTmp();
            var4.add((byte)2);
            var4.add((byte)-126);
            var4.add((byte)6);
            var4.add((byte)126);
            var4.add((byte)6);
            var4.add((byte)120);
            var4.add((byte)120);
            var4.add((byte)-128);
            this.memWrite();
            break;
         case 48:
            this.preSetReg(0 + var8);
            this.memRead(0 + var7, var18);
            this.setReg();
            break;
         case 49:
            this.preSetReg(32 + var8);
            this.memRead(0 + var7, var18);
            this.setReg();
            break;
         case 56:
            this.preSetReg(0 + var8);
            this.preMemWrite1();
            this.preMemWrite2(0 + var7, var18);
            this.pushReg(0 + var8);
            this.memWrite();
            var4.add((byte)18, 1);
            this.setReg();
            break;
         case 57:
            this.preMemWrite1();
            this.preMemWrite2(0 + var7, var18);
            this.pushReg(32 + var8);
            this.memWrite();
         }

         return var5;
      }
   }

   private boolean doLocal(int var1) {
      return var1 == 2 || var1 == 3 || var1 == 4 || var1 == 29;
   }

   private int getLocalForReg(int var1) {
      if(this.regLocalMapping[var1] != 0) {
         return this.regLocalMapping[var1];
      } else {
         this.regLocalMapping[var1] = this.nextAvailLocal++;
         return this.regLocalMapping[var1];
      }
   }

   private void fixupRegsStart() {
      int var1;
      for(var1 = 0; var1 < 67; ++var1) {
         this.regLocalMapping[var1] = 0;
         this.regLocalWritten[var1] = false;
      }

      this.nextAvailLocal = this.onePage?4:5;
      this.loadsStart = this.mg.size();

      for(var1 = 0; var1 < 12; ++var1) {
         this.mg.add((byte)0);
      }

   }

   private void fixupRegsEnd() {
      int var1 = this.loadsStart;

      for(int var2 = 0; var2 < 67; ++var2) {
         if(this.regLocalMapping[var2] != 0) {
            this.mg.set(var1++, (byte)42);
            this.mg.set(var1++, (byte)-76, this.me.field(regField[var2], Type.INT));
            this.mg.set(var1++, (byte)54, this.regLocalMapping[var2]);
            if(this.regLocalWritten[var2]) {
               this.mg.add((byte)42);
               this.mg.add((byte)21, this.regLocalMapping[var2]);
               this.mg.add((byte)-75, this.me.field(regField[var2], Type.INT));
            }
         }
      }

   }

   private void restoreChangedRegs() {
      for(int var1 = 0; var1 < 67; ++var1) {
         if(this.regLocalWritten[var1]) {
            this.mg.add((byte)42);
            this.mg.add((byte)21, this.regLocalMapping[var1]);
            this.mg.add((byte)-75, this.me.field(regField[var1], Type.INT));
         }
      }

   }

   private int pushRegWZ(int var1) {
      if(var1 == 0) {
         this.warn.println("Warning: Pushing r0!");
         (new Exception()).printStackTrace(this.warn);
      }

      return this.pushRegZ(var1);
   }

   private int pushRegZ(int var1) {
      return var1 == 0?this.mg.add((byte)3):this.pushReg(var1);
   }

   private int pushReg(int var1) {
      int var2 = this.mg.size();
      if(this.doLocal(var1)) {
         this.mg.add((byte)21, this.getLocalForReg(var1));
      } else if(var1 >= 32 && var1 <= 63 && this.singleFloat) {
         this.mg.add((byte)42);
         this.mg.add((byte)-76, this.me.field(regField[var1], Type.FLOAT));
         this.mg.add((byte)-72, Type.FLOAT_OBJECT.method("floatToIntBits", Type.INT, new Type[]{Type.FLOAT}));
      } else {
         this.mg.add((byte)42);
         this.mg.add((byte)-76, this.me.field(regField[var1], Type.INT));
      }

      return var2;
   }

   private boolean preSetReg(int var1) {
      this.preSetRegStack[this.preSetRegStackPos] = var1;
      ++this.preSetRegStackPos;
      if(this.doLocal(var1)) {
         return false;
      } else {
         this.mg.add((byte)42);
         return true;
      }
   }

   private int setReg() {
      if(this.preSetRegStackPos == 0) {
         throw new RuntimeException("didn\'t do preSetReg");
      } else {
         --this.preSetRegStackPos;
         int var1 = this.preSetRegStack[this.preSetRegStackPos];
         int var2 = this.mg.size();
         if(this.doLocal(var1)) {
            this.mg.add((byte)54, this.getLocalForReg(var1));
            this.regLocalWritten[var1] = true;
         } else if(var1 >= 32 && var1 <= 63 && this.singleFloat) {
            this.mg.add((byte)-72, Type.FLOAT_OBJECT.method("intBitsToFloat", Type.FLOAT, new Type[]{Type.INT}));
            this.mg.add((byte)-75, this.me.field(regField[var1], Type.FLOAT));
         } else {
            this.mg.add((byte)-75, this.me.field(regField[var1], Type.INT));
         }

         return var2;
      }
   }

   private int preSetPC() {
      return this.mg.add((byte)42);
   }

   private int setPC() {
      return this.mg.add((byte)-75, this.me.field("pc", Type.INT));
   }

   private int pushFloat(int var1) {
      return this.pushDouble(var1, false);
   }

   private int pushDouble(int var1, boolean var2) {
      if(var1 >= 32 && var1 < 64) {
         int var3 = this.mg.size();
         if(var2) {
            if(this.singleFloat) {
               throw new Compiler$Exn("Double operations not supported when singleFloat is enabled");
            }

            if(var1 == 63) {
               throw new Compiler$Exn("Tried to use a double in f31");
            }

            this.pushReg(var1 + 1);
            this.mg.add((byte)-123);
            this.mg.add((byte)18, 32);
            this.mg.add((byte)121);
            this.pushReg(var1);
            this.mg.add((byte)-123);
            this.mg.add((byte)18, FFFFFFFF);
            this.mg.add((byte)127);
            this.mg.add((byte)-127);
            this.mg.add((byte)-72, Type.DOUBLE_OBJECT.method("longBitsToDouble", Type.DOUBLE, new Type[]{Type.LONG}));
         } else if(this.singleFloat) {
            this.mg.add((byte)42);
            this.mg.add((byte)-76, this.me.field(regField[var1], Type.FLOAT));
         } else {
            this.pushReg(var1);
            this.mg.add((byte)-72, Class.instance("java.lang.Float").method("intBitsToFloat", Type.FLOAT, new Type[]{Type.INT}));
         }

         return var3;
      } else {
         throw new IllegalArgumentException("" + var1);
      }
   }

   private void preSetFloat(int var1) {
      this.preSetDouble(var1, false);
   }

   private void preSetDouble(int var1) {
      this.preSetDouble(var1, true);
   }

   private void preSetDouble(int var1, boolean var2) {
      this.preSetReg(var1);
   }

   private int setFloat() {
      return this.setDouble(false);
   }

   private int setDouble() {
      return this.setDouble(true);
   }

   private int setDouble(boolean var1) {
      int var2 = this.preSetRegStack[this.preSetRegStackPos - 1];
      if(var2 >= 32 && var2 < 64) {
         int var3 = this.mg.size();
         if(var1) {
            if(this.singleFloat) {
               throw new Compiler$Exn("Double operations not supported when singleFloat is enabled");
            }

            if(var2 == 63) {
               throw new Compiler$Exn("Tried to use a double in f31");
            }

            this.mg.add((byte)-72, Type.DOUBLE_OBJECT.method("doubleToLongBits", Type.LONG, new Type[]{Type.DOUBLE}));
            this.mg.add((byte)92);
            this.mg.add((byte)18, 32);
            this.mg.add((byte)125);
            this.mg.add((byte)-120);
            if(this.preSetReg(var2 + 1)) {
               this.mg.add((byte)95);
            }

            this.setReg();
            this.mg.add((byte)-120);
            this.setReg();
         } else if(this.singleFloat) {
            --this.preSetRegStackPos;
            this.mg.add((byte)-75, this.me.field(regField[var2], Type.FLOAT));
         } else {
            this.mg.add((byte)-72, Type.FLOAT_OBJECT.method("floatToRawIntBits", Type.INT, new Type[]{Type.FLOAT}));
            this.setReg();
         }

         return var3;
      } else {
         throw new IllegalArgumentException("" + var2);
      }
   }

   private void pushTmp() {
      this.mg.add((byte)27);
   }

   private void setTmp() {
      this.mg.add((byte)60);
   }

   private void addiu(int var1, int var2) {
      if(var1 != 0 && var2 != 0) {
         this.pushReg(var1);
         this.mg.add((byte)18, var2);
         this.mg.add((byte)96);
      } else if(var1 != 0) {
         this.pushReg(var1);
      } else {
         this.mg.add((byte)18, var2);
      }

   }

   private void preMemWrite1() {
      if(this.memWriteStage != 0) {
         throw new Error("pending preMemWrite1/2");
      } else {
         this.memWriteStage = 1;
         if(this.onePage) {
            this.mg.add((byte)44);
         } else if(this.fastMem) {
            this.mg.add((byte)25, 3);
         } else {
            this.mg.add((byte)42);
         }

      }
   }

   private void preMemWrite2(int var1, int var2) {
      this.addiu(var1, var2);
      this.preMemWrite2();
   }

   private void preMemWrite2() {
      this.preMemWrite2(false);
   }

   private void preMemWrite2(boolean var1) {
      if(this.memWriteStage != 1) {
         throw new Error("pending preMemWrite2 or no preMemWrite1");
      } else {
         this.memWriteStage = 2;
         if(this.nullPointerCheck) {
            this.mg.add((byte)89);
            this.mg.add((byte)42);
            this.mg.add((byte)95);
            this.mg.add((byte)-74, this.me.method("nullPointerCheck", Type.VOID, new Type[]{Type.INT}));
         }

         if(this.onePage) {
            this.mg.add((byte)5);
            this.mg.add((byte)124);
         } else if(this.fastMem) {
            if(!var1) {
               this.mg.add((byte)90);
            }

            this.mg.add((byte)18, this.pageShift);
            this.mg.add((byte)124);
            this.mg.add((byte)50);
            if(var1) {
               this.pushTmp();
            } else {
               this.mg.add((byte)95);
            }

            this.mg.add((byte)5);
            this.mg.add((byte)124);
            this.mg.add((byte)18, (this.pageSize >> 2) - 1);
            this.mg.add((byte)126);
         }

      }
   }

   private void memWrite() {
      if(this.memWriteStage != 2) {
         throw new Error("didn\'t do preMemWrite1 or preMemWrite2");
      } else {
         this.memWriteStage = 0;
         if(this.onePage) {
            this.mg.add((byte)79);
         } else if(this.fastMem) {
            this.mg.add((byte)79);
         } else {
            this.mg.add((byte)-74, this.me.method("unsafeMemWrite", Type.VOID, new Type[]{Type.INT, Type.INT}));
         }

      }
   }

   private void memRead(int var1, int var2) {
      this.preMemRead();
      this.addiu(var1, var2);
      this.memRead();
   }

   private void preMemRead() {
      this.preMemRead(false);
   }

   private void preMemRead(boolean var1) {
      if(this.didPreMemRead) {
         throw new Error("pending preMemRead");
      } else {
         this.didPreMemRead = true;
         this.preMemReadDoPreWrite = var1;
         if(this.onePage) {
            this.mg.add((byte)44);
         } else if(this.fastMem) {
            this.mg.add((byte)25, var1?3:2);
         } else {
            this.mg.add((byte)42);
         }

      }
   }

   private void memRead() {
      this.memRead(false);
   }

   private void memRead(boolean var1) {
      if(!this.didPreMemRead) {
         throw new Error("didn\'t do preMemRead");
      } else {
         this.didPreMemRead = false;
         if(this.preMemReadDoPreWrite) {
            this.memWriteStage = 2;
         }

         if(this.nullPointerCheck) {
            this.mg.add((byte)89);
            this.mg.add((byte)42);
            this.mg.add((byte)95);
            this.mg.add((byte)-74, this.me.method("nullPointerCheck", Type.VOID, new Type[]{Type.INT}));
         }

         if(this.onePage) {
            this.mg.add((byte)5);
            this.mg.add((byte)124);
            if(this.preMemReadDoPreWrite) {
               this.mg.add((byte)92);
            }

            this.mg.add((byte)46);
         } else if(this.fastMem) {
            if(!var1) {
               this.mg.add((byte)90);
            }

            this.mg.add((byte)18, this.pageShift);
            this.mg.add((byte)124);
            this.mg.add((byte)50);
            if(var1) {
               this.pushTmp();
            } else {
               this.mg.add((byte)95);
            }

            this.mg.add((byte)5);
            this.mg.add((byte)124);
            this.mg.add((byte)18, (this.pageSize >> 2) - 1);
            this.mg.add((byte)126);
            if(this.preMemReadDoPreWrite) {
               this.mg.add((byte)92);
            }

            this.mg.add((byte)46);
         } else {
            if(this.preMemReadDoPreWrite) {
               this.mg.add((byte)92);
            }

            this.mg.add((byte)-74, this.me.method("unsafeMemRead", Type.INT, new Type[]{Type.INT}));
         }

      }
   }
}
