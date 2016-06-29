package com.google.common.collect;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.CompactHashSet;
import com.google.common.collect.CompactLinkedHashSet$1;
import com.google.common.collect.ObjectArrays;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

@GoogleInternal
@GwtIncompatible("not worth using in GWT for now")
public class CompactLinkedHashSet extends CompactHashSet {
   private static final int ENDPOINT = -2;
   private transient int[] predecessor;
   private transient int[] successor;
   private transient int firstEntry;
   private transient int lastEntry;

   public static CompactLinkedHashSet create() {
      return new CompactLinkedHashSet();
   }

   public static CompactLinkedHashSet create(Collection var0) {
      CompactLinkedHashSet var1 = createWithExpectedSize(var0.size());
      var1.addAll(var0);
      return var1;
   }

   public static CompactLinkedHashSet create(Object... var0) {
      CompactLinkedHashSet var1 = createWithExpectedSize(var0.length);
      Collections.addAll(var1, var0);
      return var1;
   }

   public static CompactLinkedHashSet createWithExpectedSize(int var0) {
      return new CompactLinkedHashSet(var0);
   }

   CompactLinkedHashSet() {
   }

   CompactLinkedHashSet(int var1) {
      super(var1);
   }

   void init(int var1, float var2) {
      super.init(var1, var2);
      this.predecessor = new int[var1];
      this.successor = new int[var1];
      Arrays.fill(this.predecessor, -1);
      Arrays.fill(this.successor, -1);
      this.firstEntry = -2;
      this.lastEntry = -2;
   }

   private void succeeds(int var1, int var2) {
      if(var1 == -2) {
         this.firstEntry = var2;
      } else {
         this.successor[var1] = var2;
      }

      if(var2 == -2) {
         this.lastEntry = var1;
      } else {
         this.predecessor[var2] = var1;
      }

   }

   void insertEntry(int var1, Object var2, int var3) {
      super.insertEntry(var1, var2, var3);
      this.succeeds(this.lastEntry, var1);
      this.succeeds(var1, -2);
   }

   void moveEntry(int var1) {
      int var2 = this.size() - 1;
      super.moveEntry(var1);
      this.succeeds(this.predecessor[var1], this.successor[var1]);
      if(var2 != var1) {
         this.succeeds(this.predecessor[var2], var1);
         this.succeeds(var1, this.successor[var2]);
      }

      this.predecessor[var2] = -1;
      this.successor[var2] = -1;
   }

   public void clear() {
      super.clear();
      this.firstEntry = -2;
      this.lastEntry = -2;
      Arrays.fill(this.predecessor, -1);
      Arrays.fill(this.successor, -1);
   }

   void resizeEntries(int var1) {
      super.resizeEntries(var1);
      int var2 = this.predecessor.length;
      this.predecessor = Arrays.copyOf(this.predecessor, var1);
      this.successor = Arrays.copyOf(this.successor, var1);
      if(var2 < var1) {
         Arrays.fill(this.predecessor, var2, var1, -1);
         Arrays.fill(this.successor, var2, var1, -1);
      }

   }

   public Object[] toArray() {
      return ObjectArrays.toArrayImpl(this);
   }

   public Object[] toArray(Object[] var1) {
      return ObjectArrays.toArrayImpl(this, var1);
   }

   public Iterator iterator() {
      return new CompactLinkedHashSet$1(this);
   }

   // $FF: synthetic method
   static int access$000(CompactLinkedHashSet var0) {
      return var0.firstEntry;
   }

   // $FF: synthetic method
   static int[] access$100(CompactLinkedHashSet var0) {
      return var0.successor;
   }
}
