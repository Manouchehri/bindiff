package com.google.security.zynamics.zylib.general;

import java.awt.*;
import javax.xml.bind.*;
import com.google.common.base.*;

public final class Convert
{
    private static String[] HEX_ARRAY;
    
    public static String asciiToHexString(final String s) {
        final StringBuffer sb = new StringBuffer();
        final byte[] bytes = s.getBytes();
        for (int length = bytes.length, i = 0; i < length; ++i) {
            sb.append(byteToHexString(bytes[i]));
        }
        return sb.toString();
    }
    
    public static String byteToHexString(final byte b) {
        return Convert.HEX_ARRAY[b & 0xFF];
    }
    
    public static String colorToHexString(final Color color) {
        return Integer.toHexString(color.getRGB()).substring(2);
    }
    
    public static String decStringToHexString(final String s) {
        Preconditions.checkNotNull(s, (Object)"Error: Decimal string can't be null");
        return Long.toHexString(Long.valueOf(s, 16));
    }
    
    public static String hexStringToAsciiString(final String s) {
        String s2;
        if (s.length() % 2 == 0) {
            s2 = s;
        }
        else {
            final String s3 = "0";
            final String value = String.valueOf(s);
            s2 = ((value.length() != 0) ? s3.concat(value) : new String(s3));
        }
        final String s4 = s2;
        String string = "";
        for (int i = 0; i < s4.length(); i += 2) {
            final char char1 = s4.charAt(i);
            final char char2 = s4.charAt(i + 1);
            if (!isHexCharacter(char1) || !isHexCharacter(char2)) {
                throw new IllegalArgumentException("Error: Invalid hex string");
            }
            final char c = (char)((Character.digit(char1, 16) << 4) + Character.digit(char2, 16));
            final String value2 = String.valueOf(string);
            final String value3 = String.valueOf(isPrintableCharacter(c) ? c : ".");
            string = new StringBuilder(0 + String.valueOf(value2).length() + String.valueOf(value3).length()).append(value2).append(value3).toString();
        }
        return string;
    }
    
    public static byte[] hexStringToBytes(final String s) {
        return DatatypeConverter.parseHexBinary(s);
    }
    
    public static long hexStringToLong(final String s) {
        Preconditions.checkNotNull(s, (Object)"Error: Unicode string can't be null");
        Preconditions.checkArgument(isHexString(s), (Object)String.format("Error: Hex string '%s' is not a vaild hex string", s));
        if (s.length() == 16 && s.charAt(0) >= '\b') {
            return (Long.parseLong(s.substring(0, s.length() - 8), 16) << 32) + Long.parseLong(s.substring(s.length() - 8), 16);
        }
        return Long.parseLong(s, 16);
    }
    
    public static boolean isDecCharacter(final char c) {
        return CharMatcher.inRange('0', '9').apply(Character.valueOf(c));
    }
    
    public static boolean isDecString(final String s) {
        Preconditions.checkNotNull(s);
        final CharMatcher inRange = CharMatcher.inRange('0', '9');
        for (int i = 0; i < s.length(); ++i) {
            if (!inRange.apply(Character.valueOf(s.charAt(i)))) {
                return false;
            }
        }
        return s.length() != 0;
    }
    
    public static boolean isHexCharacter(final char c) {
        return isDecCharacter(c) || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F');
    }
    
    public static boolean isHexString(final String s) {
        Preconditions.checkNotNull(s, (Object)"Error: String argument can't be null");
        final CharMatcher or = CharMatcher.inRange('0', '9').or(CharMatcher.inRange('a', 'z')).or(CharMatcher.inRange('A', 'F'));
        for (int i = 0; i < s.length(); ++i) {
            if (!or.apply(Character.valueOf(s.charAt(i)))) {
                return false;
            }
        }
        return s.length() != 0;
    }
    
    public static boolean isMD5String(final String s) {
        Preconditions.checkNotNull(s, (Object)"Error: String argument can't be null");
        return s.length() == 32 && isHexString(s);
    }
    
    public static boolean isPrintableCharacter(final char c) {
        final Character.UnicodeBlock of = Character.UnicodeBlock.of(c);
        return !Character.isISOControl(c) && c != '\uffff' && of != null && of != Character.UnicodeBlock.SPECIALS;
    }
    
    public static boolean isSha1String(final String s) {
        Preconditions.checkNotNull(s, (Object)"Error: String argument can't be null");
        return s.length() == 40 && isHexString(s);
    }
    
    public static String unicodeToHexString(final String s) {
        Preconditions.checkNotNull(s, (Object)"Error: Unicode string can't be null");
        final StringBuffer sb = new StringBuffer();
        final byte[] bytes = s.getBytes();
        for (int length = bytes.length, i = 0; i < length; ++i) {
            sb.append(String.format("%X00", bytes[i]));
        }
        return sb.toString();
    }
    
    static {
        Convert.HEX_ARRAY = new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "0A", "0B", "0C", "0D", "0E", "0F", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "1A", "1B", "1C", "1D", "1E", "1F", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "2A", "2B", "2C", "2D", "2E", "2F", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "3A", "3B", "3C", "3D", "3E", "3F", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "4A", "4B", "4C", "4D", "4E", "4F", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "5A", "5B", "5C", "5D", "5E", "5F", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "6A", "6B", "6C", "6D", "6E", "6F", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "7A", "7B", "7C", "7D", "7E", "7F", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "8A", "8B", "8C", "8D", "8E", "8F", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "9A", "9B", "9C", "9D", "9E", "9F", "A0", "A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "AA", "AB", "AC", "AD", "AE", "AF", "B0", "B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9", "BA", "BB", "BC", "BD", "BE", "BF", "C0", "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "CA", "CB", "CC", "CD", "CE", "CF", "D0", "D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "DA", "DB", "DC", "DD", "DE", "DF", "E0", "E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8", "E9", "EA", "EB", "EC", "ED", "EE", "EF", "F0", "F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9", "FA", "FB", "FC", "FD", "FE", "FF" };
    }
}
