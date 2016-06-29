package com.google.common.base;

enum CaseFormat$2
{
    CaseFormat$2(final String s, final int n, final CharMatcher charMatcher, final String s2) {
    }
    
    @Override
    String normalizeWord(final String s) {
        return Ascii.toLowerCase(s);
    }
    
    @Override
    String convert(final CaseFormat caseFormat, final String s) {
        if (caseFormat == CaseFormat$2.LOWER_HYPHEN) {
            return s.replace('_', '-');
        }
        if (caseFormat == CaseFormat$2.UPPER_UNDERSCORE) {
            return Ascii.toUpperCase(s);
        }
        return super.convert(caseFormat, s);
    }
}
