/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
import java.util.HashMap;
import org.ibex.nestedvm.Interpreter$DebugShutdownHook;
import org.ibex.nestedvm.Runtime$CPUState;
import org.ibex.nestedvm.Runtime$ExecutionException;
import org.ibex.nestedvm.Runtime$ReadFaultException;
import org.ibex.nestedvm.Runtime$WriteFaultException;
import org.ibex.nestedvm.UnixRuntime;
import org.ibex.nestedvm.util.ELF;
import org.ibex.nestedvm.util.ELF$ELFHeader;
import org.ibex.nestedvm.util.ELF$ELFIdent;
import org.ibex.nestedvm.util.ELF$PHeader;
import org.ibex.nestedvm.util.ELF$Symbol;
import org.ibex.nestedvm.util.ELF$Symtab;
import org.ibex.nestedvm.util.Seekable;
import org.ibex.nestedvm.util.Seekable$File;
import org.ibex.nestedvm.util.Seekable$InputStream;

public class Interpreter
extends UnixRuntime
implements Cloneable {
    private int[] registers = new int[32];
    private int hi;
    private int lo;
    private int[] fpregs = new int[32];
    private int fcsr;
    private int pc;
    public String image;
    private ELF$Symtab symtab;
    private int gp;
    private ELF$Symbol userInfo;
    private int entryPoint;
    private int heapStart;
    private HashMap sourceLineCache;

    private final void setFC(boolean bl2) {
        this.fcsr = this.fcsr & -8388609 | (bl2 ? 8388608 : 0);
    }

    private final int roundingMode() {
        return this.fcsr & 3;
    }

    private final double getDouble(int n2) {
        return Double.longBitsToDouble(((long)this.fpregs[n2 + 1] & 0xFFFFFFFFL) << 32 | (long)this.fpregs[n2] & 0xFFFFFFFFL);
    }

    private final void setDouble(int n2, double d2) {
        long l2 = Double.doubleToLongBits(d2);
        this.fpregs[n2 + 1] = (int)(l2 >>> 32);
        this.fpregs[n2] = (int)l2;
    }

    private final float getFloat(int n2) {
        return Float.intBitsToFloat(this.fpregs[n2]);
    }

    private final void setFloat(int n2, float f2) {
        this.fpregs[n2] = Float.floatToRawIntBits(f2);
    }

    @Override
    protected void _execute() {
        try {
            this.runSome();
            return;
        }
        catch (Runtime$ExecutionException var1_1) {
            var1_1.setLocation(new StringBuffer().append(Interpreter.toHex(this.pc)).append(": ").append(this.sourceLine(this.pc)).toString());
            throw var1_1;
        }
    }

    @Override
    protected Object clone() {
        Interpreter interpreter = (Interpreter)super.clone();
        interpreter.registers = (int[])this.registers.clone();
        interpreter.fpregs = (int[])this.fpregs.clone();
        return interpreter;
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    private final int runSome() {
        var1_1 = 1 << this.pageShift >> 2;
        var2_2 = this.registers;
        var3_3 = this.fpregs;
        var4_4 = this.pc;
        var5_5 = var4_4 + 4;
        try {
            block211 : do {
                try {
                    var6_6 = this.readPages[var4_4 >>> this.pageShift][var4_4 >>> 2 & var1_1 - 1];
                }
                catch (RuntimeException var7_9) {
                    if (var4_4 == -559038737) {
                        throw new Error(new StringBuffer().append("fell off cpu: r2: ").append(var2_2[2]).toString());
                    }
                    var6_6 = this.memRead(var4_4);
                }
                var7_8 = var6_6 >>> 26 & 255;
                var8_10 = var6_6 >>> 21 & 31;
                var9_11 = var6_6 >>> 16 & 31;
                var10_12 = var6_6 >>> 16 & 31;
                var11_13 = var6_6 >>> 11 & 31;
                var12_14 = var6_6 >>> 11 & 31;
                var13_15 = var6_6 >>> 6 & 31;
                var14_16 = var6_6 >>> 6 & 31;
                var15_17 = var6_6 & 63;
                var16_18 = var6_6 & 67108863;
                var17_19 = var6_6 & 65535;
                var19_21 = var18_20 = var6_6 << 16 >> 16;
                var2_2[0] = 0;
                block15 : switch (var7_8) {
                    case 0: {
                        switch (var15_17) {
                            case 0: {
                                if (var6_6 == 0) break block15;
                                var2_2[var11_13] = var2_2[var9_11] << var13_15;
                                break block15;
                            }
                            case 2: {
                                var2_2[var11_13] = var2_2[var9_11] >>> var13_15;
                                break block15;
                            }
                            case 3: {
                                var2_2[var11_13] = var2_2[var9_11] >> var13_15;
                                break block15;
                            }
                            case 4: {
                                var2_2[var11_13] = var2_2[var9_11] << (var2_2[var8_10] & 31);
                                break block15;
                            }
                            case 6: {
                                var2_2[var11_13] = var2_2[var9_11] >>> (var2_2[var8_10] & 31);
                                break block15;
                            }
                            case 7: {
                                var2_2[var11_13] = var2_2[var9_11] >> (var2_2[var8_10] & 31);
                                break block15;
                            }
                            case 8: {
                                var20_22 = var2_2[var8_10];
                                var4_4 += 4;
                                var5_5 = var20_22;
                                continue block211;
                            }
                            case 9: {
                                var20_22 = var2_2[var8_10];
                                var2_2[var11_13] = (var4_4 += 4) + 4;
                                var5_5 = var20_22;
                                continue block211;
                            }
                            case 12: {
                                this.pc = var4_4;
                                var2_2[2] = this.syscall(var2_2[2], var2_2[4], var2_2[5], var2_2[6], var2_2[7], var2_2[8], var2_2[9]);
                                if (this.state == 0) break block15;
                                this.pc = var5_5;
                                return 0;
                            }
                            case 13: {
                                throw new Runtime$ExecutionException("Break");
                            }
                            case 16: {
                                var2_2[var11_13] = this.hi;
                                break block15;
                            }
                            case 17: {
                                this.hi = var2_2[var8_10];
                                break block15;
                            }
                            case 18: {
                                var2_2[var11_13] = this.lo;
                                break block15;
                            }
                            case 19: {
                                this.lo = var2_2[var8_10];
                                break block15;
                            }
                            case 24: {
                                var22_24 = (long)var2_2[var8_10] * (long)var2_2[var9_11];
                                this.hi = var22_24 >>> 32;
                                this.lo = var22_24;
                                break block15;
                            }
                            case 25: {
                                var22_25 = ((long)var2_2[var8_10] & 0xFFFFFFFFL) * ((long)var2_2[var9_11] & 0xFFFFFFFFL);
                                this.hi = (int)(var22_25 >>> 32);
                                this.lo = (int)var22_25;
                                break block15;
                            }
                            case 26: {
                                this.hi = var2_2[var8_10] % var2_2[var9_11];
                                this.lo = var2_2[var8_10] / var2_2[var9_11];
                                break block15;
                            }
                            case 27: {
                                if (var9_11 == 0) break block15;
                                this.hi = (int)(((long)var2_2[var8_10] & 0xFFFFFFFFL) % ((long)var2_2[var9_11] & 0xFFFFFFFFL));
                                this.lo = (int)(((long)var2_2[var8_10] & 0xFFFFFFFFL) / ((long)var2_2[var9_11] & 0xFFFFFFFFL));
                                break block15;
                            }
                            case 32: {
                                throw new Runtime$ExecutionException("ADD (add with oveflow trap) not suported");
                            }
                            case 33: {
                                var2_2[var11_13] = var2_2[var8_10] + var2_2[var9_11];
                                break block15;
                            }
                            case 34: {
                                throw new Runtime$ExecutionException("SUB (sub with oveflow trap) not suported");
                            }
                            case 35: {
                                var2_2[var11_13] = var2_2[var8_10] - var2_2[var9_11];
                                break block15;
                            }
                            case 36: {
                                var2_2[var11_13] = var2_2[var8_10] & var2_2[var9_11];
                                break block15;
                            }
                            case 37: {
                                var2_2[var11_13] = var2_2[var8_10] | var2_2[var9_11];
                                break block15;
                            }
                            case 38: {
                                var2_2[var11_13] = var2_2[var8_10] ^ var2_2[var9_11];
                                break block15;
                            }
                            case 39: {
                                var2_2[var11_13] = ~ (var2_2[var8_10] | var2_2[var9_11]);
                                break block15;
                            }
                            case 42: {
                                var2_2[var11_13] = var2_2[var8_10] < var2_2[var9_11] ? 1 : 0;
                                break block15;
                            }
                            case 43: {
                                var2_2[var11_13] = ((long)var2_2[var8_10] & 0xFFFFFFFFL) < ((long)var2_2[var9_11] & 0xFFFFFFFFL) ? 1 : 0;
                                break block15;
                            }
                        }
                        throw new Runtime$ExecutionException(new StringBuffer().append("Illegal instruction 0/").append(var15_17).toString());
                    }
                    case 1: {
                        switch (var9_11) {
                            case 0: {
                                if (var2_2[var8_10] >= 0) break block15;
                                var5_5 = var20_22 = (var4_4 += 4) + var19_21 * 4;
                                continue block211;
                            }
                            case 1: {
                                if (var2_2[var8_10] < 0) break block15;
                                var5_5 = var20_22 = (var4_4 += 4) + var19_21 * 4;
                                continue block211;
                            }
                            case 16: {
                                if (var2_2[var8_10] >= 0) break block15;
                                var2_2[31] = (var4_4 += 4) + 4;
                                var5_5 = var20_22 = var4_4 + var19_21 * 4;
                                continue block211;
                            }
                            case 17: {
                                if (var2_2[var8_10] < 0) break block15;
                                var2_2[31] = (var4_4 += 4) + 4;
                                var5_5 = var20_22 = var4_4 + var19_21 * 4;
                                continue block211;
                            }
                        }
                        throw new Runtime$ExecutionException("Illegal Instruction");
                    }
                    case 2: {
                        var20_22 = var4_4 & -268435456 | var16_18 << 2;
                        var4_4 += 4;
                        var5_5 = var20_22;
                        continue block211;
                    }
                    case 3: {
                        var20_22 = var4_4 & -268435456 | var16_18 << 2;
                        var2_2[31] = (var4_4 += 4) + 4;
                        var5_5 = var20_22;
                        continue block211;
                    }
                    case 4: {
                        if (var2_2[var8_10] != var2_2[var9_11]) break;
                        var5_5 = var20_22 = (var4_4 += 4) + var19_21 * 4;
                        continue block211;
                    }
                    case 5: {
                        if (var2_2[var8_10] == var2_2[var9_11]) break;
                        var5_5 = var20_22 = (var4_4 += 4) + var19_21 * 4;
                        continue block211;
                    }
                    case 6: {
                        if (var2_2[var8_10] > 0) break;
                        var5_5 = var20_22 = (var4_4 += 4) + var19_21 * 4;
                        continue block211;
                    }
                    case 7: {
                        if (var2_2[var8_10] <= 0) break;
                        var5_5 = var20_22 = (var4_4 += 4) + var19_21 * 4;
                        continue block211;
                    }
                    case 8: {
                        var2_2[var9_11] = var2_2[var8_10] + var18_20;
                        break;
                    }
                    case 9: {
                        var2_2[var9_11] = var2_2[var8_10] + var18_20;
                        break;
                    }
                    case 10: {
                        var2_2[var9_11] = var2_2[var8_10] < var18_20 ? 1 : 0;
                        break;
                    }
                    case 11: {
                        var2_2[var9_11] = ((long)var2_2[var8_10] & 0xFFFFFFFFL) < ((long)var18_20 & 0xFFFFFFFFL) ? 1 : 0;
                        break;
                    }
                    case 12: {
                        var2_2[var9_11] = var2_2[var8_10] & var17_19;
                        break;
                    }
                    case 13: {
                        var2_2[var9_11] = var2_2[var8_10] | var17_19;
                        break;
                    }
                    case 14: {
                        var2_2[var9_11] = var2_2[var8_10] ^ var17_19;
                        break;
                    }
                    case 15: {
                        var2_2[var9_11] = var17_19 << 16;
                        break;
                    }
                    case 16: {
                        throw new Runtime$ExecutionException("TLB/Exception support not implemented");
                    }
                    case 17: {
                        var22_24 = 0;
                        var23_39 = var22_24 != 0 ? this.sourceLine(var4_4) : "";
                        v0 = var24_40 = var22_24 != 0 && (var23_39.indexOf("dtoa.c:51") >= 0 || var23_39.indexOf("dtoa.c:52") >= 0 || var23_39.indexOf("test.c") >= 0);
                        if (var8_10 > 8 && var24_40) {
                            System.out.println(new StringBuffer().append("               FP Op: ").append(var7_8).append("/").append(var8_10).append("/").append(var15_17).append(" ").append(var23_39).toString());
                        }
                        if (this.roundingMode() != 0 && var8_10 != 6) {
                            if (var8_10 != 16) {
                                if (var8_10 != 17) throw new Runtime$ExecutionException("Non-cvt.w.z operation attempted with roundingMode != round to nearest");
                            }
                            if (var15_17 != 36) {
                                throw new Runtime$ExecutionException("Non-cvt.w.z operation attempted with roundingMode != round to nearest");
                            }
                        }
                        switch (var8_10) {
                            case 0: {
                                var2_2[var9_11] = var3_3[var11_13];
                                break block15;
                            }
                            case 2: {
                                if (var12_14 != 31) {
                                    throw new Runtime$ExecutionException(new StringBuffer().append("FCR ").append(var12_14).append(" unavailable").toString());
                                }
                                var2_2[var9_11] = this.fcsr;
                                break block15;
                            }
                            case 4: {
                                var3_3[var11_13] = var2_2[var9_11];
                                break block15;
                            }
                            case 6: {
                                if (var12_14 != 31) {
                                    throw new Runtime$ExecutionException(new StringBuffer().append("FCR ").append(var12_14).append(" unavailable").toString());
                                }
                                this.fcsr = var2_2[var9_11];
                                break block15;
                            }
                            case 8: {
                                if ((this.fcsr & 8388608) != 0 != ((var6_6 >>> 16 & 1) != 0)) break block15;
                                var5_5 = var20_22 = (var4_4 += 4) + var19_21 * 4;
                                continue block211;
                            }
                            case 16: {
                                switch (var15_17) {
                                    case 0: {
                                        this.setFloat(var14_16, this.getFloat(var12_14) + this.getFloat(var10_12));
                                        break block15;
                                    }
                                    case 1: {
                                        this.setFloat(var14_16, this.getFloat(var12_14) - this.getFloat(var10_12));
                                        break block15;
                                    }
                                    case 2: {
                                        this.setFloat(var14_16, this.getFloat(var12_14) * this.getFloat(var10_12));
                                        break block15;
                                    }
                                    case 3: {
                                        this.setFloat(var14_16, this.getFloat(var12_14) / this.getFloat(var10_12));
                                        break block15;
                                    }
                                    case 5: {
                                        this.setFloat(var14_16, Math.abs(this.getFloat(var12_14)));
                                        break block15;
                                    }
                                    case 6: {
                                        var3_3[var14_16] = var3_3[var12_14];
                                        break block15;
                                    }
                                    case 7: {
                                        this.setFloat(var14_16, - this.getFloat(var12_14));
                                        break block15;
                                    }
                                    case 33: {
                                        this.setDouble(var14_16, this.getFloat(var12_14));
                                        break block15;
                                    }
                                    case 36: {
                                        switch (this.roundingMode()) {
                                            case 0: {
                                                var3_3[var14_16] = (int)Math.floor(this.getFloat(var12_14) + 0.5f);
                                                break block15;
                                            }
                                            case 1: {
                                                var3_3[var14_16] = (int)this.getFloat(var12_14);
                                                break block15;
                                            }
                                            case 2: {
                                                var3_3[var14_16] = (int)Math.ceil(this.getFloat(var12_14));
                                                break block15;
                                            }
                                            case 3: {
                                                var3_3[var14_16] = (int)Math.floor(this.getFloat(var12_14));
                                            }
                                        }
                                        break block15;
                                    }
                                    case 50: {
                                        this.setFC(this.getFloat(var12_14) == this.getFloat(var10_12));
                                        break block15;
                                    }
                                    case 60: {
                                        this.setFC(this.getFloat(var12_14) < this.getFloat(var10_12));
                                        break block15;
                                    }
                                    case 62: {
                                        this.setFC(this.getFloat(var12_14) <= this.getFloat(var10_12));
                                        break block15;
                                    }
                                }
                                throw new Runtime$ExecutionException(new StringBuffer().append("Invalid Instruction 17/").append(var8_10).append("/").append(var15_17).append(" at ").append(this.sourceLine(var4_4)).toString());
                            }
                            case 17: {
                                switch (var15_17) {
                                    case 0: {
                                        this.setDouble(var14_16, this.getDouble(var12_14) + this.getDouble(var10_12));
                                        break block15;
                                    }
                                    case 1: {
                                        if (var24_40) {
                                            System.out.println(new StringBuffer().append("f").append(var14_16).append(" = f").append(var12_14).append(" (").append(this.getDouble(var12_14)).append(") - f").append(var10_12).append(" (").append(this.getDouble(var10_12)).append(")").toString());
                                        }
                                        this.setDouble(var14_16, this.getDouble(var12_14) - this.getDouble(var10_12));
                                        break block15;
                                    }
                                    case 2: {
                                        if (var24_40) {
                                            System.out.println(new StringBuffer().append("f").append(var14_16).append(" = f").append(var12_14).append(" (").append(this.getDouble(var12_14)).append(") * f").append(var10_12).append(" (").append(this.getDouble(var10_12)).append(")").toString());
                                        }
                                        this.setDouble(var14_16, this.getDouble(var12_14) * this.getDouble(var10_12));
                                        if (!var24_40) break block15;
                                        System.out.println(new StringBuffer().append("f").append(var14_16).append(" = ").append(this.getDouble(var14_16)).toString());
                                        break block15;
                                    }
                                    case 3: {
                                        this.setDouble(var14_16, this.getDouble(var12_14) / this.getDouble(var10_12));
                                        break block15;
                                    }
                                    case 5: {
                                        this.setDouble(var14_16, Math.abs(this.getDouble(var12_14)));
                                        break block15;
                                    }
                                    case 6: {
                                        var3_3[var14_16] = var3_3[var12_14];
                                        var3_3[var14_16 + 1] = var3_3[var12_14 + 1];
                                        break block15;
                                    }
                                    case 7: {
                                        this.setDouble(var14_16, - this.getDouble(var12_14));
                                        break block15;
                                    }
                                    case 32: {
                                        this.setFloat(var14_16, (float)this.getDouble(var12_14));
                                        break block15;
                                    }
                                    case 36: {
                                        if (var24_40) {
                                            System.out.println(new StringBuffer().append("CVT.W.D rm: ").append(this.roundingMode()).append(" f").append(var12_14).append(":").append(this.getDouble(var12_14)).toString());
                                        }
                                        switch (this.roundingMode()) {
                                            case 0: {
                                                var3_3[var14_16] = (int)Math.floor(this.getDouble(var12_14) + 0.5);
                                                break;
                                            }
                                            case 1: {
                                                var3_3[var14_16] = (int)this.getDouble(var12_14);
                                                break;
                                            }
                                            case 2: {
                                                var3_3[var14_16] = (int)Math.ceil(this.getDouble(var12_14));
                                                break;
                                            }
                                            case 3: {
                                                var3_3[var14_16] = (int)Math.floor(this.getDouble(var12_14));
                                            }
                                        }
                                        if (!var24_40) break block15;
                                        System.out.println(new StringBuffer().append("CVT.W.D: f").append(var14_16).append(":").append(var3_3[var14_16]).toString());
                                        break block15;
                                    }
                                    case 50: {
                                        this.setFC(this.getDouble(var12_14) == this.getDouble(var10_12));
                                        break block15;
                                    }
                                    case 60: {
                                        this.setFC(this.getDouble(var12_14) < this.getDouble(var10_12));
                                        break block15;
                                    }
                                    case 62: {
                                        this.setFC(this.getDouble(var12_14) <= this.getDouble(var10_12));
                                        break block15;
                                    }
                                }
                                throw new Runtime$ExecutionException(new StringBuffer().append("Invalid Instruction 17/").append(var8_10).append("/").append(var15_17).append(" at ").append(this.sourceLine(var4_4)).toString());
                            }
                            case 20: {
                                switch (var15_17) {
                                    case 32: {
                                        this.setFloat(var14_16, var3_3[var12_14]);
                                        break block15;
                                    }
                                    case 33: {
                                        this.setDouble(var14_16, var3_3[var12_14]);
                                        break block15;
                                    }
                                }
                                throw new Runtime$ExecutionException(new StringBuffer().append("Invalid Instruction 17/").append(var8_10).append("/").append(var15_17).append(" at ").append(this.sourceLine(var4_4)).toString());
                            }
                        }
                        throw new Runtime$ExecutionException(new StringBuffer().append("Invalid Instruction 17/").append(var8_10).toString());
                    }
                    case 18: 
                    case 19: {
                        throw new Runtime$ExecutionException("No coprocessor installed");
                    }
                    case 32: {
                        var21_23 = var2_2[var8_10] + var18_20;
                        try {
                            var20_22 = this.readPages[var21_23 >>> this.pageShift][var21_23 >>> 2 & var1_1 - 1];
                        }
                        catch (RuntimeException var22_26) {
                            var20_22 = this.memRead(var21_23 & -4);
                        }
                        switch (var21_23 & 3) {
                            case 0: {
                                var20_22 = var20_22 >>> 24 & 255;
                                break;
                            }
                            case 1: {
                                var20_22 = var20_22 >>> 16 & 255;
                                break;
                            }
                            case 2: {
                                var20_22 = var20_22 >>> 8 & 255;
                                break;
                            }
                            case 3: {
                                var20_22 = var20_22 >>> 0 & 255;
                            }
                        }
                        if ((var20_22 & 128) != 0) {
                            var20_22 |= -256;
                        }
                        var2_2[var9_11] = var20_22;
                        break;
                    }
                    case 33: {
                        var21_23 = var2_2[var8_10] + var18_20;
                        try {
                            var20_22 = this.readPages[var21_23 >>> this.pageShift][var21_23 >>> 2 & var1_1 - 1];
                        }
                        catch (RuntimeException var22_27) {
                            var20_22 = this.memRead(var21_23 & -4);
                        }
                        switch (var21_23 & 3) {
                            case 0: {
                                var20_22 = var20_22 >>> 16 & 65535;
                                ** break;
                            }
                            case 2: {
                                var20_22 = var20_22 >>> 0 & 65535;
                                ** break;
                            }
                        }
                        throw new Runtime$ReadFaultException(var21_23);
lbl394: // 2 sources:
                        if ((var20_22 & 32768) != 0) {
                            var20_22 |= -65536;
                        }
                        var2_2[var9_11] = var20_22;
                        break;
                    }
                    case 34: {
                        var21_23 = var2_2[var8_10] + var18_20;
                        try {
                            var20_22 = this.readPages[var21_23 >>> this.pageShift][var21_23 >>> 2 & var1_1 - 1];
                        }
                        catch (RuntimeException var22_28) {
                            var20_22 = this.memRead(var21_23 & -4);
                        }
                        switch (var21_23 & 3) {
                            case 0: {
                                var2_2[var9_11] = var2_2[var9_11] & 0 | var20_22 << 0;
                                break block15;
                            }
                            case 1: {
                                var2_2[var9_11] = var2_2[var9_11] & 255 | var20_22 << 8;
                                break block15;
                            }
                            case 2: {
                                var2_2[var9_11] = var2_2[var9_11] & 65535 | var20_22 << 16;
                                break block15;
                            }
                            case 3: {
                                var2_2[var9_11] = var2_2[var9_11] & 16777215 | var20_22 << 24;
                            }
                        }
                        break;
                    }
                    case 35: {
                        var21_23 = var2_2[var8_10] + var18_20;
                        try {
                            var2_2[var9_11] = this.readPages[var21_23 >>> this.pageShift][var21_23 >>> 2 & var1_1 - 1];
                        }
                        catch (RuntimeException var22_29) {
                            var2_2[var9_11] = this.memRead(var21_23);
                        }
                        break;
                    }
                    case 36: {
                        var21_23 = var2_2[var8_10] + var18_20;
                        try {
                            var20_22 = this.readPages[var21_23 >>> this.pageShift][var21_23 >>> 2 & var1_1 - 1];
                        }
                        catch (RuntimeException var22_30) {
                            var20_22 = this.memRead(var21_23);
                        }
                        switch (var21_23 & 3) {
                            case 0: {
                                var2_2[var9_11] = var20_22 >>> 24 & 255;
                                break block15;
                            }
                            case 1: {
                                var2_2[var9_11] = var20_22 >>> 16 & 255;
                                break block15;
                            }
                            case 2: {
                                var2_2[var9_11] = var20_22 >>> 8 & 255;
                                break block15;
                            }
                            case 3: {
                                var2_2[var9_11] = var20_22 >>> 0 & 255;
                            }
                        }
                        break;
                    }
                    case 37: {
                        var21_23 = var2_2[var8_10] + var18_20;
                        try {
                            var20_22 = this.readPages[var21_23 >>> this.pageShift][var21_23 >>> 2 & var1_1 - 1];
                        }
                        catch (RuntimeException var22_31) {
                            var20_22 = this.memRead(var21_23 & -4);
                        }
                        switch (var21_23 & 3) {
                            case 0: {
                                var2_2[var9_11] = var20_22 >>> 16 & 65535;
                                break block15;
                            }
                            case 2: {
                                var2_2[var9_11] = var20_22 >>> 0 & 65535;
                                break block15;
                            }
                        }
                        throw new Runtime$ReadFaultException(var21_23);
                    }
                    case 38: {
                        var21_23 = var2_2[var8_10] + var18_20;
                        try {
                            var20_22 = this.readPages[var21_23 >>> this.pageShift][var21_23 >>> 2 & var1_1 - 1];
                        }
                        catch (RuntimeException var22_32) {
                            var20_22 = this.memRead(var21_23 & -4);
                        }
                        switch (var21_23 & 3) {
                            case 0: {
                                var2_2[var9_11] = var2_2[var9_11] & -256 | var20_22 >>> 24;
                                break block15;
                            }
                            case 1: {
                                var2_2[var9_11] = var2_2[var9_11] & -65536 | var20_22 >>> 16;
                                break block15;
                            }
                            case 2: {
                                var2_2[var9_11] = var2_2[var9_11] & -16777216 | var20_22 >>> 8;
                                break block15;
                            }
                            case 3: {
                                var2_2[var9_11] = var2_2[var9_11] & 0 | var20_22 >>> 0;
                            }
                        }
                        break;
                    }
                    case 40: {
                        var21_23 = var2_2[var8_10] + var18_20;
                        try {
                            var20_22 = this.readPages[var21_23 >>> this.pageShift][var21_23 >>> 2 & var1_1 - 1];
                        }
                        catch (RuntimeException var22_33) {
                            var20_22 = this.memRead(var21_23 & -4);
                        }
                        switch (var21_23 & 3) {
                            case 0: {
                                var20_22 = var20_22 & 16777215 | (var2_2[var9_11] & 255) << 24;
                                break;
                            }
                            case 1: {
                                var20_22 = var20_22 & -16711681 | (var2_2[var9_11] & 255) << 16;
                                break;
                            }
                            case 2: {
                                var20_22 = var20_22 & -65281 | (var2_2[var9_11] & 255) << 8;
                                break;
                            }
                            case 3: {
                                var20_22 = var20_22 & -256 | (var2_2[var9_11] & 255) << 0;
                            }
                        }
                        try {
                            this.writePages[var21_23 >>> this.pageShift][var21_23 >>> 2 & var1_1 - 1] = var20_22;
                        }
                        catch (RuntimeException var22_34) {
                            this.memWrite(var21_23 & -4, var20_22);
                        }
                        break;
                    }
                    case 41: {
                        var21_23 = var2_2[var8_10] + var18_20;
                        try {
                            var20_22 = this.readPages[var21_23 >>> this.pageShift][var21_23 >>> 2 & var1_1 - 1];
                        }
                        catch (RuntimeException var22_35) {
                            var20_22 = this.memRead(var21_23 & -4);
                        }
                        switch (var21_23 & 3) {
                            case 0: {
                                var20_22 = var20_22 & 65535 | (var2_2[var9_11] & 65535) << 16;
                                ** break;
                            }
                            case 2: {
                                var20_22 = var20_22 & -65536 | (var2_2[var9_11] & 65535) << 0;
                                ** break;
                            }
                        }
                        throw new Runtime$WriteFaultException(var21_23);
lbl521: // 2 sources:
                        try {
                            this.writePages[var21_23 >>> this.pageShift][var21_23 >>> 2 & var1_1 - 1] = var20_22;
                        }
                        catch (RuntimeException var22_36) {
                            this.memWrite(var21_23 & -4, var20_22);
                        }
                        break;
                    }
                    case 42: {
                        var21_23 = var2_2[var8_10] + var18_20;
                        var20_22 = this.memRead(var21_23 & -4);
                        switch (var21_23 & 3) {
                            case 0: {
                                var20_22 = var20_22 & 0 | var2_2[var9_11] >>> 0;
                                break;
                            }
                            case 1: {
                                var20_22 = var20_22 & -16777216 | var2_2[var9_11] >>> 8;
                                break;
                            }
                            case 2: {
                                var20_22 = var20_22 & -65536 | var2_2[var9_11] >>> 16;
                                break;
                            }
                            case 3: {
                                var20_22 = var20_22 & -256 | var2_2[var9_11] >>> 24;
                            }
                        }
                        try {
                            this.writePages[var21_23 >>> this.pageShift][var21_23 >>> 2 & var1_1 - 1] = var20_22;
                        }
                        catch (RuntimeException var22_37) {
                            this.memWrite(var21_23 & -4, var20_22);
                        }
                        break;
                    }
                    case 43: {
                        var21_23 = var2_2[var8_10] + var18_20;
                        try {
                            this.writePages[var21_23 >>> this.pageShift][var21_23 >>> 2 & var1_1 - 1] = var2_2[var9_11];
                        }
                        catch (RuntimeException var22_38) {
                            this.memWrite(var21_23 & -4, var2_2[var9_11]);
                        }
                        break;
                    }
                    case 46: {
                        var21_23 = var2_2[var8_10] + var18_20;
                        var20_22 = this.memRead(var21_23 & -4);
                        switch (var21_23 & 3) {
                            case 0: {
                                var20_22 = var20_22 & 16777215 | var2_2[var9_11] << 24;
                                break;
                            }
                            case 1: {
                                var20_22 = var20_22 & 65535 | var2_2[var9_11] << 16;
                                break;
                            }
                            case 2: {
                                var20_22 = var20_22 & 255 | var2_2[var9_11] << 8;
                                break;
                            }
                            case 3: {
                                var20_22 = var20_22 & 0 | var2_2[var9_11] << 0;
                            }
                        }
                        this.memWrite(var21_23 & -4, var20_22);
                        break;
                    }
                    case 48: {
                        var2_2[var9_11] = this.memRead(var2_2[var8_10] + var18_20);
                        break;
                    }
                    case 49: {
                        var3_3[var9_11] = this.memRead(var2_2[var8_10] + var18_20);
                        break;
                    }
                    case 56: {
                        this.memWrite(var2_2[var8_10] + var18_20, var2_2[var9_11]);
                        var2_2[var9_11] = 1;
                        break;
                    }
                    case 57: {
                        this.memWrite(var2_2[var8_10] + var18_20, var3_3[var9_11]);
                        break;
                    }
                    default: {
                        throw new Runtime$ExecutionException(new StringBuffer().append("Invalid Instruction: ").append(var7_8).toString());
                    }
                }
                var4_4 = var5_5;
                var5_5 = var4_4 + 4;
            } while (true);
        }
        catch (Runtime$ExecutionException var6_7) {
            this.pc = var4_4;
            throw var6_7;
        }
    }

    @Override
    public int lookupSymbol(String string) {
        ELF$Symbol eLF$Symbol = this.symtab.getGlobalSymbol(string);
        if (eLF$Symbol == null) {
            return -1;
        }
        int n2 = eLF$Symbol.addr;
        return n2;
    }

    @Override
    protected int gp() {
        return this.gp;
    }

    protected int userInfoBae() {
        if (this.userInfo == null) {
            return 0;
        }
        int n2 = this.userInfo.addr;
        return n2;
    }

    @Override
    protected int userInfoSize() {
        if (this.userInfo == null) {
            return 0;
        }
        int n2 = this.userInfo.size;
        return n2;
    }

    @Override
    protected int entryPoint() {
        return this.entryPoint;
    }

    @Override
    protected int heapStart() {
        return this.heapStart;
    }

    private void loadImage(Seekable seekable) {
        ELF eLF = new ELF(seekable);
        this.symtab = eLF.getSymtab();
        if (eLF.header.type != 2) {
            throw new IOException("Binary is not an executable");
        }
        if (eLF.header.machine != 8) {
            throw new IOException("Binary is not for the MIPS I Architecture");
        }
        if (eLF.ident.data != 2) {
            throw new IOException("Binary is not big endian");
        }
        this.entryPoint = eLF.header.entry;
        ELF$Symtab eLF$Symtab = eLF.getSymtab();
        if (eLF$Symtab == null) {
            throw new IOException("No symtab in binary (did you strip it?)");
        }
        this.userInfo = eLF$Symtab.getGlobalSymbol("user_info");
        ELF$Symbol eLF$Symbol = eLF$Symtab.getGlobalSymbol("_gp");
        if (eLF$Symbol == null) {
            throw new IOException("NO _gp symbol!");
        }
        this.gp = eLF$Symbol.addr;
        this.entryPoint = eLF.header.entry;
        ELF$PHeader[] arreLF$PHeader = eLF.pheaders;
        int n2 = 0;
        int n3 = 1 << this.pageShift;
        int n4 = 1 << this.pageShift >> 2;
        int n5 = 0;
        do {
            if (n5 >= arreLF$PHeader.length) {
                this.heapStart = n2 + n3 - 1 & ~ (n3 - 1);
                return;
            }
            ELF$PHeader eLF$PHeader = arreLF$PHeader[n5];
            if (eLF$PHeader.type == 1) {
                int n6 = eLF$PHeader.memsz;
                int n7 = eLF$PHeader.filesz;
                if (n6 != 0) {
                    if (n6 < 0) {
                        throw new IOException("pheader size too large");
                    }
                    int n8 = eLF$PHeader.vaddr;
                    if (n8 == 0) {
                        throw new IOException("pheader vaddr == 0x0");
                    }
                    n2 = Interpreter.max(n8 + n6, n2);
                    for (int i2 = 0; i2 < n6 + n3 - 1; i2 += n3) {
                        int n9 = i2 + n8 >>> this.pageShift;
                        if (this.readPages[n9] == null) {
                            this.readPages[n9] = new int[n4];
                        }
                        if (!eLF$PHeader.writable()) continue;
                        this.writePages[n9] = this.readPages[n9];
                    }
                    if (n7 != 0) {
                        n7 &= -4;
                        DataInputStream dataInputStream = new DataInputStream(eLF$PHeader.getInputStream());
                        do {
                            this.readPages[n8 >>> this.pageShift][n8 >>> 2 & n4 - 1] = dataInputStream.readInt();
                            n8 += 4;
                        } while ((n7 -= 4) > 0);
                        dataInputStream.close();
                    }
                }
            }
            ++n5;
        } while (true);
    }

    @Override
    protected void setCPUState(Runtime$CPUState runtime$CPUState) {
        int n2;
        for (n2 = 1; n2 < 32; ++n2) {
            this.registers[n2] = runtime$CPUState.r[n2];
        }
        n2 = 0;
        do {
            if (n2 >= 32) {
                this.hi = runtime$CPUState.hi;
                this.lo = runtime$CPUState.lo;
                this.fcsr = runtime$CPUState.fcsr;
                this.pc = runtime$CPUState.pc;
                return;
            }
            this.fpregs[n2] = runtime$CPUState.f[n2];
            ++n2;
        } while (true);
    }

    @Override
    protected void getCPUState(Runtime$CPUState runtime$CPUState) {
        int n2;
        for (n2 = 1; n2 < 32; ++n2) {
            runtime$CPUState.r[n2] = this.registers[n2];
        }
        n2 = 0;
        do {
            if (n2 >= 32) {
                runtime$CPUState.hi = this.hi;
                runtime$CPUState.lo = this.lo;
                runtime$CPUState.fcsr = this.fcsr;
                runtime$CPUState.pc = this.pc;
                return;
            }
            runtime$CPUState.f[n2] = this.fpregs[n2];
            ++n2;
        } while (true);
    }

    public Interpreter(Seekable seekable) {
        super(4096, 65536);
        this.loadImage(seekable);
    }

    public Interpreter(String string) {
        this(new Seekable$File(string, false));
        this.image = string;
    }

    public Interpreter(InputStream inputStream) {
        this(new Seekable$InputStream(inputStream));
    }

    public String sourceLine(int n2) {
        String string = this.sourceLineCache == null ? null : this.sourceLineCache.get(new Integer(n2));
        if (string != null) {
            return string;
        }
        if (this.image == null) {
            return null;
        }
        try {
            Process process = Runtime.getRuntime().exec(new String[]{"mips-unknown-elf-addr2line", "-e", this.image, Interpreter.toHex(n2)});
            string = new BufferedReader(new InputStreamReader(process.getInputStream())).readLine();
            if (string == null) {
                return null;
            }
            while (string.startsWith("../")) {
                string = string.substring(3);
            }
            if (this.sourceLineCache == null) {
                this.sourceLineCache = new HashMap();
            }
            this.sourceLineCache.put(new Integer(n2), string);
            return string;
        }
        catch (IOException var4_4) {
            return null;
        }
    }

    public static void main(String[] arrstring) {
        Interpreter interpreter;
        String string = arrstring[0];
        Interpreter interpreter2 = interpreter = new Interpreter(string);
        interpreter2.getClass();
        Runtime.getRuntime().addShutdownHook(new Thread(new Interpreter$DebugShutdownHook(interpreter2)));
        int n2 = interpreter.run(arrstring);
        System.err.println(new StringBuffer().append("Exit status: ").append(n2).toString());
        System.exit(n2);
    }

    static int access$000(Interpreter interpreter) {
        return interpreter.pc;
    }
}

