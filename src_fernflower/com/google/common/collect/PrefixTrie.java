package com.google.common.collect;

import com.google.common.annotations.GoogleInternal;
import com.google.common.collect.Maps;
import com.google.common.collect.PrefixMap;
import com.google.common.collect.PrefixTrie$Node;
import java.util.LinkedHashMap;
import java.util.Map;

@GoogleInternal
public class PrefixTrie implements PrefixMap {
   private final char rangeOffset;
   private final int rangeSize;
   private final PrefixTrie$Node root;

   public PrefixTrie() {
      this.rangeOffset = 0;
      this.rangeSize = 128;
      this.root = new PrefixTrie$Node(this.rangeSize);
   }

   public PrefixTrie(char var1, char var2) {
      this.rangeOffset = var1;
      this.rangeSize = var2 - var1 + 1;
      if(this.rangeSize <= 0) {
         throw new IllegalArgumentException("Char range must include some chars");
      } else {
         this.root = new PrefixTrie$Node(this.rangeSize);
      }
   }

   public Object put(CharSequence var1, Object var2) {
      if(var2 == null) {
         throw new NullPointerException();
      } else {
         return this.putInternal(var1, var2);
      }
   }

   private Object putInternal(CharSequence var1, Object var2) {
      PrefixTrie$Node var3 = this.root;

      for(int var4 = 0; var4 < var1.length(); ++var4) {
         int var5 = var1.charAt(var4) - this.rangeOffset;

         try {
            PrefixTrie$Node var6 = var3.next[var5];
            if(var6 == null) {
               var6 = var3.next[var5] = new PrefixTrie$Node(this.rangeSize);
            }

            var3 = var6;
         } catch (ArrayIndexOutOfBoundsException var8) {
            char var7 = var1.charAt(var4);
            throw new IllegalArgumentException((new StringBuilder(36)).append("\'").append(var7).append("\' is not a legal prefix character.").toString());
         }
      }

      Object var9 = var3.value;
      var3.value = var2;
      return var9;
   }

   public Object get(CharSequence var1) {
      PrefixTrie$Node var2 = this.root;
      PrefixTrie$Node var3 = this.root;
      int var4 = 0;

      while(true) {
         if(var4 < var1.length()) {
            int var5 = var1.charAt(var4) - this.rangeOffset;
            if(var5 < 0 || this.rangeSize <= var5) {
               return null;
            }

            var3 = var3.next[var5];
            if(var3 != null) {
               if(var3.value != null) {
                  var2 = var3;
               }

               ++var4;
               continue;
            }
         }

         return var2.value;
      }
   }

   public Object remove(CharSequence var1) {
      return this.putInternal(var1, (Object)null);
   }

   public Map toMap() {
      LinkedHashMap var1 = Maps.newLinkedHashMap();
      this.addEntries(this.root, new StringBuilder(), var1);
      return var1;
   }

   private void addEntries(PrefixTrie$Node var1, StringBuilder var2, Map var3) {
      if(var1.value != null) {
         var3.put(var2.toString(), var1.value);
      }

      for(int var4 = 0; var4 < var1.next.length; ++var4) {
         PrefixTrie$Node var5 = var1.next[var4];
         if(var5 != null) {
            var2.append((char)(var4 + this.rangeOffset));
            this.addEntries(var5, var2, var3);
            var2.deleteCharAt(var2.length() - 1);
         }
      }

   }
}
