package com.google.security.zynamics.zylib.disassembly;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.security.zynamics.zylib.disassembly.IAddress;
import java.math.BigInteger;

public class CAddress implements IAddress {
   private final long m_address;

   public CAddress(BigInteger var1) {
      Preconditions.checkNotNull(var1, "Address argument can not be null");
      this.m_address = var1.longValue();
   }

   public CAddress(CAddress var1) {
      Preconditions.checkNotNull(var1, "Address argument can not be null");
      this.m_address = var1.m_address;
   }

   public CAddress(IAddress var1) {
      Preconditions.checkNotNull(var1, "Address argument can not be null");
      this.m_address = var1.toLong();
   }

   public CAddress(long var1) {
      this.m_address = var1;
   }

   public CAddress(String var1, int var2) {
      Preconditions.checkNotNull(var1, "Address argument can not be null");
      Preconditions.checkArgument(var2 > 0, "Base must be positive");
      this.m_address = (new BigInteger(var1, var2)).longValue();
   }

   public static int compare(long var0, long var2) {
      int var4 = var0 < var2?-1:(var0 > var2?1:0);
      return (var0 & Long.MIN_VALUE) == (var2 & Long.MIN_VALUE)?var4:-var4;
   }

   public int compareTo(CAddress var1) {
      return compare(this.m_address, var1.m_address);
   }

   public int compareTo(IAddress var1) {
      return compare(this.m_address, var1.toLong());
   }

   public int compareTo(long var1) {
      return compare(this.m_address, var1);
   }

   public boolean equals(CAddress var1) {
      return var1 != null && this.m_address == var1.m_address;
   }

   public boolean equals(IAddress var1) {
      return var1 != null && this.m_address == var1.toLong();
   }

   public boolean equals(long var1) {
      return this.m_address == var1;
   }

   public boolean equals(Object var1) {
      return var1 instanceof IAddress && this.m_address == ((IAddress)var1).toLong();
   }

   public int hashCode() {
      return Long.valueOf(this.m_address).hashCode();
   }

   public BigInteger toBigInteger() {
      return (this.m_address & Long.MIN_VALUE) == 0L?BigInteger.valueOf(this.m_address):new BigInteger(Long.toHexString(this.m_address), 16);
   }

   public String toHexString() {
      return Strings.padStart(Long.toHexString(this.m_address).toUpperCase(), (this.m_address & Long.MAX_VALUE) < 4294967296L?8:16, '0');
   }

   public long toLong() {
      return this.m_address;
   }

   public String toString() {
      return this.toHexString();
   }
}
