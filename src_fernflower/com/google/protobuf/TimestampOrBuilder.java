package com.google.protobuf;

import com.google.protobuf.MessageOrBuilder;

public interface TimestampOrBuilder extends MessageOrBuilder {
   long getSeconds();

   int getNanos();
}
