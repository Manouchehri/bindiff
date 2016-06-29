package com.google.protobuf;

import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;

public interface Message extends MessageLite, MessageOrBuilder {
   Parser getParserForType();

   boolean equals(Object var1);

   int hashCode();

   String toString();

   Message$Builder newBuilderForType();

   Message$Builder toBuilder();
}
