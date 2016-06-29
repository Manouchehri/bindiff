package com.google.common.base;

import java.util.*;
import com.google.common.annotations.*;
import javax.annotation.*;

@Beta
@GwtCompatible(emulated = true)
public abstract class CharMatcher implements Predicate
{
    public static final CharMatcher WHITESPACE;
    public static final CharMatcher BREAKING_WHITESPACE;
    public static final CharMatcher ASCII;
    public static final CharMatcher DIGIT;
    public static final CharMatcher JAVA_DIGIT;
    public static final CharMatcher JAVA_LETTER;
    public static final CharMatcher JAVA_LETTER_OR_DIGIT;
    public static final CharMatcher JAVA_UPPER_CASE;
    public static final CharMatcher JAVA_LOWER_CASE;
    public static final CharMatcher JAVA_ISO_CONTROL;
    public static final CharMatcher INVISIBLE;
    public static final CharMatcher SINGLE_WIDTH;
    public static final CharMatcher ANY;
    public static final CharMatcher NONE;
    private static final int DISTINCT_CHARS = 65536;
    
    public static CharMatcher any() {
        return CharMatcher$Any.INSTANCE;
    }
    
    public static CharMatcher none() {
        return CharMatcher$None.INSTANCE;
    }
    
    public static CharMatcher whitespace() {
        return CharMatcher$Whitespace.INSTANCE;
    }
    
    public static CharMatcher breakingWhitespace() {
        return CharMatcher$BreakingWhitespace.INSTANCE;
    }
    
    public static CharMatcher ascii() {
        return CharMatcher$Ascii.INSTANCE;
    }
    
    public static CharMatcher digit() {
        return CharMatcher$Digit.INSTANCE;
    }
    
    public static CharMatcher javaDigit() {
        return CharMatcher$JavaDigit.INSTANCE;
    }
    
    public static CharMatcher javaLetter() {
        return CharMatcher$JavaLetter.INSTANCE;
    }
    
    public static CharMatcher javaLetterOrDigit() {
        return CharMatcher$JavaLetterOrDigit.INSTANCE;
    }
    
    public static CharMatcher javaUpperCase() {
        return CharMatcher$JavaUpperCase.INSTANCE;
    }
    
    public static CharMatcher javaLowerCase() {
        return CharMatcher$JavaLowerCase.INSTANCE;
    }
    
    public static CharMatcher javaIsoControl() {
        return CharMatcher$JavaIsoControl.INSTANCE;
    }
    
    public static CharMatcher invisible() {
        return CharMatcher$Invisible.INSTANCE;
    }
    
    public static CharMatcher singleWidth() {
        return CharMatcher$SingleWidth.INSTANCE;
    }
    
    public static CharMatcher is(final char c) {
        return new CharMatcher$Is(c);
    }
    
    public static CharMatcher isNot(final char c) {
        return new CharMatcher$IsNot(c);
    }
    
    public static CharMatcher anyOf(final CharSequence charSequence) {
        switch (charSequence.length()) {
            case 0: {
                return none();
            }
            case 1: {
                return is(charSequence.charAt(0));
            }
            case 2: {
                return isEither(charSequence.charAt(0), charSequence.charAt(1));
            }
            default: {
                return new CharMatcher$AnyOf(charSequence);
            }
        }
    }
    
    public static CharMatcher noneOf(final CharSequence charSequence) {
        return anyOf(charSequence).negate();
    }
    
    public static CharMatcher inRange(final char c, final char c2) {
        return new CharMatcher$InRange(c, c2);
    }
    
    public static CharMatcher forPredicate(final Predicate predicate) {
        return (predicate instanceof CharMatcher) ? ((CharMatcher)predicate) : new CharMatcher$ForPredicate(predicate);
    }
    
    public abstract boolean matches(final char p0);
    
    public CharMatcher negate() {
        return new CharMatcher$Negated(this);
    }
    
    public CharMatcher and(final CharMatcher charMatcher) {
        return new CharMatcher$And(this, charMatcher);
    }
    
    public CharMatcher or(final CharMatcher charMatcher) {
        return new CharMatcher$Or(this, charMatcher);
    }
    
    public CharMatcher precomputed() {
        return Platform.precomputeCharMatcher(this);
    }
    
    @GwtIncompatible("java.util.BitSet")
    CharMatcher precomputedInternal() {
        final BitSet bits = new BitSet();
        this.setBits(bits);
        final int cardinality = bits.cardinality();
        if (cardinality * 2 <= 65536) {
            return precomputedPositive(cardinality, bits, this.toString());
        }
        bits.flip(0, 65536);
        final int n = 65536 - cardinality;
        final String s = ".negate()";
        final String string = this.toString();
        String substring;
        if (string.endsWith(s)) {
            substring = string.substring(0, string.length() - s.length());
        }
        else {
            final String value = String.valueOf(string);
            final String value2 = String.valueOf(s);
            substring = ((value2.length() != 0) ? value.concat(value2) : new String(value));
        }
        return new CharMatcher$1(this, precomputedPositive(n, bits, substring), string);
    }
    
    @GwtIncompatible("java.util.BitSet")
    private static CharMatcher precomputedPositive(final int n, final BitSet set, final String s) {
        switch (n) {
            case 0: {
                return none();
            }
            case 1: {
                return is((char)set.nextSetBit(0));
            }
            case 2: {
                final char c = (char)set.nextSetBit(0);
                return isEither(c, (char)set.nextSetBit(c + '\u0001'));
            }
            default: {
                return isSmall(n, set.length()) ? SmallCharMatcher.from(set, s) : new CharMatcher$BitSetMatcher(set, s, null);
            }
        }
    }
    
    @GwtIncompatible("SmallCharMatcher")
    private static boolean isSmall(final int n, final int n2) {
        return n <= 1023 && n2 > n * 4 * 16;
    }
    
    @GwtIncompatible("java.util.BitSet")
    void setBits(final BitSet set) {
        for (int i = 65535; i >= 0; --i) {
            if (this.matches((char)i)) {
                set.set(i);
            }
        }
    }
    
    public boolean matchesAnyOf(final CharSequence charSequence) {
        return !this.matchesNoneOf(charSequence);
    }
    
    public boolean matchesAllOf(final CharSequence charSequence) {
        for (int i = charSequence.length() - 1; i >= 0; --i) {
            if (!this.matches(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
    public boolean matchesNoneOf(final CharSequence charSequence) {
        return this.indexIn(charSequence) == -1;
    }
    
    public int indexIn(final CharSequence charSequence) {
        return this.indexIn(charSequence, 0);
    }
    
    public int indexIn(final CharSequence charSequence, final int n) {
        final int length = charSequence.length();
        Preconditions.checkPositionIndex(n, length);
        for (int i = n; i < length; ++i) {
            if (this.matches(charSequence.charAt(i))) {
                return i;
            }
        }
        return -1;
    }
    
    public int lastIndexIn(final CharSequence charSequence) {
        for (int i = charSequence.length() - 1; i >= 0; --i) {
            if (this.matches(charSequence.charAt(i))) {
                return i;
            }
        }
        return -1;
    }
    
    public int countIn(final CharSequence charSequence) {
        int n = 0;
        for (int i = 0; i < charSequence.length(); ++i) {
            if (this.matches(charSequence.charAt(i))) {
                ++n;
            }
        }
        return n;
    }
    
    @CheckReturnValue
    public String removeFrom(final CharSequence charSequence) {
        final String string = charSequence.toString();
        int i = this.indexIn(string);
        if (i == -1) {
            return string;
        }
        final char[] charArray = string.toCharArray();
        int n = 1;
    Label_0029:
        while (true) {
            ++i;
            while (i != charArray.length) {
                if (this.matches(charArray[i])) {
                    ++n;
                    continue Label_0029;
                }
                charArray[i - n] = charArray[i];
                ++i;
            }
            break;
        }
        return new String(charArray, 0, i - n);
    }
    
    @CheckReturnValue
    public String retainFrom(final CharSequence charSequence) {
        return this.negate().removeFrom(charSequence);
    }
    
    @CheckReturnValue
    public String replaceFrom(final CharSequence charSequence, final char c) {
        final String string = charSequence.toString();
        final int indexIn = this.indexIn(string);
        if (indexIn == -1) {
            return string;
        }
        final char[] charArray = string.toCharArray();
        charArray[indexIn] = c;
        for (int i = indexIn + 1; i < charArray.length; ++i) {
            if (this.matches(charArray[i])) {
                charArray[i] = c;
            }
        }
        return new String(charArray);
    }
    
    @CheckReturnValue
    public String replaceFrom(final CharSequence charSequence, final CharSequence charSequence2) {
        final int length = charSequence2.length();
        if (length == 0) {
            return this.removeFrom(charSequence);
        }
        if (length == 1) {
            return this.replaceFrom(charSequence, charSequence2.charAt(0));
        }
        final String string = charSequence.toString();
        int i = this.indexIn(string);
        if (i == -1) {
            return string;
        }
        final int length2 = string.length();
        final StringBuilder sb = new StringBuilder(length2 * 3 / 2 + 16);
        int n = 0;
        do {
            sb.append(string, n, i);
            sb.append(charSequence2);
            n = i + 1;
            i = this.indexIn(string, n);
        } while (i != -1);
        sb.append(string, n, length2);
        return sb.toString();
    }
    
    @CheckReturnValue
    public String trimFrom(final CharSequence charSequence) {
        int length;
        int n;
        for (length = charSequence.length(), n = 0; n < length && this.matches(charSequence.charAt(n)); ++n) {}
        int n2;
        for (n2 = length - 1; n2 > n && this.matches(charSequence.charAt(n2)); --n2) {}
        return charSequence.subSequence(n, n2 + 1).toString();
    }
    
    @CheckReturnValue
    public String trimLeadingFrom(final CharSequence charSequence) {
        for (int length = charSequence.length(), i = 0; i < length; ++i) {
            if (!this.matches(charSequence.charAt(i))) {
                return charSequence.subSequence(i, length).toString();
            }
        }
        return "";
    }
    
    @CheckReturnValue
    public String trimTrailingFrom(final CharSequence charSequence) {
        for (int i = charSequence.length() - 1; i >= 0; --i) {
            if (!this.matches(charSequence.charAt(i))) {
                return charSequence.subSequence(0, i + 1).toString();
            }
        }
        return "";
    }
    
    @CheckReturnValue
    public String collapseFrom(final CharSequence charSequence, final char c) {
        for (int length = charSequence.length(), i = 0; i < length; ++i) {
            final char char1 = charSequence.charAt(i);
            if (this.matches(char1)) {
                if (char1 != c || (i != length - 1 && this.matches(charSequence.charAt(i + 1)))) {
                    return this.finishCollapseFrom(charSequence, i + 1, length, c, new StringBuilder(length).append(charSequence.subSequence(0, i)).append(c), true);
                }
                ++i;
            }
        }
        return charSequence.toString();
    }
    
    @CheckReturnValue
    public String trimAndCollapseFrom(final CharSequence charSequence, final char c) {
        final int length = charSequence.length();
        int n = 0;
        int n2 = length - 1;
        while (n < length && this.matches(charSequence.charAt(n))) {
            ++n;
        }
        while (n2 > n && this.matches(charSequence.charAt(n2))) {
            --n2;
        }
        return (n == 0 && n2 == length - 1) ? this.collapseFrom(charSequence, c) : this.finishCollapseFrom(charSequence, n, n2 + 1, c, new StringBuilder(n2 + 1 - n), false);
    }
    
    private String finishCollapseFrom(final CharSequence charSequence, final int n, final int n2, final char c, final StringBuilder sb, boolean b) {
        for (int i = n; i < n2; ++i) {
            final char char1 = charSequence.charAt(i);
            if (this.matches(char1)) {
                if (!b) {
                    sb.append(c);
                    b = true;
                }
            }
            else {
                sb.append(char1);
                b = false;
            }
        }
        return sb.toString();
    }
    
    @Deprecated
    public boolean apply(final Character c) {
        return this.matches(c);
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
    
    private static String showCharacter(char c) {
        final String s = "0123456789ABCDEF";
        final char[] array = { '\\', 'u', '\0', '\0', '\0', '\0' };
        for (int i = 0; i < 4; ++i) {
            array[5 - i] = s.charAt(c & '\u000f');
            c >>= 4;
        }
        return String.copyValueOf(array);
    }
    
    private static CharMatcher$IsEither isEither(final char c, final char c2) {
        return new CharMatcher$IsEither(c, c2);
    }
    
    static {
        WHITESPACE = whitespace();
        BREAKING_WHITESPACE = breakingWhitespace();
        ASCII = ascii();
        DIGIT = digit();
        JAVA_DIGIT = javaDigit();
        JAVA_LETTER = javaLetter();
        JAVA_LETTER_OR_DIGIT = javaLetterOrDigit();
        JAVA_UPPER_CASE = javaUpperCase();
        JAVA_LOWER_CASE = javaLowerCase();
        JAVA_ISO_CONTROL = javaIsoControl();
        INVISIBLE = invisible();
        SINGLE_WIDTH = singleWidth();
        ANY = any();
        NONE = none();
    }
}
