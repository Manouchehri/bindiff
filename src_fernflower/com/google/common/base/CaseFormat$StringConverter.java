package com.google.common.base;

import com.google.common.base.CaseFormat;
import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import javax.annotation.Nullable;

final class CaseFormat$StringConverter extends Converter implements Serializable {
   private final CaseFormat sourceFormat;
   private final CaseFormat targetFormat;
   private static final long serialVersionUID = 0L;

   CaseFormat$StringConverter(CaseFormat var1, CaseFormat var2) {
      this.sourceFormat = (CaseFormat)Preconditions.checkNotNull(var1);
      this.targetFormat = (CaseFormat)Preconditions.checkNotNull(var2);
   }

   protected String doForward(String var1) {
      return this.sourceFormat.to(this.targetFormat, var1);
   }

   protected String doBackward(String var1) {
      return this.targetFormat.to(this.sourceFormat, var1);
   }

   public boolean equals(@Nullable Object var1) {
      if(!(var1 instanceof CaseFormat$StringConverter)) {
         return false;
      } else {
         CaseFormat$StringConverter var2 = (CaseFormat$StringConverter)var1;
         return this.sourceFormat.equals(var2.sourceFormat) && this.targetFormat.equals(var2.targetFormat);
      }
   }

   public int hashCode() {
      return this.sourceFormat.hashCode() ^ this.targetFormat.hashCode();
   }

   public String toString() {
      String var1 = String.valueOf(this.sourceFormat);
      String var2 = String.valueOf(this.targetFormat);
      return (new StringBuilder(14 + String.valueOf(var1).length() + String.valueOf(var2).length())).append(var1).append(".converterTo(").append(var2).append(")").toString();
   }
}
