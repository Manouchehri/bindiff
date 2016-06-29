package com.google.common.base;

import com.google.common.base.CharMatcher;
import com.google.common.base.CharMatcher$NamedFastMatcher;
import com.google.common.base.Preconditions;
import java.util.Arrays;

final class CharMatcher$Any extends CharMatcher$NamedFastMatcher {
   static final CharMatcher$Any INSTANCE = new CharMatcher$Any();

   private CharMatcher$Any() {
      super("CharMatcher.any()");
   }

   public boolean matches(char var1) {
      return true;
   }

   public int indexIn(CharSequence var1) {
      return var1.length() == 0?-1:0;
   }

   public int indexIn(CharSequence var1, int var2) {
      int var3 = var1.length();
      Preconditions.checkPositionIndex(var2, var3);
      return var2 == var3?-1:var2;
   }

   public int lastIndexIn(CharSequence var1) {
      return var1.length() - 1;
   }

   public boolean matchesAllOf(CharSequence var1) {
      Preconditions.checkNotNull(var1);
      return true;
   }

   public boolean matchesNoneOf(CharSequence var1) {
      return var1.length() == 0;
   }

   public String removeFrom(CharSequence var1) {
      Preconditions.checkNotNull(var1);
      return "";
   }

   public String replaceFrom(CharSequence var1, char var2) {
      char[] var3 = new char[var1.length()];
      Arrays.fill(var3, var2);
      return new String(var3);
   }

   public String replaceFrom(CharSequence var1, CharSequence var2) {
      StringBuilder var3 = new StringBuilder(var1.length() * var2.length());

      for(int var4 = 0; var4 < var1.length(); ++var4) {
         var3.append(var2);
      }

      return var3.toString();
   }

   public String collapseFrom(CharSequence var1, char var2) {
      return var1.length() == 0?"":String.valueOf(var2);
   }

   public String trimFrom(CharSequence var1) {
      Preconditions.checkNotNull(var1);
      return "";
   }

   public int countIn(CharSequence var1) {
      return var1.length();
   }

   public CharMatcher and(CharMatcher var1) {
      return (CharMatcher)Preconditions.checkNotNull(var1);
   }

   public CharMatcher or(CharMatcher var1) {
      Preconditions.checkNotNull(var1);
      return this;
   }

   public CharMatcher negate() {
      return none();
   }
}
