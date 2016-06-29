package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractBiMap$1;
import com.google.common.collect.AbstractBiMap$EntrySet;
import com.google.common.collect.AbstractBiMap$Inverse;
import com.google.common.collect.AbstractBiMap$KeySet;
import com.google.common.collect.AbstractBiMap$ValueSet;
import com.google.common.collect.BiMap;
import com.google.common.collect.ForwardingMap;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible(
   emulated = true
)
abstract class AbstractBiMap extends ForwardingMap implements BiMap, Serializable {
   private transient Map delegate;
   transient AbstractBiMap inverse;
   private transient Set keySet;
   private transient Set valueSet;
   private transient Set entrySet;
   @GwtIncompatible("Not needed in emulated source.")
   private static final long serialVersionUID = 0L;

   AbstractBiMap(Map var1, Map var2) {
      this.setDelegates(var1, var2);
   }

   private AbstractBiMap(Map var1, AbstractBiMap var2) {
      this.delegate = var1;
      this.inverse = var2;
   }

   protected Map delegate() {
      return this.delegate;
   }

   Object checkKey(@Nullable Object var1) {
      return var1;
   }

   Object checkValue(@Nullable Object var1) {
      return var1;
   }

   void setDelegates(Map var1, Map var2) {
      Preconditions.checkState(this.delegate == null);
      Preconditions.checkState(this.inverse == null);
      Preconditions.checkArgument(var1.isEmpty());
      Preconditions.checkArgument(var2.isEmpty());
      Preconditions.checkArgument(var1 != var2);
      this.delegate = var1;
      this.inverse = new AbstractBiMap$Inverse(var2, this, (AbstractBiMap$1)null);
   }

   void setInverse(AbstractBiMap var1) {
      this.inverse = var1;
   }

   public boolean containsValue(@Nullable Object var1) {
      return this.inverse.containsKey(var1);
   }

   public Object put(@Nullable Object var1, @Nullable Object var2) {
      return this.putInBothMaps(var1, var2, false);
   }

   public Object forcePut(@Nullable Object var1, @Nullable Object var2) {
      return this.putInBothMaps(var1, var2, true);
   }

   private Object putInBothMaps(@Nullable Object var1, @Nullable Object var2, boolean var3) {
      this.checkKey(var1);
      this.checkValue(var2);
      boolean var4 = this.containsKey(var1);
      if(var4 && Objects.equal(var2, this.get(var1))) {
         return var2;
      } else {
         if(var3) {
            this.inverse().remove(var2);
         } else {
            Preconditions.checkArgument(!this.containsValue(var2), "value already present: %s", new Object[]{var2});
         }

         Object var5 = this.delegate.put(var1, var2);
         this.updateInverseMap(var1, var4, var5, var2);
         return var5;
      }
   }

   private void updateInverseMap(Object var1, boolean var2, Object var3, Object var4) {
      if(var2) {
         this.removeFromInverseMap(var3);
      }

      this.inverse.delegate.put(var4, var1);
   }

   public Object remove(@Nullable Object var1) {
      return this.containsKey(var1)?this.removeFromBothMaps(var1):null;
   }

   private Object removeFromBothMaps(Object var1) {
      Object var2 = this.delegate.remove(var1);
      this.removeFromInverseMap(var2);
      return var2;
   }

   private void removeFromInverseMap(Object var1) {
      this.inverse.delegate.remove(var1);
   }

   public void putAll(Map var1) {
      Iterator var2 = var1.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         this.put(var3.getKey(), var3.getValue());
      }

   }

   public void clear() {
      this.delegate.clear();
      this.inverse.delegate.clear();
   }

   public BiMap inverse() {
      return this.inverse;
   }

   public Set keySet() {
      Set var1 = this.keySet;
      return var1 == null?(this.keySet = new AbstractBiMap$KeySet(this, (AbstractBiMap$1)null)):var1;
   }

   public Set values() {
      Set var1 = this.valueSet;
      return var1 == null?(this.valueSet = new AbstractBiMap$ValueSet(this, (AbstractBiMap$1)null)):var1;
   }

   public Set entrySet() {
      Set var1 = this.entrySet;
      return var1 == null?(this.entrySet = new AbstractBiMap$EntrySet(this, (AbstractBiMap$1)null)):var1;
   }

   // $FF: synthetic method
   static Map access$200(AbstractBiMap var0) {
      return var0.delegate;
   }

   // $FF: synthetic method
   static Object access$300(AbstractBiMap var0, Object var1) {
      return var0.removeFromBothMaps(var1);
   }

   // $FF: synthetic method
   static void access$600(AbstractBiMap var0, Object var1, boolean var2, Object var3, Object var4) {
      var0.updateInverseMap(var1, var2, var3, var4);
   }

   // $FF: synthetic method
   static void access$700(AbstractBiMap var0, Object var1) {
      var0.removeFromInverseMap(var1);
   }

   // $FF: synthetic method
   AbstractBiMap(Map var1, AbstractBiMap var2, AbstractBiMap$1 var3) {
      this(var1, var2);
   }
}
