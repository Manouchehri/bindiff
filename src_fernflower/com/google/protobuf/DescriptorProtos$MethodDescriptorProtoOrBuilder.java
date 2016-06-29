package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos$MethodOptions;
import com.google.protobuf.DescriptorProtos$MethodOptionsOrBuilder;
import com.google.protobuf.MessageOrBuilder;

public interface DescriptorProtos$MethodDescriptorProtoOrBuilder extends MessageOrBuilder {
   boolean hasName();

   String getName();

   ByteString getNameBytes();

   boolean hasInputType();

   String getInputType();

   ByteString getInputTypeBytes();

   boolean hasOutputType();

   String getOutputType();

   ByteString getOutputTypeBytes();

   boolean hasOptions();

   DescriptorProtos$MethodOptions getOptions();

   DescriptorProtos$MethodOptionsOrBuilder getOptionsOrBuilder();

   boolean hasClientStreaming();

   boolean getClientStreaming();

   boolean hasServerStreaming();

   boolean getServerStreaming();
}
