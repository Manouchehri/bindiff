package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.MapMaker;
import com.google.common.collect.MapMaker$RemovalCause;
import com.google.common.collect.MapMaker$RemovalListener;
import com.google.common.collect.MapMaker$RemovalNotification;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

class MapMaker$NullConcurrentMap extends AbstractMap implements Serializable, ConcurrentMap {
   private static final long serialVersionUID = 0L;
   private final MapMaker$RemovalListener removalListener;
   private final MapMaker$RemovalCause removalCause;

   MapMaker$NullConcurrentMap(MapMaker var1) {
      this.removalListener = var1.getRemovalListener();
      this.removalCause = var1.nullRemovalCause;
   }

   public boolean containsKey(@Nullable Object var1) {
      return false;
   }

   public boolean containsValue(@Nullable Object var1) {
      return false;
   }

   public Object get(@Nullable Object var1) {
      return null;
   }

   void notifyRemoval(Object var1, Object var2) {
      MapMaker$RemovalNotification var3 = new MapMaker$RemovalNotification(var1, var2, this.removalCause);
      this.removalListener.onRemoval(var3);
   }

   public Object put(Object var1, Object var2) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var2);
      this.notifyRemoval(var1, var2);
      return null;
   }

   public Object putIfAbsent(Object var1, Object var2) {
      return this.put(var1, var2);
   }

   public Object remove(@Nullable Object var1) {
      return null;
   }

   public boolean remove(@Nullable Object var1, @Nullable Object var2) {
      return false;
   }

   public Object replace(Object var1, Object var2) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var2);
      return null;
   }

   public boolean replace(Object var1, @Nullable Object var2, Object var3) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var3);
      return false;
   }

   public Set entrySet() {
      return Collections.emptySet();
   }
}
