package com.google.common.base;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Receiver;
import com.google.common.base.Receivers$1;
import com.google.common.base.Receivers$CollectingReceiver;
import com.google.common.base.Receivers$CompositeReceiver;
import java.util.Arrays;
import java.util.Collection;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
@GoogleInternal
@GwtCompatible
public final class Receivers {
   private static final Receiver IGNORING_RECEIVER = new Receivers$1();

   public static Receiver ignore() {
      return IGNORING_RECEIVER;
   }

   public static Receiver collect(Collection var0) {
      return new Receivers$CollectingReceiver(var0);
   }

   public static Receiver compose(Receiver... var0) {
      return new Receivers$CompositeReceiver(Arrays.asList(var0));
   }

   public static Receiver compose(Iterable var0) {
      return new Receivers$CompositeReceiver(var0);
   }
}
