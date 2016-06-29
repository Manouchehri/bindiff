package com.google.protobuf;

import com.google.protobuf.ByteString;

public enum Descriptors$FieldDescriptor$JavaType {
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

   private Descriptors$FieldDescriptor$JavaType(Object var3) {
      this.defaultDefault = var3;
   }

   // $FF: synthetic method
   static Object access$2200(Descriptors$FieldDescriptor$JavaType var0) {
      return var0.defaultDefault;
   }

   static {
      BYTE_STRING = new Descriptors$FieldDescriptor$JavaType("BYTE_STRING", 6, ByteString.EMPTY);
      ENUM = new Descriptors$FieldDescriptor$JavaType("ENUM", 7, (Object)null);
      MESSAGE = new Descriptors$FieldDescriptor$JavaType("MESSAGE", 8, (Object)null);
   }
}
