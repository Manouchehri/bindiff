package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.MinMaxPriorityQueue;
import com.google.common.collect.MinMaxPriorityQueue$MoveDesc;
import com.google.common.collect.Ordering;
import com.google.j2objc.annotations.Weak;

class MinMaxPriorityQueue$Heap {
   final Ordering ordering;
   @Weak
   MinMaxPriorityQueue$Heap otherHeap;
   // $FF: synthetic field
   final MinMaxPriorityQueue this$0;

   MinMaxPriorityQueue$Heap(MinMaxPriorityQueue var1, Ordering var2) {
      this.this$0 = var1;
      this.ordering = var2;
   }

   int compareElements(int var1, int var2) {
      return this.ordering.compare(this.this$0.elementData(var1), this.this$0.elementData(var2));
   }

   MinMaxPriorityQueue$MoveDesc tryCrossOverAndBubbleUp(int var1, int var2, Object var3) {
      int var4 = this.crossOver(var2, var3);
      if(var4 == var2) {
         return null;
      } else {
         Object var5;
         if(var4 < var1) {
            var5 = this.this$0.elementData(var1);
         } else {
            var5 = this.this$0.elementData(this.getParentIndex(var1));
         }

         return this.otherHeap.bubbleUpAlternatingLevels(var4, var3) < var1?new MinMaxPriorityQueue$MoveDesc(var3, var5):null;
      }
   }

   void bubbleUp(int var1, Object var2) {
      int var3 = this.crossOverUp(var1, var2);
      MinMaxPriorityQueue$Heap var4;
      if(var3 == var1) {
         var4 = this;
      } else {
         var1 = var3;
         var4 = this.otherHeap;
      }

      var4.bubbleUpAlternatingLevels(var1, var2);
   }

   int bubbleUpAlternatingLevels(int var1, Object var2) {
      while(true) {
         if(var1 > 2) {
            int var3 = this.getGrandparentIndex(var1);
            Object var4 = this.this$0.elementData(var3);
            if(this.ordering.compare(var4, var2) > 0) {
               MinMaxPriorityQueue.access$500(this.this$0)[var1] = var4;
               var1 = var3;
               continue;
            }
         }

         MinMaxPriorityQueue.access$500(this.this$0)[var1] = var2;
         return var1;
      }
   }

   int findMin(int var1, int var2) {
      if(var1 >= MinMaxPriorityQueue.access$600(this.this$0)) {
         return -1;
      } else {
         Preconditions.checkState(var1 > 0);
         int var3 = Math.min(var1, MinMaxPriorityQueue.access$600(this.this$0) - var2) + var2;
         int var4 = var1;

         for(int var5 = var1 + 1; var5 < var3; ++var5) {
            if(this.compareElements(var5, var4) < 0) {
               var4 = var5;
            }
         }

         return var4;
      }
   }

   int findMinChild(int var1) {
      return this.findMin(this.getLeftChildIndex(var1), 2);
   }

   int findMinGrandChild(int var1) {
      int var2 = this.getLeftChildIndex(var1);
      return var2 < 0?-1:this.findMin(this.getLeftChildIndex(var2), 4);
   }

   int crossOverUp(int var1, Object var2) {
      if(var1 == 0) {
         MinMaxPriorityQueue.access$500(this.this$0)[0] = var2;
         return 0;
      } else {
         int var3 = this.getParentIndex(var1);
         Object var4 = this.this$0.elementData(var3);
         if(var3 != 0) {
            int var5 = this.getParentIndex(var3);
            int var6 = this.getRightChildIndex(var5);
            if(var6 != var3 && this.getLeftChildIndex(var6) >= MinMaxPriorityQueue.access$600(this.this$0)) {
               Object var7 = this.this$0.elementData(var6);
               if(this.ordering.compare(var7, var4) < 0) {
                  var3 = var6;
                  var4 = var7;
               }
            }
         }

         if(this.ordering.compare(var4, var2) < 0) {
            MinMaxPriorityQueue.access$500(this.this$0)[var1] = var4;
            MinMaxPriorityQueue.access$500(this.this$0)[var3] = var2;
            return var3;
         } else {
            MinMaxPriorityQueue.access$500(this.this$0)[var1] = var2;
            return var1;
         }
      }
   }

   int getCorrectLastElement(Object var1) {
      int var2 = this.getParentIndex(MinMaxPriorityQueue.access$600(this.this$0));
      if(var2 != 0) {
         int var3 = this.getParentIndex(var2);
         int var4 = this.getRightChildIndex(var3);
         if(var4 != var2 && this.getLeftChildIndex(var4) >= MinMaxPriorityQueue.access$600(this.this$0)) {
            Object var5 = this.this$0.elementData(var4);
            if(this.ordering.compare(var5, var1) < 0) {
               MinMaxPriorityQueue.access$500(this.this$0)[var4] = var1;
               MinMaxPriorityQueue.access$500(this.this$0)[MinMaxPriorityQueue.access$600(this.this$0)] = var5;
               return var4;
            }
         }
      }

      return MinMaxPriorityQueue.access$600(this.this$0);
   }

   int crossOver(int var1, Object var2) {
      int var3 = this.findMinChild(var1);
      if(var3 > 0 && this.ordering.compare(this.this$0.elementData(var3), var2) < 0) {
         MinMaxPriorityQueue.access$500(this.this$0)[var1] = this.this$0.elementData(var3);
         MinMaxPriorityQueue.access$500(this.this$0)[var3] = var2;
         return var3;
      } else {
         return this.crossOverUp(var1, var2);
      }
   }

   int fillHoleAt(int var1) {
      int var2;
      while((var2 = this.findMinGrandChild(var1)) > 0) {
         MinMaxPriorityQueue.access$500(this.this$0)[var1] = this.this$0.elementData(var2);
         var1 = var2;
      }

      return var1;
   }

   private boolean verifyIndex(int var1) {
      return this.getLeftChildIndex(var1) < MinMaxPriorityQueue.access$600(this.this$0) && this.compareElements(var1, this.getLeftChildIndex(var1)) > 0?false:(this.getRightChildIndex(var1) < MinMaxPriorityQueue.access$600(this.this$0) && this.compareElements(var1, this.getRightChildIndex(var1)) > 0?false:(var1 > 0 && this.compareElements(var1, this.getParentIndex(var1)) > 0?false:var1 <= 2 || this.compareElements(this.getGrandparentIndex(var1), var1) <= 0));
   }

   private int getLeftChildIndex(int var1) {
      return var1 * 2 + 1;
   }

   private int getRightChildIndex(int var1) {
      return var1 * 2 + 2;
   }

   private int getParentIndex(int var1) {
      return (var1 - 1) / 2;
   }

   private int getGrandparentIndex(int var1) {
      return this.getParentIndex(this.getParentIndex(var1));
   }

   // $FF: synthetic method
   static boolean access$400(MinMaxPriorityQueue$Heap var0, int var1) {
      return var0.verifyIndex(var1);
   }
}
