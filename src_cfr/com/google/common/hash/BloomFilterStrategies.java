/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.hash.BloomFilter$Strategy;
import com.google.common.hash.BloomFilterStrategies$1;
import com.google.common.hash.BloomFilterStrategies$2;

abstract class BloomFilterStrategies
extends Enum
implements BloomFilter$Strategy {
    public static final /* enum */ BloomFilterStrategies MURMUR128_MITZ_32 = new BloomFilterStrategies$1("MURMUR128_MITZ_32", 0);
    public static final /* enum */ BloomFilterStrategies MURMUR128_MITZ_64 = new BloomFilterStrategies$2("MURMUR128_MITZ_64", 1);
    private static final /* synthetic */ BloomFilterStrategies[] $VALUES;

    public static BloomFilterStrategies[] values() {
        return (BloomFilterStrategies[])$VALUES.clone();
    }

    public static BloomFilterStrategies valueOf(String string) {
        return (BloomFilterStrategies)Enum.valueOf(BloomFilterStrategies.class, string);
    }

    private BloomFilterStrategies() {
        super(string, n2);
    }

    /*
     * Exception decompiling
     */
    /* synthetic */ BloomFilterStrategies(BloomFilterStrategies$1 var1) {
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
        $VALUES = new BloomFilterStrategies[]{MURMUR128_MITZ_32, MURMUR128_MITZ_64};
    }
}

