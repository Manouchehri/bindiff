package com.google.protobuf;

final class Utf8 {
   public static final int COMPLETE = 0;
   public static final int MALFORMED = -1;

   public static boolean isValidUtf8(byte[] var0) {
      return isValidUtf8(var0, 0, var0.length);
   }

   public static boolean isValidUtf8(byte[] var0, int var1, int var2) {
      return partialIsValidUtf8(var0, var1, var2) == 0;
   }

   public static int partialIsValidUtf8(int var0, byte[] var1, int var2, int var3) {
      if(var0 != 0) {
         if(var2 >= var3) {
            return var0;
         }

         byte var4 = (byte)var0;
         if(var4 < -32) {
            if(var4 < -62 || var1[var2++] > -65) {
               return -1;
            }
         } else {
            byte var5;
            if(var4 < -16) {
               var5 = (byte)(~(var0 >> 8));
               if(var5 == 0) {
                  var5 = var1[var2++];
                  if(var2 >= var3) {
                     return incompleteStateFor(var4, var5);
                  }
               }

               if(var5 > -65 || var4 == -32 && var5 < -96 || var4 == -19 && var5 >= -96 || var1[var2++] > -65) {
                  return -1;
               }
            } else {
               var5 = (byte)(~(var0 >> 8));
               byte var6 = 0;
               if(var5 == 0) {
                  var5 = var1[var2++];
                  if(var2 >= var3) {
                     return incompleteStateFor(var4, var5);
                  }
               } else {
                  var6 = (byte)(var0 >> 16);
               }

               if(var6 == 0) {
                  var6 = var1[var2++];
                  if(var2 >= var3) {
                     return incompleteStateFor(var4, var5, var6);
                  }
               }

               if(var5 > -65 || (var4 << 28) + (var5 - -112) >> 30 != 0 || var6 > -65 || var1[var2++] > -65) {
                  return -1;
               }
            }
         }
      }

      return partialIsValidUtf8(var1, var2, var3);
   }

   public static int partialIsValidUtf8(byte[] var0, int var1, int var2) {
      while(var1 < var2 && var0[var1] >= 0) {
         ++var1;
      }

      return var1 >= var2?0:partialIsValidUtf8NonAscii(var0, var1, var2);
   }

   private static int partialIsValidUtf8NonAscii(byte[] var0, int var1, int var2) {
      while(var1 < var2) {
         byte var3;
         if((var3 = var0[var1++]) < 0) {
            if(var3 < -32) {
               if(var1 >= var2) {
                  return var3;
               }

               if(var3 < -62 || var0[var1++] > -65) {
                  return -1;
               }
            } else {
               byte var4;
               if(var3 < -16) {
                  if(var1 >= var2 - 1) {
                     return incompleteStateFor(var0, var1, var2);
                  }

                  if((var4 = var0[var1++]) > -65 || var3 == -32 && var4 < -96 || var3 == -19 && var4 >= -96 || var0[var1++] > -65) {
                     return -1;
                  }
               } else {
                  if(var1 >= var2 - 2) {
                     return incompleteStateFor(var0, var1, var2);
                  }

                  if((var4 = var0[var1++]) > -65 || (var3 << 28) + (var4 - -112) >> 30 != 0 || var0[var1++] > -65 || var0[var1++] > -65) {
                     return -1;
                  }
               }
            }
         }
      }

      return 0;
   }

   private static int incompleteStateFor(int var0) {
      return var0 > -12?-1:var0;
   }

   private static int incompleteStateFor(int var0, int var1) {
      return var0 <= -12 && var1 <= -65?var0 ^ var1 << 8:-1;
   }

   private static int incompleteStateFor(int var0, int var1, int var2) {
      return var0 <= -12 && var1 <= -65 && var2 <= -65?var0 ^ var1 << 8 ^ var2 << 16:-1;
   }

   private static int incompleteStateFor(byte[] var0, int var1, int var2) {
      byte var3 = var0[var1 - 1];
      switch(var2 - var1) {
      case 0:
         return incompleteStateFor(var3);
      case 1:
         return incompleteStateFor(var3, var0[var1]);
      case 2:
         return incompleteStateFor(var3, var0[var1], var0[var1 + 1]);
      default:
         throw new AssertionError();
      }
   }
}
