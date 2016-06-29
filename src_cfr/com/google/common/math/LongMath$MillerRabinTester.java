/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.math;

import com.google.common.math.LongMath$1;
import com.google.common.math.LongMath$MillerRabinTester$1;
import com.google.common.math.LongMath$MillerRabinTester$2;

abstract class LongMath$MillerRabinTester
extends Enum {
    public static final /* enum */ LongMath$MillerRabinTester SMALL = new LongMath$MillerRabinTester$1("SMALL", 0);
    public static final /* enum */ LongMath$MillerRabinTester LARGE = new LongMath$MillerRabinTester$2("LARGE", 1);
    private static final /* synthetic */ LongMath$MillerRabinTester[] $VALUES;

    public static LongMath$MillerRabinTester[] values() {
        return (LongMath$MillerRabinTester[])$VALUES.clone();
    }

    public static LongMath$MillerRabinTester valueOf(String string) {
        return (LongMath$MillerRabinTester)((Object)Enum.valueOf(LongMath$MillerRabinTester.class, string));
    }

    private LongMath$MillerRabinTester() {
        super(string, n2);
    }

    static boolean test(long l2, long l3) {
        LongMath$MillerRabinTester longMath$MillerRabinTester;
        if (l3 <= 3037000499L) {
            longMath$MillerRabinTester = SMALL;
            return longMath$MillerRabinTester.testWitness(l2, l3);
        }
        longMath$MillerRabinTester = LARGE;
        return longMath$MillerRabinTester.testWitness(l2, l3);
    }

    abstract long mulMod(long var1, long var3, long var5);

    abstract long squareMod(long var1, long var3);

    private long powMod(long l2, long l3, long l4) {
        long l5 = 1;
        while (l3 != 0) {
            if ((l3 & 1) != 0) {
                l5 = this.mulMod(l5, l2, l4);
            }
            l2 = this.squareMod(l2, l4);
            l3 >>= 1;
        }
        return l5;
    }

    private boolean testWitness(long l2, long l3) {
        int n2 = Long.numberOfTrailingZeros(l3 - 1);
        long l4 = l3 - 1 >> n2;
        if ((l2 %= l3) == 0) {
            return true;
        }
        long l5 = this.powMod(l2, l4, l3);
        if (l5 == 1) {
            return true;
        }
        int n3 = 0;
        while (l5 != l3 - 1) {
            if (++n3 == n2) {
                return false;
            }
            l5 = this.squareMod(l5, l3);
        }
        return true;
    }

    /*
     * Exception decompiling
     */
    /* synthetic */ LongMath$MillerRabinTester(LongMath$1 var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.lang.IllegalStateException: Synthetic arg - offset is 1, but got 3
        // org.benf.cfr.reader.bytecode.analysis.types.MethodPrototype.collectInitialSlotUsage(MethodPrototype.java:244)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.assignSSAIdentifiersInner(Op02WithProcessedDataAndRefs.java:1527)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.assignSSAIdentifiers(Op02WithProcessedDataAndRefs.java:1484)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.discoverStorageLiveness(Op02WithProcessedDataAndRefs.java:1728)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:384)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:129)
        // org.benf.cfr.reader.Main.main(Main.java:181)
        // the.bytecode.club.bytecodeviewer.decompilers.CFRDecompiler.decompileToZip(CFRDecompiler.java:245)
        // the.bytecode.club.bytecodeviewer.gui.MainViewerGUI$18$1$3.run(MainViewerGUI.java:1107)
        throw new IllegalStateException("Decompilation failed");
    }

    static {
        $VALUES = new LongMath$MillerRabinTester[]{SMALL, LARGE};
    }
}

