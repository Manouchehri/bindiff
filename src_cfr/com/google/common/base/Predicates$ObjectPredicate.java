/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates$1;
import com.google.common.base.Predicates$ObjectPredicate$1;
import com.google.common.base.Predicates$ObjectPredicate$2;
import com.google.common.base.Predicates$ObjectPredicate$3;
import com.google.common.base.Predicates$ObjectPredicate$4;

abstract class Predicates$ObjectPredicate
extends Enum
implements Predicate {
    public static final /* enum */ Predicates$ObjectPredicate ALWAYS_TRUE = new Predicates$ObjectPredicate$1("ALWAYS_TRUE", 0);
    public static final /* enum */ Predicates$ObjectPredicate ALWAYS_FALSE = new Predicates$ObjectPredicate$2("ALWAYS_FALSE", 1);
    public static final /* enum */ Predicates$ObjectPredicate IS_NULL = new Predicates$ObjectPredicate$3("IS_NULL", 2);
    public static final /* enum */ Predicates$ObjectPredicate NOT_NULL = new Predicates$ObjectPredicate$4("NOT_NULL", 3);
    private static final /* synthetic */ Predicates$ObjectPredicate[] $VALUES;

    public static Predicates$ObjectPredicate[] values() {
        return (Predicates$ObjectPredicate[])$VALUES.clone();
    }

    public static Predicates$ObjectPredicate valueOf(String string) {
        return (Predicates$ObjectPredicate)Enum.valueOf(Predicates$ObjectPredicate.class, string);
    }

    private Predicates$ObjectPredicate() {
        super(string, n2);
    }

    Predicate withNarrowedType() {
        return this;
    }

    /*
     * Exception decompiling
     */
    /* synthetic */ Predicates$ObjectPredicate(Predicates$1 var1) {
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
        $VALUES = new Predicates$ObjectPredicate[]{ALWAYS_TRUE, ALWAYS_FALSE, IS_NULL, NOT_NULL};
    }
}

