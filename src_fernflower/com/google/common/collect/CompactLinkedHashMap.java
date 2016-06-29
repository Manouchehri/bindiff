package com.google.common.collect;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.CompactHashMap;
import com.google.common.collect.CompactLinkedHashMap$1EntrySetImpl;
import com.google.common.collect.CompactLinkedHashMap$1KeySetImpl;
import com.google.common.collect.CompactLinkedHashMap$1ValuesImpl;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

@GoogleInternal
@GwtIncompatible("not worth using in GWT for now")
public class CompactLinkedHashMap extends CompactHashMap {
   private static final int ENDPOINT = -2;
   @VisibleForTesting
   transient long[] links;
   private transient int firstEntry;
   private transient int lastEntry;
   private final boolean accessOrder;

   public static CompactLinkedHashMap create() {
      return new CompactLinkedHashMap();
   }

   public static CompactLinkedHashMap createWithExpectedSize(int var0) {
      return new CompactLinkedHashMap(var0);
   }

   CompactLinkedHashMap() {
      this(3);
   }

   CompactLinkedHashMap(int var1) {
      this(var1, 1.0F, false);
   }

   CompactLinkedHashMap(int var1, float var2, boolean var3) {
      super(var1, var2);
      this.accessOrder = var3;
   }

   void init(int var1, float var2) {
      super.init(var1, var2);
      this.firstEntry = -2;
      this.lastEntry = -2;
      this.links = new long[var1];
      Arrays.fill(this.links, -1L);
   }

   private int getPredecessor(int var1) {
      return (int)(this.links[var1] >>> 32);
   }

   private int getSuccessor(int var1) {
      return (int)this.links[var1];
   }

   private void setSuccessor(int var1, int var2) {
      long var3 = 4294967295L;
      this.links[var1] = this.links[var1] & ~var3 | (long)var2 & var3;
   }

   private void setPredecessor(int var1, int var2) {
      long var3 = -4294967296L;
      this.links[var1] = this.links[var1] & ~var3 | (long)var2 << 32;
   }

   private void setSucceeds(int var1, int var2) {
      if(var1 == -2) {
         this.firstEntry = var2;
      } else {
         this.setSuccessor(var1, var2);
      }

      if(var2 == -2) {
         this.lastEntry = var1;
      } else {
         this.setPredecessor(var2, var1);
      }

   }

   void insertEntry(int var1, Object var2, Object var3, int var4) {
      super.insertEntry(var1, var2, var3, var4);
      this.setSucceeds(this.lastEntry, var1);
      this.setSucceeds(var1, -2);
   }

   void accessEntry(int var1) {
      if(this.accessOrder) {
         this.setSucceeds(this.getPredecessor(var1), this.getSuccessor(var1));
         this.setSucceeds(this.lastEntry, var1);
         this.setSucceeds(var1, -2);
         ++this.modCount;
      }

   }

   void moveLastEntry(int var1) {
      int var2 = this.size() - 1;
      this.setSucceeds(this.getPredecessor(var1), this.getSuccessor(var1));
      if(var1 < var2) {
         this.setSucceeds(this.getPredecessor(var2), var1);
         this.setSucceeds(var1, this.getSuccessor(var2));
      }

      super.moveLastEntry(var1);
   }

   void resizeEntries(int var1) {
      super.resizeEntries(var1);
      this.links = Arrays.copyOf(this.links, var1);
   }

   Set createEntrySet() {
      return new CompactLinkedHashMap$1EntrySetImpl(this);
   }

   Set createKeySet() {
      return new CompactLinkedHashMap$1KeySetImpl(this);
   }

   Collection createValues() {
      return new CompactLinkedHashMap$1ValuesImpl(this);
   }

   public void clear() {
      super.clear();
      this.firstEntry = -2;
      this.lastEntry = -2;
   }

   // $FF: synthetic method
   static int access$000(CompactLinkedHashMap var0) {
      return var0.firstEntry;
   }

   // $FF: synthetic method
   static int access$100(CompactLinkedHashMap var0, int var1) {
      return var0.getSuccessor(var1);
   }
}
