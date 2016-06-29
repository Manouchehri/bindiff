package com.google.common.base;

import com.google.common.base.Objects$1;
import com.google.common.base.Objects$ToStringHelper$ValueHolder;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

@Deprecated
public final class Objects$ToStringHelper {
   private final String className;
   private Objects$ToStringHelper$ValueHolder holderHead;
   private Objects$ToStringHelper$ValueHolder holderTail;
   private boolean omitNullValues;

   private Objects$ToStringHelper(String var1) {
      this.holderHead = new Objects$ToStringHelper$ValueHolder((Objects$1)null);
      this.holderTail = this.holderHead;
      this.omitNullValues = false;
      this.className = (String)Preconditions.checkNotNull(var1);
   }

   public Objects$ToStringHelper omitNullValues() {
      this.omitNullValues = true;
      return this;
   }

   public Objects$ToStringHelper add(String var1, @Nullable Object var2) {
      return this.addHolder(var1, var2);
   }

   public Objects$ToStringHelper add(String var1, boolean var2) {
      return this.addHolder(var1, String.valueOf(var2));
   }

   public Objects$ToStringHelper add(String var1, char var2) {
      return this.addHolder(var1, String.valueOf(var2));
   }

   public Objects$ToStringHelper add(String var1, double var2) {
      return this.addHolder(var1, String.valueOf(var2));
   }

   public Objects$ToStringHelper add(String var1, float var2) {
      return this.addHolder(var1, String.valueOf(var2));
   }

   public Objects$ToStringHelper add(String var1, int var2) {
      return this.addHolder(var1, String.valueOf(var2));
   }

   public Objects$ToStringHelper add(String var1, long var2) {
      return this.addHolder(var1, String.valueOf(var2));
   }

   public Objects$ToStringHelper addValue(@Nullable Object var1) {
      return this.addHolder(var1);
   }

   public Objects$ToStringHelper addValue(boolean var1) {
      return this.addHolder(String.valueOf(var1));
   }

   public Objects$ToStringHelper addValue(char var1) {
      return this.addHolder(String.valueOf(var1));
   }

   public Objects$ToStringHelper addValue(double var1) {
      return this.addHolder(String.valueOf(var1));
   }

   public Objects$ToStringHelper addValue(float var1) {
      return this.addHolder(String.valueOf(var1));
   }

   public Objects$ToStringHelper addValue(int var1) {
      return this.addHolder(String.valueOf(var1));
   }

   public Objects$ToStringHelper addValue(long var1) {
      return this.addHolder(String.valueOf(var1));
   }

   public String toString() {
      boolean var1 = this.omitNullValues;
      String var2 = "";
      StringBuilder var3 = (new StringBuilder(32)).append(this.className).append('{');

      for(Objects$ToStringHelper$ValueHolder var4 = this.holderHead.next; var4 != null; var4 = var4.next) {
         if(!var1 || var4.value != null) {
            var3.append(var2);
            var2 = ", ";
            if(var4.name != null) {
               var3.append(var4.name).append('=');
            }

            var3.append(var4.value);
         }
      }

      return var3.append('}').toString();
   }

   private Objects$ToStringHelper$ValueHolder addHolder() {
      Objects$ToStringHelper$ValueHolder var1 = new Objects$ToStringHelper$ValueHolder((Objects$1)null);
      this.holderTail = this.holderTail.next = var1;
      return var1;
   }

   private Objects$ToStringHelper addHolder(@Nullable Object var1) {
      Objects$ToStringHelper$ValueHolder var2 = this.addHolder();
      var2.value = var1;
      return this;
   }

   private Objects$ToStringHelper addHolder(String var1, @Nullable Object var2) {
      Objects$ToStringHelper$ValueHolder var3 = this.addHolder();
      var3.value = var2;
      var3.name = (String)Preconditions.checkNotNull(var1);
      return this;
   }

   // $FF: synthetic method
   Objects$ToStringHelper(String var1, Objects$1 var2) {
      this(var1);
   }
}
