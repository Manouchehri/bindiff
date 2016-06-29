package org.ibex.nestedvm;

public class Runtime$CPUState
{
    public int[] r;
    public int[] f;
    public int hi;
    public int lo;
    public int fcsr;
    public int pc;
    
    public Runtime$CPUState() {
        this.r = new int[32];
        this.f = new int[32];
    }
    
    public Runtime$CPUState dup() {
        final Runtime$CPUState runtime$CPUState = new Runtime$CPUState();
        runtime$CPUState.hi = this.hi;
        runtime$CPUState.lo = this.lo;
        runtime$CPUState.fcsr = this.fcsr;
        runtime$CPUState.pc = this.pc;
        for (int i = 0; i < 32; ++i) {
            runtime$CPUState.r[i] = this.r[i];
            runtime$CPUState.f[i] = this.f[i];
        }
        return runtime$CPUState;
    }
}
