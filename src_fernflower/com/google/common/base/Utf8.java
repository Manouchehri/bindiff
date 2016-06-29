package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;
import javax.annotation.CheckReturnValue;

@Beta
@GwtCompatible
public final class Utf8 {
   @CheckReturnValue
   public static int encodedLength(CharSequence var0) {
      int var1 = var0.length();
      int var2 = var1;

      int var3;
      for(var3 = 0; var3 < var1 && var0.charAt(var3) < 128; ++var3) {
         ;
      }

      while(var3 < var1) {
         char var4 = var0.charAt(var3);
         if(var4 >= 2048) {
            var2 += encodedLengthGeneral(var0, var3);
            break;
         }

         var2 += 127 - var4 >>> 31;
         ++var3;
      }

      if(var2 < var1) {
         long var6 = (long)var2 + 4294967296L;
         throw new IllegalArgumentException((new StringBuilder(54)).append("UTF-8 length does not fit in int: ").append(var6).toString());
      } else {
         return var2;
      }
   }

   private static int encodedLengthGeneral(CharSequence var0, int var1) {
      int var2 = var0.length();
      int var3 = 0;

      for(int var4 = var1; var4 < var2; ++var4) {
         char var5 = var0.charAt(var4);
         if(var5 < 2048) {
            var3 += 127 - var5 >>> 31;
         } else {
            var3 += 2;
            if('\ud800' <= var5 && var5 <= '\udfff') {
               if(Character.codePointAt(var0, var4) == var5) {
                  throw new IllegalArgumentException(unpairedSurrogateMsg(var4));
               }

               ++var4;
            }
         }
      }

      return var3;
   }

   @GwtIncompatible("ByteBuffer")
   @GoogleInternal
   public static void encode(CharSequence var0, ByteBuffer var1) {
      if(var1.isReadOnly()) {
         throw new ReadOnlyBufferException();
      } else {
         if(var1.hasArray()) {
            try {
               int var2 = encode(var0, var1.array(), var1.arrayOffset() + var1.position(), var1.remaining());
               var1.position(var2 - var1.arrayOffset());
            } catch (ArrayIndexOutOfBoundsException var4) {
               BufferOverflowException var3 = new BufferOverflowException();
               var3.initCause(var4);
               throw var3;
            }
         } else {
            encodeDirect(var0, var1);
         }

      }
   }

   @GwtIncompatible("ByteBuffer")
   @GoogleInternal
   private static void encodeDirect(CharSequence var0, ByteBuffer var1) {
      int var2 = var0.length();

      int var3;
      char var4;
      for(var3 = 0; var3 < var2 && (var4 = var0.charAt(var3)) < 128; ++var3) {
         var1.put((byte)var4);
      }

      for(; var3 < var2; ++var3) {
         var4 = var0.charAt(var3);
         if(var4 < 128) {
            var1.put((byte)var4);
         } else if(var4 < 2048) {
            var1.put((byte)(960 | var4 >>> 6));
            var1.put((byte)(128 | 63 & var4));
         } else {
            if(var4 >= '\ud800' && '\udfff' >= var4) {
               encodeDirectGeneral(var0, var1, var3);
               return;
            }

            var1.put((byte)(480 | var4 >>> 12));
            var1.put((byte)(128 | 63 & var4 >>> 6));
            var1.put((byte)(128 | 63 & var4));
         }
      }

   }

   @GwtIncompatible("ByteBuffer")
   @GoogleInternal
   private static void encodeDirectGeneral(CharSequence var0, ByteBuffer var1, int var2) {
      for(int var3 = var0.length(); var2 < var3; ++var2) {
         char var4 = var0.charAt(var2);
         if(var4 < 128) {
            var1.put((byte)var4);
         } else if(var4 < 2048) {
            var1.put((byte)(960 | var4 >>> 6));
            var1.put((byte)(128 | 63 & var4));
         } else if(var4 >= '\ud800' && '\udfff' >= var4) {
            int var5;
            if((var5 = Character.codePointAt(var0, var2)) == var4) {
               throw new IllegalArgumentException(unpairedSurrogateMsg(var2));
            }

            ++var2;
            var1.put((byte)(240 | var5 >>> 18));
            var1.put((byte)(128 | 63 & var5 >>> 12));
            var1.put((byte)(128 | 63 & var5 >>> 6));
            var1.put((byte)(128 | 63 & var5));
         } else {
            var1.put((byte)(480 | var4 >>> 12));
            var1.put((byte)(128 | 63 & var4 >>> 6));
            var1.put((byte)(128 | 63 & var4));
         }
      }

   }

   @GoogleInternal
   public static int encode(CharSequence var0, byte[] var1) {
      return encode(var0, var1, 0, var1.length);
   }

   @GoogleInternal
   public static int encode(CharSequence var0, byte[] var1, int var2) {
      return encode(var0, var1, var2, var1.length - var2);
   }

   @GoogleInternal
   private static int encode(CharSequence var0, byte[] var1, int var2, int var3) {
      int var4 = var0.length();
      int var5 = var2;
      int var6 = 0;

      int var7;
      char var8;
      for(var7 = var2 + var3; var6 < var4 && var6 + var5 < var7 && (var8 = var0.charAt(var6)) < 128; ++var6) {
         var1[var5 + var6] = (byte)var8;
      }

      if(var6 == var4) {
         return var5 + var4;
      } else {
         for(var5 += var6; var6 < var4; ++var6) {
            var8 = var0.charAt(var6);
            if(var8 < 128 && var5 < var7) {
               var1[var5++] = (byte)var8;
            } else if(var8 < 2048 && var5 <= var7 - 2) {
               var1[var5++] = (byte)(960 | var8 >>> 6);
               var1[var5++] = (byte)(128 | 63 & var8);
            } else if((var8 < '\ud800' || '\udfff' < var8) && var5 <= var7 - 3) {
               var1[var5++] = (byte)(480 | var8 >>> 12);
               var1[var5++] = (byte)(128 | 63 & var8 >>> 6);
               var1[var5++] = (byte)(128 | 63 & var8);
            } else {
               if(var5 > var7 - 4) {
                  if(unpairedSurrogateAt(var0, var6)) {
                     throw new IllegalArgumentException(unpairedSurrogateMsg(var6));
                  }

                  throw new ArrayIndexOutOfBoundsException((new StringBuilder(37)).append("Failed writing ").append(var8).append(" at index ").append(var5).toString());
               }

               int var9;
               if((var9 = Character.codePointAt(var0, var6)) == var8) {
                  throw new IllegalArgumentException(unpairedSurrogateMsg(var6));
               }

               ++var6;
               var1[var5++] = (byte)(240 | var9 >>> 18);
               var1[var5++] = (byte)(128 | 63 & var9 >>> 12);
               var1[var5++] = (byte)(128 | 63 & var9 >>> 6);
               var1[var5++] = (byte)(128 | 63 & var9);
            }
         }

         return var5;
      }
   }

   @CheckReturnValue
   public static boolean isWellFormed(byte[] var0) {
      return isWellFormed(var0, 0, var0.length);
   }

   @CheckReturnValue
   public static boolean isWellFormed(byte[] var0, int var1, int var2) {
      int var3 = var1 + var2;
      Preconditions.checkPositionIndexes(var1, var3, var0.length);

      for(int var4 = var1; var4 < var3; ++var4) {
         if(var0[var4] < 0) {
            return isWellFormedSlowPath(var0, var4, var3);
         }
      }

      return true;
   }

   private static boolean isWellFormedSlowPath(byte[] var0, int var1, int var2) {
      int var3 = var1;

      while(true) {
         byte var4;
         do {
            if(var3 >= var2) {
               return true;
            }
         } while((var4 = var0[var3++]) >= 0);

         if(var4 < -32) {
            if(var3 == var2) {
               return false;
            }

            if(var4 < -62 || var0[var3++] > -65) {
               return false;
            }
         } else {
            byte var5;
            if(var4 < -16) {
               if(var3 + 1 >= var2) {
                  return false;
               }

               var5 = var0[var3++];
               if(var5 > -65 || var4 == -32 && var5 < -96 || var4 == -19 && -96 <= var5 || var0[var3++] > -65) {
                  return false;
               }
            } else {
               if(var3 + 2 >= var2) {
                  return false;
               }

               var5 = var0[var3++];
               if(var5 > -65 || (var4 << 28) + (var5 - -112) >> 30 != 0 || var0[var3++] > -65 || var0[var3++] > -65) {
                  return false;
               }
            }
         }
      }
   }

   @GoogleInternal
   private static boolean unpairedSurrogateAt(CharSequence var0, int var1) {
      int var2 = Character.codePointAt(var0, var1);
      return '\ud800' <= var2 && var2 <= '\udfff';
   }

   private static String unpairedSurrogateMsg(int var0) {
      return (new StringBuilder(39)).append("Unpaired surrogate at index ").append(var0).toString();
   }
}
