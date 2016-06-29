/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.util.concurrent.CycleDetectingLockFactory$1;
import com.google.common.util.concurrent.CycleDetectingLockFactory$Policies$1;
import com.google.common.util.concurrent.CycleDetectingLockFactory$Policies$2;
import com.google.common.util.concurrent.CycleDetectingLockFactory$Policies$3;
import com.google.common.util.concurrent.CycleDetectingLockFactory$Policy;

@Beta
public abstract class CycleDetectingLockFactory$Policies
extends Enum
implements CycleDetectingLockFactory$Policy {
    public static final /* enum */ CycleDetectingLockFactory$Policies THROW = new CycleDetectingLockFactory$Policies$1("THROW", 0);
    public static final /* enum */ CycleDetectingLockFactory$Policies WARN = new CycleDetectingLockFactory$Policies$2("WARN", 1);
    public static final /* enum */ CycleDetectingLockFactory$Policies DISABLED = new CycleDetectingLockFactory$Policies$3("DISABLED", 2);
    private static final /* synthetic */ CycleDetectingLockFactory$Policies[] $VALUES;

    public static CycleDetectingLockFactory$Policies[] values() {
        return (CycleDetectingLockFactory$Policies[])$VALUES.clone();
    }

    public static CycleDetectingLockFactory$Policies valueOf(String string) {
        return (CycleDetectingLockFactory$Policies)Enum.valueOf(CycleDetectingLockFactory$Policies.class, string);
    }

    private CycleDetectingLockFactory$Policies() {
        super(string, n2);
    }

    /*
     * Exception decompiling
     */
    /* synthetic */ CycleDetectingLockFactory$Policies(CycleDetectingLockFactory$1 var1) {
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
        $VALUES = new CycleDetectingLockFactory$Policies[]{THROW, WARN, DISABLED};
    }
}

