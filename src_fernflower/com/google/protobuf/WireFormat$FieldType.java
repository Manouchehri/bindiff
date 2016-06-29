package com.google.protobuf;

import com.google.protobuf.WireFormat$1;
import com.google.protobuf.WireFormat$FieldType$1;
import com.google.protobuf.WireFormat$FieldType$2;
import com.google.protobuf.WireFormat$FieldType$3;
import com.google.protobuf.WireFormat$FieldType$4;
import com.google.protobuf.WireFormat$JavaType;

public enum WireFormat$FieldType {
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

   private final WireFormat$JavaType javaType;
   private final int wireType;

   private WireFormat$FieldType(WireFormat$JavaType var3, int var4) {
      this.javaType = var3;
      this.wireType = var4;
   }

   public WireFormat$JavaType getJavaType() {
      return this.javaType;
   }

   public int getWireType() {
      return this.wireType;
   }

   public boolean isPackable() {
      return true;
   }

   // $FF: synthetic method
   WireFormat$FieldType(WireFormat$JavaType var3, int var4, WireFormat$1 var5) {
      this(var3, var4);
   }

   static {
      DOUBLE = new WireFormat$FieldType("DOUBLE", 0, WireFormat$JavaType.DOUBLE, 1);
      FLOAT = new WireFormat$FieldType("FLOAT", 1, WireFormat$JavaType.FLOAT, 5);
      INT64 = new WireFormat$FieldType("INT64", 2, WireFormat$JavaType.LONG, 0);
      UINT64 = new WireFormat$FieldType("UINT64", 3, WireFormat$JavaType.LONG, 0);
      INT32 = new WireFormat$FieldType("INT32", 4, WireFormat$JavaType.INT, 0);
      FIXED64 = new WireFormat$FieldType("FIXED64", 5, WireFormat$JavaType.LONG, 1);
      FIXED32 = new WireFormat$FieldType("FIXED32", 6, WireFormat$JavaType.INT, 5);
      BOOL = new WireFormat$FieldType("BOOL", 7, WireFormat$JavaType.BOOLEAN, 0);
      STRING = new WireFormat$FieldType$1("STRING", 8, WireFormat$JavaType.STRING, 2);
      GROUP = new WireFormat$FieldType$2("GROUP", 9, WireFormat$JavaType.MESSAGE, 3);
      MESSAGE = new WireFormat$FieldType$3("MESSAGE", 10, WireFormat$JavaType.MESSAGE, 2);
      BYTES = new WireFormat$FieldType$4("BYTES", 11, WireFormat$JavaType.BYTE_STRING, 2);
      UINT32 = new WireFormat$FieldType("UINT32", 12, WireFormat$JavaType.INT, 0);
      ENUM = new WireFormat$FieldType("ENUM", 13, WireFormat$JavaType.ENUM, 0);
      SFIXED32 = new WireFormat$FieldType("SFIXED32", 14, WireFormat$JavaType.INT, 5);
      SFIXED64 = new WireFormat$FieldType("SFIXED64", 15, WireFormat$JavaType.LONG, 1);
      SINT32 = new WireFormat$FieldType("SINT32", 16, WireFormat$JavaType.INT, 0);
      SINT64 = new WireFormat$FieldType("SINT64", 17, WireFormat$JavaType.LONG, 0);
   }
}
