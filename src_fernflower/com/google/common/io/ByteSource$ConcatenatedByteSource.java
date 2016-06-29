package com.google.common.io;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.io.ByteSource;
import com.google.common.io.MultiInputStream;
import java.io.InputStream;
import java.util.Iterator;

final class ByteSource$ConcatenatedByteSource extends ByteSource {
   final Iterable sources;

   ByteSource$ConcatenatedByteSource(Iterable var1) {
      this.sources = (Iterable)Preconditions.checkNotNull(var1);
   }

   public InputStream openStream() {
      return new MultiInputStream(this.sources.iterator());
   }

   public boolean isEmpty() {
      Iterator var1 = this.sources.iterator();

      ByteSource var2;
      do {
         if(!var1.hasNext()) {
            return true;
         }

         var2 = (ByteSource)var1.next();
      } while(var2.isEmpty());

      return false;
   }

   public Optional sizeIfKnown() {
      long var1 = 0L;

      Optional var5;
      for(Iterator var3 = this.sources.iterator(); var3.hasNext(); var1 += ((Long)var5.get()).longValue()) {
         ByteSource var4 = (ByteSource)var3.next();
         var5 = var4.sizeIfKnown();
         if(!var5.isPresent()) {
            return Optional.absent();
         }
      }

      return Optional.of(Long.valueOf(var1));
   }

   public long size() {
      long var1 = 0L;

      ByteSource var4;
      for(Iterator var3 = this.sources.iterator(); var3.hasNext(); var1 += var4.size()) {
         var4 = (ByteSource)var3.next();
      }

      return var1;
   }

   public String toString() {
      String var1 = String.valueOf(this.sources);
      return (new StringBuilder(19 + String.valueOf(var1).length())).append("ByteSource.concat(").append(var1).append(")").toString();
   }
}
