package com.google.protobuf;

public final class StructProto
{
    static Descriptors$Descriptor internal_static_google_protobuf_Struct_descriptor;
    static GeneratedMessage$FieldAccessorTable internal_static_google_protobuf_Struct_fieldAccessorTable;
    static Descriptors$Descriptor internal_static_google_protobuf_Struct_FieldsEntry_descriptor;
    static GeneratedMessage$FieldAccessorTable internal_static_google_protobuf_Struct_FieldsEntry_fieldAccessorTable;
    static Descriptors$Descriptor internal_static_google_protobuf_Value_descriptor;
    static GeneratedMessage$FieldAccessorTable internal_static_google_protobuf_Value_fieldAccessorTable;
    static Descriptors$Descriptor internal_static_google_protobuf_ListValue_descriptor;
    static GeneratedMessage$FieldAccessorTable internal_static_google_protobuf_ListValue_fieldAccessorTable;
    private static Descriptors$FileDescriptor descriptor;
    
    public static void registerAllExtensions(final ExtensionRegistry extensionRegistry) {
    }
    
    public static Descriptors$FileDescriptor getDescriptor() {
        return StructProto.descriptor;
    }
    
    static {
        Descriptors$FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\u001cgoogle/protobuf/struct.proto\u0012\u000fgoogle.protobuf\"\u0084\u0001\n\u0006Struct\u00123\n\u0006fields\u0018\u0001 \u0003(\u000b2#.google.protobuf.Struct.FieldsEntry\u001aE\n\u000bFieldsEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\t\u0012%\n\u0005value\u0018\u0002 \u0001(\u000b2\u0016.google.protobuf.Value:\u00028\u0001\"\u00ea\u0001\n\u0005Value\u00120\n\nnull_value\u0018\u0001 \u0001(\u000e2\u001a.google.protobuf.NullValueH\u0000\u0012\u0016\n\fnumber_value\u0018\u0002 \u0001(\u0001H\u0000\u0012\u0016\n\fstring_value\u0018\u0003 \u0001(\tH\u0000\u0012\u0014\n\nbool_value\u0018\u0004 \u0001(\bH\u0000\u0012/\n\fstruct_value\u0018\u0005 \u0001(\u000b2\u0017.google.protobuf.StructH\u0000\u00120\n\nlist_value\u0018\u0006 \u0001(\u000b2\u001a.google.protobuf.", "ListValueH\u0000B\u0006\n\u0004kind\"3\n\tListValue\u0012&\n\u0006values\u0018\u0001 \u0003(\u000b2\u0016.google.protobuf.Value*\u001b\n\tNullValue\u0012\u000e\n\nNULL_VALUE\u0010\u0000BF\n\u0013com.google.protobufB\u000bStructProtoP\u0001 \u0001\u0001¢\u0002\u0003GPBª\u0002\u0016Google.ProtocolBuffersb\u0006proto3" }, new Descriptors$FileDescriptor[0], new StructProto$1());
        StructProto.internal_static_google_protobuf_Struct_descriptor = getDescriptor().getMessageTypes().get(0);
        StructProto.internal_static_google_protobuf_Struct_fieldAccessorTable = new GeneratedMessage$FieldAccessorTable(StructProto.internal_static_google_protobuf_Struct_descriptor, new String[] { "Fields" });
        StructProto.internal_static_google_protobuf_Struct_FieldsEntry_descriptor = StructProto.internal_static_google_protobuf_Struct_descriptor.getNestedTypes().get(0);
        StructProto.internal_static_google_protobuf_Struct_FieldsEntry_fieldAccessorTable = new GeneratedMessage$FieldAccessorTable(StructProto.internal_static_google_protobuf_Struct_FieldsEntry_descriptor, new String[] { "Key", "Value" });
        StructProto.internal_static_google_protobuf_Value_descriptor = getDescriptor().getMessageTypes().get(1);
        StructProto.internal_static_google_protobuf_Value_fieldAccessorTable = new GeneratedMessage$FieldAccessorTable(StructProto.internal_static_google_protobuf_Value_descriptor, new String[] { "NullValue", "NumberValue", "StringValue", "BoolValue", "StructValue", "ListValue", "Kind" });
        StructProto.internal_static_google_protobuf_ListValue_descriptor = getDescriptor().getMessageTypes().get(2);
        StructProto.internal_static_google_protobuf_ListValue_fieldAccessorTable = new GeneratedMessage$FieldAccessorTable(StructProto.internal_static_google_protobuf_ListValue_descriptor, new String[] { "Values" });
    }
}
