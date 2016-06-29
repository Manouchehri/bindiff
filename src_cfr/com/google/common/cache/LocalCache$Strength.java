/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.base.Equivalence;
import com.google.common.cache.LocalCache$1;
import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.cache.LocalCache$Segment;
import com.google.common.cache.LocalCache$Strength$1;
import com.google.common.cache.LocalCache$Strength$2;
import com.google.common.cache.LocalCache$Strength$3;
import com.google.common.cache.LocalCache$ValueReference;

abstract class LocalCache$Strength
extends Enum {
    public static final /* enum */ LocalCache$Strength STRONG = new LocalCache$Strength$1("STRONG", 0);
    public static final /* enum */ LocalCache$Strength SOFT = new LocalCache$Strength$2("SOFT", 1);
    public static final /* enum */ LocalCache$Strength WEAK = new LocalCache$Strength$3("WEAK", 2);
    private static final /* synthetic */ LocalCache$Strength[] $VALUES;

    public static LocalCache$Strength[] values() {
        return (LocalCache$Strength[])$VALUES.clone();
    }

    public static LocalCache$Strength valueOf(String string) {
        return (LocalCache$Strength)((Object)Enum.valueOf(LocalCache$Strength.class, string));
    }

    private LocalCache$Strength() {
        super(string, n2);
    }

    abstract LocalCache$ValueReference referenceValue(LocalCache$Segment var1, LocalCache$ReferenceEntry var2, Object var3, int var4);

    abstract Equivalence defaultEquivalence();

    /*
     * Exception decompiling
     */
    /* synthetic */ LocalCache$Strength(LocalCache$1 var1) {
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
        $VALUES = new LocalCache$Strength[]{STRONG, SOFT, WEAK};
    }
}

