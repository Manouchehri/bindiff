/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 */
package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Ascii;
import com.google.common.base.CaseFormat$1;
import com.google.common.base.CaseFormat$2;
import com.google.common.base.CaseFormat$3;
import com.google.common.base.CaseFormat$4;
import com.google.common.base.CaseFormat$5;
import com.google.common.base.CaseFormat$StringConverter;
import com.google.common.base.CharMatcher;
import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
@GwtCompatible
public abstract class CaseFormat
extends Enum {
    public static final /* enum */ CaseFormat LOWER_HYPHEN = new CaseFormat$1("LOWER_HYPHEN", 0, CharMatcher.is('-'), "-");
    public static final /* enum */ CaseFormat LOWER_UNDERSCORE = new CaseFormat$2("LOWER_UNDERSCORE", 1, CharMatcher.is('_'), "_");
    public static final /* enum */ CaseFormat LOWER_CAMEL = new CaseFormat$3("LOWER_CAMEL", 2, CharMatcher.inRange('A', 'Z'), "");
    public static final /* enum */ CaseFormat UPPER_CAMEL = new CaseFormat$4("UPPER_CAMEL", 3, CharMatcher.inRange('A', 'Z'), "");
    public static final /* enum */ CaseFormat UPPER_UNDERSCORE = new CaseFormat$5("UPPER_UNDERSCORE", 4, CharMatcher.is('_'), "_");
    private final CharMatcher wordBoundary;
    private final String wordSeparator;
    private static final /* synthetic */ CaseFormat[] $VALUES;

    public static CaseFormat[] values() {
        return (CaseFormat[])$VALUES.clone();
    }

    public static CaseFormat valueOf(String string) {
        return (CaseFormat)((Object)Enum.valueOf(CaseFormat.class, string));
    }

    private CaseFormat(CharMatcher charMatcher, String string2) {
        super(string, n2);
        this.wordBoundary = charMatcher;
        this.wordSeparator = string2;
    }

    public final String to(CaseFormat caseFormat, String string) {
        String string2;
        Preconditions.checkNotNull((Object)caseFormat);
        Preconditions.checkNotNull(string);
        if (caseFormat == this) {
            string2 = string;
            return string2;
        }
        string2 = this.convert(caseFormat, string);
        return string2;
    }

    String convert(CaseFormat caseFormat, String string) {
        String string2;
        StringBuilder stringBuilder = null;
        int n2 = 0;
        int n3 = -1;
        do {
            ++n3;
            if ((n3 = this.wordBoundary.indexIn(string, n3)) == -1) break;
            if (n2 == 0) {
                stringBuilder = new StringBuilder(string.length() + 4 * this.wordSeparator.length());
                stringBuilder.append(caseFormat.normalizeFirstWord(string.substring(n2, n3)));
            } else {
                stringBuilder.append(caseFormat.normalizeWord(string.substring(n2, n3)));
            }
            stringBuilder.append(caseFormat.wordSeparator);
            n2 = n3 + this.wordSeparator.length();
        } while (true);
        if (n2 == 0) {
            string2 = caseFormat.normalizeFirstWord(string);
            return string2;
        }
        string2 = stringBuilder.append(caseFormat.normalizeWord(string.substring(n2))).toString();
        return string2;
    }

    @Beta
    public Converter converterTo(CaseFormat caseFormat) {
        return new CaseFormat$StringConverter(this, caseFormat);
    }

    abstract String normalizeWord(String var1);

    private String normalizeFirstWord(String string) {
        String string2;
        if (this == LOWER_CAMEL) {
            string2 = Ascii.toLowerCase(string);
            return string2;
        }
        string2 = this.normalizeWord(string);
        return string2;
    }

    private static String firstCharOnlyToUpper(String string) {
        String string2;
        if (string.isEmpty()) {
            string2 = string;
            return string2;
        }
        string2 = new StringBuilder(string.length()).append(Ascii.toUpperCase(string.charAt(0))).append(Ascii.toLowerCase(string.substring(1))).toString();
        return string2;
    }

    /*
     * Exception decompiling
     */
    /* synthetic */ CaseFormat(CharMatcher var1, String var2, CaseFormat$1 var3) {
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

    static /* synthetic */ String access$100(String string) {
        return CaseFormat.firstCharOnlyToUpper(string);
    }

    static {
        $VALUES = new CaseFormat[]{LOWER_HYPHEN, LOWER_UNDERSCORE, LOWER_CAMEL, UPPER_CAMEL, UPPER_UNDERSCORE};
    }
}

