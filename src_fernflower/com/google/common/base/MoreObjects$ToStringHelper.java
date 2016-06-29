package com.google.common.base;

import com.google.common.base.MoreObjects$1;
import com.google.common.base.MoreObjects$ToStringHelper$ValueHolder;
import com.google.common.base.Preconditions;
import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

public final class MoreObjects$ToStringHelper {
   private final String className;
   private MoreObjects$ToStringHelper$ValueHolder holderHead;
   private MoreObjects$ToStringHelper$ValueHolder holderTail;
   private boolean omitNullValues;

   private MoreObjects$ToStringHelper(String var1) {
      this.holderHead = new MoreObjects$ToStringHelper$ValueHolder((MoreObjects$1)null);
      this.holderTail = this.holderHead;
      this.omitNullValues = false;
      this.className = (String)Preconditions.checkNotNull(var1);
   }

   public MoreObjects$ToStringHelper omitNullValues() {
      this.omitNullValues = true;
      return this;
   }

   public MoreObjects$ToStringHelper add(String var1, @Nullable Object var2) {
      return this.addHolder(var1, var2);
   }

   public MoreObjects$ToStringHelper add(String var1, boolean var2) {
      return this.addHolder(var1, String.valueOf(var2));
   }

   public MoreObjects$ToStringHelper add(String var1, char var2) {
      return this.addHolder(var1, String.valueOf(var2));
   }

   public MoreObjects$ToStringHelper add(String var1, double var2) {
      return this.addHolder(var1, String.valueOf(var2));
   }

   public MoreObjects$ToStringHelper add(String var1, float var2) {
      return this.addHolder(var1, String.valueOf(var2));
   }

   public MoreObjects$ToStringHelper add(String var1, int var2) {
      return this.addHolder(var1, String.valueOf(var2));
   }

   public MoreObjects$ToStringHelper add(String var1, long var2) {
      return this.addHolder(var1, String.valueOf(var2));
   }

   public MoreObjects$ToStringHelper addValue(@Nullable Object var1) {
      return this.addHolder(var1);
   }

   public MoreObjects$ToStringHelper addValue(boolean var1) {
      return this.addHolder(String.valueOf(var1));
   }

   public MoreObjects$ToStringHelper addValue(char var1) {
      return this.addHolder(String.valueOf(var1));
   }

   public MoreObjects$ToStringHelper addValue(double var1) {
      return this.addHolder(String.valueOf(var1));
   }

   public MoreObjects$ToStringHelper addValue(float var1) {
      return this.addHolder(String.valueOf(var1));
   }

   public MoreObjects$ToStringHelper addValue(int var1) {
      return this.addHolder(String.valueOf(var1));
   }

   public MoreObjects$ToStringHelper addValue(long var1) {
      return this.addHolder(String.valueOf(var1));
   }

   @CheckReturnValue
   public String toString() {
      boolean var1 = this.omitNullValues;
      String var2 = "";
      StringBuilder var3 = (new StringBuilder(32)).append(this.className).append('{');

      for(MoreObjects$ToStringHelper$ValueHolder var4 = this.holderHead.next; var4 != null; var4 = var4.next) {
         Object var5 = var4.value;
         if(!var1 || var5 != null) {
            var3.append(var2);
            var2 = ", ";
            if(var4.name != null) {
               var3.append(var4.name).append('=');
            }

            if(var5 != null && var5.getClass().isArray()) {
               Object[] var6 = new Object[]{var5};
               String var7 = Arrays.deepToString(var6);
               var3.append(var7.substring(1, var7.length() - 1));
            } else {
               var3.append(var5);
            }
         }
      }

      return var3.append('}').toString();
   }

   private MoreObjects$ToStringHelper$ValueHolder addHolder() {
      MoreObjects$ToStringHelper$ValueHolder var1 = new MoreObjects$ToStringHelper$ValueHolder((MoreObjects$1)null);
      this.holderTail = this.holderTail.next = var1;
      return var1;
   }

   private MoreObjects$ToStringHelper addHolder(@Nullable Object var1) {
      MoreObjects$ToStringHelper$ValueHolder var2 = this.addHolder();
      var2.value = var1;
      return this;
   }

   private MoreObjects$ToStringHelper addHolder(String var1, @Nullable Object var2) {
      MoreObjects$ToStringHelper$ValueHolder var3 = this.addHolder();
      var3.value = var2;
      var3.name = (String)Preconditions.checkNotNull(var1);
      return this;
   }

   // $FF: synthetic method
   MoreObjects$ToStringHelper(String var1, MoreObjects$1 var2) {
      this(var1);
   }
}
