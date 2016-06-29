package com.google.security.zynamics.zylib.general.memmanager;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.general.memmanager.IMemoryListener;
import com.google.security.zynamics.zylib.general.memmanager.MemoryChunk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Memory {
   private final LinkedList m_chunks = new LinkedList();
   private final ArrayList m_listeners = new ArrayList();
   private final ReadWriteLock m_readWriteLock = new ReentrantReadWriteLock();
   private final Lock m_readLock;
   private final Lock m_writeLock;

   public Memory() {
      this.m_readLock = this.m_readWriteLock.readLock();
      this.m_writeLock = this.m_readWriteLock.writeLock();
   }

   private byte[] concat(byte[] var1, byte[] var2) {
      byte[] var3 = new byte[var1.length + var2.length];
      System.arraycopy(var1, 0, var3, 0, var1.length);
      System.arraycopy(var2, 0, var3, var1.length, var2.length);
      return var3;
   }

   private MemoryChunk connectChunks(MemoryChunk var1, MemoryChunk var2) {
      Preconditions.checkNotNull(var1, "Error: First memory chunk can\'t be null");
      Preconditions.checkNotNull(var2, "Error: Second memory chunk can\'t be null");
      Preconditions.checkArgument(var2.getAddress() > var1.getAddress(), "Error: Second memory chunk must start after the first memory chunk");
      long var3 = var1.getAddress();
      MemoryChunk var5;
      if(var1.getAddress() + (long)var1.getLength() == var2.getAddress()) {
         byte[] var6 = this.concat(var1.getBytes(), var2.getBytes());
         var5 = new MemoryChunk(var3, var6);
      } else {
         int var8 = (int)(var2.getAddress() - var1.getAddress()) - var1.getLength();
         byte[] var7 = new byte[var1.getLength() + var8 + var2.getLength()];
         if(var8 > 0) {
            return null;
         }

         if(var8 < 0) {
            System.arraycopy(var1.getBytes(), 0, var7, 0, var1.getLength());
            System.arraycopy(var2.getBytes(), -var8, var7, var1.getLength(), var2.getLength() + var8);
         }

         var5 = new MemoryChunk(var3, var7);
      }

      this.removeChunk(var1);
      this.removeChunk(var2);
      this.insertChunk(var5);
      return var5;
   }

   private MemoryChunk findChunk(long var1) {
      Preconditions.checkArgument(var1 >= 0L, "Error: Address can\'t be less than 0");
      Iterator var3 = this.m_chunks.iterator();

      MemoryChunk var4;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         var4 = (MemoryChunk)var3.next();
      } while(var1 < var4.getAddress() || var1 >= var4.getAddress() + (long)var4.getLength());

      return var4;
   }

   private int findChunkPosition(MemoryChunk var1) {
      Preconditions.checkNotNull(var1, "Error: Memory chunk can\'t be null");
      long var2 = var1.getAddress();

      for(int var4 = 0; var4 < this.getNumberOfChunks(); ++var4) {
         if(var2 < ((MemoryChunk)this.m_chunks.get(var4)).getAddress()) {
            return var4;
         }
      }

      return this.m_chunks.size();
   }

   private MemoryChunk findNextChunk(long var1) {
      Preconditions.checkArgument(var1 >= 0L, "Error: Address can\'t be less than 0");
      Iterator var3 = this.m_chunks.iterator();

      MemoryChunk var4;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         var4 = (MemoryChunk)var3.next();
      } while(var4.getAddress() < var1);

      return var4;
   }

   private void insertChunk(MemoryChunk var1) {
      Preconditions.checkNotNull(var1, "Error: Memory chunk can\'t be null");
      int var2 = this.findChunkPosition(var1);
      this.m_chunks.add(var2, var1);
   }

   private void notifyListeners(long var1, int var3) {
      Iterator var4 = this.m_listeners.iterator();

      while(var4.hasNext()) {
         IMemoryListener var5 = (IMemoryListener)var4.next();
         var5.memoryChanged(var1, var3);
      }

   }

   private void removeChunk(MemoryChunk var1) {
      Preconditions.checkNotNull(var1, "Error: Memory chunk can\'t be null");
      this.m_chunks.remove(var1);
   }

   private void splitChunk(MemoryChunk var1, long var2) {
      byte[] var4 = var1.getBytes();
      byte[] var5 = new byte[(int)(var2 - var1.getAddress())];
      byte[] var6 = new byte[var1.getLength() - var5.length];
      System.arraycopy(var4, 0, var5, 0, var5.length);
      System.arraycopy(var4, var4.length - var6.length, var6, 0, var6.length);
      MemoryChunk var7 = new MemoryChunk(var1.getAddress(), var5);
      MemoryChunk var8 = new MemoryChunk(var1.getAddress() + (long)var1.getLength() - (long)var6.length, var6);
      this.removeChunk(var1);
      this.insertChunk(var7);
      this.insertChunk(var8);
   }

   public void addMemoryListener(IMemoryListener var1) {
      Preconditions.checkNotNull(var1, "Error: Listener can\'t be null");
      this.m_listeners.add(var1);
   }

   public void clear() {
      this.m_writeLock.lock();
      this.m_chunks.clear();
      this.m_writeLock.unlock();
      Iterator var1 = this.m_listeners.iterator();

      while(var1.hasNext()) {
         IMemoryListener var2 = (IMemoryListener)var1.next();
         var2.memoryCleared();
      }

   }

   public byte[] getData(long var1, int var3) {
      Preconditions.checkArgument(var1 >= 0L, "Error: Address can\'t be less than 0");
      Preconditions.checkArgument(var3 > 0, "Error: Length must be positive");
      this.m_readLock.lock();
      MemoryChunk var4 = this.findChunk(var1);
      int var5 = var3;
      long var6 = var1;
      byte[] var8 = new byte[var3];
      int var9 = 0;

      try {
         while(var4 != null) {
            int var10;
            if(var4.getAddress() + (long)var4.getLength() - var6 >= (long)var5) {
               var10 = (int)(var6 - var4.getAddress());
               System.arraycopy(var4.getBytes(), var10, var8, var9, var5);
               byte[] var15 = var8;
               return var15;
            }

            var10 = (int)(var6 - var4.getAddress());
            int var11 = var4.getLength() - var10;
            System.arraycopy(var4.getBytes(), var10, var8, var9, var11);
            var9 += var11;
            var5 = (int)((long)var5 - (var4.getAddress() + (long)var4.getLength() - var6));
            var6 = var4.getAddress() + (long)var4.getLength();
            var4 = this.findChunk(var6);
         }

         throw new IllegalArgumentException("Error: Data is not available");
      } finally {
         this.m_readLock.unlock();
      }
   }

   public int getMemorySize() {
      this.m_readLock.lock();
      int var1 = 0;

      MemoryChunk var3;
      for(Iterator var2 = this.m_chunks.iterator(); var2.hasNext(); var1 += var3.getLength()) {
         var3 = (MemoryChunk)var2.next();
      }

      this.m_readLock.unlock();
      return var1;
   }

   public int getNumberOfChunks() {
      this.m_readLock.lock();
      int var1 = this.m_chunks.size();
      this.m_readLock.unlock();
      return var1;
   }

   public long getSectionSize(long var1) {
      this.m_readLock.lock();
      long var3 = this.getSectionStart(var1);

      long var8;
      try {
         MemoryChunk var5;
         if(this.hasData(var3, 1)) {
            var5 = this.findChunk(var3);

            long var14;
            for(var14 = 0L; this.hasData(var5.getAddress() + (long)var5.getLength(), 1); var5 = this.findChunk(var5.getAddress() + (long)var5.getLength())) {
               var14 += (long)var5.getLength();
            }

            var8 = (long)((int)(var14 + (long)var5.getLength()));
            return var8;
         }

         if(this.m_chunks.size() == 0) {
            long var13 = 4294967296L;
            return var13;
         }

         var5 = new MemoryChunk(var3, 1);
         int var6 = this.findChunkPosition(var5);
         if(var6 != this.m_chunks.size()) {
            long var15 = ((MemoryChunk)this.m_chunks.get(var6)).getAddress() - var3;
            return var15;
         }

         MemoryChunk var7 = (MemoryChunk)this.m_chunks.get(var6 - 1);
         var8 = 4294967296L - var7.getAddress() - (long)var7.getLength();
      } finally {
         this.m_readLock.unlock();
      }

      return var8;
   }

   public long getSectionStart(long var1) {
      long var7;
      try {
         this.m_readLock.lock();
         MemoryChunk var3 = this.findChunk(var1);
         MemoryChunk var6;
         long var13;
         if(var3 == null) {
            MemoryChunk var12 = new MemoryChunk(var1, 1);
            int var5 = this.findChunkPosition(var12);
            if(var5 == 0) {
               var13 = 0L;
               return var13;
            }

            var6 = (MemoryChunk)this.m_chunks.get(var5 - 1);
            var7 = var6.getAddress() + (long)var6.getLength();
            return var7;
         }

         long var4 = var3.getAddress();
         if(var4 == 0L) {
            var13 = 0L;
            return var13;
         }

         var6 = this.findChunk(var4 - 1L);
         if(var6 != null) {
            var7 = this.getSectionStart(var4 - 1L);
            return var7;
         }

         var7 = var4;
      } finally {
         this.m_readLock.unlock();
      }

      return var7;
   }

   public boolean hasData(long var1, int var3) {
      Preconditions.checkArgument(var1 >= 0L, "Error: Address can\'t be less than 0");
      Preconditions.checkArgument(var3 > 0, "Error: Length must be positive");

      boolean var8;
      try {
         this.m_readLock.lock();
         MemoryChunk var4 = this.findChunk(var1);
         int var5 = var3;

         for(long var6 = var1; var4 != null; var4 = this.findChunk(var6)) {
            if(var4.getAddress() + (long)var4.getLength() - var6 >= (long)var5) {
               var8 = true;
               return var8;
            }

            var5 = (int)((long)var5 - (var4.getAddress() + (long)var4.getLength() - var6));
            var6 = var4.getAddress() + (long)var4.getLength();
         }

         var8 = false;
      } finally {
         this.m_readLock.unlock();
      }

      return var8;
   }

   public void printMemory() {
      this.m_readLock.lock();
      Iterator var1 = this.m_chunks.iterator();

      while(var1.hasNext()) {
         MemoryChunk var2 = (MemoryChunk)var1.next();
         var2.print();
      }

      this.m_readLock.unlock();
   }

   public void remove(long var1, int var3) {
      Preconditions.checkArgument(var1 >= 0L, "Error: Address can\'t be less than 0");
      Preconditions.checkArgument(var3 > 0, "Error: Length must be positive");

      try {
         this.m_writeLock.lock();
         MemoryChunk var4 = this.findChunk(var1);
         MemoryChunk var5;
         int var6;
         if(var4 != null) {
            if(var4.getAddress() == var1) {
               if(var4.getLength() <= var3) {
                  this.removeChunk(var4);
                  int var10 = var3 - var4.getLength();
                  if(var10 > 0) {
                     this.remove(var1 + (long)var4.getLength(), var10);
                     return;
                  }
               } else {
                  this.splitChunk(var4, var1 + (long)var3);
                  this.removeChunk(this.findChunk(var1));
               }

               return;
            } else {
               if(var4.getAddress() + (long)var4.getLength() <= var1 + (long)var3) {
                  this.splitChunk(var4, var1);
                  var5 = this.findChunk(var1);
                  this.removeChunk(var5);
                  var6 = var3 - var5.getLength();
                  if(var6 > 0) {
                     this.remove(var1 + (long)var5.getLength(), var6);
                     return;
                  }
               } else {
                  this.splitChunk(var4, var1);
                  var5 = this.findChunk(var1);
                  this.splitChunk(var5, var1 + (long)var3);
                  this.removeChunk(this.findChunk(var1));
               }

               return;
            }
         }

         var5 = this.findNextChunk(var1);
         if(var5 == null) {
            return;
         }

         if(var5.getAddress() < var1 + (long)var3) {
            var6 = (int)(var1 + (long)var3 - var5.getAddress());
            this.remove(var5.getAddress(), var6);
            return;
         }
      } finally {
         this.m_writeLock.unlock();
      }

   }

   public void removeMemoryListener(IMemoryListener var1) {
      this.m_listeners.remove(var1);
   }

   public void store(long var1, byte[] var3) {
      Preconditions.checkArgument(var1 >= 0L, "Error: Address can\'t be less than 0");
      Preconditions.checkNotNull(var3, "Error: Data can\'t be null");

      try {
         this.m_writeLock.lock();
         this.remove(var1, var3.length);
         MemoryChunk var4 = new MemoryChunk(var1, var3);
         this.insertChunk(var4);
         MemoryChunk var5 = this.findChunk(var1 + (long)var4.getLength());
         if(var5 != null) {
            this.connectChunks(var4, var5);
         }
      } finally {
         this.m_writeLock.unlock();
      }

      this.notifyListeners(var1, var3.length);
   }
}
