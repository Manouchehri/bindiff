/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.cache.RemovalCause$1;
import com.google.common.cache.RemovalCause$2;
import com.google.common.cache.RemovalCause$3;
import com.google.common.cache.RemovalCause$4;
import com.google.common.cache.RemovalCause$5;

@GwtCompatible
public abstract class RemovalCause
extends Enum {
    public static final /* enum */ RemovalCause EXPLICIT = new RemovalCause$1("EXPLICIT", 0);
    public static final /* enum */ RemovalCause REPLACED = new RemovalCause$2("REPLACED", 1);
    public static final /* enum */ RemovalCause COLLECTED = new RemovalCause$3("COLLECTED", 2);
    public static final /* enum */ RemovalCause EXPIRED = new RemovalCause$4("EXPIRED", 3);
    public static final /* enum */ RemovalCause SIZE = new RemovalCause$5("SIZE", 4);
    private static final /* synthetic */ RemovalCause[] $VALUES;

    public static RemovalCause[] values() {
        return (RemovalCause[])$VALUES.clone();
    }

    public static RemovalCause valueOf(String string) {
        return (RemovalCause)((Object)Enum.valueOf(RemovalCause.class, string));
    }

    private RemovalCause() {
        super(string, n2);
    }

    abstract boolean wasEvicted();

    /*
     * Exception decompiling
     */
    /* synthetic */ RemovalCause(RemovalCause$1 var1) {
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
        $VALUES = new RemovalCause[]{EXPLICIT, REPLACED, COLLECTED, EXPIRED, SIZE};
    }
}

