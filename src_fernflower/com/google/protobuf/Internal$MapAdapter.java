package com.google.protobuf;

import com.google.protobuf.Internal$EnumLite;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.Internal$MapAdapter$1;
import com.google.protobuf.Internal$MapAdapter$Converter;
import com.google.protobuf.Internal$MapAdapter$SetAdapter;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

public class Internal$MapAdapter extends AbstractMap {
   private final Map realMap;
   private final Internal$MapAdapter$Converter valueConverter;

   public static Internal$MapAdapter$Converter newEnumConverter(Internal$EnumLiteMap var0, Internal$EnumLite var1) {
      return new Internal$MapAdapter$1(var0, var1);
   }

   public Internal$MapAdapter(Map var1, Internal$MapAdapter$Converter var2) {
      this.realMap = var1;
      this.valueConverter = var2;
   }

   public Object get(Object var1) {
      Object var2 = this.realMap.get(var1);
      return var2 == null?null:this.valueConverter.doForward(var2);
   }

   public Object put(Object var1, Object var2) {
      Object var3 = this.realMap.put(var1, this.valueConverter.doBackward(var2));
      return var3 == null?null:this.valueConverter.doForward(var3);
   }

   public Set entrySet() {
      return new Internal$MapAdapter$SetAdapter(this, this.realMap.entrySet());
   }

   // $FF: synthetic method
   static Internal$MapAdapter$Converter access$000(Internal$MapAdapter var0) {
      return var0.valueConverter;
   }
}
