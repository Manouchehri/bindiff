package com.google.security.zynamics.zylib.general;

import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import java.awt.Color;
import java.lang.Character.UnicodeBlock;
import javax.xml.bind.DatatypeConverter;

public final class Convert {
   private static String[] HEX_ARRAY = new String[]{"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "0A", "0B", "0C", "0D", "0E", "0F", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "1A", "1B", "1C", "1D", "1E", "1F", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "2A", "2B", "2C", "2D", "2E", "2F", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "3A", "3B", "3C", "3D", "3E", "3F", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "4A", "4B", "4C", "4D", "4E", "4F", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "5A", "5B", "5C", "5D", "5E", "5F", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "6A", "6B", "6C", "6D", "6E", "6F", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "7A", "7B", "7C", "7D", "7E", "7F", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "8A", "8B", "8C", "8D", "8E", "8F", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "9A", "9B", "9C", "9D", "9E", "9F", "A0", "A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "AA", "AB", "AC", "AD", "AE", "AF", "B0", "B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9", "BA", "BB", "BC", "BD", "BE", "BF", "C0", "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "CA", "CB", "CC", "CD", "CE", "CF", "D0", "D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "DA", "DB", "DC", "DD", "DE", "DF", "E0", "E1", "E2", "E3", "E4", "E5", "E6", "E7", "E8", "E9", "EA", "EB", "EC", "ED", "EE", "EF", "F0", "F1", "F2", "F3", "F4", "F5", "F6", "F7", "F8", "F9", "FA", "FB", "FC", "FD", "FE", "FF"};

   public static String asciiToHexString(String var0) {
      StringBuffer var1 = new StringBuffer();
      byte[] var2 = var0.getBytes();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         byte var5 = var2[var4];
         var1.append(byteToHexString(var5));
      }

      return var1.toString();
   }

   public static String byteToHexString(byte var0) {
      return HEX_ARRAY[var0 & 255];
   }

   public static String colorToHexString(Color var0) {
      String var1 = Integer.toHexString(var0.getRGB());
      return var1.substring(2);
   }

   public static String decStringToHexString(String var0) {
      Preconditions.checkNotNull(var0, "Error: Decimal string can\'t be null");
      return Long.toHexString(Long.valueOf(var0, 16).longValue());
   }

   public static String hexStringToAsciiString(String var0) {
      // $FF: Couldn't be decompiled
   }

   public static byte[] hexStringToBytes(String var0) {
      return DatatypeConverter.parseHexBinary(var0);
   }

   public static long hexStringToLong(String var0) {
      Preconditions.checkNotNull(var0, "Error: Unicode string can\'t be null");
      Preconditions.checkArgument(isHexString(var0), String.format("Error: Hex string \'%s\' is not a vaild hex string", new Object[]{var0}));
      if(var0.length() == 16 && var0.charAt(0) >= 8) {
         String var1 = var0.substring(0, var0.length() - 8);
         String var2 = var0.substring(var0.length() - 8);
         return (Long.parseLong(var1, 16) << 32) + Long.parseLong(var2, 16);
      } else {
         return Long.parseLong(var0, 16);
      }
   }

   public static boolean isDecCharacter(char var0) {
      return CharMatcher.inRange('0', '9').apply(Character.valueOf(var0));
   }

   public static boolean isDecString(String var0) {
      Preconditions.checkNotNull(var0);
      CharMatcher var1 = CharMatcher.inRange('0', '9');

      for(int var2 = 0; var2 < var0.length(); ++var2) {
         if(!var1.apply(Character.valueOf(var0.charAt(var2)))) {
            return false;
         }
      }

      return var0.length() != 0;
   }

   public static boolean isHexCharacter(char var0) {
      return isDecCharacter(var0) || var0 >= 97 && var0 <= 102 || var0 >= 65 && var0 <= 70;
   }

   public static boolean isHexString(String var0) {
      Preconditions.checkNotNull(var0, "Error: String argument can\'t be null");
      CharMatcher var1 = CharMatcher.inRange('0', '9').or(CharMatcher.inRange('a', 'z')).or(CharMatcher.inRange('A', 'F'));

      for(int var2 = 0; var2 < var0.length(); ++var2) {
         if(!var1.apply(Character.valueOf(var0.charAt(var2)))) {
            return false;
         }
      }

      return var0.length() != 0;
   }

   public static boolean isMD5String(String var0) {
      Preconditions.checkNotNull(var0, "Error: String argument can\'t be null");
      return var0.length() == 32 && isHexString(var0);
   }

   public static boolean isPrintableCharacter(char var0) {
      UnicodeBlock var1 = UnicodeBlock.of(var0);
      return !Character.isISOControl(var0) && var0 != '\uffff' && var1 != null && var1 != UnicodeBlock.SPECIALS;
   }

   public static boolean isSha1String(String var0) {
      Preconditions.checkNotNull(var0, "Error: String argument can\'t be null");
      return var0.length() == 40 && isHexString(var0);
   }

   public static String unicodeToHexString(String var0) {
      Preconditions.checkNotNull(var0, "Error: Unicode string can\'t be null");
      StringBuffer var1 = new StringBuffer();
      byte[] var2 = var0.getBytes();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         byte var5 = var2[var4];
         var1.append(String.format("%X00", new Object[]{Byte.valueOf(var5)}));
      }

      return var1.toString();
   }
}
