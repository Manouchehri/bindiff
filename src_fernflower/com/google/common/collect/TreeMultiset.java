package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractSortedMultiset;
import com.google.common.collect.BoundType;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.GeneralRange;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Ordering;
import com.google.common.collect.Serialization;
import com.google.common.collect.SortedMultiset;
import com.google.common.collect.TreeMultiset$1;
import com.google.common.collect.TreeMultiset$2;
import com.google.common.collect.TreeMultiset$3;
import com.google.common.collect.TreeMultiset$4;
import com.google.common.collect.TreeMultiset$Aggregate;
import com.google.common.collect.TreeMultiset$AvlNode;
import com.google.common.collect.TreeMultiset$Reference;
import com.google.common.primitives.Ints;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtCompatible(
   emulated = true
)
public final class TreeMultiset extends AbstractSortedMultiset implements Serializable {
   private final transient TreeMultiset$Reference rootReference;
   private final transient GeneralRange range;
   private final transient TreeMultiset$AvlNode header;
   @GwtIncompatible("not needed in emulated source")
   private static final long serialVersionUID = 1L;

   public static TreeMultiset create() {
      return new TreeMultiset(Ordering.natural());
   }

   public static TreeMultiset create(@Nullable Comparator var0) {
      return var0 == null?new TreeMultiset(Ordering.natural()):new TreeMultiset(var0);
   }

   public static TreeMultiset create(Iterable var0) {
      TreeMultiset var1 = create();
      Iterables.addAll(var1, var0);
      return var1;
   }

   TreeMultiset(TreeMultiset$Reference var1, GeneralRange var2, TreeMultiset$AvlNode var3) {
      super(var2.comparator());
      this.rootReference = var1;
      this.range = var2;
      this.header = var3;
   }

   TreeMultiset(Comparator var1) {
      super(var1);
      this.range = GeneralRange.all(var1);
      this.header = new TreeMultiset$AvlNode((Object)null, 1);
      successor(this.header, this.header);
      this.rootReference = new TreeMultiset$Reference((TreeMultiset$1)null);
   }

   private long aggregateForEntries(TreeMultiset$Aggregate var1) {
      TreeMultiset$AvlNode var2 = (TreeMultiset$AvlNode)this.rootReference.get();
      long var3 = var1.treeAggregate(var2);
      if(this.range.hasLowerBound()) {
         var3 -= this.aggregateBelowRange(var1, var2);
      }

      if(this.range.hasUpperBound()) {
         var3 -= this.aggregateAboveRange(var1, var2);
      }

      return var3;
   }

   private long aggregateBelowRange(TreeMultiset$Aggregate var1, @Nullable TreeMultiset$AvlNode var2) {
      if(var2 == null) {
         return 0L;
      } else {
         int var3 = this.comparator().compare(this.range.getLowerEndpoint(), TreeMultiset$AvlNode.access$500(var2));
         if(var3 < 0) {
            return this.aggregateBelowRange(var1, TreeMultiset$AvlNode.access$600(var2));
         } else if(var3 == 0) {
            switch(TreeMultiset$4.$SwitchMap$com$google$common$collect$BoundType[this.range.getLowerBoundType().ordinal()]) {
            case 1:
               return (long)var1.nodeAggregate(var2) + var1.treeAggregate(TreeMultiset$AvlNode.access$600(var2));
            case 2:
               return var1.treeAggregate(TreeMultiset$AvlNode.access$600(var2));
            default:
               throw new AssertionError();
            }
         } else {
            return var1.treeAggregate(TreeMultiset$AvlNode.access$600(var2)) + (long)var1.nodeAggregate(var2) + this.aggregateBelowRange(var1, TreeMultiset$AvlNode.access$700(var2));
         }
      }
   }

   private long aggregateAboveRange(TreeMultiset$Aggregate var1, @Nullable TreeMultiset$AvlNode var2) {
      if(var2 == null) {
         return 0L;
      } else {
         int var3 = this.comparator().compare(this.range.getUpperEndpoint(), TreeMultiset$AvlNode.access$500(var2));
         if(var3 > 0) {
            return this.aggregateAboveRange(var1, TreeMultiset$AvlNode.access$700(var2));
         } else if(var3 == 0) {
            switch(TreeMultiset$4.$SwitchMap$com$google$common$collect$BoundType[this.range.getUpperBoundType().ordinal()]) {
            case 1:
               return (long)var1.nodeAggregate(var2) + var1.treeAggregate(TreeMultiset$AvlNode.access$700(var2));
            case 2:
               return var1.treeAggregate(TreeMultiset$AvlNode.access$700(var2));
            default:
               throw new AssertionError();
            }
         } else {
            return var1.treeAggregate(TreeMultiset$AvlNode.access$700(var2)) + (long)var1.nodeAggregate(var2) + this.aggregateAboveRange(var1, TreeMultiset$AvlNode.access$600(var2));
         }
      }
   }

   public int size() {
      return Ints.saturatedCast(this.aggregateForEntries(TreeMultiset$Aggregate.SIZE));
   }

   int distinctElements() {
      return Ints.saturatedCast(this.aggregateForEntries(TreeMultiset$Aggregate.DISTINCT));
   }

   public int count(@Nullable Object var1) {
      try {
         TreeMultiset$AvlNode var3 = (TreeMultiset$AvlNode)this.rootReference.get();
         return this.range.contains(var1) && var3 != null?var3.count(this.comparator(), var1):0;
      } catch (ClassCastException var4) {
         return 0;
      } catch (NullPointerException var5) {
         return 0;
      }
   }

   public int add(@Nullable Object var1, int var2) {
      CollectPreconditions.checkNonnegative(var2, "occurrences");
      if(var2 == 0) {
         return this.count(var1);
      } else {
         Preconditions.checkArgument(this.range.contains(var1));
         TreeMultiset$AvlNode var3 = (TreeMultiset$AvlNode)this.rootReference.get();
         if(var3 == null) {
            this.comparator().compare(var1, var1);
            TreeMultiset$AvlNode var6 = new TreeMultiset$AvlNode(var1, var2);
            successor(this.header, var6, this.header);
            this.rootReference.checkAndSet(var3, var6);
            return 0;
         } else {
            int[] var4 = new int[1];
            TreeMultiset$AvlNode var5 = var3.add(this.comparator(), var1, var2, var4);
            this.rootReference.checkAndSet(var3, var5);
            return var4[0];
         }
      }
   }

   public int remove(@Nullable Object var1, int var2) {
      CollectPreconditions.checkNonnegative(var2, "occurrences");
      if(var2 == 0) {
         return this.count(var1);
      } else {
         TreeMultiset$AvlNode var3 = (TreeMultiset$AvlNode)this.rootReference.get();
         int[] var4 = new int[1];

         TreeMultiset$AvlNode var5;
         try {
            if(!this.range.contains(var1) || var3 == null) {
               return 0;
            }

            var5 = var3.remove(this.comparator(), var1, var2, var4);
         } catch (ClassCastException var7) {
            return 0;
         } catch (NullPointerException var8) {
            return 0;
         }

         this.rootReference.checkAndSet(var3, var5);
         return var4[0];
      }
   }

   public int setCount(@Nullable Object var1, int var2) {
      CollectPreconditions.checkNonnegative(var2, "count");
      if(!this.range.contains(var1)) {
         Preconditions.checkArgument(var2 == 0);
         return 0;
      } else {
         TreeMultiset$AvlNode var3 = (TreeMultiset$AvlNode)this.rootReference.get();
         if(var3 == null) {
            if(var2 > 0) {
               this.add(var1, var2);
            }

            return 0;
         } else {
            int[] var4 = new int[1];
            TreeMultiset$AvlNode var5 = var3.setCount(this.comparator(), var1, var2, var4);
            this.rootReference.checkAndSet(var3, var5);
            return var4[0];
         }
      }
   }

   public boolean setCount(@Nullable Object var1, int var2, int var3) {
      CollectPreconditions.checkNonnegative(var3, "newCount");
      CollectPreconditions.checkNonnegative(var2, "oldCount");
      Preconditions.checkArgument(this.range.contains(var1));
      TreeMultiset$AvlNode var4 = (TreeMultiset$AvlNode)this.rootReference.get();
      if(var4 == null) {
         if(var2 == 0) {
            if(var3 > 0) {
               this.add(var1, var3);
            }

            return true;
         } else {
            return false;
         }
      } else {
         int[] var5 = new int[1];
         TreeMultiset$AvlNode var6 = var4.setCount(this.comparator(), var1, var2, var3, var5);
         this.rootReference.checkAndSet(var4, var6);
         return var5[0] == var2;
      }
   }

   private Multiset$Entry wrapEntry(TreeMultiset$AvlNode var1) {
      return new TreeMultiset$1(this, var1);
   }

   @Nullable
   private TreeMultiset$AvlNode firstNode() {
      TreeMultiset$AvlNode var1 = (TreeMultiset$AvlNode)this.rootReference.get();
      if(var1 == null) {
         return null;
      } else {
         TreeMultiset$AvlNode var2;
         if(this.range.hasLowerBound()) {
            Object var3 = this.range.getLowerEndpoint();
            var2 = TreeMultiset$AvlNode.access$800((TreeMultiset$AvlNode)this.rootReference.get(), this.comparator(), var3);
            if(var2 == null) {
               return null;
            }

            if(this.range.getLowerBoundType() == BoundType.OPEN && this.comparator().compare(var3, var2.getElement()) == 0) {
               var2 = TreeMultiset$AvlNode.access$900(var2);
            }
         } else {
            var2 = TreeMultiset$AvlNode.access$900(this.header);
         }

         return var2 != this.header && this.range.contains(var2.getElement())?var2:null;
      }
   }

   @Nullable
   private TreeMultiset$AvlNode lastNode() {
      TreeMultiset$AvlNode var1 = (TreeMultiset$AvlNode)this.rootReference.get();
      if(var1 == null) {
         return null;
      } else {
         TreeMultiset$AvlNode var2;
         if(this.range.hasUpperBound()) {
            Object var3 = this.range.getUpperEndpoint();
            var2 = TreeMultiset$AvlNode.access$1000((TreeMultiset$AvlNode)this.rootReference.get(), this.comparator(), var3);
            if(var2 == null) {
               return null;
            }

            if(this.range.getUpperBoundType() == BoundType.OPEN && this.comparator().compare(var3, var2.getElement()) == 0) {
               var2 = TreeMultiset$AvlNode.access$1100(var2);
            }
         } else {
            var2 = TreeMultiset$AvlNode.access$1100(this.header);
         }

         return var2 != this.header && this.range.contains(var2.getElement())?var2:null;
      }
   }

   Iterator entryIterator() {
      return new TreeMultiset$2(this);
   }

   Iterator descendingEntryIterator() {
      return new TreeMultiset$3(this);
   }

   public SortedMultiset headMultiset(@Nullable Object var1, BoundType var2) {
      return new TreeMultiset(this.rootReference, this.range.intersect(GeneralRange.upTo(this.comparator(), var1, var2)), this.header);
   }

   public SortedMultiset tailMultiset(@Nullable Object var1, BoundType var2) {
      return new TreeMultiset(this.rootReference, this.range.intersect(GeneralRange.downTo(this.comparator(), var1, var2)), this.header);
   }

   static int distinctElements(@Nullable TreeMultiset$AvlNode var0) {
      return var0 == null?0:TreeMultiset$AvlNode.access$400(var0);
   }

   private static void successor(TreeMultiset$AvlNode var0, TreeMultiset$AvlNode var1) {
      TreeMultiset$AvlNode.access$902(var0, var1);
      TreeMultiset$AvlNode.access$1102(var1, var0);
   }

   private static void successor(TreeMultiset$AvlNode var0, TreeMultiset$AvlNode var1, TreeMultiset$AvlNode var2) {
      successor(var0, var1);
      successor(var1, var2);
   }

   @GwtIncompatible("java.io.ObjectOutputStream")
   private void writeObject(ObjectOutputStream var1) {
      var1.defaultWriteObject();
      var1.writeObject(this.elementSet().comparator());
      Serialization.writeMultiset(this, var1);
   }

   @GwtIncompatible("java.io.ObjectInputStream")
   private void readObject(ObjectInputStream var1) {
      var1.defaultReadObject();
      Comparator var2 = (Comparator)var1.readObject();
      Serialization.getFieldSetter(AbstractSortedMultiset.class, "comparator").set(this, var2);
      Serialization.getFieldSetter(TreeMultiset.class, "range").set(this, GeneralRange.all(var2));
      Serialization.getFieldSetter(TreeMultiset.class, "rootReference").set(this, new TreeMultiset$Reference((TreeMultiset$1)null));
      TreeMultiset$AvlNode var3 = new TreeMultiset$AvlNode((Object)null, 1);
      Serialization.getFieldSetter(TreeMultiset.class, "header").set(this, var3);
      successor(var3, var3);
      Serialization.populateMultiset(this, var1);
   }

   // $FF: synthetic method
   static TreeMultiset$AvlNode access$1200(TreeMultiset var0) {
      return var0.firstNode();
   }

   // $FF: synthetic method
   static GeneralRange access$1300(TreeMultiset var0) {
      return var0.range;
   }

   // $FF: synthetic method
   static Multiset$Entry access$1400(TreeMultiset var0, TreeMultiset$AvlNode var1) {
      return var0.wrapEntry(var1);
   }

   // $FF: synthetic method
   static TreeMultiset$AvlNode access$1500(TreeMultiset var0) {
      return var0.header;
   }

   // $FF: synthetic method
   static TreeMultiset$AvlNode access$1600(TreeMultiset var0) {
      return var0.lastNode();
   }

   // $FF: synthetic method
   static void access$1700(TreeMultiset$AvlNode var0, TreeMultiset$AvlNode var1, TreeMultiset$AvlNode var2) {
      successor(var0, var1, var2);
   }

   // $FF: synthetic method
   static void access$1800(TreeMultiset$AvlNode var0, TreeMultiset$AvlNode var1) {
      successor(var0, var1);
   }
}
