package com.google.common.base;

import java.util.regex.*;
import javax.annotation.*;
import com.google.common.annotations.*;
import java.util.*;
import java.io.*;

@GoogleInternal
public final class StringUtil
{
    private static final Splitter NEWLINE_SPLITTER;
    private static final Splitter TO_WORDS;
    private static final CharMatcher FANCY_SINGLE_QUOTE;
    private static final CharMatcher FANCY_DOUBLE_QUOTE;
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
    
    public static boolean isEmptyOrWhitespace(@Nullable final String s) {
        return s == null || CharMatcher.WHITESPACE.matchesAllOf(s);
    }
    
    @Nullable
    public static String toNullIfEmptyOrWhitespace(@Nullable final String s) {
        return isEmptyOrWhitespace(s) ? null : s;
    }
    
    public static String fixedWidth(final String s, final int n) {
        final ArrayList<String> list = new ArrayList<String>();
        final Iterator<String> iterator = StringUtil.NEWLINE_SPLITTER.split(s).iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return fixedWidth(list.toArray(new String[0]), n);
    }
    
    @VisibleForTesting
    static String fixedWidth(final String[] array, final int n) {
        final ArrayList<String> list = new ArrayList<String>();
        for (int length = array.length, i = 0; i < length; ++i) {
            list.add(formatLineToFixedWidth(array[i], n));
        }
        return Joiner.on('\n').join(list);
    }
    
    private static String formatLineToFixedWidth(final String s, final int n) {
        if (s.length() <= n) {
            return s;
        }
        final StringBuilder sb = new StringBuilder();
        int n2 = 0;
        for (final String s2 : StringUtil.TO_WORDS.split(s)) {
            if (n2 == 0) {
                n2 = s2.length();
            }
            else {
                final int n3 = n2 + s2.length() + 1;
                if (n3 <= n) {
                    sb.append(' ');
                    n2 = n3;
                }
                else {
                    sb.append('\n');
                    n2 = s2.length();
                }
            }
            sb.append(s2);
        }
        return sb.toString();
    }
    
    public static String indent(final String s, final int n) {
        final StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (int i = 0; i < n; ++i) {
            sb.append("  ");
        }
        return s.replace("\n", sb.toString());
    }
    
    @Nullable
    public static String stripPrefix(final String s, final String s2) {
        return s.startsWith(s2) ? s.substring(s2.length()) : null;
    }
    
    @Nullable
    public static String stripPrefixIgnoreCase(final String s, final String s2) {
        return startsWithIgnoreCase(s, s2) ? s.substring(s2.length()) : null;
    }
    
    @Nullable
    public static String stripSuffix(final String s, final String s2) {
        return s.endsWith(s2) ? s.substring(0, s.length() - s2.length()) : null;
    }
    
    @Nullable
    public static String stripSuffixIgnoreCase(final String s, final String s2) {
        return endsWithIgnoreCase(s, s2) ? s.substring(0, s.length() - s2.length()) : null;
    }
    
    public static String replaceSmartQuotes(final String s) {
        return StringUtil.FANCY_DOUBLE_QUOTE.replaceFrom(StringUtil.FANCY_SINGLE_QUOTE.replaceFrom(s, '\''), '\"');
    }
    
    @Deprecated
    public static byte[] hexToBytes(final CharSequence charSequence) {
        final byte[] array = new byte[(charSequence.length() + 1) / 2];
        if (charSequence.length() == 0) {
            return array;
        }
        array[0] = 0;
        int n = charSequence.length() % 2;
        for (int i = 0; i < charSequence.length(); ++i) {
            final char char1 = charSequence.charAt(i);
            if (n % 2 == 0) {
                array[n >> 1] = (byte)(hexValue(char1) << 4);
            }
            else {
                final byte[] array2 = array;
                final int n2 = n >> 1;
                array2[n2] += (byte)hexValue(char1);
            }
            ++n;
        }
        return array;
    }
    
    public static String convertEOLToLF(final String s) {
        final StringBuilder sb = new StringBuilder(s.length());
        final char[] charArray = s.toCharArray();
        int n = 0;
        final int length = charArray.length;
        for (int i = 0; i < length; ++i) {
            if (charArray[i] == '\r') {
                sb.append(charArray, n, i - n);
                sb.append('\n');
                if (i + 1 < length && charArray[i + 1] == '\n') {
                    ++i;
                }
                n = i + 1;
            }
        }
        if (n == 0) {
            return s;
        }
        sb.append(charArray, n, length - n);
        return sb.toString();
    }
    
    @Nullable
    public static String maskLeft(final String s, int min, final char c) {
        if (min <= 0) {
            return s;
        }
        min = Math.min(min, s.length());
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < min; ++i) {
            sb.append(c);
        }
        sb.append(s.substring(min));
        return sb.toString();
    }
    
    private static boolean isOctal(final char c) {
        return c >= '0' && c <= '7';
    }
    
    private static boolean isHex(final char c) {
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F');
    }
    
    private static int hexValue(final char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'f') {
            return c - 'a' + '\n';
        }
        if (c >= 'A' && c <= 'F') {
            return c - 'A' + '\n';
        }
        throw new IllegalArgumentException("char is not a hex char");
    }
    
    public static String unescapeCString(final String s) {
        if (s.indexOf(92) < 0) {
            return s;
        }
        final StringBuilder sb = new StringBuilder();
        final int length = s.length();
        int i = 0;
        while (i < length) {
            char c = s.charAt(i++);
            if (c == '\\' && i < length) {
                c = s.charAt(i++);
                switch (c) {
                    case 97: {
                        c = '\u0007';
                        break;
                    }
                    case 98: {
                        c = '\b';
                        break;
                    }
                    case 102: {
                        c = '\f';
                        break;
                    }
                    case 110: {
                        c = '\n';
                        break;
                    }
                    case 114: {
                        c = '\r';
                        break;
                    }
                    case 116: {
                        c = '\t';
                        break;
                    }
                    case 118: {
                        c = '\u000b';
                        break;
                    }
                    case 92: {
                        c = '\\';
                        break;
                    }
                    case 63: {
                        c = '?';
                        break;
                    }
                    case 39: {
                        c = '\'';
                        break;
                    }
                    case 34: {
                        c = '\"';
                        break;
                    }
                    default: {
                        if (c == 'x' && i < length && isHex(s.charAt(i))) {
                            int hexValue = hexValue(s.charAt(i++));
                            if (i < length && isHex(s.charAt(i))) {
                                hexValue = hexValue * 16 + hexValue(s.charAt(i++));
                            }
                            c = (char)hexValue;
                            break;
                        }
                        if (isOctal(c)) {
                            int n = c - '0';
                            if (i < length && isOctal(s.charAt(i))) {
                                n = n * 8 + (s.charAt(i++) - '0');
                            }
                            if (i < length && isOctal(s.charAt(i))) {
                                n = n * 8 + (s.charAt(i++) - '0');
                            }
                            c = (char)n;
                            break;
                        }
                        sb.append('\\');
                        break;
                    }
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
    
    @Deprecated
    public static String unescapeHTML(final String s) {
        return unescapeHTML(s, false);
    }
    
    @Deprecated
    public static String unescapeHTML(final String s, final boolean b) {
        final int index = s.indexOf(38);
        if (index == -1) {
            return s;
        }
        final char[] charArray = s.toCharArray();
        final char[] array = new char[charArray.length];
        System.arraycopy(charArray, 0, array, 0, index);
        int n = index;
        int i = index;
        while (i < charArray.length) {
            if (charArray[i] != '&') {
                array[n++] = charArray[i++];
            }
            else {
                int j = i + 1;
                boolean b2 = false;
                if (j < charArray.length && charArray[j] == '#') {
                    ++j;
                    b2 = true;
                }
                boolean b3 = false;
                if (j < charArray.length && (charArray[j] == 'x' || charArray[j] == 'X')) {
                    ++j;
                    b3 = true;
                }
                while (j < charArray.length) {
                    final char c = charArray[j];
                    final boolean digit = Character.isDigit(c);
                    if (b2) {
                        if (!b3 && !digit) {
                            break;
                        }
                        if (b3 && !digit && !StringUtil.HEX_LETTER.matches(c)) {
                            break;
                        }
                    }
                    if (!digit && !Character.isLetter(c)) {
                        break;
                    }
                    ++j;
                }
                boolean b4 = false;
                if ((j <= charArray.length && b) || (j < charArray.length && charArray[j] == ';')) {
                    if (i + 2 < charArray.length && s.charAt(i + 1) == '#') {
                        try {
                            long n2 = 0L;
                            final char char1 = s.charAt(i + 2);
                            if (b3) {
                                n2 = Long.parseLong(new String(charArray, i + 3, j - i - 3), 16);
                            }
                            else if (Character.isDigit(char1)) {
                                n2 = Long.parseLong(new String(charArray, i + 2, j - i - 2));
                            }
                            if (n2 > 0L && n2 < 65536L) {
                                array[n++] = (char)n2;
                                b4 = true;
                            }
                        }
                        catch (NumberFormatException ex) {}
                    }
                    else {
                        final Character c2 = StringUtil.ESCAPE_STRINGS.get(new String(charArray, i, j - i));
                        if (c2 != null) {
                            array[n++] = c2;
                            b4 = true;
                        }
                    }
                    if (j < charArray.length && charArray[j] == ';') {
                        ++j;
                    }
                }
                if (!b4) {
                    System.arraycopy(charArray, i, array, n, j - i);
                    n += j - i;
                }
                i = j;
            }
        }
        return new String(array, 0, n);
    }
    
    @Deprecated
    @Nullable
    public static String stripHtmlTags(@Nullable final String s) {
        if (s == null || "".equals(s)) {
            return s;
        }
        return StringUtil.LT_GT_ESCAPE.escape(StringUtil.HTML_TAG_PATTERN.matcher(s).replaceAll(""));
    }
    
    public static String javaScriptEscape(final CharSequence charSequence) {
        return javaScriptEscapeHelper(charSequence, false);
    }
    
    public static String javaScriptEscapeToAscii(final CharSequence charSequence) {
        return javaScriptEscapeHelper(charSequence, true);
    }
    
    private static String javaScriptEscapeHelper(final CharSequence charSequence, final boolean b) {
        final StringBuilder sb = new StringBuilder(charSequence.length() * 9 / 8);
        try {
            escapeStringBody(charSequence, b, StringUtil$JsEscapingMode.EMBEDDABLE_JS, sb);
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return sb.toString();
    }
    
    public static void escapeStringBody(final CharSequence charSequence, final boolean b, final StringUtil$JsEscapingMode stringUtil$JsEscapingMode, final Appendable appendable) {
        int n = 0;
        final int length = charSequence.length();
        Preconditions.checkNotNull(stringUtil$JsEscapingMode);
        int charCount;
        for (int i = 0; i < length; i += charCount) {
            final int codePoint = Character.codePointAt(charSequence, i);
            charCount = Character.charCount(codePoint);
            if (shouldEscapeChar(codePoint, b, stringUtil$JsEscapingMode)) {
                appendable.append(charSequence, n, i);
                n = i + charCount;
                switch (codePoint) {
                    case 8: {
                        appendable.append("\\b");
                        continue;
                    }
                    case 9: {
                        appendable.append("\\t");
                        continue;
                    }
                    case 10: {
                        appendable.append("\\n");
                        continue;
                    }
                    case 12: {
                        appendable.append("\\f");
                        continue;
                    }
                    case 13: {
                        appendable.append("\\r");
                        continue;
                    }
                    case 92: {
                        appendable.append("\\\\");
                        continue;
                    }
                    case 34:
                    case 39: {
                        if (stringUtil$JsEscapingMode == StringUtil$JsEscapingMode.JSON && 39 == codePoint) {
                            appendable.append((char)codePoint);
                            continue;
                        }
                        if (stringUtil$JsEscapingMode != StringUtil$JsEscapingMode.EMBEDDABLE_JS) {
                            appendable.append('\\').append((char)codePoint);
                            continue;
                        }
                        break;
                    }
                }
                if (codePoint >= 256 || stringUtil$JsEscapingMode == StringUtil$JsEscapingMode.JSON) {
                    appendHexJavaScriptRepresentation(codePoint, appendable);
                }
                else {
                    appendOctalJavaScriptRepresentation((char)codePoint, i + charCount >= length || isOctal(charSequence.charAt(i + charCount)), appendable);
                }
            }
        }
        appendable.append(charSequence, n, length);
    }
    
    private static boolean shouldEscapeChar(final int n, final boolean b, final StringUtil$JsEscapingMode stringUtil$JsEscapingMode) {
        if (b && (n < 32 || n > 126)) {
            return true;
        }
        if (stringUtil$JsEscapingMode == StringUtil$JsEscapingMode.JSON) {
            return mustEscapeCharInJsonOrJsString(n);
        }
        return mustEscapeCharInJsString(n);
    }
    
    private static void appendHexJavaScriptRepresentation(final int n, final Appendable appendable) {
        if (Character.isSupplementaryCodePoint(n)) {
            final char[] chars = Character.toChars(n);
            appendHexJavaScriptRepresentation(chars[0], appendable);
            appendHexJavaScriptRepresentation(chars[1], appendable);
            return;
        }
        appendable.append("\\u").append(StringUtil.hexChars[n >>> 12 & 0xF]).append(StringUtil.hexChars[n >>> 8 & 0xF]).append(StringUtil.hexChars[n >>> 4 & 0xF]).append(StringUtil.hexChars[n & 0xF]);
    }
    
    private static void appendOctalJavaScriptRepresentation(final char c, final boolean b, final Appendable appendable) {
        if (c >= '@' || b) {
            appendable.append('\\').append(StringUtil.octalChars[c >>> 6 & '\u0007']).append(StringUtil.octalChars[c >>> 3 & '\u0007']).append(StringUtil.octalChars[c & '\u0007']);
        }
        else if (c >= '\b') {
            appendable.append('\\').append(StringUtil.octalChars[c >>> 3 & '\u0007']).append(StringUtil.octalChars[c & '\u0007']);
        }
        else {
            appendable.append('\\').append(StringUtil.octalChars[c & '\u0007']);
        }
    }
    
    public static String javaScriptUnescape(final String s) {
        final StringBuilder sb = new StringBuilder(s.length());
        int i = 0;
        while (i < s.length()) {
            final char char1 = s.charAt(i);
            if (char1 == '\\') {
                i = javaScriptUnescapeHelper(s, i + 1, sb);
            }
            else {
                sb.append(char1);
                ++i;
            }
        }
        return sb.toString();
    }
    
    private static int javaScriptUnescapeHelper(final String s, int n, final StringBuilder sb) {
        if (n >= s.length()) {
            throw new IllegalArgumentException(new StringBuilder(42 + String.valueOf(s).length()).append("End-of-string after escape character in [").append(s).append("]").toString());
        }
        final char char1 = s.charAt(n++);
        switch (char1) {
            case 110: {
                sb.append('\n');
                break;
            }
            case 114: {
                sb.append('\r');
                break;
            }
            case 116: {
                sb.append('\t');
                break;
            }
            case 98: {
                sb.append('\b');
                break;
            }
            case 102: {
                sb.append('\f');
                break;
            }
            case 34:
            case 39:
            case 62:
            case 92: {
                sb.append(char1);
                break;
            }
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55: {
                --n;
                int n2;
                for (n2 = 1; n2 < ((char1 < '4') ? 3 : 2) && n + n2 < s.length() && isOctal(s.charAt(n + n2)); ++n2) {}
                sb.append((char)Integer.parseInt(s.substring(n, n + n2), 8));
                n += n2;
                break;
            }
            case 117:
            case 120: {
                final int n3 = (char1 == 'u') ? 4 : 2;
                String substring;
                try {
                    substring = s.substring(n, n + n3);
                }
                catch (IndexOutOfBoundsException ex) {
                    final String value = String.valueOf(s.substring(n));
                    throw new IllegalArgumentException(new StringBuilder(54 + String.valueOf(value).length() + String.valueOf(s).length()).append("Invalid unicode sequence [").append(value).append("] at index ").append(n).append(" in [").append(s).append("]").toString());
                }
                int int1;
                try {
                    int1 = Integer.parseInt(substring, 16);
                }
                catch (NumberFormatException ex2) {
                    throw new IllegalArgumentException(new StringBuilder(54 + String.valueOf(substring).length() + String.valueOf(s).length()).append("Invalid unicode sequence [").append(substring).append("] at index ").append(n).append(" in [").append(s).append("]").toString());
                }
                sb.append((char)int1);
                n += n3;
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuilder(50 + String.valueOf(s).length()).append("Unknown escape code [").append(char1).append("] at index ").append(n).append(" in [").append(s).append("]").toString());
            }
        }
        return n;
    }
    
    @Deprecated
    public static HashMap splitToMap(final String s, @Nullable final String s2, @Nullable final String s3, final boolean b) {
        Preconditions.checkNotNull(s);
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        if (Strings.isNullOrEmpty(s2) || Strings.isNullOrEmpty(s3)) {
            hashMap.put(CharMatcher.WHITESPACE.trimFrom(s), "");
            return hashMap;
        }
        final int length = s3.length();
        for (final String s4 : Splitter.on(s2).split(s)) {
            final int index = s4.indexOf(s3);
            if (index > 0) {
                String s5 = s4.substring(index + length);
                if (b) {
                    s5 = CharMatcher.WHITESPACE.trimFrom(s5);
                }
                hashMap.put(CharMatcher.WHITESPACE.trimFrom(s4.substring(0, index)), s5);
            }
            else {
                hashMap.put(CharMatcher.WHITESPACE.trimFrom(s4), "");
            }
        }
        return hashMap;
    }
    
    @Deprecated
    @Nullable
    public static HashMap string2Map(@Nullable final String s, @Nullable final String s2, @Nullable final String s3, final boolean b) {
        if (s == null) {
            return null;
        }
        return splitToMap(s, s2, s3, b);
    }
    
    @Deprecated
    public static String[] parseDelimitedList(final String s, final char c) {
        Preconditions.checkNotNull(s);
        final String string = new StringBuilder(1).append(c).toString();
        final StringTokenizer stringTokenizer = new StringTokenizer(new StringBuilder(1 + String.valueOf(s).length() + String.valueOf(string).length()).append(s).append(string).append(" ").toString(), string, true);
        final ArrayList<String> list = new ArrayList<String>();
        String s2 = "";
        final StringBuilder sb = new StringBuilder();
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            if (s2 != null) {
                if (nextToken.equals(string)) {
                    sb.append(s2);
                    if (s2.equals(string)) {
                        nextToken = null;
                    }
                }
                else {
                    if (sb.length() != 0) {
                        list.add(sb.toString());
                    }
                    sb.setLength(0);
                }
            }
            s2 = nextToken;
        }
        return list.toArray(new String[0]);
    }
    
    public static String lastToken(final String s, final String s2) {
        return s.substring(CharMatcher.anyOf(s2).lastIndexIn(s) + 1);
    }
    
    @Deprecated
    public static boolean containsCharRef(final String s) {
        return StringUtil.CHARACTER_REFERENCE_PATTERN.matcher(s).find();
    }
    
    public static boolean isCjk(final String s) {
        for (int length = s.length(), i = 0; i < length; ++i) {
            if (isCjk(s.codePointAt(i))) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean isCjk(final char c) {
        return isCjk((int)c);
    }
    
    public static boolean isCjk(final int n) {
        return (n & 0xFFFFFF00) != 0x0 && StringUtil.CJK_BLOCKS.contains(Character.UnicodeBlock.of(n));
    }
    
    public static int displayWidth(final String s) {
        int n = 0;
        for (int length = s.length(), i = 0; i < length; ++i) {
            n += displayWidth(s.charAt(i));
        }
        return n;
    }
    
    public static int displayWidth(final char c) {
        if (c <= '\u04f9' || c == '\u05be' || (c >= '\u05d0' && c <= '\u05ea') || c == '\u05f3' || c == '\u05f4' || (c >= '\u0600' && c <= '\u06ff') || (c >= '\u0750' && c <= '\u077f') || (c >= '\ufb50' && c <= '\ufdff') || (c >= '\ufe70' && c <= '\ufeff') || (c >= '\u1e00' && c <= '\u20af') || (c >= '\u2100' && c <= '\u213a') || (c >= '\u0e00' && c <= '\u0e7f') || (c >= '\uff61' && c <= '\uffdc')) {
            return 1;
        }
        return 2;
    }
    
    @Deprecated
    public static String capitalize(final String s) {
        if (s.length() == 0) {
            return s;
        }
        final char char1 = s.charAt(0);
        final char upperCase = Character.toUpperCase(char1);
        String string;
        if (char1 == upperCase) {
            string = s;
        }
        else {
            final String value = String.valueOf(s.substring(1));
            string = new StringBuilder(1 + String.valueOf(value).length()).append(upperCase).append(value).toString();
        }
        return string;
    }
    
    public static boolean startsWithIgnoreCase(final String s, final String s2) {
        return s.regionMatches(true, 0, s2, 0, s2.length());
    }
    
    public static boolean endsWithIgnoreCase(final String s, final String s2) {
        final int length = s2.length();
        return s.regionMatches(true, s.length() - length, s2, 0, length);
    }
    
    public static String truncateStringForUtf8Storage(final String s, final int n) {
        if (n < 0) {
            throw new IndexOutOfBoundsException();
        }
        int n2 = 0;
        for (int i = 0; i < s.length(); ++i) {
            final char char1 = s.charAt(i);
            if (char1 < '\u0080') {
                ++n2;
            }
            else if (char1 < '\u0800') {
                n2 += 2;
            }
            else if (char1 < '\ud800' || char1 > '\udfff' || s.codePointAt(i) < 65536) {
                n2 += 3;
            }
            else {
                n2 += 4;
                i += ((n2 <= n) ? 1 : 0);
            }
            if (n2 > n) {
                return s.substring(0, i);
            }
        }
        return s;
    }
    
    public static String truncateIfNecessary(final String s, final int n) {
        if (s.length() <= n) {
            return s;
        }
        final String trimTrailing = CharMatcher.WHITESPACE.trimTrailingFrom(unicodePreservingSubstring(s, 0, n));
        if (trimTrailing.length() < n) {
            return trimTrailing;
        }
        if (CharMatcher.WHITESPACE.matches(s.charAt(n))) {
            return trimTrailing;
        }
        for (int i = trimTrailing.length() - 1; i >= 0; --i) {
            if (CharMatcher.WHITESPACE.matches(trimTrailing.charAt(i))) {
                return CharMatcher.WHITESPACE.trimTrailingFrom(trimTrailing.substring(0, i));
            }
        }
        return trimTrailing;
    }
    
    public static String truncateAtMaxLength(final String s, final int n, final boolean b) {
        if (s.length() <= n) {
            return s;
        }
        if (b && n > 3) {
            return String.valueOf(unicodePreservingSubstring(s, 0, n - 3)).concat("...");
        }
        return unicodePreservingSubstring(s, 0, n);
    }
    
    @VisibleForTesting
    static int unicodePreservingIndex(final String s, final int n) {
        if (n > 0 && n < s.length() && Character.isHighSurrogate(s.charAt(n - 1)) && Character.isLowSurrogate(s.charAt(n))) {
            return n - 1;
        }
        return n;
    }
    
    public static String unicodePreservingSubstring(final String s, final int n, final int n2) {
        return s.substring(unicodePreservingIndex(s, n), unicodePreservingIndex(s, n2));
    }
    
    public static String unicodePreservingSubstring(final String s, final int n) {
        return unicodePreservingSubstring(s, n, s.length());
    }
    
    @VisibleForTesting
    static boolean mustEscapeCharInJsString(final int n) {
        return StringUtil.JS_ESCAPE_CHARS.contains(n);
    }
    
    @VisibleForTesting
    static boolean mustEscapeCharInJsonString(final int n) {
        return StringUtil.JSON_ESCAPE_CHARS.contains(n);
    }
    
    @VisibleForTesting
    static boolean mustEscapeCharInJsonOrJsString(final int n) {
        return StringUtil.JSON_OR_JS_ESCAPE_CHARS.contains(n);
    }
    
    static {
        NEWLINE_SPLITTER = Splitter.on('\n').omitEmptyStrings();
        TO_WORDS = Splitter.on(CharMatcher.BREAKING_WHITESPACE).omitEmptyStrings();
        FANCY_SINGLE_QUOTE = CharMatcher.anyOf("\u0091\u0092\u2018\u2019");
        FANCY_DOUBLE_QUOTE = CharMatcher.anyOf("\u0093\u0094\u201c\u201d");
        final HashMap<String, Character> hashMap = new HashMap<String, Character>(252);
        hashMap.put("&nbsp", ' ');
        hashMap.put("&iexcl", '¡');
        hashMap.put("&cent", '¢');
        hashMap.put("&pound", '£');
        hashMap.put("&curren", '¤');
        hashMap.put("&yen", '¥');
        hashMap.put("&brvbar", '¦');
        hashMap.put("&sect", '§');
        hashMap.put("&uml", '¨');
        hashMap.put("&copy", '©');
        hashMap.put("&ordf", 'ª');
        hashMap.put("&laquo", '«');
        hashMap.put("&not", '¬');
        hashMap.put("&shy", '\u00ad');
        hashMap.put("&reg", '®');
        hashMap.put("&macr", '¯');
        hashMap.put("&deg", '°');
        hashMap.put("&plusmn", '±');
        hashMap.put("&sup2", '²');
        hashMap.put("&sup3", '³');
        hashMap.put("&acute", '´');
        hashMap.put("&micro", 'µ');
        hashMap.put("&para", '¶');
        hashMap.put("&middot", '·');
        hashMap.put("&cedil", '¸');
        hashMap.put("&sup1", '¹');
        hashMap.put("&ordm", 'º');
        hashMap.put("&raquo", '»');
        hashMap.put("&frac14", '¼');
        hashMap.put("&frac12", '½');
        hashMap.put("&frac34", '¾');
        hashMap.put("&iquest", '¿');
        hashMap.put("&Agrave", '\u00c0');
        hashMap.put("&Aacute", '\u00c1');
        hashMap.put("&Acirc", '\u00c2');
        hashMap.put("&Atilde", '\u00c3');
        hashMap.put("&Auml", '\u00c4');
        hashMap.put("&Aring", '\u00c5');
        hashMap.put("&AElig", '\u00c6');
        hashMap.put("&Ccedil", '\u00c7');
        hashMap.put("&Egrave", '\u00c8');
        hashMap.put("&Eacute", '\u00c9');
        hashMap.put("&Ecirc", '\u00ca');
        hashMap.put("&Euml", '\u00cb');
        hashMap.put("&Igrave", '\u00cc');
        hashMap.put("&Iacute", '\u00cd');
        hashMap.put("&Icirc", '\u00ce');
        hashMap.put("&Iuml", '\u00cf');
        hashMap.put("&ETH", '\u00d0');
        hashMap.put("&Ntilde", '\u00d1');
        hashMap.put("&Ograve", '\u00d2');
        hashMap.put("&Oacute", '\u00d3');
        hashMap.put("&Ocirc", '\u00d4');
        hashMap.put("&Otilde", '\u00d5');
        hashMap.put("&Ouml", '\u00d6');
        hashMap.put("&times", '\u00d7');
        hashMap.put("&Oslash", '\u00d8');
        hashMap.put("&Ugrave", '\u00d9');
        hashMap.put("&Uacute", '\u00da');
        hashMap.put("&Ucirc", '\u00db');
        hashMap.put("&Uuml", '\u00dc');
        hashMap.put("&Yacute", '\u00dd');
        hashMap.put("&THORN", '\u00de');
        hashMap.put("&szlig", '\u00df');
        hashMap.put("&agrave", '\u00e0');
        hashMap.put("&aacute", '\u00e1');
        hashMap.put("&acirc", '\u00e2');
        hashMap.put("&atilde", '\u00e3');
        hashMap.put("&auml", '\u00e4');
        hashMap.put("&aring", '\u00e5');
        hashMap.put("&aelig", '\u00e6');
        hashMap.put("&ccedil", '\u00e7');
        hashMap.put("&egrave", '\u00e8');
        hashMap.put("&eacute", '\u00e9');
        hashMap.put("&ecirc", '\u00ea');
        hashMap.put("&euml", '\u00eb');
        hashMap.put("&igrave", '\u00ec');
        hashMap.put("&iacute", '\u00ed');
        hashMap.put("&icirc", '\u00ee');
        hashMap.put("&iuml", '\u00ef');
        hashMap.put("&eth", '\u00f0');
        hashMap.put("&ntilde", '\u00f1');
        hashMap.put("&ograve", '\u00f2');
        hashMap.put("&oacute", '\u00f3');
        hashMap.put("&ocirc", '\u00f4');
        hashMap.put("&otilde", '\u00f5');
        hashMap.put("&ouml", '\u00f6');
        hashMap.put("&divide", '\u00f7');
        hashMap.put("&oslash", '\u00f8');
        hashMap.put("&ugrave", '\u00f9');
        hashMap.put("&uacute", '\u00fa');
        hashMap.put("&ucirc", '\u00fb');
        hashMap.put("&uuml", '\u00fc');
        hashMap.put("&yacute", '\u00fd');
        hashMap.put("&thorn", '\u00fe');
        hashMap.put("&yuml", '\u00ff');
        hashMap.put("&fnof", '\u0192');
        hashMap.put("&Alpha", '\u0391');
        hashMap.put("&Beta", '\u0392');
        hashMap.put("&Gamma", '\u0393');
        hashMap.put("&Delta", '\u0394');
        hashMap.put("&Epsilon", '\u0395');
        hashMap.put("&Zeta", '\u0396');
        hashMap.put("&Eta", '\u0397');
        hashMap.put("&Theta", '\u0398');
        hashMap.put("&Iota", '\u0399');
        hashMap.put("&Kappa", '\u039a');
        hashMap.put("&Lambda", '\u039b');
        hashMap.put("&Mu", '\u039c');
        hashMap.put("&Nu", '\u039d');
        hashMap.put("&Xi", '\u039e');
        hashMap.put("&Omicron", '\u039f');
        hashMap.put("&Pi", '\u03a0');
        hashMap.put("&Rho", '\u03a1');
        hashMap.put("&Sigma", '\u03a3');
        hashMap.put("&Tau", '\u03a4');
        hashMap.put("&Upsilon", '\u03a5');
        hashMap.put("&Phi", '\u03a6');
        hashMap.put("&Chi", '\u03a7');
        hashMap.put("&Psi", '\u03a8');
        hashMap.put("&Omega", '\u03a9');
        hashMap.put("&alpha", '\u03b1');
        hashMap.put("&beta", '\u03b2');
        hashMap.put("&gamma", '\u03b3');
        hashMap.put("&delta", '\u03b4');
        hashMap.put("&epsilon", '\u03b5');
        hashMap.put("&zeta", '\u03b6');
        hashMap.put("&eta", '\u03b7');
        hashMap.put("&theta", '\u03b8');
        hashMap.put("&iota", '\u03b9');
        hashMap.put("&kappa", '\u03ba');
        hashMap.put("&lambda", '\u03bb');
        hashMap.put("&mu", '\u03bc');
        hashMap.put("&nu", '\u03bd');
        hashMap.put("&xi", '\u03be');
        hashMap.put("&omicron", '\u03bf');
        hashMap.put("&pi", '\u03c0');
        hashMap.put("&rho", '\u03c1');
        hashMap.put("&sigmaf", '\u03c2');
        hashMap.put("&sigma", '\u03c3');
        hashMap.put("&tau", '\u03c4');
        hashMap.put("&upsilon", '\u03c5');
        hashMap.put("&phi", '\u03c6');
        hashMap.put("&chi", '\u03c7');
        hashMap.put("&psi", '\u03c8');
        hashMap.put("&omega", '\u03c9');
        hashMap.put("&thetasym", '\u03d1');
        hashMap.put("&upsih", '\u03d2');
        hashMap.put("&piv", '\u03d6');
        hashMap.put("&bull", '\u2022');
        hashMap.put("&hellip", '\u2026');
        hashMap.put("&prime", '\u2032');
        hashMap.put("&Prime", '\u2033');
        hashMap.put("&oline", '\u203e');
        hashMap.put("&frasl", '\u2044');
        hashMap.put("&weierp", '\u2118');
        hashMap.put("&image", '\u2111');
        hashMap.put("&real", '\u211c');
        hashMap.put("&trade", '\u2122');
        hashMap.put("&alefsym", '\u2135');
        hashMap.put("&larr", '\u2190');
        hashMap.put("&uarr", '\u2191');
        hashMap.put("&rarr", '\u2192');
        hashMap.put("&darr", '\u2193');
        hashMap.put("&harr", '\u2194');
        hashMap.put("&crarr", '\u21b5');
        hashMap.put("&lArr", '\u21d0');
        hashMap.put("&uArr", '\u21d1');
        hashMap.put("&rArr", '\u21d2');
        hashMap.put("&dArr", '\u21d3');
        hashMap.put("&hArr", '\u21d4');
        hashMap.put("&forall", '\u2200');
        hashMap.put("&part", '\u2202');
        hashMap.put("&exist", '\u2203');
        hashMap.put("&empty", '\u2205');
        hashMap.put("&nabla", '\u2207');
        hashMap.put("&isin", '\u2208');
        hashMap.put("&notin", '\u2209');
        hashMap.put("&ni", '\u220b');
        hashMap.put("&prod", '\u220f');
        hashMap.put("&sum", '\u2211');
        hashMap.put("&minus", '\u2212');
        hashMap.put("&lowast", '\u2217');
        hashMap.put("&radic", '\u221a');
        hashMap.put("&prop", '\u221d');
        hashMap.put("&infin", '\u221e');
        hashMap.put("&ang", '\u2220');
        hashMap.put("&and", '\u2227');
        hashMap.put("&or", '\u2228');
        hashMap.put("&cap", '\u2229');
        hashMap.put("&cup", '\u222a');
        hashMap.put("&int", '\u222b');
        hashMap.put("&there4", '\u2234');
        hashMap.put("&sim", '\u223c');
        hashMap.put("&cong", '\u2245');
        hashMap.put("&asymp", '\u2248');
        hashMap.put("&ne", '\u2260');
        hashMap.put("&equiv", '\u2261');
        hashMap.put("&le", '\u2264');
        hashMap.put("&ge", '\u2265');
        hashMap.put("&sub", '\u2282');
        hashMap.put("&sup", '\u2283');
        hashMap.put("&nsub", '\u2284');
        hashMap.put("&sube", '\u2286');
        hashMap.put("&supe", '\u2287');
        hashMap.put("&oplus", '\u2295');
        hashMap.put("&otimes", '\u2297');
        hashMap.put("&perp", '\u22a5');
        hashMap.put("&sdot", '\u22c5');
        hashMap.put("&lceil", '\u2308');
        hashMap.put("&rceil", '\u2309');
        hashMap.put("&lfloor", '\u230a');
        hashMap.put("&rfloor", '\u230b');
        hashMap.put("&lang", '\u2329');
        hashMap.put("&rang", '\u232a');
        hashMap.put("&loz", '\u25ca');
        hashMap.put("&spades", '\u2660');
        hashMap.put("&clubs", '\u2663');
        hashMap.put("&hearts", '\u2665');
        hashMap.put("&diams", '\u2666');
        hashMap.put("&quot", '\"');
        hashMap.put("&amp", '&');
        hashMap.put("&lt", '<');
        hashMap.put("&gt", '>');
        hashMap.put("&apos", '\'');
        hashMap.put("&OElig", '\u0152');
        hashMap.put("&oelig", '\u0153');
        hashMap.put("&Scaron", '\u0160');
        hashMap.put("&scaron", '\u0161');
        hashMap.put("&Yuml", '\u0178');
        hashMap.put("&circ", '\u02c6');
        hashMap.put("&tilde", '\u02dc');
        hashMap.put("&ensp", '\u2002');
        hashMap.put("&emsp", '\u2003');
        hashMap.put("&thinsp", '\u2009');
        hashMap.put("&zwnj", '\u200c');
        hashMap.put("&zwj", '\u200d');
        hashMap.put("&lrm", '\u200e');
        hashMap.put("&rlm", '\u200f');
        hashMap.put("&ndash", '\u2013');
        hashMap.put("&mdash", '\u2014');
        hashMap.put("&lsquo", '\u2018');
        hashMap.put("&rsquo", '\u2019');
        hashMap.put("&sbquo", '\u201a');
        hashMap.put("&ldquo", '\u201c');
        hashMap.put("&rdquo", '\u201d');
        hashMap.put("&bdquo", '\u201e');
        hashMap.put("&dagger", '\u2020');
        hashMap.put("&Dagger", '\u2021');
        hashMap.put("&permil", '\u2030');
        hashMap.put("&lsaquo", '\u2039');
        hashMap.put("&rsaquo", '\u203a');
        hashMap.put("&euro", '\u20ac');
        ESCAPE_STRINGS = Collections.unmodifiableMap((Map<?, ?>)hashMap);
        HEX_LETTER = CharMatcher.inRange('A', 'F').or(CharMatcher.inRange('a', 'f'));
        LT_GT_ESCAPE = new StringUtil$CharEscaperBuilder().addEscape('<', "&lt;").addEscape('>', "&gt;").toEscaper();
        HTML_TAG_PATTERN = Pattern.compile("</?[a-zA-Z][^>]*>");
        CHARACTER_REFERENCE_PATTERN = Pattern.compile("&#?[a-zA-Z0-9]{1,8};");
        final HashSet<Character.UnicodeBlock> set = new HashSet<Character.UnicodeBlock>();
        set.add(Character.UnicodeBlock.HANGUL_JAMO);
        set.add(Character.UnicodeBlock.CJK_RADICALS_SUPPLEMENT);
        set.add(Character.UnicodeBlock.KANGXI_RADICALS);
        set.add(Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION);
        set.add(Character.UnicodeBlock.HIRAGANA);
        set.add(Character.UnicodeBlock.KATAKANA);
        set.add(Character.UnicodeBlock.BOPOMOFO);
        set.add(Character.UnicodeBlock.HANGUL_COMPATIBILITY_JAMO);
        set.add(Character.UnicodeBlock.KANBUN);
        set.add(Character.UnicodeBlock.BOPOMOFO_EXTENDED);
        set.add(Character.UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS);
        set.add(Character.UnicodeBlock.ENCLOSED_CJK_LETTERS_AND_MONTHS);
        set.add(Character.UnicodeBlock.CJK_COMPATIBILITY);
        set.add(Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A);
        set.add(Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS);
        set.add(Character.UnicodeBlock.HANGUL_SYLLABLES);
        set.add(Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS);
        set.add(Character.UnicodeBlock.CJK_COMPATIBILITY_FORMS);
        set.add(Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS);
        set.add(Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B);
        set.add(Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT);
        CJK_BLOCKS = Collections.unmodifiableSet((Set<?>)set);
        hexChars = "0123456789abcdef".toCharArray();
        octalChars = "01234567".toCharArray();
        JS_ESCAPE_CHARS = new StringUtil$CodePointSet$Builder().addCodePoint(173).addRange(1536, 1539).addCodePoint(1757).addCodePoint(1807).addRange(6068, 6069).addRange(8203, 8207).addRange(8234, 8238).addRange(8288, 8292).addRange(8298, 8303).addCodePoint(65279).addRange(65529, 65531).addRange(119155, 119162).addCodePoint(917505).addRange(917536, 917631).addCodePoint(0).addCodePoint(10).addCodePoint(13).addRange(8232, 8233).addCodePoint(133).addCodePoint(Character.codePointAt("'", 0)).addCodePoint(Character.codePointAt("\"", 0)).addCodePoint(Character.codePointAt("&", 0)).addCodePoint(Character.codePointAt("<", 0)).addCodePoint(Character.codePointAt(">", 0)).addCodePoint(Character.codePointAt("=", 0)).addCodePoint(Character.codePointAt("\\", 0)).create();
        JSON_ESCAPE_CHARS = new StringUtil$CodePointSet$Builder().addCodePoint(Character.codePointAt("\"", 0)).addCodePoint(Character.codePointAt("\\", 0)).addRange(0, 31).create();
        JSON_OR_JS_ESCAPE_CHARS = StringUtil.JSON_ESCAPE_CHARS.or(StringUtil.JS_ESCAPE_CHARS);
    }
}
