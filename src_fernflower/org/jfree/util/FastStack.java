package org.jfree.util;

import java.io.Serializable;
import java.util.Arrays;
import java.util.EmptyStackException;

public final class FastStack implements Serializable, Cloneable {
   private Object[] contents;
   private int size;
   private int initialSize;

   public FastStack() {
      this.initialSize = 10;
   }

   public FastStack(int var1) {
      this.initialSize = Math.max(1, var1);
   }

   public boolean isEmpty() {
      return this.size == 0;
   }

   public int size() {
      return this.size;
   }

   public void push(Object var1) {
      if(this.contents == null) {
         this.contents = new Object[this.initialSize];
         this.contents[0] = var1;
         this.size = 1;
      } else {
         int var2 = this.size++;
         if(this.contents.length == this.size) {
            Object[] var3 = new Object[this.size + this.initialSize];
            System.arraycopy(this.contents, 0, var3, 0, this.size);
            this.contents = var3;
         }

         this.contents[var2] = var1;
      }
   }

   public Object peek() {
      if(this.size == 0) {
         throw new EmptyStackException();
      } else {
         return this.contents[this.size - 1];
      }
   }

   public Object pop() {
      if(this.size == 0) {
         throw new EmptyStackException();
      } else {
         --this.size;
         Object var1 = this.contents[this.size];
         this.contents[this.size] = null;
         return var1;
      }
   }

   public Object clone() {
      try {
         FastStack var1 = (FastStack)super.clone();
         if(this.contents != null) {
            var1.contents = (Object[])((Object[])this.contents.clone());
         }

         return var1;
      } catch (CloneNotSupportedException var2) {
         throw new IllegalStateException("Clone not supported? Why?");
      }
   }

   public void clear() {
      this.size = 0;
      if(this.contents != null) {
         Arrays.fill(this.contents, (Object)null);
      }

   }

   public Object get(int var1) {
      if(var1 >= this.size) {
         throw new IndexOutOfBoundsException();
      } else {
         return this.contents[var1];
      }
   }
}
