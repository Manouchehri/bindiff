package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.CharMatcher$1;
import com.google.common.base.CharMatcher$And;
import com.google.common.base.CharMatcher$Any;
import com.google.common.base.CharMatcher$AnyOf;
import com.google.common.base.CharMatcher$Ascii;
import com.google.common.base.CharMatcher$BitSetMatcher;
import com.google.common.base.CharMatcher$BreakingWhitespace;
import com.google.common.base.CharMatcher$Digit;
import com.google.common.base.CharMatcher$ForPredicate;
import com.google.common.base.CharMatcher$InRange;
import com.google.common.base.CharMatcher$Invisible;
import com.google.common.base.CharMatcher$Is;
import com.google.common.base.CharMatcher$IsEither;
import com.google.common.base.CharMatcher$IsNot;
import com.google.common.base.CharMatcher$JavaDigit;
import com.google.common.base.CharMatcher$JavaIsoControl;
import com.google.common.base.CharMatcher$JavaLetter;
import com.google.common.base.CharMatcher$JavaLetterOrDigit;
import com.google.common.base.CharMatcher$JavaLowerCase;
import com.google.common.base.CharMatcher$JavaUpperCase;
import com.google.common.base.CharMatcher$Negated;
import com.google.common.base.CharMatcher$None;
import com.google.common.base.CharMatcher$Or;
import com.google.common.base.CharMatcher$SingleWidth;
import com.google.common.base.CharMatcher$Whitespace;
import com.google.common.base.Platform;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.SmallCharMatcher;
import java.util.BitSet;
import javax.annotation.CheckReturnValue;

@Beta
@GwtCompatible(
   emulated = true
)
public abstract class CharMatcher implements Predicate {
   public static final CharMatcher WHITESPACE = whitespace();
   public static final CharMatcher BREAKING_WHITESPACE = breakingWhitespace();
   public static final CharMatcher ASCII = ascii();
   public static final CharMatcher DIGIT = digit();
   public static final CharMatcher JAVA_DIGIT = javaDigit();
   public static final CharMatcher JAVA_LETTER = javaLetter();
   public static final CharMatcher JAVA_LETTER_OR_DIGIT = javaLetterOrDigit();
   public static final CharMatcher JAVA_UPPER_CASE = javaUpperCase();
   public static final CharMatcher JAVA_LOWER_CASE = javaLowerCase();
   public static final CharMatcher JAVA_ISO_CONTROL = javaIsoControl();
   public static final CharMatcher INVISIBLE = invisible();
   public static final CharMatcher SINGLE_WIDTH = singleWidth();
   public static final CharMatcher ANY = any();
   public static final CharMatcher NONE = none();
   private static final int DISTINCT_CHARS = 65536;

   public static CharMatcher any() {
      return CharMatcher$Any.INSTANCE;
   }

   public static CharMatcher none() {
      return CharMatcher$None.INSTANCE;
   }

   public static CharMatcher whitespace() {
      return CharMatcher$Whitespace.INSTANCE;
   }

   public static CharMatcher breakingWhitespace() {
      return CharMatcher$BreakingWhitespace.INSTANCE;
   }

   public static CharMatcher ascii() {
      return CharMatcher$Ascii.INSTANCE;
   }

   public static CharMatcher digit() {
      return CharMatcher$Digit.INSTANCE;
   }

   public static CharMatcher javaDigit() {
      return CharMatcher$JavaDigit.INSTANCE;
   }

   public static CharMatcher javaLetter() {
      return CharMatcher$JavaLetter.INSTANCE;
   }

   public static CharMatcher javaLetterOrDigit() {
      return CharMatcher$JavaLetterOrDigit.INSTANCE;
   }

   public static CharMatcher javaUpperCase() {
      return CharMatcher$JavaUpperCase.INSTANCE;
   }

   public static CharMatcher javaLowerCase() {
      return CharMatcher$JavaLowerCase.INSTANCE;
   }

   public static CharMatcher javaIsoControl() {
      return CharMatcher$JavaIsoControl.INSTANCE;
   }

   public static CharMatcher invisible() {
      return CharMatcher$Invisible.INSTANCE;
   }

   public static CharMatcher singleWidth() {
      return CharMatcher$SingleWidth.INSTANCE;
   }

   public static CharMatcher is(char var0) {
      return new CharMatcher$Is(var0);
   }

   public static CharMatcher isNot(char var0) {
      return new CharMatcher$IsNot(var0);
   }

   public static CharMatcher anyOf(CharSequence var0) {
      switch(var0.length()) {
      case 0:
         return none();
      case 1:
         return is(var0.charAt(0));
      case 2:
         return isEither(var0.charAt(0), var0.charAt(1));
      default:
         return new CharMatcher$AnyOf(var0);
      }
   }

   public static CharMatcher noneOf(CharSequence var0) {
      return anyOf(var0).negate();
   }

   public static CharMatcher inRange(char var0, char var1) {
      return new CharMatcher$InRange(var0, var1);
   }

   public static CharMatcher forPredicate(Predicate var0) {
      return (CharMatcher)(var0 instanceof CharMatcher?(CharMatcher)var0:new CharMatcher$ForPredicate(var0));
   }

   public abstract boolean matches(char var1);

   public CharMatcher negate() {
      return new CharMatcher$Negated(this);
   }

   public CharMatcher and(CharMatcher var1) {
      return new CharMatcher$And(this, var1);
   }

   public CharMatcher or(CharMatcher var1) {
      return new CharMatcher$Or(this, var1);
   }

   public CharMatcher precomputed() {
      return Platform.precomputeCharMatcher(this);
   }

   @GwtIncompatible("java.util.BitSet")
   CharMatcher precomputedInternal() {
      // $FF: Couldn't be decompiled
   }

   @GwtIncompatible("java.util.BitSet")
   private static CharMatcher precomputedPositive(int var0, BitSet var1, String var2) {
      switch(var0) {
      case 0:
         return none();
      case 1:
         return is((char)var1.nextSetBit(0));
      case 2:
         char var3 = (char)var1.nextSetBit(0);
         char var4 = (char)var1.nextSetBit(var3 + 1);
         return isEither(var3, var4);
      default:
         return (CharMatcher)(isSmall(var0, var1.length())?SmallCharMatcher.from(var1, var2):new CharMatcher$BitSetMatcher(var1, var2, (CharMatcher$1)null));
      }
   }

   @GwtIncompatible("SmallCharMatcher")
   private static boolean isSmall(int var0, int var1) {
      return var0 <= 1023 && var1 > var0 * 4 * 16;
   }

   @GwtIncompatible("java.util.BitSet")
   void setBits(BitSet var1) {
      for(int var2 = '\uffff'; var2 >= 0; --var2) {
         if(this.matches((char)var2)) {
            var1.set(var2);
         }
      }

   }

   public boolean matchesAnyOf(CharSequence var1) {
      return !this.matchesNoneOf(var1);
   }

   public boolean matchesAllOf(CharSequence var1) {
      for(int var2 = var1.length() - 1; var2 >= 0; --var2) {
         if(!this.matches(var1.charAt(var2))) {
            return false;
         }
      }

      return true;
   }

   public boolean matchesNoneOf(CharSequence var1) {
      return this.indexIn(var1) == -1;
   }

   public int indexIn(CharSequence var1) {
      return this.indexIn(var1, 0);
   }

   public int indexIn(CharSequence var1, int var2) {
      int var3 = var1.length();
      Preconditions.checkPositionIndex(var2, var3);

      for(int var4 = var2; var4 < var3; ++var4) {
         if(this.matches(var1.charAt(var4))) {
            return var4;
         }
      }

      return -1;
   }

   public int lastIndexIn(CharSequence var1) {
      for(int var2 = var1.length() - 1; var2 >= 0; --var2) {
         if(this.matches(var1.charAt(var2))) {
            return var2;
         }
      }

      return -1;
   }

   public int countIn(CharSequence var1) {
      int var2 = 0;

      for(int var3 = 0; var3 < var1.length(); ++var3) {
         if(this.matches(var1.charAt(var3))) {
            ++var2;
         }
      }

      return var2;
   }

   @CheckReturnValue
   public String removeFrom(CharSequence var1) {
      String var2 = var1.toString();
      int var3 = this.indexIn(var2);
      if(var3 == -1) {
         return var2;
      } else {
         char[] var4 = var2.toCharArray();
         int var5 = 1;

         label25:
         while(true) {
            ++var3;

            while(var3 != var4.length) {
               if(this.matches(var4[var3])) {
                  ++var5;
                  continue label25;
               }

               var4[var3 - var5] = var4[var3];
               ++var3;
            }

            return new String(var4, 0, var3 - var5);
         }
      }
   }

   @CheckReturnValue
   public String retainFrom(CharSequence var1) {
      return this.negate().removeFrom(var1);
   }

   @CheckReturnValue
   public String replaceFrom(CharSequence var1, char var2) {
      String var3 = var1.toString();
      int var4 = this.indexIn(var3);
      if(var4 == -1) {
         return var3;
      } else {
         char[] var5 = var3.toCharArray();
         var5[var4] = var2;

         for(int var6 = var4 + 1; var6 < var5.length; ++var6) {
            if(this.matches(var5[var6])) {
               var5[var6] = var2;
            }
         }

         return new String(var5);
      }
   }

   @CheckReturnValue
   public String replaceFrom(CharSequence var1, CharSequence var2) {
      int var3 = var2.length();
      if(var3 == 0) {
         return this.removeFrom(var1);
      } else if(var3 == 1) {
         return this.replaceFrom(var1, var2.charAt(0));
      } else {
         String var4 = var1.toString();
         int var5 = this.indexIn(var4);
         if(var5 == -1) {
            return var4;
         } else {
            int var6 = var4.length();
            StringBuilder var7 = new StringBuilder(var6 * 3 / 2 + 16);
            int var8 = 0;

            do {
               var7.append(var4, var8, var5);
               var7.append(var2);
               var8 = var5 + 1;
               var5 = this.indexIn(var4, var8);
            } while(var5 != -1);

            var7.append(var4, var8, var6);
            return var7.toString();
         }
      }
   }

   @CheckReturnValue
   public String trimFrom(CharSequence var1) {
      int var2 = var1.length();

      int var3;
      for(var3 = 0; var3 < var2 && this.matches(var1.charAt(var3)); ++var3) {
         ;
      }

      int var4;
      for(var4 = var2 - 1; var4 > var3 && this.matches(var1.charAt(var4)); --var4) {
         ;
      }

      return var1.subSequence(var3, var4 + 1).toString();
   }

   @CheckReturnValue
   public String trimLeadingFrom(CharSequence var1) {
      int var2 = var1.length();

      for(int var3 = 0; var3 < var2; ++var3) {
         if(!this.matches(var1.charAt(var3))) {
            return var1.subSequence(var3, var2).toString();
         }
      }

      return "";
   }

   @CheckReturnValue
   public String trimTrailingFrom(CharSequence var1) {
      int var2 = var1.length();

      for(int var3 = var2 - 1; var3 >= 0; --var3) {
         if(!this.matches(var1.charAt(var3))) {
            return var1.subSequence(0, var3 + 1).toString();
         }
      }

      return "";
   }

   @CheckReturnValue
   public String collapseFrom(CharSequence var1, char var2) {
      int var3 = var1.length();

      for(int var4 = 0; var4 < var3; ++var4) {
         char var5 = var1.charAt(var4);
         if(this.matches(var5)) {
            if(var5 != var2 || var4 != var3 - 1 && this.matches(var1.charAt(var4 + 1))) {
               StringBuilder var6 = (new StringBuilder(var3)).append(var1.subSequence(0, var4)).append(var2);
               return this.finishCollapseFrom(var1, var4 + 1, var3, var2, var6, true);
            }

            ++var4;
         }
      }

      return var1.toString();
   }

   @CheckReturnValue
   public String trimAndCollapseFrom(CharSequence var1, char var2) {
      int var3 = var1.length();
      int var4 = 0;

      int var5;
      for(var5 = var3 - 1; var4 < var3 && this.matches(var1.charAt(var4)); ++var4) {
         ;
      }

      while(var5 > var4 && this.matches(var1.charAt(var5))) {
         --var5;
      }

      return var4 == 0 && var5 == var3 - 1?this.collapseFrom(var1, var2):this.finishCollapseFrom(var1, var4, var5 + 1, var2, new StringBuilder(var5 + 1 - var4), false);
   }

   private String finishCollapseFrom(CharSequence var1, int var2, int var3, char var4, StringBuilder var5, boolean var6) {
      for(int var7 = var2; var7 < var3; ++var7) {
         char var8 = var1.charAt(var7);
         if(this.matches(var8)) {
            if(!var6) {
               var5.append(var4);
               var6 = true;
            }
         } else {
            var5.append(var8);
            var6 = false;
         }
      }

      return var5.toString();
   }

   @Deprecated
   public boolean apply(Character var1) {
      return this.matches(var1.charValue());
   }

   public String toString() {
      return super.toString();
   }

   private static String showCharacter(char var0) {
      String var1 = "0123456789ABCDEF";
      char[] var2 = new char[]{'\\', 'u', '\u0000', '\u0000', '\u0000', '\u0000'};

      for(int var3 = 0; var3 < 4; ++var3) {
         var2[5 - var3] = var1.charAt(var0 & 15);
         var0 = (char)(var0 >> 4);
      }

      return String.copyValueOf(var2);
   }

   private static CharMatcher$IsEither isEither(char var0, char var1) {
      return new CharMatcher$IsEither(var0, var1);
   }

   // $FF: synthetic method
   static String access$100(char var0) {
      return showCharacter(var0);
   }
}
