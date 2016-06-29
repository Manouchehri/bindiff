package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Joiner$1;
import com.google.common.base.Joiner$2;
import com.google.common.base.Joiner$3;
import com.google.common.base.Joiner$MapJoiner;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible
public class Joiner {
   private final String separator;

   @CheckReturnValue
   public static Joiner on(String var0) {
      return new Joiner(var0);
   }

   @CheckReturnValue
   public static Joiner on(char var0) {
      return new Joiner(String.valueOf(var0));
   }

   private Joiner(String var1) {
      this.separator = (String)Preconditions.checkNotNull(var1);
   }

   private Joiner(Joiner var1) {
      this.separator = var1.separator;
   }

   public Appendable appendTo(Appendable var1, Iterable var2) {
      return this.appendTo(var1, var2.iterator());
   }

   public Appendable appendTo(Appendable var1, Iterator var2) {
      Preconditions.checkNotNull(var1);
      if(var2.hasNext()) {
         var1.append(this.toString(var2.next()));

         while(var2.hasNext()) {
            var1.append(this.separator);
            var1.append(this.toString(var2.next()));
         }
      }

      return var1;
   }

   public final Appendable appendTo(Appendable var1, Object[] var2) {
      return this.appendTo((Appendable)var1, (Iterable)Arrays.asList(var2));
   }

   public final Appendable appendTo(Appendable var1, @Nullable Object var2, @Nullable Object var3, Object... var4) {
      return this.appendTo(var1, iterable(var2, var3, var4));
   }

   public final StringBuilder appendTo(StringBuilder var1, Iterable var2) {
      return this.appendTo(var1, var2.iterator());
   }

   public final StringBuilder appendTo(StringBuilder var1, Iterator var2) {
      try {
         this.appendTo((Appendable)var1, (Iterator)var2);
         return var1;
      } catch (IOException var4) {
         throw new AssertionError(var4);
      }
   }

   public final StringBuilder appendTo(StringBuilder var1, Object[] var2) {
      return this.appendTo((StringBuilder)var1, (Iterable)Arrays.asList(var2));
   }

   public final StringBuilder appendTo(StringBuilder var1, @Nullable Object var2, @Nullable Object var3, Object... var4) {
      return this.appendTo(var1, iterable(var2, var3, var4));
   }

   @CheckReturnValue
   public final String join(Iterable var1) {
      return this.join(var1.iterator());
   }

   @CheckReturnValue
   public final String join(Iterator var1) {
      return this.appendTo(new StringBuilder(), var1).toString();
   }

   @CheckReturnValue
   public final String join(Object[] var1) {
      return this.join((Iterable)Arrays.asList(var1));
   }

   @CheckReturnValue
   public final String join(@Nullable Object var1, @Nullable Object var2, Object... var3) {
      return this.join(iterable(var1, var2, var3));
   }

   @CheckReturnValue
   public Joiner useForNull(String var1) {
      Preconditions.checkNotNull(var1);
      return new Joiner$1(this, this, var1);
   }

   @CheckReturnValue
   public Joiner skipNulls() {
      return new Joiner$2(this, this);
   }

   @CheckReturnValue
   public Joiner$MapJoiner withKeyValueSeparator(String var1) {
      return new Joiner$MapJoiner(this, var1, (Joiner$1)null);
   }

   CharSequence toString(Object var1) {
      Preconditions.checkNotNull(var1);
      return (CharSequence)(var1 instanceof CharSequence?(CharSequence)var1:var1.toString());
   }

   private static Iterable iterable(Object var0, Object var1, Object[] var2) {
      Preconditions.checkNotNull(var2);
      return new Joiner$3(var2, var0, var1);
   }

   // $FF: synthetic method
   Joiner(Joiner var1, Joiner$1 var2) {
      this(var1);
   }

   // $FF: synthetic method
   static String access$100(Joiner var0) {
      return var0.separator;
   }
}
