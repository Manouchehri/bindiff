package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMultiset;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.ConcurrentHashMultiset$1;
import com.google.common.collect.ConcurrentHashMultiset$2;
import com.google.common.collect.ConcurrentHashMultiset$3;
import com.google.common.collect.ConcurrentHashMultiset$EntrySet;
import com.google.common.collect.ConcurrentHashMultiset$FieldSettersHolder;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Maps;
import com.google.common.collect.Multiset$Entry;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

public final class ConcurrentHashMultiset extends AbstractMultiset implements Serializable {
   private final transient ConcurrentMap countMap;
   private static final long serialVersionUID = 1L;

   public static ConcurrentHashMultiset create() {
      return new ConcurrentHashMultiset(new ConcurrentHashMap());
   }

   public static ConcurrentHashMultiset create(Iterable var0) {
      ConcurrentHashMultiset var1 = create();
      Iterables.addAll(var1, var0);
      return var1;
   }

   @Beta
   public static ConcurrentHashMultiset create(MapMaker var0) {
      return new ConcurrentHashMultiset(var0.makeMap());
   }

   @VisibleForTesting
   ConcurrentHashMultiset(ConcurrentMap var1) {
      Preconditions.checkArgument(var1.isEmpty());
      this.countMap = var1;
   }

   public int count(@Nullable Object var1) {
      AtomicInteger var2 = (AtomicInteger)Maps.safeGet(this.countMap, var1);
      return var2 == null?0:var2.get();
   }

   public int size() {
      long var1 = 0L;

      AtomicInteger var4;
      for(Iterator var3 = this.countMap.values().iterator(); var3.hasNext(); var1 += (long)var4.get()) {
         var4 = (AtomicInteger)var3.next();
      }

      return Ints.saturatedCast(var1);
   }

   public Object[] toArray() {
      return this.snapshot().toArray();
   }

   public Object[] toArray(Object[] var1) {
      return this.snapshot().toArray(var1);
   }

   private List snapshot() {
      ArrayList var1 = Lists.newArrayListWithExpectedSize(this.size());
      Iterator var2 = this.entrySet().iterator();

      while(var2.hasNext()) {
         Multiset$Entry var3 = (Multiset$Entry)var2.next();
         Object var4 = var3.getElement();

         for(int var5 = var3.getCount(); var5 > 0; --var5) {
            var1.add(var4);
         }
      }

      return var1;
   }

   public int add(Object var1, int var2) {
      Preconditions.checkNotNull(var1);
      if(var2 == 0) {
         return this.count(var1);
      } else {
         Preconditions.checkArgument(var2 > 0, "Invalid occurrences: %s", new Object[]{Integer.valueOf(var2)});

         AtomicInteger var3;
         AtomicInteger var7;
         do {
            var3 = (AtomicInteger)Maps.safeGet(this.countMap, var1);
            if(var3 == null) {
               var3 = (AtomicInteger)this.countMap.putIfAbsent(var1, new AtomicInteger(var2));
               if(var3 == null) {
                  return 0;
               }
            }

            while(true) {
               int var4 = var3.get();
               if(var4 == 0) {
                  var7 = new AtomicInteger(var2);
                  break;
               }

               try {
                  int var5 = IntMath.checkedAdd(var4, var2);
                  if(var3.compareAndSet(var4, var5)) {
                     return var4;
                  }
               } catch (ArithmeticException var6) {
                  throw new IllegalArgumentException((new StringBuilder(65)).append("Overflow adding ").append(var2).append(" occurrences to a count of ").append(var4).toString());
               }
            }
         } while(this.countMap.putIfAbsent(var1, var7) != null && !this.countMap.replace(var1, var3, var7));

         return 0;
      }
   }

   public int remove(@Nullable Object var1, int var2) {
      if(var2 == 0) {
         return this.count(var1);
      } else {
         Preconditions.checkArgument(var2 > 0, "Invalid occurrences: %s", new Object[]{Integer.valueOf(var2)});
         AtomicInteger var3 = (AtomicInteger)Maps.safeGet(this.countMap, var1);
         if(var3 == null) {
            return 0;
         } else {
            int var4;
            int var5;
            do {
               var4 = var3.get();
               if(var4 == 0) {
                  return 0;
               }

               var5 = Math.max(0, var4 - var2);
            } while(!var3.compareAndSet(var4, var5));

            if(var5 == 0) {
               this.countMap.remove(var1, var3);
            }

            return var4;
         }
      }
   }

   public boolean removeExactly(@Nullable Object var1, int var2) {
      if(var2 == 0) {
         return true;
      } else {
         Preconditions.checkArgument(var2 > 0, "Invalid occurrences: %s", new Object[]{Integer.valueOf(var2)});
         AtomicInteger var3 = (AtomicInteger)Maps.safeGet(this.countMap, var1);
         if(var3 == null) {
            return false;
         } else {
            int var4;
            int var5;
            do {
               var4 = var3.get();
               if(var4 < var2) {
                  return false;
               }

               var5 = var4 - var2;
            } while(!var3.compareAndSet(var4, var5));

            if(var5 == 0) {
               this.countMap.remove(var1, var3);
            }

            return true;
         }
      }
   }

   public int setCount(Object var1, int var2) {
      Preconditions.checkNotNull(var1);
      CollectPreconditions.checkNonnegative(var2, "count");

      AtomicInteger var3;
      AtomicInteger var5;
      label40:
      do {
         var3 = (AtomicInteger)Maps.safeGet(this.countMap, var1);
         if(var3 == null) {
            if(var2 == 0) {
               return 0;
            }

            var3 = (AtomicInteger)this.countMap.putIfAbsent(var1, new AtomicInteger(var2));
            if(var3 == null) {
               return 0;
            }
         }

         int var4;
         do {
            var4 = var3.get();
            if(var4 == 0) {
               if(var2 == 0) {
                  return 0;
               }

               var5 = new AtomicInteger(var2);
               continue label40;
            }
         } while(!var3.compareAndSet(var4, var2));

         if(var2 == 0) {
            this.countMap.remove(var1, var3);
         }

         return var4;
      } while(this.countMap.putIfAbsent(var1, var5) != null && !this.countMap.replace(var1, var3, var5));

      return 0;
   }

   public boolean setCount(Object var1, int var2, int var3) {
      Preconditions.checkNotNull(var1);
      CollectPreconditions.checkNonnegative(var2, "oldCount");
      CollectPreconditions.checkNonnegative(var3, "newCount");
      AtomicInteger var4 = (AtomicInteger)Maps.safeGet(this.countMap, var1);
      if(var4 == null) {
         return var2 != 0?false:(var3 == 0?true:this.countMap.putIfAbsent(var1, new AtomicInteger(var3)) == null);
      } else {
         int var5 = var4.get();
         if(var5 == var2) {
            if(var5 == 0) {
               if(var3 == 0) {
                  this.countMap.remove(var1, var4);
                  return true;
               }

               AtomicInteger var6 = new AtomicInteger(var3);
               return this.countMap.putIfAbsent(var1, var6) == null || this.countMap.replace(var1, var4, var6);
            }

            if(var4.compareAndSet(var5, var3)) {
               if(var3 == 0) {
                  this.countMap.remove(var1, var4);
               }

               return true;
            }
         }

         return false;
      }
   }

   Set createElementSet() {
      Set var1 = this.countMap.keySet();
      return new ConcurrentHashMultiset$1(this, var1);
   }

   public Set createEntrySet() {
      return new ConcurrentHashMultiset$EntrySet(this, (ConcurrentHashMultiset$1)null);
   }

   int distinctElements() {
      return this.countMap.size();
   }

   public boolean isEmpty() {
      return this.countMap.isEmpty();
   }

   Iterator entryIterator() {
      ConcurrentHashMultiset$2 var1 = new ConcurrentHashMultiset$2(this);
      return new ConcurrentHashMultiset$3(this, var1);
   }

   public void clear() {
      this.countMap.clear();
   }

   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      var1.writeObject(this.countMap);
   }

   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      ConcurrentMap var2 = (ConcurrentMap)var1.readObject();
      ConcurrentHashMultiset$FieldSettersHolder.COUNT_MAP_FIELD_SETTER.set(this, var2);
   }

   // $FF: synthetic method
   static ConcurrentMap access$100(ConcurrentHashMultiset var0) {
      return var0.countMap;
   }
}
