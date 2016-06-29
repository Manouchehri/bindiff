/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AnyProto$1;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import java.util.List;

public final class AnyProto {
    static Descriptors$Descriptor internal_static_google_protobuf_Any_descriptor;
    static GeneratedMessage$FieldAccessorTable internal_static_google_protobuf_Any_fieldAccessorTable;
    private static Descriptors$FileDescriptor descriptor;

    private AnyProto() {
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
        String[] arrstring = new String[]{"\n\u0019google/protobuf/any.proto\u0012\u000fgoogle.protobuf\"&\n\u0003Any\u0012\u0010\n\btype_url\u0018\u0001 \u0001(\t\u0012\r\n\u0005value\u0018\u0002 \u0001(\fBC\n\u0013com.google.protobufB\bAnyProtoP\u0001\u00a0\u0001\u0001\u00a2\u0002\u0003GPB\u00aa\u0002\u0016Google.ProtocolBuffersb\u0006proto3"};
        AnyProto$1 anyProto$1 = new AnyProto$1();
        Descriptors$FileDescriptor.internalBuildGeneratedFileFrom(arrstring, new Descriptors$FileDescriptor[0], anyProto$1);
        internal_static_google_protobuf_Any_descriptor = (Descriptors$Descriptor)AnyProto.getDescriptor().getMessageTypes().get(0);
        internal_static_google_protobuf_Any_fieldAccessorTable = new GeneratedMessage$FieldAccessorTable(internal_static_google_protobuf_Any_descriptor, new String[]{"TypeUrl", "Value"});
    }
}

