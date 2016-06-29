package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.base.Joiner;
import com.google.common.base.Joiner$1;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.CheckReturnValue;

public final class Joiner$MapJoiner {
   private final Joiner joiner;
   private final String keyValueSeparator;

   private Joiner$MapJoiner(Joiner var1, String var2) {
      this.joiner = var1;
      this.keyValueSeparator = (String)Preconditions.checkNotNull(var2);
   }

   public Appendable appendTo(Appendable var1, Map var2) {
      return this.appendTo((Appendable)var1, (Iterable)var2.entrySet());
   }

   public StringBuilder appendTo(StringBuilder var1, Map var2) {
      return this.appendTo((StringBuilder)var1, (Iterable)var2.entrySet());
   }

   @CheckReturnValue
   public String join(Map var1) {
      return this.join((Iterable)var1.entrySet());
   }

   @Beta
   public Appendable appendTo(Appendable var1, Iterable var2) {
      return this.appendTo(var1, var2.iterator());
   }

   @Beta
   public Appendable appendTo(Appendable var1, Iterator var2) {
      Preconditions.checkNotNull(var1);
      if(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.append(this.joiner.toString(var3.getKey()));
         var1.append(this.keyValueSeparator);
         var1.append(this.joiner.toString(var3.getValue()));

         while(var2.hasNext()) {
            var1.append(Joiner.access$100(this.joiner));
            Entry var4 = (Entry)var2.next();
            var1.append(this.joiner.toString(var4.getKey()));
            var1.append(this.keyValueSeparator);
            var1.append(this.joiner.toString(var4.getValue()));
         }
      }

      return var1;
   }

   @Beta
   public StringBuilder appendTo(StringBuilder var1, Iterable var2) {
      return this.appendTo(var1, var2.iterator());
   }

   @Beta
   public StringBuilder appendTo(StringBuilder var1, Iterator var2) {
      try {
         this.appendTo((Appendable)var1, (Iterator)var2);
         return var1;
      } catch (IOException var4) {
         throw new AssertionError(var4);
      }
   }

   @CheckReturnValue
   @Beta
   public String join(Iterable var1) {
      return this.join(var1.iterator());
   }

   @CheckReturnValue
   @Beta
   public String join(Iterator var1) {
      return this.appendTo(new StringBuilder(), var1).toString();
   }

   @CheckReturnValue
   public Joiner$MapJoiner useForNull(String var1) {
      return new Joiner$MapJoiner(this.joiner.useForNull(var1), this.keyValueSeparator);
   }

   // $FF: synthetic method
   Joiner$MapJoiner(Joiner var1, String var2, Joiner$1 var3) {
      this(var1, var2);
   }
}
