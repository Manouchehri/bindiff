/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.EmptyProto$1;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import java.util.List;

public final class EmptyProto {
    static Descriptors$Descriptor internal_static_google_protobuf_Empty_descriptor;
    static GeneratedMessage$FieldAccessorTable internal_static_google_protobuf_Empty_fieldAccessorTable;
    private static Descriptors$FileDescriptor descriptor;

    private EmptyProto() {
    }

    public static void registerAllExtensions(ExtensionRegistry extensionRegistry) {
    }

    public static Descriptors$FileDescriptor getDescriptor() {
        return descriptor;
    }

    static /* synthetic */ Descriptors$FileDescriptor access$002(Descriptors$FileDescriptor descriptors$FileDescriptor) {
        descriptor = descriptors$FileDescriptor;
        return descriptor;
    }

    static {
        String[] arrstring = new String[]{"\n\u001bgoogle/protobuf/empty.proto\u0012\u000fgoogle.protobuf\"\u0007\n\u0005EmptyB)\n\u0013com.google.protobufB\nEmptyProtoP\u0001\u00a2\u0002\u0003GPBb\u0006proto3"};
        EmptyProto$1 emptyProto$1 = new EmptyProto$1();
        Descriptors$FileDescriptor.internalBuildGeneratedFileFrom(arrstring, new Descriptors$FileDescriptor[0], emptyProto$1);
        internal_static_google_protobuf_Empty_descriptor = (Descriptors$Descriptor)EmptyProto.getDescriptor().getMessageTypes().get(0);
        internal_static_google_protobuf_Empty_fieldAccessorTable = new GeneratedMessage$FieldAccessorTable(internal_static_google_protobuf_Empty_descriptor, new String[0]);
    }
}

