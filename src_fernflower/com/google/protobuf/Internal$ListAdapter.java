package com.google.protobuf;

import com.google.protobuf.Internal$ListAdapter$Converter;
import java.util.AbstractList;
import java.util.List;

public class Internal$ListAdapter extends AbstractList {
   private final List fromList;
   private final Internal$ListAdapter$Converter converter;

   public Internal$ListAdapter(List var1, Internal$ListAdapter$Converter var2) {
      this.fromList = var1;
      this.converter = var2;
   }

   public Object get(int var1) {
      return this.converter.convert(this.fromList.get(var1));
   }

   public int size() {
      return this.fromList.size();
   }
}
