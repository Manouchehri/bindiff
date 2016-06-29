package org.jfree.threads;

import org.jfree.threads.ReaderWriterLock$1;

class ReaderWriterLock$ReaderWriterNode {
   protected static final int READER = 0;
   protected static final int WRITER = 1;
   protected Thread t;
   protected int state;
   protected int nAcquires;

   private ReaderWriterLock$ReaderWriterNode(Thread var1, int var2) {
      this.t = var1;
      this.state = var2;
      this.nAcquires = 0;
   }

   ReaderWriterLock$ReaderWriterNode(Thread var1, int var2, ReaderWriterLock$1 var3) {
      this(var1, var2);
   }
}
