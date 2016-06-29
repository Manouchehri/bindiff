package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingMap;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ForwardingSortedMap extends ForwardingMap implements SortedMap {
   protected abstract SortedMap delegate();

   public Comparator comparator() {
      return this.delegate().comparator();
   }

   public Object firstKey() {
      return this.delegate().firstKey();
   }

   public SortedMap headMap(Object var1) {
      return this.delegate().headMap(var1);
   }

   public Object lastKey() {
      return this.delegate().lastKey();
   }

   public SortedMap subMap(Object var1, Object var2) {
      return this.delegate().subMap(var1, var2);
   }

   public SortedMap tailMap(Object var1) {
      return this.delegate().tailMap(var1);
   }

   private int unsafeCompare(Object var1, Object var2) {
      Comparator var3 = this.comparator();
      return var3 == null?((Comparable)var1).compareTo(var2):var3.compare(var1, var2);
   }

   @Beta
   protected boolean standardContainsKey(@Nullable Object var1) {
      try {
         Object var3 = this.tailMap(var1).firstKey();
         return this.unsafeCompare(var3, var1) == 0;
      } catch (ClassCastException var4) {
         return false;
      } catch (NoSuchElementException var5) {
         return false;
      } catch (NullPointerException var6) {
         return false;
      }
   }

   @Beta
   protected SortedMap standardSubMap(Object var1, Object var2) {
      Preconditions.checkArgument(this.unsafeCompare(var1, var2) <= 0, "fromKey must be <= toKey");
      return this.tailMap(var1).headMap(var2);
   }
}
