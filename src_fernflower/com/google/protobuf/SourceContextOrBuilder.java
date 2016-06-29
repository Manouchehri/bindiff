package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface SourceContextOrBuilder extends MessageOrBuilder {
   String getFileName();

   ByteString getFileNameBytes();
}
