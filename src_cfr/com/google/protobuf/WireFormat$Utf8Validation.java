/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.WireFormat$1;
import com.google.protobuf.WireFormat$Utf8Validation$1;
import com.google.protobuf.WireFormat$Utf8Validation$2;
import com.google.protobuf.WireFormat$Utf8Validation$3;

abstract class WireFormat$Utf8Validation
extends Enum {
    public static final /* enum */ WireFormat$Utf8Validation LOOSE = new WireFormat$Utf8Validation$1("LOOSE", 0);
    public static final /* enum */ WireFormat$Utf8Validation STRICT = new WireFormat$Utf8Validation$2("STRICT", 1);
    public static final /* enum */ WireFormat$Utf8Validation LAZY = new WireFormat$Utf8Validation$3("LAZY", 2);
    private static final /* synthetic */ WireFormat$Utf8Validation[] $VALUES;

    public static WireFormat$Utf8Validation[] values() {
        return (WireFormat$Utf8Validation[])$VALUES.clone();
    }

    public static WireFormat$Utf8Validation valueOf(String string) {
        return (WireFormat$Utf8Validation)((Object)Enum.valueOf(WireFormat$Utf8Validation.class, string));
    }

    private WireFormat$Utf8Validation() {
        super(string, n2);
    }

    abstract Object readString(CodedInputStream var1);

    /*
     * Exception decompiling
     */
    /* synthetic */ WireFormat$Utf8Validation(WireFormat$1 var1) {
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
        $VALUES = new WireFormat$Utf8Validation[]{LOOSE, STRICT, LAZY};
    }
}

