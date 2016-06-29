/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.base.StringUtil$CharEscaper;
import com.google.common.base.StringUtil$CharEscaperBuilder;
import com.google.common.base.StringUtil$CodePointSet;
import com.google.common.base.StringUtil$CodePointSet$Builder;
import com.google.common.base.StringUtil$JsEscapingMode;
import com.google.common.base.Strings;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

@GoogleInternal
public final class StringUtil {
    private static final Splitter NEWLINE_SPLITTER = Splitter.on('\n').omitEmptyStrings();
    private static final Splitter TO_WORDS = Splitter.on(CharMatcher.BREAKING_WHITESPACE).omitEmptyStrings();
    private static final CharMatcher FANCY_SINGLE_QUOTE = CharMatcher.anyOf("\u0091\u0092\u2018\u2019");
    private static final CharMatcher FANCY_DOUBLE_QUOTE = CharMatcher.anyOf("\u0093\u0094\u201c\u201d");
    private static final Map ESCAPE_STRINGS;
    private static final CharMatcher HEX_LETTER;
    private static final StringUtil$CharEscaper LT_GT_ESCAPE;
    private static final Pattern HTML_TAG_PATTERN;
    private static final Pattern CHARACTER_REFERENCE_PATTERN;
    private static final Set CJK_BLOCKS;
    private static final char[] hexChars;
    private static final char[] octalChars;
    private static final StringUtil$CodePointSet JS_ESCAPE_CHARS;
    private static final StringUtil$CodePointSet JSON_ESCAPE_CHARS;
    private static final StringUtil$CodePointSet JSON_OR_JS_ESCAPE_CHARS;

    private StringUtil() {
    }

    public static boolean isEmptyOrWhitespace(@Nullable String string) {
        if (string == null) return true;
        if (CharMatcher.WHITESPACE.matchesAllOf(string)) return true;
        return false;
    }

    @Nullable
    public static String toNullIfEmptyOrWhitespace(@Nullable String string) {
        if (StringUtil.isEmptyOrWhitespace(string)) {
            return null;
        }
        String string2 = string;
        return string2;
    }

    public static String fixedWidth(String string, int n2) {
        ArrayList<String> arrayList = new ArrayList<String>();
        String[] arrstring = NEWLINE_SPLITTER.split(string).iterator();
        do {
            if (!arrstring.hasNext()) {
                arrstring = arrayList.toArray(new String[0]);
                return StringUtil.fixedWidth(arrstring, n2);
            }
            String string2 = (String)arrstring.next();
            arrayList.add(string2);
        } while (true);
    }

    @VisibleForTesting
    static String fixedWidth(String[] arrstring, int n2) {
        ArrayList<String> arrayList = new ArrayList<String>();
        String[] arrstring2 = arrstring;
        int n3 = arrstring2.length;
        int n4 = 0;
        while (n4 < n3) {
            String string = arrstring2[n4];
            arrayList.add(StringUtil.formatLineToFixedWidth(string, n2));
            ++n4;
        }
        return Joiner.on('\n').join(arrayList);
    }

    private static String formatLineToFixedWidth(String string, int n2) {
        if (string.length() <= n2) {
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int n3 = 0;
        Iterator iterator = TO_WORDS.split(string).iterator();
        while (iterator.hasNext()) {
            String string2 = (String)iterator.next();
            if (n3 == 0) {
                n3 = string2.length();
            } else {
                int n4 = n3 + string2.length() + 1;
                if (n4 <= n2) {
                    stringBuilder.append(' ');
                    n3 = n4;
                } else {
                    stringBuilder.append('\n');
                    n3 = string2.length();
                }
            }
            stringBuilder.append(string2);
        }
        return stringBuilder.toString();
    }

    public static String indent(String string, int n2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n");
        int n3 = 0;
        while (n3 < n2) {
            stringBuilder.append("  ");
            ++n3;
        }
        return string.replace("\n", stringBuilder.toString());
    }

    @Nullable
    public static String stripPrefix(String string, String string2) {
        if (!string.startsWith(string2)) return null;
        String string3 = string.substring(string2.length());
        return string3;
    }

    @Nullable
    public static String stripPrefixIgnoreCase(String string, String string2) {
        if (!StringUtil.startsWithIgnoreCase(string, string2)) return null;
        String string3 = string.substring(string2.length());
        return string3;
    }

    @Nullable
    public static String stripSuffix(String string, String string2) {
        if (!string.endsWith(string2)) return null;
        String string3 = string.substring(0, string.length() - string2.length());
        return string3;
    }

    @Nullable
    public static String stripSuffixIgnoreCase(String string, String string2) {
        if (!StringUtil.endsWithIgnoreCase(string, string2)) return null;
        String string3 = string.substring(0, string.length() - string2.length());
        return string3;
    }

    public static String replaceSmartQuotes(String string) {
        String string2 = FANCY_SINGLE_QUOTE.replaceFrom((CharSequence)string, '\'');
        return FANCY_DOUBLE_QUOTE.replaceFrom((CharSequence)string2, '\"');
    }

    @Deprecated
    public static byte[] hexToBytes(CharSequence charSequence) {
        byte[] arrby = new byte[(charSequence.length() + 1) / 2];
        if (charSequence.length() == 0) {
            return arrby;
        }
        arrby[0] = 0;
        int n2 = charSequence.length() % 2;
        int n3 = 0;
        while (n3 < charSequence.length()) {
            char c2 = charSequence.charAt(n3);
            if (n2 % 2 == 0) {
                arrby[n2 >> 1] = (byte)(StringUtil.hexValue(c2) << 4);
            } else {
                byte[] arrby2 = arrby;
                int n4 = n2 >> 1;
                arrby2[n4] = (byte)(arrby2[n4] + (byte)StringUtil.hexValue(c2));
            }
            ++n2;
            ++n3;
        }
        return arrby;
    }

    public static String convertEOLToLF(String string) {
        StringBuilder stringBuilder = new StringBuilder(string.length());
        char[] arrc = string.toCharArray();
        int n2 = 0;
        int n3 = arrc.length;
        for (int i2 = 0; i2 < n3; ++i2) {
            if (arrc[i2] != '\r') continue;
            stringBuilder.append(arrc, n2, i2 - n2);
            stringBuilder.append('\n');
            if (i2 + 1 < n3 && arrc[i2 + 1] == '\n') {
                ++i2;
            }
            n2 = i2 + 1;
        }
        if (n2 == 0) {
            return string;
        }
        stringBuilder.append(arrc, n2, n3 - n2);
        return stringBuilder.toString();
    }

    @Nullable
    public static String maskLeft(String string, int n2, char c2) {
        if (n2 <= 0) {
            return string;
        }
        n2 = Math.min(n2, string.length());
        StringBuilder stringBuilder = new StringBuilder();
        int n3 = 0;
        do {
            if (n3 >= n2) {
                stringBuilder.append(string.substring(n2));
                return stringBuilder.toString();
            }
            stringBuilder.append(c2);
            ++n3;
        } while (true);
    }

    private static boolean isOctal(char c2) {
        if (c2 < '0') return false;
        if (c2 > '7') return false;
        return true;
    }

    private static boolean isHex(char c2) {
        if (c2 >= '0') {
            if (c2 <= '9') return true;
        }
        if (c2 >= 'a') {
            if (c2 <= 'f') return true;
        }
        if (c2 < 'A') return false;
        if (c2 > 'F') return false;
        return true;
    }

    private static int hexValue(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - 48;
        }
        if (c2 >= 'a' && c2 <= 'f') {
            return c2 - 97 + 10;
        }
        if (c2 < 'A') throw new IllegalArgumentException("char is not a hex char");
        if (c2 > 'F') throw new IllegalArgumentException("char is not a hex char");
        return c2 - 65 + 10;
    }

    /*
     * Unable to fully structure code
     */
    public static String unescapeCString(String var0) {
        if (var0.indexOf(92) < 0) {
            return var0;
        }
        var1_1 = new StringBuilder();
        var2_2 = var0.length();
        var3_3 = 0;
        while (var3_3 < var2_2) {
            if ((var4_4 = var0.charAt(var3_3++)) == '\\' && var3_3 < var2_2) {
                var4_4 = var0.charAt(var3_3++);
                switch (var4_4) {
                    case 'a': {
                        var4_4 = '\u0007';
                        ** break;
                    }
                    case 'b': {
                        var4_4 = '\b';
                        ** break;
                    }
                    case 'f': {
                        var4_4 = '\f';
                        ** break;
                    }
                    case 'n': {
                        var4_4 = '\n';
                        ** break;
                    }
                    case 'r': {
                        var4_4 = '\r';
                        ** break;
                    }
                    case 't': {
                        var4_4 = '\t';
                        ** break;
                    }
                    case 'v': {
                        var4_4 = '\u000b';
                        ** break;
                    }
                    case '\\': {
                        var4_4 = '\\';
                        ** break;
                    }
                    case '?': {
                        var4_4 = '?';
                        ** break;
                    }
                    case '\'': {
                        var4_4 = '\'';
                        ** break;
                    }
                    case '\"': {
                        var4_4 = '\"';
                        ** break;
                    }
                }
                if (var4_4 == 'x' && var3_3 < var2_2 && StringUtil.isHex(var0.charAt(var3_3))) {
                    var5_5 = StringUtil.hexValue(var0.charAt(var3_3++));
                    if (var3_3 < var2_2 && StringUtil.isHex(var0.charAt(var3_3))) {
                        var5_5 = var5_5 * 16 + StringUtil.hexValue(var0.charAt(var3_3++));
                    }
                    var4_4 = (char)var5_5;
                    ** break;
                }
                if (StringUtil.isOctal(var4_4)) {
                    var5_5 = var4_4 - 48;
                    if (var3_3 < var2_2 && StringUtil.isOctal(var0.charAt(var3_3))) {
                        var5_5 = var5_5 * 8 + (var0.charAt(var3_3++) - 48);
                    }
                    if (var3_3 < var2_2 && StringUtil.isOctal(var0.charAt(var3_3))) {
                        var5_5 = var5_5 * 8 + (var0.charAt(var3_3++) - 48);
                    }
                    var4_4 = (char)var5_5;
                    ** break;
                }
                var1_1.append('\\');
            }
lbl58: // 16 sources:
            var1_1.append(var4_4);
        }
        return var1_1.toString();
    }

    @Deprecated
    public static String unescapeHTML(String string) {
        return StringUtil.unescapeHTML(string, false);
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    @Deprecated
    public static String unescapeHTML(String var0, boolean var1_1) {
        var2_2 = var0.indexOf(38);
        if (var2_2 == -1) {
            return var0;
        }
        var3_3 = var0.toCharArray();
        var4_4 = new char[var3_3.length];
        System.arraycopy(var3_3, 0, var4_4, 0, var2_2);
        var5_5 = var2_2;
        var6_6 = var2_2;
        while (var6_6 < var3_3.length) {
            if (var3_3[var6_6] != '&') {
                var4_4[var5_5++] = var3_3[var6_6++];
                continue;
            }
            var7_7 = var6_6 + 1;
            var8_8 = false;
            if (var7_7 < var3_3.length && var3_3[var7_7] == '#') {
                ++var7_7;
                var8_8 = true;
            }
            var9_9 = false;
            if (var7_7 < var3_3.length && (var3_3[var7_7] == 'x' || var3_3[var7_7] == 'X')) {
                ++var7_7;
                var9_9 = true;
            }
            while (var7_7 < var3_3.length) {
                var10_10 = var3_3[var7_7];
                var11_11 = Character.isDigit(var10_10);
                if (var8_8 && (!var9_9 && !var11_11 || var9_9 && !var11_11 && !StringUtil.HEX_LETTER.matches(var10_10)) || !var11_11 && !Character.isLetter(var10_10)) break;
                ++var7_7;
            }
            var10_10 = '\u0000';
            if ((var7_7 > var3_3.length || !var1_1) && (var7_7 >= var3_3.length || var3_3[var7_7] != ';')) ** GOTO lbl55
            if (var6_6 + 2 < var3_3.length && var0.charAt(var6_6 + 1) == '#') {
                try {
                    var11_12 = 0;
                    var13_16 = var0.charAt(var6_6 + 2);
                    if (var9_9) {
                        var11_12 = Long.parseLong(new String(var3_3, var6_6 + 3, var7_7 - var6_6 - 3), 16);
                    } else if (Character.isDigit(var13_16)) {
                        var11_12 = Long.parseLong(new String(var3_3, var6_6 + 2, var7_7 - var6_6 - 2));
                    }
                    if (var11_12 > 0 && var11_12 < 65536) {
                        var4_4[var5_5++] = (char)var11_12;
                        var10_10 = '\u0001';
                    }
                }
                catch (NumberFormatException var11_13) {}
            } else {
                var11_14 = new String(var3_3, var6_6, var7_7 - var6_6);
                var12_15 = (Character)StringUtil.ESCAPE_STRINGS.get(var11_14);
                if (var12_15 != null) {
                    var4_4[var5_5++] = var12_15.charValue();
                    var10_10 = '\u0001';
                }
            }
            if (var7_7 < var3_3.length) {
                if (var3_3[var7_7] == ';') {
                    ++var7_7;
                }
lbl55: // 4 sources:
                if (var10_10 == '\u0000') {
                    System.arraycopy(var3_3, var6_6, var4_4, var5_5, var7_7 - var6_6);
                    var5_5 += var7_7 - var6_6;
                }
            }
            var6_6 = var7_7;
        }
        return new String(var4_4, 0, var5_5);
    }

    @Deprecated
    @Nullable
    public static String stripHtmlTags(@Nullable String string) {
        if (string == null) return string;
        if ("".equals(string)) {
            return string;
        }
        String string2 = HTML_TAG_PATTERN.matcher(string).replaceAll("");
        return LT_GT_ESCAPE.escape(string2);
    }

    public static String javaScriptEscape(CharSequence charSequence) {
        return StringUtil.javaScriptEscapeHelper(charSequence, false);
    }

    public static String javaScriptEscapeToAscii(CharSequence charSequence) {
        return StringUtil.javaScriptEscapeHelper(charSequence, true);
    }

    private static String javaScriptEscapeHelper(CharSequence charSequence, boolean bl2) {
        StringBuilder stringBuilder = new StringBuilder(charSequence.length() * 9 / 8);
        try {
            StringUtil.escapeStringBody(charSequence, bl2, StringUtil$JsEscapingMode.EMBEDDABLE_JS, stringBuilder);
            return stringBuilder.toString();
        }
        catch (IOException var3_3) {
            throw new RuntimeException(var3_3);
        }
    }

    /*
     * Unable to fully structure code
     */
    public static void escapeStringBody(CharSequence var0, boolean var1_1, StringUtil$JsEscapingMode var2_2, Appendable var3_3) {
        var4_4 = 0;
        var5_5 = var0.length();
        Preconditions.checkNotNull((Object)var2_2);
        var8_6 = 0;
        do {
            if (var8_6 >= var5_5) {
                var3_3.append(var0, var4_4, var5_5);
                return;
            }
            var6_7 = Character.codePointAt(var0, var8_6);
            var7_8 = Character.charCount(var6_7);
            if (StringUtil.shouldEscapeChar(var6_7, var1_1, var2_2)) {
                var3_3.append(var0, var4_4, var8_6);
                var4_4 = var8_6 + var7_8;
                switch (var6_7) {
                    case 8: {
                        var3_3.append("\\b");
                        ** break;
                    }
                    case 9: {
                        var3_3.append("\\t");
                        ** break;
                    }
                    case 10: {
                        var3_3.append("\\n");
                        ** break;
                    }
                    case 12: {
                        var3_3.append("\\f");
                        ** break;
                    }
                    case 13: {
                        var3_3.append("\\r");
                        ** break;
                    }
                    case 92: {
                        var3_3.append("\\\\");
                        ** break;
                    }
                    case 34: 
                    case 39: {
                        if (var2_2 == StringUtil$JsEscapingMode.JSON && 39 == var6_7) {
                            var3_3.append((char)var6_7);
                            ** break;
                        }
                        if (var2_2 == StringUtil$JsEscapingMode.EMBEDDABLE_JS) break;
                        var3_3.append('\\').append((char)var6_7);
                        ** break;
                    }
                }
                if (var6_7 >= 256 || var2_2 == StringUtil$JsEscapingMode.JSON) {
                    StringUtil.appendHexJavaScriptRepresentation(var6_7, var3_3);
                    ** break;
                }
                var9_9 = var8_6 + var7_8 >= var5_5 || StringUtil.isOctal(var0.charAt(var8_6 + var7_8)) != false;
                StringUtil.appendOctalJavaScriptRepresentation((char)var6_7, var9_9, var3_3);
            }
lbl45: // 12 sources:
            var8_6 += var7_8;
        } while (true);
    }

    private static boolean shouldEscapeChar(int n2, boolean bl2, StringUtil$JsEscapingMode stringUtil$JsEscapingMode) {
        if (bl2) {
            if (n2 < 32) return true;
            if (n2 > 126) {
                return true;
            }
        }
        if (stringUtil$JsEscapingMode != StringUtil$JsEscapingMode.JSON) return StringUtil.mustEscapeCharInJsString(n2);
        return StringUtil.mustEscapeCharInJsonOrJsString(n2);
    }

    private static void appendHexJavaScriptRepresentation(int n2, Appendable appendable) {
        if (Character.isSupplementaryCodePoint(n2)) {
            char[] arrc = Character.toChars(n2);
            StringUtil.appendHexJavaScriptRepresentation(arrc[0], appendable);
            StringUtil.appendHexJavaScriptRepresentation(arrc[1], appendable);
            return;
        }
        appendable.append("\\u").append(hexChars[n2 >>> 12 & 15]).append(hexChars[n2 >>> 8 & 15]).append(hexChars[n2 >>> 4 & 15]).append(hexChars[n2 & 15]);
    }

    private static void appendOctalJavaScriptRepresentation(char c2, boolean bl2, Appendable appendable) {
        if (c2 >= '@' || bl2) {
            appendable.append('\\').append(octalChars[c2 >>> 6 & 7]).append(octalChars[c2 >>> 3 & 7]).append(octalChars[c2 & 7]);
            return;
        }
        if (c2 >= '\b') {
            appendable.append('\\').append(octalChars[c2 >>> 3 & 7]).append(octalChars[c2 & 7]);
            return;
        }
        appendable.append('\\').append(octalChars[c2 & 7]);
    }

    public static String javaScriptUnescape(String string) {
        StringBuilder stringBuilder = new StringBuilder(string.length());
        int n2 = 0;
        while (n2 < string.length()) {
            char c2 = string.charAt(n2);
            if (c2 == '\\') {
                n2 = StringUtil.javaScriptUnescapeHelper(string, n2 + 1, stringBuilder);
                continue;
            }
            stringBuilder.append(c2);
            ++n2;
        }
        return stringBuilder.toString();
    }

    private static int javaScriptUnescapeHelper(String string, int n2, StringBuilder stringBuilder) {
        if (n2 >= string.length()) {
            throw new IllegalArgumentException(new StringBuilder(42 + String.valueOf(string).length()).append("End-of-string after escape character in [").append(string).append("]").toString());
        }
        char c2 = string.charAt(n2++);
        switch (c2) {
            case 'n': {
                stringBuilder.append('\n');
                return n2;
            }
            case 'r': {
                stringBuilder.append('\r');
                return n2;
            }
            case 't': {
                stringBuilder.append('\t');
                return n2;
            }
            case 'b': {
                stringBuilder.append('\b');
                return n2;
            }
            case 'f': {
                stringBuilder.append('\f');
                return n2;
            }
            case '\"': 
            case '\'': 
            case '>': 
            case '\\': {
                stringBuilder.append(c2);
                return n2;
            }
            case '0': 
            case '1': 
            case '2': 
            case '3': 
            case '4': 
            case '5': 
            case '6': 
            case '7': {
                int n3;
                int n4;
                int n5 = n4 = c2 < '4' ? 3 : 2;
                for (n3 = 1; n3 < n4 && n2 + n3 < string.length() && StringUtil.isOctal(string.charAt(--n2 + n3)); ++n3) {
                }
                stringBuilder.append((char)Integer.parseInt(string.substring(n2, n2 + n3), 8));
                return n2 += n3;
            }
            case 'u': 
            case 'x': {
                String string2;
                int n6;
                int n7 = c2 == 'u' ? 4 : 2;
                try {
                    string2 = string.substring(n2, n2 + n7);
                }
                catch (IndexOutOfBoundsException var8_8) {
                    String string3 = String.valueOf(string.substring(n2));
                    int n8 = n2;
                    throw new IllegalArgumentException(new StringBuilder(54 + String.valueOf(string3).length() + String.valueOf(string).length()).append("Invalid unicode sequence [").append(string3).append("] at index ").append(n8).append(" in [").append(string).append("]").toString());
                }
                try {
                    n6 = Integer.parseInt(string2, 16);
                }
                catch (NumberFormatException var9_11) {
                    int n9 = n2;
                    throw new IllegalArgumentException(new StringBuilder(54 + String.valueOf(string2).length() + String.valueOf(string).length()).append("Invalid unicode sequence [").append(string2).append("] at index ").append(n9).append(" in [").append(string).append("]").toString());
                }
                stringBuilder.append((char)n6);
                return n2 += n7;
            }
        }
        int n10 = n2;
        throw new IllegalArgumentException(new StringBuilder(50 + String.valueOf(string).length()).append("Unknown escape code [").append(c2).append("] at index ").append(n10).append(" in [").append(string).append("]").toString());
    }

    @Deprecated
    public static HashMap splitToMap(String string, @Nullable String string2, @Nullable String string3, boolean bl2) {
        Preconditions.checkNotNull(string);
        HashMap<String, String> hashMap = new HashMap<String, String>();
        if (Strings.isNullOrEmpty(string2) || Strings.isNullOrEmpty(string3)) {
            hashMap.put(CharMatcher.WHITESPACE.trimFrom(string), "");
            return hashMap;
        }
        int n2 = string3.length();
        Iterator iterator = Splitter.on(string2).split(string).iterator();
        while (iterator.hasNext()) {
            String string4 = (String)iterator.next();
            int n3 = string4.indexOf(string3);
            if (n3 > 0) {
                String string5 = string4.substring(n3 + n2);
                if (bl2) {
                    string5 = CharMatcher.WHITESPACE.trimFrom(string5);
                }
                hashMap.put(CharMatcher.WHITESPACE.trimFrom(string4.substring(0, n3)), string5);
                continue;
            }
            hashMap.put(CharMatcher.WHITESPACE.trimFrom(string4), "");
        }
        return hashMap;
    }

    @Deprecated
    @Nullable
    public static HashMap string2Map(@Nullable String string, @Nullable String string2, @Nullable String string3, boolean bl2) {
        if (string != null) return StringUtil.splitToMap(string, string2, string3, bl2);
        return null;
    }

    @Deprecated
    public static String[] parseDelimitedList(String string, char c2) {
        Preconditions.checkNotNull(string);
        String string2 = new StringBuilder(1).append(c2).toString();
        StringTokenizer stringTokenizer = new StringTokenizer(new StringBuilder(1 + String.valueOf(string).length() + String.valueOf(string2).length()).append(string).append(string2).append(" ").toString(), string2, true);
        ArrayList<String> arrayList = new ArrayList<String>();
        String string3 = "";
        StringBuilder stringBuilder = new StringBuilder();
        while (stringTokenizer.hasMoreTokens()) {
            String string4 = stringTokenizer.nextToken();
            if (string3 != null) {
                if (string4.equals(string2)) {
                    stringBuilder.append(string3);
                    if (string3.equals(string2)) {
                        string4 = null;
                    }
                } else {
                    if (stringBuilder.length() != 0) {
                        arrayList.add(stringBuilder.toString());
                    }
                    stringBuilder.setLength(0);
                }
            }
            string3 = string4;
        }
        return arrayList.toArray(new String[0]);
    }

    public static String lastToken(String string, String string2) {
        return string.substring(CharMatcher.anyOf(string2).lastIndexIn(string) + 1);
    }

    @Deprecated
    public static boolean containsCharRef(String string) {
        return CHARACTER_REFERENCE_PATTERN.matcher(string).find();
    }

    public static boolean isCjk(String string) {
        int n2 = string.length();
        int n3 = 0;
        while (n3 < n2) {
            if (StringUtil.isCjk(string.codePointAt(n3))) {
                return true;
            }
            ++n3;
        }
        return false;
    }

    public static boolean isCjk(char c2) {
        return StringUtil.isCjk((int)c2);
    }

    public static boolean isCjk(int n2) {
        if ((n2 & -256) != 0) return CJK_BLOCKS.contains(Character.UnicodeBlock.of(n2));
        return false;
    }

    public static int displayWidth(String string) {
        int n2 = 0;
        int n3 = string.length();
        int n4 = 0;
        while (n4 < n3) {
            n2 += StringUtil.displayWidth(string.charAt(n4));
            ++n4;
        }
        return n2;
    }

    public static int displayWidth(char c2) {
        if (c2 <= '\u04f9') return 1;
        if (c2 == '\u05be') return 1;
        if (c2 >= '\u05d0') {
            if (c2 <= '\u05ea') return 1;
        }
        if (c2 == '\u05f3') return 1;
        if (c2 == '\u05f4') return 1;
        if (c2 >= '\u0600') {
            if (c2 <= '\u06ff') return 1;
        }
        if (c2 >= '\u0750') {
            if (c2 <= '\u077f') return 1;
        }
        if (c2 >= '\ufb50') {
            if (c2 <= '\ufdff') return 1;
        }
        if (c2 >= '\ufe70') {
            if (c2 <= '\ufeff') return 1;
        }
        if (c2 >= '\u1e00') {
            if (c2 <= '\u20af') return 1;
        }
        if (c2 >= '\u2100') {
            if (c2 <= '\u213a') return 1;
        }
        if (c2 >= '\u0e00') {
            if (c2 <= '\u0e7f') return 1;
        }
        if (c2 < '\uff61') return 2;
        if (c2 > '\uffdc') return 2;
        return 1;
    }

    @Deprecated
    public static String capitalize(String string) {
        String string2;
        char c2;
        if (string.length() == 0) {
            return string;
        }
        char c3 = string.charAt(0);
        if (c3 == (c2 = Character.toUpperCase(c3))) {
            string2 = string;
            return string2;
        }
        String string3 = String.valueOf(string.substring(1));
        string2 = new StringBuilder(1 + String.valueOf(string3).length()).append(c2).append(string3).toString();
        return string2;
    }

    public static boolean startsWithIgnoreCase(String string, String string2) {
        return string.regionMatches(true, 0, string2, 0, string2.length());
    }

    public static boolean endsWithIgnoreCase(String string, String string2) {
        int n2 = string2.length();
        return string.regionMatches(true, string.length() - n2, string2, 0, n2);
    }

    public static String truncateStringForUtf8Storage(String string, int n2) {
        if (n2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        int n3 = 0;
        int n4 = 0;
        int n5 = string.length();
        while (n4 < n5) {
            char c2 = string.charAt(n4);
            if (c2 < '?') {
                ++n3;
            } else if (c2 < '\u0800') {
                n3 += 2;
            } else if (c2 < '\ud800' || c2 > '\udfff' || string.codePointAt(n4) < 65536) {
                n3 += 3;
            } else {
                n4 += (n3 += 4) > n2 ? 0 : 1;
            }
            if (n3 > n2) {
                return string.substring(0, n4);
            }
            ++n4;
        }
        return string;
    }

    public static String truncateIfNecessary(String string, int n2) {
        if (string.length() <= n2) {
            return string;
        }
        String string2 = StringUtil.unicodePreservingSubstring(string, 0, n2);
        String string3 = CharMatcher.WHITESPACE.trimTrailingFrom(string2);
        if (string3.length() < n2) {
            return string3;
        }
        if (CharMatcher.WHITESPACE.matches(string.charAt(n2))) {
            return string3;
        }
        int n3 = string3.length() - 1;
        while (n3 >= 0) {
            if (CharMatcher.WHITESPACE.matches(string3.charAt(n3))) {
                String string4 = string3.substring(0, n3);
                return CharMatcher.WHITESPACE.trimTrailingFrom(string4);
            }
            --n3;
        }
        return string3;
    }

    public static String truncateAtMaxLength(String string, int n2, boolean bl2) {
        if (string.length() <= n2) {
            return string;
        }
        if (!bl2) return StringUtil.unicodePreservingSubstring(string, 0, n2);
        if (n2 <= 3) return StringUtil.unicodePreservingSubstring(string, 0, n2);
        return String.valueOf(StringUtil.unicodePreservingSubstring(string, 0, n2 - 3)).concat("...");
    }

    @VisibleForTesting
    static int unicodePreservingIndex(String string, int n2) {
        if (n2 <= 0) return n2;
        if (n2 >= string.length()) return n2;
        if (!Character.isHighSurrogate(string.charAt(n2 - 1))) return n2;
        if (!Character.isLowSurrogate(string.charAt(n2))) return n2;
        return n2 - 1;
    }

    public static String unicodePreservingSubstring(String string, int n2, int n3) {
        return string.substring(StringUtil.unicodePreservingIndex(string, n2), StringUtil.unicodePreservingIndex(string, n3));
    }

    public static String unicodePreservingSubstring(String string, int n2) {
        return StringUtil.unicodePreservingSubstring(string, n2, string.length());
    }

    @VisibleForTesting
    static boolean mustEscapeCharInJsString(int n2) {
        return JS_ESCAPE_CHARS.contains(n2);
    }

    @VisibleForTesting
    static boolean mustEscapeCharInJsonString(int n2) {
        return JSON_ESCAPE_CHARS.contains(n2);
    }

    @VisibleForTesting
    static boolean mustEscapeCharInJsonOrJsString(int n2) {
        return JSON_OR_JS_ESCAPE_CHARS.contains(n2);
    }

    static {
        Cloneable cloneable = new HashMap<String, Character>(252);
        cloneable.put("&nbsp", Character.valueOf('\u00a0'));
        cloneable.put("&iexcl", Character.valueOf('\u00a1'));
        cloneable.put("&cent", Character.valueOf('\u00a2'));
        cloneable.put("&pound", Character.valueOf('\u00a3'));
        cloneable.put("&curren", Character.valueOf('\u00a4'));
        cloneable.put("&yen", Character.valueOf('\u00a5'));
        cloneable.put("&brvbar", Character.valueOf('\u00a6'));
        cloneable.put("&sect", Character.valueOf('\u00a7'));
        cloneable.put("&uml", Character.valueOf('\u00a8'));
        cloneable.put("&copy", Character.valueOf('\u00a9'));
        cloneable.put("&ordf", Character.valueOf('\u00aa'));
        cloneable.put("&laquo", Character.valueOf('\u00ab'));
        cloneable.put("&not", Character.valueOf('\u00ac'));
        cloneable.put("&shy", Character.valueOf('\u00ad'));
        cloneable.put("&reg", Character.valueOf('\u00ae'));
        cloneable.put("&macr", Character.valueOf('\u00af'));
        cloneable.put("&deg", Character.valueOf('\u00b0'));
        cloneable.put("&plusmn", Character.valueOf('\u00b1'));
        cloneable.put("&sup2", Character.valueOf('\u00b2'));
        cloneable.put("&sup3", Character.valueOf('\u00b3'));
        cloneable.put("&acute", Character.valueOf('\u00b4'));
        cloneable.put("&micro", Character.valueOf('\u00b5'));
        cloneable.put("&para", Character.valueOf('\u00b6'));
        cloneable.put("&middot", Character.valueOf('\u00b7'));
        cloneable.put("&cedil", Character.valueOf('\u00b8'));
        cloneable.put("&sup1", Character.valueOf('\u00b9'));
        cloneable.put("&ordm", Character.valueOf('\u00ba'));
        cloneable.put("&raquo", Character.valueOf('\u00bb'));
        cloneable.put("&frac14", Character.valueOf('\u00bc'));
        cloneable.put("&frac12", Character.valueOf('\u00bd'));
        cloneable.put("&frac34", Character.valueOf('\u00be'));
        cloneable.put("&iquest", Character.valueOf('\u00bf'));
        cloneable.put("&Agrave", Character.valueOf('\u00c0'));
        cloneable.put("&Aacute", Character.valueOf('\u00c1'));
        cloneable.put("&Acirc", Character.valueOf('\u00c2'));
        cloneable.put("&Atilde", Character.valueOf('\u00c3'));
        cloneable.put("&Auml", Character.valueOf('\u00c4'));
        cloneable.put("&Aring", Character.valueOf('\u00c5'));
        cloneable.put("&AElig", Character.valueOf('\u00c6'));
        cloneable.put("&Ccedil", Character.valueOf('\u00c7'));
        cloneable.put("&Egrave", Character.valueOf('\u00c8'));
        cloneable.put("&Eacute", Character.valueOf('\u00c9'));
        cloneable.put("&Ecirc", Character.valueOf('\u00ca'));
        cloneable.put("&Euml", Character.valueOf('\u00cb'));
        cloneable.put("&Igrave", Character.valueOf('\u00cc'));
        cloneable.put("&Iacute", Character.valueOf('\u00cd'));
        cloneable.put("&Icirc", Character.valueOf('\u00ce'));
        cloneable.put("&Iuml", Character.valueOf('\u00cf'));
        cloneable.put("&ETH", Character.valueOf('\u00d0'));
        cloneable.put("&Ntilde", Character.valueOf('\u00d1'));
        cloneable.put("&Ograve", Character.valueOf('\u00d2'));
        cloneable.put("&Oacute", Character.valueOf('\u00d3'));
        cloneable.put("&Ocirc", Character.valueOf('\u00d4'));
        cloneable.put("&Otilde", Character.valueOf('\u00d5'));
        cloneable.put("&Ouml", Character.valueOf('\u00d6'));
        cloneable.put("&times", Character.valueOf('\u00d7'));
        cloneable.put("&Oslash", Character.valueOf('\u00d8'));
        cloneable.put("&Ugrave", Character.valueOf('\u00d9'));
        cloneable.put("&Uacute", Character.valueOf('\u00da'));
        cloneable.put("&Ucirc", Character.valueOf('\u00db'));
        cloneable.put("&Uuml", Character.valueOf('\u00dc'));
        cloneable.put("&Yacute", Character.valueOf('\u00dd'));
        cloneable.put("&THORN", Character.valueOf('\u00de'));
        cloneable.put("&szlig", Character.valueOf('\u00df'));
        cloneable.put("&agrave", Character.valueOf('\u00e0'));
        cloneable.put("&aacute", Character.valueOf('\u00e1'));
        cloneable.put("&acirc", Character.valueOf('\u00e2'));
        cloneable.put("&atilde", Character.valueOf('\u00e3'));
        cloneable.put("&auml", Character.valueOf('\u00e4'));
        cloneable.put("&aring", Character.valueOf('\u00e5'));
        cloneable.put("&aelig", Character.valueOf('\u00e6'));
        cloneable.put("&ccedil", Character.valueOf('\u00e7'));
        cloneable.put("&egrave", Character.valueOf('\u00e8'));
        cloneable.put("&eacute", Character.valueOf('\u00e9'));
        cloneable.put("&ecirc", Character.valueOf('\u00ea'));
        cloneable.put("&euml", Character.valueOf('\u00eb'));
        cloneable.put("&igrave", Character.valueOf('\u00ec'));
        cloneable.put("&iacute", Character.valueOf('\u00ed'));
        cloneable.put("&icirc", Character.valueOf('\u00ee'));
        cloneable.put("&iuml", Character.valueOf('\u00ef'));
        cloneable.put("&eth", Character.valueOf('\u00f0'));
        cloneable.put("&ntilde", Character.valueOf('\u00f1'));
        cloneable.put("&ograve", Character.valueOf('\u00f2'));
        cloneable.put("&oacute", Character.valueOf('\u00f3'));
        cloneable.put("&ocirc", Character.valueOf('\u00f4'));
        cloneable.put("&otilde", Character.valueOf('\u00f5'));
        cloneable.put("&ouml", Character.valueOf('\u00f6'));
        cloneable.put("&divide", Character.valueOf('\u00f7'));
        cloneable.put("&oslash", Character.valueOf('\u00f8'));
        cloneable.put("&ugrave", Character.valueOf('\u00f9'));
        cloneable.put("&uacute", Character.valueOf('\u00fa'));
        cloneable.put("&ucirc", Character.valueOf('\u00fb'));
        cloneable.put("&uuml", Character.valueOf('\u00fc'));
        cloneable.put("&yacute", Character.valueOf('\u00fd'));
        cloneable.put("&thorn", Character.valueOf('\u00fe'));
        cloneable.put("&yuml", Character.valueOf('\u00ff'));
        cloneable.put("&fnof", Character.valueOf('\u0192'));
        cloneable.put("&Alpha", Character.valueOf('\u0391'));
        cloneable.put("&Beta", Character.valueOf('\u0392'));
        cloneable.put("&Gamma", Character.valueOf('\u0393'));
        cloneable.put("&Delta", Character.valueOf('\u0394'));
        cloneable.put("&Epsilon", Character.valueOf('\u0395'));
        cloneable.put("&Zeta", Character.valueOf('\u0396'));
        cloneable.put("&Eta", Character.valueOf('\u0397'));
        cloneable.put("&Theta", Character.valueOf('\u0398'));
        cloneable.put("&Iota", Character.valueOf('\u0399'));
        cloneable.put("&Kappa", Character.valueOf('\u039a'));
        cloneable.put("&Lambda", Character.valueOf('\u039b'));
        cloneable.put("&Mu", Character.valueOf('\u039c'));
        cloneable.put("&Nu", Character.valueOf('\u039d'));
        cloneable.put("&Xi", Character.valueOf('\u039e'));
        cloneable.put("&Omicron", Character.valueOf('\u039f'));
        cloneable.put("&Pi", Character.valueOf('\u03a0'));
        cloneable.put("&Rho", Character.valueOf('\u03a1'));
        cloneable.put("&Sigma", Character.valueOf('\u03a3'));
        cloneable.put("&Tau", Character.valueOf('\u03a4'));
        cloneable.put("&Upsilon", Character.valueOf('\u03a5'));
        cloneable.put("&Phi", Character.valueOf('\u03a6'));
        cloneable.put("&Chi", Character.valueOf('\u03a7'));
        cloneable.put("&Psi", Character.valueOf('\u03a8'));
        cloneable.put("&Omega", Character.valueOf('\u03a9'));
        cloneable.put("&alpha", Character.valueOf('\u03b1'));
        cloneable.put("&beta", Character.valueOf('\u03b2'));
        cloneable.put("&gamma", Character.valueOf('\u03b3'));
        cloneable.put("&delta", Character.valueOf('\u03b4'));
        cloneable.put("&epsilon", Character.valueOf('\u03b5'));
        cloneable.put("&zeta", Character.valueOf('\u03b6'));
        cloneable.put("&eta", Character.valueOf('\u03b7'));
        cloneable.put("&theta", Character.valueOf('\u03b8'));
        cloneable.put("&iota", Character.valueOf('\u03b9'));
        cloneable.put("&kappa", Character.valueOf('\u03ba'));
        cloneable.put("&lambda", Character.valueOf('\u03bb'));
        cloneable.put("&mu", Character.valueOf('\u03bc'));
        cloneable.put("&nu", Character.valueOf('\u03bd'));
        cloneable.put("&xi", Character.valueOf('\u03be'));
        cloneable.put("&omicron", Character.valueOf('\u03bf'));
        cloneable.put("&pi", Character.valueOf('\u03c0'));
        cloneable.put("&rho", Character.valueOf('\u03c1'));
        cloneable.put("&sigmaf", Character.valueOf('\u03c2'));
        cloneable.put("&sigma", Character.valueOf('\u03c3'));
        cloneable.put("&tau", Character.valueOf('\u03c4'));
        cloneable.put("&upsilon", Character.valueOf('\u03c5'));
        cloneable.put("&phi", Character.valueOf('\u03c6'));
        cloneable.put("&chi", Character.valueOf('\u03c7'));
        cloneable.put("&psi", Character.valueOf('\u03c8'));
        cloneable.put("&omega", Character.valueOf('\u03c9'));
        cloneable.put("&thetasym", Character.valueOf('\u03d1'));
        cloneable.put("&upsih", Character.valueOf('\u03d2'));
        cloneable.put("&piv", Character.valueOf('\u03d6'));
        cloneable.put("&bull", Character.valueOf('\u2022'));
        cloneable.put("&hellip", Character.valueOf('\u2026'));
        cloneable.put("&prime", Character.valueOf('\u2032'));
        cloneable.put("&Prime", Character.valueOf('\u2033'));
        cloneable.put("&oline", Character.valueOf('\u203e'));
        cloneable.put("&frasl", Character.valueOf('\u2044'));
        cloneable.put("&weierp", Character.valueOf('\u2118'));
        cloneable.put("&image", Character.valueOf('\u2111'));
        cloneable.put("&real", Character.valueOf('\u211c'));
        cloneable.put("&trade", Character.valueOf('\u2122'));
        cloneable.put("&alefsym", Character.valueOf('\u2135'));
        cloneable.put("&larr", Character.valueOf('\u2190'));
        cloneable.put("&uarr", Character.valueOf('\u2191'));
        cloneable.put("&rarr", Character.valueOf('\u2192'));
        cloneable.put("&darr", Character.valueOf('\u2193'));
        cloneable.put("&harr", Character.valueOf('\u2194'));
        cloneable.put("&crarr", Character.valueOf('\u21b5'));
        cloneable.put("&lArr", Character.valueOf('\u21d0'));
        cloneable.put("&uArr", Character.valueOf('\u21d1'));
        cloneable.put("&rArr", Character.valueOf('\u21d2'));
        cloneable.put("&dArr", Character.valueOf('\u21d3'));
        cloneable.put("&hArr", Character.valueOf('\u21d4'));
        cloneable.put("&forall", Character.valueOf('\u2200'));
        cloneable.put("&part", Character.valueOf('\u2202'));
        cloneable.put("&exist", Character.valueOf('\u2203'));
        cloneable.put("&empty", Character.valueOf('\u2205'));
        cloneable.put("&nabla", Character.valueOf('\u2207'));
        cloneable.put("&isin", Character.valueOf('\u2208'));
        cloneable.put("&notin", Character.valueOf('\u2209'));
        cloneable.put("&ni", Character.valueOf('\u220b'));
        cloneable.put("&prod", Character.valueOf('\u220f'));
        cloneable.put("&sum", Character.valueOf('\u2211'));
        cloneable.put("&minus", Character.valueOf('\u2212'));
        cloneable.put("&lowast", Character.valueOf('\u2217'));
        cloneable.put("&radic", Character.valueOf('\u221a'));
        cloneable.put("&prop", Character.valueOf('\u221d'));
        cloneable.put("&infin", Character.valueOf('\u221e'));
        cloneable.put("&ang", Character.valueOf('\u2220'));
        cloneable.put("&and", Character.valueOf('\u2227'));
        cloneable.put("&or", Character.valueOf('\u2228'));
        cloneable.put("&cap", Character.valueOf('\u2229'));
        cloneable.put("&cup", Character.valueOf('\u222a'));
        cloneable.put("&int", Character.valueOf('\u222b'));
        cloneable.put("&there4", Character.valueOf('\u2234'));
        cloneable.put("&sim", Character.valueOf('\u223c'));
        cloneable.put("&cong", Character.valueOf('\u2245'));
        cloneable.put("&asymp", Character.valueOf('\u2248'));
        cloneable.put("&ne", Character.valueOf('\u2260'));
        cloneable.put("&equiv", Character.valueOf('\u2261'));
        cloneable.put("&le", Character.valueOf('\u2264'));
        cloneable.put("&ge", Character.valueOf('\u2265'));
        cloneable.put("&sub", Character.valueOf('\u2282'));
        cloneable.put("&sup", Character.valueOf('\u2283'));
        cloneable.put("&nsub", Character.valueOf('\u2284'));
        cloneable.put("&sube", Character.valueOf('\u2286'));
        cloneable.put("&supe", Character.valueOf('\u2287'));
        cloneable.put("&oplus", Character.valueOf('\u2295'));
        cloneable.put("&otimes", Character.valueOf('\u2297'));
        cloneable.put("&perp", Character.valueOf('\u22a5'));
        cloneable.put("&sdot", Character.valueOf('\u22c5'));
        cloneable.put("&lceil", Character.valueOf('\u2308'));
        cloneable.put("&rceil", Character.valueOf('\u2309'));
        cloneable.put("&lfloor", Character.valueOf('\u230a'));
        cloneable.put("&rfloor", Character.valueOf('\u230b'));
        cloneable.put("&lang", Character.valueOf('\u2329'));
        cloneable.put("&rang", Character.valueOf('\u232a'));
        cloneable.put("&loz", Character.valueOf('\u25ca'));
        cloneable.put("&spades", Character.valueOf('\u2660'));
        cloneable.put("&clubs", Character.valueOf('\u2663'));
        cloneable.put("&hearts", Character.valueOf('\u2665'));
        cloneable.put("&diams", Character.valueOf('\u2666'));
        cloneable.put("&quot", Character.valueOf('\"'));
        cloneable.put("&amp", Character.valueOf('&'));
        cloneable.put("&lt", Character.valueOf('<'));
        cloneable.put("&gt", Character.valueOf('>'));
        cloneable.put("&apos", Character.valueOf('\''));
        cloneable.put("&OElig", Character.valueOf('\u0152'));
        cloneable.put("&oelig", Character.valueOf('\u0153'));
        cloneable.put("&Scaron", Character.valueOf('\u0160'));
        cloneable.put("&scaron", Character.valueOf('\u0161'));
        cloneable.put("&Yuml", Character.valueOf('\u0178'));
        cloneable.put("&circ", Character.valueOf('\u02c6'));
        cloneable.put("&tilde", Character.valueOf('\u02dc'));
        cloneable.put("&ensp", Character.valueOf('\u2002'));
        cloneable.put("&emsp", Character.valueOf('\u2003'));
        cloneable.put("&thinsp", Character.valueOf('\u2009'));
        cloneable.put("&zwnj", Character.valueOf('\u200c'));
        cloneable.put("&zwj", Character.valueOf('\u200d'));
        cloneable.put("&lrm", Character.valueOf('\u200e'));
        cloneable.put("&rlm", Character.valueOf('\u200f'));
        cloneable.put("&ndash", Character.valueOf('\u2013'));
        cloneable.put("&mdash", Character.valueOf('\u2014'));
        cloneable.put("&lsquo", Character.valueOf('\u2018'));
        cloneable.put("&rsquo", Character.valueOf('\u2019'));
        cloneable.put("&sbquo", Character.valueOf('\u201a'));
        cloneable.put("&ldquo", Character.valueOf('\u201c'));
        cloneable.put("&rdquo", Character.valueOf('\u201d'));
        cloneable.put("&bdquo", Character.valueOf('\u201e'));
        cloneable.put("&dagger", Character.valueOf('\u2020'));
        cloneable.put("&Dagger", Character.valueOf('\u2021'));
        cloneable.put("&permil", Character.valueOf('\u2030'));
        cloneable.put("&lsaquo", Character.valueOf('\u2039'));
        cloneable.put("&rsaquo", Character.valueOf('\u203a'));
        cloneable.put("&euro", Character.valueOf('\u20ac'));
        ESCAPE_STRINGS = Collections.unmodifiableMap(cloneable);
        HEX_LETTER = CharMatcher.inRange('A', 'F').or(CharMatcher.inRange('a', 'f'));
        LT_GT_ESCAPE = new StringUtil$CharEscaperBuilder().addEscape('<', "&lt;").addEscape('>', "&gt;").toEscaper();
        HTML_TAG_PATTERN = Pattern.compile("</?[a-zA-Z][^>]*>");
        CHARACTER_REFERENCE_PATTERN = Pattern.compile("&#?[a-zA-Z0-9]{1,8};");
        cloneable = new HashSet();
        cloneable.add(Character.UnicodeBlock.HANGUL_JAMO);
        cloneable.add(Character.UnicodeBlock.CJK_RADICALS_SUPPLEMENT);
        cloneable.add(Character.UnicodeBlock.KANGXI_RADICALS);
        cloneable.add(Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION);
        cloneable.add(Character.UnicodeBlock.HIRAGANA);
        cloneable.add(Character.UnicodeBlock.KATAKANA);
        cloneable.add(Character.UnicodeBlock.BOPOMOFO);
        cloneable.add(Character.UnicodeBlock.HANGUL_COMPATIBILITY_JAMO);
        cloneable.add(Character.UnicodeBlock.KANBUN);
        cloneable.add(Character.UnicodeBlock.BOPOMOFO_EXTENDED);
        cloneable.add(Character.UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS);
        cloneable.add(Character.UnicodeBlock.ENCLOSED_CJK_LETTERS_AND_MONTHS);
        cloneable.add(Character.UnicodeBlock.CJK_COMPATIBILITY);
        cloneable.add(Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A);
        cloneable.add(Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS);
        cloneable.add(Character.UnicodeBlock.HANGUL_SYLLABLES);
        cloneable.add(Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS);
        cloneable.add(Character.UnicodeBlock.CJK_COMPATIBILITY_FORMS);
        cloneable.add(Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS);
        cloneable.add(Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B);
        cloneable.add(Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT);
        CJK_BLOCKS = Collections.unmodifiableSet(cloneable);
        hexChars = "0123456789abcdef".toCharArray();
        octalChars = "01234567".toCharArray();
        JS_ESCAPE_CHARS = new StringUtil$CodePointSet$Builder().addCodePoint(173).addRange(1536, 1539).addCodePoint(1757).addCodePoint(1807).addRange(6068, 6069).addRange(8203, 8207).addRange(8234, 8238).addRange(8288, 8292).addRange(8298, 8303).addCodePoint(65279).addRange(65529, 65531).addRange(119155, 119162).addCodePoint(917505).addRange(917536, 917631).addCodePoint(0).addCodePoint(10).addCodePoint(13).addRange(8232, 8233).addCodePoint(133).addCodePoint(Character.codePointAt("'", 0)).addCodePoint(Character.codePointAt("\"", 0)).addCodePoint(Character.codePointAt("&", 0)).addCodePoint(Character.codePointAt("<", 0)).addCodePoint(Character.codePointAt(">", 0)).addCodePoint(Character.codePointAt("=", 0)).addCodePoint(Character.codePointAt("\\", 0)).create();
        JSON_ESCAPE_CHARS = new StringUtil$CodePointSet$Builder().addCodePoint(Character.codePointAt("\"", 0)).addCodePoint(Character.codePointAt("\\", 0)).addRange(0, 31).create();
        JSON_OR_JS_ESCAPE_CHARS = JSON_ESCAPE_CHARS.or(JS_ESCAPE_CHARS);
    }
}

