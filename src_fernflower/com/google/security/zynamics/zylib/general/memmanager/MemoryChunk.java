package com.google.security.zynamics.zylib.general.memmanager;

import com.google.common.base.Preconditions;

public class MemoryChunk implements Comparable {
   private final long m_address;
   private byte[] m_data;

   public MemoryChunk(long var1, byte[] var3) {
      Preconditions.checkArgument(var1 >= 0L, "Error: Chunk addresses can\'t be less than 0");
      Preconditions.checkNotNull(var3, "Error: Initial data can\'t be null");
      Preconditions.checkArgument(var3.length != 0, "Error: Initial data can\'t be empty");
      this.m_address = var1;
      this.m_data = var3;
   }

   public MemoryChunk(long var1, int var3) {
      this(var1, new byte[var3]);
   }

   public int compareTo(MemoryChunk var1) {
      return (int)(this.m_address - var1.m_address);
   }

   public void extend(int var1) {
      Preconditions.checkArgument(var1 > 0, "Error: The number of bytes to add must be positive");
      byte[] var2 = new byte[this.m_data.length + var1];
      System.arraycopy(this.m_data, 0, var2, 0, this.m_data.length);
      this.m_data = var2;
   }

   public long getAddress() {
      return this.m_address;
   }

   public byte[] getBytes() {
      return this.m_data;
   }

   public int getLength() {
      return this.m_data.length;
   }

   public byte loadByte(long var1) {
      return this.m_data[(int)(var1 - this.m_address)];
   }

   public void print() {
      System.out.printf("%08X: ", new Object[]{Long.valueOf(this.m_address)});
      byte[] var1 = this.m_data;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         byte var4 = var1[var3];
         System.out.printf("%02X ", new Object[]{Byte.valueOf(var4)});
      }

      System.out.println();
   }

   public void store(long var1, byte[] var3) {
      System.arraycopy(var3, 0, this.m_data, (int)(var1 - this.m_address), var3.length);
   }

   public void storeByte(long var1, byte var3) {
      this.m_data[(int)(var1 - this.m_address)] = var3;
   }
}
