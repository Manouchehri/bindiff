package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.ListValue;
import com.google.protobuf.ListValueOrBuilder;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.NullValue;
import com.google.protobuf.Struct;
import com.google.protobuf.StructOrBuilder;

public interface ValueOrBuilder extends MessageOrBuilder {
   int getNullValueValue();

   NullValue getNullValue();

   double getNumberValue();

   String getStringValue();

   ByteString getStringValueBytes();

   boolean getBoolValue();

   Struct getStructValue();

   StructOrBuilder getStructValueOrBuilder();

   ListValue getListValue();

   ListValueOrBuilder getListValueOrBuilder();
}
