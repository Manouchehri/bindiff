package com.google.protobuf;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.WireFormat$1;
import com.google.protobuf.WireFormat$FieldType;
import com.google.protobuf.WireFormat$Utf8Validation;

public final class WireFormat {
   public static final int WIRETYPE_VARINT = 0;
   public static final int WIRETYPE_FIXED64 = 1;
   public static final int WIRETYPE_LENGTH_DELIMITED = 2;
   public static final int WIRETYPE_START_GROUP = 3;
   public static final int WIRETYPE_END_GROUP = 4;
   public static final int WIRETYPE_FIXED32 = 5;
   static final int TAG_TYPE_BITS = 3;
   static final int TAG_TYPE_MASK = 7;
   static final int MESSAGE_SET_ITEM = 1;
   static final int MESSAGE_SET_TYPE_ID = 2;
   static final int MESSAGE_SET_MESSAGE = 3;
   static final int MESSAGE_SET_ITEM_TAG = makeTag(1, 3);
   static final int MESSAGE_SET_ITEM_END_TAG = makeTag(1, 4);
   static final int MESSAGE_SET_TYPE_ID_TAG = makeTag(2, 0);
   static final int MESSAGE_SET_MESSAGE_TAG = makeTag(3, 2);

   static int getTagWireType(int var0) {
      return var0 & 7;
   }

   public static int getTagFieldNumber(int var0) {
      return var0 >>> 3;
   }

   static int makeTag(int var0, int var1) {
      return var0 << 3 | var1;
   }

   static Object readPrimitiveField(CodedInputStream var0, WireFormat$FieldType var1, WireFormat$Utf8Validation var2) {
      switch(WireFormat$1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[var1.ordinal()]) {
      case 1:
         return Double.valueOf(var0.readDouble());
      case 2:
         return Float.valueOf(var0.readFloat());
      case 3:
         return Long.valueOf(var0.readInt64());
      case 4:
         return Long.valueOf(var0.readUInt64());
      case 5:
         return Integer.valueOf(var0.readInt32());
      case 6:
         return Long.valueOf(var0.readFixed64());
      case 7:
         return Integer.valueOf(var0.readFixed32());
      case 8:
         return Boolean.valueOf(var0.readBool());
      case 9:
         return var0.readBytes();
      case 10:
         return Integer.valueOf(var0.readUInt32());
      case 11:
         return Integer.valueOf(var0.readSFixed32());
      case 12:
         return Long.valueOf(var0.readSFixed64());
      case 13:
         return Integer.valueOf(var0.readSInt32());
      case 14:
         return Long.valueOf(var0.readSInt64());
      case 15:
         return var2.readString(var0);
      case 16:
         throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
      case 17:
         throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
      case 18:
         throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
      default:
         throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
      }
   }
}
