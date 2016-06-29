package com.google.common.hash;

import com.google.common.hash.HashCode;

final class GoogleLegacy32HashFunction$GoogleLegacy32Mixer {
   private int a = -1640531527;
   private int b = -1640531527;
   private int c;

   GoogleLegacy32HashFunction$GoogleLegacy32Mixer(int var1) {
      this.c = var1;
   }

   HashCode makeHash() {
      return HashCode.fromInt(this.mix());
   }

   private int mix() {
      this.a -= this.b;
      this.a -= this.c;
      this.a ^= this.c >>> 13;
      this.b -= this.c;
      this.b -= this.a;
      this.b ^= this.a << 8;
      this.c -= this.a;
      this.c -= this.b;
      this.c ^= this.b >>> 13;
      this.a -= this.b;
      this.a -= this.c;
      this.a ^= this.c >>> 12;
      this.b -= this.c;
      this.b -= this.a;
      this.b ^= this.a << 16;
      this.c -= this.a;
      this.c -= this.b;
      this.c ^= this.b >>> 5;
      this.a -= this.b;
      this.a -= this.c;
      this.a ^= this.c >>> 3;
      this.b -= this.c;
      this.b -= this.a;
      this.b ^= this.a << 10;
      this.c -= this.a;
      this.c -= this.b;
      this.c ^= this.b >>> 15;
      return this.c;
   }

   // $FF: synthetic method
   static int access$200(GoogleLegacy32HashFunction$GoogleLegacy32Mixer var0) {
      return var0.a;
   }

   // $FF: synthetic method
   static int access$202(GoogleLegacy32HashFunction$GoogleLegacy32Mixer var0, int var1) {
      return var0.a = var1;
   }

   // $FF: synthetic method
   static int access$300(GoogleLegacy32HashFunction$GoogleLegacy32Mixer var0) {
      return var0.b;
   }

   // $FF: synthetic method
   static int access$302(GoogleLegacy32HashFunction$GoogleLegacy32Mixer var0, int var1) {
      return var0.b = var1;
   }

   // $FF: synthetic method
   static int access$400(GoogleLegacy32HashFunction$GoogleLegacy32Mixer var0) {
      return var0.c;
   }

   // $FF: synthetic method
   static int access$402(GoogleLegacy32HashFunction$GoogleLegacy32Mixer var0, int var1) {
      return var0.c = var1;
   }

   // $FF: synthetic method
   static int access$500(GoogleLegacy32HashFunction$GoogleLegacy32Mixer var0) {
      return var0.mix();
   }
}
