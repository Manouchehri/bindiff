/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.hash.GoogleLegacy32HashFunction$1;
import com.google.common.hash.GoogleLegacy32HashFunction$FingerprintStrategy$1;
import com.google.common.hash.GoogleLegacy32HashFunction$FingerprintStrategy$2;

abstract class GoogleLegacy32HashFunction$FingerprintStrategy
extends Enum {
    public static final /* enum */ GoogleLegacy32HashFunction$FingerprintStrategy WORKING = new GoogleLegacy32HashFunction$FingerprintStrategy$1("WORKING", 0);
    public static final /* enum */ GoogleLegacy32HashFunction$FingerprintStrategy BROKEN = new GoogleLegacy32HashFunction$FingerprintStrategy$2("BROKEN", 1);
    private static final /* synthetic */ GoogleLegacy32HashFunction$FingerprintStrategy[] $VALUES;

    public static GoogleLegacy32HashFunction$FingerprintStrategy[] values() {
        return (GoogleLegacy32HashFunction$FingerprintStrategy[])$VALUES.clone();
    }

    public static GoogleLegacy32HashFunction$FingerprintStrategy valueOf(String string) {
        return (GoogleLegacy32HashFunction$FingerprintStrategy)((Object)Enum.valueOf(GoogleLegacy32HashFunction$FingerprintStrategy.class, string));
    }

    private GoogleLegacy32HashFunction$FingerprintStrategy() {
        super(string, n2);
    }

    abstract int maybeAddSignCruft(int var1);

    abstract int word32At(byte[] var1, int var2);

    /*
     * Exception decompiling
     */
    /* synthetic */ GoogleLegacy32HashFunction$FingerprintStrategy(GoogleLegacy32HashFunction$1 var1) {
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
        $VALUES = new GoogleLegacy32HashFunction$FingerprintStrategy[]{WORKING, BROKEN};
    }
}

