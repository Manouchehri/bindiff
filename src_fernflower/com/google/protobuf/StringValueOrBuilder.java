package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface StringValueOrBuilder extends MessageOrBuilder {
   String getValue();

   ByteString getValueBytes();
}
