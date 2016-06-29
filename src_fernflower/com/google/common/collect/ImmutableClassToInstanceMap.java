package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ImmutableClassToInstanceMap$1;
import com.google.common.collect.ImmutableClassToInstanceMap$Builder;
import com.google.common.collect.ImmutableMap;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.Nullable;

public final class ImmutableClassToInstanceMap extends ForwardingMap implements ClassToInstanceMap, Serializable {
   private static final ImmutableClassToInstanceMap EMPTY = new ImmutableClassToInstanceMap(ImmutableMap.of());
   private final ImmutableMap delegate;

   public static ImmutableClassToInstanceMap of() {
      return EMPTY;
   }

   public static ImmutableClassToInstanceMap of(Class var0, Object var1) {
      ImmutableMap var2 = ImmutableMap.of(var0, var1);
      return new ImmutableClassToInstanceMap(var2);
   }

   public static ImmutableClassToInstanceMap$Builder builder() {
      return new ImmutableClassToInstanceMap$Builder();
   }

   public static ImmutableClassToInstanceMap copyOf(Map var0) {
      if(var0 instanceof ImmutableClassToInstanceMap) {
         ImmutableClassToInstanceMap var1 = (ImmutableClassToInstanceMap)var0;
         return var1;
      } else {
         return (new ImmutableClassToInstanceMap$Builder()).putAll(var0).build();
      }
   }

   private ImmutableClassToInstanceMap(ImmutableMap var1) {
      this.delegate = var1;
   }

   protected Map delegate() {
      return this.delegate;
   }

   @Nullable
   public Object getInstance(Class var1) {
      return this.delegate.get(Preconditions.checkNotNull(var1));
   }

   @Deprecated
   public Object putInstance(Class var1, Object var2) {
      throw new UnsupportedOperationException();
   }

   Object readResolve() {
      return this.isEmpty()?of():this;
   }

   // $FF: synthetic method
   ImmutableClassToInstanceMap(ImmutableMap var1, ImmutableClassToInstanceMap$1 var2) {
      this(var1);
   }
}
