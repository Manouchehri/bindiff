/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 */
package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.CharMatcher$1;
import com.google.common.base.CharMatcher$And;
import com.google.common.base.CharMatcher$Any;
import com.google.common.base.CharMatcher$AnyOf;
import com.google.common.base.CharMatcher$Ascii;
import com.google.common.base.CharMatcher$BitSetMatcher;
import com.google.common.base.CharMatcher$BreakingWhitespace;
import com.google.common.base.CharMatcher$Digit;
import com.google.common.base.CharMatcher$ForPredicate;
import com.google.common.base.CharMatcher$InRange;
import com.google.common.base.CharMatcher$Invisible;
import com.google.common.base.CharMatcher$Is;
import com.google.common.base.CharMatcher$IsEither;
import com.google.common.base.CharMatcher$IsNot;
import com.google.common.base.CharMatcher$JavaDigit;
import com.google.common.base.CharMatcher$JavaIsoControl;
import com.google.common.base.CharMatcher$JavaLetter;
import com.google.common.base.CharMatcher$JavaLetterOrDigit;
import com.google.common.base.CharMatcher$JavaLowerCase;
import com.google.common.base.CharMatcher$JavaUpperCase;
import com.google.common.base.CharMatcher$Negated;
import com.google.common.base.CharMatcher$None;
import com.google.common.base.CharMatcher$Or;
import com.google.common.base.CharMatcher$SingleWidth;
import com.google.common.base.CharMatcher$Whitespace;
import com.google.common.base.Platform;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.SmallCharMatcher;
import java.util.BitSet;
import javax.annotation.CheckReturnValue;

@Beta
@GwtCompatible(emulated=1)
public abstract class CharMatcher
implements Predicate {
    public static final CharMatcher WHITESPACE = CharMatcher.whitespace();
    public static final CharMatcher BREAKING_WHITESPACE = CharMatcher.breakingWhitespace();
    public static final CharMatcher ASCII = CharMatcher.ascii();
    public static final CharMatcher DIGIT = CharMatcher.digit();
    public static final CharMatcher JAVA_DIGIT = CharMatcher.javaDigit();
    public static final CharMatcher JAVA_LETTER = CharMatcher.javaLetter();
    public static final CharMatcher JAVA_LETTER_OR_DIGIT = CharMatcher.javaLetterOrDigit();
    public static final CharMatcher JAVA_UPPER_CASE = CharMatcher.javaUpperCase();
    public static final CharMatcher JAVA_LOWER_CASE = CharMatcher.javaLowerCase();
    public static final CharMatcher JAVA_ISO_CONTROL = CharMatcher.javaIsoControl();
    public static final CharMatcher INVISIBLE = CharMatcher.invisible();
    public static final CharMatcher SINGLE_WIDTH = CharMatcher.singleWidth();
    public static final CharMatcher ANY = CharMatcher.any();
    public static final CharMatcher NONE = CharMatcher.none();
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

    public static CharMatcher is(char c2) {
        return new CharMatcher$Is(c2);
    }

    public static CharMatcher isNot(char c2) {
        return new CharMatcher$IsNot(c2);
    }

    public static CharMatcher anyOf(CharSequence charSequence) {
        switch (charSequence.length()) {
            case 0: {
                return CharMatcher.none();
            }
            case 1: {
                return CharMatcher.is(charSequence.charAt(0));
            }
            case 2: {
                return CharMatcher.isEither(charSequence.charAt(0), charSequence.charAt(1));
            }
        }
        return new CharMatcher$AnyOf(charSequence);
    }

    public static CharMatcher noneOf(CharSequence charSequence) {
        return CharMatcher.anyOf(charSequence).negate();
    }

    public static CharMatcher inRange(char c2, char c3) {
        return new CharMatcher$InRange(c2, c3);
    }

    public static CharMatcher forPredicate(Predicate predicate) {
        CharMatcher charMatcher;
        if (predicate instanceof CharMatcher) {
            charMatcher = (CharMatcher)predicate;
            return charMatcher;
        }
        charMatcher = new CharMatcher$ForPredicate(predicate);
        return charMatcher;
    }

    protected CharMatcher() {
    }

    public abstract boolean matches(char var1);

    public CharMatcher negate() {
        return new CharMatcher$Negated(this);
    }

    public CharMatcher and(CharMatcher charMatcher) {
        return new CharMatcher$And(this, charMatcher);
    }

    public CharMatcher or(CharMatcher charMatcher) {
        return new CharMatcher$Or(this, charMatcher);
    }

    public CharMatcher precomputed() {
        return Platform.precomputeCharMatcher(this);
    }

    @GwtIncompatible(value="java.util.BitSet")
    CharMatcher precomputedInternal() {
        String string;
        BitSet bitSet = new BitSet();
        this.setBits(bitSet);
        int n2 = bitSet.cardinality();
        if (n2 * 2 <= 65536) {
            return CharMatcher.precomputedPositive(n2, bitSet, this.toString());
        }
        bitSet.flip(0, 65536);
        int n3 = 65536 - n2;
        String string2 = ".negate()";
        String string3 = this.toString();
        if (string3.endsWith(string2)) {
            string = string3.substring(0, string3.length() - string2.length());
        } else {
            String string4 = String.valueOf(string3);
            String string5 = String.valueOf(string2);
            string = string5.length() != 0 ? string4.concat(string5) : new String(string4);
        }
        String string6 = string;
        return new CharMatcher$1(this, CharMatcher.precomputedPositive(n3, bitSet, string6), string3);
    }

    @GwtIncompatible(value="java.util.BitSet")
    private static CharMatcher precomputedPositive(int n2, BitSet bitSet, String string) {
        CharMatcher$BitSetMatcher charMatcher$BitSetMatcher /* !! */ ;
        switch (n2) {
            case 0: {
                return CharMatcher.none();
            }
            case 1: {
                return CharMatcher.is((char)bitSet.nextSetBit(0));
            }
            case 2: {
                char c2 = (char)bitSet.nextSetBit(0);
                char c3 = (char)bitSet.nextSetBit(c2 + '\u0001');
                return CharMatcher.isEither(c2, c3);
            }
        }
        if (CharMatcher.isSmall(n2, bitSet.length())) {
            charMatcher$BitSetMatcher /* !! */  = SmallCharMatcher.from(bitSet, string);
            return charMatcher$BitSetMatcher /* !! */ ;
        }
        charMatcher$BitSetMatcher /* !! */  = new CharMatcher$BitSetMatcher(bitSet, string, null);
        return charMatcher$BitSetMatcher /* !! */ ;
    }

    @GwtIncompatible(value="SmallCharMatcher")
    private static boolean isSmall(int n2, int n3) {
        if (n2 > 1023) return false;
        if (n3 <= n2 * 4 * 16) return false;
        return true;
    }

    @GwtIncompatible(value="java.util.BitSet")
    void setBits(BitSet bitSet) {
        int n2 = 65535;
        while (n2 >= 0) {
            if (this.matches((char)n2)) {
                bitSet.set(n2);
            }
            --n2;
        }
    }

    public boolean matchesAnyOf(CharSequence charSequence) {
        if (this.matchesNoneOf(charSequence)) return false;
        return true;
    }

    public boolean matchesAllOf(CharSequence charSequence) {
        int n2 = charSequence.length() - 1;
        while (n2 >= 0) {
            if (!this.matches(charSequence.charAt(n2))) {
                return false;
            }
            --n2;
        }
        return true;
    }

    public boolean matchesNoneOf(CharSequence charSequence) {
        if (this.indexIn(charSequence) != -1) return false;
        return true;
    }

    public int indexIn(CharSequence charSequence) {
        return this.indexIn(charSequence, 0);
    }

    public int indexIn(CharSequence charSequence, int n2) {
        int n3 = charSequence.length();
        Preconditions.checkPositionIndex(n2, n3);
        int n4 = n2;
        while (n4 < n3) {
            if (this.matches(charSequence.charAt(n4))) {
                return n4;
            }
            ++n4;
        }
        return -1;
    }

    public int lastIndexIn(CharSequence charSequence) {
        int n2 = charSequence.length() - 1;
        while (n2 >= 0) {
            if (this.matches(charSequence.charAt(n2))) {
                return n2;
            }
            --n2;
        }
        return -1;
    }

    public int countIn(CharSequence charSequence) {
        int n2 = 0;
        int n3 = 0;
        while (n3 < charSequence.length()) {
            if (this.matches(charSequence.charAt(n3))) {
                ++n2;
            }
            ++n3;
        }
        return n2;
    }

    @CheckReturnValue
    public String removeFrom(CharSequence charSequence) {
        String string = charSequence.toString();
        int n2 = this.indexIn(string);
        if (n2 == -1) {
            return string;
        }
        char[] arrc = string.toCharArray();
        int n3 = 1;
        block0 : do {
            ++n2;
            do {
                if (n2 == arrc.length) {
                    return new String(arrc, 0, n2 - n3);
                }
                if (this.matches(arrc[n2])) {
                    ++n3;
                    continue block0;
                }
                arrc[n2 - n3] = arrc[n2];
                ++n2;
            } while (true);
            break;
        } while (true);
    }

    @CheckReturnValue
    public String retainFrom(CharSequence charSequence) {
        return this.negate().removeFrom(charSequence);
    }

    @CheckReturnValue
    public String replaceFrom(CharSequence charSequence, char c2) {
        String string = charSequence.toString();
        int n2 = this.indexIn(string);
        if (n2 == -1) {
            return string;
        }
        char[] arrc = string.toCharArray();
        arrc[n2] = c2;
        int n3 = n2 + 1;
        while (n3 < arrc.length) {
            if (this.matches(arrc[n3])) {
                arrc[n3] = c2;
            }
            ++n3;
        }
        return new String(arrc);
    }

    @CheckReturnValue
    public String replaceFrom(CharSequence charSequence, CharSequence charSequence2) {
        int n2 = charSequence2.length();
        if (n2 == 0) {
            return this.removeFrom(charSequence);
        }
        if (n2 == 1) {
            return this.replaceFrom(charSequence, charSequence2.charAt(0));
        }
        String string = charSequence.toString();
        int n3 = this.indexIn(string);
        if (n3 == -1) {
            return string;
        }
        int n4 = string.length();
        StringBuilder stringBuilder = new StringBuilder(n4 * 3 / 2 + 16);
        int n5 = 0;
        do {
            stringBuilder.append(string, n5, n3);
            stringBuilder.append(charSequence2);
            n5 = n3 + 1;
        } while ((n3 = this.indexIn(string, n5)) != -1);
        stringBuilder.append(string, n5, n4);
        return stringBuilder.toString();
    }

    @CheckReturnValue
    public String trimFrom(CharSequence charSequence) {
        int n2;
        int n3 = charSequence.length();
        for (n2 = 0; n2 < n3 && this.matches(charSequence.charAt(n2)); ++n2) {
        }
        int n4 = n3 - 1;
        while (n4 > n2) {
            if (!this.matches(charSequence.charAt(n4))) {
                return charSequence.subSequence(n2, n4 + 1).toString();
            }
            --n4;
        }
        return charSequence.subSequence(n2, n4 + 1).toString();
    }

    @CheckReturnValue
    public String trimLeadingFrom(CharSequence charSequence) {
        int n2 = charSequence.length();
        int n3 = 0;
        while (n3 < n2) {
            if (!this.matches(charSequence.charAt(n3))) {
                return charSequence.subSequence(n3, n2).toString();
            }
            ++n3;
        }
        return "";
    }

    @CheckReturnValue
    public String trimTrailingFrom(CharSequence charSequence) {
        int n2 = charSequence.length();
        int n3 = n2 - 1;
        while (n3 >= 0) {
            if (!this.matches(charSequence.charAt(n3))) {
                return charSequence.subSequence(0, n3 + 1).toString();
            }
            --n3;
        }
        return "";
    }

    /*
     * Unable to fully structure code
     */
    @CheckReturnValue
    public String collapseFrom(CharSequence var1_1, char var2_2) {
        block2 : {
            var3_3 = var1_1.length();
            var4_4 = 0;
            while (var4_4 < var3_3) {
                var5_5 = var1_1.charAt(var4_4);
                if (!this.matches(var5_5)) ** GOTO lbl8
                if (!(var5_5 != var2_2 || var4_4 != var3_3 - 1 && this.matches(var1_1.charAt(var4_4 + 1)))) {
                    ++var4_4;
lbl8: // 2 sources:
                    ++var4_4;
                    continue;
                }
                break block2;
            }
            return var1_1.toString();
        }
        var6_6 = new StringBuilder(var3_3).append(var1_1.subSequence(0, var4_4)).append(var2_2);
        return this.finishCollapseFrom(var1_1, var4_4 + 1, var3_3, var2_2, var6_6, true);
    }

    @CheckReturnValue
    public String trimAndCollapseFrom(CharSequence charSequence, char c2) {
        String string;
        int n2;
        int n3 = charSequence.length();
        int n4 = n3 - 1;
        for (n2 = 0; n2 < n3 && this.matches(charSequence.charAt(n2)); ++n2) {
        }
        while (n4 > n2 && this.matches(charSequence.charAt(n4))) {
            --n4;
        }
        if (n2 == 0 && n4 == n3 - 1) {
            string = this.collapseFrom(charSequence, c2);
            return string;
        }
        string = this.finishCollapseFrom(charSequence, n2, n4 + 1, c2, new StringBuilder(n4 + 1 - n2), false);
        return string;
    }

    private String finishCollapseFrom(CharSequence charSequence, int n2, int n3, char c2, StringBuilder stringBuilder, boolean bl2) {
        int n4 = n2;
        while (n4 < n3) {
            char c3 = charSequence.charAt(n4);
            if (this.matches(c3)) {
                if (!bl2) {
                    stringBuilder.append(c2);
                    bl2 = true;
                }
            } else {
                stringBuilder.append(c3);
                bl2 = false;
            }
            ++n4;
        }
        return stringBuilder.toString();
    }

    @Deprecated
    public boolean apply(Character c2) {
        return this.matches(c2.charValue());
    }

    public String toString() {
        return super.toString();
    }

    private static String showCharacter(char c2) {
        String string = "0123456789ABCDEF";
        char[] arrc = new char[]{'\\', 'u', '\u0000', '\u0000', '\u0000', '\u0000'};
        int n2 = 0;
        while (n2 < 4) {
            arrc[5 - n2] = string.charAt(c2 & 15);
            c2 = (char)(c2 >> 4);
            ++n2;
        }
        return String.copyValueOf(arrc);
    }

    private static CharMatcher$IsEither isEither(char c2, char c3) {
        return new CharMatcher$IsEither(c2, c3);
    }

    static /* synthetic */ String access$100(char c2) {
        return CharMatcher.showCharacter(c2);
    }
}

