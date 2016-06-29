/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.util.concurrent.Service$1;
import com.google.common.util.concurrent.Service$State$1;
import com.google.common.util.concurrent.Service$State$2;
import com.google.common.util.concurrent.Service$State$3;
import com.google.common.util.concurrent.Service$State$4;
import com.google.common.util.concurrent.Service$State$5;
import com.google.common.util.concurrent.Service$State$6;

@Beta
public abstract class Service$State
extends Enum {
    public static final /* enum */ Service$State NEW = new Service$State$1("NEW", 0);
    public static final /* enum */ Service$State STARTING = new Service$State$2("STARTING", 1);
    public static final /* enum */ Service$State RUNNING = new Service$State$3("RUNNING", 2);
    public static final /* enum */ Service$State STOPPING = new Service$State$4("STOPPING", 3);
    public static final /* enum */ Service$State TERMINATED = new Service$State$5("TERMINATED", 4);
    public static final /* enum */ Service$State FAILED = new Service$State$6("FAILED", 5);
    private static final /* synthetic */ Service$State[] $VALUES;

    public static Service$State[] values() {
        return (Service$State[])$VALUES.clone();
    }

    public static Service$State valueOf(String string) {
        return (Service$State)((Object)Enum.valueOf(Service$State.class, string));
    }

    private Service$State() {
        super(string, n2);
    }

    abstract boolean isTerminal();

    /*
     * Exception decompiling
     */
    /* synthetic */ Service$State(Service$1 var1) {
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
        $VALUES = new Service$State[]{NEW, STARTING, RUNNING, STOPPING, TERMINATED, FAILED};
    }
}

