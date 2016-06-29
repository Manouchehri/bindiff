package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.MinMaxPriorityQueue$1;
import com.google.common.collect.MinMaxPriorityQueue$Builder;
import com.google.common.collect.MinMaxPriorityQueue$Heap;
import com.google.common.collect.MinMaxPriorityQueue$MoveDesc;
import com.google.common.collect.MinMaxPriorityQueue$QueueIterator;
import com.google.common.collect.Ordering;
import com.google.common.math.IntMath;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

@Beta
public final class MinMaxPriorityQueue extends AbstractQueue {
   private final MinMaxPriorityQueue$Heap minHeap;
   private final MinMaxPriorityQueue$Heap maxHeap;
   @VisibleForTesting
   final int maximumSize;
   private Object[] queue;
   private int size;
   private int modCount;
   private static final int EVEN_POWERS_OF_TWO = 1431655765;
   private static final int ODD_POWERS_OF_TWO = -1431655766;
   private static final int DEFAULT_CAPACITY = 11;

   public static MinMaxPriorityQueue create() {
      return (new MinMaxPriorityQueue$Builder(Ordering.natural(), (MinMaxPriorityQueue$1)null)).create();
   }

   public static MinMaxPriorityQueue create(Iterable var0) {
      return (new MinMaxPriorityQueue$Builder(Ordering.natural(), (MinMaxPriorityQueue$1)null)).create(var0);
   }

   public static MinMaxPriorityQueue$Builder orderedBy(Comparator var0) {
      return new MinMaxPriorityQueue$Builder(var0, (MinMaxPriorityQueue$1)null);
   }

   public static MinMaxPriorityQueue$Builder expectedSize(int var0) {
      return (new MinMaxPriorityQueue$Builder(Ordering.natural(), (MinMaxPriorityQueue$1)null)).expectedSize(var0);
   }

   public static MinMaxPriorityQueue$Builder maximumSize(int var0) {
      return (new MinMaxPriorityQueue$Builder(Ordering.natural(), (MinMaxPriorityQueue$1)null)).maximumSize(var0);
   }

   private MinMaxPriorityQueue(MinMaxPriorityQueue$Builder var1, int var2) {
      Ordering var3 = MinMaxPriorityQueue$Builder.access$200(var1);
      this.minHeap = new MinMaxPriorityQueue$Heap(this, var3);
      this.maxHeap = new MinMaxPriorityQueue$Heap(this, var3.reverse());
      this.minHeap.otherHeap = this.maxHeap;
      this.maxHeap.otherHeap = this.minHeap;
      this.maximumSize = MinMaxPriorityQueue$Builder.access$300(var1);
      this.queue = new Object[var2];
   }

   public int size() {
      return this.size;
   }

   public boolean add(Object var1) {
      this.offer(var1);
      return true;
   }

   public boolean addAll(Collection var1) {
      boolean var2 = false;

      for(Iterator var3 = var1.iterator(); var3.hasNext(); var2 = true) {
         Object var4 = var3.next();
         this.offer(var4);
      }

      return var2;
   }

   public boolean offer(Object var1) {
      Preconditions.checkNotNull(var1);
      ++this.modCount;
      int var2 = this.size++;
      this.growIfNeeded();
      this.heapForIndex(var2).bubbleUp(var2, var1);
      return this.size <= this.maximumSize || this.pollLast() != var1;
   }

   public Object poll() {
      return this.isEmpty()?null:this.removeAndGet(0);
   }

   Object elementData(int var1) {
      return this.queue[var1];
   }

   public Object peek() {
      return this.isEmpty()?null:this.elementData(0);
   }

   private int getMaxElementIndex() {
      switch(this.size) {
      case 1:
         return 0;
      case 2:
         return 1;
      default:
         return this.maxHeap.compareElements(1, 2) <= 0?1:2;
      }
   }

   public Object pollFirst() {
      return this.poll();
   }

   public Object removeFirst() {
      return this.remove();
   }

   public Object peekFirst() {
      return this.peek();
   }

   public Object pollLast() {
      return this.isEmpty()?null:this.removeAndGet(this.getMaxElementIndex());
   }

   public Object removeLast() {
      if(this.isEmpty()) {
         throw new NoSuchElementException();
      } else {
         return this.removeAndGet(this.getMaxElementIndex());
      }
   }

   public Object peekLast() {
      return this.isEmpty()?null:this.elementData(this.getMaxElementIndex());
   }

   @VisibleForTesting
   MinMaxPriorityQueue$MoveDesc removeAt(int var1) {
      Preconditions.checkPositionIndex(var1, this.size);
      ++this.modCount;
      --this.size;
      if(this.size == var1) {
         this.queue[this.size] = null;
         return null;
      } else {
         Object var2 = this.elementData(this.size);
         int var3 = this.heapForIndex(this.size).getCorrectLastElement(var2);
         Object var4 = this.elementData(this.size);
         this.queue[this.size] = null;
         MinMaxPriorityQueue$MoveDesc var5 = this.fillHole(var1, var4);
         return var3 < var1?(var5 == null?new MinMaxPriorityQueue$MoveDesc(var2, var4):new MinMaxPriorityQueue$MoveDesc(var2, var5.replaced)):var5;
      }
   }

   private MinMaxPriorityQueue$MoveDesc fillHole(int var1, Object var2) {
      MinMaxPriorityQueue$Heap var3 = this.heapForIndex(var1);
      int var4 = var3.fillHoleAt(var1);
      int var5 = var3.bubbleUpAlternatingLevels(var4, var2);
      return var5 == var4?var3.tryCrossOverAndBubbleUp(var1, var4, var2):(var5 < var1?new MinMaxPriorityQueue$MoveDesc(var2, this.elementData(var1)):null);
   }

   private Object removeAndGet(int var1) {
      Object var2 = this.elementData(var1);
      this.removeAt(var1);
      return var2;
   }

   private MinMaxPriorityQueue$Heap heapForIndex(int var1) {
      return isEvenLevel(var1)?this.minHeap:this.maxHeap;
   }

   @VisibleForTesting
   static boolean isEvenLevel(int var0) {
      int var1 = var0 + 1;
      Preconditions.checkState(var1 > 0, "negative index");
      return (var1 & 1431655765) > (var1 & -1431655766);
   }

   @VisibleForTesting
   boolean isIntact() {
      for(int var1 = 1; var1 < this.size; ++var1) {
         if(!MinMaxPriorityQueue$Heap.access$400(this.heapForIndex(var1), var1)) {
            return false;
         }
      }

      return true;
   }

   public Iterator iterator() {
      return new MinMaxPriorityQueue$QueueIterator(this, (MinMaxPriorityQueue$1)null);
   }

   public void clear() {
      for(int var1 = 0; var1 < this.size; ++var1) {
         this.queue[var1] = null;
      }

      this.size = 0;
   }

   public Object[] toArray() {
      Object[] var1 = new Object[this.size];
      System.arraycopy(this.queue, 0, var1, 0, this.size);
      return var1;
   }

   public Comparator comparator() {
      return this.minHeap.ordering;
   }

   @VisibleForTesting
   int capacity() {
      return this.queue.length;
   }

   @VisibleForTesting
   static int initialQueueSize(int var0, int var1, Iterable var2) {
      int var3 = var0 == -1?11:var0;
      if(var2 instanceof Collection) {
         int var4 = ((Collection)var2).size();
         var3 = Math.max(var3, var4);
      }

      return capAtMaximumSize(var3, var1);
   }

   private void growIfNeeded() {
      if(this.size > this.queue.length) {
         int var1 = this.calculateNewCapacity();
         Object[] var2 = new Object[var1];
         System.arraycopy(this.queue, 0, var2, 0, this.queue.length);
         this.queue = var2;
      }

   }

   private int calculateNewCapacity() {
      int var1 = this.queue.length;
      int var2 = var1 < 64?(var1 + 1) * 2:IntMath.checkedMultiply(var1 / 2, 3);
      return capAtMaximumSize(var2, this.maximumSize);
   }

   private static int capAtMaximumSize(int var0, int var1) {
      return Math.min(var0 - 1, var1) + 1;
   }

   // $FF: synthetic method
   MinMaxPriorityQueue(MinMaxPriorityQueue$Builder var1, int var2, MinMaxPriorityQueue$1 var3) {
      this(var1, var2);
   }

   // $FF: synthetic method
   static Object[] access$500(MinMaxPriorityQueue var0) {
      return var0.queue;
   }

   // $FF: synthetic method
   static int access$600(MinMaxPriorityQueue var0) {
      return var0.size;
   }

   // $FF: synthetic method
   static int access$700(MinMaxPriorityQueue var0) {
      return var0.modCount;
   }
}
