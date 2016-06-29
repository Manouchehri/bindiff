package com.google.protobuf;

public interface DescriptorProtos$MethodDescriptorProtoOrBuilder extends MessageOrBuilder
{
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
