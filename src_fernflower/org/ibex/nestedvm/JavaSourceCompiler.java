package org.ibex.nestedvm;

import java.io.DataInputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import org.ibex.nestedvm.Compiler;
import org.ibex.nestedvm.Compiler$Exn;
import org.ibex.nestedvm.util.ELF$SHeader;
import org.ibex.nestedvm.util.ELF$Symbol;
import org.ibex.nestedvm.util.Seekable;

public class JavaSourceCompiler extends Compiler {
   private StringBuffer runs = new StringBuffer();
   private StringBuffer inits = new StringBuffer();
   private StringBuffer classLevel = new StringBuffer();
   private PrintWriter out;
   private int indent;
   private static String[] indents = new String[16];
   private int startOfMethod = 0;
   private int endOfMethod = 0;
   private HashMap relativeAddrs = new HashMap();
   private boolean textDone;
   private int initDataCount = 0;
   private boolean unreachable = false;

   private void p() {
      this.out.println();
   }

   private void p(String var1) {
      this.out.println(indents[this.indent] + var1);
   }

   private void pblock(StringBuffer var1) {
      this.out.print(var1.toString());
   }

   public JavaSourceCompiler(Seekable var1, String var2, Writer var3) {
      super(var1, var2);
      this.out = new PrintWriter(var3);
   }

   protected void _go() {
      if(this.singleFloat) {
         throw new Compiler$Exn("JavaSourceCompiler doesn\'t support singleFloat");
      } else {
         String var1;
         String var2;
         if(this.fullClassName.indexOf(46) != -1) {
            var1 = this.fullClassName.substring(0, this.fullClassName.lastIndexOf(46));
            var2 = this.fullClassName.substring(this.fullClassName.lastIndexOf(46) + 1);
         } else {
            var2 = this.fullClassName;
            var1 = null;
         }

         this.p("/* This file was generated from " + this.source + " by Mips2Java on " + dateTime() + " */");
         if(var1 != null) {
            this.p("package " + var1 + ";");
         }

         if(this.runtimeStats) {
            this.p("import java.util.*;");
         }

         this.p();
         this.p("public final class " + var2 + " extends " + this.runtimeClass + " {");
         ++this.indent;
         this.p("/* program counter */");
         this.p("private int pc = 0;");
         if(this.debugCompiler) {
            this.p("private int lastPC = 0;");
         }

         this.p();
         this.p("/* General Purpose registers */");
         this.p("private final static int r0 = 0;");
         this.p("private int      r1,  r2,  r3,  r4,  r5,  r6,  r7,");
         this.p("            r8,  r9,  r10, r11, r12, r13, r14, r15,");
         this.p("            r16, r17, r18, r19, r20, r21, r22, r23,");
         this.p("            r24, r25, r26, r27, r28, r29, r30, r31,");
         this.p("            hi = 0, lo = 0;");
         this.p("/* FP registers */");
         this.p("private int f0,  f1,  f2,  f3,  f4,  f5,  f6,  f7,");
         this.p("            f8,  f9,  f10, f11, f12, f13, f14, f15,");
         this.p("            f16, f17, f18, f19, f20, f21, f22, f23,");
         this.p("            f24, f25, f26, f27, f28, f29, f30, f31;");
         this.p("/* FP Control Register */");
         this.p("private int fcsr = 0;");
         this.p();
         if(this.onePage) {
            this.p("private final int[] page = readPages[0];");
         }

         int var3 = 0;

         int var4;
         for(var4 = 0; var4 < this.elf.sheaders.length; ++var4) {
            ELF$SHeader var5 = this.elf.sheaders[var4];
            String var6 = var5.name;
            if(var5.addr != 0) {
               var3 = Math.max(var3, var5.addr + var5.size);
               if(var6.equals(".text")) {
                  this.emitText(var5.addr, new DataInputStream(var5.getInputStream()), var5.size);
               } else if(!var6.equals(".data") && !var6.equals(".sdata") && !var6.equals(".rodata") && !var6.equals(".ctors") && !var6.equals(".dtors")) {
                  if(!var6.equals(".bss") && !var6.equals(".sbss")) {
                     throw new Compiler$Exn("Unknown segment: " + var6);
                  }

                  this.emitBSS(var5.addr, var5.size);
               } else {
                  this.emitData(var5.addr, new DataInputStream(var5.getInputStream()), var5.size, var6.equals(".rodata"));
               }
            }
         }

         this.p();
         this.pblock(this.classLevel);
         this.p();
         this.p("private final void trampoline() throws ExecutionException {");
         ++this.indent;
         this.p("while(state == RUNNING) {");
         ++this.indent;
         this.p("switch(pc>>>" + this.methodShift + ") {");
         ++this.indent;
         this.pblock(this.runs);
         this.p("default: throw new ExecutionException(\"invalid address 0x\" + Long.toString(this.pc&0xffffffffL,16) + \": r2: \" + r2);");
         --this.indent;
         this.p("}");
         --this.indent;
         this.p("}");
         --this.indent;
         this.p("}");
         this.p();
         this.p("public " + var2 + "() {");
         ++this.indent;
         this.p("super(" + this.pageSize + "," + this.totalPages + ");");
         this.pblock(this.inits);
         --this.indent;
         this.p("}");
         this.p();
         this.p("protected int entryPoint() { return " + toHex(this.elf.header.entry) + "; }");
         this.p("protected int heapStart() { return " + toHex(var3) + "; }");
         this.p("protected int gp() { return " + toHex(this.gp.addr) + "; }");
         if(this.userInfo != null) {
            this.p("protected int userInfoBase() { return " + toHex(this.userInfo.addr) + "; }");
            this.p("protected int userInfoSize() { return " + toHex(this.userInfo.size) + "; }");
         }

         this.p("public static void main(String[] args) throws Exception {");
         ++this.indent;
         this.p("" + var2 + " me = new " + var2 + "();");
         this.p("int status = me.run(\"" + this.fullClassName + "\",args);");
         if(this.runtimeStats) {
            this.p("me.printStats();");
         }

         this.p("System.exit(status);");
         --this.indent;
         this.p("}");
         this.p();
         this.p("protected void _execute() throws ExecutionException { trampoline(); }");
         this.p();
         this.p("protected void setCPUState(CPUState state) {");
         ++this.indent;

         for(var4 = 1; var4 < 32; ++var4) {
            this.p("r" + var4 + "=state.r[" + var4 + "];");
         }

         for(var4 = 0; var4 < 32; ++var4) {
            this.p("f" + var4 + "=state.f[" + var4 + "];");
         }

         this.p("hi=state.hi; lo=state.lo; fcsr=state.fcsr;");
         this.p("pc=state.pc;");
         --this.indent;
         this.p("}");
         this.p("protected void getCPUState(CPUState state) {");
         ++this.indent;

         for(var4 = 1; var4 < 32; ++var4) {
            this.p("state.r[" + var4 + "]=r" + var4 + ";");
         }

         for(var4 = 0; var4 < 32; ++var4) {
            this.p("state.f[" + var4 + "]=f" + var4 + ";");
         }

         this.p("state.hi=hi; state.lo=lo; state.fcsr=fcsr;");
         this.p("state.pc=pc;");
         --this.indent;
         this.p("}");
         this.p();
         if(this.supportCall) {
            this.p("private static final " + this.hashClass + " symbols = new " + this.hashClass + "();");
            this.p("static {");
            ++this.indent;
            ELF$Symbol[] var9 = this.elf.getSymtab().symbols;

            for(int var7 = 0; var7 < var9.length; ++var7) {
               ELF$Symbol var8 = var9[var7];
               if(var8.type == 2 && var8.binding == 1 && (var8.name.equals("_call_helper") || !var8.name.startsWith("_"))) {
                  this.p("symbols.put(\"" + var8.name + "\",new Integer(" + toHex(var8.addr) + "));");
               }
            }

            --this.indent;
            this.p("}");
            this.p("public int lookupSymbol(String symbol) { Integer i = (Integer) symbols.get(symbol); return i==null ? -1 : i.intValue(); }");
            this.p();
         }

         if(this.runtimeStats) {
            this.p("private HashMap counters = new HashMap();");
            this.p("private void inc(String k) { Long i = (Long)counters.get(k); counters.put(k,new Long(i==null ? 1 : i.longValue() + 1)); }");
            this.p("private void printStats() {");
            this.p(" Iterator i = new TreeSet(counters.keySet()).iterator();");
            this.p(" while(i.hasNext()) { Object o = i.next(); System.err.println(\"\" + o + \": \" + counters.get(o)); }");
            this.p("}");
            this.p();
         }

         --this.indent;
         this.p("}");
      }
   }

   private void startMethod(int var1) {
      var1 &= ~(this.maxBytesPerMethod - 1);
      this.startOfMethod = var1;
      this.endOfMethod = var1 + this.maxBytesPerMethod;
      String var2 = "run_" + Long.toString((long)var1 & 4294967295L, 16);
      this.runs.append(indents[4] + "case " + toHex(var1 >>> this.methodShift) + ": " + var2 + "(); break; \n");
      this.p("private final void " + var2 + "() throws ExecutionException { /" + "* " + toHex(var1) + " - " + toHex(this.endOfMethod) + " *" + "/");
      ++this.indent;
      this.p("int addr, tmp;");
      this.p("for(;;) {");
      ++this.indent;
      this.p("switch(pc) {");
      ++this.indent;
   }

   private void endMethod() {
      this.endMethod(this.endOfMethod);
   }

   private void endMethod(int var1) {
      if(this.startOfMethod != 0) {
         this.p("case " + toHex(var1) + ":");
         ++this.indent;
         this.p("pc=" + this.constant(var1) + ";");
         this.leaveMethod();
         --this.indent;
         if(this.debugCompiler) {
            this.p("default: throw new ExecutionException(\"invalid address 0x\" + Long.toString(pc&0xffffffffL,16)  + \" (got here from 0x\" + Long.toString(lastPC&0xffffffffL,16)+\")\");");
         } else {
            this.p("default: throw new ExecutionException(\"invalid address 0x\" + Long.toString(pc&0xffffffffL,16));");
         }

         --this.indent;
         this.p("}");
         this.p("/* NOT REACHED */");
         --this.indent;
         this.p("}");
         --this.indent;
         this.p("}");
         this.endOfMethod = this.startOfMethod = 0;
      }
   }

   private String constant(int var1) {
      if(var1 >= 4096 && this.lessConstants) {
         int var2 = var1 & -1024;
         String var3 = "N_" + toHex8(var2);
         if(this.relativeAddrs.get(new Integer(var2)) == null) {
            this.relativeAddrs.put(new Integer(var2), Boolean.TRUE);
            this.classLevel.append(indents[1] + "private static int " + var3 + " = " + toHex(var2) + ";\n");
         }

         return "(" + var3 + " + " + toHex(var1 - var2) + ")";
      } else {
         return toHex(var1);
      }
   }

   private void branch(int var1, int var2) {
      if(this.debugCompiler) {
         this.p("lastPC = " + toHex(var1) + ";");
      }

      this.p("pc=" + this.constant(var2) + ";");
      if(var2 == 0) {
         this.p("throw new ExecutionException(\"Branch to addr 0x0\");");
      } else if((var1 & this.methodMask) == (var2 & this.methodMask)) {
         this.p("continue;");
      } else if(this.assumeTailCalls) {
         this.p("run_" + Long.toString((long)(var2 & this.methodMask) & 4294967295L, 16) + "(); return;");
      } else {
         this.leaveMethod();
      }

   }

   private void leaveMethod() {
      this.p("return;");
   }

   private void emitText(int var1, DataInputStream var2, int var3) {
      if(this.textDone) {
         throw new Compiler$Exn("Multiple text segments");
      } else {
         this.textDone = true;
         if((var1 & 3) == 0 && (var3 & 3) == 0) {
            int var4 = var3 / 4;
            int var5 = var2.readInt();
            if(var5 == -1) {
               throw new Error("Actually read -1 at " + toHex(var1));
            } else {
               for(int var7 = 0; var7 < var4; var1 += 4) {
                  int var6 = var5;
                  var5 = var7 == var4 - 1?-1:var2.readInt();
                  if(var1 >= this.endOfMethod) {
                     this.endMethod();
                     this.startMethod(var1);
                  }

                  label62: {
                     if(this.jumpableAddresses != null && var1 != this.startOfMethod && this.jumpableAddresses.get(new Integer(var1)) == null) {
                        if(this.unreachable) {
                           break label62;
                        }

                        if(this.debugCompiler) {
                           this.p("/* pc = " + toHex(var1) + "*" + "/");
                        }
                     } else {
                        this.p("case " + toHex(var1) + ":");
                        this.unreachable = false;
                     }

                     ++this.indent;
                     this.emitInstruction(var1, var6, var5);
                     --this.indent;
                  }

                  ++var7;
               }

               this.endMethod(var1);
               this.p();
               var2.close();
            }
         } else {
            throw new Compiler$Exn("Section on weird boundaries");
         }
      }
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
                  char var14 = (char)((int)(var9 >>> 7 * (7 - var11) & 127L));
                  if(var14 == 10) {
                     var7.append("\\n");
                  } else if(var14 == 13) {
                     var7.append("\\r");
                  } else if(var14 == 92) {
                     var7.append("\\\\");
                  } else if(var14 == 34) {
                     var7.append("\\\"");
                  } else if(var14 >= 32 && var14 <= 126) {
                     var7.append(var14);
                  } else {
                     var7.append("\\" + toOctal3(var14));
                  }
               }
            }

            String var13 = "_data" + ++this.initDataCount;
            this.p("private static final int[] " + var13 + " = decodeData(\"" + var7.toString() + "\"," + toHex(var6 / 4) + ");");
            this.inits.append(indents[2] + "initPages(" + var13 + "," + toHex(var1) + "," + (var4?"true":"false") + ");\n");
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
         this.inits.append(indents[2] + "clearPages(" + toHex(var1) + "," + toHex(var3) + ");\n");
      }
   }

   private void emitInstruction(int var1, int var2, int var3) {
      if(var2 == -1) {
         throw new Error("insn is -1");
      } else {
         int var4 = var2 >>> 26 & 255;
         int var5 = var2 >>> 21 & 31;
         int var6 = var2 >>> 16 & 31;
         int var7 = var2 >>> 16 & 31;
         int var8 = var2 >>> 11 & 31;
         int var9 = var2 >>> 11 & 31;
         int var10 = var2 >>> 6 & 31;
         int var11 = var2 >>> 6 & 31;
         int var12 = var2 & 63;
         int var13 = var2 & 67108863;
         int var14 = var2 & '\uffff';
         int var15 = var2 << 16 >> 16;
         if(var1 == -1) {
            this.p("/* Next insn is delay slot */ ");
         }

         if(this.runtimeStats && var4 != 0) {
            this.p("inc(\"opcode: " + var4 + "\");");
         }

         switch(var4) {
         case 0:
            if(this.runtimeStats && var2 != 0) {
               this.p("inc(\"opcode: 0/" + var12 + "\");");
            }

            switch(var12) {
            case 0:
               if(var2 != 0) {
                  this.p("r" + var8 + " = r" + var6 + " << " + var10 + ";");
               }

               return;
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
               throw new RuntimeException("Illegal instruction 0/" + var12);
            case 2:
               this.p("r" + var8 + " = r" + var6 + " >>> " + var10 + ";");
               return;
            case 3:
               this.p("r" + var8 + " = r" + var6 + " >> " + var10 + ";");
               return;
            case 4:
               this.p("r" + var8 + " = r" + var6 + " << (r" + var5 + "&0x1f);");
               return;
            case 6:
               this.p("r" + var8 + " = r" + var6 + " >>> (r" + var5 + "&0x1f);");
               return;
            case 7:
               this.p("r" + var8 + " = r" + var6 + " >> (r" + var5 + "&0x1f);");
               return;
            case 8:
               if(var1 == -1) {
                  throw new Error("pc modifying insn in delay slot");
               }

               this.emitInstruction(-1, var3, -1);
               if(this.debugCompiler) {
                  this.p("lastPC = " + toHex(var1) + ";");
               }

               this.p("pc=r" + var5 + ";");
               this.leaveMethod();
               this.unreachable = true;
               return;
            case 9:
               if(var1 == -1) {
                  throw new Error("pc modifying insn in delay slot");
               }

               this.emitInstruction(-1, var3, -1);
               if(this.debugCompiler) {
                  this.p("lastPC = " + toHex(var1) + ";");
               }

               this.p("pc=r" + var5 + ";");
               this.p("r31=" + this.constant(var1 + 8) + ";");
               this.leaveMethod();
               this.unreachable = true;
               return;
            case 12:
               this.p("pc = " + toHex(var1) + ";");
               this.p("r2 = syscall(r2,r4,r5,r6,r7,r8,r9);");
               this.p("if (state != RUNNING) {");
               ++this.indent;
               this.p("pc = " + toHex(var1 + 4) + ";");
               this.leaveMethod();
               --this.indent;
               this.p("}");
               return;
            case 13:
               this.p("throw new ExecutionException(\"Break\");");
               this.unreachable = true;
               return;
            case 16:
               this.p("r" + var8 + " = hi;");
               return;
            case 17:
               this.p("hi = r" + var5 + ";");
               return;
            case 18:
               this.p("r" + var8 + " = lo;");
               return;
            case 19:
               this.p("lo = r" + var5 + ";");
               return;
            case 24:
               this.p("{ long hilo = (long)(r" + var5 + ") * ((long)r" + var6 + "); " + "hi = (int) (hilo >>> 32); " + "lo = (int) hilo; }");
               return;
            case 25:
               this.p("{ long hilo = (r" + var5 + " & 0xffffffffL) * (r" + var6 + " & 0xffffffffL); " + "hi = (int) (hilo >>> 32); " + "lo = (int) hilo; } ");
               return;
            case 26:
               this.p("hi = r" + var5 + "%r" + var6 + "; lo = r" + var5 + "/r" + var6 + ";");
               return;
            case 27:
               this.p("if(r" + var6 + "!=0) {");
               this.p("hi = (int)((r" + var5 + " & 0xffffffffL) % (r" + var6 + " & 0xffffffffL)); " + "lo = (int)((r" + var5 + " & 0xffffffffL) / (r" + var6 + " & 0xffffffffL));");
               this.p("}");
               return;
            case 32:
               throw new Compiler$Exn("ADD (add with oveflow trap) not suported");
            case 33:
               this.p("r" + var8 + " = r" + var5 + " + r" + var6 + ";");
               return;
            case 34:
               throw new Compiler$Exn("SUB (add with oveflow trap) not suported");
            case 35:
               this.p("r" + var8 + " = r" + var5 + " - r" + var6 + ";");
               return;
            case 36:
               this.p("r" + var8 + " = r" + var5 + " & r" + var6 + ";");
               return;
            case 37:
               this.p("r" + var8 + " = r" + var5 + " | r" + var6 + ";");
               return;
            case 38:
               this.p("r" + var8 + " = r" + var5 + " ^ r" + var6 + ";");
               return;
            case 39:
               this.p("r" + var8 + " = ~(r" + var5 + " | r" + var6 + ");");
               return;
            case 42:
               this.p("r" + var8 + " = r" + var5 + " < r" + var6 + " ? 1 : 0;");
               return;
            case 43:
               this.p("r" + var8 + " = ((r" + var5 + " & 0xffffffffL) < (r" + var6 + " & 0xffffffffL)) ? 1 : 0;");
               return;
            }
         case 1:
            switch(var6) {
            case 0:
               if(var1 == -1) {
                  throw new Error("pc modifying insn in delay slot");
               }

               this.p("if(r" + var5 + " < 0) {");
               ++this.indent;
               this.emitInstruction(-1, var3, -1);
               this.branch(var1, var1 + var15 * 4 + 4);
               --this.indent;
               this.p("}");
               return;
            case 1:
               if(var1 == -1) {
                  throw new Error("pc modifying insn in delay slot");
               }

               this.p("if(r" + var5 + " >= 0) {");
               ++this.indent;
               this.emitInstruction(-1, var3, -1);
               this.branch(var1, var1 + var15 * 4 + 4);
               --this.indent;
               this.p("}");
               return;
            case 16:
               if(var1 == -1) {
                  throw new Error("pc modifying insn in delay slot");
               }

               this.p("if(r" + var5 + " < 0) {");
               ++this.indent;
               this.emitInstruction(-1, var3, -1);
               this.p("r31=" + this.constant(var1 + 8) + ";");
               this.branch(var1, var1 + var15 * 4 + 4);
               --this.indent;
               this.p("}");
               return;
            case 17:
               if(var1 == -1) {
                  throw new Error("pc modifying insn in delay slot");
               }

               this.p("if(r" + var5 + " >= 0) {");
               ++this.indent;
               this.emitInstruction(-1, var3, -1);
               this.p("r31=" + this.constant(var1 + 8) + ";");
               this.branch(var1, var1 + var15 * 4 + 4);
               --this.indent;
               this.p("}");
               return;
            default:
               throw new RuntimeException("Illegal Instruction 1/" + var6);
            }
         case 2:
            if(var1 == -1) {
               throw new Error("pc modifying insn in delay slot");
            }

            this.emitInstruction(-1, var3, -1);
            this.branch(var1, var1 & -268435456 | var13 << 2);
            this.unreachable = true;
            break;
         case 3:
            if(var1 == -1) {
               throw new Error("pc modifying insn in delay slot");
            }

            int var18 = var1 & -268435456 | var13 << 2;
            this.emitInstruction(-1, var3, -1);
            this.p("r31=" + this.constant(var1 + 8) + ";");
            this.branch(var1, var18);
            this.unreachable = true;
            break;
         case 4:
            if(var1 == -1) {
               throw new Error("pc modifying insn in delay slot");
            }

            this.p("if(r" + var5 + " == r" + var6 + ") {");
            ++this.indent;
            this.emitInstruction(-1, var3, -1);
            this.branch(var1, var1 + var15 * 4 + 4);
            --this.indent;
            this.p("}");
            break;
         case 5:
            if(var1 == -1) {
               throw new Error("pc modifying insn in delay slot");
            }

            this.p("if(r" + var5 + " != r" + var6 + ") {");
            ++this.indent;
            this.emitInstruction(-1, var3, -1);
            this.branch(var1, var1 + var15 * 4 + 4);
            --this.indent;
            this.p("}");
            break;
         case 6:
            if(var1 == -1) {
               throw new Error("pc modifying insn in delay slot");
            }

            this.p("if(r" + var5 + " <= 0) {");
            ++this.indent;
            this.emitInstruction(-1, var3, -1);
            this.branch(var1, var1 + var15 * 4 + 4);
            --this.indent;
            this.p("}");
            break;
         case 7:
            if(var1 == -1) {
               throw new Error("pc modifying insn in delay slot");
            }

            this.p("if(r" + var5 + " > 0) {");
            ++this.indent;
            this.emitInstruction(-1, var3, -1);
            this.branch(var1, var1 + var15 * 4 + 4);
            --this.indent;
            this.p("}");
            break;
         case 8:
            this.p("r" + var6 + " = r" + var5 + " + " + var15 + ";");
            break;
         case 9:
            this.p("r" + var6 + " = r" + var5 + " + " + var15 + ";");
            break;
         case 10:
            this.p("r" + var6 + " = r" + var5 + " < " + var15 + " ? 1 : 0;");
            break;
         case 11:
            this.p("r" + var6 + " = (r" + var5 + "&0xffffffffL) < (" + var15 + "&0xffffffffL) ? 1 : 0;");
            break;
         case 12:
            this.p("r" + var6 + " = r" + var5 + " & " + var14 + ";");
            break;
         case 13:
            this.p("r" + var6 + " = r" + var5 + " | " + var14 + ";");
            break;
         case 14:
            this.p("r" + var6 + " = r" + var5 + " ^ " + var14 + ";");
            break;
         case 15:
            this.p("r" + var6 + " = " + var14 + " << 16;");
            break;
         case 16:
            throw new Compiler$Exn("TLB/Exception support not implemented");
         case 17:
            switch(var5) {
            case 0:
               this.p("r" + var6 + " = f" + var8 + ";");
               return;
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
               throw new Compiler$Exn("Invalid Instruction 17/" + var5);
            case 2:
               if(var9 != 31) {
                  throw new Compiler$Exn("FCR " + var9 + " unavailable");
               }

               this.p("r" + var6 + " = fcsr;");
               return;
            case 4:
               this.p("f" + var8 + " = r" + var6 + ";");
               return;
            case 6:
               if(var9 != 31) {
                  throw new Compiler$Exn("FCR " + var9 + " unavailable");
               }

               this.p("fcsr = r" + var6 + ";");
               return;
            case 8:
               int var17 = var2 >>> 16 & 1;
               this.p("if(((fcsr&0x800000)!=0) == (" + var17 + "!=0)) {");
               ++this.indent;
               this.emitInstruction(-1, var3, -1);
               this.branch(var1, var1 + var15 * 4 + 4);
               --this.indent;
               this.p("}");
               return;
            case 16:
               switch(var12) {
               case 0:
                  this.p(setFloat(var11, getFloat(var9) + "+" + getFloat(var7)));
                  return;
               case 1:
                  this.p(setFloat(var11, getFloat(var9) + "-" + getFloat(var7)));
                  return;
               case 2:
                  this.p(setFloat(var11, getFloat(var9) + "*" + getFloat(var7)));
                  return;
               case 3:
                  this.p(setFloat(var11, getFloat(var9) + "/" + getFloat(var7)));
                  return;
               case 5:
                  this.p(setFloat(var11, "Math.abs(" + getFloat(var9) + ")"));
                  return;
               case 6:
                  this.p("f" + var11 + " = f" + var9 + "; // MOV.S");
                  return;
               case 7:
                  this.p(setFloat(var11, "-" + getFloat(var9)));
                  return;
               case 33:
                  this.p(setDouble(var11, "(float)" + getFloat(var9)));
                  return;
               case 36:
                  this.p("switch(fcsr & 3) {");
                  ++this.indent;
                  this.p("case 0: f" + var11 + " = (int)Math.floor(" + getFloat(var9) + "+0.5); break; // Round to nearest");
                  this.p("case 1: f" + var11 + " = (int)" + getFloat(var9) + "; break; // Round towards zero");
                  this.p("case 2: f" + var11 + " = (int)Math.ceil(" + getFloat(var9) + "); break; // Round towards plus infinity");
                  this.p("case 3: f" + var11 + " = (int)Math.floor(" + getFloat(var9) + "); break; // Round towards minus infinity");
                  --this.indent;
                  this.p("}");
                  return;
               case 50:
                  this.p("fcsr = (fcsr&~0x800000) | ((" + getFloat(var9) + "==" + getFloat(var7) + ") ? 0x800000 : 0x000000);");
                  return;
               case 60:
                  this.p("fcsr = (fcsr&~0x800000) | ((" + getFloat(var9) + "<" + getFloat(var7) + ") ? 0x800000 : 0x000000);");
                  return;
               case 62:
                  this.p("fcsr = (fcsr&~0x800000) | ((" + getFloat(var9) + "<=" + getFloat(var7) + ") ? 0x800000 : 0x000000);");
                  return;
               default:
                  throw new Compiler$Exn("Invalid Instruction 17/" + var5 + "/" + var12);
               }
            case 17:
               switch(var12) {
               case 0:
                  this.p(setDouble(var11, getDouble(var9) + "+" + getDouble(var7)));
                  return;
               case 1:
                  this.p(setDouble(var11, getDouble(var9) + "-" + getDouble(var7)));
                  return;
               case 2:
                  this.p(setDouble(var11, getDouble(var9) + "*" + getDouble(var7)));
                  return;
               case 3:
                  this.p(setDouble(var11, getDouble(var9) + "/" + getDouble(var7)));
                  return;
               case 5:
                  this.p(setDouble(var11, "Math.abs(" + getDouble(var9) + ")"));
                  return;
               case 6:
                  this.p("f" + var11 + " = f" + var9 + ";");
                  this.p("f" + (var11 + 1) + " = f" + (var9 + 1) + ";");
                  return;
               case 7:
                  this.p(setDouble(var11, "-" + getDouble(var9)));
                  return;
               case 32:
                  this.p(setFloat(var11, "(float)" + getDouble(var9)));
                  return;
               case 36:
                  this.p("switch(fcsr & 3) {");
                  ++this.indent;
                  this.p("case 0: f" + var11 + " = (int)Math.floor(" + getDouble(var9) + "+0.5); break; // Round to nearest");
                  this.p("case 1: f" + var11 + " = (int)" + getDouble(var9) + "; break; // Round towards zero");
                  this.p("case 2: f" + var11 + " = (int)Math.ceil(" + getDouble(var9) + "); break; // Round towards plus infinity");
                  this.p("case 3: f" + var11 + " = (int)Math.floor(" + getDouble(var9) + "); break; // Round towards minus infinity");
                  --this.indent;
                  this.p("}");
                  return;
               case 50:
                  this.p("fcsr = (fcsr&~0x800000) | ((" + getDouble(var9) + "==" + getDouble(var7) + ") ? 0x800000 : 0x000000);");
                  return;
               case 60:
                  this.p("fcsr = (fcsr&~0x800000) | ((" + getDouble(var9) + "<" + getDouble(var7) + ") ? 0x800000 : 0x000000);");
                  return;
               case 62:
                  this.p("fcsr = (fcsr&~0x800000) | ((" + getDouble(var9) + "<=" + getDouble(var7) + ") ? 0x800000 : 0x000000);");
                  return;
               default:
                  throw new Compiler$Exn("Invalid Instruction 17/" + var5 + "/" + var12);
               }
            case 20:
               switch(var12) {
               case 32:
                  this.p(" // CVS.S.W");
                  this.p(setFloat(var11, "((float)f" + var9 + ")"));
                  return;
               case 33:
                  this.p(setDouble(var11, "((double)f" + var9 + ")"));
                  return;
               default:
                  throw new Compiler$Exn("Invalid Instruction 17/" + var5 + "/" + var12);
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
            throw new Compiler$Exn("Invalid Instruction: " + var4 + " at " + toHex(var1));
         case 32:
            if(this.runtimeStats) {
               this.p("inc(\"LB\");");
            }

            this.p("addr=r" + var5 + "+" + var15 + ";");
            this.memRead("addr", "tmp");
            this.p("tmp = (tmp>>>(((~addr)&3)<<3)) & 0xff;");
            this.p("if((tmp&0x80)!=0) tmp |= 0xffffff00; /* sign extend */");
            this.p("r" + var6 + " = tmp;");
            break;
         case 33:
            if(this.runtimeStats) {
               this.p("inc(\"LH\");");
            }

            this.p("addr=r" + var5 + "+" + var15 + ";");
            this.memRead("addr", "tmp");
            this.p("tmp = (tmp>>>(((~addr)&2)<<3)) & 0xffff;");
            this.p("if((tmp&0x8000)!=0) tmp |= 0xffff0000; /* sign extend */");
            this.p("r" + var6 + " = tmp;");
            break;
         case 34:
            this.p("addr=r" + var5 + "+" + var15 + ";");
            this.memRead("addr", "tmp");
            this.p("r" + var6 + " = (r" + var6 + "&(0x00ffffff>>>(((~addr)&3)<<3)))|(tmp<<((addr&3)<<3));");
            break;
         case 35:
            if(this.runtimeStats) {
               this.p("inc(\"LW\");");
            }

            this.memRead("r" + var5 + "+" + var15, "r" + var6);
            break;
         case 36:
            this.p("addr=r" + var5 + "+" + var15 + ";");
            this.memRead("addr", "tmp");
            this.p("tmp = (tmp>>>(((~addr)&3)<<3)) & 0xff;");
            this.p("r" + var6 + " = tmp;");
            break;
         case 37:
            this.p("addr=r" + var5 + "+" + var15 + ";");
            this.memRead("addr", "tmp");
            this.p("tmp = (tmp>>>(((~addr)&2)<<3)) & 0xffff;");
            this.p("r" + var6 + " = tmp;");
            break;
         case 38:
            this.p("addr=r" + var5 + "+" + var15 + ";");
            this.memRead("addr", "tmp");
            this.p("r" + var6 + " = (r" + var6 + "&(0xffffff00<<((addr&3)<<3)))|(tmp>>>(((~addr)&3)<<3));");
            break;
         case 40:
            if(this.runtimeStats) {
               this.p("inc(\"SB\");");
            }

            this.p("addr=r" + var5 + "+" + var15 + ";");
            this.memRead("addr", "tmp");
            this.p("tmp = (tmp&~(0xff000000>>>((addr&3)<<3)))|((r" + var6 + "&0xff)<<(((~addr)&3)<<3));");
            this.memWrite("addr", "tmp");
            break;
         case 41:
            if(this.runtimeStats) {
               this.p("inc(\"SH\");");
            }

            this.p("addr=r" + var5 + "+" + var15 + ";");
            this.memRead("addr", "tmp");
            this.p("tmp = (tmp&(0xffff<<((addr&2)<<3)))|((r" + var6 + "&0xffff)<<(((~addr)&2)<<3));");
            this.memWrite("addr", "tmp");
            break;
         case 42:
            this.p(" // SWL");
            this.p("addr=r" + var5 + "+" + var15 + ";");
            this.memRead("addr", "tmp");
            this.p("tmp = (tmp&(0xffffff00<<(((~addr)&3)<<3)))|(r" + var6 + ">>>((addr&3)<<3));");
            this.memWrite("addr", "tmp");
            break;
         case 43:
            if(this.runtimeStats) {
               this.p("inc(\"SW\");");
            }

            this.memWrite("r" + var5 + "+" + var15, "r" + var6);
            break;
         case 46:
            this.p(" // SWR");
            this.p("addr=r" + var5 + "+" + var15 + ";");
            this.memRead("addr", "tmp");
            this.p("tmp = (tmp&(0x00ffffff>>>((addr&3)<<3)))|(r" + var6 + "<<(((~addr)&3)<<3));");
            this.memWrite("addr", "tmp");
            break;
         case 48:
            this.memRead("r" + var5 + "+" + var15, "r" + var6);
            break;
         case 49:
            this.memRead("r" + var5 + "+" + var15, "f" + var6);
            break;
         case 56:
            this.memWrite("r" + var5 + "+" + var15, "r" + var6);
            this.p("r" + var6 + "=1;");
            break;
         case 57:
            this.memWrite("r" + var5 + "+" + var15, "f" + var6);
         }

      }
   }

   private void memWrite(String var1, String var2) {
      if(this.nullPointerCheck) {
         this.p("nullPointerCheck(" + var1 + ");");
      }

      if(this.onePage) {
         this.p("page[(" + var1 + ")>>>2] = " + var2 + ";");
      } else if(this.fastMem) {
         this.p("writePages[(" + var1 + ")>>>" + this.pageShift + "][((" + var1 + ")>>>2)&" + toHex((this.pageSize >> 2) - 1) + "] = " + var2 + ";");
      } else {
         this.p("unsafeMemWrite(" + var1 + "," + var2 + ");");
      }

   }

   private void memRead(String var1, String var2) {
      if(this.nullPointerCheck) {
         this.p("nullPointerCheck(" + var1 + ");");
      }

      if(this.onePage) {
         this.p(var2 + "= page[(" + var1 + ")>>>2];");
      } else if(this.fastMem) {
         this.p(var2 + " = readPages[(" + var1 + ")>>>" + this.pageShift + "][((" + var1 + ")>>>2)&" + toHex((this.pageSize >> 2) - 1) + "];");
      } else {
         this.p(var2 + " = unsafeMemRead(" + var1 + ");");
      }

   }

   private static String getFloat(int var0) {
      return "(Float.intBitsToFloat(f" + var0 + "))";
   }

   private static String getDouble(int var0) {
      return "(Double.longBitsToDouble(((f" + (var0 + 1) + "&0xffffffffL) << 32) | (f" + var0 + "&0xffffffffL)))";
   }

   private static String setFloat(int var0, String var1) {
      return "f" + var0 + "=Float.floatToRawIntBits(" + var1 + ");";
   }

   private static String setDouble(int var0, String var1) {
      return "{ long l = Double.doubleToLongBits(" + var1 + "); " + "f" + (var0 + 1) + " = (int)(l >>> 32); f" + var0 + " = (int)l; }";
   }

   static {
      String var0 = "";

      for(int var1 = 0; var1 < indents.length; var0 = var0 + "    ") {
         indents[var1] = var0;
         ++var1;
      }

   }
}
