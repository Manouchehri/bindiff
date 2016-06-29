/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$1;
import com.google.common.cache.LocalCache$EntryFactory$1;
import com.google.common.cache.LocalCache$EntryFactory$2;
import com.google.common.cache.LocalCache$EntryFactory$3;
import com.google.common.cache.LocalCache$EntryFactory$4;
import com.google.common.cache.LocalCache$EntryFactory$5;
import com.google.common.cache.LocalCache$EntryFactory$6;
import com.google.common.cache.LocalCache$EntryFactory$7;
import com.google.common.cache.LocalCache$EntryFactory$8;
import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.cache.LocalCache$Segment;
import com.google.common.cache.LocalCache$Strength;
import javax.annotation.Nullable;

abstract class LocalCache$EntryFactory
extends Enum {
    public static final /* enum */ LocalCache$EntryFactory STRONG = new LocalCache$EntryFactory$1("STRONG", 0);
    public static final /* enum */ LocalCache$EntryFactory STRONG_ACCESS = new LocalCache$EntryFactory$2("STRONG_ACCESS", 1);
    public static final /* enum */ LocalCache$EntryFactory STRONG_WRITE = new LocalCache$EntryFactory$3("STRONG_WRITE", 2);
    public static final /* enum */ LocalCache$EntryFactory STRONG_ACCESS_WRITE = new LocalCache$EntryFactory$4("STRONG_ACCESS_WRITE", 3);
    public static final /* enum */ LocalCache$EntryFactory WEAK = new LocalCache$EntryFactory$5("WEAK", 4);
    public static final /* enum */ LocalCache$EntryFactory WEAK_ACCESS = new LocalCache$EntryFactory$6("WEAK_ACCESS", 5);
    public static final /* enum */ LocalCache$EntryFactory WEAK_WRITE = new LocalCache$EntryFactory$7("WEAK_WRITE", 6);
    public static final /* enum */ LocalCache$EntryFactory WEAK_ACCESS_WRITE = new LocalCache$EntryFactory$8("WEAK_ACCESS_WRITE", 7);
    static final int ACCESS_MASK = 1;
    static final int WRITE_MASK = 2;
    static final int WEAK_MASK = 4;
    static final LocalCache$EntryFactory[] factories;
    private static final /* synthetic */ LocalCache$EntryFactory[] $VALUES;

    public static LocalCache$EntryFactory[] values() {
        return (LocalCache$EntryFactory[])$VALUES.clone();
    }

    public static LocalCache$EntryFactory valueOf(String string) {
        return (LocalCache$EntryFactory)((Object)Enum.valueOf(LocalCache$EntryFactory.class, string));
    }

    private LocalCache$EntryFactory() {
        super(string, n2);
    }

    static LocalCache$EntryFactory getFactory(LocalCache$Strength localCache$Strength, boolean bl2, boolean bl3) {
        int n2 = (localCache$Strength == LocalCache$Strength.WEAK ? 4 : 0) | (bl2 ? 1 : 0) | (bl3 ? 2 : 0);
        return factories[n2];
    }

    abstract LocalCache$ReferenceEntry newEntry(LocalCache$Segment var1, Object var2, int var3, @Nullable LocalCache$ReferenceEntry var4);

    LocalCache$ReferenceEntry copyEntry(LocalCache$Segment localCache$Segment, LocalCache$ReferenceEntry localCache$ReferenceEntry, LocalCache$ReferenceEntry localCache$ReferenceEntry2) {
        return this.newEntry(localCache$Segment, localCache$ReferenceEntry.getKey(), localCache$ReferenceEntry.getHash(), localCache$ReferenceEntry2);
    }

    void copyAccessEntry(LocalCache$ReferenceEntry localCache$ReferenceEntry, LocalCache$ReferenceEntry localCache$ReferenceEntry2) {
        localCache$ReferenceEntry2.setAccessTime(localCache$ReferenceEntry.getAccessTime());
        LocalCache.connectAccessOrder(localCache$ReferenceEntry.getPreviousInAccessQueue(), localCache$ReferenceEntry2);
        LocalCache.connectAccessOrder(localCache$ReferenceEntry2, localCache$ReferenceEntry.getNextInAccessQueue());
        LocalCache.nullifyAccessOrder(localCache$ReferenceEntry);
    }

    void copyWriteEntry(LocalCache$ReferenceEntry localCache$ReferenceEntry, LocalCache$ReferenceEntry localCache$ReferenceEntry2) {
        localCache$ReferenceEntry2.setWriteTime(localCache$ReferenceEntry.getWriteTime());
        LocalCache.connectWriteOrder(localCache$ReferenceEntry.getPreviousInWriteQueue(), localCache$ReferenceEntry2);
        LocalCache.connectWriteOrder(localCache$ReferenceEntry2, localCache$ReferenceEntry.getNextInWriteQueue());
        LocalCache.nullifyWriteOrder(localCache$ReferenceEntry);
    }

    /*
     * Exception decompiling
     */
    /* synthetic */ LocalCache$EntryFactory(LocalCache$1 var1) {
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
        $VALUES = new LocalCache$EntryFactory[]{STRONG, STRONG_ACCESS, STRONG_WRITE, STRONG_ACCESS_WRITE, WEAK, WEAK_ACCESS, WEAK_WRITE, WEAK_ACCESS_WRITE};
        factories = new LocalCache$EntryFactory[]{STRONG, STRONG_ACCESS, STRONG_WRITE, STRONG_ACCESS_WRITE, WEAK, WEAK_ACCESS, WEAK_WRITE, WEAK_ACCESS_WRITE};
    }
}

