/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.TextFormat$1;
import com.google.protobuf.TextFormat$2;
import com.google.protobuf.TextFormat$ByteSequence;
import com.google.protobuf.TextFormat$InvalidEscapeSequenceException;
import com.google.protobuf.TextFormat$Parser;
import com.google.protobuf.TextFormat$Printer;
import com.google.protobuf.TextFormat$TextGenerator;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Locale;
import java.util.logging.Logger;

public final class TextFormat {
    private static final Logger logger = Logger.getLogger(TextFormat.class.getName());
    private static final TextFormat$Printer DEFAULT_PRINTER = new TextFormat$Printer(null);
    private static final TextFormat$Printer SINGLE_LINE_PRINTER = TextFormat$Printer.access$100(new TextFormat$Printer(null), true);
    private static final TextFormat$Printer UNICODE_PRINTER = TextFormat$Printer.access$200(new TextFormat$Printer(null), false);
    private static final TextFormat$Parser PARSER = TextFormat$Parser.newBuilder().build();

    private TextFormat() {
    }

    public static void print(MessageOrBuilder messageOrBuilder, Appendable appendable) {
        TextFormat$Printer.access$400(DEFAULT_PRINTER, messageOrBuilder, new TextFormat$TextGenerator(appendable, null));
    }

    public static void print(UnknownFieldSet unknownFieldSet, Appendable appendable) {
        TextFormat$Printer.access$500(DEFAULT_PRINTER, unknownFieldSet, new TextFormat$TextGenerator(appendable, null));
    }

    public static void printUnicode(MessageOrBuilder messageOrBuilder, Appendable appendable) {
        TextFormat$Printer.access$400(UNICODE_PRINTER, messageOrBuilder, new TextFormat$TextGenerator(appendable, null));
    }

    public static void printUnicode(UnknownFieldSet unknownFieldSet, Appendable appendable) {
        TextFormat$Printer.access$500(UNICODE_PRINTER, unknownFieldSet, new TextFormat$TextGenerator(appendable, null));
    }

    public static String shortDebugString(MessageOrBuilder messageOrBuilder) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            TextFormat$Printer.access$400(SINGLE_LINE_PRINTER, messageOrBuilder, new TextFormat$TextGenerator(stringBuilder, null));
            return stringBuilder.toString().trim();
        }
        catch (IOException var1_2) {
            throw new IllegalStateException(var1_2);
        }
    }

    public static String shortDebugString(UnknownFieldSet unknownFieldSet) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            TextFormat$Printer.access$500(SINGLE_LINE_PRINTER, unknownFieldSet, new TextFormat$TextGenerator(stringBuilder, null));
            return stringBuilder.toString().trim();
        }
        catch (IOException var1_2) {
            throw new IllegalStateException(var1_2);
        }
    }

    public static String printToString(MessageOrBuilder messageOrBuilder) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            TextFormat.print(messageOrBuilder, (Appendable)stringBuilder);
            return stringBuilder.toString();
        }
        catch (IOException var1_2) {
            throw new IllegalStateException(var1_2);
        }
    }

    public static String printToString(UnknownFieldSet unknownFieldSet) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            TextFormat.print(unknownFieldSet, (Appendable)stringBuilder);
            return stringBuilder.toString();
        }
        catch (IOException var1_2) {
            throw new IllegalStateException(var1_2);
        }
    }

    public static String printToUnicodeString(MessageOrBuilder messageOrBuilder) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            TextFormat$Printer.access$400(UNICODE_PRINTER, messageOrBuilder, new TextFormat$TextGenerator(stringBuilder, null));
            return stringBuilder.toString();
        }
        catch (IOException var1_2) {
            throw new IllegalStateException(var1_2);
        }
    }

    public static String printToUnicodeString(UnknownFieldSet unknownFieldSet) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            TextFormat$Printer.access$500(UNICODE_PRINTER, unknownFieldSet, new TextFormat$TextGenerator(stringBuilder, null));
            return stringBuilder.toString();
        }
        catch (IOException var1_2) {
            throw new IllegalStateException(var1_2);
        }
    }

    public static void printField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object, Appendable appendable) {
        TextFormat$Printer.access$600(DEFAULT_PRINTER, descriptors$FieldDescriptor, object, new TextFormat$TextGenerator(appendable, null));
    }

    public static String printFieldToString(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            TextFormat.printField(descriptors$FieldDescriptor, object, stringBuilder);
            return stringBuilder.toString();
        }
        catch (IOException var2_3) {
            throw new IllegalStateException(var2_3);
        }
    }

    public static void printFieldValue(Descriptors$FieldDescriptor descriptors$FieldDescriptor, Object object, Appendable appendable) {
        TextFormat$Printer.access$700(DEFAULT_PRINTER, descriptors$FieldDescriptor, object, new TextFormat$TextGenerator(appendable, null));
    }

    public static void printUnknownFieldValue(int n2, Object object, Appendable appendable) {
        TextFormat.printUnknownFieldValue(n2, object, new TextFormat$TextGenerator(appendable, null));
    }

    private static void printUnknownFieldValue(int n2, Object object, TextFormat$TextGenerator textFormat$TextGenerator) {
        switch (WireFormat.getTagWireType(n2)) {
            case 0: {
                textFormat$TextGenerator.print(TextFormat.unsignedToString((Long)object));
                return;
            }
            case 5: {
                textFormat$TextGenerator.print(String.format((Locale)null, "0x%08x", (Integer)object));
                return;
            }
            case 1: {
                textFormat$TextGenerator.print(String.format((Locale)null, "0x%016x", (Long)object));
                return;
            }
            case 2: {
                textFormat$TextGenerator.print("\"");
                textFormat$TextGenerator.print(TextFormat.escapeBytes((ByteString)object));
                textFormat$TextGenerator.print("\"");
                return;
            }
            case 3: {
                TextFormat$Printer.access$500(DEFAULT_PRINTER, (UnknownFieldSet)object, textFormat$TextGenerator);
                return;
            }
        }
        int n3 = n2;
        throw new IllegalArgumentException(new StringBuilder(20).append("Bad tag: ").append(n3).toString());
    }

    public static String unsignedToString(int n2) {
        if (n2 < 0) return Long.toString((long)n2 & 0xFFFFFFFFL);
        return Integer.toString(n2);
    }

    public static String unsignedToString(long l2) {
        if (l2 < 0) return BigInteger.valueOf(l2 & Long.MAX_VALUE).setBit(63).toString();
        return Long.toString(l2);
    }

    public static TextFormat$Parser getParser() {
        return PARSER;
    }

    public static void merge(Readable readable, Message$Builder message$Builder) {
        PARSER.merge(readable, message$Builder);
    }

    public static void merge(CharSequence charSequence, Message$Builder message$Builder) {
        PARSER.merge(charSequence, message$Builder);
    }

    public static void merge(Readable readable, ExtensionRegistry extensionRegistry, Message$Builder message$Builder) {
        PARSER.merge(readable, extensionRegistry, message$Builder);
    }

    public static void merge(CharSequence charSequence, ExtensionRegistry extensionRegistry, Message$Builder message$Builder) {
        PARSER.merge(charSequence, extensionRegistry, message$Builder);
    }

    /*
     * Unable to fully structure code
     */
    public static String escapeBytes(TextFormat$ByteSequence var0) {
        var1_1 = new StringBuilder(var0.size());
        var2_2 = 0;
        while (var2_2 < var0.size()) {
            var3_3 = var0.byteAt(var2_2);
            switch (var3_3) {
                case 7: {
                    var1_1.append("\\a");
                    ** break;
                }
                case 8: {
                    var1_1.append("\\b");
                    ** break;
                }
                case 12: {
                    var1_1.append("\\f");
                    ** break;
                }
                case 10: {
                    var1_1.append("\\n");
                    ** break;
                }
                case 13: {
                    var1_1.append("\\r");
                    ** break;
                }
                case 9: {
                    var1_1.append("\\t");
                    ** break;
                }
                case 11: {
                    var1_1.append("\\v");
                    ** break;
                }
                case 92: {
                    var1_1.append("\\\\");
                    ** break;
                }
                case 39: {
                    var1_1.append("\\'");
                    ** break;
                }
                case 34: {
                    var1_1.append("\\\"");
                    ** break;
                }
            }
            if (var3_3 >= 32 && var3_3 <= 126) {
                var1_1.append((char)var3_3);
                ** break;
            }
            var1_1.append('\\');
            var1_1.append((char)(48 + (var3_3 >>> 6 & 3)));
            var1_1.append((char)(48 + (var3_3 >>> 3 & 7)));
            var1_1.append((char)(48 + (var3_3 & 7)));
lbl43: // 12 sources:
            ++var2_2;
        }
        return var1_1.toString();
    }

    public static String escapeBytes(ByteString byteString) {
        return TextFormat.escapeBytes(new TextFormat$1(byteString));
    }

    public static String escapeBytes(byte[] arrby) {
        return TextFormat.escapeBytes(new TextFormat$2(arrby));
    }

    /*
     * Unable to fully structure code
     */
    public static ByteString unescapeBytes(CharSequence var0) {
        var1_1 = ByteString.copyFromUtf8(var0.toString());
        var2_2 = new byte[var1_1.size()];
        var3_3 = 0;
        var4_4 = 0;
        while (var4_4 < var1_1.size()) {
            var5_5 = var1_1.byteAt(var4_4);
            if (var5_5 != 92) ** GOTO lbl60
            if (var4_4 + 1 >= var1_1.size()) throw new TextFormat$InvalidEscapeSequenceException("Invalid escape sequence: '\\' at end of string.");
            if (!TextFormat.isOctal(var5_5 = var1_1.byteAt(++var4_4))) ** GOTO lbl17
            var6_6 = TextFormat.digitValue(var5_5);
            if (var4_4 + 1 < var1_1.size() && TextFormat.isOctal(var1_1.byteAt(var4_4 + 1))) {
                var6_6 = var6_6 * 8 + TextFormat.digitValue(var1_1.byteAt(++var4_4));
            }
            if (var4_4 + 1 < var1_1.size() && TextFormat.isOctal(var1_1.byteAt(var4_4 + 1))) {
                var6_6 = var6_6 * 8 + TextFormat.digitValue(var1_1.byteAt(++var4_4));
            }
            var2_2[var3_3++] = (byte)var6_6;
            ** GOTO lbl61
lbl17: // 1 sources:
            switch (var5_5) {
                case 97: {
                    var2_2[var3_3++] = 7;
                    ** GOTO lbl61
                }
                case 98: {
                    var2_2[var3_3++] = 8;
                    ** GOTO lbl61
                }
                case 102: {
                    var2_2[var3_3++] = 12;
                    ** GOTO lbl61
                }
                case 110: {
                    var2_2[var3_3++] = 10;
                    ** GOTO lbl61
                }
                case 114: {
                    var2_2[var3_3++] = 13;
                    ** GOTO lbl61
                }
                case 116: {
                    var2_2[var3_3++] = 9;
                    ** GOTO lbl61
                }
                case 118: {
                    var2_2[var3_3++] = 11;
                    ** GOTO lbl61
                }
                case 92: {
                    var2_2[var3_3++] = 92;
                    ** GOTO lbl61
                }
                case 39: {
                    var2_2[var3_3++] = 39;
                    ** GOTO lbl61
                }
                case 34: {
                    var2_2[var3_3++] = 34;
                    ** GOTO lbl61
                }
                case 120: {
                    var6_6 = 0;
                    if (var4_4 + 1 >= var1_1.size()) throw new TextFormat$InvalidEscapeSequenceException("Invalid escape sequence: '\\x' with no digits");
                    if (TextFormat.isHex(var1_1.byteAt(var4_4 + 1)) == false) throw new TextFormat$InvalidEscapeSequenceException("Invalid escape sequence: '\\x' with no digits");
                    var6_6 = TextFormat.digitValue(var1_1.byteAt(++var4_4));
                    if (var4_4 + 1 < var1_1.size() && TextFormat.isHex(var1_1.byteAt(var4_4 + 1))) {
                        var6_6 = var6_6 * 16 + TextFormat.digitValue(var1_1.byteAt(++var4_4));
                    }
                    var2_2[var3_3++] = (byte)var6_6;
                    ** GOTO lbl61
                }
                default: {
                    var7_7 = (char)var5_5;
                    throw new TextFormat$InvalidEscapeSequenceException(new StringBuilder(29).append("Invalid escape sequence: '\\").append(var7_7).append("'").toString());
                }
            }
lbl60: // 1 sources:
            var2_2[var3_3++] = var5_5;
lbl61: // 13 sources:
            ++var4_4;
        }
        return ByteString.copyFrom(var2_2, 0, var3_3);
    }

    static String escapeText(String string) {
        return TextFormat.escapeBytes(ByteString.copyFromUtf8(string));
    }

    public static String escapeDoubleQuotesAndBackslashes(String string) {
        return string.replace("\\", "\\\\").replace("\"", "\\\"");
    }

    static String unescapeText(String string) {
        return TextFormat.unescapeBytes(string).toStringUtf8();
    }

    private static boolean isOctal(byte by2) {
        if (48 > by2) return false;
        if (by2 > 55) return false;
        return true;
    }

    private static boolean isHex(byte by2) {
        if (48 <= by2) {
            if (by2 <= 57) return true;
        }
        if (97 <= by2) {
            if (by2 <= 102) return true;
        }
        if (65 > by2) return false;
        if (by2 > 70) return false;
        return true;
    }

    private static int digitValue(byte by2) {
        if (48 <= by2 && by2 <= 57) {
            return by2 - 48;
        }
        if (97 > by2) return by2 - 65 + 10;
        if (by2 > 122) return by2 - 65 + 10;
        return by2 - 97 + 10;
    }

    static int parseInt32(String string) {
        return (int)TextFormat.parseInteger(string, true, false);
    }

    static int parseUInt32(String string) {
        return (int)TextFormat.parseInteger(string, false, false);
    }

    static long parseInt64(String string) {
        return TextFormat.parseInteger(string, true, true);
    }

    static long parseUInt64(String string) {
        return TextFormat.parseInteger(string, false, true);
    }

    private static long parseInteger(String string, boolean bl2, boolean bl3) {
        String string2;
        int n2 = 0;
        boolean bl4 = false;
        if (string.startsWith("-", n2)) {
            if (!bl2) {
                String string3;
                String string4 = String.valueOf(string);
                if (string4.length() != 0) {
                    string3 = "Number must be positive: ".concat(string4);
                    throw new NumberFormatException(string3);
                }
                string3 = new String("Number must be positive: ");
                throw new NumberFormatException(string3);
            }
            ++n2;
            bl4 = true;
        }
        int n3 = 10;
        if (string.startsWith("0x", n2)) {
            n2 += 2;
            n3 = 16;
        } else if (string.startsWith("0", n2)) {
            n3 = 8;
        }
        String string5 = string.substring(n2);
        long l2 = 0;
        if (string5.length() < 16) {
            String string6;
            l2 = Long.parseLong(string5, n3);
            if (bl4) {
                l2 = - l2;
            }
            if (bl3) return l2;
            if (bl2) {
                String string7;
                if (l2 <= Integer.MAX_VALUE) {
                    if (l2 >= Integer.MIN_VALUE) return l2;
                }
                String string8 = String.valueOf(string);
                if (string8.length() != 0) {
                    string7 = "Number out of range for 32-bit signed integer: ".concat(string8);
                    throw new NumberFormatException(string7);
                }
                string7 = new String("Number out of range for 32-bit signed integer: ");
                throw new NumberFormatException(string7);
            }
            if (l2 < 0x100000000L) {
                if (l2 >= 0) return l2;
            }
            String string9 = String.valueOf(string);
            if (string9.length() != 0) {
                string6 = "Number out of range for 32-bit unsigned integer: ".concat(string9);
                throw new NumberFormatException(string6);
            }
            string6 = new String("Number out of range for 32-bit unsigned integer: ");
            throw new NumberFormatException(string6);
        }
        BigInteger bigInteger = new BigInteger(string5, n3);
        if (bl4) {
            bigInteger = bigInteger.negate();
        }
        if (!bl3) {
            String string10;
            if (bl2) {
                String string11;
                if (bigInteger.bitLength() <= 31) return bigInteger.longValue();
                String string12 = String.valueOf(string);
                if (string12.length() != 0) {
                    string11 = "Number out of range for 32-bit signed integer: ".concat(string12);
                    throw new NumberFormatException(string11);
                }
                string11 = new String("Number out of range for 32-bit signed integer: ");
                throw new NumberFormatException(string11);
            }
            if (bigInteger.bitLength() <= 32) return bigInteger.longValue();
            String string13 = String.valueOf(string);
            if (string13.length() != 0) {
                string10 = "Number out of range for 32-bit unsigned integer: ".concat(string13);
                throw new NumberFormatException(string10);
            }
            string10 = new String("Number out of range for 32-bit unsigned integer: ");
            throw new NumberFormatException(string10);
        }
        if (bl2) {
            String string14;
            if (bigInteger.bitLength() <= 63) return bigInteger.longValue();
            String string15 = String.valueOf(string);
            if (string15.length() != 0) {
                string14 = "Number out of range for 64-bit signed integer: ".concat(string15);
                throw new NumberFormatException(string14);
            }
            string14 = new String("Number out of range for 64-bit signed integer: ");
            throw new NumberFormatException(string14);
        }
        if (bigInteger.bitLength() <= 64) return bigInteger.longValue();
        String string16 = String.valueOf(string);
        if (string16.length() != 0) {
            string2 = "Number out of range for 64-bit unsigned integer: ".concat(string16);
            throw new NumberFormatException(string2);
        }
        string2 = new String("Number out of range for 64-bit unsigned integer: ");
        throw new NumberFormatException(string2);
    }

    static /* synthetic */ void access$800(int n2, Object object, TextFormat$TextGenerator textFormat$TextGenerator) {
        TextFormat.printUnknownFieldValue(n2, object, textFormat$TextGenerator);
    }

    static /* synthetic */ Logger access$1100() {
        return logger;
    }
}

