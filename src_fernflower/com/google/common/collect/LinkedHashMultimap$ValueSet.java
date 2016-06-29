package com.google.common.collect;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Hashing;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.LinkedHashMultimap$ValueEntry;
import com.google.common.collect.LinkedHashMultimap$ValueSet$1;
import com.google.common.collect.LinkedHashMultimap$ValueSetLink;
import com.google.common.collect.Sets$ImprovedAbstractSet;
import java.util.Arrays;
import java.util.Iterator;
import javax.annotation.Nullable;

@VisibleForTesting
final class LinkedHashMultimap$ValueSet extends Sets$ImprovedAbstractSet implements LinkedHashMultimap$ValueSetLink {
   private final Object key;
   @VisibleForTesting
   LinkedHashMultimap$ValueEntry[] hashTable;
   private int size;
   private int modCount;
   private LinkedHashMultimap$ValueSetLink firstEntry;
   private LinkedHashMultimap$ValueSetLink lastEntry;
   // $FF: synthetic field
   final LinkedHashMultimap this$0;

   LinkedHashMultimap$ValueSet(LinkedHashMultimap var1, Object var2, int var3) {
      this.this$0 = var1;
      this.size = 0;
      this.modCount = 0;
      this.key = var2;
      this.firstEntry = this;
      this.lastEntry = this;
      int var4 = Hashing.closedTableSize(var3, 1.0D);
      LinkedHashMultimap$ValueEntry[] var5 = new LinkedHashMultimap$ValueEntry[var4];
      this.hashTable = var5;
   }

   private int mask() {
      return this.hashTable.length - 1;
   }

   public LinkedHashMultimap$ValueSetLink getPredecessorInValueSet() {
      return this.lastEntry;
   }

   public LinkedHashMultimap$ValueSetLink getSuccessorInValueSet() {
      return this.firstEntry;
   }

   public void setPredecessorInValueSet(LinkedHashMultimap$ValueSetLink var1) {
      this.lastEntry = var1;
   }

   public void setSuccessorInValueSet(LinkedHashMultimap$ValueSetLink var1) {
      this.firstEntry = var1;
   }

   public Iterator iterator() {
      return new LinkedHashMultimap$ValueSet$1(this);
   }

   public int size() {
      return this.size;
   }

   public boolean contains(@Nullable Object var1) {
      int var2 = Hashing.smearedHash(var1);

      for(LinkedHashMultimap$ValueEntry var3 = this.hashTable[var2 & this.mask()]; var3 != null; var3 = var3.nextInValueBucket) {
         if(var3.matchesValue(var1, var2)) {
            return true;
         }
      }

      return false;
   }

   public boolean add(@Nullable Object var1) {
      int var2 = Hashing.smearedHash(var1);
      int var3 = var2 & this.mask();
      LinkedHashMultimap$ValueEntry var4 = this.hashTable[var3];

      LinkedHashMultimap$ValueEntry var5;
      for(var5 = var4; var5 != null; var5 = var5.nextInValueBucket) {
         if(var5.matchesValue(var1, var2)) {
            return false;
         }
      }

      var5 = new LinkedHashMultimap$ValueEntry(this.key, var1, var2, var4);
      LinkedHashMultimap.access$200(this.lastEntry, var5);
      LinkedHashMultimap.access$200(var5, this);
      LinkedHashMultimap.access$400(LinkedHashMultimap.access$300(this.this$0).getPredecessorInMultimap(), var5);
      LinkedHashMultimap.access$400(var5, LinkedHashMultimap.access$300(this.this$0));
      this.hashTable[var3] = var5;
      ++this.size;
      ++this.modCount;
      this.rehashIfNecessary();
      return true;
   }

   private void rehashIfNecessary() {
      if(Hashing.needsResizing(this.size, this.hashTable.length, 1.0D)) {
         LinkedHashMultimap$ValueEntry[] var1 = new LinkedHashMultimap$ValueEntry[this.hashTable.length * 2];
         this.hashTable = var1;
         int var2 = var1.length - 1;

         for(LinkedHashMultimap$ValueSetLink var3 = this.firstEntry; var3 != this; var3 = var3.getSuccessorInValueSet()) {
            LinkedHashMultimap$ValueEntry var4 = (LinkedHashMultimap$ValueEntry)var3;
            int var5 = var4.smearedValueHash & var2;
            var4.nextInValueBucket = var1[var5];
            var1[var5] = var4;
         }
      }

   }

   public boolean remove(@Nullable Object var1) {
      int var2 = Hashing.smearedHash(var1);
      int var3 = var2 & this.mask();
      LinkedHashMultimap$ValueEntry var4 = null;

      for(LinkedHashMultimap$ValueEntry var5 = this.hashTable[var3]; var5 != null; var5 = var5.nextInValueBucket) {
         if(var5.matchesValue(var1, var2)) {
            if(var4 == null) {
               this.hashTable[var3] = var5.nextInValueBucket;
            } else {
               var4.nextInValueBucket = var5.nextInValueBucket;
            }

            LinkedHashMultimap.access$500(var5);
            LinkedHashMultimap.access$600(var5);
            --this.size;
            ++this.modCount;
            return true;
         }

         var4 = var5;
      }

      return false;
   }

   public void clear() {
      Arrays.fill(this.hashTable, (Object)null);
      this.size = 0;

      for(LinkedHashMultimap$ValueSetLink var1 = this.firstEntry; var1 != this; var1 = var1.getSuccessorInValueSet()) {
         LinkedHashMultimap$ValueEntry var2 = (LinkedHashMultimap$ValueEntry)var1;
         LinkedHashMultimap.access$600(var2);
      }

      LinkedHashMultimap.access$200(this, this);
      ++this.modCount;
   }

   // $FF: synthetic method
   static LinkedHashMultimap$ValueSetLink access$000(LinkedHashMultimap$ValueSet var0) {
      return var0.firstEntry;
   }

   // $FF: synthetic method
   static int access$100(LinkedHashMultimap$ValueSet var0) {
      return var0.modCount;
   }
}
