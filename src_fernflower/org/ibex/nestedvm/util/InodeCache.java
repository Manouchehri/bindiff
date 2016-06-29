package org.ibex.nestedvm.util;

public class InodeCache {
   private static final Object PLACEHOLDER = new Object();
   private static final short SHORT_PLACEHOLDER = -2;
   private static final short SHORT_NULL = -1;
   private static final int LOAD_FACTOR = 2;
   private final int maxSize;
   private final int totalSlots;
   private final int maxUsedSlots;
   private final Object[] keys;
   private final short[] next;
   private final short[] prev;
   private final short[] inodes;
   private final short[] reverse;
   private int size;
   private int usedSlots;
   private short mru;
   private short lru;

   public InodeCache() {
      this(1024);
   }

   public InodeCache(int var1) {
      this.maxSize = var1;
      this.totalSlots = var1 * 2 * 2 + 3;
      this.maxUsedSlots = this.totalSlots / 2;
      if(this.totalSlots > 32767) {
         throw new IllegalArgumentException("cache size too large");
      } else {
         this.keys = new Object[this.totalSlots];
         this.next = new short[this.totalSlots];
         this.prev = new short[this.totalSlots];
         this.inodes = new short[this.totalSlots];
         this.reverse = new short[this.totalSlots];
         this.clear();
      }
   }

   private static void fill(Object[] var0, Object var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         var0[var2] = var1;
      }

   }

   private static void fill(short[] var0, short var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         var0[var2] = var1;
      }

   }

   public final void clear() {
      this.size = this.usedSlots = 0;
      this.mru = this.lru = -1;
      fill(this.keys, (Object)null);
      fill(this.inodes, (short)-1);
      fill(this.reverse, (short)-1);
   }

   public final short get(Object var1) {
      int var2 = var1.hashCode() & Integer.MAX_VALUE;
      int var3 = var2 % this.totalSlots;
      int var4 = var3;
      int var5 = 1;
      boolean var6 = true;

      Object var7;
      int var8;
      short var11;
      for(var8 = -1; (var7 = this.keys[var3]) != null; var6 = !var6) {
         if(var7 == PLACEHOLDER) {
            if(var8 == -1) {
               var8 = var3;
            }
         } else if(var7.equals(var1)) {
            short var9 = this.inodes[var3];
            if(var3 == this.mru) {
               return var9;
            }

            if(this.lru == var3) {
               this.lru = this.next[this.lru];
            } else {
               short var10 = this.prev[var3];
               var11 = this.next[var3];
               this.next[var10] = var11;
               this.prev[var11] = var10;
            }

            this.prev[var3] = this.mru;
            this.next[this.mru] = (short)var3;
            this.mru = (short)var3;
            return var9;
         }

         var3 = Math.abs((var4 + (var6?1:-1) * var5 * var5) % this.totalSlots);
         if(!var6) {
            ++var5;
         }
      }

      int var13;
      if(var8 == -1) {
         var13 = var3;
         if(this.usedSlots == this.maxUsedSlots) {
            this.clear();
            return this.get(var1);
         }

         ++this.usedSlots;
      } else {
         var13 = var8;
      }

      if(this.size == this.maxSize) {
         this.keys[this.lru] = PLACEHOLDER;
         this.inodes[this.lru] = -2;
         this.lru = this.next[this.lru];
      } else {
         if(this.size == 0) {
            this.lru = (short)var13;
         }

         ++this.size;
      }

      int var14 = var2 & 32767;

      label100:
      while(true) {
         var3 = var14 % this.totalSlots;
         var4 = var3;
         var5 = 1;
         var6 = true;

         for(var8 = -1; (var11 = this.reverse[var3]) != -1; var6 = !var6) {
            short var12 = this.inodes[var11];
            if(var12 == -2) {
               if(var8 == -1) {
                  var8 = var3;
               }
            } else if(var12 == var14) {
               ++var14;
               continue label100;
            }

            var3 = Math.abs((var4 + (var6?1:-1) * var5 * var5) % this.totalSlots);
            if(!var6) {
               ++var5;
            }
         }

         if(var8 != -1) {
            var3 = var8;
         }

         this.keys[var13] = var1;
         this.reverse[var3] = (short)var13;
         this.inodes[var13] = (short)var14;
         if(this.mru != -1) {
            this.prev[var13] = this.mru;
            this.next[this.mru] = (short)var13;
         }

         this.mru = (short)var13;
         return (short)var14;
      }
   }

   public Object reverse(short var1) {
      int var2 = var1 % this.totalSlots;
      int var3 = var2;
      int var4 = 1;

      short var6;
      for(boolean var5 = true; (var6 = this.reverse[var2]) != -1; var5 = !var5) {
         if(this.inodes[var6] == var1) {
            return this.keys[var6];
         }

         var2 = Math.abs((var3 + (var5?1:-1) * var4 * var4) % this.totalSlots);
         if(!var5) {
            ++var4;
         }
      }

      return null;
   }
}
