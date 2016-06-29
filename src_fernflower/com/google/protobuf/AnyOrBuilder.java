package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface AnyOrBuilder extends MessageOrBuilder {
   String getTypeUrl();

   ByteString getTypeUrlBytes();

   ByteString getValue();
}
