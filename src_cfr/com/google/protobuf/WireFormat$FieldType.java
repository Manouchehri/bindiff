/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.WireFormat$1;
import com.google.protobuf.WireFormat$FieldType$1;
import com.google.protobuf.WireFormat$FieldType$2;
import com.google.protobuf.WireFormat$FieldType$3;
import com.google.protobuf.WireFormat$FieldType$4;
import com.google.protobuf.WireFormat$JavaType;

public class WireFormat$FieldType
extends Enum {
    public static final /* enum */ WireFormat$FieldType DOUBLE = new WireFormat$FieldType(WireFormat$JavaType.DOUBLE, 1);
    public static final /* enum */ WireFormat$FieldType FLOAT = new WireFormat$FieldType(WireFormat$JavaType.FLOAT, 5);
    public static final /* enum */ WireFormat$FieldType INT64 = new WireFormat$FieldType(WireFormat$JavaType.LONG, 0);
    public static final /* enum */ WireFormat$FieldType UINT64 = new WireFormat$FieldType(WireFormat$JavaType.LONG, 0);
    public static final /* enum */ WireFormat$FieldType INT32 = new WireFormat$FieldType(WireFormat$JavaType.INT, 0);
    public static final /* enum */ WireFormat$FieldType FIXED64 = new WireFormat$FieldType(WireFormat$JavaType.LONG, 1);
    public static final /* enum */ WireFormat$FieldType FIXED32 = new WireFormat$FieldType(WireFormat$JavaType.INT, 5);
    public static final /* enum */ WireFormat$FieldType BOOL = new WireFormat$FieldType(WireFormat$JavaType.BOOLEAN, 0);
    public static final /* enum */ WireFormat$FieldType STRING = new WireFormat$FieldType$1("STRING", 8, WireFormat$JavaType.STRING, 2);
    public static final /* enum */ WireFormat$FieldType GROUP = new WireFormat$FieldType$2("GROUP", 9, WireFormat$JavaType.MESSAGE, 3);
    public static final /* enum */ WireFormat$FieldType MESSAGE = new WireFormat$FieldType$3("MESSAGE", 10, WireFormat$JavaType.MESSAGE, 2);
    public static final /* enum */ WireFormat$FieldType BYTES = new WireFormat$FieldType$4("BYTES", 11, WireFormat$JavaType.BYTE_STRING, 2);
    public static final /* enum */ WireFormat$FieldType UINT32 = new WireFormat$FieldType(WireFormat$JavaType.INT, 0);
    public static final /* enum */ WireFormat$FieldType ENUM = new WireFormat$FieldType(WireFormat$JavaType.ENUM, 0);
    public static final /* enum */ WireFormat$FieldType SFIXED32 = new WireFormat$FieldType(WireFormat$JavaType.INT, 5);
    public static final /* enum */ WireFormat$FieldType SFIXED64 = new WireFormat$FieldType(WireFormat$JavaType.LONG, 1);
    public static final /* enum */ WireFormat$FieldType SINT32 = new WireFormat$FieldType(WireFormat$JavaType.INT, 0);
    public static final /* enum */ WireFormat$FieldType SINT64 = new WireFormat$FieldType(WireFormat$JavaType.LONG, 0);
    private final WireFormat$JavaType javaType;
    private final int wireType;
    private static final /* synthetic */ WireFormat$FieldType[] $VALUES;

    public static WireFormat$FieldType[] values() {
        return (WireFormat$FieldType[])$VALUES.clone();
    }

    public static WireFormat$FieldType valueOf(String string) {
        return (WireFormat$FieldType)((Object)Enum.valueOf(WireFormat$FieldType.class, string));
    }

    private WireFormat$FieldType(WireFormat$JavaType wireFormat$JavaType, int n3) {
        super(string, n2);
        this.javaType = wireFormat$JavaType;
        this.wireType = n3;
    }

    public WireFormat$JavaType getJavaType() {
        return this.javaType;
    }

    public int getWireType() {
        return this.wireType;
    }

    public boolean isPackable() {
        return true;
    }

    /*
     * Exception decompiling
     */
    /* synthetic */ WireFormat$FieldType(WireFormat$JavaType var1, int var2, WireFormat$1 var3) {
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
        $VALUES = new WireFormat$FieldType[]{DOUBLE, FLOAT, INT64, UINT64, INT32, FIXED64, FIXED32, BOOL, STRING, GROUP, MESSAGE, BYTES, UINT32, ENUM, SFIXED32, SFIXED64, SINT32, SINT64};
    }
}

