package com.google.common.io;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.io.CharSource;
import com.google.common.io.MultiReader;
import java.io.Reader;
import java.util.Iterator;

final class CharSource$ConcatenatedCharSource extends CharSource {
   private final Iterable sources;

   CharSource$ConcatenatedCharSource(Iterable var1) {
      this.sources = (Iterable)Preconditions.checkNotNull(var1);
   }

   public Reader openStream() {
      return new MultiReader(this.sources.iterator());
   }

   public boolean isEmpty() {
      Iterator var1 = this.sources.iterator();

      CharSource var2;
      do {
         if(!var1.hasNext()) {
            return true;
         }

         var2 = (CharSource)var1.next();
      } while(var2.isEmpty());

      return false;
   }

   public Optional lengthIfKnown() {
      long var1 = 0L;

      Optional var5;
      for(Iterator var3 = this.sources.iterator(); var3.hasNext(); var1 += ((Long)var5.get()).longValue()) {
         CharSource var4 = (CharSource)var3.next();
         var5 = var4.lengthIfKnown();
         if(!var5.isPresent()) {
            return Optional.absent();
         }
      }

      return Optional.of(Long.valueOf(var1));
   }

   public long length() {
      long var1 = 0L;

      CharSource var4;
      for(Iterator var3 = this.sources.iterator(); var3.hasNext(); var1 += var4.length()) {
         var4 = (CharSource)var3.next();
      }

      return var1;
   }

   public String toString() {
      String var1 = String.valueOf(this.sources);
      return (new StringBuilder(19 + String.valueOf(var1).length())).append("CharSource.concat(").append(var1).append(")").toString();
   }
}
