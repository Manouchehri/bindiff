/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$1;
import com.google.common.collect.MapMakerInternalMap$EntryFactory$1;
import com.google.common.collect.MapMakerInternalMap$EntryFactory$2;
import com.google.common.collect.MapMakerInternalMap$EntryFactory$3;
import com.google.common.collect.MapMakerInternalMap$EntryFactory$4;
import com.google.common.collect.MapMakerInternalMap$EntryFactory$5;
import com.google.common.collect.MapMakerInternalMap$EntryFactory$6;
import com.google.common.collect.MapMakerInternalMap$EntryFactory$7;
import com.google.common.collect.MapMakerInternalMap$EntryFactory$8;
import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;
import com.google.common.collect.MapMakerInternalMap$Segment;
import com.google.common.collect.MapMakerInternalMap$Strength;
import javax.annotation.Nullable;

abstract class MapMakerInternalMap$EntryFactory
extends Enum {
    public static final /* enum */ MapMakerInternalMap$EntryFactory STRONG = new MapMakerInternalMap$EntryFactory$1("STRONG", 0);
    public static final /* enum */ MapMakerInternalMap$EntryFactory STRONG_EXPIRABLE = new MapMakerInternalMap$EntryFactory$2("STRONG_EXPIRABLE", 1);
    public static final /* enum */ MapMakerInternalMap$EntryFactory STRONG_EVICTABLE = new MapMakerInternalMap$EntryFactory$3("STRONG_EVICTABLE", 2);
    public static final /* enum */ MapMakerInternalMap$EntryFactory STRONG_EXPIRABLE_EVICTABLE = new MapMakerInternalMap$EntryFactory$4("STRONG_EXPIRABLE_EVICTABLE", 3);
    public static final /* enum */ MapMakerInternalMap$EntryFactory WEAK = new MapMakerInternalMap$EntryFactory$5("WEAK", 4);
    public static final /* enum */ MapMakerInternalMap$EntryFactory WEAK_EXPIRABLE = new MapMakerInternalMap$EntryFactory$6("WEAK_EXPIRABLE", 5);
    public static final /* enum */ MapMakerInternalMap$EntryFactory WEAK_EVICTABLE = new MapMakerInternalMap$EntryFactory$7("WEAK_EVICTABLE", 6);
    public static final /* enum */ MapMakerInternalMap$EntryFactory WEAK_EXPIRABLE_EVICTABLE = new MapMakerInternalMap$EntryFactory$8("WEAK_EXPIRABLE_EVICTABLE", 7);
    static final int EXPIRABLE_MASK = 1;
    static final int EVICTABLE_MASK = 2;
    static final MapMakerInternalMap$EntryFactory[][] factories;
    private static final /* synthetic */ MapMakerInternalMap$EntryFactory[] $VALUES;

    public static MapMakerInternalMap$EntryFactory[] values() {
        return (MapMakerInternalMap$EntryFactory[])$VALUES.clone();
    }

    public static MapMakerInternalMap$EntryFactory valueOf(String string) {
        return (MapMakerInternalMap$EntryFactory)((Object)Enum.valueOf(MapMakerInternalMap$EntryFactory.class, string));
    }

    private MapMakerInternalMap$EntryFactory() {
        super(string, n2);
    }

    static MapMakerInternalMap$EntryFactory getFactory(MapMakerInternalMap$Strength mapMakerInternalMap$Strength, boolean bl2, boolean bl3) {
        int n2 = (bl2 ? 1 : 0) | (bl3 ? 2 : 0);
        return factories[mapMakerInternalMap$Strength.ordinal()][n2];
    }

    abstract MapMakerInternalMap$ReferenceEntry newEntry(MapMakerInternalMap$Segment var1, Object var2, int var3, @Nullable MapMakerInternalMap$ReferenceEntry var4);

    MapMakerInternalMap$ReferenceEntry copyEntry(MapMakerInternalMap$Segment mapMakerInternalMap$Segment, MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry, MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry2) {
        return this.newEntry(mapMakerInternalMap$Segment, mapMakerInternalMap$ReferenceEntry.getKey(), mapMakerInternalMap$ReferenceEntry.getHash(), mapMakerInternalMap$ReferenceEntry2);
    }

    void copyExpirableEntry(MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry, MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry2) {
        mapMakerInternalMap$ReferenceEntry2.setExpirationTime(mapMakerInternalMap$ReferenceEntry.getExpirationTime());
        MapMakerInternalMap.connectExpirables(mapMakerInternalMap$ReferenceEntry.getPreviousExpirable(), mapMakerInternalMap$ReferenceEntry2);
        MapMakerInternalMap.connectExpirables(mapMakerInternalMap$ReferenceEntry2, mapMakerInternalMap$ReferenceEntry.getNextExpirable());
        MapMakerInternalMap.nullifyExpirable(mapMakerInternalMap$ReferenceEntry);
    }

    void copyEvictableEntry(MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry, MapMakerInternalMap$ReferenceEntry mapMakerInternalMap$ReferenceEntry2) {
        MapMakerInternalMap.connectEvictables(mapMakerInternalMap$ReferenceEntry.getPreviousEvictable(), mapMakerInternalMap$ReferenceEntry2);
        MapMakerInternalMap.connectEvictables(mapMakerInternalMap$ReferenceEntry2, mapMakerInternalMap$ReferenceEntry.getNextEvictable());
        MapMakerInternalMap.nullifyEvictable(mapMakerInternalMap$ReferenceEntry);
    }

    /*
     * Exception decompiling
     */
    /* synthetic */ MapMakerInternalMap$EntryFactory(MapMakerInternalMap$1 var1) {
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
        $VALUES = new MapMakerInternalMap$EntryFactory[]{STRONG, STRONG_EXPIRABLE, STRONG_EVICTABLE, STRONG_EXPIRABLE_EVICTABLE, WEAK, WEAK_EXPIRABLE, WEAK_EVICTABLE, WEAK_EXPIRABLE_EVICTABLE};
        factories = new MapMakerInternalMap$EntryFactory[][]{{STRONG, STRONG_EXPIRABLE, STRONG_EVICTABLE, STRONG_EXPIRABLE_EVICTABLE}, new MapMakerInternalMap$EntryFactory[0], {WEAK, WEAK_EXPIRABLE, WEAK_EVICTABLE, WEAK_EXPIRABLE_EVICTABLE}};
    }
}

