/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.base.Supplier;
import com.google.common.hash.Hashing$1;
import com.google.common.hash.Hashing$ChecksumType$1;
import com.google.common.hash.Hashing$ChecksumType$2;
import java.util.zip.Checksum;

abstract class Hashing$ChecksumType
extends Enum
implements Supplier {
    public static final /* enum */ Hashing$ChecksumType CRC_32 = new Hashing$ChecksumType$1("CRC_32", 0, 32);
    public static final /* enum */ Hashing$ChecksumType ADLER_32 = new Hashing$ChecksumType$2("ADLER_32", 1, 32);
    private final int bits;
    private static final /* synthetic */ Hashing$ChecksumType[] $VALUES;

    public static Hashing$ChecksumType[] values() {
        return (Hashing$ChecksumType[])$VALUES.clone();
    }

    public static Hashing$ChecksumType valueOf(String string) {
        return (Hashing$ChecksumType)Enum.valueOf(Hashing$ChecksumType.class, string);
    }

    private Hashing$ChecksumType(int n3) {
        super(string, n2);
        this.bits = n3;
    }

    @Override
    public abstract Checksum get();

    static /* synthetic */ int access$300(Hashing$ChecksumType hashing$ChecksumType) {
        return hashing$ChecksumType.bits;
    }

    /*
     * Exception decompiling
     */
    /* synthetic */ Hashing$ChecksumType(int var1, Hashing$1 var2) {
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
        $VALUES = new Hashing$ChecksumType[]{CRC_32, ADLER_32};
    }
}

