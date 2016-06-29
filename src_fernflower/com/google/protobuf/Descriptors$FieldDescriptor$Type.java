package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$FieldDescriptorProto$Type;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;

public enum Descriptors$FieldDescriptor$Type {
   DOUBLE,
   FLOAT,
   INT64,
   UINT64,
   INT32,
   FIXED64,
   FIXED32,
   BOOL,
   STRING,
   GROUP,
   MESSAGE,
   BYTES,
   UINT32,
   ENUM,
   SFIXED32,
   SFIXED64,
   SINT32,
   SINT64;

   private Descriptors$FieldDescriptor$JavaType javaType;

   private Descriptors$FieldDescriptor$Type(Descriptors$FieldDescriptor$JavaType var3) {
      this.javaType = var3;
   }

   public DescriptorProtos$FieldDescriptorProto$Type toProto() {
      return DescriptorProtos$FieldDescriptorProto$Type.valueOf(this.ordinal() + 1);
   }

   public Descriptors$FieldDescriptor$JavaType getJavaType() {
      return this.javaType;
   }

   public static Descriptors$FieldDescriptor$Type valueOf(DescriptorProtos$FieldDescriptorProto$Type var0) {
      return values()[var0.getNumber() - 1];
   }

   static {
      DOUBLE = new Descriptors$FieldDescriptor$Type("DOUBLE", 0, Descriptors$FieldDescriptor$JavaType.DOUBLE);
      FLOAT = new Descriptors$FieldDescriptor$Type("FLOAT", 1, Descriptors$FieldDescriptor$JavaType.FLOAT);
      INT64 = new Descriptors$FieldDescriptor$Type("INT64", 2, Descriptors$FieldDescriptor$JavaType.LONG);
      UINT64 = new Descriptors$FieldDescriptor$Type("UINT64", 3, Descriptors$FieldDescriptor$JavaType.LONG);
      INT32 = new Descriptors$FieldDescriptor$Type("INT32", 4, Descriptors$FieldDescriptor$JavaType.INT);
      FIXED64 = new Descriptors$FieldDescriptor$Type("FIXED64", 5, Descriptors$FieldDescriptor$JavaType.LONG);
      FIXED32 = new Descriptors$FieldDescriptor$Type("FIXED32", 6, Descriptors$FieldDescriptor$JavaType.INT);
      BOOL = new Descriptors$FieldDescriptor$Type("BOOL", 7, Descriptors$FieldDescriptor$JavaType.BOOLEAN);
      STRING = new Descriptors$FieldDescriptor$Type("STRING", 8, Descriptors$FieldDescriptor$JavaType.STRING);
      GROUP = new Descriptors$FieldDescriptor$Type("GROUP", 9, Descriptors$FieldDescriptor$JavaType.MESSAGE);
      MESSAGE = new Descriptors$FieldDescriptor$Type("MESSAGE", 10, Descriptors$FieldDescriptor$JavaType.MESSAGE);
      BYTES = new Descriptors$FieldDescriptor$Type("BYTES", 11, Descriptors$FieldDescriptor$JavaType.BYTE_STRING);
      UINT32 = new Descriptors$FieldDescriptor$Type("UINT32", 12, Descriptors$FieldDescriptor$JavaType.INT);
      ENUM = new Descriptors$FieldDescriptor$Type("ENUM", 13, Descriptors$FieldDescriptor$JavaType.ENUM);
      SFIXED32 = new Descriptors$FieldDescriptor$Type("SFIXED32", 14, Descriptors$FieldDescriptor$JavaType.INT);
      SFIXED64 = new Descriptors$FieldDescriptor$Type("SFIXED64", 15, Descriptors$FieldDescriptor$JavaType.LONG);
      SINT32 = new Descriptors$FieldDescriptor$Type("SINT32", 16, Descriptors$FieldDescriptor$JavaType.INT);
      SINT64 = new Descriptors$FieldDescriptor$Type("SINT64", 17, Descriptors$FieldDescriptor$JavaType.LONG);
   }
}
