/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.general;

import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import java.awt.Color;
import javax.xml.bind.DatatypeConverter;

public final class Convert {
    private static String[] HEX_ARRAY = new String[]{"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "0A", "0B", "0C", "0D", "0E", "0F", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "1A", "1B", "1C", "1D", "1E", "1F", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "2A", "2B", "2C", "2D", "2E", "2F", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "3A", "3B", "3C", "3D", "3E", "3F", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "4A", "4B", "4C", "4D", "4E", "4F", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "5A", "5B", "5C", "5D", "5E", "5F", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "6A", "6B", "6C", "6D", "6E", "6F", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "7A", "7B", "7C", "7D", "7E", "7F", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "8A", "8B", "8C", "8D", "8E", "8F", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "9A", "9B", "9C", "9D", "9E", "9F", "A0", "A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "AA", "AB", "AC", "AD", "AE", "AF", "B0", "B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9", "BA", "BB", "BC", "BD", "BE", "BF", "C0", "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "CA", "CB", "CC", "CD", "CE", "CF", "D0", "D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "DA", "DB", "DC", "DD", "DE", "DF", "E0", "E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8", "E9", "EA", "EB", "EC", "ED", "EE", "EF", "F0", "F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9", "FA", "FB", "FC", "FD", "FE", "FF"};

    public static String asciiToHexString(String string) {
        StringBuffer stringBuffer = new StringBuffer();
        byte[] arrby = string.getBytes();
        int n2 = arrby.length;
        int n3 = 0;
        while (n3 < n2) {
            byte by2 = arrby[n3];
            stringBuffer.append(Convert.byteToHexString(by2));
            ++n3;
        }
        return stringBuffer.toString();
    }

    public static String byteToHexString(byte by2) {
        return HEX_ARRAY[by2 & 255];
    }

    public static String colorToHexString(Color color) {
        String string = Integer.toHexString(color.getRGB());
        return string.substring(2);
    }

    public static String decStringToHexString(String string) {
        Preconditions.checkNotNull(string, "Error: Decimal string can't be null");
        return Long.toHexString(Long.valueOf(string, 16));
    }

    public static String hexStringToAsciiString(String string) {
        String string2;
        if (string.length() % 2 == 0) {
            string2 = string;
        } else {
            String string3 = String.valueOf(string);
            string2 = string3.length() != 0 ? "0".concat(string3) : new String("0");
        }
        String string4 = string2;
        String string5 = "";
        int n2 = 0;
        while (n2 < string4.length()) {
            char c2 = string4.charAt(n2);
            char c3 = string4.charAt(n2 + 1);
            if (!Convert.isHexCharacter(c2)) throw new IllegalArgumentException("Error: Invalid hex string");
            if (!Convert.isHexCharacter(c3)) {
                throw new IllegalArgumentException("Error: Invalid hex string");
            }
            char c4 = (char)((Character.digit(c2, 16) << 4) + Character.digit(c3, 16));
            String string6 = String.valueOf(string5);
            String string7 = String.valueOf(Convert.isPrintableCharacter(c4) ? Character.valueOf(c4) : ".");
            string5 = new StringBuilder(0 + String.valueOf(string6).length() + String.valueOf(string7).length()).append(string6).append(string7).toString();
            n2 += 2;
        }
        return string5;
    }

    public static byte[] hexStringToBytes(String string) {
        return DatatypeConverter.parseHexBinary(string);
    }

    public static long hexStringToLong(String string) {
        Preconditions.checkNotNull(string, "Error: Unicode string can't be null");
        Preconditions.checkArgument(Convert.isHexString(string), String.format("Error: Hex string '%s' is not a vaild hex string", string));
        if (string.length() != 16) return Long.parseLong(string, 16);
        if (string.charAt(0) < '\b') return Long.parseLong(string, 16);
        String string2 = string.substring(0, string.length() - 8);
        String string3 = string.substring(string.length() - 8);
        return (Long.parseLong(string2, 16) << 32) + Long.parseLong(string3, 16);
    }

    public static boolean isDecCharacter(char c2) {
        return CharMatcher.inRange('0', '9').apply(Character.valueOf(c2));
    }

    public static boolean isDecString(String string) {
        Preconditions.checkNotNull(string);
        CharMatcher charMatcher = CharMatcher.inRange('0', '9');
        for (int i2 = 0; i2 < string.length(); ++i2) {
            if (charMatcher.apply(Character.valueOf(string.charAt(i2)))) continue;
            return false;
        }
        if (string.length() == 0) return false;
        return true;
    }

    public static boolean isHexCharacter(char c2) {
        if (Convert.isDecCharacter(c2)) return true;
        if (c2 >= 'a') {
            if (c2 <= 'f') return true;
        }
        if (c2 < 'A') return false;
        if (c2 > 'F') return false;
        return true;
    }

    public static boolean isHexString(String string) {
        Preconditions.checkNotNull(string, "Error: String argument can't be null");
        CharMatcher charMatcher = CharMatcher.inRange('0', '9').or(CharMatcher.inRange('a', 'z')).or(CharMatcher.inRange('A', 'F'));
        for (int i2 = 0; i2 < string.length(); ++i2) {
            if (charMatcher.apply(Character.valueOf(string.charAt(i2)))) continue;
            return false;
        }
        if (string.length() == 0) return false;
        return true;
    }

    public static boolean isMD5String(String string) {
        Preconditions.checkNotNull(string, "Error: String argument can't be null");
        if (string.length() != 32) return false;
        if (!Convert.isHexString(string)) return false;
        return true;
    }

    public static boolean isPrintableCharacter(char c2) {
        Character.UnicodeBlock unicodeBlock = Character.UnicodeBlock.of(c2);
        if (Character.isISOControl(c2)) return false;
        if (c2 == '\uffff') return false;
        if (unicodeBlock == null) return false;
        if (unicodeBlock == Character.UnicodeBlock.SPECIALS) return false;
        return true;
    }

    public static boolean isSha1String(String string) {
        Preconditions.checkNotNull(string, "Error: String argument can't be null");
        if (string.length() != 40) return false;
        if (!Convert.isHexString(string)) return false;
        return true;
    }

    public static String unicodeToHexString(String string) {
        Preconditions.checkNotNull(string, "Error: Unicode string can't be null");
        StringBuffer stringBuffer = new StringBuffer();
        byte[] arrby = string.getBytes();
        int n2 = arrby.length;
        int n3 = 0;
        while (n3 < n2) {
            byte by2 = arrby[n3];
            stringBuffer.append(String.format("%X00", Byte.valueOf(by2)));
            ++n3;
        }
        return stringBuffer.toString();
    }
}

