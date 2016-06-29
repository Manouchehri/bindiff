package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.io.CharSink;
import com.google.common.io.CharSource$CharSequenceCharSource;
import com.google.common.io.CharSource$ConcatenatedCharSource;
import com.google.common.io.CharSource$EmptyCharSource;
import com.google.common.io.CharStreams;
import com.google.common.io.Closer;
import com.google.common.io.LineProcessor;
import java.io.BufferedReader;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

public abstract class CharSource {
   public abstract Reader openStream();

   public BufferedReader openBufferedStream() {
      Reader var1 = this.openStream();
      return var1 instanceof BufferedReader?(BufferedReader)var1:new BufferedReader(var1);
   }

   @Beta
   public Optional lengthIfKnown() {
      return Optional.absent();
   }

   @Beta
   public long length() {
      Optional var1 = this.lengthIfKnown();
      if(var1.isPresent()) {
         return ((Long)var1.get()).longValue();
      } else {
         Closer var2 = Closer.create();

         long var4;
         try {
            Reader var3 = (Reader)var2.register(this.openStream());
            var4 = this.countBySkipping(var3);
         } catch (Throwable var9) {
            throw var2.rethrow(var9);
         } finally {
            var2.close();
         }

         return var4;
      }
   }

   private long countBySkipping(Reader var1) {
      long var2;
      long var4;
      for(var2 = 0L; (var4 = var1.skip(Long.MAX_VALUE)) != 0L; var2 += var4) {
         ;
      }

      return var2;
   }

   public long copyTo(Appendable var1) {
      Preconditions.checkNotNull(var1);
      Closer var2 = Closer.create();

      long var4;
      try {
         Reader var3 = (Reader)var2.register(this.openStream());
         var4 = CharStreams.copy(var3, var1);
      } catch (Throwable var9) {
         throw var2.rethrow(var9);
      } finally {
         var2.close();
      }

      return var4;
   }

   public long copyTo(CharSink var1) {
      Preconditions.checkNotNull(var1);
      Closer var2 = Closer.create();

      long var5;
      try {
         Reader var3 = (Reader)var2.register(this.openStream());
         Writer var4 = (Writer)var2.register(var1.openStream());
         var5 = CharStreams.copy(var3, var4);
      } catch (Throwable var10) {
         throw var2.rethrow(var10);
      } finally {
         var2.close();
      }

      return var5;
   }

   public String read() {
      Closer var1 = Closer.create();

      String var3;
      try {
         Reader var2 = (Reader)var1.register(this.openStream());
         var3 = CharStreams.toString(var2);
      } catch (Throwable var7) {
         throw var1.rethrow(var7);
      } finally {
         var1.close();
      }

      return var3;
   }

   @Nullable
   public String readFirstLine() {
      Closer var1 = Closer.create();

      String var3;
      try {
         BufferedReader var2 = (BufferedReader)var1.register(this.openBufferedStream());
         var3 = var2.readLine();
      } catch (Throwable var7) {
         throw var1.rethrow(var7);
      } finally {
         var1.close();
      }

      return var3;
   }

   public ImmutableList readLines() {
      Closer var1 = Closer.create();

      try {
         BufferedReader var2 = (BufferedReader)var1.register(this.openBufferedStream());
         ArrayList var3 = Lists.newArrayList();

         String var4;
         while((var4 = var2.readLine()) != null) {
            var3.add(var4);
         }

         ImmutableList var5 = ImmutableList.copyOf((Collection)var3);
         return var5;
      } catch (Throwable var9) {
         throw var1.rethrow(var9);
      } finally {
         var1.close();
      }
   }

   @Beta
   public Object readLines(LineProcessor var1) {
      Preconditions.checkNotNull(var1);
      Closer var2 = Closer.create();

      Object var4;
      try {
         Reader var3 = (Reader)var2.register(this.openStream());
         var4 = CharStreams.readLines(var3, var1);
      } catch (Throwable var8) {
         throw var2.rethrow(var8);
      } finally {
         var2.close();
      }

      return var4;
   }

   public boolean isEmpty() {
      Optional var1 = this.lengthIfKnown();
      if(var1.isPresent() && ((Long)var1.get()).longValue() == 0L) {
         return true;
      } else {
         Closer var2 = Closer.create();

         boolean var4;
         try {
            Reader var3 = (Reader)var2.register(this.openStream());
            var4 = var3.read() == -1;
         } catch (Throwable var8) {
            throw var2.rethrow(var8);
         } finally {
            var2.close();
         }

         return var4;
      }
   }

   public static CharSource concat(Iterable var0) {
      return new CharSource$ConcatenatedCharSource(var0);
   }

   public static CharSource concat(Iterator var0) {
      return concat((Iterable)ImmutableList.copyOf(var0));
   }

   public static CharSource concat(CharSource... var0) {
      return concat((Iterable)ImmutableList.copyOf((Object[])var0));
   }

   public static CharSource wrap(CharSequence var0) {
      return new CharSource$CharSequenceCharSource(var0);
   }

   public static CharSource empty() {
      return CharSource$EmptyCharSource.access$000();
   }
}
