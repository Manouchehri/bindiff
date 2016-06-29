package com.google.common.base;

import com.google.common.base.CharMatcher;
import com.google.common.base.CharMatcher$NamedFastMatcher;
import com.google.common.base.Preconditions;

final class CharMatcher$None extends CharMatcher$NamedFastMatcher {
   static final CharMatcher$None INSTANCE = new CharMatcher$None();

   private CharMatcher$None() {
      super("CharMatcher.none()");
   }

   public boolean matches(char var1) {
      return false;
   }

   public int indexIn(CharSequence var1) {
      Preconditions.checkNotNull(var1);
      return -1;
   }

   public int indexIn(CharSequence var1, int var2) {
      int var3 = var1.length();
      Preconditions.checkPositionIndex(var2, var3);
      return -1;
   }

   public int lastIndexIn(CharSequence var1) {
      Preconditions.checkNotNull(var1);
      return -1;
   }

   public boolean matchesAllOf(CharSequence var1) {
      return var1.length() == 0;
   }

   public boolean matchesNoneOf(CharSequence var1) {
      Preconditions.checkNotNull(var1);
      return true;
   }

   public String removeFrom(CharSequence var1) {
      return var1.toString();
   }

   public String replaceFrom(CharSequence var1, char var2) {
      return var1.toString();
   }

   public String replaceFrom(CharSequence var1, CharSequence var2) {
      Preconditions.checkNotNull(var2);
      return var1.toString();
   }

   public String collapseFrom(CharSequence var1, char var2) {
      return var1.toString();
   }

   public String trimFrom(CharSequence var1) {
      return var1.toString();
   }

   public String trimLeadingFrom(CharSequence var1) {
      return var1.toString();
   }

   public String trimTrailingFrom(CharSequence var1) {
      return var1.toString();
   }

   public int countIn(CharSequence var1) {
      Preconditions.checkNotNull(var1);
      return 0;
   }

   public CharMatcher and(CharMatcher var1) {
      Preconditions.checkNotNull(var1);
      return this;
   }

   public CharMatcher or(CharMatcher var1) {
      return (CharMatcher)Preconditions.checkNotNull(var1);
   }

   public CharMatcher negate() {
      return any();
   }
}
