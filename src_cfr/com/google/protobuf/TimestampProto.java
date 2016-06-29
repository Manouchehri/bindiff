/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.TimestampProto$1;
import java.util.List;

public final class TimestampProto {
    static Descriptors$Descriptor internal_static_google_protobuf_Timestamp_descriptor;
    static GeneratedMessage$FieldAccessorTable internal_static_google_protobuf_Timestamp_fieldAccessorTable;
    private static Descriptors$FileDescriptor descriptor;

    private TimestampProto() {
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
        String[] arrstring = new String[]{"\n\u001fgoogle/protobuf/timestamp.proto\u0012\u000fgoogle.protobuf\"+\n\tTimestamp\u0012\u000f\n\u0007seconds\u0018\u0001 \u0001(\u0003\u0012\r\n\u0005nanos\u0018\u0002 \u0001(\u0005BI\n\u0013com.google.protobufB\u000eTimestampProtoP\u0001\u00a0\u0001\u0001\u00a2\u0002\u0003GPB\u00aa\u0002\u0016Google.ProtocolBuffersb\u0006proto3"};
        TimestampProto$1 timestampProto$1 = new TimestampProto$1();
        Descriptors$FileDescriptor.internalBuildGeneratedFileFrom(arrstring, new Descriptors$FileDescriptor[0], timestampProto$1);
        internal_static_google_protobuf_Timestamp_descriptor = (Descriptors$Descriptor)TimestampProto.getDescriptor().getMessageTypes().get(0);
        internal_static_google_protobuf_Timestamp_fieldAccessorTable = new GeneratedMessage$FieldAccessorTable(internal_static_google_protobuf_Timestamp_descriptor, new String[]{"Seconds", "Nanos"});
    }
}

