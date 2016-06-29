package com.google.protobuf;

import com.google.protobuf.Internal$EnumLite;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.Internal$MapAdapter$Converter;

final class Internal$MapAdapter$1 implements Internal$MapAdapter$Converter {
   // $FF: synthetic field
   final Internal$EnumLiteMap val$enumMap;
   // $FF: synthetic field
   final Internal$EnumLite val$unrecognizedValue;

   Internal$MapAdapter$1(Internal$EnumLiteMap var1, Internal$EnumLite var2) {
      this.val$enumMap = var1;
      this.val$unrecognizedValue = var2;
   }

   public Internal$EnumLite doForward(Integer var1) {
      Internal$EnumLite var2 = this.val$enumMap.findValueByNumber(var1.intValue());
      return var2 == null?this.val$unrecognizedValue:var2;
   }

   public Integer doBackward(Internal$EnumLite var1) {
      return Integer.valueOf(var1.getNumber());
   }
}
