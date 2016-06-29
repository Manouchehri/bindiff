package com.google.common.base;

import javax.annotation.*;
import com.google.common.annotations.*;

@CheckReturnValue
@GwtCompatible
public enum CaseFormat
{
    LOWER_HYPHEN("LOWER_HYPHEN", 0, CharMatcher.is('-'), "-"), 
    LOWER_UNDERSCORE("LOWER_UNDERSCORE", 1, CharMatcher.is('_'), "_"), 
    LOWER_CAMEL("LOWER_CAMEL", 2, CharMatcher.inRange('A', 'Z'), ""), 
    UPPER_CAMEL("UPPER_CAMEL", 3, CharMatcher.inRange('A', 'Z'), ""), 
    UPPER_UNDERSCORE("UPPER_UNDERSCORE", 4, CharMatcher.is('_'), "_");
    
    private final CharMatcher wordBoundary;
    private final String wordSeparator;
    
    private CaseFormat(final String s, final int n, final CharMatcher wordBoundary, final String wordSeparator) {
        this.wordBoundary = wordBoundary;
        this.wordSeparator = wordSeparator;
    }
    
    public final String to(final CaseFormat caseFormat, final String s) {
        Preconditions.checkNotNull(caseFormat);
        Preconditions.checkNotNull(s);
        return (caseFormat == this) ? s : this.convert(caseFormat, s);
    }
    
    String convert(final CaseFormat caseFormat, final String s) {
        StringBuilder sb = null;
        int n = 0;
        int indexIn = -1;
        while ((indexIn = this.wordBoundary.indexIn(s, ++indexIn)) != -1) {
            if (n == 0) {
                sb = new StringBuilder(s.length() + 4 * this.wordSeparator.length());
                sb.append(caseFormat.normalizeFirstWord(s.substring(n, indexIn)));
            }
            else {
                sb.append(caseFormat.normalizeWord(s.substring(n, indexIn)));
            }
            sb.append(caseFormat.wordSeparator);
            n = indexIn + this.wordSeparator.length();
        }
        return (n == 0) ? caseFormat.normalizeFirstWord(s) : sb.append(caseFormat.normalizeWord(s.substring(n))).toString();
    }
    
    @Beta
    public Converter converterTo(final CaseFormat caseFormat) {
        return new CaseFormat$StringConverter(this, caseFormat);
    }
    
    abstract String normalizeWord(final String p0);
    
    private String normalizeFirstWord(final String s) {
        return (this == CaseFormat.LOWER_CAMEL) ? Ascii.toLowerCase(s) : this.normalizeWord(s);
    }
    
    private static String firstCharOnlyToUpper(final String s) {
        return s.isEmpty() ? s : new StringBuilder(s.length()).append(Ascii.toUpperCase(s.charAt(0))).append(Ascii.toLowerCase(s.substring(1))).toString();
    }
}
