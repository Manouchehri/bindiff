/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

import com.google.common.base.Predicate;
import com.google.common.io.Files$1;
import com.google.common.io.Files$FilePredicate$1;
import com.google.common.io.Files$FilePredicate$2;

abstract class Files$FilePredicate
extends Enum
implements Predicate {
    public static final /* enum */ Files$FilePredicate IS_DIRECTORY = new Files$FilePredicate$1("IS_DIRECTORY", 0);
    public static final /* enum */ Files$FilePredicate IS_FILE = new Files$FilePredicate$2("IS_FILE", 1);
    private static final /* synthetic */ Files$FilePredicate[] $VALUES;

    public static Files$FilePredicate[] values() {
        return (Files$FilePredicate[])$VALUES.clone();
    }

    public static Files$FilePredicate valueOf(String string) {
        return (Files$FilePredicate)Enum.valueOf(Files$FilePredicate.class, string);
    }

    private Files$FilePredicate() {
        super(string, n2);
    }

    /*
     * Exception decompiling
     */
    /* synthetic */ Files$FilePredicate(Files$1 var1) {
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
        $VALUES = new Files$FilePredicate[]{IS_DIRECTORY, IS_FILE};
    }
}

