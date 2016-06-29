package com.google.common.hash;

import com.google.common.hash.AbstractCompositeHashFunction;
import com.google.common.hash.Funnel;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import java.nio.charset.Charset;

class AbstractCompositeHashFunction$1 implements Hasher {
   // $FF: synthetic field
   final Hasher[] val$hashers;
   // $FF: synthetic field
   final AbstractCompositeHashFunction this$0;

   AbstractCompositeHashFunction$1(AbstractCompositeHashFunction var1, Hasher[] var2) {
      this.this$0 = var1;
      this.val$hashers = var2;
   }

   public Hasher putByte(byte var1) {
      Hasher[] var2 = this.val$hashers;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Hasher var5 = var2[var4];
         var5.putByte(var1);
      }

      return this;
   }

   public Hasher putBytes(byte[] var1) {
      Hasher[] var2 = this.val$hashers;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Hasher var5 = var2[var4];
         var5.putBytes(var1);
      }

      return this;
   }

   public Hasher putBytes(byte[] var1, int var2, int var3) {
      Hasher[] var4 = this.val$hashers;
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         Hasher var7 = var4[var6];
         var7.putBytes(var1, var2, var3);
      }

      return this;
   }

   public Hasher putShort(short var1) {
      Hasher[] var2 = this.val$hashers;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Hasher var5 = var2[var4];
         var5.putShort(var1);
      }

      return this;
   }

   public Hasher putInt(int var1) {
      Hasher[] var2 = this.val$hashers;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Hasher var5 = var2[var4];
         var5.putInt(var1);
      }

      return this;
   }

   public Hasher putLong(long var1) {
      Hasher[] var3 = this.val$hashers;
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         Hasher var6 = var3[var5];
         var6.putLong(var1);
      }

      return this;
   }

   public Hasher putFloat(float var1) {
      Hasher[] var2 = this.val$hashers;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Hasher var5 = var2[var4];
         var5.putFloat(var1);
      }

      return this;
   }

   public Hasher putDouble(double var1) {
      Hasher[] var3 = this.val$hashers;
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         Hasher var6 = var3[var5];
         var6.putDouble(var1);
      }

      return this;
   }

   public Hasher putBoolean(boolean var1) {
      Hasher[] var2 = this.val$hashers;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Hasher var5 = var2[var4];
         var5.putBoolean(var1);
      }

      return this;
   }

   public Hasher putChar(char var1) {
      Hasher[] var2 = this.val$hashers;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Hasher var5 = var2[var4];
         var5.putChar(var1);
      }

      return this;
   }

   @Deprecated
   public Hasher putString(CharSequence var1) {
      return this.putUnencodedChars(var1);
   }

   public Hasher putUnencodedChars(CharSequence var1) {
      Hasher[] var2 = this.val$hashers;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Hasher var5 = var2[var4];
         var5.putUnencodedChars(var1);
      }

      return this;
   }

   public Hasher putString(CharSequence var1, Charset var2) {
      Hasher[] var3 = this.val$hashers;
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         Hasher var6 = var3[var5];
         var6.putString(var1, var2);
      }

      return this;
   }

   public Hasher putObject(Object var1, Funnel var2) {
      Hasher[] var3 = this.val$hashers;
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         Hasher var6 = var3[var5];
         var6.putObject(var1, var2);
      }

      return this;
   }

   public HashCode hash() {
      return this.this$0.makeHash(this.val$hashers);
   }
}
