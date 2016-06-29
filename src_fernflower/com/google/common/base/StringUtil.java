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
import java.lang.Character.UnicodeBlock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

@GoogleInternal
public final class StringUtil {
   private static final Splitter NEWLINE_SPLITTER = Splitter.on('\n').omitEmptyStrings();
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

   public static boolean isEmptyOrWhitespace(@Nullable String var0) {
      return var0 == null || CharMatcher.WHITESPACE.matchesAllOf(var0);
   }

   @Nullable
   public static String toNullIfEmptyOrWhitespace(@Nullable String var0) {
      return isEmptyOrWhitespace(var0)?null:var0;
   }

   public static String fixedWidth(String var0, int var1) {
      ArrayList var2 = new ArrayList();
      Iterator var3 = NEWLINE_SPLITTER.split(var0).iterator();

      while(var3.hasNext()) {
         String var4 = (String)var3.next();
         var2.add(var4);
      }

      String[] var5 = (String[])var2.toArray(new String[0]);
      return fixedWidth(var5, var1);
   }

   @VisibleForTesting
   static String fixedWidth(String[] var0, int var1) {
      ArrayList var2 = new ArrayList();
      String[] var3 = var0;
      int var4 = var0.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         String var6 = var3[var5];
         var2.add(formatLineToFixedWidth(var6, var1));
      }

      return Joiner.on('\n').join((Iterable)var2);
   }

   private static String formatLineToFixedWidth(String var0, int var1) {
      if(var0.length() <= var1) {
         return var0;
      } else {
         StringBuilder var2 = new StringBuilder();
         int var3 = 0;

         String var5;
         for(Iterator var4 = TO_WORDS.split(var0).iterator(); var4.hasNext(); var2.append(var5)) {
            var5 = (String)var4.next();
            if(var3 == 0) {
               var3 = var5.length();
            } else {
               int var6 = var3 + var5.length() + 1;
               if(var6 <= var1) {
                  var2.append(' ');
                  var3 = var6;
               } else {
                  var2.append('\n');
                  var3 = var5.length();
               }
            }
         }

         return var2.toString();
      }
   }

   public static String indent(String var0, int var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append("\n");

      for(int var3 = 0; var3 < var1; ++var3) {
         var2.append("  ");
      }

      return var0.replace("\n", var2.toString());
   }

   @Nullable
   public static String stripPrefix(String var0, String var1) {
      return var0.startsWith(var1)?var0.substring(var1.length()):null;
   }

   @Nullable
   public static String stripPrefixIgnoreCase(String var0, String var1) {
      return startsWithIgnoreCase(var0, var1)?var0.substring(var1.length()):null;
   }

   @Nullable
   public static String stripSuffix(String var0, String var1) {
      return var0.endsWith(var1)?var0.substring(0, var0.length() - var1.length()):null;
   }

   @Nullable
   public static String stripSuffixIgnoreCase(String var0, String var1) {
      return endsWithIgnoreCase(var0, var1)?var0.substring(0, var0.length() - var1.length()):null;
   }

   public static String replaceSmartQuotes(String var0) {
      String var1 = FANCY_SINGLE_QUOTE.replaceFrom(var0, '\'');
      return FANCY_DOUBLE_QUOTE.replaceFrom(var1, '\"');
   }

   @Deprecated
   public static byte[] hexToBytes(CharSequence var0) {
      byte[] var1 = new byte[(var0.length() + 1) / 2];
      if(var0.length() == 0) {
         return var1;
      } else {
         var1[0] = 0;
         int var2 = var0.length() % 2;

         for(int var3 = 0; var3 < var0.length(); ++var3) {
            char var4 = var0.charAt(var3);
            if(var2 % 2 == 0) {
               var1[var2 >> 1] = (byte)(hexValue(var4) << 4);
            } else {
               var1[var2 >> 1] += (byte)hexValue(var4);
            }

            ++var2;
         }

         return var1;
      }
   }

   public static String convertEOLToLF(String var0) {
      StringBuilder var1 = new StringBuilder(var0.length());
      char[] var2 = var0.toCharArray();
      int var3 = 0;
      int var4 = var2.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         if(var2[var5] == 13) {
            var1.append(var2, var3, var5 - var3);
            var1.append('\n');
            if(var5 + 1 < var4 && var2[var5 + 1] == 10) {
               ++var5;
            }

            var3 = var5 + 1;
         }
      }

      if(var3 == 0) {
         return var0;
      } else {
         var1.append(var2, var3, var4 - var3);
         return var1.toString();
      }
   }

   @Nullable
   public static String maskLeft(String var0, int var1, char var2) {
      if(var1 <= 0) {
         return var0;
      } else {
         var1 = Math.min(var1, var0.length());
         StringBuilder var3 = new StringBuilder();

         for(int var4 = 0; var4 < var1; ++var4) {
            var3.append(var2);
         }

         var3.append(var0.substring(var1));
         return var3.toString();
      }
   }

   private static boolean isOctal(char var0) {
      return var0 >= 48 && var0 <= 55;
   }

   private static boolean isHex(char var0) {
      return var0 >= 48 && var0 <= 57 || var0 >= 97 && var0 <= 102 || var0 >= 65 && var0 <= 70;
   }

   private static int hexValue(char var0) {
      if(var0 >= 48 && var0 <= 57) {
         return var0 - 48;
      } else if(var0 >= 97 && var0 <= 102) {
         return var0 - 97 + 10;
      } else if(var0 >= 65 && var0 <= 70) {
         return var0 - 65 + 10;
      } else {
         throw new IllegalArgumentException("char is not a hex char");
      }
   }

   public static String unescapeCString(String var0) {
      if(var0.indexOf(92) < 0) {
         return var0;
      } else {
         StringBuilder var1 = new StringBuilder();
         int var2 = var0.length();

         char var4;
         for(int var3 = 0; var3 < var2; var1.append(var4)) {
            var4 = var0.charAt(var3++);
            if(var4 == 92 && var3 < var2) {
               var4 = var0.charAt(var3++);
               switch(var4) {
               case '\"':
                  var4 = 34;
                  break;
               case '\'':
                  var4 = 39;
                  break;
               case '?':
                  var4 = 63;
                  break;
               case '\\':
                  var4 = 92;
                  break;
               case 'a':
                  var4 = 7;
                  break;
               case 'b':
                  var4 = 8;
                  break;
               case 'f':
                  var4 = 12;
                  break;
               case 'n':
                  var4 = 10;
                  break;
               case 'r':
                  var4 = 13;
                  break;
               case 't':
                  var4 = 9;
                  break;
               case 'v':
                  var4 = 11;
                  break;
               default:
                  int var5;
                  if(var4 == 120 && var3 < var2 && isHex(var0.charAt(var3))) {
                     var5 = hexValue(var0.charAt(var3++));
                     if(var3 < var2 && isHex(var0.charAt(var3))) {
                        var5 = var5 * 16 + hexValue(var0.charAt(var3++));
                     }

                     var4 = (char)var5;
                  } else if(isOctal(var4)) {
                     var5 = var4 - 48;
                     if(var3 < var2 && isOctal(var0.charAt(var3))) {
                        var5 = var5 * 8 + (var0.charAt(var3++) - 48);
                     }

                     if(var3 < var2 && isOctal(var0.charAt(var3))) {
                        var5 = var5 * 8 + (var0.charAt(var3++) - 48);
                     }

                     var4 = (char)var5;
                  } else {
                     var1.append('\\');
                  }
               }
            }
         }

         return var1.toString();
      }
   }

   @Deprecated
   public static String unescapeHTML(String var0) {
      return unescapeHTML(var0, false);
   }

   @Deprecated
   public static String unescapeHTML(String var0, boolean var1) {
      int var2 = var0.indexOf(38);
      if(var2 == -1) {
         return var0;
      } else {
         char[] var3 = var0.toCharArray();
         char[] var4 = new char[var3.length];
         System.arraycopy(var3, 0, var4, 0, var2);
         int var5 = var2;
         int var6 = var2;

         while(true) {
            while(var6 < var3.length) {
               if(var3[var6] != 38) {
                  var4[var5++] = var3[var6++];
               } else {
                  int var7 = var6 + 1;
                  boolean var8 = false;
                  if(var7 < var3.length && var3[var7] == 35) {
                     ++var7;
                     var8 = true;
                  }

                  boolean var9 = false;
                  if(var7 < var3.length && (var3[var7] == 120 || var3[var7] == 88)) {
                     ++var7;
                     var9 = true;
                  }

                  while(var7 < var3.length) {
                     char var10 = var3[var7];
                     boolean var11 = Character.isDigit(var10);
                     if(var8 && (!var9 && !var11 || var9 && !var11 && !HEX_LETTER.matches(var10)) || !var11 && !Character.isLetter(var10)) {
                        break;
                     }

                     ++var7;
                  }

                  boolean var15 = false;
                  if(var7 <= var3.length && var1 || var7 < var3.length && var3[var7] == 59) {
                     if(var6 + 2 < var3.length && var0.charAt(var6 + 1) == 35) {
                        try {
                           long var17 = 0L;
                           char var13 = var0.charAt(var6 + 2);
                           if(var9) {
                              var17 = Long.parseLong(new String(var3, var6 + 3, var7 - var6 - 3), 16);
                           } else if(Character.isDigit(var13)) {
                              var17 = Long.parseLong(new String(var3, var6 + 2, var7 - var6 - 2));
                           }

                           if(var17 > 0L && var17 < 65536L) {
                              var4[var5++] = (char)((int)var17);
                              var15 = true;
                           }
                        } catch (NumberFormatException var14) {
                           ;
                        }
                     } else {
                        String var16 = new String(var3, var6, var7 - var6);
                        Character var12 = (Character)ESCAPE_STRINGS.get(var16);
                        if(var12 != null) {
                           var4[var5++] = var12.charValue();
                           var15 = true;
                        }
                     }

                     if(var7 < var3.length && var3[var7] == 59) {
                        ++var7;
                     }
                  }

                  if(!var15) {
                     System.arraycopy(var3, var6, var4, var5, var7 - var6);
                     var5 += var7 - var6;
                  }

                  var6 = var7;
               }
            }

            return new String(var4, 0, var5);
         }
      }
   }

   @Deprecated
   @Nullable
   public static String stripHtmlTags(@Nullable String var0) {
      if(var0 != null && !"".equals(var0)) {
         String var1 = HTML_TAG_PATTERN.matcher(var0).replaceAll("");
         return LT_GT_ESCAPE.escape(var1);
      } else {
         return var0;
      }
   }

   public static String javaScriptEscape(CharSequence var0) {
      return javaScriptEscapeHelper(var0, false);
   }

   public static String javaScriptEscapeToAscii(CharSequence var0) {
      return javaScriptEscapeHelper(var0, true);
   }

   private static String javaScriptEscapeHelper(CharSequence var0, boolean var1) {
      StringBuilder var2 = new StringBuilder(var0.length() * 9 / 8);

      try {
         escapeStringBody(var0, var1, StringUtil$JsEscapingMode.EMBEDDABLE_JS, var2);
      } catch (IOException var4) {
         throw new RuntimeException(var4);
      }

      return var2.toString();
   }

   public static void escapeStringBody(CharSequence var0, boolean var1, StringUtil$JsEscapingMode var2, Appendable var3) {
      int var4 = 0;
      int var5 = var0.length();
      Preconditions.checkNotNull(var2);

      int var7;
      for(int var8 = 0; var8 < var5; var8 += var7) {
         int var6 = Character.codePointAt(var0, var8);
         var7 = Character.charCount(var6);
         if(shouldEscapeChar(var6, var1, var2)) {
            var3.append(var0, var4, var8);
            var4 = var8 + var7;
            switch(var6) {
            case 8:
               var3.append("\\b");
               continue;
            case 9:
               var3.append("\\t");
               continue;
            case 10:
               var3.append("\\n");
               continue;
            case 12:
               var3.append("\\f");
               continue;
            case 13:
               var3.append("\\r");
               continue;
            case 34:
            case 39:
               if(var2 == StringUtil$JsEscapingMode.JSON && 39 == var6) {
                  var3.append((char)var6);
                  continue;
               }

               if(var2 != StringUtil$JsEscapingMode.EMBEDDABLE_JS) {
                  var3.append('\\').append((char)var6);
                  continue;
               }
               break;
            case 92:
               var3.append("\\\\");
               continue;
            }

            if(var6 < 256 && var2 != StringUtil$JsEscapingMode.JSON) {
               boolean var9 = var8 + var7 >= var5 || isOctal(var0.charAt(var8 + var7));
               appendOctalJavaScriptRepresentation((char)var6, var9, var3);
            } else {
               appendHexJavaScriptRepresentation(var6, var3);
            }
         }
      }

      var3.append(var0, var4, var5);
   }

   private static boolean shouldEscapeChar(int var0, boolean var1, StringUtil$JsEscapingMode var2) {
      return !var1 || var0 >= 32 && var0 <= 126?(var2 == StringUtil$JsEscapingMode.JSON?mustEscapeCharInJsonOrJsString(var0):mustEscapeCharInJsString(var0)):true;
   }

   private static void appendHexJavaScriptRepresentation(int var0, Appendable var1) {
      if(Character.isSupplementaryCodePoint(var0)) {
         char[] var2 = Character.toChars(var0);
         appendHexJavaScriptRepresentation(var2[0], var1);
         appendHexJavaScriptRepresentation(var2[1], var1);
      } else {
         var1.append("\\u").append(hexChars[var0 >>> 12 & 15]).append(hexChars[var0 >>> 8 & 15]).append(hexChars[var0 >>> 4 & 15]).append(hexChars[var0 & 15]);
      }
   }

   private static void appendOctalJavaScriptRepresentation(char var0, boolean var1, Appendable var2) {
      if(var0 < 64 && !var1) {
         if(var0 >= 8) {
            var2.append('\\').append(octalChars[var0 >>> 3 & 7]).append(octalChars[var0 & 7]);
         } else {
            var2.append('\\').append(octalChars[var0 & 7]);
         }
      } else {
         var2.append('\\').append(octalChars[var0 >>> 6 & 7]).append(octalChars[var0 >>> 3 & 7]).append(octalChars[var0 & 7]);
      }

   }

   public static String javaScriptUnescape(String var0) {
      StringBuilder var1 = new StringBuilder(var0.length());
      int var2 = 0;

      while(var2 < var0.length()) {
         char var3 = var0.charAt(var2);
         if(var3 == 92) {
            var2 = javaScriptUnescapeHelper(var0, var2 + 1, var1);
         } else {
            var1.append(var3);
            ++var2;
         }
      }

      return var1.toString();
   }

   private static int javaScriptUnescapeHelper(String var0, int var1, StringBuilder var2) {
      if(var1 >= var0.length()) {
         throw new IllegalArgumentException((new StringBuilder(42 + String.valueOf(var0).length())).append("End-of-string after escape character in [").append(var0).append("]").toString());
      } else {
         char var3 = var0.charAt(var1++);
         switch(var3) {
         case '\"':
         case '\'':
         case '>':
         case '\\':
            var2.append(var3);
            break;
         case '0':
         case '1':
         case '2':
         case '3':
         case '4':
         case '5':
         case '6':
         case '7':
            --var1;
            int var4 = 1;

            for(int var5 = var3 < 52?3:2; var4 < var5 && var1 + var4 < var0.length() && isOctal(var0.charAt(var1 + var4)); ++var4) {
               ;
            }

            var2.append((char)Integer.parseInt(var0.substring(var1, var1 + var4), 8));
            var1 += var4;
            break;
         case 'b':
            var2.append('\b');
            break;
         case 'f':
            var2.append('\f');
            break;
         case 'n':
            var2.append('\n');
            break;
         case 'r':
            var2.append('\r');
            break;
         case 't':
            var2.append('\t');
            break;
         case 'u':
         case 'x':
            int var7 = var3 == 117?4:2;

            String var6;
            try {
               var6 = var0.substring(var1, var1 + var7);
            } catch (IndexOutOfBoundsException var12) {
               String var9 = String.valueOf(var0.substring(var1));
               throw new IllegalArgumentException((new StringBuilder(54 + String.valueOf(var9).length() + String.valueOf(var0).length())).append("Invalid unicode sequence [").append(var9).append("] at index ").append(var1).append(" in [").append(var0).append("]").toString());
            }

            int var8;
            try {
               var8 = Integer.parseInt(var6, 16);
            } catch (NumberFormatException var11) {
               throw new IllegalArgumentException((new StringBuilder(54 + String.valueOf(var6).length() + String.valueOf(var0).length())).append("Invalid unicode sequence [").append(var6).append("] at index ").append(var1).append(" in [").append(var0).append("]").toString());
            }

            var2.append((char)var8);
            var1 += var7;
            break;
         default:
            throw new IllegalArgumentException((new StringBuilder(50 + String.valueOf(var0).length())).append("Unknown escape code [").append(var3).append("] at index ").append(var1).append(" in [").append(var0).append("]").toString());
         }

         return var1;
      }
   }

   @Deprecated
   public static HashMap splitToMap(String var0, @Nullable String var1, @Nullable String var2, boolean var3) {
      Preconditions.checkNotNull(var0);
      HashMap var4 = new HashMap();
      if(!Strings.isNullOrEmpty(var1) && !Strings.isNullOrEmpty(var2)) {
         int var5 = var2.length();
         Iterator var6 = Splitter.on(var1).split(var0).iterator();

         while(var6.hasNext()) {
            String var7 = (String)var6.next();
            int var8 = var7.indexOf(var2);
            if(var8 > 0) {
               String var9 = var7.substring(var8 + var5);
               if(var3) {
                  var9 = CharMatcher.WHITESPACE.trimFrom(var9);
               }

               var4.put(CharMatcher.WHITESPACE.trimFrom(var7.substring(0, var8)), var9);
            } else {
               var4.put(CharMatcher.WHITESPACE.trimFrom(var7), "");
            }
         }

         return var4;
      } else {
         var4.put(CharMatcher.WHITESPACE.trimFrom(var0), "");
         return var4;
      }
   }

   @Deprecated
   @Nullable
   public static HashMap string2Map(@Nullable String var0, @Nullable String var1, @Nullable String var2, boolean var3) {
      return var0 == null?null:splitToMap(var0, var1, var2, var3);
   }

   @Deprecated
   public static String[] parseDelimitedList(String var0, char var1) {
      Preconditions.checkNotNull(var0);
      String var2 = (new StringBuilder(1)).append(var1).toString();
      StringTokenizer var3 = new StringTokenizer((new StringBuilder(1 + String.valueOf(var0).length() + String.valueOf(var2).length())).append(var0).append(var2).append(" ").toString(), var2, true);
      ArrayList var4 = new ArrayList();
      String var5 = "";

      String var7;
      for(StringBuilder var6 = new StringBuilder(); var3.hasMoreTokens(); var5 = var7) {
         var7 = var3.nextToken();
         if(var5 != null) {
            if(var7.equals(var2)) {
               var6.append(var5);
               if(var5.equals(var2)) {
                  var7 = null;
               }
            } else {
               if(var6.length() != 0) {
                  var4.add(var6.toString());
               }

               var6.setLength(0);
            }
         }
      }

      return (String[])var4.toArray(new String[0]);
   }

   public static String lastToken(String var0, String var1) {
      return var0.substring(CharMatcher.anyOf(var1).lastIndexIn(var0) + 1);
   }

   @Deprecated
   public static boolean containsCharRef(String var0) {
      return CHARACTER_REFERENCE_PATTERN.matcher(var0).find();
   }

   public static boolean isCjk(String var0) {
      int var1 = var0.length();

      for(int var2 = 0; var2 < var1; ++var2) {
         if(isCjk(var0.codePointAt(var2))) {
            return true;
         }
      }

      return false;
   }

   public static boolean isCjk(char var0) {
      return isCjk((int)var0);
   }

   public static boolean isCjk(int var0) {
      return (var0 & -256) == 0?false:CJK_BLOCKS.contains(UnicodeBlock.of(var0));
   }

   public static int displayWidth(String var0) {
      int var1 = 0;
      int var2 = var0.length();

      for(int var3 = 0; var3 < var2; ++var3) {
         var1 += displayWidth(var0.charAt(var3));
      }

      return var1;
   }

   public static int displayWidth(char var0) {
      return var0 > 1273 && var0 != 1470 && (var0 < 1488 || var0 > 1514) && var0 != 1523 && var0 != 1524 && (var0 < 1536 || var0 > 1791) && (var0 < 1872 || var0 > 1919) && (var0 < 'ﭐ' || var0 > '\ufdff') && (var0 < 'ﹰ' || var0 > '\ufeff') && (var0 < 7680 || var0 > 8367) && (var0 < 8448 || var0 > 8506) && (var0 < 3584 || var0 > 3711) && (var0 < '｡' || var0 > 'ￜ')?2:1;
   }

   @Deprecated
   public static String capitalize(String var0) {
      if(var0.length() == 0) {
         return var0;
      } else {
         char var1 = var0.charAt(0);
         char var2 = Character.toUpperCase(var1);
         String var10000;
         if(var1 == var2) {
            var10000 = var0;
         } else {
            String var3 = String.valueOf(var0.substring(1));
            var10000 = (new StringBuilder(1 + String.valueOf(var3).length())).append(var2).append(var3).toString();
         }

         return var10000;
      }
   }

   public static boolean startsWithIgnoreCase(String var0, String var1) {
      return var0.regionMatches(true, 0, var1, 0, var1.length());
   }

   public static boolean endsWithIgnoreCase(String var0, String var1) {
      int var2 = var1.length();
      return var0.regionMatches(true, var0.length() - var2, var1, 0, var2);
   }

   public static String truncateStringForUtf8Storage(String var0, int var1) {
      if(var1 < 0) {
         throw new IndexOutOfBoundsException();
      } else {
         int var2 = 0;
         int var3 = 0;

         for(int var4 = var0.length(); var3 < var4; ++var3) {
            char var5 = var0.charAt(var3);
            if(var5 < 128) {
               ++var2;
            } else if(var5 < 2048) {
               var2 += 2;
            } else if(var5 >= '\ud800' && var5 <= '\udfff' && var0.codePointAt(var3) >= 65536) {
               var2 += 4;
               var3 += var2 > var1?0:1;
            } else {
               var2 += 3;
            }

            if(var2 > var1) {
               return var0.substring(0, var3);
            }
         }

         return var0;
      }
   }

   public static String truncateIfNecessary(String var0, int var1) {
      if(var0.length() <= var1) {
         return var0;
      } else {
         String var2 = unicodePreservingSubstring(var0, 0, var1);
         String var3 = CharMatcher.WHITESPACE.trimTrailingFrom(var2);
         if(var3.length() < var1) {
            return var3;
         } else if(CharMatcher.WHITESPACE.matches(var0.charAt(var1))) {
            return var3;
         } else {
            for(int var4 = var3.length() - 1; var4 >= 0; --var4) {
               if(CharMatcher.WHITESPACE.matches(var3.charAt(var4))) {
                  String var5 = var3.substring(0, var4);
                  return CharMatcher.WHITESPACE.trimTrailingFrom(var5);
               }
            }

            return var3;
         }
      }
   }

   public static String truncateAtMaxLength(String var0, int var1, boolean var2) {
      return var0.length() <= var1?var0:(var2 && var1 > 3?String.valueOf(unicodePreservingSubstring(var0, 0, var1 - 3)).concat("..."):unicodePreservingSubstring(var0, 0, var1));
   }

   @VisibleForTesting
   static int unicodePreservingIndex(String var0, int var1) {
      return var1 > 0 && var1 < var0.length() && Character.isHighSurrogate(var0.charAt(var1 - 1)) && Character.isLowSurrogate(var0.charAt(var1))?var1 - 1:var1;
   }

   public static String unicodePreservingSubstring(String var0, int var1, int var2) {
      return var0.substring(unicodePreservingIndex(var0, var1), unicodePreservingIndex(var0, var2));
   }

   public static String unicodePreservingSubstring(String var0, int var1) {
      return unicodePreservingSubstring(var0, var1, var0.length());
   }

   @VisibleForTesting
   static boolean mustEscapeCharInJsString(int var0) {
      return JS_ESCAPE_CHARS.contains(var0);
   }

   @VisibleForTesting
   static boolean mustEscapeCharInJsonString(int var0) {
      return JSON_ESCAPE_CHARS.contains(var0);
   }

   @VisibleForTesting
   static boolean mustEscapeCharInJsonOrJsString(int var0) {
      return JSON_OR_JS_ESCAPE_CHARS.contains(var0);
   }

   static {
      TO_WORDS = Splitter.on(CharMatcher.BREAKING_WHITESPACE).omitEmptyStrings();
      FANCY_SINGLE_QUOTE = CharMatcher.anyOf("\u0091\u0092‘’");
      FANCY_DOUBLE_QUOTE = CharMatcher.anyOf("\u0093\u0094“”");
      HashMap var0 = new HashMap(252);
      var0.put("&nbsp", Character.valueOf(' '));
      var0.put("&iexcl", Character.valueOf('¡'));
      var0.put("&cent", Character.valueOf('¢'));
      var0.put("&pound", Character.valueOf('£'));
      var0.put("&curren", Character.valueOf('¤'));
      var0.put("&yen", Character.valueOf('¥'));
      var0.put("&brvbar", Character.valueOf('¦'));
      var0.put("&sect", Character.valueOf('§'));
      var0.put("&uml", Character.valueOf('¨'));
      var0.put("&copy", Character.valueOf('©'));
      var0.put("&ordf", Character.valueOf('ª'));
      var0.put("&laquo", Character.valueOf('«'));
      var0.put("&not", Character.valueOf('¬'));
      var0.put("&shy", Character.valueOf('\u00ad'));
      var0.put("&reg", Character.valueOf('®'));
      var0.put("&macr", Character.valueOf('¯'));
      var0.put("&deg", Character.valueOf('°'));
      var0.put("&plusmn", Character.valueOf('±'));
      var0.put("&sup2", Character.valueOf('²'));
      var0.put("&sup3", Character.valueOf('³'));
      var0.put("&acute", Character.valueOf('´'));
      var0.put("&micro", Character.valueOf('µ'));
      var0.put("&para", Character.valueOf('¶'));
      var0.put("&middot", Character.valueOf('·'));
      var0.put("&cedil", Character.valueOf('¸'));
      var0.put("&sup1", Character.valueOf('¹'));
      var0.put("&ordm", Character.valueOf('º'));
      var0.put("&raquo", Character.valueOf('»'));
      var0.put("&frac14", Character.valueOf('¼'));
      var0.put("&frac12", Character.valueOf('½'));
      var0.put("&frac34", Character.valueOf('¾'));
      var0.put("&iquest", Character.valueOf('¿'));
      var0.put("&Agrave", Character.valueOf('À'));
      var0.put("&Aacute", Character.valueOf('Á'));
      var0.put("&Acirc", Character.valueOf('Â'));
      var0.put("&Atilde", Character.valueOf('Ã'));
      var0.put("&Auml", Character.valueOf('Ä'));
      var0.put("&Aring", Character.valueOf('Å'));
      var0.put("&AElig", Character.valueOf('Æ'));
      var0.put("&Ccedil", Character.valueOf('Ç'));
      var0.put("&Egrave", Character.valueOf('È'));
      var0.put("&Eacute", Character.valueOf('É'));
      var0.put("&Ecirc", Character.valueOf('Ê'));
      var0.put("&Euml", Character.valueOf('Ë'));
      var0.put("&Igrave", Character.valueOf('Ì'));
      var0.put("&Iacute", Character.valueOf('Í'));
      var0.put("&Icirc", Character.valueOf('Î'));
      var0.put("&Iuml", Character.valueOf('Ï'));
      var0.put("&ETH", Character.valueOf('Ð'));
      var0.put("&Ntilde", Character.valueOf('Ñ'));
      var0.put("&Ograve", Character.valueOf('Ò'));
      var0.put("&Oacute", Character.valueOf('Ó'));
      var0.put("&Ocirc", Character.valueOf('Ô'));
      var0.put("&Otilde", Character.valueOf('Õ'));
      var0.put("&Ouml", Character.valueOf('Ö'));
      var0.put("&times", Character.valueOf('×'));
      var0.put("&Oslash", Character.valueOf('Ø'));
      var0.put("&Ugrave", Character.valueOf('Ù'));
      var0.put("&Uacute", Character.valueOf('Ú'));
      var0.put("&Ucirc", Character.valueOf('Û'));
      var0.put("&Uuml", Character.valueOf('Ü'));
      var0.put("&Yacute", Character.valueOf('Ý'));
      var0.put("&THORN", Character.valueOf('Þ'));
      var0.put("&szlig", Character.valueOf('ß'));
      var0.put("&agrave", Character.valueOf('à'));
      var0.put("&aacute", Character.valueOf('á'));
      var0.put("&acirc", Character.valueOf('â'));
      var0.put("&atilde", Character.valueOf('ã'));
      var0.put("&auml", Character.valueOf('ä'));
      var0.put("&aring", Character.valueOf('å'));
      var0.put("&aelig", Character.valueOf('æ'));
      var0.put("&ccedil", Character.valueOf('ç'));
      var0.put("&egrave", Character.valueOf('è'));
      var0.put("&eacute", Character.valueOf('é'));
      var0.put("&ecirc", Character.valueOf('ê'));
      var0.put("&euml", Character.valueOf('ë'));
      var0.put("&igrave", Character.valueOf('ì'));
      var0.put("&iacute", Character.valueOf('í'));
      var0.put("&icirc", Character.valueOf('î'));
      var0.put("&iuml", Character.valueOf('ï'));
      var0.put("&eth", Character.valueOf('ð'));
      var0.put("&ntilde", Character.valueOf('ñ'));
      var0.put("&ograve", Character.valueOf('ò'));
      var0.put("&oacute", Character.valueOf('ó'));
      var0.put("&ocirc", Character.valueOf('ô'));
      var0.put("&otilde", Character.valueOf('õ'));
      var0.put("&ouml", Character.valueOf('ö'));
      var0.put("&divide", Character.valueOf('÷'));
      var0.put("&oslash", Character.valueOf('ø'));
      var0.put("&ugrave", Character.valueOf('ù'));
      var0.put("&uacute", Character.valueOf('ú'));
      var0.put("&ucirc", Character.valueOf('û'));
      var0.put("&uuml", Character.valueOf('ü'));
      var0.put("&yacute", Character.valueOf('ý'));
      var0.put("&thorn", Character.valueOf('þ'));
      var0.put("&yuml", Character.valueOf('ÿ'));
      var0.put("&fnof", Character.valueOf('ƒ'));
      var0.put("&Alpha", Character.valueOf('Α'));
      var0.put("&Beta", Character.valueOf('Β'));
      var0.put("&Gamma", Character.valueOf('Γ'));
      var0.put("&Delta", Character.valueOf('Δ'));
      var0.put("&Epsilon", Character.valueOf('Ε'));
      var0.put("&Zeta", Character.valueOf('Ζ'));
      var0.put("&Eta", Character.valueOf('Η'));
      var0.put("&Theta", Character.valueOf('Θ'));
      var0.put("&Iota", Character.valueOf('Ι'));
      var0.put("&Kappa", Character.valueOf('Κ'));
      var0.put("&Lambda", Character.valueOf('Λ'));
      var0.put("&Mu", Character.valueOf('Μ'));
      var0.put("&Nu", Character.valueOf('Ν'));
      var0.put("&Xi", Character.valueOf('Ξ'));
      var0.put("&Omicron", Character.valueOf('Ο'));
      var0.put("&Pi", Character.valueOf('Π'));
      var0.put("&Rho", Character.valueOf('Ρ'));
      var0.put("&Sigma", Character.valueOf('Σ'));
      var0.put("&Tau", Character.valueOf('Τ'));
      var0.put("&Upsilon", Character.valueOf('Υ'));
      var0.put("&Phi", Character.valueOf('Φ'));
      var0.put("&Chi", Character.valueOf('Χ'));
      var0.put("&Psi", Character.valueOf('Ψ'));
      var0.put("&Omega", Character.valueOf('Ω'));
      var0.put("&alpha", Character.valueOf('α'));
      var0.put("&beta", Character.valueOf('β'));
      var0.put("&gamma", Character.valueOf('γ'));
      var0.put("&delta", Character.valueOf('δ'));
      var0.put("&epsilon", Character.valueOf('ε'));
      var0.put("&zeta", Character.valueOf('ζ'));
      var0.put("&eta", Character.valueOf('η'));
      var0.put("&theta", Character.valueOf('θ'));
      var0.put("&iota", Character.valueOf('ι'));
      var0.put("&kappa", Character.valueOf('κ'));
      var0.put("&lambda", Character.valueOf('λ'));
      var0.put("&mu", Character.valueOf('μ'));
      var0.put("&nu", Character.valueOf('ν'));
      var0.put("&xi", Character.valueOf('ξ'));
      var0.put("&omicron", Character.valueOf('ο'));
      var0.put("&pi", Character.valueOf('π'));
      var0.put("&rho", Character.valueOf('ρ'));
      var0.put("&sigmaf", Character.valueOf('ς'));
      var0.put("&sigma", Character.valueOf('σ'));
      var0.put("&tau", Character.valueOf('τ'));
      var0.put("&upsilon", Character.valueOf('υ'));
      var0.put("&phi", Character.valueOf('φ'));
      var0.put("&chi", Character.valueOf('χ'));
      var0.put("&psi", Character.valueOf('ψ'));
      var0.put("&omega", Character.valueOf('ω'));
      var0.put("&thetasym", Character.valueOf('ϑ'));
      var0.put("&upsih", Character.valueOf('ϒ'));
      var0.put("&piv", Character.valueOf('ϖ'));
      var0.put("&bull", Character.valueOf('•'));
      var0.put("&hellip", Character.valueOf('…'));
      var0.put("&prime", Character.valueOf('′'));
      var0.put("&Prime", Character.valueOf('″'));
      var0.put("&oline", Character.valueOf('‾'));
      var0.put("&frasl", Character.valueOf('⁄'));
      var0.put("&weierp", Character.valueOf('℘'));
      var0.put("&image", Character.valueOf('ℑ'));
      var0.put("&real", Character.valueOf('ℜ'));
      var0.put("&trade", Character.valueOf('™'));
      var0.put("&alefsym", Character.valueOf('ℵ'));
      var0.put("&larr", Character.valueOf('←'));
      var0.put("&uarr", Character.valueOf('↑'));
      var0.put("&rarr", Character.valueOf('→'));
      var0.put("&darr", Character.valueOf('↓'));
      var0.put("&harr", Character.valueOf('↔'));
      var0.put("&crarr", Character.valueOf('↵'));
      var0.put("&lArr", Character.valueOf('⇐'));
      var0.put("&uArr", Character.valueOf('⇑'));
      var0.put("&rArr", Character.valueOf('⇒'));
      var0.put("&dArr", Character.valueOf('⇓'));
      var0.put("&hArr", Character.valueOf('⇔'));
      var0.put("&forall", Character.valueOf('∀'));
      var0.put("&part", Character.valueOf('∂'));
      var0.put("&exist", Character.valueOf('∃'));
      var0.put("&empty", Character.valueOf('∅'));
      var0.put("&nabla", Character.valueOf('∇'));
      var0.put("&isin", Character.valueOf('∈'));
      var0.put("&notin", Character.valueOf('∉'));
      var0.put("&ni", Character.valueOf('∋'));
      var0.put("&prod", Character.valueOf('∏'));
      var0.put("&sum", Character.valueOf('∑'));
      var0.put("&minus", Character.valueOf('−'));
      var0.put("&lowast", Character.valueOf('∗'));
      var0.put("&radic", Character.valueOf('√'));
      var0.put("&prop", Character.valueOf('∝'));
      var0.put("&infin", Character.valueOf('∞'));
      var0.put("&ang", Character.valueOf('∠'));
      var0.put("&and", Character.valueOf('∧'));
      var0.put("&or", Character.valueOf('∨'));
      var0.put("&cap", Character.valueOf('∩'));
      var0.put("&cup", Character.valueOf('∪'));
      var0.put("&int", Character.valueOf('∫'));
      var0.put("&there4", Character.valueOf('∴'));
      var0.put("&sim", Character.valueOf('∼'));
      var0.put("&cong", Character.valueOf('≅'));
      var0.put("&asymp", Character.valueOf('≈'));
      var0.put("&ne", Character.valueOf('≠'));
      var0.put("&equiv", Character.valueOf('≡'));
      var0.put("&le", Character.valueOf('≤'));
      var0.put("&ge", Character.valueOf('≥'));
      var0.put("&sub", Character.valueOf('⊂'));
      var0.put("&sup", Character.valueOf('⊃'));
      var0.put("&nsub", Character.valueOf('⊄'));
      var0.put("&sube", Character.valueOf('⊆'));
      var0.put("&supe", Character.valueOf('⊇'));
      var0.put("&oplus", Character.valueOf('⊕'));
      var0.put("&otimes", Character.valueOf('⊗'));
      var0.put("&perp", Character.valueOf('⊥'));
      var0.put("&sdot", Character.valueOf('⋅'));
      var0.put("&lceil", Character.valueOf('⌈'));
      var0.put("&rceil", Character.valueOf('⌉'));
      var0.put("&lfloor", Character.valueOf('⌊'));
      var0.put("&rfloor", Character.valueOf('⌋'));
      var0.put("&lang", Character.valueOf('〈'));
      var0.put("&rang", Character.valueOf('〉'));
      var0.put("&loz", Character.valueOf('◊'));
      var0.put("&spades", Character.valueOf('♠'));
      var0.put("&clubs", Character.valueOf('♣'));
      var0.put("&hearts", Character.valueOf('♥'));
      var0.put("&diams", Character.valueOf('♦'));
      var0.put("&quot", Character.valueOf('\"'));
      var0.put("&amp", Character.valueOf('&'));
      var0.put("&lt", Character.valueOf('<'));
      var0.put("&gt", Character.valueOf('>'));
      var0.put("&apos", Character.valueOf('\''));
      var0.put("&OElig", Character.valueOf('Œ'));
      var0.put("&oelig", Character.valueOf('œ'));
      var0.put("&Scaron", Character.valueOf('Š'));
      var0.put("&scaron", Character.valueOf('š'));
      var0.put("&Yuml", Character.valueOf('Ÿ'));
      var0.put("&circ", Character.valueOf('ˆ'));
      var0.put("&tilde", Character.valueOf('˜'));
      var0.put("&ensp", Character.valueOf(' '));
      var0.put("&emsp", Character.valueOf(' '));
      var0.put("&thinsp", Character.valueOf(' '));
      var0.put("&zwnj", Character.valueOf('\u200c'));
      var0.put("&zwj", Character.valueOf('\u200d'));
      var0.put("&lrm", Character.valueOf('\u200e'));
      var0.put("&rlm", Character.valueOf('\u200f'));
      var0.put("&ndash", Character.valueOf('–'));
      var0.put("&mdash", Character.valueOf('—'));
      var0.put("&lsquo", Character.valueOf('‘'));
      var0.put("&rsquo", Character.valueOf('’'));
      var0.put("&sbquo", Character.valueOf('‚'));
      var0.put("&ldquo", Character.valueOf('“'));
      var0.put("&rdquo", Character.valueOf('”'));
      var0.put("&bdquo", Character.valueOf('„'));
      var0.put("&dagger", Character.valueOf('†'));
      var0.put("&Dagger", Character.valueOf('‡'));
      var0.put("&permil", Character.valueOf('‰'));
      var0.put("&lsaquo", Character.valueOf('‹'));
      var0.put("&rsaquo", Character.valueOf('›'));
      var0.put("&euro", Character.valueOf('€'));
      ESCAPE_STRINGS = Collections.unmodifiableMap(var0);
      HEX_LETTER = CharMatcher.inRange('A', 'F').or(CharMatcher.inRange('a', 'f'));
      LT_GT_ESCAPE = (new StringUtil$CharEscaperBuilder()).addEscape('<', "&lt;").addEscape('>', "&gt;").toEscaper();
      HTML_TAG_PATTERN = Pattern.compile("</?[a-zA-Z][^>]*>");
      CHARACTER_REFERENCE_PATTERN = Pattern.compile("&#?[a-zA-Z0-9]{1,8};");
      HashSet var1 = new HashSet();
      var1.add(UnicodeBlock.HANGUL_JAMO);
      var1.add(UnicodeBlock.CJK_RADICALS_SUPPLEMENT);
      var1.add(UnicodeBlock.KANGXI_RADICALS);
      var1.add(UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION);
      var1.add(UnicodeBlock.HIRAGANA);
      var1.add(UnicodeBlock.KATAKANA);
      var1.add(UnicodeBlock.BOPOMOFO);
      var1.add(UnicodeBlock.HANGUL_COMPATIBILITY_JAMO);
      var1.add(UnicodeBlock.KANBUN);
      var1.add(UnicodeBlock.BOPOMOFO_EXTENDED);
      var1.add(UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS);
      var1.add(UnicodeBlock.ENCLOSED_CJK_LETTERS_AND_MONTHS);
      var1.add(UnicodeBlock.CJK_COMPATIBILITY);
      var1.add(UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A);
      var1.add(UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS);
      var1.add(UnicodeBlock.HANGUL_SYLLABLES);
      var1.add(UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS);
      var1.add(UnicodeBlock.CJK_COMPATIBILITY_FORMS);
      var1.add(UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS);
      var1.add(UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B);
      var1.add(UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT);
      CJK_BLOCKS = Collections.unmodifiableSet(var1);
      hexChars = "0123456789abcdef".toCharArray();
      octalChars = "01234567".toCharArray();
      JS_ESCAPE_CHARS = (new StringUtil$CodePointSet$Builder()).addCodePoint(173).addRange(1536, 1539).addCodePoint(1757).addCodePoint(1807).addRange(6068, 6069).addRange(8203, 8207).addRange(8234, 8238).addRange(8288, 8292).addRange(8298, 8303).addCodePoint('\ufeff').addRange('\ufff9', '\ufffb').addRange(119155, 119162).addCodePoint(917505).addRange(917536, 917631).addCodePoint(0).addCodePoint(10).addCodePoint(13).addRange(8232, 8233).addCodePoint(133).addCodePoint(Character.codePointAt("\'", 0)).addCodePoint(Character.codePointAt("\"", 0)).addCodePoint(Character.codePointAt("&", 0)).addCodePoint(Character.codePointAt("<", 0)).addCodePoint(Character.codePointAt(">", 0)).addCodePoint(Character.codePointAt("=", 0)).addCodePoint(Character.codePointAt("\\", 0)).create();
      JSON_ESCAPE_CHARS = (new StringUtil$CodePointSet$Builder()).addCodePoint(Character.codePointAt("\"", 0)).addCodePoint(Character.codePointAt("\\", 0)).addRange(0, 31).create();
      JSON_OR_JS_ESCAPE_CHARS = JSON_ESCAPE_CHARS.or(JS_ESCAPE_CHARS);
   }
}
