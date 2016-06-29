/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.collect;

import com.google.common.base.Equivalence;
import com.google.common.collect.MapMakerInternalMap$1;
import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap$Segment;
import com.google.common.collect.MapMakerInternalMap$Strength$1;
import com.google.common.collect.MapMakerInternalMap$Strength$2;
import com.google.common.collect.MapMakerInternalMap$Strength$3;
import com.google.common.collect.MapMakerInternalMap$ValueReference;

abstract class MapMakerInternalMap$Strength
extends Enum {
    public static final /* enum */ MapMakerInternalMap$Strength STRONG = new MapMakerInternalMap$Strength$1("STRONG", 0);
    public static final /* enum */ MapMakerInternalMap$Strength SOFT = new MapMakerInternalMap$Strength$2("SOFT", 1);
    public static final /* enum */ MapMakerInternalMap$Strength WEAK = new MapMakerInternalMap$Strength$3("WEAK", 2);
    private static final /* synthetic */ MapMakerInternalMap$Strength[] $VALUES;

    public static MapMakerInternalMap$Strength[] values() {
        return (MapMakerInternalMap$Strength[])$VALUES.clone();
    }

    public static MapMakerInternalMap$Strength valueOf(String string) {
        return (MapMakerInternalMap$Strength)((Object)Enum.valueOf(MapMakerInternalMap$Strength.class, string));
    }

    private MapMakerInternalMap$Strength() {
        super(string, n2);
    }

    abstract MapMakerInternalMap$ValueReference referenceValue(MapMakerInternalMap$Segment var1, MapMakerInternalMap$ReferenceEntry var2, Object var3);

    abstract Equivalence defaultEquivalence();

    /*
     * Exception decompiling
     */
    /* synthetic */ MapMakerInternalMap$Strength(MapMakerInternalMap$1 var1) {
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
        $VALUES = new MapMakerInternalMap$Strength[]{STRONG, SOFT, WEAK};
    }
}

