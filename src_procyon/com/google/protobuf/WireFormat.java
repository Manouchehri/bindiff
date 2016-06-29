package com.google.protobuf;

public final class WireFormat
{
    public static final int WIRETYPE_VARINT = 0;
    public static final int WIRETYPE_FIXED64 = 1;
    public static final int WIRETYPE_LENGTH_DELIMITED = 2;
    public static final int WIRETYPE_START_GROUP = 3;
    public static final int WIRETYPE_END_GROUP = 4;
    public static final int WIRETYPE_FIXED32 = 5;
    static final int TAG_TYPE_BITS = 3;
    static final int TAG_TYPE_MASK = 7;
    static final int MESSAGE_SET_ITEM = 1;
    static final int MESSAGE_SET_TYPE_ID = 2;
    static final int MESSAGE_SET_MESSAGE = 3;
    static final int MESSAGE_SET_ITEM_TAG;
    static final int MESSAGE_SET_ITEM_END_TAG;
    static final int MESSAGE_SET_TYPE_ID_TAG;
    static final int MESSAGE_SET_MESSAGE_TAG;
    
    static int getTagWireType(final int n) {
        return n & 0x7;
    }
    
    public static int getTagFieldNumber(final int n) {
        return n >>> 3;
    }
    
    static int makeTag(final int n, final int n2) {
        return n << 3 | n2;
    }
    
    static Object readPrimitiveField(final CodedInputStream codedInputStream, final WireFormat$FieldType wireFormat$FieldType, final WireFormat$Utf8Validation wireFormat$Utf8Validation) {
        switch (WireFormat$1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[wireFormat$FieldType.ordinal()]) {
            case 1: {
                return codedInputStream.readDouble();
            }
            case 2: {
                return codedInputStream.readFloat();
            }
            case 3: {
                return codedInputStream.readInt64();
            }
            case 4: {
                return codedInputStream.readUInt64();
            }
            case 5: {
                return codedInputStream.readInt32();
            }
            case 6: {
                return codedInputStream.readFixed64();
            }
            case 7: {
                return codedInputStream.readFixed32();
            }
            case 8: {
                return codedInputStream.readBool();
            }
            case 9: {
                return codedInputStream.readBytes();
            }
            case 10: {
                return codedInputStream.readUInt32();
            }
            case 11: {
                return codedInputStream.readSFixed32();
            }
            case 12: {
                return codedInputStream.readSFixed64();
            }
            case 13: {
                return codedInputStream.readSInt32();
            }
            case 14: {
                return codedInputStream.readSInt64();
            }
            case 15: {
                return wireFormat$Utf8Validation.readString(codedInputStream);
            }
            case 16: {
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            }
            case 17: {
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            }
            case 18: {
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            }
            default: {
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
            }
        }
    }
    
    static {
        MESSAGE_SET_ITEM_TAG = makeTag(1, 3);
        MESSAGE_SET_ITEM_END_TAG = makeTag(1, 4);
        MESSAGE_SET_TYPE_ID_TAG = makeTag(2, 0);
        MESSAGE_SET_MESSAGE_TAG = makeTag(3, 2);
    }
}
