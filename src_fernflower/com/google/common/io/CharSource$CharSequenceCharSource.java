package com.google.common.io;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.io.CharSequenceReader;
import com.google.common.io.CharSource;
import com.google.common.io.CharSource$CharSequenceCharSource$1;
import com.google.common.io.LineProcessor;
import java.io.Reader;
import java.util.Iterator;
import java.util.regex.Pattern;

class CharSource$CharSequenceCharSource extends CharSource {
   private static final Splitter LINE_SPLITTER = Splitter.on(Pattern.compile("\r\n|\n|\r"));
   private final CharSequence seq;

   protected CharSource$CharSequenceCharSource(CharSequence var1) {
      this.seq = (CharSequence)Preconditions.checkNotNull(var1);
   }

   public Reader openStream() {
      return new CharSequenceReader(this.seq);
   }

   public String read() {
      return this.seq.toString();
   }

   public boolean isEmpty() {
      return this.seq.length() == 0;
   }

   public long length() {
      return (long)this.seq.length();
   }

   public Optional lengthIfKnown() {
      return Optional.of(Long.valueOf((long)this.seq.length()));
   }

   private Iterable lines() {
      return new CharSource$CharSequenceCharSource$1(this);
   }

   public String readFirstLine() {
      Iterator var1 = this.lines().iterator();
      return var1.hasNext()?(String)var1.next():null;
   }

   public ImmutableList readLines() {
      return ImmutableList.copyOf(this.lines());
   }

   public Object readLines(LineProcessor var1) {
      Iterator var2 = this.lines().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         if(!var1.processLine(var3)) {
            break;
         }
      }

      return var1.getResult();
   }

   public String toString() {
      String var1 = truncate(this.seq, 30, "...");
      return (new StringBuilder(17 + String.valueOf(var1).length())).append("CharSource.wrap(").append(var1).append(")").toString();
   }

   private static String truncate(CharSequence var0, int var1, String var2) {
      Preconditions.checkNotNull(var0);
      int var3 = var1 - var2.length();
      Preconditions.checkArgument(var3 >= 0, "maxLength (%s) must be >= length of the truncation indicator (%s)", new Object[]{Integer.valueOf(var1), Integer.valueOf(var2.length())});
      if(((CharSequence)var0).length() <= var1) {
         String var4 = ((CharSequence)var0).toString();
         if(var4.length() <= var1) {
            return var4;
         }

         var0 = var4;
      }

      return (new StringBuilder(var1)).append((CharSequence)var0, 0, var3).append(var2).toString();
   }

   // $FF: synthetic method
   static CharSequence access$100(CharSource$CharSequenceCharSource var0) {
      return var0.seq;
   }

   // $FF: synthetic method
   static Splitter access$200() {
      return LINE_SPLITTER;
   }
}
