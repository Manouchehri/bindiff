/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.SortedLists$1;
import com.google.common.collect.SortedLists$KeyAbsentBehavior$1;
import com.google.common.collect.SortedLists$KeyAbsentBehavior$2;
import com.google.common.collect.SortedLists$KeyAbsentBehavior$3;

public abstract class SortedLists$KeyAbsentBehavior
extends Enum {
    public static final /* enum */ SortedLists$KeyAbsentBehavior NEXT_LOWER = new SortedLists$KeyAbsentBehavior$1("NEXT_LOWER", 0);
    public static final /* enum */ SortedLists$KeyAbsentBehavior NEXT_HIGHER = new SortedLists$KeyAbsentBehavior$2("NEXT_HIGHER", 1);
    public static final /* enum */ SortedLists$KeyAbsentBehavior INVERTED_INSERTION_INDEX = new SortedLists$KeyAbsentBehavior$3("INVERTED_INSERTION_INDEX", 2);
    private static final /* synthetic */ SortedLists$KeyAbsentBehavior[] $VALUES;

    public static SortedLists$KeyAbsentBehavior[] values() {
        return (SortedLists$KeyAbsentBehavior[])$VALUES.clone();
    }

    public static SortedLists$KeyAbsentBehavior valueOf(String string) {
        return (SortedLists$KeyAbsentBehavior)((Object)Enum.valueOf(SortedLists$KeyAbsentBehavior.class, string));
    }

    private SortedLists$KeyAbsentBehavior() {
        super(string, n2);
    }

    abstract int resultIndex(int var1);

    /*
     * Exception decompiling
     */
    /* synthetic */ SortedLists$KeyAbsentBehavior(SortedLists$1 var1) {
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
        $VALUES = new SortedLists$KeyAbsentBehavior[]{NEXT_LOWER, NEXT_HIGHER, INVERTED_INSERTION_INDEX};
    }
}

