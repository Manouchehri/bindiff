package com.google.protobuf;

public final class TypeProto
{
    static Descriptors$Descriptor internal_static_google_protobuf_Type_descriptor;
    static GeneratedMessage$FieldAccessorTable internal_static_google_protobuf_Type_fieldAccessorTable;
    static Descriptors$Descriptor internal_static_google_protobuf_Field_descriptor;
    static GeneratedMessage$FieldAccessorTable internal_static_google_protobuf_Field_fieldAccessorTable;
    static Descriptors$Descriptor internal_static_google_protobuf_Enum_descriptor;
    static GeneratedMessage$FieldAccessorTable internal_static_google_protobuf_Enum_fieldAccessorTable;
    static Descriptors$Descriptor internal_static_google_protobuf_EnumValue_descriptor;
    static GeneratedMessage$FieldAccessorTable internal_static_google_protobuf_EnumValue_fieldAccessorTable;
    static Descriptors$Descriptor internal_static_google_protobuf_Option_descriptor;
    static GeneratedMessage$FieldAccessorTable internal_static_google_protobuf_Option_fieldAccessorTable;
    private static Descriptors$FileDescriptor descriptor;
    
    public static void registerAllExtensions(final ExtensionRegistry extensionRegistry) {
    }
    
    public static Descriptors$FileDescriptor getDescriptor() {
        return TypeProto.descriptor;
    }
    
    static {
        Descriptors$FileDescriptor.internalBuildGeneratedFileFrom(new String[] { "\n\u001agoogle/protobuf/type.proto\u0012\u000fgoogle.protobuf\u001a\u0019google/protobuf/any.proto\u001a$google/protobuf/source_context.proto\"�\u0001\n\u0004Type\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012&\n\u0006fields\u0018\u0002 \u0003(\u000b2\u0016.google.protobuf.Field\u0012\u000e\n\u0006oneofs\u0018\u0003 \u0003(\t\u0012(\n\u0007options\u0018\u0004 \u0003(\u000b2\u0017.google.protobuf.Option\u00126\n\u000esource_context\u0018\u0005 \u0001(\u000b2\u001e.google.protobuf.SourceContext\"\u009b\u0005\n\u0005Field\u0012)\n\u0004kind\u0018\u0001 \u0001(\u000e2\u001b.google.protobuf.Field.Kind\u00127\n\u000bcardinality\u0018\u0002 \u0001(\u000e2\".google.protobuf.Field.Cardinality\u0012\u000e\n", "\u0006number\u0018\u0003 \u0001(\u0005\u0012\f\n\u0004name\u0018\u0004 \u0001(\t\u0012\u0010\n\btype_url\u0018\u0006 \u0001(\t\u0012\u0013\n\u000boneof_index\u0018\u0007 \u0001(\u0005\u0012\u000e\n\u0006packed\u0018\b \u0001(\b\u0012(\n\u0007options\u0018\t \u0003(\u000b2\u0017.google.protobuf.Option\"�\u0002\n\u0004Kind\u0012\u0010\n\fTYPE_UNKNOWN\u0010\u0000\u0012\u000f\n\u000bTYPE_DOUBLE\u0010\u0001\u0012\u000e\n\nTYPE_FLOAT\u0010\u0002\u0012\u000e\n\nTYPE_INT64\u0010\u0003\u0012\u000f\n\u000bTYPE_UINT64\u0010\u0004\u0012\u000e\n\nTYPE_INT32\u0010\u0005\u0012\u0010\n\fTYPE_FIXED64\u0010\u0006\u0012\u0010\n\fTYPE_FIXED32\u0010\u0007\u0012\r\n\tTYPE_BOOL\u0010\b\u0012\u000f\n\u000bTYPE_STRING\u0010\t\u0012\u0010\n\fTYPE_MESSAGE\u0010\u000b\u0012\u000e\n\nTYPE_BYTES\u0010\f\u0012\u000f\n\u000bTYPE_UINT32\u0010\r\u0012\r\n\tTYPE_ENUM\u0010\u000e\u0012\u0011\n\rTYPE_SFIXED32\u0010\u000f\u0012\u0011\n\rTYPE_SFIXE", "D64\u0010\u0010\u0012\u000f\n\u000bTYPE_SINT32\u0010\u0011\u0012\u000f\n\u000bTYPE_SINT64\u0010\u0012\"t\n\u000bCardinality\u0012\u0017\n\u0013CARDINALITY_UNKNOWN\u0010\u0000\u0012\u0018\n\u0014CARDINALITY_OPTIONAL\u0010\u0001\u0012\u0018\n\u0014CARDINALITY_REQUIRED\u0010\u0002\u0012\u0018\n\u0014CARDINALITY_REPEATED\u0010\u0003\"�\u0001\n\u0004Enum\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012-\n\tenumvalue\u0018\u0002 \u0003(\u000b2\u001a.google.protobuf.EnumValue\u0012(\n\u0007options\u0018\u0003 \u0003(\u000b2\u0017.google.protobuf.Option\u00126\n\u000esource_context\u0018\u0004 \u0001(\u000b2\u001e.google.protobuf.SourceContext\"S\n\tEnumValue\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u000e\n\u0006number\u0018\u0002 \u0001(\u0005\u0012(\n\u0007options\u0018\u0003 \u0003(\u000b2\u0017.google.proto", "buf.Option\";\n\u0006Option\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012#\n\u0005value\u0018\u0002 \u0001(\u000b2\u0014.google.protobuf.AnyB(\n\u0013com.google.protobufB\tTypeProtoP\u0001�\u0002\u0003GPBb\u0006proto3" }, new Descriptors$FileDescriptor[] { AnyProto.getDescriptor(), SourceContextProto.getDescriptor() }, new TypeProto$1());
        TypeProto.internal_static_google_protobuf_Type_descriptor = getDescriptor().getMessageTypes().get(0);
        TypeProto.internal_static_google_protobuf_Type_fieldAccessorTable = new GeneratedMessage$FieldAccessorTable(TypeProto.internal_static_google_protobuf_Type_descriptor, new String[] { "Name", "Fields", "Oneofs", "Options", "SourceContext" });
        TypeProto.internal_static_google_protobuf_Field_descriptor = getDescriptor().getMessageTypes().get(1);
        TypeProto.internal_static_google_protobuf_Field_fieldAccessorTable = new GeneratedMessage$FieldAccessorTable(TypeProto.internal_static_google_protobuf_Field_descriptor, new String[] { "Kind", "Cardinality", "Number", "Name", "TypeUrl", "OneofIndex", "Packed", "Options" });
        TypeProto.internal_static_google_protobuf_Enum_descriptor = getDescriptor().getMessageTypes().get(2);
        TypeProto.internal_static_google_protobuf_Enum_fieldAccessorTable = new GeneratedMessage$FieldAccessorTable(TypeProto.internal_static_google_protobuf_Enum_descriptor, new String[] { "Name", "Enumvalue", "Options", "SourceContext" });
        TypeProto.internal_static_google_protobuf_EnumValue_descriptor = getDescriptor().getMessageTypes().get(3);
        TypeProto.internal_static_google_protobuf_EnumValue_fieldAccessorTable = new GeneratedMessage$FieldAccessorTable(TypeProto.internal_static_google_protobuf_EnumValue_descriptor, new String[] { "Name", "Number", "Options" });
        TypeProto.internal_static_google_protobuf_Option_descriptor = getDescriptor().getMessageTypes().get(4);
        TypeProto.internal_static_google_protobuf_Option_fieldAccessorTable = new GeneratedMessage$FieldAccessorTable(TypeProto.internal_static_google_protobuf_Option_descriptor, new String[] { "Name", "Value" });
        AnyProto.getDescriptor();
        SourceContextProto.getDescriptor();
    }
}
