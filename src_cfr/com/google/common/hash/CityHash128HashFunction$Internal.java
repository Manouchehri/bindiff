/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.hash;

import com.google.common.hash.CityHash128HashFunction$1;
import com.google.common.hash.CityHash128HashFunction$Internal$1;
import com.google.common.hash.CityHash128HashFunction$Internal$2;
import com.google.common.hash.CityHash128HashFunction$InternalImplementation;
import com.google.common.hash.HashCode;
import com.google.common.hash.LittleEndianByteArray;
import javax.annotation.Nullable;

abstract class CityHash128HashFunction$Internal
extends Enum
implements CityHash128HashFunction$InternalImplementation {
    public static final /* enum */ CityHash128HashFunction$Internal UsingUnsafe = new CityHash128HashFunction$Internal$1("UsingUnsafe", 0);
    public static final /* enum */ CityHash128HashFunction$Internal UsingByteBuffer = new CityHash128HashFunction$Internal$2("UsingByteBuffer", 1);
    private static final /* synthetic */ CityHash128HashFunction$Internal[] $VALUES;

    public static CityHash128HashFunction$Internal[] values() {
        return (CityHash128HashFunction$Internal[])$VALUES.clone();
    }

    public static CityHash128HashFunction$Internal valueOf(String string) {
        return (CityHash128HashFunction$Internal)Enum.valueOf(CityHash128HashFunction$Internal.class, string);
    }

    private CityHash128HashFunction$Internal() {
        super(string, n2);
    }

    protected abstract HashCode fingerprint(byte[] var1, int var2, int var3, long var4, long var6);

    @Override
    public HashCode fingerprint(byte[] arrby, int n2, int n3, @Nullable long[] arrl) {
        long l2;
        long l3;
        if (arrl != null) {
            l3 = arrl[0];
            l2 = arrl[1];
            return this.fingerprint(arrby, n2, n3, l2, l3);
        }
        if (n3 >= 16) {
            l3 = LittleEndianByteArray.load64(arrby, n2) ^ -4102945252841444853L;
            l2 = LittleEndianByteArray.load64(arrby, n2 + 8);
            return this.fingerprint(arrby, n2 += 16, n3 -= 16, l2, l3);
        }
        if (n3 >= 8) {
            l3 = LittleEndianByteArray.load64(arrby, n2) ^ (long)n3 * -6505348102511208375L;
            l2 = LittleEndianByteArray.load64(arrby, n3 - 8) ^ -8261664234251669945L;
            n3 = 0;
            return this.fingerprint(arrby, n2, n3, l2, l3);
        }
        l3 = -6505348102511208375L;
        l2 = -8261664234251669945L;
        return this.fingerprint(arrby, n2, n3, l2, l3);
    }

    /*
     * Exception decompiling
     */
    /* synthetic */ CityHash128HashFunction$Internal(CityHash128HashFunction$1 var1) {
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
        $VALUES = new CityHash128HashFunction$Internal[]{UsingUnsafe, UsingByteBuffer};
    }
}

