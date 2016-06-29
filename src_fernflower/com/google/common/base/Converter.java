package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Converter$1;
import com.google.common.base.Converter$ConverterComposition;
import com.google.common.base.Converter$FunctionBasedConverter;
import com.google.common.base.Converter$IdentityConverter;
import com.google.common.base.Converter$ReverseConverter;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.LazyInit;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
public abstract class Converter implements Function {
   private final boolean handleNullAutomatically;
   @LazyInit
   private transient Converter reverse;

   protected Converter() {
      this(true);
   }

   Converter(boolean var1) {
      this.handleNullAutomatically = var1;
   }

   protected abstract Object doForward(Object var1);

   protected abstract Object doBackward(Object var1);

   @Nullable
   public final Object convert(@Nullable Object var1) {
      return this.correctedDoForward(var1);
   }

   @Nullable
   Object correctedDoForward(@Nullable Object var1) {
      return this.handleNullAutomatically?(var1 == null?null:Preconditions.checkNotNull(this.doForward(var1))):this.doForward(var1);
   }

   @Nullable
   Object correctedDoBackward(@Nullable Object var1) {
      return this.handleNullAutomatically?(var1 == null?null:Preconditions.checkNotNull(this.doBackward(var1))):this.doBackward(var1);
   }

   public Iterable convertAll(Iterable var1) {
      Preconditions.checkNotNull(var1, "fromIterable");
      return new Converter$1(this, var1);
   }

   public Converter reverse() {
      Converter var1 = this.reverse;
      return var1 == null?(this.reverse = new Converter$ReverseConverter(this)):var1;
   }

   public final Converter andThen(Converter var1) {
      return this.doAndThen(var1);
   }

   Converter doAndThen(Converter var1) {
      return new Converter$ConverterComposition(this, (Converter)Preconditions.checkNotNull(var1));
   }

   @Deprecated
   @Nullable
   public final Object apply(@Nullable Object var1) {
      return this.convert(var1);
   }

   public boolean equals(@Nullable Object var1) {
      return super.equals(var1);
   }

   public static Converter from(Function var0, Function var1) {
      return new Converter$FunctionBasedConverter(var0, var1, (Converter$1)null);
   }

   public static Converter identity() {
      return Converter$IdentityConverter.INSTANCE;
   }
}
