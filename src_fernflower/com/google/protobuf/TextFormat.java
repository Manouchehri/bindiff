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
   private static final TextFormat$Printer DEFAULT_PRINTER = new TextFormat$Printer((TextFormat$1)null);
   private static final TextFormat$Printer SINGLE_LINE_PRINTER = TextFormat$Printer.access$100(new TextFormat$Printer((TextFormat$1)null), true);
   private static final TextFormat$Printer UNICODE_PRINTER = TextFormat$Printer.access$200(new TextFormat$Printer((TextFormat$1)null), false);
   private static final TextFormat$Parser PARSER = TextFormat$Parser.newBuilder().build();

   public static void print(MessageOrBuilder var0, Appendable var1) {
      TextFormat$Printer.access$400(DEFAULT_PRINTER, var0, new TextFormat$TextGenerator(var1, (TextFormat$1)null));
   }

   public static void print(UnknownFieldSet var0, Appendable var1) {
      TextFormat$Printer.access$500(DEFAULT_PRINTER, var0, new TextFormat$TextGenerator(var1, (TextFormat$1)null));
   }

   public static void printUnicode(MessageOrBuilder var0, Appendable var1) {
      TextFormat$Printer.access$400(UNICODE_PRINTER, var0, new TextFormat$TextGenerator(var1, (TextFormat$1)null));
   }

   public static void printUnicode(UnknownFieldSet var0, Appendable var1) {
      TextFormat$Printer.access$500(UNICODE_PRINTER, var0, new TextFormat$TextGenerator(var1, (TextFormat$1)null));
   }

   public static String shortDebugString(MessageOrBuilder var0) {
      try {
         StringBuilder var1 = new StringBuilder();
         TextFormat$Printer.access$400(SINGLE_LINE_PRINTER, var0, new TextFormat$TextGenerator(var1, (TextFormat$1)null));
         return var1.toString().trim();
      } catch (IOException var2) {
         throw new IllegalStateException(var2);
      }
   }

   public static String shortDebugString(UnknownFieldSet var0) {
      try {
         StringBuilder var1 = new StringBuilder();
         TextFormat$Printer.access$500(SINGLE_LINE_PRINTER, var0, new TextFormat$TextGenerator(var1, (TextFormat$1)null));
         return var1.toString().trim();
      } catch (IOException var2) {
         throw new IllegalStateException(var2);
      }
   }

   public static String printToString(MessageOrBuilder var0) {
      try {
         StringBuilder var1 = new StringBuilder();
         print((MessageOrBuilder)var0, var1);
         return var1.toString();
      } catch (IOException var2) {
         throw new IllegalStateException(var2);
      }
   }

   public static String printToString(UnknownFieldSet var0) {
      try {
         StringBuilder var1 = new StringBuilder();
         print((UnknownFieldSet)var0, var1);
         return var1.toString();
      } catch (IOException var2) {
         throw new IllegalStateException(var2);
      }
   }

   public static String printToUnicodeString(MessageOrBuilder var0) {
      try {
         StringBuilder var1 = new StringBuilder();
         TextFormat$Printer.access$400(UNICODE_PRINTER, var0, new TextFormat$TextGenerator(var1, (TextFormat$1)null));
         return var1.toString();
      } catch (IOException var2) {
         throw new IllegalStateException(var2);
      }
   }

   public static String printToUnicodeString(UnknownFieldSet var0) {
      try {
         StringBuilder var1 = new StringBuilder();
         TextFormat$Printer.access$500(UNICODE_PRINTER, var0, new TextFormat$TextGenerator(var1, (TextFormat$1)null));
         return var1.toString();
      } catch (IOException var2) {
         throw new IllegalStateException(var2);
      }
   }

   public static void printField(Descriptors$FieldDescriptor var0, Object var1, Appendable var2) {
      TextFormat$Printer.access$600(DEFAULT_PRINTER, var0, var1, new TextFormat$TextGenerator(var2, (TextFormat$1)null));
   }

   public static String printFieldToString(Descriptors$FieldDescriptor var0, Object var1) {
      try {
         StringBuilder var2 = new StringBuilder();
         printField(var0, var1, var2);
         return var2.toString();
      } catch (IOException var3) {
         throw new IllegalStateException(var3);
      }
   }

   public static void printFieldValue(Descriptors$FieldDescriptor var0, Object var1, Appendable var2) {
      TextFormat$Printer.access$700(DEFAULT_PRINTER, var0, var1, new TextFormat$TextGenerator(var2, (TextFormat$1)null));
   }

   public static void printUnknownFieldValue(int var0, Object var1, Appendable var2) {
      printUnknownFieldValue(var0, var1, new TextFormat$TextGenerator(var2, (TextFormat$1)null));
   }

   private static void printUnknownFieldValue(int var0, Object var1, TextFormat$TextGenerator var2) {
      switch(WireFormat.getTagWireType(var0)) {
      case 0:
         var2.print(unsignedToString(((Long)var1).longValue()));
         break;
      case 1:
         var2.print(String.format((Locale)null, "0x%016x", new Object[]{(Long)var1}));
         break;
      case 2:
         var2.print("\"");
         var2.print(escapeBytes((ByteString)var1));
         var2.print("\"");
         break;
      case 3:
         TextFormat$Printer.access$500(DEFAULT_PRINTER, (UnknownFieldSet)var1, var2);
         break;
      case 4:
      default:
         throw new IllegalArgumentException((new StringBuilder(20)).append("Bad tag: ").append(var0).toString());
      case 5:
         var2.print(String.format((Locale)null, "0x%08x", new Object[]{(Integer)var1}));
      }

   }

   public static String unsignedToString(int var0) {
      return var0 >= 0?Integer.toString(var0):Long.toString((long)var0 & 4294967295L);
   }

   public static String unsignedToString(long var0) {
      return var0 >= 0L?Long.toString(var0):BigInteger.valueOf(var0 & Long.MAX_VALUE).setBit(63).toString();
   }

   public static TextFormat$Parser getParser() {
      return PARSER;
   }

   public static void merge(Readable var0, Message$Builder var1) {
      PARSER.merge(var0, var1);
   }

   public static void merge(CharSequence var0, Message$Builder var1) {
      PARSER.merge(var0, var1);
   }

   public static void merge(Readable var0, ExtensionRegistry var1, Message$Builder var2) {
      PARSER.merge(var0, var1, var2);
   }

   public static void merge(CharSequence var0, ExtensionRegistry var1, Message$Builder var2) {
      PARSER.merge(var0, var1, var2);
   }

   public static String escapeBytes(TextFormat$ByteSequence var0) {
      StringBuilder var1 = new StringBuilder(var0.size());

      for(int var2 = 0; var2 < var0.size(); ++var2) {
         byte var3 = var0.byteAt(var2);
         switch(var3) {
         case 7:
            var1.append("\\a");
            break;
         case 8:
            var1.append("\\b");
            break;
         case 9:
            var1.append("\\t");
            break;
         case 10:
            var1.append("\\n");
            break;
         case 11:
            var1.append("\\v");
            break;
         case 12:
            var1.append("\\f");
            break;
         case 13:
            var1.append("\\r");
            break;
         case 34:
            var1.append("\\\"");
            break;
         case 39:
            var1.append("\\\'");
            break;
         case 92:
            var1.append("\\\\");
            break;
         default:
            if(var3 >= 32 && var3 <= 126) {
               var1.append((char)var3);
            } else {
               var1.append('\\');
               var1.append((char)(48 + (var3 >>> 6 & 3)));
               var1.append((char)(48 + (var3 >>> 3 & 7)));
               var1.append((char)(48 + (var3 & 7)));
            }
         }
      }

      return var1.toString();
   }

   public static String escapeBytes(ByteString var0) {
      return escapeBytes((TextFormat$ByteSequence)(new TextFormat$1(var0)));
   }

   public static String escapeBytes(byte[] var0) {
      return escapeBytes((TextFormat$ByteSequence)(new TextFormat$2(var0)));
   }

   public static ByteString unescapeBytes(CharSequence var0) {
      ByteString var1 = ByteString.copyFromUtf8(var0.toString());
      byte[] var2 = new byte[var1.size()];
      int var3 = 0;

      for(int var4 = 0; var4 < var1.size(); ++var4) {
         byte var5 = var1.byteAt(var4);
         if(var5 == 92) {
            if(var4 + 1 >= var1.size()) {
               throw new TextFormat$InvalidEscapeSequenceException("Invalid escape sequence: \'\\\' at end of string.");
            }

            ++var4;
            var5 = var1.byteAt(var4);
            int var8;
            if(isOctal(var5)) {
               var8 = digitValue(var5);
               if(var4 + 1 < var1.size() && isOctal(var1.byteAt(var4 + 1))) {
                  ++var4;
                  var8 = var8 * 8 + digitValue(var1.byteAt(var4));
               }

               if(var4 + 1 < var1.size() && isOctal(var1.byteAt(var4 + 1))) {
                  ++var4;
                  var8 = var8 * 8 + digitValue(var1.byteAt(var4));
               }

               var2[var3++] = (byte)var8;
            } else {
               switch(var5) {
               case 34:
                  var2[var3++] = 34;
                  break;
               case 39:
                  var2[var3++] = 39;
                  break;
               case 92:
                  var2[var3++] = 92;
                  break;
               case 97:
                  var2[var3++] = 7;
                  break;
               case 98:
                  var2[var3++] = 8;
                  break;
               case 102:
                  var2[var3++] = 12;
                  break;
               case 110:
                  var2[var3++] = 10;
                  break;
               case 114:
                  var2[var3++] = 13;
                  break;
               case 116:
                  var2[var3++] = 9;
                  break;
               case 118:
                  var2[var3++] = 11;
                  break;
               case 120:
                  boolean var6 = false;
                  if(var4 + 1 < var1.size() && isHex(var1.byteAt(var4 + 1))) {
                     ++var4;
                     var8 = digitValue(var1.byteAt(var4));
                     if(var4 + 1 < var1.size() && isHex(var1.byteAt(var4 + 1))) {
                        ++var4;
                        var8 = var8 * 16 + digitValue(var1.byteAt(var4));
                     }

                     var2[var3++] = (byte)var8;
                     break;
                  }

                  throw new TextFormat$InvalidEscapeSequenceException("Invalid escape sequence: \'\\x\' with no digits");
               default:
                  char var7 = (char)var5;
                  throw new TextFormat$InvalidEscapeSequenceException((new StringBuilder(29)).append("Invalid escape sequence: \'\\").append(var7).append("\'").toString());
               }
            }
         } else {
            var2[var3++] = var5;
         }
      }

      return ByteString.copyFrom(var2, 0, var3);
   }

   static String escapeText(String var0) {
      return escapeBytes(ByteString.copyFromUtf8(var0));
   }

   public static String escapeDoubleQuotesAndBackslashes(String var0) {
      return var0.replace("\\", "\\\\").replace("\"", "\\\"");
   }

   static String unescapeText(String var0) {
      return unescapeBytes(var0).toStringUtf8();
   }

   private static boolean isOctal(byte var0) {
      return 48 <= var0 && var0 <= 55;
   }

   private static boolean isHex(byte var0) {
      return 48 <= var0 && var0 <= 57 || 97 <= var0 && var0 <= 102 || 65 <= var0 && var0 <= 70;
   }

   private static int digitValue(byte var0) {
      return 48 <= var0 && var0 <= 57?var0 - 48:(97 <= var0 && var0 <= 122?var0 - 97 + 10:var0 - 65 + 10);
   }

   static int parseInt32(String var0) {
      return (int)parseInteger(var0, true, false);
   }

   static int parseUInt32(String var0) {
      return (int)parseInteger(var0, false, false);
   }

   static long parseInt64(String var0) {
      return parseInteger(var0, true, true);
   }

   static long parseUInt64(String var0) {
      return parseInteger(var0, false, true);
   }

   private static long parseInteger(String var0, boolean var1, boolean var2) {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   static void access$800(int var0, Object var1, TextFormat$TextGenerator var2) {
      printUnknownFieldValue(var0, var1, var2);
   }

   // $FF: synthetic method
   static Logger access$1100() {
      return logger;
   }
}
