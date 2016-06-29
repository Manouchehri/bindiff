package com.google.protobuf;

import com.google.protobuf.ByteString;

public enum WireFormat$JavaType {
   INT(Integer.valueOf(0)),
   LONG(Long.valueOf(0L)),
   FLOAT(Float.valueOf(0.0F)),
   DOUBLE(Double.valueOf(0.0D)),
   BOOLEAN(Boolean.valueOf(false)),
   STRING(""),
   BYTE_STRING,
   ENUM,
   MESSAGE;

   private final Object defaultDefault;

   private WireFormat$JavaType(Object var3) {
      this.defaultDefault = var3;
   }

   Object getDefaultDefault() {
      return this.defaultDefault;
   }

   static {
      BYTE_STRING = new WireFormat$JavaType("BYTE_STRING", 6, ByteString.EMPTY);
      ENUM = new WireFormat$JavaType("ENUM", 7, (Object)null);
      MESSAGE = new WireFormat$JavaType("MESSAGE", 8, (Object)null);
   }
}
