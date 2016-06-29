package org.jfree.threads;

import java.util.ArrayList;
import java.util.Iterator;
import org.jfree.threads.ReaderWriterLock$1;
import org.jfree.threads.ReaderWriterLock$ReaderWriterNode;

public class ReaderWriterLock {
   private ArrayList waiters = new ArrayList();

   public synchronized void lockRead() {
      Thread var2 = Thread.currentThread();
      int var3 = this.getIndex(var2);
      ReaderWriterLock$ReaderWriterNode var1;
      if(var3 == -1) {
         var1 = new ReaderWriterLock$ReaderWriterNode(var2, 0, (ReaderWriterLock$1)null);
         this.waiters.add(var1);
      } else {
         var1 = (ReaderWriterLock$ReaderWriterNode)this.waiters.get(var3);
      }

      while(this.getIndex(var2) > this.firstWriter()) {
         try {
            this.wait();
         } catch (Exception var5) {
            System.err.println("ReaderWriterLock.lockRead(): exception.");
            System.err.print(var5.getMessage());
         }
      }

      ++var1.nAcquires;
   }

   public synchronized void lockWrite() {
      Thread var2 = Thread.currentThread();
      int var3 = this.getIndex(var2);
      ReaderWriterLock$ReaderWriterNode var1;
      if(var3 == -1) {
         var1 = new ReaderWriterLock$ReaderWriterNode(var2, 1, (ReaderWriterLock$1)null);
         this.waiters.add(var1);
      } else {
         var1 = (ReaderWriterLock$ReaderWriterNode)this.waiters.get(var3);
         if(var1.state == 0) {
            throw new IllegalArgumentException("Upgrade lock");
         }

         var1.state = 1;
      }

      while(this.getIndex(var2) != 0) {
         try {
            this.wait();
         } catch (Exception var5) {
            System.err.println("ReaderWriterLock.lockWrite(): exception.");
            System.err.print(var5.getMessage());
         }
      }

      ++var1.nAcquires;
   }

   public synchronized void unlock() {
      Thread var2 = Thread.currentThread();
      int var3 = this.getIndex(var2);
      if(var3 > this.firstWriter()) {
         throw new IllegalArgumentException("Lock not held");
      } else {
         ReaderWriterLock$ReaderWriterNode var1 = (ReaderWriterLock$ReaderWriterNode)this.waiters.get(var3);
         --var1.nAcquires;
         if(var1.nAcquires == 0) {
            this.waiters.remove(var3);
         }

         this.notifyAll();
      }
   }

   private int firstWriter() {
      Iterator var1 = this.waiters.iterator();

      for(int var2 = 0; var1.hasNext(); ++var2) {
         ReaderWriterLock$ReaderWriterNode var3 = (ReaderWriterLock$ReaderWriterNode)var1.next();
         if(var3.state == 1) {
            return var2;
         }
      }

      return Integer.MAX_VALUE;
   }

   private int getIndex(Thread var1) {
      Iterator var2 = this.waiters.iterator();

      for(int var3 = 0; var2.hasNext(); ++var3) {
         ReaderWriterLock$ReaderWriterNode var4 = (ReaderWriterLock$ReaderWriterNode)var2.next();
         if(var4.t == var1) {
            return var3;
         }
      }

      return -1;
   }
}
