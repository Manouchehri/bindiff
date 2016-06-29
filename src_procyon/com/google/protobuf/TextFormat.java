package com.google.protobuf;

import java.util.logging.*;
import java.io.*;
import java.math.*;
import java.util.*;

public final class TextFormat
{
    private static final Logger logger;
    private static final TextFormat$Printer DEFAULT_PRINTER;
    private static final TextFormat$Printer SINGLE_LINE_PRINTER;
    private static final TextFormat$Printer UNICODE_PRINTER;
    private static final TextFormat$Parser PARSER;
    
    public static void print(final MessageOrBuilder messageOrBuilder, final Appendable appendable) {
        TextFormat.DEFAULT_PRINTER.print(messageOrBuilder, new TextFormat$TextGenerator(appendable, null));
    }
    
    public static void print(final UnknownFieldSet set, final Appendable appendable) {
        TextFormat.DEFAULT_PRINTER.printUnknownFields(set, new TextFormat$TextGenerator(appendable, null));
    }
    
    public static void printUnicode(final MessageOrBuilder messageOrBuilder, final Appendable appendable) {
        TextFormat.UNICODE_PRINTER.print(messageOrBuilder, new TextFormat$TextGenerator(appendable, null));
    }
    
    public static void printUnicode(final UnknownFieldSet set, final Appendable appendable) {
        TextFormat.UNICODE_PRINTER.printUnknownFields(set, new TextFormat$TextGenerator(appendable, null));
    }
    
    public static String shortDebugString(final MessageOrBuilder messageOrBuilder) {
        try {
            final StringBuilder sb = new StringBuilder();
            TextFormat.SINGLE_LINE_PRINTER.print(messageOrBuilder, new TextFormat$TextGenerator(sb, null));
            return sb.toString().trim();
        }
        catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }
    
    public static String shortDebugString(final UnknownFieldSet set) {
        try {
            final StringBuilder sb = new StringBuilder();
            TextFormat.SINGLE_LINE_PRINTER.printUnknownFields(set, new TextFormat$TextGenerator(sb, null));
            return sb.toString().trim();
        }
        catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }
    
    public static String printToString(final MessageOrBuilder messageOrBuilder) {
        try {
            final StringBuilder sb = new StringBuilder();
            print(messageOrBuilder, sb);
            return sb.toString();
        }
        catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }
    
    public static String printToString(final UnknownFieldSet set) {
        try {
            final StringBuilder sb = new StringBuilder();
            print(set, sb);
            return sb.toString();
        }
        catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }
    
    public static String printToUnicodeString(final MessageOrBuilder messageOrBuilder) {
        try {
            final StringBuilder sb = new StringBuilder();
            TextFormat.UNICODE_PRINTER.print(messageOrBuilder, new TextFormat$TextGenerator(sb, null));
            return sb.toString();
        }
        catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }
    
    public static String printToUnicodeString(final UnknownFieldSet set) {
        try {
            final StringBuilder sb = new StringBuilder();
            TextFormat.UNICODE_PRINTER.printUnknownFields(set, new TextFormat$TextGenerator(sb, null));
            return sb.toString();
        }
        catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }
    
    public static void printField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final Object o, final Appendable appendable) {
        TextFormat.DEFAULT_PRINTER.printField(descriptors$FieldDescriptor, o, new TextFormat$TextGenerator(appendable, null));
    }
    
    public static String printFieldToString(final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final Object o) {
        try {
            final StringBuilder sb = new StringBuilder();
            printField(descriptors$FieldDescriptor, o, sb);
            return sb.toString();
        }
        catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }
    
    public static void printFieldValue(final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final Object o, final Appendable appendable) {
        TextFormat.DEFAULT_PRINTER.printFieldValue(descriptors$FieldDescriptor, o, new TextFormat$TextGenerator(appendable, null));
    }
    
    public static void printUnknownFieldValue(final int n, final Object o, final Appendable appendable) {
        printUnknownFieldValue(n, o, new TextFormat$TextGenerator(appendable, null));
    }
    
    private static void printUnknownFieldValue(final int n, final Object o, final TextFormat$TextGenerator textFormat$TextGenerator) {
        switch (WireFormat.getTagWireType(n)) {
            case 0: {
                textFormat$TextGenerator.print(unsignedToString((long)o));
                break;
            }
            case 5: {
                textFormat$TextGenerator.print(String.format(null, "0x%08x", (Integer)o));
                break;
            }
            case 1: {
                textFormat$TextGenerator.print(String.format(null, "0x%016x", (Long)o));
                break;
            }
            case 2: {
                textFormat$TextGenerator.print("\"");
                textFormat$TextGenerator.print(escapeBytes((ByteString)o));
                textFormat$TextGenerator.print("\"");
                break;
            }
            case 3: {
                TextFormat.DEFAULT_PRINTER.printUnknownFields((UnknownFieldSet)o, textFormat$TextGenerator);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuilder(20).append("Bad tag: ").append(n).toString());
            }
        }
    }
    
    public static String unsignedToString(final int n) {
        if (n >= 0) {
            return Integer.toString(n);
        }
        return Long.toString(n & 0xFFFFFFFFL);
    }
    
    public static String unsignedToString(final long n) {
        if (n >= 0L) {
            return Long.toString(n);
        }
        return BigInteger.valueOf(n & Long.MAX_VALUE).setBit(63).toString();
    }
    
    public static TextFormat$Parser getParser() {
        return TextFormat.PARSER;
    }
    
    public static void merge(final Readable readable, final Message$Builder message$Builder) {
        TextFormat.PARSER.merge(readable, message$Builder);
    }
    
    public static void merge(final CharSequence charSequence, final Message$Builder message$Builder) {
        TextFormat.PARSER.merge(charSequence, message$Builder);
    }
    
    public static void merge(final Readable readable, final ExtensionRegistry extensionRegistry, final Message$Builder message$Builder) {
        TextFormat.PARSER.merge(readable, extensionRegistry, message$Builder);
    }
    
    public static void merge(final CharSequence charSequence, final ExtensionRegistry extensionRegistry, final Message$Builder message$Builder) {
        TextFormat.PARSER.merge(charSequence, extensionRegistry, message$Builder);
    }
    
    public static String escapeBytes(final TextFormat$ByteSequence textFormat$ByteSequence) {
        final StringBuilder sb = new StringBuilder(textFormat$ByteSequence.size());
        for (int i = 0; i < textFormat$ByteSequence.size(); ++i) {
            final byte byte1 = textFormat$ByteSequence.byteAt(i);
            switch (byte1) {
                case 7: {
                    sb.append("\\a");
                    break;
                }
                case 8: {
                    sb.append("\\b");
                    break;
                }
                case 12: {
                    sb.append("\\f");
                    break;
                }
                case 10: {
                    sb.append("\\n");
                    break;
                }
                case 13: {
                    sb.append("\\r");
                    break;
                }
                case 9: {
                    sb.append("\\t");
                    break;
                }
                case 11: {
                    sb.append("\\v");
                    break;
                }
                case 92: {
                    sb.append("\\\\");
                    break;
                }
                case 39: {
                    sb.append("\\'");
                    break;
                }
                case 34: {
                    sb.append("\\\"");
                    break;
                }
                default: {
                    if (byte1 >= 32 && byte1 <= 126) {
                        sb.append((char)byte1);
                        break;
                    }
                    sb.append('\\');
                    sb.append((char)(48 + (byte1 >>> 6 & 0x3)));
                    sb.append((char)(48 + (byte1 >>> 3 & 0x7)));
                    sb.append((char)(48 + (byte1 & 0x7)));
                    break;
                }
            }
        }
        return sb.toString();
    }
    
    public static String escapeBytes(final ByteString byteString) {
        return escapeBytes(new TextFormat$1(byteString));
    }
    
    public static String escapeBytes(final byte[] array) {
        return escapeBytes(new TextFormat$2(array));
    }
    
    public static ByteString unescapeBytes(final CharSequence charSequence) {
        final ByteString copyFromUtf8 = ByteString.copyFromUtf8(charSequence.toString());
        final byte[] array = new byte[copyFromUtf8.size()];
        int n = 0;
        for (int i = 0; i < copyFromUtf8.size(); ++i) {
            final byte byte1 = copyFromUtf8.byteAt(i);
            if (byte1 == 92) {
                if (i + 1 >= copyFromUtf8.size()) {
                    throw new TextFormat$InvalidEscapeSequenceException("Invalid escape sequence: '\\' at end of string.");
                }
                ++i;
                final byte byte2 = copyFromUtf8.byteAt(i);
                if (isOctal(byte2)) {
                    int digitValue = digitValue(byte2);
                    if (i + 1 < copyFromUtf8.size() && isOctal(copyFromUtf8.byteAt(i + 1))) {
                        ++i;
                        digitValue = digitValue * 8 + digitValue(copyFromUtf8.byteAt(i));
                    }
                    if (i + 1 < copyFromUtf8.size() && isOctal(copyFromUtf8.byteAt(i + 1))) {
                        ++i;
                        digitValue = digitValue * 8 + digitValue(copyFromUtf8.byteAt(i));
                    }
                    array[n++] = (byte)digitValue;
                }
                else {
                    switch (byte2) {
                        case 97: {
                            array[n++] = 7;
                            break;
                        }
                        case 98: {
                            array[n++] = 8;
                            break;
                        }
                        case 102: {
                            array[n++] = 12;
                            break;
                        }
                        case 110: {
                            array[n++] = 10;
                            break;
                        }
                        case 114: {
                            array[n++] = 13;
                            break;
                        }
                        case 116: {
                            array[n++] = 9;
                            break;
                        }
                        case 118: {
                            array[n++] = 11;
                            break;
                        }
                        case 92: {
                            array[n++] = 92;
                            break;
                        }
                        case 39: {
                            array[n++] = 39;
                            break;
                        }
                        case 34: {
                            array[n++] = 34;
                            break;
                        }
                        case 120: {
                            if (i + 1 < copyFromUtf8.size() && isHex(copyFromUtf8.byteAt(i + 1))) {
                                ++i;
                                int digitValue2 = digitValue(copyFromUtf8.byteAt(i));
                                if (i + 1 < copyFromUtf8.size() && isHex(copyFromUtf8.byteAt(i + 1))) {
                                    ++i;
                                    digitValue2 = digitValue2 * 16 + digitValue(copyFromUtf8.byteAt(i));
                                }
                                array[n++] = (byte)digitValue2;
                                break;
                            }
                            throw new TextFormat$InvalidEscapeSequenceException("Invalid escape sequence: '\\x' with no digits");
                        }
                        default: {
                            throw new TextFormat$InvalidEscapeSequenceException(new StringBuilder(29).append("Invalid escape sequence: '\\").append((char)byte2).append("'").toString());
                        }
                    }
                }
            }
            else {
                array[n++] = byte1;
            }
        }
        return ByteString.copyFrom(array, 0, n);
    }
    
    static String escapeText(final String s) {
        return escapeBytes(ByteString.copyFromUtf8(s));
    }
    
    public static String escapeDoubleQuotesAndBackslashes(final String s) {
        return s.replace("\\", "\\\\").replace("\"", "\\\"");
    }
    
    static String unescapeText(final String s) {
        return unescapeBytes(s).toStringUtf8();
    }
    
    private static boolean isOctal(final byte b) {
        return 48 <= b && b <= 55;
    }
    
    private static boolean isHex(final byte b) {
        return (48 <= b && b <= 57) || (97 <= b && b <= 102) || (65 <= b && b <= 70);
    }
    
    private static int digitValue(final byte b) {
        if (48 <= b && b <= 57) {
            return b - 48;
        }
        if (97 <= b && b <= 122) {
            return b - 97 + 10;
        }
        return b - 65 + 10;
    }
    
    static int parseInt32(final String s) {
        return (int)parseInteger(s, true, false);
    }
    
    static int parseUInt32(final String s) {
        return (int)parseInteger(s, false, false);
    }
    
    static long parseInt64(final String s) {
        return parseInteger(s, true, true);
    }
    
    static long parseUInt64(final String s) {
        return parseInteger(s, false, true);
    }
    
    private static long parseInteger(final String s, final boolean b, final boolean b2) {
        int n = 0;
        boolean b3 = false;
        if (s.startsWith("-", n)) {
            if (!b) {
                final String s2 = "Number must be positive: ";
                final String value = String.valueOf(s);
                throw new NumberFormatException((value.length() != 0) ? s2.concat(value) : new String(s2));
            }
            ++n;
            b3 = true;
        }
        int n2 = 10;
        if (s.startsWith("0x", n)) {
            n += 2;
            n2 = 16;
        }
        else if (s.startsWith("0", n)) {
            n2 = 8;
        }
        final String substring = s.substring(n);
        long n3;
        if (substring.length() < 16) {
            n3 = Long.parseLong(substring, n2);
            if (b3) {
                n3 = -n3;
            }
            if (!b2) {
                if (b) {
                    if (n3 > 2147483647L || n3 < -2147483648L) {
                        final String s3 = "Number out of range for 32-bit signed integer: ";
                        final String value2 = String.valueOf(s);
                        throw new NumberFormatException((value2.length() != 0) ? s3.concat(value2) : new String(s3));
                    }
                }
                else if (n3 >= 4294967296L || n3 < 0L) {
                    final String s4 = "Number out of range for 32-bit unsigned integer: ";
                    final String value3 = String.valueOf(s);
                    throw new NumberFormatException((value3.length() != 0) ? s4.concat(value3) : new String(s4));
                }
            }
        }
        else {
            BigInteger negate = new BigInteger(substring, n2);
            if (b3) {
                negate = negate.negate();
            }
            if (!b2) {
                if (b) {
                    if (negate.bitLength() > 31) {
                        final String s5 = "Number out of range for 32-bit signed integer: ";
                        final String value4 = String.valueOf(s);
                        throw new NumberFormatException((value4.length() != 0) ? s5.concat(value4) : new String(s5));
                    }
                }
                else if (negate.bitLength() > 32) {
                    final String s6 = "Number out of range for 32-bit unsigned integer: ";
                    final String value5 = String.valueOf(s);
                    throw new NumberFormatException((value5.length() != 0) ? s6.concat(value5) : new String(s6));
                }
            }
            else if (b) {
                if (negate.bitLength() > 63) {
                    final String s7 = "Number out of range for 64-bit signed integer: ";
                    final String value6 = String.valueOf(s);
                    throw new NumberFormatException((value6.length() != 0) ? s7.concat(value6) : new String(s7));
                }
            }
            else if (negate.bitLength() > 64) {
                final String s8 = "Number out of range for 64-bit unsigned integer: ";
                final String value7 = String.valueOf(s);
                throw new NumberFormatException((value7.length() != 0) ? s8.concat(value7) : new String(s8));
            }
            n3 = negate.longValue();
        }
        return n3;
    }
    
    static {
        logger = Logger.getLogger(TextFormat.class.getName());
        DEFAULT_PRINTER = new TextFormat$Printer(null);
        SINGLE_LINE_PRINTER = new TextFormat$Printer(null).setSingleLineMode(true);
        UNICODE_PRINTER = new TextFormat$Printer(null).setEscapeNonAscii(false);
        PARSER = TextFormat$Parser.newBuilder().build();
    }
}
