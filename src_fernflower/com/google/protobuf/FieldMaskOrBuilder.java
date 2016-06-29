package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.ProtocolStringList;

public interface FieldMaskOrBuilder extends MessageOrBuilder {
   ProtocolStringList getPathsList();

   int getPathsCount();

   String getPaths(int var1);

   ByteString getPathsBytes(int var1);
}
