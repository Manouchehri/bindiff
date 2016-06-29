package com.google.common.base;

import com.google.common.base.AbstractIterator;
import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;

abstract class Splitter$SplittingIterator extends AbstractIterator {
   final CharSequence toSplit;
   final CharMatcher trimmer;
   final boolean omitEmptyStrings;
   int offset = 0;
   int limit;

   abstract int separatorStart(int var1);

   abstract int separatorEnd(int var1);

   protected Splitter$SplittingIterator(Splitter var1, CharSequence var2) {
      this.trimmer = Splitter.access$200(var1);
      this.omitEmptyStrings = Splitter.access$300(var1);
      this.limit = Splitter.access$400(var1);
      this.toSplit = var2;
   }

   protected String computeNext() {
      int var1 = this.offset;

      while(true) {
         while(this.offset != -1) {
            int var2 = var1;
            int var4 = this.separatorStart(this.offset);
            int var3;
            if(var4 == -1) {
               var3 = this.toSplit.length();
               this.offset = -1;
            } else {
               var3 = var4;
               this.offset = this.separatorEnd(var4);
            }

            if(this.offset != var1) {
               while(var2 < var3 && this.trimmer.matches(this.toSplit.charAt(var2))) {
                  ++var2;
               }

               while(var3 > var2 && this.trimmer.matches(this.toSplit.charAt(var3 - 1))) {
                  --var3;
               }

               if(!this.omitEmptyStrings || var2 != var3) {
                  if(this.limit == 1) {
                     var3 = this.toSplit.length();

                     for(this.offset = -1; var3 > var2 && this.trimmer.matches(this.toSplit.charAt(var3 - 1)); --var3) {
                        ;
                     }
                  } else {
                     --this.limit;
                  }

                  return this.toSplit.subSequence(var2, var3).toString();
               }

               var1 = this.offset;
            } else {
               ++this.offset;
               if(this.offset >= this.toSplit.length()) {
                  this.offset = -1;
               }
            }
         }

         return (String)this.endOfData();
      }
   }
}
