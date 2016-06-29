package com.google.common.hash;

import com.google.common.hash.HashCode;

final class GoogleLegacy64HashFunction$GoogleLegacy64Mixer {
   private long a = -2266404186210603134L;
   private long b = -2266404186210603134L;
   private long c;

   GoogleLegacy64HashFunction$GoogleLegacy64Mixer(long var1) {
      this.c = var1;
   }

   HashCode makeHash() {
      return HashCode.fromLong(this.mix());
   }

   private long mix() {
      this.a -= this.b;
      this.a -= this.c;
      this.a ^= this.c >>> 43;
      this.b -= this.c;
      this.b -= this.a;
      this.b ^= this.a << 9;
      this.c -= this.a;
      this.c -= this.b;
      this.c ^= this.b >>> 8;
      this.a -= this.b;
      this.a -= this.c;
      this.a ^= this.c >>> 38;
      this.b -= this.c;
      this.b -= this.a;
      this.b ^= this.a << 23;
      this.c -= this.a;
      this.c -= this.b;
      this.c ^= this.b >>> 5;
      this.a -= this.b;
      this.a -= this.c;
      this.a ^= this.c >>> 35;
      this.b -= this.c;
      this.b -= this.a;
      this.b ^= this.a << 49;
      this.c -= this.a;
      this.c -= this.b;
      this.c ^= this.b >>> 11;
      this.a -= this.b;
      this.a -= this.c;
      this.a ^= this.c >>> 12;
      this.b -= this.c;
      this.b -= this.a;
      this.b ^= this.a << 18;
      this.c -= this.a;
      this.c -= this.b;
      this.c ^= this.b >>> 22;
      return this.c;
   }

   // $FF: synthetic method
   static long access$100(GoogleLegacy64HashFunction$GoogleLegacy64Mixer var0) {
      return var0.a;
   }

   // $FF: synthetic method
   static long access$102(GoogleLegacy64HashFunction$GoogleLegacy64Mixer var0, long var1) {
      return var0.a = var1;
   }

   // $FF: synthetic method
   static long access$200(GoogleLegacy64HashFunction$GoogleLegacy64Mixer var0) {
      return var0.b;
   }

   // $FF: synthetic method
   static long access$202(GoogleLegacy64HashFunction$GoogleLegacy64Mixer var0, long var1) {
      return var0.b = var1;
   }

   // $FF: synthetic method
   static long access$300(GoogleLegacy64HashFunction$GoogleLegacy64Mixer var0) {
      return var0.c;
   }

   // $FF: synthetic method
   static long access$302(GoogleLegacy64HashFunction$GoogleLegacy64Mixer var0, long var1) {
      return var0.c = var1;
   }

   // $FF: synthetic method
   static long access$400(GoogleLegacy64HashFunction$GoogleLegacy64Mixer var0) {
      return var0.mix();
   }
}
