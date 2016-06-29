package com.google.protobuf;

public enum Descriptors$FileDescriptor$Syntax
{
    UNKNOWN("UNKNOWN", 0, "unknown"), 
    PROTO2("PROTO2", 1, "proto2"), 
    PROTO3("PROTO3", 2, "proto3");
    
    private final String name;
    
    private Descriptors$FileDescriptor$Syntax(final String s, final int n, final String name) {
        this.name = name;
    }
}
