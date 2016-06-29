package com.google.common.collect;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multisets;
import com.google.common.collect.Multisets$AbstractEntry;
import com.google.common.collect.TreeMultiset;
import java.util.Comparator;
import javax.annotation.Nullable;

final class TreeMultiset$AvlNode extends Multisets$AbstractEntry {
   @Nullable
   private final Object elem;
   private int elemCount;
   private int distinctElements;
   private long totalCount;
   private int height;
   private TreeMultiset$AvlNode left;
   private TreeMultiset$AvlNode right;
   private TreeMultiset$AvlNode pred;
   private TreeMultiset$AvlNode succ;

   TreeMultiset$AvlNode(@Nullable Object var1, int var2) {
      Preconditions.checkArgument(var2 > 0);
      this.elem = var1;
      this.elemCount = var2;
      this.totalCount = (long)var2;
      this.distinctElements = 1;
      this.height = 1;
      this.left = null;
      this.right = null;
   }

   public int count(Comparator var1, Object var2) {
      int var3 = var1.compare(var2, this.elem);
      return var3 < 0?(this.left == null?0:this.left.count(var1, var2)):(var3 > 0?(this.right == null?0:this.right.count(var1, var2)):this.elemCount);
   }

   private TreeMultiset$AvlNode addRightChild(Object var1, int var2) {
      this.right = new TreeMultiset$AvlNode(var1, var2);
      TreeMultiset.access$1700(this, this.right, this.succ);
      this.height = Math.max(2, this.height);
      ++this.distinctElements;
      this.totalCount += (long)var2;
      return this;
   }

   private TreeMultiset$AvlNode addLeftChild(Object var1, int var2) {
      this.left = new TreeMultiset$AvlNode(var1, var2);
      TreeMultiset.access$1700(this.pred, this.left, this);
      this.height = Math.max(2, this.height);
      ++this.distinctElements;
      this.totalCount += (long)var2;
      return this;
   }

   TreeMultiset$AvlNode add(Comparator var1, @Nullable Object var2, int var3, int[] var4) {
      int var5 = var1.compare(var2, this.elem);
      int var7;
      TreeMultiset$AvlNode var8;
      if(var5 < 0) {
         var8 = this.left;
         if(var8 == null) {
            var4[0] = 0;
            return this.addLeftChild(var2, var3);
         } else {
            var7 = var8.height;
            this.left = var8.add(var1, var2, var3, var4);
            if(var4[0] == 0) {
               ++this.distinctElements;
            }

            this.totalCount += (long)var3;
            return this.left.height == var7?this:this.rebalance();
         }
      } else if(var5 > 0) {
         var8 = this.right;
         if(var8 == null) {
            var4[0] = 0;
            return this.addRightChild(var2, var3);
         } else {
            var7 = var8.height;
            this.right = var8.add(var1, var2, var3, var4);
            if(var4[0] == 0) {
               ++this.distinctElements;
            }

            this.totalCount += (long)var3;
            return this.right.height == var7?this:this.rebalance();
         }
      } else {
         var4[0] = this.elemCount;
         long var6 = (long)this.elemCount + (long)var3;
         Preconditions.checkArgument(var6 <= 2147483647L);
         this.elemCount += var3;
         this.totalCount += (long)var3;
         return this;
      }
   }

   TreeMultiset$AvlNode remove(Comparator var1, @Nullable Object var2, int var3, int[] var4) {
      int var5 = var1.compare(var2, this.elem);
      TreeMultiset$AvlNode var6;
      if(var5 < 0) {
         var6 = this.left;
         if(var6 == null) {
            var4[0] = 0;
            return this;
         } else {
            this.left = var6.remove(var1, var2, var3, var4);
            if(var4[0] > 0) {
               if(var3 >= var4[0]) {
                  --this.distinctElements;
                  this.totalCount -= (long)var4[0];
               } else {
                  this.totalCount -= (long)var3;
               }
            }

            return var4[0] == 0?this:this.rebalance();
         }
      } else if(var5 > 0) {
         var6 = this.right;
         if(var6 == null) {
            var4[0] = 0;
            return this;
         } else {
            this.right = var6.remove(var1, var2, var3, var4);
            if(var4[0] > 0) {
               if(var3 >= var4[0]) {
                  --this.distinctElements;
                  this.totalCount -= (long)var4[0];
               } else {
                  this.totalCount -= (long)var3;
               }
            }

            return this.rebalance();
         }
      } else {
         var4[0] = this.elemCount;
         if(var3 >= this.elemCount) {
            return this.deleteMe();
         } else {
            this.elemCount -= var3;
            this.totalCount -= (long)var3;
            return this;
         }
      }
   }

   TreeMultiset$AvlNode setCount(Comparator var1, @Nullable Object var2, int var3, int[] var4) {
      int var5 = var1.compare(var2, this.elem);
      TreeMultiset$AvlNode var6;
      if(var5 < 0) {
         var6 = this.left;
         if(var6 == null) {
            var4[0] = 0;
            return var3 > 0?this.addLeftChild(var2, var3):this;
         } else {
            this.left = var6.setCount(var1, var2, var3, var4);
            if(var3 == 0 && var4[0] != 0) {
               --this.distinctElements;
            } else if(var3 > 0 && var4[0] == 0) {
               ++this.distinctElements;
            }

            this.totalCount += (long)(var3 - var4[0]);
            return this.rebalance();
         }
      } else if(var5 > 0) {
         var6 = this.right;
         if(var6 == null) {
            var4[0] = 0;
            return var3 > 0?this.addRightChild(var2, var3):this;
         } else {
            this.right = var6.setCount(var1, var2, var3, var4);
            if(var3 == 0 && var4[0] != 0) {
               --this.distinctElements;
            } else if(var3 > 0 && var4[0] == 0) {
               ++this.distinctElements;
            }

            this.totalCount += (long)(var3 - var4[0]);
            return this.rebalance();
         }
      } else {
         var4[0] = this.elemCount;
         if(var3 == 0) {
            return this.deleteMe();
         } else {
            this.totalCount += (long)(var3 - this.elemCount);
            this.elemCount = var3;
            return this;
         }
      }
   }

   TreeMultiset$AvlNode setCount(Comparator var1, @Nullable Object var2, int var3, int var4, int[] var5) {
      int var6 = var1.compare(var2, this.elem);
      TreeMultiset$AvlNode var7;
      if(var6 < 0) {
         var7 = this.left;
         if(var7 == null) {
            var5[0] = 0;
            return var3 == 0 && var4 > 0?this.addLeftChild(var2, var4):this;
         } else {
            this.left = var7.setCount(var1, var2, var3, var4, var5);
            if(var5[0] == var3) {
               if(var4 == 0 && var5[0] != 0) {
                  --this.distinctElements;
               } else if(var4 > 0 && var5[0] == 0) {
                  ++this.distinctElements;
               }

               this.totalCount += (long)(var4 - var5[0]);
            }

            return this.rebalance();
         }
      } else if(var6 > 0) {
         var7 = this.right;
         if(var7 == null) {
            var5[0] = 0;
            return var3 == 0 && var4 > 0?this.addRightChild(var2, var4):this;
         } else {
            this.right = var7.setCount(var1, var2, var3, var4, var5);
            if(var5[0] == var3) {
               if(var4 == 0 && var5[0] != 0) {
                  --this.distinctElements;
               } else if(var4 > 0 && var5[0] == 0) {
                  ++this.distinctElements;
               }

               this.totalCount += (long)(var4 - var5[0]);
            }

            return this.rebalance();
         }
      } else {
         var5[0] = this.elemCount;
         if(var3 == this.elemCount) {
            if(var4 == 0) {
               return this.deleteMe();
            }

            this.totalCount += (long)(var4 - this.elemCount);
            this.elemCount = var4;
         }

         return this;
      }
   }

   private TreeMultiset$AvlNode deleteMe() {
      int var1 = this.elemCount;
      this.elemCount = 0;
      TreeMultiset.access$1800(this.pred, this.succ);
      if(this.left == null) {
         return this.right;
      } else if(this.right == null) {
         return this.left;
      } else {
         TreeMultiset$AvlNode var2;
         if(this.left.height >= this.right.height) {
            var2 = this.pred;
            var2.left = this.left.removeMax(var2);
            var2.right = this.right;
            var2.distinctElements = this.distinctElements - 1;
            var2.totalCount = this.totalCount - (long)var1;
            return var2.rebalance();
         } else {
            var2 = this.succ;
            var2.right = this.right.removeMin(var2);
            var2.left = this.left;
            var2.distinctElements = this.distinctElements - 1;
            var2.totalCount = this.totalCount - (long)var1;
            return var2.rebalance();
         }
      }
   }

   private TreeMultiset$AvlNode removeMin(TreeMultiset$AvlNode var1) {
      if(this.left == null) {
         return this.right;
      } else {
         this.left = this.left.removeMin(var1);
         --this.distinctElements;
         this.totalCount -= (long)var1.elemCount;
         return this.rebalance();
      }
   }

   private TreeMultiset$AvlNode removeMax(TreeMultiset$AvlNode var1) {
      if(this.right == null) {
         return this.left;
      } else {
         this.right = this.right.removeMax(var1);
         --this.distinctElements;
         this.totalCount -= (long)var1.elemCount;
         return this.rebalance();
      }
   }

   private void recomputeMultiset() {
      this.distinctElements = 1 + TreeMultiset.distinctElements(this.left) + TreeMultiset.distinctElements(this.right);
      this.totalCount = (long)this.elemCount + totalCount(this.left) + totalCount(this.right);
   }

   private void recomputeHeight() {
      this.height = 1 + Math.max(height(this.left), height(this.right));
   }

   private void recompute() {
      this.recomputeMultiset();
      this.recomputeHeight();
   }

   private TreeMultiset$AvlNode rebalance() {
      switch(this.balanceFactor()) {
      case -2:
         if(this.right.balanceFactor() > 0) {
            this.right = this.right.rotateRight();
         }

         return this.rotateLeft();
      case 2:
         if(this.left.balanceFactor() < 0) {
            this.left = this.left.rotateLeft();
         }

         return this.rotateRight();
      default:
         this.recomputeHeight();
         return this;
      }
   }

   private int balanceFactor() {
      return height(this.left) - height(this.right);
   }

   private TreeMultiset$AvlNode rotateLeft() {
      Preconditions.checkState(this.right != null);
      TreeMultiset$AvlNode var1 = this.right;
      this.right = var1.left;
      var1.left = this;
      var1.totalCount = this.totalCount;
      var1.distinctElements = this.distinctElements;
      this.recompute();
      var1.recomputeHeight();
      return var1;
   }

   private TreeMultiset$AvlNode rotateRight() {
      Preconditions.checkState(this.left != null);
      TreeMultiset$AvlNode var1 = this.left;
      this.left = var1.right;
      var1.right = this;
      var1.totalCount = this.totalCount;
      var1.distinctElements = this.distinctElements;
      this.recompute();
      var1.recomputeHeight();
      return var1;
   }

   private static long totalCount(@Nullable TreeMultiset$AvlNode var0) {
      return var0 == null?0L:var0.totalCount;
   }

   private static int height(@Nullable TreeMultiset$AvlNode var0) {
      return var0 == null?0:var0.height;
   }

   @Nullable
   private TreeMultiset$AvlNode ceiling(Comparator var1, Object var2) {
      int var3 = var1.compare(var2, this.elem);
      return var3 < 0?(this.left == null?this:(TreeMultiset$AvlNode)MoreObjects.firstNonNull(this.left.ceiling(var1, var2), this)):(var3 == 0?this:(this.right == null?null:this.right.ceiling(var1, var2)));
   }

   @Nullable
   private TreeMultiset$AvlNode floor(Comparator var1, Object var2) {
      int var3 = var1.compare(var2, this.elem);
      return var3 > 0?(this.right == null?this:(TreeMultiset$AvlNode)MoreObjects.firstNonNull(this.right.floor(var1, var2), this)):(var3 == 0?this:(this.left == null?null:this.left.floor(var1, var2)));
   }

   public Object getElement() {
      return this.elem;
   }

   public int getCount() {
      return this.elemCount;
   }

   public String toString() {
      return Multisets.immutableEntry(this.getElement(), this.getCount()).toString();
   }

   // $FF: synthetic method
   static int access$200(TreeMultiset$AvlNode var0) {
      return var0.elemCount;
   }

   // $FF: synthetic method
   static long access$300(TreeMultiset$AvlNode var0) {
      return var0.totalCount;
   }

   // $FF: synthetic method
   static int access$400(TreeMultiset$AvlNode var0) {
      return var0.distinctElements;
   }

   // $FF: synthetic method
   static Object access$500(TreeMultiset$AvlNode var0) {
      return var0.elem;
   }

   // $FF: synthetic method
   static TreeMultiset$AvlNode access$600(TreeMultiset$AvlNode var0) {
      return var0.left;
   }

   // $FF: synthetic method
   static TreeMultiset$AvlNode access$700(TreeMultiset$AvlNode var0) {
      return var0.right;
   }

   // $FF: synthetic method
   static TreeMultiset$AvlNode access$800(TreeMultiset$AvlNode var0, Comparator var1, Object var2) {
      return var0.ceiling(var1, var2);
   }

   // $FF: synthetic method
   static TreeMultiset$AvlNode access$900(TreeMultiset$AvlNode var0) {
      return var0.succ;
   }

   // $FF: synthetic method
   static TreeMultiset$AvlNode access$1000(TreeMultiset$AvlNode var0, Comparator var1, Object var2) {
      return var0.floor(var1, var2);
   }

   // $FF: synthetic method
   static TreeMultiset$AvlNode access$1100(TreeMultiset$AvlNode var0) {
      return var0.pred;
   }

   // $FF: synthetic method
   static TreeMultiset$AvlNode access$902(TreeMultiset$AvlNode var0, TreeMultiset$AvlNode var1) {
      return var0.succ = var1;
   }

   // $FF: synthetic method
   static TreeMultiset$AvlNode access$1102(TreeMultiset$AvlNode var0, TreeMultiset$AvlNode var1) {
      return var0.pred = var1;
   }
}
