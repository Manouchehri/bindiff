/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.collect.SortedLists$1;
import com.google.common.collect.SortedLists$KeyPresentBehavior$1;
import com.google.common.collect.SortedLists$KeyPresentBehavior$2;
import com.google.common.collect.SortedLists$KeyPresentBehavior$3;
import com.google.common.collect.SortedLists$KeyPresentBehavior$4;
import com.google.common.collect.SortedLists$KeyPresentBehavior$5;
import java.util.Comparator;
import java.util.List;

public abstract class SortedLists$KeyPresentBehavior
extends Enum {
    public static final /* enum */ SortedLists$KeyPresentBehavior ANY_PRESENT = new SortedLists$KeyPresentBehavior$1("ANY_PRESENT", 0);
    public static final /* enum */ SortedLists$KeyPresentBehavior LAST_PRESENT = new SortedLists$KeyPresentBehavior$2("LAST_PRESENT", 1);
    public static final /* enum */ SortedLists$KeyPresentBehavior FIRST_PRESENT = new SortedLists$KeyPresentBehavior$3("FIRST_PRESENT", 2);
    public static final /* enum */ SortedLists$KeyPresentBehavior FIRST_AFTER = new SortedLists$KeyPresentBehavior$4("FIRST_AFTER", 3);
    public static final /* enum */ SortedLists$KeyPresentBehavior LAST_BEFORE = new SortedLists$KeyPresentBehavior$5("LAST_BEFORE", 4);
    private static final /* synthetic */ SortedLists$KeyPresentBehavior[] $VALUES;

    public static SortedLists$KeyPresentBehavior[] values() {
        return (SortedLists$KeyPresentBehavior[])$VALUES.clone();
    }

    public static SortedLists$KeyPresentBehavior valueOf(String string) {
        return (SortedLists$KeyPresentBehavior)((Object)Enum.valueOf(SortedLists$KeyPresentBehavior.class, string));
    }

    private SortedLists$KeyPresentBehavior() {
        super(string, n2);
    }

    abstract int resultIndex(Comparator var1, Object var2, List var3, int var4);

    /*
     * Exception decompiling
     */
    /* synthetic */ SortedLists$KeyPresentBehavior(SortedLists$1 var1) {
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
        $VALUES = new SortedLists$KeyPresentBehavior[]{ANY_PRESENT, LAST_PRESENT, FIRST_PRESENT, FIRST_AFTER, LAST_BEFORE};
    }
}

