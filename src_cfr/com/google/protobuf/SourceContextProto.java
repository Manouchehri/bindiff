/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.SourceContextProto$1;
import java.util.List;

public final class SourceContextProto {
    static Descriptors$Descriptor internal_static_google_protobuf_SourceContext_descriptor;
    static GeneratedMessage$FieldAccessorTable internal_static_google_protobuf_SourceContext_fieldAccessorTable;
    private static Descriptors$FileDescriptor descriptor;

    private SourceContextProto() {
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
        String[] arrstring = new String[]{"\n$google/protobuf/source_context.proto\u0012\u000fgoogle.protobuf\"\"\n\rSourceContext\u0012\u0011\n\tfile_name\u0018\u0001 \u0001(\tB1\n\u0013com.google.protobufB\u0012SourceContextProtoP\u0001\u00a2\u0002\u0003GPBb\u0006proto3"};
        SourceContextProto$1 sourceContextProto$1 = new SourceContextProto$1();
        Descriptors$FileDescriptor.internalBuildGeneratedFileFrom(arrstring, new Descriptors$FileDescriptor[0], sourceContextProto$1);
        internal_static_google_protobuf_SourceContext_descriptor = (Descriptors$Descriptor)SourceContextProto.getDescriptor().getMessageTypes().get(0);
        internal_static_google_protobuf_SourceContext_fieldAccessorTable = new GeneratedMessage$FieldAccessorTable(internal_static_google_protobuf_SourceContext_descriptor, new String[]{"FileName"});
    }
}

