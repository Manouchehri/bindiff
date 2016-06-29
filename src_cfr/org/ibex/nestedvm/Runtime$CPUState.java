/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm;

public class Runtime$CPUState {
    public int[] r = new int[32];
    public int[] f = new int[32];
    public int hi;
    public int lo;
    public int fcsr;
    public int pc;

    public Runtime$CPUState dup() {
        Runtime$CPUState runtime$CPUState = new Runtime$CPUState();
        runtime$CPUState.hi = this.hi;
        runtime$CPUState.lo = this.lo;
        runtime$CPUState.fcsr = this.fcsr;
        runtime$CPUState.pc = this.pc;
        int n2 = 0;
        while (n2 < 32) {
            runtime$CPUState.r[n2] = this.r[n2];
            runtime$CPUState.f[n2] = this.f[n2];
            ++n2;
        }
        return runtime$CPUState;
    }
}

