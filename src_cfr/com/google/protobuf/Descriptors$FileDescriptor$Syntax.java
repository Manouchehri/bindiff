/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

public enum Descriptors$FileDescriptor$Syntax {
    UNKNOWN("unknown"),
    PROTO2("proto2"),
    PROTO3("proto3");
    
    private final String name;

    private Descriptors$FileDescriptor$Syntax(String string2) {
        this.name = string2;
    }

    static /* synthetic */ String access$000(Descriptors$FileDescriptor$Syntax descriptors$FileDescriptor$Syntax) {
        return descriptors$FileDescriptor$Syntax.name;
    }
}

