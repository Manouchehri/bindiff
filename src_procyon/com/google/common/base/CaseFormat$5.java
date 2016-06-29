package com.google.common.base;

enum CaseFormat$5
{
    CaseFormat$5(final String s, final int n, final CharMatcher charMatcher, final String s2) {
    }
    
    @Override
    String normalizeWord(final String s) {
        return Ascii.toUpperCase(s);
    }
    
    @Override
    String convert(final CaseFormat caseFormat, final String s) {
        if (caseFormat == CaseFormat$5.LOWER_HYPHEN) {
            return Ascii.toLowerCase(s.replace('_', '-'));
        }
        if (caseFormat == CaseFormat$5.LOWER_UNDERSCORE) {
            return Ascii.toLowerCase(s);
        }
        return super.convert(caseFormat, s);
    }
}
