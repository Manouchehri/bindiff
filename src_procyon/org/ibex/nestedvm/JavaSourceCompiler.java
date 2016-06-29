package org.ibex.nestedvm;

import java.util.*;
import java.io.*;
import org.ibex.nestedvm.util.*;

public class JavaSourceCompiler extends Compiler
{
    private StringBuffer runs;
    private StringBuffer inits;
    private StringBuffer classLevel;
    private PrintWriter out;
    private int indent;
    private static String[] indents;
    private int startOfMethod;
    private int endOfMethod;
    private HashMap relativeAddrs;
    private boolean textDone;
    private int initDataCount;
    private boolean unreachable;
    
    private void p() {
        this.out.println();
    }
    
    private void p(final String s) {
        this.out.println(JavaSourceCompiler.indents[this.indent] + s);
    }
    
    private void pblock(final StringBuffer sb) {
        this.out.print(sb.toString());
    }
    
    public JavaSourceCompiler(final Seekable seekable, final String s, final Writer writer) {
        super(seekable, s);
        this.runs = new StringBuffer();
        this.inits = new StringBuffer();
        this.classLevel = new StringBuffer();
        this.startOfMethod = 0;
        this.endOfMethod = 0;
        this.relativeAddrs = new HashMap();
        this.initDataCount = 0;
        this.unreachable = false;
        this.out = new PrintWriter(writer);
    }
    
    protected void _go() {
        if (this.singleFloat) {
            throw new Compiler$Exn("JavaSourceCompiler doesn't support singleFloat");
        }
        String substring;
        String s;
        if (this.fullClassName.indexOf(46) != -1) {
            substring = this.fullClassName.substring(0, this.fullClassName.lastIndexOf(46));
            s = this.fullClassName.substring(this.fullClassName.lastIndexOf(46) + 1);
        }
        else {
            s = this.fullClassName;
            substring = null;
        }
        this.p("/* This file was generated from " + this.source + " by Mips2Java on " + Compiler.dateTime() + " */");
        if (substring != null) {
            this.p("package " + substring + ";");
        }
        if (this.runtimeStats) {
            this.p("import java.util.*;");
        }
        this.p();
        this.p("public final class " + s + " extends " + this.runtimeClass + " {");
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
        int max = 0;
        for (int i = 0; i < this.elf.sheaders.length; ++i) {
            final ELF$SHeader elf$SHeader = this.elf.sheaders[i];
            final String name = elf$SHeader.name;
            if (elf$SHeader.addr != 0) {
                max = Math.max(max, elf$SHeader.addr + elf$SHeader.size);
                if (name.equals(".text")) {
                    this.emitText(elf$SHeader.addr, new DataInputStream(elf$SHeader.getInputStream()), elf$SHeader.size);
                }
                else if (name.equals(".data") || name.equals(".sdata") || name.equals(".rodata") || name.equals(".ctors") || name.equals(".dtors")) {
                    this.emitData(elf$SHeader.addr, new DataInputStream(elf$SHeader.getInputStream()), elf$SHeader.size, name.equals(".rodata"));
                }
                else {
                    if (!name.equals(".bss") && !name.equals(".sbss")) {
                        throw new Compiler$Exn("Unknown segment: " + name);
                    }
                    this.emitBSS(elf$SHeader.addr, elf$SHeader.size);
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
        this.p("public " + s + "() {");
        ++this.indent;
        this.p("super(" + this.pageSize + "," + this.totalPages + ");");
        this.pblock(this.inits);
        --this.indent;
        this.p("}");
        this.p();
        this.p("protected int entryPoint() { return " + Compiler.toHex(this.elf.header.entry) + "; }");
        this.p("protected int heapStart() { return " + Compiler.toHex(max) + "; }");
        this.p("protected int gp() { return " + Compiler.toHex(this.gp.addr) + "; }");
        if (this.userInfo != null) {
            this.p("protected int userInfoBase() { return " + Compiler.toHex(this.userInfo.addr) + "; }");
            this.p("protected int userInfoSize() { return " + Compiler.toHex(this.userInfo.size) + "; }");
        }
        this.p("public static void main(String[] args) throws Exception {");
        ++this.indent;
        this.p("" + s + " me = new " + s + "();");
        this.p("int status = me.run(\"" + this.fullClassName + "\",args);");
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
        for (int j = 1; j < 32; ++j) {
            this.p("r" + j + "=state.r[" + j + "];");
        }
        for (int k = 0; k < 32; ++k) {
            this.p("f" + k + "=state.f[" + k + "];");
        }
        this.p("hi=state.hi; lo=state.lo; fcsr=state.fcsr;");
        this.p("pc=state.pc;");
        --this.indent;
        this.p("}");
        this.p("protected void getCPUState(CPUState state) {");
        ++this.indent;
        for (int l = 1; l < 32; ++l) {
            this.p("state.r[" + l + "]=r" + l + ";");
        }
        for (int n = 0; n < 32; ++n) {
            this.p("state.f[" + n + "]=f" + n + ";");
        }
        this.p("state.hi=hi; state.lo=lo; state.fcsr=fcsr;");
        this.p("state.pc=pc;");
        --this.indent;
        this.p("}");
        this.p();
        if (this.supportCall) {
            this.p("private static final " + this.hashClass + " symbols = new " + this.hashClass + "();");
            this.p("static {");
            ++this.indent;
            final ELF$Symbol[] symbols = this.elf.getSymtab().symbols;
            for (int n2 = 0; n2 < symbols.length; ++n2) {
                final ELF$Symbol elf$Symbol = symbols[n2];
                if (elf$Symbol.type == 2 && elf$Symbol.binding == 1 && (elf$Symbol.name.equals("_call_helper") || !elf$Symbol.name.startsWith("_"))) {
                    this.p("symbols.put(\"" + elf$Symbol.name + "\",new Integer(" + Compiler.toHex(elf$Symbol.addr) + "));");
                }
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
    
    private void startMethod(int startOfMethod) {
        startOfMethod &= ~(this.maxBytesPerMethod - 1);
        this.startOfMethod = startOfMethod;
        this.endOfMethod = startOfMethod + this.maxBytesPerMethod;
        final String string = "run_" + Long.toString(startOfMethod & 0xFFFFFFFFL, 16);
        this.runs.append(JavaSourceCompiler.indents[4] + "case " + Compiler.toHex(startOfMethod >>> this.methodShift) + ": " + string + "(); break; \n");
        this.p("private final void " + string + "() throws ExecutionException { /" + "* " + Compiler.toHex(startOfMethod) + " - " + Compiler.toHex(this.endOfMethod) + " *" + "/");
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
    
    private void endMethod(final int n) {
        if (this.startOfMethod == 0) {
            return;
        }
        this.p("case " + Compiler.toHex(n) + ":");
        ++this.indent;
        this.p("pc=" + this.constant(n) + ";");
        this.leaveMethod();
        --this.indent;
        if (this.debugCompiler) {
            this.p("default: throw new ExecutionException(\"invalid address 0x\" + Long.toString(pc&0xffffffffL,16)  + \" (got here from 0x\" + Long.toString(lastPC&0xffffffffL,16)+\")\");");
        }
        else {
            this.p("default: throw new ExecutionException(\"invalid address 0x\" + Long.toString(pc&0xffffffffL,16));");
        }
        --this.indent;
        this.p("}");
        this.p("/* NOT REACHED */");
        --this.indent;
        this.p("}");
        --this.indent;
        this.p("}");
        final boolean b = false;
        this.startOfMethod = (b ? 1 : 0);
        this.endOfMethod = (b ? 1 : 0);
    }
    
    private String constant(final int n) {
        if (n >= 4096 && this.lessConstants) {
            final int n2 = n & 0xFFFFFC00;
            final String string = "N_" + Compiler.toHex8(n2);
            if (this.relativeAddrs.get(new Integer(n2)) == null) {
                this.relativeAddrs.put(new Integer(n2), Boolean.TRUE);
                this.classLevel.append(JavaSourceCompiler.indents[1] + "private static int " + string + " = " + Compiler.toHex(n2) + ";\n");
            }
            return "(" + string + " + " + Compiler.toHex(n - n2) + ")";
        }
        return Compiler.toHex(n);
    }
    
    private void branch(final int n, final int n2) {
        if (this.debugCompiler) {
            this.p("lastPC = " + Compiler.toHex(n) + ";");
        }
        this.p("pc=" + this.constant(n2) + ";");
        if (n2 == 0) {
            this.p("throw new ExecutionException(\"Branch to addr 0x0\");");
        }
        else if ((n & this.methodMask) == (n2 & this.methodMask)) {
            this.p("continue;");
        }
        else if (this.assumeTailCalls) {
            this.p("run_" + Long.toString(n2 & this.methodMask & 0xFFFFFFFFL, 16) + "(); return;");
        }
        else {
            this.leaveMethod();
        }
    }
    
    private void leaveMethod() {
        this.p("return;");
    }
    
    private void emitText(int n, final DataInputStream dataInputStream, final int n2) {
        if (this.textDone) {
            throw new Compiler$Exn("Multiple text segments");
        }
        this.textDone = true;
        if ((n & 0x3) != 0x0 || (n2 & 0x3) != 0x0) {
            throw new Compiler$Exn("Section on weird boundaries");
        }
        final int n3 = n2 / 4;
        int int1 = dataInputStream.readInt();
        if (int1 == -1) {
            throw new Error("Actually read -1 at " + Compiler.toHex(n));
        }
        for (int i = 0; i < n3; ++i, n += 4) {
            final int n4 = int1;
            int1 = ((i == n3 - 1) ? -1 : dataInputStream.readInt());
            if (n >= this.endOfMethod) {
                this.endMethod();
                this.startMethod(n);
            }
            if (this.jumpableAddresses == null || n == this.startOfMethod || this.jumpableAddresses.get(new Integer(n)) != null) {
                this.p("case " + Compiler.toHex(n) + ":");
                this.unreachable = false;
            }
            else {
                if (this.unreachable) {
                    continue;
                }
                if (this.debugCompiler) {
                    this.p("/* pc = " + Compiler.toHex(n) + "*" + "/");
                }
            }
            ++this.indent;
            this.emitInstruction(n, n4, int1);
            --this.indent;
        }
        this.endMethod(n);
        this.p();
        dataInputStream.close();
    }
    
    private void emitData(int i, final DataInputStream dataInputStream, int n, final boolean b) {
        if ((i & 0x3) != 0x0 || (n & 0x3) != 0x0) {
            throw new Compiler$Exn("Data section on weird boundaries");
        }
        while (i < i + n) {
            final int min = Math.min(n, 28000);
            final StringBuffer sb = new StringBuffer();
            for (int j = 0; j < min; j += 7) {
                long n2 = 0L;
                for (int k = 0; k < 7; ++k) {
                    n2 = (n2 << 8 | (((j + k < n) ? dataInputStream.readByte() : 1) & 0xFFL));
                }
                for (int l = 0; l < 8; ++l) {
                    final char c = (char)(n2 >>> 7 * (7 - l) & 0x7FL);
                    if (c == '\n') {
                        sb.append("\\n");
                    }
                    else if (c == '\r') {
                        sb.append("\\r");
                    }
                    else if (c == '\\') {
                        sb.append("\\\\");
                    }
                    else if (c == '\"') {
                        sb.append("\\\"");
                    }
                    else if (c >= ' ' && c <= '~') {
                        sb.append(c);
                    }
                    else {
                        sb.append("\\" + Compiler.toOctal3(c));
                    }
                }
            }
            final String string = "_data" + ++this.initDataCount;
            this.p("private static final int[] " + string + " = decodeData(\"" + sb.toString() + "\"," + Compiler.toHex(min / 4) + ");");
            this.inits.append(JavaSourceCompiler.indents[2] + "initPages(" + string + "," + Compiler.toHex(i) + "," + (b ? "true" : "false") + ");\n");
            i += min;
            n -= min;
        }
        dataInputStream.close();
    }
    
    private void emitBSS(final int n, int n2) {
        if ((n & 0x3) != 0x0) {
            throw new Compiler$Exn("BSS section on weird boundaries");
        }
        n2 = (n2 + 3 & 0xFFFFFFFC);
        this.inits.append(JavaSourceCompiler.indents[2] + "clearPages(" + Compiler.toHex(n) + "," + Compiler.toHex(n2 / 4) + ");\n");
    }
    
    private void emitInstruction(final int n, final int n2, final int n3) {
        if (n2 == -1) {
            throw new Error("insn is -1");
        }
        final int n4 = n2 >>> 26 & 0xFF;
        final int n5 = n2 >>> 21 & 0x1F;
        final int n6 = n2 >>> 16 & 0x1F;
        final int n7 = n2 >>> 16 & 0x1F;
        final int n8 = n2 >>> 11 & 0x1F;
        final int n9 = n2 >>> 11 & 0x1F;
        final int n10 = n2 >>> 6 & 0x1F;
        final int n11 = n2 >>> 6 & 0x1F;
        final int n12 = n2 & 0x3F;
        final int n13 = n2 & 0x3FFFFFF;
        final int n14 = n2 & 0xFFFF;
        final int n16;
        final int n15 = n16 = n2 << 16 >> 16;
        if (n == -1) {
            this.p("/* Next insn is delay slot */ ");
        }
        if (this.runtimeStats && n4 != 0) {
            this.p("inc(\"opcode: " + n4 + "\");");
        }
        Label_7662: {
            switch (n4) {
                case 0: {
                    if (this.runtimeStats && n2 != 0) {
                        this.p("inc(\"opcode: 0/" + n12 + "\");");
                    }
                    switch (n12) {
                        case 0: {
                            if (n2 != 0) {
                                this.p("r" + n8 + " = r" + n6 + " << " + n10 + ";");
                                break Label_7662;
                            }
                            break Label_7662;
                        }
                        case 2: {
                            this.p("r" + n8 + " = r" + n6 + " >>> " + n10 + ";");
                            break Label_7662;
                        }
                        case 3: {
                            this.p("r" + n8 + " = r" + n6 + " >> " + n10 + ";");
                            break Label_7662;
                        }
                        case 4: {
                            this.p("r" + n8 + " = r" + n6 + " << (r" + n5 + "&0x1f);");
                            break Label_7662;
                        }
                        case 6: {
                            this.p("r" + n8 + " = r" + n6 + " >>> (r" + n5 + "&0x1f);");
                            break Label_7662;
                        }
                        case 7: {
                            this.p("r" + n8 + " = r" + n6 + " >> (r" + n5 + "&0x1f);");
                            break Label_7662;
                        }
                        case 8: {
                            if (n == -1) {
                                throw new Error("pc modifying insn in delay slot");
                            }
                            this.emitInstruction(-1, n3, -1);
                            if (this.debugCompiler) {
                                this.p("lastPC = " + Compiler.toHex(n) + ";");
                            }
                            this.p("pc=r" + n5 + ";");
                            this.leaveMethod();
                            this.unreachable = true;
                            break Label_7662;
                        }
                        case 9: {
                            if (n == -1) {
                                throw new Error("pc modifying insn in delay slot");
                            }
                            this.emitInstruction(-1, n3, -1);
                            if (this.debugCompiler) {
                                this.p("lastPC = " + Compiler.toHex(n) + ";");
                            }
                            this.p("pc=r" + n5 + ";");
                            this.p("r31=" + this.constant(n + 8) + ";");
                            this.leaveMethod();
                            this.unreachable = true;
                            break Label_7662;
                        }
                        case 12: {
                            this.p("pc = " + Compiler.toHex(n) + ";");
                            this.p("r2 = syscall(r2,r4,r5,r6,r7,r8,r9);");
                            this.p("if (state != RUNNING) {");
                            ++this.indent;
                            this.p("pc = " + Compiler.toHex(n + 4) + ";");
                            this.leaveMethod();
                            --this.indent;
                            this.p("}");
                            break Label_7662;
                        }
                        case 13: {
                            this.p("throw new ExecutionException(\"Break\");");
                            this.unreachable = true;
                            break Label_7662;
                        }
                        case 16: {
                            this.p("r" + n8 + " = hi;");
                            break Label_7662;
                        }
                        case 17: {
                            this.p("hi = r" + n5 + ";");
                            break Label_7662;
                        }
                        case 18: {
                            this.p("r" + n8 + " = lo;");
                            break Label_7662;
                        }
                        case 19: {
                            this.p("lo = r" + n5 + ";");
                            break Label_7662;
                        }
                        case 24: {
                            this.p("{ long hilo = (long)(r" + n5 + ") * ((long)r" + n6 + "); " + "hi = (int) (hilo >>> 32); " + "lo = (int) hilo; }");
                            break Label_7662;
                        }
                        case 25: {
                            this.p("{ long hilo = (r" + n5 + " & 0xffffffffL) * (r" + n6 + " & 0xffffffffL); " + "hi = (int) (hilo >>> 32); " + "lo = (int) hilo; } ");
                            break Label_7662;
                        }
                        case 26: {
                            this.p("hi = r" + n5 + "%r" + n6 + "; lo = r" + n5 + "/r" + n6 + ";");
                            break Label_7662;
                        }
                        case 27: {
                            this.p("if(r" + n6 + "!=0) {");
                            this.p("hi = (int)((r" + n5 + " & 0xffffffffL) % (r" + n6 + " & 0xffffffffL)); " + "lo = (int)((r" + n5 + " & 0xffffffffL) / (r" + n6 + " & 0xffffffffL));");
                            this.p("}");
                            break Label_7662;
                        }
                        case 32: {
                            throw new Compiler$Exn("ADD (add with oveflow trap) not suported");
                        }
                        case 33: {
                            this.p("r" + n8 + " = r" + n5 + " + r" + n6 + ";");
                            break Label_7662;
                        }
                        case 34: {
                            throw new Compiler$Exn("SUB (add with oveflow trap) not suported");
                        }
                        case 35: {
                            this.p("r" + n8 + " = r" + n5 + " - r" + n6 + ";");
                            break Label_7662;
                        }
                        case 36: {
                            this.p("r" + n8 + " = r" + n5 + " & r" + n6 + ";");
                            break Label_7662;
                        }
                        case 37: {
                            this.p("r" + n8 + " = r" + n5 + " | r" + n6 + ";");
                            break Label_7662;
                        }
                        case 38: {
                            this.p("r" + n8 + " = r" + n5 + " ^ r" + n6 + ";");
                            break Label_7662;
                        }
                        case 39: {
                            this.p("r" + n8 + " = ~(r" + n5 + " | r" + n6 + ");");
                            break Label_7662;
                        }
                        case 42: {
                            this.p("r" + n8 + " = r" + n5 + " < r" + n6 + " ? 1 : 0;");
                            break Label_7662;
                        }
                        case 43: {
                            this.p("r" + n8 + " = ((r" + n5 + " & 0xffffffffL) < (r" + n6 + " & 0xffffffffL)) ? 1 : 0;");
                            break Label_7662;
                        }
                        default: {
                            throw new RuntimeException("Illegal instruction 0/" + n12);
                        }
                    }
                    break;
                }
                case 1: {
                    switch (n6) {
                        case 0: {
                            if (n == -1) {
                                throw new Error("pc modifying insn in delay slot");
                            }
                            this.p("if(r" + n5 + " < 0) {");
                            ++this.indent;
                            this.emitInstruction(-1, n3, -1);
                            this.branch(n, n + n16 * 4 + 4);
                            --this.indent;
                            this.p("}");
                            break Label_7662;
                        }
                        case 1: {
                            if (n == -1) {
                                throw new Error("pc modifying insn in delay slot");
                            }
                            this.p("if(r" + n5 + " >= 0) {");
                            ++this.indent;
                            this.emitInstruction(-1, n3, -1);
                            this.branch(n, n + n16 * 4 + 4);
                            --this.indent;
                            this.p("}");
                            break Label_7662;
                        }
                        case 16: {
                            if (n == -1) {
                                throw new Error("pc modifying insn in delay slot");
                            }
                            this.p("if(r" + n5 + " < 0) {");
                            ++this.indent;
                            this.emitInstruction(-1, n3, -1);
                            this.p("r31=" + this.constant(n + 8) + ";");
                            this.branch(n, n + n16 * 4 + 4);
                            --this.indent;
                            this.p("}");
                            break Label_7662;
                        }
                        case 17: {
                            if (n == -1) {
                                throw new Error("pc modifying insn in delay slot");
                            }
                            this.p("if(r" + n5 + " >= 0) {");
                            ++this.indent;
                            this.emitInstruction(-1, n3, -1);
                            this.p("r31=" + this.constant(n + 8) + ";");
                            this.branch(n, n + n16 * 4 + 4);
                            --this.indent;
                            this.p("}");
                            break Label_7662;
                        }
                        default: {
                            throw new RuntimeException("Illegal Instruction 1/" + n6);
                        }
                    }
                    break;
                }
                case 2: {
                    if (n == -1) {
                        throw new Error("pc modifying insn in delay slot");
                    }
                    this.emitInstruction(-1, n3, -1);
                    this.branch(n, (n & 0xF0000000) | n13 << 2);
                    this.unreachable = true;
                    break;
                }
                case 3: {
                    if (n == -1) {
                        throw new Error("pc modifying insn in delay slot");
                    }
                    final int n17 = (n & 0xF0000000) | n13 << 2;
                    this.emitInstruction(-1, n3, -1);
                    this.p("r31=" + this.constant(n + 8) + ";");
                    this.branch(n, n17);
                    this.unreachable = true;
                    break;
                }
                case 4: {
                    if (n == -1) {
                        throw new Error("pc modifying insn in delay slot");
                    }
                    this.p("if(r" + n5 + " == r" + n6 + ") {");
                    ++this.indent;
                    this.emitInstruction(-1, n3, -1);
                    this.branch(n, n + n16 * 4 + 4);
                    --this.indent;
                    this.p("}");
                    break;
                }
                case 5: {
                    if (n == -1) {
                        throw new Error("pc modifying insn in delay slot");
                    }
                    this.p("if(r" + n5 + " != r" + n6 + ") {");
                    ++this.indent;
                    this.emitInstruction(-1, n3, -1);
                    this.branch(n, n + n16 * 4 + 4);
                    --this.indent;
                    this.p("}");
                    break;
                }
                case 6: {
                    if (n == -1) {
                        throw new Error("pc modifying insn in delay slot");
                    }
                    this.p("if(r" + n5 + " <= 0) {");
                    ++this.indent;
                    this.emitInstruction(-1, n3, -1);
                    this.branch(n, n + n16 * 4 + 4);
                    --this.indent;
                    this.p("}");
                    break;
                }
                case 7: {
                    if (n == -1) {
                        throw new Error("pc modifying insn in delay slot");
                    }
                    this.p("if(r" + n5 + " > 0) {");
                    ++this.indent;
                    this.emitInstruction(-1, n3, -1);
                    this.branch(n, n + n16 * 4 + 4);
                    --this.indent;
                    this.p("}");
                    break;
                }
                case 8: {
                    this.p("r" + n6 + " = r" + n5 + " + " + n15 + ";");
                    break;
                }
                case 9: {
                    this.p("r" + n6 + " = r" + n5 + " + " + n15 + ";");
                    break;
                }
                case 10: {
                    this.p("r" + n6 + " = r" + n5 + " < " + n15 + " ? 1 : 0;");
                    break;
                }
                case 11: {
                    this.p("r" + n6 + " = (r" + n5 + "&0xffffffffL) < (" + n15 + "&0xffffffffL) ? 1 : 0;");
                    break;
                }
                case 12: {
                    this.p("r" + n6 + " = r" + n5 + " & " + n14 + ";");
                    break;
                }
                case 13: {
                    this.p("r" + n6 + " = r" + n5 + " | " + n14 + ";");
                    break;
                }
                case 14: {
                    this.p("r" + n6 + " = r" + n5 + " ^ " + n14 + ";");
                    break;
                }
                case 15: {
                    this.p("r" + n6 + " = " + n14 + " << 16;");
                    break;
                }
                case 16: {
                    throw new Compiler$Exn("TLB/Exception support not implemented");
                }
                case 17: {
                    switch (n5) {
                        case 0: {
                            this.p("r" + n6 + " = f" + n8 + ";");
                            break Label_7662;
                        }
                        case 2: {
                            if (n9 != 31) {
                                throw new Compiler$Exn("FCR " + n9 + " unavailable");
                            }
                            this.p("r" + n6 + " = fcsr;");
                            break Label_7662;
                        }
                        case 4: {
                            this.p("f" + n8 + " = r" + n6 + ";");
                            break Label_7662;
                        }
                        case 6: {
                            if (n9 != 31) {
                                throw new Compiler$Exn("FCR " + n9 + " unavailable");
                            }
                            this.p("fcsr = r" + n6 + ";");
                            break Label_7662;
                        }
                        case 8: {
                            this.p("if(((fcsr&0x800000)!=0) == (" + (n2 >>> 16 & 0x1) + "!=0)) {");
                            ++this.indent;
                            this.emitInstruction(-1, n3, -1);
                            this.branch(n, n + n16 * 4 + 4);
                            --this.indent;
                            this.p("}");
                            break Label_7662;
                        }
                        case 16: {
                            switch (n12) {
                                case 0: {
                                    this.p(setFloat(n11, getFloat(n9) + "+" + getFloat(n7)));
                                    break Label_7662;
                                }
                                case 1: {
                                    this.p(setFloat(n11, getFloat(n9) + "-" + getFloat(n7)));
                                    break Label_7662;
                                }
                                case 2: {
                                    this.p(setFloat(n11, getFloat(n9) + "*" + getFloat(n7)));
                                    break Label_7662;
                                }
                                case 3: {
                                    this.p(setFloat(n11, getFloat(n9) + "/" + getFloat(n7)));
                                    break Label_7662;
                                }
                                case 5: {
                                    this.p(setFloat(n11, "Math.abs(" + getFloat(n9) + ")"));
                                    break Label_7662;
                                }
                                case 6: {
                                    this.p("f" + n11 + " = f" + n9 + "; // MOV.S");
                                    break Label_7662;
                                }
                                case 7: {
                                    this.p(setFloat(n11, "-" + getFloat(n9)));
                                    break Label_7662;
                                }
                                case 33: {
                                    this.p(setDouble(n11, "(float)" + getFloat(n9)));
                                    break Label_7662;
                                }
                                case 36: {
                                    this.p("switch(fcsr & 3) {");
                                    ++this.indent;
                                    this.p("case 0: f" + n11 + " = (int)Math.floor(" + getFloat(n9) + "+0.5); break; // Round to nearest");
                                    this.p("case 1: f" + n11 + " = (int)" + getFloat(n9) + "; break; // Round towards zero");
                                    this.p("case 2: f" + n11 + " = (int)Math.ceil(" + getFloat(n9) + "); break; // Round towards plus infinity");
                                    this.p("case 3: f" + n11 + " = (int)Math.floor(" + getFloat(n9) + "); break; // Round towards minus infinity");
                                    --this.indent;
                                    this.p("}");
                                    break Label_7662;
                                }
                                case 50: {
                                    this.p("fcsr = (fcsr&~0x800000) | ((" + getFloat(n9) + "==" + getFloat(n7) + ") ? 0x800000 : 0x000000);");
                                    break Label_7662;
                                }
                                case 60: {
                                    this.p("fcsr = (fcsr&~0x800000) | ((" + getFloat(n9) + "<" + getFloat(n7) + ") ? 0x800000 : 0x000000);");
                                    break Label_7662;
                                }
                                case 62: {
                                    this.p("fcsr = (fcsr&~0x800000) | ((" + getFloat(n9) + "<=" + getFloat(n7) + ") ? 0x800000 : 0x000000);");
                                    break Label_7662;
                                }
                                default: {
                                    throw new Compiler$Exn("Invalid Instruction 17/" + n5 + "/" + n12);
                                }
                            }
                            break;
                        }
                        case 17: {
                            switch (n12) {
                                case 0: {
                                    this.p(setDouble(n11, getDouble(n9) + "+" + getDouble(n7)));
                                    break Label_7662;
                                }
                                case 1: {
                                    this.p(setDouble(n11, getDouble(n9) + "-" + getDouble(n7)));
                                    break Label_7662;
                                }
                                case 2: {
                                    this.p(setDouble(n11, getDouble(n9) + "*" + getDouble(n7)));
                                    break Label_7662;
                                }
                                case 3: {
                                    this.p(setDouble(n11, getDouble(n9) + "/" + getDouble(n7)));
                                    break Label_7662;
                                }
                                case 5: {
                                    this.p(setDouble(n11, "Math.abs(" + getDouble(n9) + ")"));
                                    break Label_7662;
                                }
                                case 6: {
                                    this.p("f" + n11 + " = f" + n9 + ";");
                                    this.p("f" + (n11 + 1) + " = f" + (n9 + 1) + ";");
                                    break Label_7662;
                                }
                                case 7: {
                                    this.p(setDouble(n11, "-" + getDouble(n9)));
                                    break Label_7662;
                                }
                                case 32: {
                                    this.p(setFloat(n11, "(float)" + getDouble(n9)));
                                    break Label_7662;
                                }
                                case 36: {
                                    this.p("switch(fcsr & 3) {");
                                    ++this.indent;
                                    this.p("case 0: f" + n11 + " = (int)Math.floor(" + getDouble(n9) + "+0.5); break; // Round to nearest");
                                    this.p("case 1: f" + n11 + " = (int)" + getDouble(n9) + "; break; // Round towards zero");
                                    this.p("case 2: f" + n11 + " = (int)Math.ceil(" + getDouble(n9) + "); break; // Round towards plus infinity");
                                    this.p("case 3: f" + n11 + " = (int)Math.floor(" + getDouble(n9) + "); break; // Round towards minus infinity");
                                    --this.indent;
                                    this.p("}");
                                    break Label_7662;
                                }
                                case 50: {
                                    this.p("fcsr = (fcsr&~0x800000) | ((" + getDouble(n9) + "==" + getDouble(n7) + ") ? 0x800000 : 0x000000);");
                                    break Label_7662;
                                }
                                case 60: {
                                    this.p("fcsr = (fcsr&~0x800000) | ((" + getDouble(n9) + "<" + getDouble(n7) + ") ? 0x800000 : 0x000000);");
                                    break Label_7662;
                                }
                                case 62: {
                                    this.p("fcsr = (fcsr&~0x800000) | ((" + getDouble(n9) + "<=" + getDouble(n7) + ") ? 0x800000 : 0x000000);");
                                    break Label_7662;
                                }
                                default: {
                                    throw new Compiler$Exn("Invalid Instruction 17/" + n5 + "/" + n12);
                                }
                            }
                            break;
                        }
                        case 20: {
                            switch (n12) {
                                case 32: {
                                    this.p(" // CVS.S.W");
                                    this.p(setFloat(n11, "((float)f" + n9 + ")"));
                                    break Label_7662;
                                }
                                case 33: {
                                    this.p(setDouble(n11, "((double)f" + n9 + ")"));
                                    break Label_7662;
                                }
                                default: {
                                    throw new Compiler$Exn("Invalid Instruction 17/" + n5 + "/" + n12);
                                }
                            }
                            break;
                        }
                        default: {
                            throw new Compiler$Exn("Invalid Instruction 17/" + n5);
                        }
                    }
                    break;
                }
                case 18:
                case 19: {
                    throw new Compiler$Exn("coprocessor 2 and 3 instructions not available");
                }
                case 32: {
                    if (this.runtimeStats) {
                        this.p("inc(\"LB\");");
                    }
                    this.p("addr=r" + n5 + "+" + n15 + ";");
                    this.memRead("addr", "tmp");
                    this.p("tmp = (tmp>>>(((~addr)&3)<<3)) & 0xff;");
                    this.p("if((tmp&0x80)!=0) tmp |= 0xffffff00; /* sign extend */");
                    this.p("r" + n6 + " = tmp;");
                    break;
                }
                case 33: {
                    if (this.runtimeStats) {
                        this.p("inc(\"LH\");");
                    }
                    this.p("addr=r" + n5 + "+" + n15 + ";");
                    this.memRead("addr", "tmp");
                    this.p("tmp = (tmp>>>(((~addr)&2)<<3)) & 0xffff;");
                    this.p("if((tmp&0x8000)!=0) tmp |= 0xffff0000; /* sign extend */");
                    this.p("r" + n6 + " = tmp;");
                    break;
                }
                case 34: {
                    this.p("addr=r" + n5 + "+" + n15 + ";");
                    this.memRead("addr", "tmp");
                    this.p("r" + n6 + " = (r" + n6 + "&(0x00ffffff>>>(((~addr)&3)<<3)))|(tmp<<((addr&3)<<3));");
                    break;
                }
                case 35: {
                    if (this.runtimeStats) {
                        this.p("inc(\"LW\");");
                    }
                    this.memRead("r" + n5 + "+" + n15, "r" + n6);
                    break;
                }
                case 36: {
                    this.p("addr=r" + n5 + "+" + n15 + ";");
                    this.memRead("addr", "tmp");
                    this.p("tmp = (tmp>>>(((~addr)&3)<<3)) & 0xff;");
                    this.p("r" + n6 + " = tmp;");
                    break;
                }
                case 37: {
                    this.p("addr=r" + n5 + "+" + n15 + ";");
                    this.memRead("addr", "tmp");
                    this.p("tmp = (tmp>>>(((~addr)&2)<<3)) & 0xffff;");
                    this.p("r" + n6 + " = tmp;");
                    break;
                }
                case 38: {
                    this.p("addr=r" + n5 + "+" + n15 + ";");
                    this.memRead("addr", "tmp");
                    this.p("r" + n6 + " = (r" + n6 + "&(0xffffff00<<((addr&3)<<3)))|(tmp>>>(((~addr)&3)<<3));");
                    break;
                }
                case 40: {
                    if (this.runtimeStats) {
                        this.p("inc(\"SB\");");
                    }
                    this.p("addr=r" + n5 + "+" + n15 + ";");
                    this.memRead("addr", "tmp");
                    this.p("tmp = (tmp&~(0xff000000>>>((addr&3)<<3)))|((r" + n6 + "&0xff)<<(((~addr)&3)<<3));");
                    this.memWrite("addr", "tmp");
                    break;
                }
                case 41: {
                    if (this.runtimeStats) {
                        this.p("inc(\"SH\");");
                    }
                    this.p("addr=r" + n5 + "+" + n15 + ";");
                    this.memRead("addr", "tmp");
                    this.p("tmp = (tmp&(0xffff<<((addr&2)<<3)))|((r" + n6 + "&0xffff)<<(((~addr)&2)<<3));");
                    this.memWrite("addr", "tmp");
                    break;
                }
                case 42: {
                    this.p(" // SWL");
                    this.p("addr=r" + n5 + "+" + n15 + ";");
                    this.memRead("addr", "tmp");
                    this.p("tmp = (tmp&(0xffffff00<<(((~addr)&3)<<3)))|(r" + n6 + ">>>((addr&3)<<3));");
                    this.memWrite("addr", "tmp");
                    break;
                }
                case 43: {
                    if (this.runtimeStats) {
                        this.p("inc(\"SW\");");
                    }
                    this.memWrite("r" + n5 + "+" + n15, "r" + n6);
                    break;
                }
                case 46: {
                    this.p(" // SWR");
                    this.p("addr=r" + n5 + "+" + n15 + ";");
                    this.memRead("addr", "tmp");
                    this.p("tmp = (tmp&(0x00ffffff>>>((addr&3)<<3)))|(r" + n6 + "<<(((~addr)&3)<<3));");
                    this.memWrite("addr", "tmp");
                    break;
                }
                case 48: {
                    this.memRead("r" + n5 + "+" + n15, "r" + n6);
                    break;
                }
                case 49: {
                    this.memRead("r" + n5 + "+" + n15, "f" + n6);
                    break;
                }
                case 56: {
                    this.memWrite("r" + n5 + "+" + n15, "r" + n6);
                    this.p("r" + n6 + "=1;");
                    break;
                }
                case 57: {
                    this.memWrite("r" + n5 + "+" + n15, "f" + n6);
                    break;
                }
                default: {
                    throw new Compiler$Exn("Invalid Instruction: " + n4 + " at " + Compiler.toHex(n));
                }
            }
        }
    }
    
    private void memWrite(final String s, final String s2) {
        if (this.nullPointerCheck) {
            this.p("nullPointerCheck(" + s + ");");
        }
        if (this.onePage) {
            this.p("page[(" + s + ")>>>2] = " + s2 + ";");
        }
        else if (this.fastMem) {
            this.p("writePages[(" + s + ")>>>" + this.pageShift + "][((" + s + ")>>>2)&" + Compiler.toHex((this.pageSize >> 2) - 1) + "] = " + s2 + ";");
        }
        else {
            this.p("unsafeMemWrite(" + s + "," + s2 + ");");
        }
    }
    
    private void memRead(final String s, final String s2) {
        if (this.nullPointerCheck) {
            this.p("nullPointerCheck(" + s + ");");
        }
        if (this.onePage) {
            this.p(s2 + "= page[(" + s + ")>>>2];");
        }
        else if (this.fastMem) {
            this.p(s2 + " = readPages[(" + s + ")>>>" + this.pageShift + "][((" + s + ")>>>2)&" + Compiler.toHex((this.pageSize >> 2) - 1) + "];");
        }
        else {
            this.p(s2 + " = unsafeMemRead(" + s + ");");
        }
    }
    
    private static String getFloat(final int n) {
        return "(Float.intBitsToFloat(f" + n + "))";
    }
    
    private static String getDouble(final int n) {
        return "(Double.longBitsToDouble(((f" + (n + 1) + "&0xffffffffL) << 32) | (f" + n + "&0xffffffffL)))";
    }
    
    private static String setFloat(final int n, final String s) {
        return "f" + n + "=Float.floatToRawIntBits(" + s + ");";
    }
    
    private static String setDouble(final int n, final String s) {
        return "{ long l = Double.doubleToLongBits(" + s + "); " + "f" + (n + 1) + " = (int)(l >>> 32); f" + n + " = (int)l; }";
    }
    
    static {
        JavaSourceCompiler.indents = new String[16];
        String string = "";
        for (int i = 0; i < JavaSourceCompiler.indents.length; ++i, string += "    ") {
            JavaSourceCompiler.indents[i] = string;
        }
    }
}
