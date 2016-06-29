package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.TextFormat;
import com.google.protobuf.TextFormat$1;
import com.google.protobuf.TextFormat$InvalidEscapeSequenceException;
import com.google.protobuf.TextFormat$ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class TextFormat$Tokenizer {
   private final CharSequence text;
   private final Matcher matcher;
   private String currentToken;
   private int pos;
   private int line;
   private int column;
   private int previousLine;
   private int previousColumn;
   private static final Pattern WHITESPACE = Pattern.compile("(\\s|(#.*$))++", 8);
   private static final Pattern TOKEN = Pattern.compile("[a-zA-Z_][0-9a-zA-Z_+-]*+|[.]?[0-9+-][0-9a-zA-Z_.+-]*+|\"([^\"\n\\\\]|\\\\.)*+(\"|\\\\?$)|\'([^\'\n\\\\]|\\\\.)*+(\'|\\\\?$)", 8);
   private static final Pattern DOUBLE_INFINITY = Pattern.compile("-?inf(inity)?", 2);
   private static final Pattern FLOAT_INFINITY = Pattern.compile("-?inf(inity)?f?", 2);
   private static final Pattern FLOAT_NAN = Pattern.compile("nanf?", 2);

   private TextFormat$Tokenizer(CharSequence var1) {
      this.pos = 0;
      this.line = 0;
      this.column = 0;
      this.previousLine = 0;
      this.previousColumn = 0;
      this.text = var1;
      this.matcher = WHITESPACE.matcher(var1);
      this.skipWhitespace();
      this.nextToken();
   }

   public boolean atEnd() {
      return this.currentToken.length() == 0;
   }

   public void nextToken() {
      this.previousLine = this.line;

      for(this.previousColumn = this.column; this.pos < this.matcher.regionStart(); ++this.pos) {
         if(this.text.charAt(this.pos) == 10) {
            ++this.line;
            this.column = 0;
         } else {
            ++this.column;
         }
      }

      if(this.matcher.regionStart() == this.matcher.regionEnd()) {
         this.currentToken = "";
      } else {
         this.matcher.usePattern(TOKEN);
         if(this.matcher.lookingAt()) {
            this.currentToken = this.matcher.group();
            this.matcher.region(this.matcher.end(), this.matcher.regionEnd());
         } else {
            this.currentToken = String.valueOf(this.text.charAt(this.pos));
            this.matcher.region(this.pos + 1, this.matcher.regionEnd());
         }

         this.skipWhitespace();
      }

   }

   private void skipWhitespace() {
      this.matcher.usePattern(WHITESPACE);
      if(this.matcher.lookingAt()) {
         this.matcher.region(this.matcher.end(), this.matcher.regionEnd());
      }

   }

   public boolean tryConsume(String var1) {
      if(this.currentToken.equals(var1)) {
         this.nextToken();
         return true;
      } else {
         return false;
      }
   }

   public void consume(String var1) {
      if(!this.tryConsume(var1)) {
         String var2 = String.valueOf(String.valueOf(var1));
         throw this.parseException((new StringBuilder(12 + var2.length())).append("Expected \"").append(var2).append("\".").toString());
      }
   }

   public boolean lookingAtInteger() {
      if(this.currentToken.length() == 0) {
         return false;
      } else {
         char var1 = this.currentToken.charAt(0);
         return 48 <= var1 && var1 <= 57 || var1 == 45 || var1 == 43;
      }
   }

   public boolean lookingAt(String var1) {
      return this.currentToken.equals(var1);
   }

   public String consumeIdentifier() {
      for(int var1 = 0; var1 < this.currentToken.length(); ++var1) {
         char var2 = this.currentToken.charAt(var1);
         if((97 > var2 || var2 > 122) && (65 > var2 || var2 > 90) && (48 > var2 || var2 > 57) && var2 != 95 && var2 != 46) {
            String var3 = String.valueOf(String.valueOf(this.currentToken));
            throw this.parseException((new StringBuilder(29 + var3.length())).append("Expected identifier. Found \'").append(var3).append("\'").toString());
         }
      }

      String var4 = this.currentToken;
      this.nextToken();
      return var4;
   }

   public boolean tryConsumeIdentifier() {
      try {
         this.consumeIdentifier();
         return true;
      } catch (TextFormat$ParseException var2) {
         return false;
      }
   }

   public int consumeInt32() {
      try {
         int var1 = TextFormat.parseInt32(this.currentToken);
         this.nextToken();
         return var1;
      } catch (NumberFormatException var2) {
         throw this.integerParseException(var2);
      }
   }

   public int consumeUInt32() {
      try {
         int var1 = TextFormat.parseUInt32(this.currentToken);
         this.nextToken();
         return var1;
      } catch (NumberFormatException var2) {
         throw this.integerParseException(var2);
      }
   }

   public long consumeInt64() {
      try {
         long var1 = TextFormat.parseInt64(this.currentToken);
         this.nextToken();
         return var1;
      } catch (NumberFormatException var3) {
         throw this.integerParseException(var3);
      }
   }

   public boolean tryConsumeInt64() {
      try {
         this.consumeInt64();
         return true;
      } catch (TextFormat$ParseException var2) {
         return false;
      }
   }

   public long consumeUInt64() {
      try {
         long var1 = TextFormat.parseUInt64(this.currentToken);
         this.nextToken();
         return var1;
      } catch (NumberFormatException var3) {
         throw this.integerParseException(var3);
      }
   }

   public boolean tryConsumeUInt64() {
      try {
         this.consumeUInt64();
         return true;
      } catch (TextFormat$ParseException var2) {
         return false;
      }
   }

   public double consumeDouble() {
      if(DOUBLE_INFINITY.matcher(this.currentToken).matches()) {
         boolean var4 = this.currentToken.startsWith("-");
         this.nextToken();
         return var4?Double.NEGATIVE_INFINITY:Double.POSITIVE_INFINITY;
      } else if(this.currentToken.equalsIgnoreCase("nan")) {
         this.nextToken();
         return Double.NaN;
      } else {
         try {
            double var1 = Double.parseDouble(this.currentToken);
            this.nextToken();
            return var1;
         } catch (NumberFormatException var3) {
            throw this.floatParseException(var3);
         }
      }
   }

   public boolean tryConsumeDouble() {
      try {
         this.consumeDouble();
         return true;
      } catch (TextFormat$ParseException var2) {
         return false;
      }
   }

   public float consumeFloat() {
      if(FLOAT_INFINITY.matcher(this.currentToken).matches()) {
         boolean var3 = this.currentToken.startsWith("-");
         this.nextToken();
         return var3?Float.NEGATIVE_INFINITY:Float.POSITIVE_INFINITY;
      } else if(FLOAT_NAN.matcher(this.currentToken).matches()) {
         this.nextToken();
         return Float.NaN;
      } else {
         try {
            float var1 = Float.parseFloat(this.currentToken);
            this.nextToken();
            return var1;
         } catch (NumberFormatException var2) {
            throw this.floatParseException(var2);
         }
      }
   }

   public boolean tryConsumeFloat() {
      try {
         this.consumeFloat();
         return true;
      } catch (TextFormat$ParseException var2) {
         return false;
      }
   }

   public boolean consumeBoolean() {
      if(!this.currentToken.equals("true") && !this.currentToken.equals("t") && !this.currentToken.equals("1")) {
         if(!this.currentToken.equals("false") && !this.currentToken.equals("f") && !this.currentToken.equals("0")) {
            throw this.parseException("Expected \"true\" or \"false\".");
         } else {
            this.nextToken();
            return false;
         }
      } else {
         this.nextToken();
         return true;
      }
   }

   public String consumeString() {
      return this.consumeByteString().toStringUtf8();
   }

   public boolean tryConsumeString() {
      try {
         this.consumeString();
         return true;
      } catch (TextFormat$ParseException var2) {
         return false;
      }
   }

   public ByteString consumeByteString() {
      ArrayList var1 = new ArrayList();
      this.consumeByteString(var1);

      while(this.currentToken.startsWith("\'") || this.currentToken.startsWith("\"")) {
         this.consumeByteString(var1);
      }

      return ByteString.copyFrom((Iterable)var1);
   }

   private void consumeByteString(List var1) {
      char var2 = this.currentToken.length() > 0?this.currentToken.charAt(0):0;
      if(var2 != 34 && var2 != 39) {
         throw this.parseException("Expected string.");
      } else if(this.currentToken.length() >= 2 && this.currentToken.charAt(this.currentToken.length() - 1) == var2) {
         try {
            String var3 = this.currentToken.substring(1, this.currentToken.length() - 1);
            ByteString var4 = TextFormat.unescapeBytes(var3);
            this.nextToken();
            var1.add(var4);
         } catch (TextFormat$InvalidEscapeSequenceException var5) {
            throw this.parseException(var5.getMessage());
         }
      } else {
         throw this.parseException("String missing ending quote.");
      }
   }

   public TextFormat$ParseException parseException(String var1) {
      return new TextFormat$ParseException(this.line + 1, this.column + 1, var1);
   }

   public TextFormat$ParseException parseExceptionPreviousToken(String var1) {
      return new TextFormat$ParseException(this.previousLine + 1, this.previousColumn + 1, var1);
   }

   private TextFormat$ParseException integerParseException(NumberFormatException var1) {
      // $FF: Couldn't be decompiled
   }

   private TextFormat$ParseException floatParseException(NumberFormatException var1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   TextFormat$Tokenizer(CharSequence var1, TextFormat$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static String access$1200(TextFormat$Tokenizer var0) {
      return var0.currentToken;
   }
}
