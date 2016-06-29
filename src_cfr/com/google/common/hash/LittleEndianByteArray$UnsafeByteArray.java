/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.hash;

import com.google.common.hash.LittleEndianByteArray$1;
import com.google.common.hash.LittleEndianByteArray$LittleEndianBytes;
import com.google.common.hash.LittleEndianByteArray$UnsafeByteArray$1;
import com.google.common.hash.LittleEndianByteArray$UnsafeByteArray$2;
import com.google.common.hash.LittleEndianByteArray$UnsafeByteArray$3;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import sun.misc.Unsafe;

abstract class LittleEndianByteArray$UnsafeByteArray
extends Enum
implements LittleEndianByteArray$LittleEndianBytes {
    public static final /* enum */ LittleEndianByteArray$UnsafeByteArray UNSAFE_LITTLE_ENDIAN = new LittleEndianByteArray$UnsafeByteArray$1("UNSAFE_LITTLE_ENDIAN", 0);
    public static final /* enum */ LittleEndianByteArray$UnsafeByteArray UNSAFE_BIG_ENDIAN = new LittleEndianByteArray$UnsafeByteArray$2("UNSAFE_BIG_ENDIAN", 1);
    private static final Unsafe theUnsafe;
    private static final int BYTE_ARRAY_BASE_OFFSET;
    private static final /* synthetic */ LittleEndianByteArray$UnsafeByteArray[] $VALUES;

    public static LittleEndianByteArray$UnsafeByteArray[] values() {
        return (LittleEndianByteArray$UnsafeByteArray[])$VALUES.clone();
    }

    public static LittleEndianByteArray$UnsafeByteArray valueOf(String string) {
        return (LittleEndianByteArray$UnsafeByteArray)Enum.valueOf(LittleEndianByteArray$UnsafeByteArray.class, string);
    }

    private LittleEndianByteArray$UnsafeByteArray() {
        super(string, n2);
    }

    private static Unsafe getUnsafe() {
        try {
            return Unsafe.getUnsafe();
        }
        catch (SecurityException var0) {
            try {
                return (Unsafe)AccessController.doPrivileged(new LittleEndianByteArray$UnsafeByteArray$3());
            }
            catch (PrivilegedActionException var0_1) {
                throw new RuntimeException("Could not initialize intrinsics", var0_1.getCause());
            }
        }
    }

    /*
     * Exception decompiling
     */
    /* synthetic */ LittleEndianByteArray$UnsafeByteArray(LittleEndianByteArray$1 var1) {
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

    static /* synthetic */ int access$100() {
        return BYTE_ARRAY_BASE_OFFSET;
    }

    static /* synthetic */ Unsafe access$200() {
        return theUnsafe;
    }

    static {
        $VALUES = new LittleEndianByteArray$UnsafeByteArray[]{UNSAFE_LITTLE_ENDIAN, UNSAFE_BIG_ENDIAN};
        theUnsafe = LittleEndianByteArray$UnsafeByteArray.getUnsafe();
        BYTE_ARRAY_BASE_OFFSET = theUnsafe.arrayBaseOffset(byte[].class);
        if (theUnsafe.arrayIndexScale(byte[].class) == 1) return;
        throw new AssertionError();
    }
}

