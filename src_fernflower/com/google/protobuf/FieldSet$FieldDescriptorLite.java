package com.google.protobuf;

import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.WireFormat$FieldType;
import com.google.protobuf.WireFormat$JavaType;

public interface FieldSet$FieldDescriptorLite extends Comparable {
   int getNumber();

   WireFormat$FieldType getLiteType();

   WireFormat$JavaType getLiteJavaType();

   boolean isRepeated();

   boolean isPacked();

   Internal$EnumLiteMap getEnumType();

   MessageLite$Builder internalMergeFrom(MessageLite$Builder var1, MessageLite var2);
}
