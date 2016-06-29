package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.collect.ForwardingObject;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ForwardingMapEntry extends ForwardingObject implements Entry {
   protected abstract Entry delegate();

   public Object getKey() {
      return this.delegate().getKey();
   }

   public Object getValue() {
      return this.delegate().getValue();
   }

   public Object setValue(Object var1) {
      return this.delegate().setValue(var1);
   }

   public boolean equals(@Nullable Object var1) {
      return this.delegate().equals(var1);
   }

   public int hashCode() {
      return this.delegate().hashCode();
   }

   protected boolean standardEquals(@Nullable Object var1) {
      if(!(var1 instanceof Entry)) {
         return false;
      } else {
         Entry var2 = (Entry)var1;
         return Objects.equal(this.getKey(), var2.getKey()) && Objects.equal(this.getValue(), var2.getValue());
      }
   }

   protected int standardHashCode() {
      Object var1 = this.getKey();
      Object var2 = this.getValue();
      return (var1 == null?0:var1.hashCode()) ^ (var2 == null?0:var2.hashCode());
   }

   @Beta
   protected String standardToString() {
      String var1 = String.valueOf(this.getKey());
      String var2 = String.valueOf(this.getValue());
      return (new StringBuilder(1 + String.valueOf(var1).length() + String.valueOf(var2).length())).append(var1).append("=").append(var2).toString();
   }
}
