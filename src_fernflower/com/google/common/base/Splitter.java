package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.CharMatcher;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter$1;
import com.google.common.base.Splitter$2;
import com.google.common.base.Splitter$3;
import com.google.common.base.Splitter$4;
import com.google.common.base.Splitter$5;
import com.google.common.base.Splitter$MapSplitter;
import com.google.common.base.Splitter$Strategy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.CheckReturnValue;

@GwtCompatible(
   emulated = true
)
public final class Splitter {
   private final CharMatcher trimmer;
   private final boolean omitEmptyStrings;
   private final Splitter$Strategy strategy;
   private final int limit;

   private Splitter(Splitter$Strategy var1) {
      this(var1, false, CharMatcher.NONE, Integer.MAX_VALUE);
   }

   private Splitter(Splitter$Strategy var1, boolean var2, CharMatcher var3, int var4) {
      this.strategy = var1;
      this.omitEmptyStrings = var2;
      this.trimmer = var3;
      this.limit = var4;
   }

   @CheckReturnValue
   public static Splitter on(char var0) {
      return on(CharMatcher.is(var0));
   }

   @CheckReturnValue
   public static Splitter on(CharMatcher var0) {
      Preconditions.checkNotNull(var0);
      return new Splitter(new Splitter$1(var0));
   }

   @CheckReturnValue
   public static Splitter on(String var0) {
      Preconditions.checkArgument(var0.length() != 0, "The separator may not be the empty string.");
      return new Splitter(new Splitter$2(var0));
   }

   @CheckReturnValue
   @GwtIncompatible("java.util.regex")
   public static Splitter on(Pattern var0) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkArgument(!var0.matcher("").matches(), "The pattern may not match the empty string: %s", new Object[]{var0});
      return new Splitter(new Splitter$3(var0));
   }

   @CheckReturnValue
   @GwtIncompatible("java.util.regex")
   public static Splitter onPattern(String var0) {
      return on(Pattern.compile(var0));
   }

   @CheckReturnValue
   public static Splitter fixedLength(int var0) {
      Preconditions.checkArgument(var0 > 0, "The length may not be less than 1");
      return new Splitter(new Splitter$4(var0));
   }

   @CheckReturnValue
   public Splitter omitEmptyStrings() {
      return new Splitter(this.strategy, true, this.trimmer, this.limit);
   }

   @CheckReturnValue
   public Splitter limit(int var1) {
      Preconditions.checkArgument(var1 > 0, "must be greater than zero: %s", new Object[]{Integer.valueOf(var1)});
      return new Splitter(this.strategy, this.omitEmptyStrings, this.trimmer, var1);
   }

   @CheckReturnValue
   public Splitter trimResults() {
      return this.trimResults(CharMatcher.WHITESPACE);
   }

   @CheckReturnValue
   public Splitter trimResults(CharMatcher var1) {
      Preconditions.checkNotNull(var1);
      return new Splitter(this.strategy, this.omitEmptyStrings, var1, this.limit);
   }

   @CheckReturnValue
   public Iterable split(CharSequence var1) {
      Preconditions.checkNotNull(var1);
      return new Splitter$5(this, var1);
   }

   private Iterator splittingIterator(CharSequence var1) {
      return this.strategy.iterator(this, var1);
   }

   @CheckReturnValue
   @Beta
   public List splitToList(CharSequence var1) {
      Preconditions.checkNotNull(var1);
      Iterator var2 = this.splittingIterator(var1);
      ArrayList var3 = new ArrayList();

      while(var2.hasNext()) {
         var3.add(var2.next());
      }

      return Collections.unmodifiableList(var3);
   }

   @CheckReturnValue
   @Beta
   public Splitter$MapSplitter withKeyValueSeparator(String var1) {
      return this.withKeyValueSeparator(on(var1));
   }

   @CheckReturnValue
   @Beta
   public Splitter$MapSplitter withKeyValueSeparator(char var1) {
      return this.withKeyValueSeparator(on(var1));
   }

   @CheckReturnValue
   @Beta
   public Splitter$MapSplitter withKeyValueSeparator(Splitter var1) {
      return new Splitter$MapSplitter(this, var1, (Splitter$1)null);
   }

   // $FF: synthetic method
   static Iterator access$000(Splitter var0, CharSequence var1) {
      return var0.splittingIterator(var1);
   }

   // $FF: synthetic method
   static CharMatcher access$200(Splitter var0) {
      return var0.trimmer;
   }

   // $FF: synthetic method
   static boolean access$300(Splitter var0) {
      return var0.omitEmptyStrings;
   }

   // $FF: synthetic method
   static int access$400(Splitter var0) {
      return var0.limit;
   }
}
