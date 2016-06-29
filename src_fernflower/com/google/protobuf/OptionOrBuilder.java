package com.google.protobuf;

import com.google.protobuf.Any;
import com.google.protobuf.AnyOrBuilder;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface OptionOrBuilder extends MessageOrBuilder {
   String getName();

   ByteString getNameBytes();

   boolean hasValue();

   Any getValue();

   AnyOrBuilder getValueOrBuilder();
}
