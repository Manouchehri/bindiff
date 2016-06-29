/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Hashtable;
import org.ibex.nestedvm.Compiler;
import org.ibex.nestedvm.Compiler$Exn;
import org.ibex.nestedvm.util.ELF;
import org.ibex.nestedvm.util.ELF$ELFHeader;
import org.ibex.nestedvm.util.ELF$SHeader;
import org.ibex.nestedvm.util.ELF$Symbol;
import org.ibex.nestedvm.util.ELF$Symtab;
import org.ibex.nestedvm.util.Seekable;

public class JavaSourceCompiler
extends Compiler {
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

    private void p(String string) {
        this.out.println(new StringBuffer().append(indents[this.indent]).append(string).toString());
    }

    private void pblock(StringBuffer stringBuffer) {
        this.out.print(stringBuffer.toString());
    }

    public JavaSourceCompiler(Seekable seekable, String string, Writer writer) {
        super(seekable, string);
        this.out = new PrintWriter(writer);
    }

    @Override
    protected void _go() {
        String string;
        Object object;
        String string2;
        int n2;
        if (this.singleFloat) {
            throw new Compiler$Exn("JavaSourceCompiler doesn't support singleFloat");
        }
        if (this.fullClassName.indexOf(46) != -1) {
            string2 = this.fullClassName.substring(0, this.fullClassName.lastIndexOf(46));
            string = this.fullClassName.substring(this.fullClassName.lastIndexOf(46) + 1);
        } else {
            string = this.fullClassName;
            string2 = null;
        }
        this.p(new StringBuffer().append("/* This file was generated from ").append(this.source).append(" by Mips2Java on ").append(JavaSourceCompiler.dateTime()).append(" */").toString());
        if (string2 != null) {
            this.p(new StringBuffer().append("package ").append(string2).append(";").toString());
        }
        if (this.runtimeStats) {
            this.p("import java.util.*;");
        }
        this.p();
        this.p(new StringBuffer().append("public final class ").append(string).append(" extends ").append(this.runtimeClass).append(" {").toString());
        ++this.indent;
        this.p("/* program counter */");
        this.p("private int pc = 0;");
        if (this.debugCompiler) {
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
        if (this.onePage) {
            this.p("private final int[] page = readPages[0];");
        }
        int n3 = 0;
        for (n2 = 0; n2 < this.elf.sheaders.length; ++n2) {
            ELF$SHeader eLF$SHeader = this.elf.sheaders[n2];
            object = eLF$SHeader.name;
            if (eLF$SHeader.addr == 0) continue;
            n3 = Math.max(n3, eLF$SHeader.addr + eLF$SHeader.size);
            if (object.equals(".text")) {
                this.emitText(eLF$SHeader.addr, new DataInputStream(eLF$SHeader.getInputStream()), eLF$SHeader.size);
                continue;
            }
            if (object.equals(".data") || object.equals(".sdata") || object.equals(".rodata") || object.equals(".ctors") || object.equals(".dtors")) {
                this.emitData(eLF$SHeader.addr, new DataInputStream(eLF$SHeader.getInputStream()), eLF$SHeader.size, object.equals(".rodata"));
                continue;
            }
            if (!object.equals(".bss")) {
                if (!object.equals(".sbss")) throw new Compiler$Exn(new StringBuffer().append("Unknown segment: ").append((String)object).toString());
            }
            this.emitBSS(eLF$SHeader.addr, eLF$SHeader.size);
        }
        this.p();
        this.pblock(this.classLevel);
        this.p();
        this.p("private final void trampoline() throws ExecutionException {");
        ++this.indent;
        this.p("while(state == RUNNING) {");
        ++this.indent;
        this.p(new StringBuffer().append("switch(pc>>>").append(this.methodShift).append(") {").toString());
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
        this.p(new StringBuffer().append("public ").append(string).append("() {").toString());
        ++this.indent;
        this.p(new StringBuffer().append("super(").append(this.pageSize).append(",").append(this.totalPages).append(");").toString());
        this.pblock(this.inits);
        --this.indent;
        this.p("}");
        this.p();
        this.p(new StringBuffer().append("protected int entryPoint() { return ").append(JavaSourceCompiler.toHex(this.elf.header.entry)).append("; }").toString());
        this.p(new StringBuffer().append("protected int heapStart() { return ").append(JavaSourceCompiler.toHex(n3)).append("; }").toString());
        this.p(new StringBuffer().append("protected int gp() { return ").append(JavaSourceCompiler.toHex(this.gp.addr)).append("; }").toString());
        if (this.userInfo != null) {
            this.p(new StringBuffer().append("protected int userInfoBase() { return ").append(JavaSourceCompiler.toHex(this.userInfo.addr)).append("; }").toString());
            this.p(new StringBuffer().append("protected int userInfoSize() { return ").append(JavaSourceCompiler.toHex(this.userInfo.size)).append("; }").toString());
        }
        this.p("public static void main(String[] args) throws Exception {");
        ++this.indent;
        this.p(new StringBuffer().append("").append(string).append(" me = new ").append(string).append("();").toString());
        this.p(new StringBuffer().append("int status = me.run(\"").append(this.fullClassName).append("\",args);").toString());
        if (this.runtimeStats) {
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
        for (n2 = 1; n2 < 32; ++n2) {
            this.p(new StringBuffer().append("r").append(n2).append("=state.r[").append(n2).append("];").toString());
        }
        for (n2 = 0; n2 < 32; ++n2) {
            this.p(new StringBuffer().append("f").append(n2).append("=state.f[").append(n2).append("];").toString());
        }
        this.p("hi=state.hi; lo=state.lo; fcsr=state.fcsr;");
        this.p("pc=state.pc;");
        --this.indent;
        this.p("}");
        this.p("protected void getCPUState(CPUState state) {");
        ++this.indent;
        for (n2 = 1; n2 < 32; ++n2) {
            this.p(new StringBuffer().append("state.r[").append(n2).append("]=r").append(n2).append(";").toString());
        }
        for (n2 = 0; n2 < 32; ++n2) {
            this.p(new StringBuffer().append("state.f[").append(n2).append("]=f").append(n2).append(";").toString());
        }
        this.p("state.hi=hi; state.lo=lo; state.fcsr=fcsr;");
        this.p("state.pc=pc;");
        --this.indent;
        this.p("}");
        this.p();
        if (this.supportCall) {
            this.p(new StringBuffer().append("private static final ").append(this.hashClass).append(" symbols = new ").append(this.hashClass).append("();").toString());
            this.p("static {");
            ++this.indent;
            ELF$Symbol[] arreLF$Symbol = this.elf.getSymtab().symbols;
            for (int i2 = 0; i2 < arreLF$Symbol.length; ++i2) {
                object = arreLF$Symbol[i2];
                if (object.type != 2 || object.binding != 1 || !object.name.equals("_call_helper") && object.name.startsWith("_")) continue;
                this.p(new StringBuffer().append("symbols.put(\"").append(object.name).append("\",new Integer(").append(JavaSourceCompiler.toHex(object.addr)).append("));").toString());
            }
            --this.indent;
            this.p("}");
            this.p("public int lookupSymbol(String symbol) { Integer i = (Integer) symbols.get(symbol); return i==null ? -1 : i.intValue(); }");
            this.p();
        }
        if (this.runtimeStats) {
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

    private void startMethod(int n2) {
        this.startOfMethod = n2 &= ~ (this.maxBytesPerMethod - 1);
        this.endOfMethod = n2 + this.maxBytesPerMethod;
        String string = new StringBuffer().append("run_").append(Long.toString((long)n2 & 0xFFFFFFFFL, 16)).toString();
        this.runs.append(new StringBuffer().append(indents[4]).append("case ").append(JavaSourceCompiler.toHex(n2 >>> this.methodShift)).append(": ").append(string).append("(); break; \n").toString());
        this.p(new StringBuffer().append("private final void ").append(string).append("() throws ExecutionException { /").append("* ").append(JavaSourceCompiler.toHex(n2)).append(" - ").append(JavaSourceCompiler.toHex(this.endOfMethod)).append(" *").append("/").toString());
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

    private void endMethod(int n2) {
        if (this.startOfMethod == 0) {
            return;
        }
        this.p(new StringBuffer().append("case ").append(JavaSourceCompiler.toHex(n2)).append(":").toString());
        ++this.indent;
        this.p(new StringBuffer().append("pc=").append(this.constant(n2)).append(";").toString());
        this.leaveMethod();
        --this.indent;
        if (this.debugCompiler) {
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
        this.startOfMethod = 0;
        this.endOfMethod = 0;
    }

    private String constant(int n2) {
        if (n2 < 4096) return JavaSourceCompiler.toHex(n2);
        if (!this.lessConstants) return JavaSourceCompiler.toHex(n2);
        int n3 = n2 & -1024;
        String string = new StringBuffer().append("N_").append(JavaSourceCompiler.toHex8(n3)).toString();
        if (this.relativeAddrs.get(new Integer(n3)) != null) return new StringBuffer().append("(").append(string).append(" + ").append(JavaSourceCompiler.toHex(n2 - n3)).append(")").toString();
        this.relativeAddrs.put(new Integer(n3), Boolean.TRUE);
        this.classLevel.append(new StringBuffer().append(indents[1]).append("private static int ").append(string).append(" = ").append(JavaSourceCompiler.toHex(n3)).append(";\n").toString());
        return new StringBuffer().append("(").append(string).append(" + ").append(JavaSourceCompiler.toHex(n2 - n3)).append(")").toString();
    }

    private void branch(int n2, int n3) {
        if (this.debugCompiler) {
            this.p(new StringBuffer().append("lastPC = ").append(JavaSourceCompiler.toHex(n2)).append(";").toString());
        }
        this.p(new StringBuffer().append("pc=").append(this.constant(n3)).append(";").toString());
        if (n3 == 0) {
            this.p("throw new ExecutionException(\"Branch to addr 0x0\");");
            return;
        }
        if ((n2 & this.methodMask) == (n3 & this.methodMask)) {
            this.p("continue;");
            return;
        }
        if (this.assumeTailCalls) {
            this.p(new StringBuffer().append("run_").append(Long.toString((long)(n3 & this.methodMask) & 0xFFFFFFFFL, 16)).append("(); return;").toString());
            return;
        }
        this.leaveMethod();
    }

    private void leaveMethod() {
        this.p("return;");
    }

    /*
     * Unable to fully structure code
     */
    private void emitText(int var1_1, DataInputStream var2_2, int var3_3) {
        if (this.textDone) {
            throw new Compiler$Exn("Multiple text segments");
        }
        this.textDone = true;
        if ((var1_1 & 3) != 0) throw new Compiler$Exn("Section on weird boundaries");
        if ((var3_3 & 3) != 0) {
            throw new Compiler$Exn("Section on weird boundaries");
        }
        var4_4 = var3_3 / 4;
        var5_5 = var2_2.readInt();
        if (var5_5 == -1) {
            throw new Error(new StringBuffer().append("Actually read -1 at ").append(JavaSourceCompiler.toHex(var1_1)).toString());
        }
        var7_6 = 0;
        do {
            if (var7_6 >= var4_4) {
                this.endMethod(var1_1);
                this.p();
                var2_2.close();
                return;
            }
            var6_7 = var5_5;
            v0 = var5_5 = var7_6 == var4_4 - 1 ? -1 : var2_2.readInt();
            if (var1_1 >= this.endOfMethod) {
                this.endMethod();
                this.startMethod(var1_1);
            }
            if (this.jumpableAddresses != null && var1_1 != this.startOfMethod && this.jumpableAddresses.get(new Integer(var1_1)) == null) ** GOTO lbl27
            this.p(new StringBuffer().append("case ").append(JavaSourceCompiler.toHex(var1_1)).append(":").toString());
            this.unreachable = false;
            ** GOTO lbl30
lbl27: // 1 sources:
            if (!this.unreachable) {
                if (this.debugCompiler) {
                    this.p(new StringBuffer().append("/* pc = ").append(JavaSourceCompiler.toHex(var1_1)).append("*").append("/").toString());
                }
lbl30: // 4 sources:
                ++this.indent;
                this.emitInstruction(var1_1, var6_7, var5_5);
                --this.indent;
            }
            ++var7_6;
            var1_1 += 4;
        } while (true);
    }

    private void emitData(int n2, DataInputStream dataInputStream, int n3, boolean bl2) {
        if ((n2 & 3) != 0) throw new Compiler$Exn("Data section on weird boundaries");
        if ((n3 & 3) != 0) {
            throw new Compiler$Exn("Data section on weird boundaries");
        }
        int n4 = n2 + n3;
        block0 : do {
            if (n2 >= n4) {
                dataInputStream.close();
                return;
            }
            int n5 = Math.min(n3, 28000);
            StringBuffer stringBuffer = new StringBuffer();
            int n6 = 0;
            do {
                int n7;
                char c2;
                long l2;
                if (n6 < n5) {
                    l2 = 0;
                } else {
                    String string = new StringBuffer().append("_data").append(++this.initDataCount).toString();
                    this.p(new StringBuffer().append("private static final int[] ").append(string).append(" = decodeData(\"").append(stringBuffer.toString()).append("\",").append(JavaSourceCompiler.toHex(n5 / 4)).append(");").toString());
                    this.inits.append(new StringBuffer().append(indents[2]).append("initPages(").append(string).append(",").append(JavaSourceCompiler.toHex(n2)).append(",").append(bl2 ? "true" : "false").append(");\n").toString());
                    n2 += n5;
                    n3 -= n5;
                    continue block0;
                }
                for (n7 = 0; n7 < 7; l2 |= (long)c2 & 255, ++n7) {
                    l2 <<= 8;
                    c2 = n6 + n7 < n3 ? dataInputStream.readByte() : '\u0001';
                }
                for (n7 = 0; n7 < 8; ++n7) {
                    c2 = (char)(l2 >>> 7 * (7 - n7) & 127);
                    if (c2 == '\n') {
                        stringBuffer.append("\\n");
                        continue;
                    }
                    if (c2 == '\r') {
                        stringBuffer.append("\\r");
                        continue;
                    }
                    if (c2 == '\\') {
                        stringBuffer.append("\\\\");
                        continue;
                    }
                    if (c2 == '\"') {
                        stringBuffer.append("\\\"");
                        continue;
                    }
                    if (c2 >= ' ' && c2 <= '~') {
                        stringBuffer.append(c2);
                        continue;
                    }
                    stringBuffer.append(new StringBuffer().append("\\").append(JavaSourceCompiler.toOctal3(c2)).toString());
                }
                n6 += 7;
            } while (true);
            break;
        } while (true);
    }

    private void emitBSS(int n2, int n3) {
        if ((n2 & 3) != 0) {
            throw new Compiler$Exn("BSS section on weird boundaries");
        }
        n3 = n3 + 3 & -4;
        int n4 = n3 / 4;
        this.inits.append(new StringBuffer().append(indents[2]).append("clearPages(").append(JavaSourceCompiler.toHex(n2)).append(",").append(JavaSourceCompiler.toHex(n4)).append(");\n").toString());
    }

    private void emitInstruction(int n2, int n3, int n4) {
        int n5;
        if (n3 == -1) {
            throw new Error("insn is -1");
        }
        int n6 = n3 >>> 26 & 255;
        int n7 = n3 >>> 21 & 31;
        int n8 = n3 >>> 16 & 31;
        int n9 = n3 >>> 16 & 31;
        int n10 = n3 >>> 11 & 31;
        int n11 = n3 >>> 11 & 31;
        int n12 = n3 >>> 6 & 31;
        int n13 = n3 >>> 6 & 31;
        int n14 = n3 & 63;
        int n15 = n3 & 67108863;
        int n16 = n3 & 65535;
        int n17 = n5 = n3 << 16 >> 16;
        if (n2 == -1) {
            this.p("/* Next insn is delay slot */ ");
        }
        if (this.runtimeStats && n6 != 0) {
            this.p(new StringBuffer().append("inc(\"opcode: ").append(n6).append("\");").toString());
        }
        switch (n6) {
            case 0: {
                if (this.runtimeStats && n3 != 0) {
                    this.p(new StringBuffer().append("inc(\"opcode: 0/").append(n14).append("\");").toString());
                }
                switch (n14) {
                    case 0: {
                        if (n3 == 0) return;
                        this.p(new StringBuffer().append("r").append(n10).append(" = r").append(n8).append(" << ").append(n12).append(";").toString());
                        return;
                    }
                    case 2: {
                        this.p(new StringBuffer().append("r").append(n10).append(" = r").append(n8).append(" >>> ").append(n12).append(";").toString());
                        return;
                    }
                    case 3: {
                        this.p(new StringBuffer().append("r").append(n10).append(" = r").append(n8).append(" >> ").append(n12).append(";").toString());
                        return;
                    }
                    case 4: {
                        this.p(new StringBuffer().append("r").append(n10).append(" = r").append(n8).append(" << (r").append(n7).append("&0x1f);").toString());
                        return;
                    }
                    case 6: {
                        this.p(new StringBuffer().append("r").append(n10).append(" = r").append(n8).append(" >>> (r").append(n7).append("&0x1f);").toString());
                        return;
                    }
                    case 7: {
                        this.p(new StringBuffer().append("r").append(n10).append(" = r").append(n8).append(" >> (r").append(n7).append("&0x1f);").toString());
                        return;
                    }
                    case 8: {
                        if (n2 == -1) {
                            throw new Error("pc modifying insn in delay slot");
                        }
                        this.emitInstruction(-1, n4, -1);
                        if (this.debugCompiler) {
                            this.p(new StringBuffer().append("lastPC = ").append(JavaSourceCompiler.toHex(n2)).append(";").toString());
                        }
                        this.p(new StringBuffer().append("pc=r").append(n7).append(";").toString());
                        this.leaveMethod();
                        this.unreachable = true;
                        return;
                    }
                    case 9: {
                        if (n2 == -1) {
                            throw new Error("pc modifying insn in delay slot");
                        }
                        this.emitInstruction(-1, n4, -1);
                        if (this.debugCompiler) {
                            this.p(new StringBuffer().append("lastPC = ").append(JavaSourceCompiler.toHex(n2)).append(";").toString());
                        }
                        this.p(new StringBuffer().append("pc=r").append(n7).append(";").toString());
                        this.p(new StringBuffer().append("r31=").append(this.constant(n2 + 8)).append(";").toString());
                        this.leaveMethod();
                        this.unreachable = true;
                        return;
                    }
                    case 12: {
                        this.p(new StringBuffer().append("pc = ").append(JavaSourceCompiler.toHex(n2)).append(";").toString());
                        this.p("r2 = syscall(r2,r4,r5,r6,r7,r8,r9);");
                        this.p("if (state != RUNNING) {");
                        ++this.indent;
                        this.p(new StringBuffer().append("pc = ").append(JavaSourceCompiler.toHex(n2 + 4)).append(";").toString());
                        this.leaveMethod();
                        --this.indent;
                        this.p("}");
                        return;
                    }
                    case 13: {
                        this.p("throw new ExecutionException(\"Break\");");
                        this.unreachable = true;
                        return;
                    }
                    case 16: {
                        this.p(new StringBuffer().append("r").append(n10).append(" = hi;").toString());
                        return;
                    }
                    case 17: {
                        this.p(new StringBuffer().append("hi = r").append(n7).append(";").toString());
                        return;
                    }
                    case 18: {
                        this.p(new StringBuffer().append("r").append(n10).append(" = lo;").toString());
                        return;
                    }
                    case 19: {
                        this.p(new StringBuffer().append("lo = r").append(n7).append(";").toString());
                        return;
                    }
                    case 24: {
                        this.p(new StringBuffer().append("{ long hilo = (long)(r").append(n7).append(") * ((long)r").append(n8).append("); ").append("hi = (int) (hilo >>> 32); ").append("lo = (int) hilo; }").toString());
                        return;
                    }
                    case 25: {
                        this.p(new StringBuffer().append("{ long hilo = (r").append(n7).append(" & 0xffffffffL) * (r").append(n8).append(" & 0xffffffffL); ").append("hi = (int) (hilo >>> 32); ").append("lo = (int) hilo; } ").toString());
                        return;
                    }
                    case 26: {
                        this.p(new StringBuffer().append("hi = r").append(n7).append("%r").append(n8).append("; lo = r").append(n7).append("/r").append(n8).append(";").toString());
                        return;
                    }
                    case 27: {
                        this.p(new StringBuffer().append("if(r").append(n8).append("!=0) {").toString());
                        this.p(new StringBuffer().append("hi = (int)((r").append(n7).append(" & 0xffffffffL) % (r").append(n8).append(" & 0xffffffffL)); ").append("lo = (int)((r").append(n7).append(" & 0xffffffffL) / (r").append(n8).append(" & 0xffffffffL));").toString());
                        this.p("}");
                        return;
                    }
                    case 32: {
                        throw new Compiler$Exn("ADD (add with oveflow trap) not suported");
                    }
                    case 33: {
                        this.p(new StringBuffer().append("r").append(n10).append(" = r").append(n7).append(" + r").append(n8).append(";").toString());
                        return;
                    }
                    case 34: {
                        throw new Compiler$Exn("SUB (add with oveflow trap) not suported");
                    }
                    case 35: {
                        this.p(new StringBuffer().append("r").append(n10).append(" = r").append(n7).append(" - r").append(n8).append(";").toString());
                        return;
                    }
                    case 36: {
                        this.p(new StringBuffer().append("r").append(n10).append(" = r").append(n7).append(" & r").append(n8).append(";").toString());
                        return;
                    }
                    case 37: {
                        this.p(new StringBuffer().append("r").append(n10).append(" = r").append(n7).append(" | r").append(n8).append(";").toString());
                        return;
                    }
                    case 38: {
                        this.p(new StringBuffer().append("r").append(n10).append(" = r").append(n7).append(" ^ r").append(n8).append(";").toString());
                        return;
                    }
                    case 39: {
                        this.p(new StringBuffer().append("r").append(n10).append(" = ~(r").append(n7).append(" | r").append(n8).append(");").toString());
                        return;
                    }
                    case 42: {
                        this.p(new StringBuffer().append("r").append(n10).append(" = r").append(n7).append(" < r").append(n8).append(" ? 1 : 0;").toString());
                        return;
                    }
                    case 43: {
                        this.p(new StringBuffer().append("r").append(n10).append(" = ((r").append(n7).append(" & 0xffffffffL) < (r").append(n8).append(" & 0xffffffffL)) ? 1 : 0;").toString());
                        return;
                    }
                }
                throw new RuntimeException(new StringBuffer().append("Illegal instruction 0/").append(n14).toString());
            }
            case 1: {
                switch (n8) {
                    case 0: {
                        if (n2 == -1) {
                            throw new Error("pc modifying insn in delay slot");
                        }
                        this.p(new StringBuffer().append("if(r").append(n7).append(" < 0) {").toString());
                        ++this.indent;
                        this.emitInstruction(-1, n4, -1);
                        this.branch(n2, n2 + n17 * 4 + 4);
                        --this.indent;
                        this.p("}");
                        return;
                    }
                    case 1: {
                        if (n2 == -1) {
                            throw new Error("pc modifying insn in delay slot");
                        }
                        this.p(new StringBuffer().append("if(r").append(n7).append(" >= 0) {").toString());
                        ++this.indent;
                        this.emitInstruction(-1, n4, -1);
                        this.branch(n2, n2 + n17 * 4 + 4);
                        --this.indent;
                        this.p("}");
                        return;
                    }
                    case 16: {
                        if (n2 == -1) {
                            throw new Error("pc modifying insn in delay slot");
                        }
                        this.p(new StringBuffer().append("if(r").append(n7).append(" < 0) {").toString());
                        ++this.indent;
                        this.emitInstruction(-1, n4, -1);
                        this.p(new StringBuffer().append("r31=").append(this.constant(n2 + 8)).append(";").toString());
                        this.branch(n2, n2 + n17 * 4 + 4);
                        --this.indent;
                        this.p("}");
                        return;
                    }
                    case 17: {
                        if (n2 == -1) {
                            throw new Error("pc modifying insn in delay slot");
                        }
                        this.p(new StringBuffer().append("if(r").append(n7).append(" >= 0) {").toString());
                        ++this.indent;
                        this.emitInstruction(-1, n4, -1);
                        this.p(new StringBuffer().append("r31=").append(this.constant(n2 + 8)).append(";").toString());
                        this.branch(n2, n2 + n17 * 4 + 4);
                        --this.indent;
                        this.p("}");
                        return;
                    }
                }
                throw new RuntimeException(new StringBuffer().append("Illegal Instruction 1/").append(n8).toString());
            }
            case 2: {
                if (n2 == -1) {
                    throw new Error("pc modifying insn in delay slot");
                }
                this.emitInstruction(-1, n4, -1);
                this.branch(n2, n2 & -268435456 | n15 << 2);
                this.unreachable = true;
                return;
            }
            case 3: {
                if (n2 == -1) {
                    throw new Error("pc modifying insn in delay slot");
                }
                int n18 = n2 & -268435456 | n15 << 2;
                this.emitInstruction(-1, n4, -1);
                this.p(new StringBuffer().append("r31=").append(this.constant(n2 + 8)).append(";").toString());
                this.branch(n2, n18);
                this.unreachable = true;
                return;
            }
            case 4: {
                if (n2 == -1) {
                    throw new Error("pc modifying insn in delay slot");
                }
                this.p(new StringBuffer().append("if(r").append(n7).append(" == r").append(n8).append(") {").toString());
                ++this.indent;
                this.emitInstruction(-1, n4, -1);
                this.branch(n2, n2 + n17 * 4 + 4);
                --this.indent;
                this.p("}");
                return;
            }
            case 5: {
                if (n2 == -1) {
                    throw new Error("pc modifying insn in delay slot");
                }
                this.p(new StringBuffer().append("if(r").append(n7).append(" != r").append(n8).append(") {").toString());
                ++this.indent;
                this.emitInstruction(-1, n4, -1);
                this.branch(n2, n2 + n17 * 4 + 4);
                --this.indent;
                this.p("}");
                return;
            }
            case 6: {
                if (n2 == -1) {
                    throw new Error("pc modifying insn in delay slot");
                }
                this.p(new StringBuffer().append("if(r").append(n7).append(" <= 0) {").toString());
                ++this.indent;
                this.emitInstruction(-1, n4, -1);
                this.branch(n2, n2 + n17 * 4 + 4);
                --this.indent;
                this.p("}");
                return;
            }
            case 7: {
                if (n2 == -1) {
                    throw new Error("pc modifying insn in delay slot");
                }
                this.p(new StringBuffer().append("if(r").append(n7).append(" > 0) {").toString());
                ++this.indent;
                this.emitInstruction(-1, n4, -1);
                this.branch(n2, n2 + n17 * 4 + 4);
                --this.indent;
                this.p("}");
                return;
            }
            case 8: {
                this.p(new StringBuffer().append("r").append(n8).append(" = r").append(n7).append(" + ").append(n5).append(";").toString());
                return;
            }
            case 9: {
                this.p(new StringBuffer().append("r").append(n8).append(" = r").append(n7).append(" + ").append(n5).append(";").toString());
                return;
            }
            case 10: {
                this.p(new StringBuffer().append("r").append(n8).append(" = r").append(n7).append(" < ").append(n5).append(" ? 1 : 0;").toString());
                return;
            }
            case 11: {
                this.p(new StringBuffer().append("r").append(n8).append(" = (r").append(n7).append("&0xffffffffL) < (").append(n5).append("&0xffffffffL) ? 1 : 0;").toString());
                return;
            }
            case 12: {
                this.p(new StringBuffer().append("r").append(n8).append(" = r").append(n7).append(" & ").append(n16).append(";").toString());
                return;
            }
            case 13: {
                this.p(new StringBuffer().append("r").append(n8).append(" = r").append(n7).append(" | ").append(n16).append(";").toString());
                return;
            }
            case 14: {
                this.p(new StringBuffer().append("r").append(n8).append(" = r").append(n7).append(" ^ ").append(n16).append(";").toString());
                return;
            }
            case 15: {
                this.p(new StringBuffer().append("r").append(n8).append(" = ").append(n16).append(" << 16;").toString());
                return;
            }
            case 16: {
                throw new Compiler$Exn("TLB/Exception support not implemented");
            }
            case 17: {
                switch (n7) {
                    case 0: {
                        this.p(new StringBuffer().append("r").append(n8).append(" = f").append(n10).append(";").toString());
                        return;
                    }
                    case 2: {
                        if (n11 != 31) {
                            throw new Compiler$Exn(new StringBuffer().append("FCR ").append(n11).append(" unavailable").toString());
                        }
                        this.p(new StringBuffer().append("r").append(n8).append(" = fcsr;").toString());
                        return;
                    }
                    case 4: {
                        this.p(new StringBuffer().append("f").append(n10).append(" = r").append(n8).append(";").toString());
                        return;
                    }
                    case 6: {
                        if (n11 != 31) {
                            throw new Compiler$Exn(new StringBuffer().append("FCR ").append(n11).append(" unavailable").toString());
                        }
                        this.p(new StringBuffer().append("fcsr = r").append(n8).append(";").toString());
                        return;
                    }
                    case 8: {
                        int n19 = n3 >>> 16 & 1;
                        this.p(new StringBuffer().append("if(((fcsr&0x800000)!=0) == (").append(n19).append("!=0)) {").toString());
                        ++this.indent;
                        this.emitInstruction(-1, n4, -1);
                        this.branch(n2, n2 + n17 * 4 + 4);
                        --this.indent;
                        this.p("}");
                        return;
                    }
                    case 16: {
                        switch (n14) {
                            case 0: {
                                this.p(JavaSourceCompiler.setFloat(n13, new StringBuffer().append(JavaSourceCompiler.getFloat(n11)).append("+").append(JavaSourceCompiler.getFloat(n9)).toString()));
                                return;
                            }
                            case 1: {
                                this.p(JavaSourceCompiler.setFloat(n13, new StringBuffer().append(JavaSourceCompiler.getFloat(n11)).append("-").append(JavaSourceCompiler.getFloat(n9)).toString()));
                                return;
                            }
                            case 2: {
                                this.p(JavaSourceCompiler.setFloat(n13, new StringBuffer().append(JavaSourceCompiler.getFloat(n11)).append("*").append(JavaSourceCompiler.getFloat(n9)).toString()));
                                return;
                            }
                            case 3: {
                                this.p(JavaSourceCompiler.setFloat(n13, new StringBuffer().append(JavaSourceCompiler.getFloat(n11)).append("/").append(JavaSourceCompiler.getFloat(n9)).toString()));
                                return;
                            }
                            case 5: {
                                this.p(JavaSourceCompiler.setFloat(n13, new StringBuffer().append("Math.abs(").append(JavaSourceCompiler.getFloat(n11)).append(")").toString()));
                                return;
                            }
                            case 6: {
                                this.p(new StringBuffer().append("f").append(n13).append(" = f").append(n11).append("; // MOV.S").toString());
                                return;
                            }
                            case 7: {
                                this.p(JavaSourceCompiler.setFloat(n13, new StringBuffer().append("-").append(JavaSourceCompiler.getFloat(n11)).toString()));
                                return;
                            }
                            case 33: {
                                this.p(JavaSourceCompiler.setDouble(n13, new StringBuffer().append("(float)").append(JavaSourceCompiler.getFloat(n11)).toString()));
                                return;
                            }
                            case 36: {
                                this.p("switch(fcsr & 3) {");
                                ++this.indent;
                                this.p(new StringBuffer().append("case 0: f").append(n13).append(" = (int)Math.floor(").append(JavaSourceCompiler.getFloat(n11)).append("+0.5); break; // Round to nearest").toString());
                                this.p(new StringBuffer().append("case 1: f").append(n13).append(" = (int)").append(JavaSourceCompiler.getFloat(n11)).append("; break; // Round towards zero").toString());
                                this.p(new StringBuffer().append("case 2: f").append(n13).append(" = (int)Math.ceil(").append(JavaSourceCompiler.getFloat(n11)).append("); break; // Round towards plus infinity").toString());
                                this.p(new StringBuffer().append("case 3: f").append(n13).append(" = (int)Math.floor(").append(JavaSourceCompiler.getFloat(n11)).append("); break; // Round towards minus infinity").toString());
                                --this.indent;
                                this.p("}");
                                return;
                            }
                            case 50: {
                                this.p(new StringBuffer().append("fcsr = (fcsr&~0x800000) | ((").append(JavaSourceCompiler.getFloat(n11)).append("==").append(JavaSourceCompiler.getFloat(n9)).append(") ? 0x800000 : 0x000000);").toString());
                                return;
                            }
                            case 60: {
                                this.p(new StringBuffer().append("fcsr = (fcsr&~0x800000) | ((").append(JavaSourceCompiler.getFloat(n11)).append("<").append(JavaSourceCompiler.getFloat(n9)).append(") ? 0x800000 : 0x000000);").toString());
                                return;
                            }
                            case 62: {
                                this.p(new StringBuffer().append("fcsr = (fcsr&~0x800000) | ((").append(JavaSourceCompiler.getFloat(n11)).append("<=").append(JavaSourceCompiler.getFloat(n9)).append(") ? 0x800000 : 0x000000);").toString());
                                return;
                            }
                        }
                        throw new Compiler$Exn(new StringBuffer().append("Invalid Instruction 17/").append(n7).append("/").append(n14).toString());
                    }
                    case 17: {
                        switch (n14) {
                            case 0: {
                                this.p(JavaSourceCompiler.setDouble(n13, new StringBuffer().append(JavaSourceCompiler.getDouble(n11)).append("+").append(JavaSourceCompiler.getDouble(n9)).toString()));
                                return;
                            }
                            case 1: {
                                this.p(JavaSourceCompiler.setDouble(n13, new StringBuffer().append(JavaSourceCompiler.getDouble(n11)).append("-").append(JavaSourceCompiler.getDouble(n9)).toString()));
                                return;
                            }
                            case 2: {
                                this.p(JavaSourceCompiler.setDouble(n13, new StringBuffer().append(JavaSourceCompiler.getDouble(n11)).append("*").append(JavaSourceCompiler.getDouble(n9)).toString()));
                                return;
                            }
                            case 3: {
                                this.p(JavaSourceCompiler.setDouble(n13, new StringBuffer().append(JavaSourceCompiler.getDouble(n11)).append("/").append(JavaSourceCompiler.getDouble(n9)).toString()));
                                return;
                            }
                            case 5: {
                                this.p(JavaSourceCompiler.setDouble(n13, new StringBuffer().append("Math.abs(").append(JavaSourceCompiler.getDouble(n11)).append(")").toString()));
                                return;
                            }
                            case 6: {
                                this.p(new StringBuffer().append("f").append(n13).append(" = f").append(n11).append(";").toString());
                                this.p(new StringBuffer().append("f").append(n13 + 1).append(" = f").append(n11 + 1).append(";").toString());
                                return;
                            }
                            case 7: {
                                this.p(JavaSourceCompiler.setDouble(n13, new StringBuffer().append("-").append(JavaSourceCompiler.getDouble(n11)).toString()));
                                return;
                            }
                            case 32: {
                                this.p(JavaSourceCompiler.setFloat(n13, new StringBuffer().append("(float)").append(JavaSourceCompiler.getDouble(n11)).toString()));
                                return;
                            }
                            case 36: {
                                this.p("switch(fcsr & 3) {");
                                ++this.indent;
                                this.p(new StringBuffer().append("case 0: f").append(n13).append(" = (int)Math.floor(").append(JavaSourceCompiler.getDouble(n11)).append("+0.5); break; // Round to nearest").toString());
                                this.p(new StringBuffer().append("case 1: f").append(n13).append(" = (int)").append(JavaSourceCompiler.getDouble(n11)).append("; break; // Round towards zero").toString());
                                this.p(new StringBuffer().append("case 2: f").append(n13).append(" = (int)Math.ceil(").append(JavaSourceCompiler.getDouble(n11)).append("); break; // Round towards plus infinity").toString());
                                this.p(new StringBuffer().append("case 3: f").append(n13).append(" = (int)Math.floor(").append(JavaSourceCompiler.getDouble(n11)).append("); break; // Round towards minus infinity").toString());
                                --this.indent;
                                this.p("}");
                                return;
                            }
                            case 50: {
                                this.p(new StringBuffer().append("fcsr = (fcsr&~0x800000) | ((").append(JavaSourceCompiler.getDouble(n11)).append("==").append(JavaSourceCompiler.getDouble(n9)).append(") ? 0x800000 : 0x000000);").toString());
                                return;
                            }
                            case 60: {
                                this.p(new StringBuffer().append("fcsr = (fcsr&~0x800000) | ((").append(JavaSourceCompiler.getDouble(n11)).append("<").append(JavaSourceCompiler.getDouble(n9)).append(") ? 0x800000 : 0x000000);").toString());
                                return;
                            }
                            case 62: {
                                this.p(new StringBuffer().append("fcsr = (fcsr&~0x800000) | ((").append(JavaSourceCompiler.getDouble(n11)).append("<=").append(JavaSourceCompiler.getDouble(n9)).append(") ? 0x800000 : 0x000000);").toString());
                                return;
                            }
                        }
                        throw new Compiler$Exn(new StringBuffer().append("Invalid Instruction 17/").append(n7).append("/").append(n14).toString());
                    }
                    case 20: {
                        switch (n14) {
                            case 32: {
                                this.p(" // CVS.S.W");
                                this.p(JavaSourceCompiler.setFloat(n13, new StringBuffer().append("((float)f").append(n11).append(")").toString()));
                                return;
                            }
                            case 33: {
                                this.p(JavaSourceCompiler.setDouble(n13, new StringBuffer().append("((double)f").append(n11).append(")").toString()));
                                return;
                            }
                        }
                        throw new Compiler$Exn(new StringBuffer().append("Invalid Instruction 17/").append(n7).append("/").append(n14).toString());
                    }
                }
                throw new Compiler$Exn(new StringBuffer().append("Invalid Instruction 17/").append(n7).toString());
            }
            case 18: 
            case 19: {
                throw new Compiler$Exn("coprocessor 2 and 3 instructions not available");
            }
            case 32: {
                if (this.runtimeStats) {
                    this.p("inc(\"LB\");");
                }
                this.p(new StringBuffer().append("addr=r").append(n7).append("+").append(n5).append(";").toString());
                this.memRead("addr", "tmp");
                this.p("tmp = (tmp>>>(((~addr)&3)<<3)) & 0xff;");
                this.p("if((tmp&0x80)!=0) tmp |= 0xffffff00; /* sign extend */");
                this.p(new StringBuffer().append("r").append(n8).append(" = tmp;").toString());
                return;
            }
            case 33: {
                if (this.runtimeStats) {
                    this.p("inc(\"LH\");");
                }
                this.p(new StringBuffer().append("addr=r").append(n7).append("+").append(n5).append(";").toString());
                this.memRead("addr", "tmp");
                this.p("tmp = (tmp>>>(((~addr)&2)<<3)) & 0xffff;");
                this.p("if((tmp&0x8000)!=0) tmp |= 0xffff0000; /* sign extend */");
                this.p(new StringBuffer().append("r").append(n8).append(" = tmp;").toString());
                return;
            }
            case 34: {
                this.p(new StringBuffer().append("addr=r").append(n7).append("+").append(n5).append(";").toString());
                this.memRead("addr", "tmp");
                this.p(new StringBuffer().append("r").append(n8).append(" = (r").append(n8).append("&(0x00ffffff>>>(((~addr)&3)<<3)))|(tmp<<((addr&3)<<3));").toString());
                return;
            }
            case 35: {
                if (this.runtimeStats) {
                    this.p("inc(\"LW\");");
                }
                this.memRead(new StringBuffer().append("r").append(n7).append("+").append(n5).toString(), new StringBuffer().append("r").append(n8).toString());
                return;
            }
            case 36: {
                this.p(new StringBuffer().append("addr=r").append(n7).append("+").append(n5).append(";").toString());
                this.memRead("addr", "tmp");
                this.p("tmp = (tmp>>>(((~addr)&3)<<3)) & 0xff;");
                this.p(new StringBuffer().append("r").append(n8).append(" = tmp;").toString());
                return;
            }
            case 37: {
                this.p(new StringBuffer().append("addr=r").append(n7).append("+").append(n5).append(";").toString());
                this.memRead("addr", "tmp");
                this.p("tmp = (tmp>>>(((~addr)&2)<<3)) & 0xffff;");
                this.p(new StringBuffer().append("r").append(n8).append(" = tmp;").toString());
                return;
            }
            case 38: {
                this.p(new StringBuffer().append("addr=r").append(n7).append("+").append(n5).append(";").toString());
                this.memRead("addr", "tmp");
                this.p(new StringBuffer().append("r").append(n8).append(" = (r").append(n8).append("&(0xffffff00<<((addr&3)<<3)))|(tmp>>>(((~addr)&3)<<3));").toString());
                return;
            }
            case 40: {
                if (this.runtimeStats) {
                    this.p("inc(\"SB\");");
                }
                this.p(new StringBuffer().append("addr=r").append(n7).append("+").append(n5).append(";").toString());
                this.memRead("addr", "tmp");
                this.p(new StringBuffer().append("tmp = (tmp&~(0xff000000>>>((addr&3)<<3)))|((r").append(n8).append("&0xff)<<(((~addr)&3)<<3));").toString());
                this.memWrite("addr", "tmp");
                return;
            }
            case 41: {
                if (this.runtimeStats) {
                    this.p("inc(\"SH\");");
                }
                this.p(new StringBuffer().append("addr=r").append(n7).append("+").append(n5).append(";").toString());
                this.memRead("addr", "tmp");
                this.p(new StringBuffer().append("tmp = (tmp&(0xffff<<((addr&2)<<3)))|((r").append(n8).append("&0xffff)<<(((~addr)&2)<<3));").toString());
                this.memWrite("addr", "tmp");
                return;
            }
            case 42: {
                this.p(" // SWL");
                this.p(new StringBuffer().append("addr=r").append(n7).append("+").append(n5).append(";").toString());
                this.memRead("addr", "tmp");
                this.p(new StringBuffer().append("tmp = (tmp&(0xffffff00<<(((~addr)&3)<<3)))|(r").append(n8).append(">>>((addr&3)<<3));").toString());
                this.memWrite("addr", "tmp");
                return;
            }
            case 43: {
                if (this.runtimeStats) {
                    this.p("inc(\"SW\");");
                }
                this.memWrite(new StringBuffer().append("r").append(n7).append("+").append(n5).toString(), new StringBuffer().append("r").append(n8).toString());
                return;
            }
            case 46: {
                this.p(" // SWR");
                this.p(new StringBuffer().append("addr=r").append(n7).append("+").append(n5).append(";").toString());
                this.memRead("addr", "tmp");
                this.p(new StringBuffer().append("tmp = (tmp&(0x00ffffff>>>((addr&3)<<3)))|(r").append(n8).append("<<(((~addr)&3)<<3));").toString());
                this.memWrite("addr", "tmp");
                return;
            }
            case 48: {
                this.memRead(new StringBuffer().append("r").append(n7).append("+").append(n5).toString(), new StringBuffer().append("r").append(n8).toString());
                return;
            }
            case 49: {
                this.memRead(new StringBuffer().append("r").append(n7).append("+").append(n5).toString(), new StringBuffer().append("f").append(n8).toString());
                return;
            }
            case 56: {
                this.memWrite(new StringBuffer().append("r").append(n7).append("+").append(n5).toString(), new StringBuffer().append("r").append(n8).toString());
                this.p(new StringBuffer().append("r").append(n8).append("=1;").toString());
                return;
            }
            case 57: {
                this.memWrite(new StringBuffer().append("r").append(n7).append("+").append(n5).toString(), new StringBuffer().append("f").append(n8).toString());
                return;
            }
        }
        throw new Compiler$Exn(new StringBuffer().append("Invalid Instruction: ").append(n6).append(" at ").append(JavaSourceCompiler.toHex(n2)).toString());
    }

    private void memWrite(String string, String string2) {
        if (this.nullPointerCheck) {
            this.p(new StringBuffer().append("nullPointerCheck(").append(string).append(");").toString());
        }
        if (this.onePage) {
            this.p(new StringBuffer().append("page[(").append(string).append(")>>>2] = ").append(string2).append(";").toString());
            return;
        }
        if (this.fastMem) {
            this.p(new StringBuffer().append("writePages[(").append(string).append(")>>>").append(this.pageShift).append("][((").append(string).append(")>>>2)&").append(JavaSourceCompiler.toHex((this.pageSize >> 2) - 1)).append("] = ").append(string2).append(";").toString());
            return;
        }
        this.p(new StringBuffer().append("unsafeMemWrite(").append(string).append(",").append(string2).append(");").toString());
    }

    private void memRead(String string, String string2) {
        if (this.nullPointerCheck) {
            this.p(new StringBuffer().append("nullPointerCheck(").append(string).append(");").toString());
        }
        if (this.onePage) {
            this.p(new StringBuffer().append(string2).append("= page[(").append(string).append(")>>>2];").toString());
            return;
        }
        if (this.fastMem) {
            this.p(new StringBuffer().append(string2).append(" = readPages[(").append(string).append(")>>>").append(this.pageShift).append("][((").append(string).append(")>>>2)&").append(JavaSourceCompiler.toHex((this.pageSize >> 2) - 1)).append("];").toString());
            return;
        }
        this.p(new StringBuffer().append(string2).append(" = unsafeMemRead(").append(string).append(");").toString());
    }

    private static String getFloat(int n2) {
        return new StringBuffer().append("(Float.intBitsToFloat(f").append(n2).append("))").toString();
    }

    private static String getDouble(int n2) {
        return new StringBuffer().append("(Double.longBitsToDouble(((f").append(n2 + 1).append("&0xffffffffL) << 32) | (f").append(n2).append("&0xffffffffL)))").toString();
    }

    private static String setFloat(int n2, String string) {
        return new StringBuffer().append("f").append(n2).append("=Float.floatToRawIntBits(").append(string).append(");").toString();
    }

    private static String setDouble(int n2, String string) {
        return new StringBuffer().append("{ long l = Double.doubleToLongBits(").append(string).append("); ").append("f").append(n2 + 1).append(" = (int)(l >>> 32); f").append(n2).append(" = (int)l; }").toString();
    }

    static {
        String string = "";
        int n2 = 0;
        while (n2 < indents.length) {
            JavaSourceCompiler.indents[n2] = string;
            ++n2;
            string = new StringBuffer().append(string).append("    ").toString();
        }
    }
}

