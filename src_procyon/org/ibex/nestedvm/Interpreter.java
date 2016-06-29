package org.ibex.nestedvm;

import java.util.*;
import org.ibex.nestedvm.util.*;
import java.io.*;

public class Interpreter extends UnixRuntime implements Cloneable
{
    private int[] registers;
    private int hi;
    private int lo;
    private int[] fpregs;
    private int fcsr;
    private int pc;
    public String image;
    private ELF$Symtab symtab;
    private int gp;
    private ELF$Symbol userInfo;
    private int entryPoint;
    private int heapStart;
    private HashMap sourceLineCache;
    
    private final void setFC(final boolean b) {
        this.fcsr = ((this.fcsr & 0xFF7FFFFF) | (b ? 8388608 : 0));
    }
    
    private final int roundingMode() {
        return this.fcsr & 0x3;
    }
    
    private final double getDouble(final int n) {
        return Double.longBitsToDouble((this.fpregs[n + 1] & 0xFFFFFFFFL) << 32 | (this.fpregs[n] & 0xFFFFFFFFL));
    }
    
    private final void setDouble(final int n, final double n2) {
        final long doubleToLongBits = Double.doubleToLongBits(n2);
        this.fpregs[n + 1] = (int)(doubleToLongBits >>> 32);
        this.fpregs[n] = (int)doubleToLongBits;
    }
    
    private final float getFloat(final int n) {
        return Float.intBitsToFloat(this.fpregs[n]);
    }
    
    private final void setFloat(final int n, final float n2) {
        this.fpregs[n] = Float.floatToRawIntBits(n2);
    }
    
    protected void _execute() {
        try {
            this.runSome();
        }
        catch (Runtime$ExecutionException ex) {
            ex.setLocation(Runtime.toHex(this.pc) + ": " + this.sourceLine(this.pc));
            throw ex;
        }
    }
    
    protected Object clone() {
        final Interpreter interpreter = (Interpreter)super.clone();
        interpreter.registers = this.registers.clone();
        interpreter.fpregs = this.fpregs.clone();
        return interpreter;
    }
    
    private final int runSome() {
        final int n = 1 << this.pageShift >> 2;
        final int[] registers = this.registers;
        final int[] fpregs = this.fpregs;
        int pc = this.pc;
        int pc2 = pc + 4;
        Label_5492: {
            try {
                while (true) {
                    int memRead;
                    try {
                        memRead = this.readPages[pc >>> this.pageShift][pc >>> 2 & n - 1];
                    }
                    catch (RuntimeException ex2) {
                        if (pc == -559038737) {
                            throw new Error("fell off cpu: r2: " + registers[2]);
                        }
                        memRead = this.memRead(pc);
                    }
                    final int n2 = memRead >>> 26 & 0xFF;
                    final int n3 = memRead >>> 21 & 0x1F;
                    final int n4 = memRead >>> 16 & 0x1F;
                    final int n5 = memRead >>> 16 & 0x1F;
                    final int n6 = memRead >>> 11 & 0x1F;
                    final int n7 = memRead >>> 11 & 0x1F;
                    final int n8 = memRead >>> 6 & 0x1F;
                    final int n9 = memRead >>> 6 & 0x1F;
                    final int n10 = memRead & 0x3F;
                    final int n11 = memRead & 0x3FFFFFF;
                    final int n12 = memRead & 0xFFFF;
                    final int n14;
                    final int n13 = n14 = memRead << 16 >> 16;
                    registers[0] = 0;
                    Label_5465: {
                        switch (n2) {
                            case 0: {
                                switch (n10) {
                                    case 0: {
                                        if (memRead == 0) {
                                            break Label_5465;
                                        }
                                        registers[n6] = registers[n4] << n8;
                                        break Label_5465;
                                    }
                                    case 2: {
                                        registers[n6] = registers[n4] >>> n8;
                                        break Label_5465;
                                    }
                                    case 3: {
                                        registers[n6] = registers[n4] >> n8;
                                        break Label_5465;
                                    }
                                    case 4: {
                                        registers[n6] = registers[n4] << (registers[n3] & 0x1F);
                                        break Label_5465;
                                    }
                                    case 6: {
                                        registers[n6] = registers[n4] >>> (registers[n3] & 0x1F);
                                        break Label_5465;
                                    }
                                    case 7: {
                                        registers[n6] = registers[n4] >> (registers[n3] & 0x1F);
                                        break Label_5465;
                                    }
                                    case 8: {
                                        final int n15 = registers[n3];
                                        pc += 4;
                                        pc2 = n15;
                                        continue;
                                    }
                                    case 9: {
                                        final int n16 = registers[n3];
                                        pc += 4;
                                        registers[n6] = pc + 4;
                                        pc2 = n16;
                                        continue;
                                    }
                                    case 12: {
                                        this.pc = pc;
                                        registers[2] = this.syscall(registers[2], registers[4], registers[5], registers[6], registers[7], registers[8], registers[9]);
                                        if (this.state != 0) {
                                            this.pc = pc2;
                                            break Label_5492;
                                        }
                                        break Label_5465;
                                    }
                                    case 13: {
                                        throw new Runtime$ExecutionException("Break");
                                    }
                                    case 16: {
                                        registers[n6] = this.hi;
                                        break Label_5465;
                                    }
                                    case 17: {
                                        this.hi = registers[n3];
                                        break Label_5465;
                                    }
                                    case 18: {
                                        registers[n6] = this.lo;
                                        break Label_5465;
                                    }
                                    case 19: {
                                        this.lo = registers[n3];
                                        break Label_5465;
                                    }
                                    case 24: {
                                        final long n17 = registers[n3] * registers[n4];
                                        this.hi = (int)(n17 >>> 32);
                                        this.lo = (int)n17;
                                        break Label_5465;
                                    }
                                    case 25: {
                                        final long n18 = (registers[n3] & 0xFFFFFFFFL) * (registers[n4] & 0xFFFFFFFFL);
                                        this.hi = (int)(n18 >>> 32);
                                        this.lo = (int)n18;
                                        break Label_5465;
                                    }
                                    case 26: {
                                        this.hi = registers[n3] % registers[n4];
                                        this.lo = registers[n3] / registers[n4];
                                        break Label_5465;
                                    }
                                    case 27: {
                                        if (n4 != 0) {
                                            this.hi = (int)((registers[n3] & 0xFFFFFFFFL) % (registers[n4] & 0xFFFFFFFFL));
                                            this.lo = (int)((registers[n3] & 0xFFFFFFFFL) / (registers[n4] & 0xFFFFFFFFL));
                                            break Label_5465;
                                        }
                                        break Label_5465;
                                    }
                                    case 32: {
                                        throw new Runtime$ExecutionException("ADD (add with oveflow trap) not suported");
                                    }
                                    case 33: {
                                        registers[n6] = registers[n3] + registers[n4];
                                        break Label_5465;
                                    }
                                    case 34: {
                                        throw new Runtime$ExecutionException("SUB (sub with oveflow trap) not suported");
                                    }
                                    case 35: {
                                        registers[n6] = registers[n3] - registers[n4];
                                        break Label_5465;
                                    }
                                    case 36: {
                                        registers[n6] = (registers[n3] & registers[n4]);
                                        break Label_5465;
                                    }
                                    case 37: {
                                        registers[n6] = (registers[n3] | registers[n4]);
                                        break Label_5465;
                                    }
                                    case 38: {
                                        registers[n6] = (registers[n3] ^ registers[n4]);
                                        break Label_5465;
                                    }
                                    case 39: {
                                        registers[n6] = ~(registers[n3] | registers[n4]);
                                        break Label_5465;
                                    }
                                    case 42: {
                                        registers[n6] = ((registers[n3] < registers[n4]) ? 1 : 0);
                                        break Label_5465;
                                    }
                                    case 43: {
                                        registers[n6] = (((registers[n3] & 0xFFFFFFFFL) < (registers[n4] & 0xFFFFFFFFL)) ? 1 : 0);
                                        break Label_5465;
                                    }
                                    default: {
                                        throw new Runtime$ExecutionException("Illegal instruction 0/" + n10);
                                    }
                                }
                                break;
                            }
                            case 1: {
                                switch (n4) {
                                    case 0: {
                                        if (registers[n3] < 0) {
                                            pc += 4;
                                            pc2 = pc + n14 * 4;
                                            continue;
                                        }
                                        break Label_5465;
                                    }
                                    case 1: {
                                        if (registers[n3] >= 0) {
                                            pc += 4;
                                            pc2 = pc + n14 * 4;
                                            continue;
                                        }
                                        break Label_5465;
                                    }
                                    case 16: {
                                        if (registers[n3] < 0) {
                                            pc += 4;
                                            registers[31] = pc + 4;
                                            pc2 = pc + n14 * 4;
                                            continue;
                                        }
                                        break Label_5465;
                                    }
                                    case 17: {
                                        if (registers[n3] >= 0) {
                                            pc += 4;
                                            registers[31] = pc + 4;
                                            pc2 = pc + n14 * 4;
                                            continue;
                                        }
                                        break Label_5465;
                                    }
                                    default: {
                                        throw new Runtime$ExecutionException("Illegal Instruction");
                                    }
                                }
                                break;
                            }
                            case 2: {
                                final int n19 = (pc & 0xF0000000) | n11 << 2;
                                pc += 4;
                                pc2 = n19;
                                continue;
                            }
                            case 3: {
                                final int n20 = (pc & 0xF0000000) | n11 << 2;
                                pc += 4;
                                registers[31] = pc + 4;
                                pc2 = n20;
                                continue;
                            }
                            case 4: {
                                if (registers[n3] == registers[n4]) {
                                    pc += 4;
                                    pc2 = pc + n14 * 4;
                                    continue;
                                }
                                break;
                            }
                            case 5: {
                                if (registers[n3] != registers[n4]) {
                                    pc += 4;
                                    pc2 = pc + n14 * 4;
                                    continue;
                                }
                                break;
                            }
                            case 6: {
                                if (registers[n3] <= 0) {
                                    pc += 4;
                                    pc2 = pc + n14 * 4;
                                    continue;
                                }
                                break;
                            }
                            case 7: {
                                if (registers[n3] > 0) {
                                    pc += 4;
                                    pc2 = pc + n14 * 4;
                                    continue;
                                }
                                break;
                            }
                            case 8: {
                                registers[n4] = registers[n3] + n13;
                                break;
                            }
                            case 9: {
                                registers[n4] = registers[n3] + n13;
                                break;
                            }
                            case 10: {
                                registers[n4] = ((registers[n3] < n13) ? 1 : 0);
                                break;
                            }
                            case 11: {
                                registers[n4] = (((registers[n3] & 0xFFFFFFFFL) < (n13 & 0xFFFFFFFFL)) ? 1 : 0);
                                break;
                            }
                            case 12: {
                                registers[n4] = (registers[n3] & n12);
                                break;
                            }
                            case 13: {
                                registers[n4] = (registers[n3] | n12);
                                break;
                            }
                            case 14: {
                                registers[n4] = (registers[n3] ^ n12);
                                break;
                            }
                            case 15: {
                                registers[n4] = n12 << 16;
                                break;
                            }
                            case 16: {
                                throw new Runtime$ExecutionException("TLB/Exception support not implemented");
                            }
                            case 17: {
                                final boolean b = false;
                                final String s = b ? this.sourceLine(pc) : "";
                                final boolean b2 = b && (s.indexOf("dtoa.c:51") >= 0 || s.indexOf("dtoa.c:52") >= 0 || s.indexOf("test.c") >= 0);
                                if (n3 > 8 && b2) {
                                    System.out.println("               FP Op: " + n2 + "/" + n3 + "/" + n10 + " " + s);
                                }
                                if (this.roundingMode() != 0 && n3 != 6 && ((n3 != 16 && n3 != 17) || n10 != 36)) {
                                    throw new Runtime$ExecutionException("Non-cvt.w.z operation attempted with roundingMode != round to nearest");
                                }
                                switch (n3) {
                                    case 0: {
                                        registers[n4] = fpregs[n6];
                                        break Label_5465;
                                    }
                                    case 2: {
                                        if (n7 != 31) {
                                            throw new Runtime$ExecutionException("FCR " + n7 + " unavailable");
                                        }
                                        registers[n4] = this.fcsr;
                                        break Label_5465;
                                    }
                                    case 4: {
                                        fpregs[n6] = registers[n4];
                                        break Label_5465;
                                    }
                                    case 6: {
                                        if (n7 != 31) {
                                            throw new Runtime$ExecutionException("FCR " + n7 + " unavailable");
                                        }
                                        this.fcsr = registers[n4];
                                        break Label_5465;
                                    }
                                    case 8: {
                                        if ((this.fcsr & 0x800000) != 0x0 == ((memRead >>> 16 & 0x1) != 0x0)) {
                                            pc += 4;
                                            pc2 = pc + n14 * 4;
                                            continue;
                                        }
                                        break Label_5465;
                                    }
                                    case 16: {
                                        switch (n10) {
                                            case 0: {
                                                this.setFloat(n9, this.getFloat(n7) + this.getFloat(n5));
                                                break Label_5465;
                                            }
                                            case 1: {
                                                this.setFloat(n9, this.getFloat(n7) - this.getFloat(n5));
                                                break Label_5465;
                                            }
                                            case 2: {
                                                this.setFloat(n9, this.getFloat(n7) * this.getFloat(n5));
                                                break Label_5465;
                                            }
                                            case 3: {
                                                this.setFloat(n9, this.getFloat(n7) / this.getFloat(n5));
                                                break Label_5465;
                                            }
                                            case 5: {
                                                this.setFloat(n9, Math.abs(this.getFloat(n7)));
                                                break Label_5465;
                                            }
                                            case 6: {
                                                fpregs[n9] = fpregs[n7];
                                                break Label_5465;
                                            }
                                            case 7: {
                                                this.setFloat(n9, -this.getFloat(n7));
                                                break Label_5465;
                                            }
                                            case 33: {
                                                this.setDouble(n9, this.getFloat(n7));
                                                break Label_5465;
                                            }
                                            case 36: {
                                                switch (this.roundingMode()) {
                                                    case 0: {
                                                        fpregs[n9] = (int)Math.floor(this.getFloat(n7) + 0.5f);
                                                        break;
                                                    }
                                                    case 1: {
                                                        fpregs[n9] = (int)this.getFloat(n7);
                                                        break;
                                                    }
                                                    case 2: {
                                                        fpregs[n9] = (int)Math.ceil(this.getFloat(n7));
                                                        break;
                                                    }
                                                    case 3: {
                                                        fpregs[n9] = (int)Math.floor(this.getFloat(n7));
                                                        break;
                                                    }
                                                }
                                                break Label_5465;
                                            }
                                            case 50: {
                                                this.setFC(this.getFloat(n7) == this.getFloat(n5));
                                                break Label_5465;
                                            }
                                            case 60: {
                                                this.setFC(this.getFloat(n7) < this.getFloat(n5));
                                                break Label_5465;
                                            }
                                            case 62: {
                                                this.setFC(this.getFloat(n7) <= this.getFloat(n5));
                                                break Label_5465;
                                            }
                                            default: {
                                                throw new Runtime$ExecutionException("Invalid Instruction 17/" + n3 + "/" + n10 + " at " + this.sourceLine(pc));
                                            }
                                        }
                                        break;
                                    }
                                    case 17: {
                                        switch (n10) {
                                            case 0: {
                                                this.setDouble(n9, this.getDouble(n7) + this.getDouble(n5));
                                                break Label_5465;
                                            }
                                            case 1: {
                                                if (b2) {
                                                    System.out.println("f" + n9 + " = f" + n7 + " (" + this.getDouble(n7) + ") - f" + n5 + " (" + this.getDouble(n5) + ")");
                                                }
                                                this.setDouble(n9, this.getDouble(n7) - this.getDouble(n5));
                                                break Label_5465;
                                            }
                                            case 2: {
                                                if (b2) {
                                                    System.out.println("f" + n9 + " = f" + n7 + " (" + this.getDouble(n7) + ") * f" + n5 + " (" + this.getDouble(n5) + ")");
                                                }
                                                this.setDouble(n9, this.getDouble(n7) * this.getDouble(n5));
                                                if (b2) {
                                                    System.out.println("f" + n9 + " = " + this.getDouble(n9));
                                                    break Label_5465;
                                                }
                                                break Label_5465;
                                            }
                                            case 3: {
                                                this.setDouble(n9, this.getDouble(n7) / this.getDouble(n5));
                                                break Label_5465;
                                            }
                                            case 5: {
                                                this.setDouble(n9, Math.abs(this.getDouble(n7)));
                                                break Label_5465;
                                            }
                                            case 6: {
                                                fpregs[n9] = fpregs[n7];
                                                fpregs[n9 + 1] = fpregs[n7 + 1];
                                                break Label_5465;
                                            }
                                            case 7: {
                                                this.setDouble(n9, -this.getDouble(n7));
                                                break Label_5465;
                                            }
                                            case 32: {
                                                this.setFloat(n9, (float)this.getDouble(n7));
                                                break Label_5465;
                                            }
                                            case 36: {
                                                if (b2) {
                                                    System.out.println("CVT.W.D rm: " + this.roundingMode() + " f" + n7 + ":" + this.getDouble(n7));
                                                }
                                                switch (this.roundingMode()) {
                                                    case 0: {
                                                        fpregs[n9] = (int)Math.floor(this.getDouble(n7) + 0.5);
                                                        break;
                                                    }
                                                    case 1: {
                                                        fpregs[n9] = (int)this.getDouble(n7);
                                                        break;
                                                    }
                                                    case 2: {
                                                        fpregs[n9] = (int)Math.ceil(this.getDouble(n7));
                                                        break;
                                                    }
                                                    case 3: {
                                                        fpregs[n9] = (int)Math.floor(this.getDouble(n7));
                                                        break;
                                                    }
                                                }
                                                if (b2) {
                                                    System.out.println("CVT.W.D: f" + n9 + ":" + fpregs[n9]);
                                                    break Label_5465;
                                                }
                                                break Label_5465;
                                            }
                                            case 50: {
                                                this.setFC(this.getDouble(n7) == this.getDouble(n5));
                                                break Label_5465;
                                            }
                                            case 60: {
                                                this.setFC(this.getDouble(n7) < this.getDouble(n5));
                                                break Label_5465;
                                            }
                                            case 62: {
                                                this.setFC(this.getDouble(n7) <= this.getDouble(n5));
                                                break Label_5465;
                                            }
                                            default: {
                                                throw new Runtime$ExecutionException("Invalid Instruction 17/" + n3 + "/" + n10 + " at " + this.sourceLine(pc));
                                            }
                                        }
                                        break;
                                    }
                                    case 20: {
                                        switch (n10) {
                                            case 32: {
                                                this.setFloat(n9, fpregs[n7]);
                                                break Label_5465;
                                            }
                                            case 33: {
                                                this.setDouble(n9, fpregs[n7]);
                                                break Label_5465;
                                            }
                                            default: {
                                                throw new Runtime$ExecutionException("Invalid Instruction 17/" + n3 + "/" + n10 + " at " + this.sourceLine(pc));
                                            }
                                        }
                                        break;
                                    }
                                    default: {
                                        throw new Runtime$ExecutionException("Invalid Instruction 17/" + n3);
                                    }
                                }
                                break;
                            }
                            case 18:
                            case 19: {
                                throw new Runtime$ExecutionException("No coprocessor installed");
                            }
                            case 32: {
                                final int n21 = registers[n3] + n13;
                                int memRead2;
                                try {
                                    memRead2 = this.readPages[n21 >>> this.pageShift][n21 >>> 2 & n - 1];
                                }
                                catch (RuntimeException ex3) {
                                    memRead2 = this.memRead(n21 & 0xFFFFFFFC);
                                }
                                switch (n21 & 0x3) {
                                    case 0: {
                                        memRead2 = (memRead2 >>> 24 & 0xFF);
                                        break;
                                    }
                                    case 1: {
                                        memRead2 = (memRead2 >>> 16 & 0xFF);
                                        break;
                                    }
                                    case 2: {
                                        memRead2 = (memRead2 >>> 8 & 0xFF);
                                        break;
                                    }
                                    case 3: {
                                        memRead2 = (memRead2 >>> 0 & 0xFF);
                                        break;
                                    }
                                }
                                if ((memRead2 & 0x80) != 0x0) {
                                    memRead2 |= 0xFFFFFF00;
                                }
                                registers[n4] = memRead2;
                                break;
                            }
                            case 33: {
                                final int n22 = registers[n3] + n13;
                                int memRead3;
                                try {
                                    memRead3 = this.readPages[n22 >>> this.pageShift][n22 >>> 2 & n - 1];
                                }
                                catch (RuntimeException ex4) {
                                    memRead3 = this.memRead(n22 & 0xFFFFFFFC);
                                }
                                int n23 = 0;
                                switch (n22 & 0x3) {
                                    case 0: {
                                        n23 = (memRead3 >>> 16 & 0xFFFF);
                                        break;
                                    }
                                    case 2: {
                                        n23 = (memRead3 >>> 0 & 0xFFFF);
                                        break;
                                    }
                                    default: {
                                        throw new Runtime$ReadFaultException(n22);
                                    }
                                }
                                if ((n23 & 0x8000) != 0x0) {
                                    n23 |= 0xFFFF0000;
                                }
                                registers[n4] = n23;
                                break;
                            }
                            case 34: {
                                final int n24 = registers[n3] + n13;
                                int memRead4;
                                try {
                                    memRead4 = this.readPages[n24 >>> this.pageShift][n24 >>> 2 & n - 1];
                                }
                                catch (RuntimeException ex5) {
                                    memRead4 = this.memRead(n24 & 0xFFFFFFFC);
                                }
                                switch (n24 & 0x3) {
                                    case 0: {
                                        registers[n4] = ((registers[n4] & 0x0) | memRead4 << 0);
                                        break;
                                    }
                                    case 1: {
                                        registers[n4] = ((registers[n4] & 0xFF) | memRead4 << 8);
                                        break;
                                    }
                                    case 2: {
                                        registers[n4] = ((registers[n4] & 0xFFFF) | memRead4 << 16);
                                        break;
                                    }
                                    case 3: {
                                        registers[n4] = ((registers[n4] & 0xFFFFFF) | memRead4 << 24);
                                        break;
                                    }
                                }
                                break;
                            }
                            case 35: {
                                final int n25 = registers[n3] + n13;
                                try {
                                    registers[n4] = this.readPages[n25 >>> this.pageShift][n25 >>> 2 & n - 1];
                                }
                                catch (RuntimeException ex6) {
                                    registers[n4] = this.memRead(n25);
                                }
                                break;
                            }
                            case 36: {
                                final int n26 = registers[n3] + n13;
                                int memRead5;
                                try {
                                    memRead5 = this.readPages[n26 >>> this.pageShift][n26 >>> 2 & n - 1];
                                }
                                catch (RuntimeException ex7) {
                                    memRead5 = this.memRead(n26);
                                }
                                switch (n26 & 0x3) {
                                    case 0: {
                                        registers[n4] = (memRead5 >>> 24 & 0xFF);
                                        break;
                                    }
                                    case 1: {
                                        registers[n4] = (memRead5 >>> 16 & 0xFF);
                                        break;
                                    }
                                    case 2: {
                                        registers[n4] = (memRead5 >>> 8 & 0xFF);
                                        break;
                                    }
                                    case 3: {
                                        registers[n4] = (memRead5 >>> 0 & 0xFF);
                                        break;
                                    }
                                }
                                break;
                            }
                            case 37: {
                                final int n27 = registers[n3] + n13;
                                int memRead6;
                                try {
                                    memRead6 = this.readPages[n27 >>> this.pageShift][n27 >>> 2 & n - 1];
                                }
                                catch (RuntimeException ex8) {
                                    memRead6 = this.memRead(n27 & 0xFFFFFFFC);
                                }
                                switch (n27 & 0x3) {
                                    case 0: {
                                        registers[n4] = (memRead6 >>> 16 & 0xFFFF);
                                        break Label_5465;
                                    }
                                    case 2: {
                                        registers[n4] = (memRead6 >>> 0 & 0xFFFF);
                                        break Label_5465;
                                    }
                                    default: {
                                        throw new Runtime$ReadFaultException(n27);
                                    }
                                }
                                break;
                            }
                            case 38: {
                                final int n28 = registers[n3] + n13;
                                int memRead7;
                                try {
                                    memRead7 = this.readPages[n28 >>> this.pageShift][n28 >>> 2 & n - 1];
                                }
                                catch (RuntimeException ex9) {
                                    memRead7 = this.memRead(n28 & 0xFFFFFFFC);
                                }
                                switch (n28 & 0x3) {
                                    case 0: {
                                        registers[n4] = ((registers[n4] & 0xFFFFFF00) | memRead7 >>> 24);
                                        break;
                                    }
                                    case 1: {
                                        registers[n4] = ((registers[n4] & 0xFFFF0000) | memRead7 >>> 16);
                                        break;
                                    }
                                    case 2: {
                                        registers[n4] = ((registers[n4] & 0xFF000000) | memRead7 >>> 8);
                                        break;
                                    }
                                    case 3: {
                                        registers[n4] = ((registers[n4] & 0x0) | memRead7 >>> 0);
                                        break;
                                    }
                                }
                                break;
                            }
                            case 40: {
                                final int n29 = registers[n3] + n13;
                                int memRead8;
                                try {
                                    memRead8 = this.readPages[n29 >>> this.pageShift][n29 >>> 2 & n - 1];
                                }
                                catch (RuntimeException ex10) {
                                    memRead8 = this.memRead(n29 & 0xFFFFFFFC);
                                }
                                switch (n29 & 0x3) {
                                    case 0: {
                                        memRead8 = ((memRead8 & 0xFFFFFF) | (registers[n4] & 0xFF) << 24);
                                        break;
                                    }
                                    case 1: {
                                        memRead8 = ((memRead8 & 0xFF00FFFF) | (registers[n4] & 0xFF) << 16);
                                        break;
                                    }
                                    case 2: {
                                        memRead8 = ((memRead8 & 0xFFFF00FF) | (registers[n4] & 0xFF) << 8);
                                        break;
                                    }
                                    case 3: {
                                        memRead8 = ((memRead8 & 0xFFFFFF00) | (registers[n4] & 0xFF) << 0);
                                        break;
                                    }
                                }
                                try {
                                    this.writePages[n29 >>> this.pageShift][n29 >>> 2 & n - 1] = memRead8;
                                }
                                catch (RuntimeException ex11) {
                                    this.memWrite(n29 & 0xFFFFFFFC, memRead8);
                                }
                                break;
                            }
                            case 41: {
                                final int n30 = registers[n3] + n13;
                                int memRead9;
                                try {
                                    memRead9 = this.readPages[n30 >>> this.pageShift][n30 >>> 2 & n - 1];
                                }
                                catch (RuntimeException ex12) {
                                    memRead9 = this.memRead(n30 & 0xFFFFFFFC);
                                }
                                int n31 = 0;
                                switch (n30 & 0x3) {
                                    case 0: {
                                        n31 = ((memRead9 & 0xFFFF) | (registers[n4] & 0xFFFF) << 16);
                                        break;
                                    }
                                    case 2: {
                                        n31 = ((memRead9 & 0xFFFF0000) | (registers[n4] & 0xFFFF) << 0);
                                        break;
                                    }
                                    default: {
                                        throw new Runtime$WriteFaultException(n30);
                                    }
                                }
                                try {
                                    this.writePages[n30 >>> this.pageShift][n30 >>> 2 & n - 1] = n31;
                                }
                                catch (RuntimeException ex13) {
                                    this.memWrite(n30 & 0xFFFFFFFC, n31);
                                }
                                break;
                            }
                            case 42: {
                                final int n32 = registers[n3] + n13;
                                int memRead10 = this.memRead(n32 & 0xFFFFFFFC);
                                switch (n32 & 0x3) {
                                    case 0: {
                                        memRead10 = ((memRead10 & 0x0) | registers[n4] >>> 0);
                                        break;
                                    }
                                    case 1: {
                                        memRead10 = ((memRead10 & 0xFF000000) | registers[n4] >>> 8);
                                        break;
                                    }
                                    case 2: {
                                        memRead10 = ((memRead10 & 0xFFFF0000) | registers[n4] >>> 16);
                                        break;
                                    }
                                    case 3: {
                                        memRead10 = ((memRead10 & 0xFFFFFF00) | registers[n4] >>> 24);
                                        break;
                                    }
                                }
                                try {
                                    this.writePages[n32 >>> this.pageShift][n32 >>> 2 & n - 1] = memRead10;
                                }
                                catch (RuntimeException ex14) {
                                    this.memWrite(n32 & 0xFFFFFFFC, memRead10);
                                }
                                break;
                            }
                            case 43: {
                                final int n33 = registers[n3] + n13;
                                try {
                                    this.writePages[n33 >>> this.pageShift][n33 >>> 2 & n - 1] = registers[n4];
                                }
                                catch (RuntimeException ex15) {
                                    this.memWrite(n33 & 0xFFFFFFFC, registers[n4]);
                                }
                                break;
                            }
                            case 46: {
                                final int n34 = registers[n3] + n13;
                                int memRead11 = this.memRead(n34 & 0xFFFFFFFC);
                                switch (n34 & 0x3) {
                                    case 0: {
                                        memRead11 = ((memRead11 & 0xFFFFFF) | registers[n4] << 24);
                                        break;
                                    }
                                    case 1: {
                                        memRead11 = ((memRead11 & 0xFFFF) | registers[n4] << 16);
                                        break;
                                    }
                                    case 2: {
                                        memRead11 = ((memRead11 & 0xFF) | registers[n4] << 8);
                                        break;
                                    }
                                    case 3: {
                                        memRead11 = ((memRead11 & 0x0) | registers[n4] << 0);
                                        break;
                                    }
                                }
                                this.memWrite(n34 & 0xFFFFFFFC, memRead11);
                                break;
                            }
                            case 48: {
                                registers[n4] = this.memRead(registers[n3] + n13);
                                break;
                            }
                            case 49: {
                                fpregs[n4] = this.memRead(registers[n3] + n13);
                                break;
                            }
                            case 56: {
                                this.memWrite(registers[n3] + n13, registers[n4]);
                                registers[n4] = 1;
                                break;
                            }
                            case 57: {
                                this.memWrite(registers[n3] + n13, fpregs[n4]);
                                break;
                            }
                            default: {
                                throw new Runtime$ExecutionException("Invalid Instruction: " + n2);
                            }
                        }
                    }
                    pc = pc2;
                    pc2 = pc + 4;
                }
            }
            catch (Runtime$ExecutionException ex) {
                this.pc = pc;
                throw ex;
            }
        }
        return 0;
    }
    
    public int lookupSymbol(final String s) {
        final ELF$Symbol globalSymbol = this.symtab.getGlobalSymbol(s);
        return (globalSymbol == null) ? -1 : globalSymbol.addr;
    }
    
    protected int gp() {
        return this.gp;
    }
    
    protected int userInfoBae() {
        return (this.userInfo == null) ? 0 : this.userInfo.addr;
    }
    
    protected int userInfoSize() {
        return (this.userInfo == null) ? 0 : this.userInfo.size;
    }
    
    protected int entryPoint() {
        return this.entryPoint;
    }
    
    protected int heapStart() {
        return this.heapStart;
    }
    
    private void loadImage(final Seekable seekable) {
        final ELF elf = new ELF(seekable);
        this.symtab = elf.getSymtab();
        if (elf.header.type != 2) {
            throw new IOException("Binary is not an executable");
        }
        if (elf.header.machine != 8) {
            throw new IOException("Binary is not for the MIPS I Architecture");
        }
        if (elf.ident.data != 2) {
            throw new IOException("Binary is not big endian");
        }
        this.entryPoint = elf.header.entry;
        final ELF$Symtab symtab = elf.getSymtab();
        if (symtab == null) {
            throw new IOException("No symtab in binary (did you strip it?)");
        }
        this.userInfo = symtab.getGlobalSymbol("user_info");
        final ELF$Symbol globalSymbol = symtab.getGlobalSymbol("_gp");
        if (globalSymbol == null) {
            throw new IOException("NO _gp symbol!");
        }
        this.gp = globalSymbol.addr;
        this.entryPoint = elf.header.entry;
        final ELF$PHeader[] pheaders = elf.pheaders;
        int max = 0;
        final int n = 1 << this.pageShift;
        final int n2 = 1 << this.pageShift >> 2;
        for (int i = 0; i < pheaders.length; ++i) {
            final ELF$PHeader elf$PHeader = pheaders[i];
            if (elf$PHeader.type == 1) {
                final int memsz = elf$PHeader.memsz;
                final int filesz = elf$PHeader.filesz;
                if (memsz != 0) {
                    if (memsz < 0) {
                        throw new IOException("pheader size too large");
                    }
                    int vaddr = elf$PHeader.vaddr;
                    if (vaddr == 0) {
                        throw new IOException("pheader vaddr == 0x0");
                    }
                    max = Runtime.max(vaddr + memsz, max);
                    for (int j = 0; j < memsz + n - 1; j += n) {
                        final int n3 = j + vaddr >>> this.pageShift;
                        if (this.readPages[n3] == null) {
                            this.readPages[n3] = new int[n2];
                        }
                        if (elf$PHeader.writable()) {
                            this.writePages[n3] = this.readPages[n3];
                        }
                    }
                    if (filesz != 0) {
                        int k = filesz & 0xFFFFFFFC;
                        final DataInputStream dataInputStream = new DataInputStream(elf$PHeader.getInputStream());
                        do {
                            this.readPages[vaddr >>> this.pageShift][vaddr >>> 2 & n2 - 1] = dataInputStream.readInt();
                            vaddr += 4;
                            k -= 4;
                        } while (k > 0);
                        dataInputStream.close();
                    }
                }
            }
        }
        this.heapStart = (max + n - 1 & ~(n - 1));
    }
    
    protected void setCPUState(final Runtime$CPUState runtime$CPUState) {
        for (int i = 1; i < 32; ++i) {
            this.registers[i] = runtime$CPUState.r[i];
        }
        for (int j = 0; j < 32; ++j) {
            this.fpregs[j] = runtime$CPUState.f[j];
        }
        this.hi = runtime$CPUState.hi;
        this.lo = runtime$CPUState.lo;
        this.fcsr = runtime$CPUState.fcsr;
        this.pc = runtime$CPUState.pc;
    }
    
    protected void getCPUState(final Runtime$CPUState runtime$CPUState) {
        for (int i = 1; i < 32; ++i) {
            runtime$CPUState.r[i] = this.registers[i];
        }
        for (int j = 0; j < 32; ++j) {
            runtime$CPUState.f[j] = this.fpregs[j];
        }
        runtime$CPUState.hi = this.hi;
        runtime$CPUState.lo = this.lo;
        runtime$CPUState.fcsr = this.fcsr;
        runtime$CPUState.pc = this.pc;
    }
    
    public Interpreter(final Seekable seekable) {
        super(4096, 65536);
        this.registers = new int[32];
        this.fpregs = new int[32];
        this.loadImage(seekable);
    }
    
    public Interpreter(final String image) {
        this(new Seekable$File(image, false));
        this.image = image;
    }
    
    public Interpreter(final InputStream inputStream) {
        this(new Seekable$InputStream(inputStream));
    }
    
    public String sourceLine(final int n) {
        final String s = (this.sourceLineCache == null) ? null : this.sourceLineCache.get(new Integer(n));
        if (s != null) {
            return s;
        }
        if (this.image == null) {
            return null;
        }
        try {
            String s2 = new BufferedReader(new InputStreamReader(java.lang.Runtime.getRuntime().exec(new String[] { "mips-unknown-elf-addr2line", "-e", this.image, Runtime.toHex(n) }).getInputStream())).readLine();
            if (s2 == null) {
                return null;
            }
            while (s2.startsWith("../")) {
                s2 = s2.substring(3);
            }
            if (this.sourceLineCache == null) {
                this.sourceLineCache = new HashMap();
            }
            this.sourceLineCache.put(new Integer(n), s2);
            return s2;
        }
        catch (IOException ex) {
            return null;
        }
    }
    
    public static void main(final String[] array) {
        final Interpreter interpreter = new Interpreter(array[0]);
        final java.lang.Runtime runtime = java.lang.Runtime.getRuntime();
        final Interpreter interpreter2 = interpreter;
        interpreter2.getClass();
        runtime.addShutdownHook(new Thread(new Interpreter$DebugShutdownHook(interpreter2)));
        final int run = interpreter.run(array);
        System.err.println("Exit status: " + run);
        System.exit(run);
    }
    
    static int access$000(final Interpreter interpreter) {
        return interpreter.pc;
    }
}
