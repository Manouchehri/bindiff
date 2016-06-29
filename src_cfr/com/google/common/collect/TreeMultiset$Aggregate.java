/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.TreeMultiset$1;
import com.google.common.collect.TreeMultiset$Aggregate$1;
import com.google.common.collect.TreeMultiset$Aggregate$2;
import com.google.common.collect.TreeMultiset$AvlNode;
import javax.annotation.Nullable;

abstract class TreeMultiset$Aggregate
extends Enum {
    public static final /* enum */ TreeMultiset$Aggregate SIZE = new TreeMultiset$Aggregate$1("SIZE", 0);
    public static final /* enum */ TreeMultiset$Aggregate DISTINCT = new TreeMultiset$Aggregate$2("DISTINCT", 1);
    private static final /* synthetic */ TreeMultiset$Aggregate[] $VALUES;

    public static TreeMultiset$Aggregate[] values() {
        return (TreeMultiset$Aggregate[])$VALUES.clone();
    }

    public static TreeMultiset$Aggregate valueOf(String string) {
        return (TreeMultiset$Aggregate)((Object)Enum.valueOf(TreeMultiset$Aggregate.class, string));
    }

    private TreeMultiset$Aggregate() {
        super(string, n2);
    }

    abstract int nodeAggregate(TreeMultiset$AvlNode var1);

    abstract long treeAggregate(@Nullable TreeMultiset$AvlNode var1);

    /*
     * Exception decompiling
     */
    /* synthetic */ TreeMultiset$Aggregate(TreeMultiset$1 var1) {
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
        $VALUES = new TreeMultiset$Aggregate[]{SIZE, DISTINCT};
    }
}

