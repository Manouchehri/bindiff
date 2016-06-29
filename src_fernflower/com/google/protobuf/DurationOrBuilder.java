package com.google.protobuf;

import com.google.protobuf.MessageOrBuilder;

public interface DurationOrBuilder extends MessageOrBuilder {
   long getSeconds();

   int getNanos();
}
