package com.google.common.base;

enum CaseFormat$1
{
    CaseFormat$1(final String s, final int n, final CharMatcher charMatcher, final String s2) {
    }
    
    @Override
    String normalizeWord(final String s) {
        return Ascii.toLowerCase(s);
    }
    
    @Override
    String convert(final CaseFormat caseFormat, final String s) {
        if (caseFormat == CaseFormat$1.LOWER_UNDERSCORE) {
            return s.replace('-', '_');
        }
        if (caseFormat == CaseFormat$1.UPPER_UNDERSCORE) {
            return Ascii.toUpperCase(s.replace('-', '_'));
        }
        return super.convert(caseFormat, s);
    }
}
