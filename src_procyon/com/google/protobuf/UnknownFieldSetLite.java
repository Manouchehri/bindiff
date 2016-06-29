package com.google.protobuf;

public final class UnknownFieldSetLite
{
    private static final UnknownFieldSetLite DEFAULT_INSTANCE;
    private final ByteString byteString;
    
    public static UnknownFieldSetLite getDefaultInstance() {
        return UnknownFieldSetLite.DEFAULT_INSTANCE;
    }
    
    public static UnknownFieldSetLite$Builder newBuilder() {
        return new UnknownFieldSetLite$Builder(null);
    }
    
    static UnknownFieldSetLite concat(final UnknownFieldSetLite unknownFieldSetLite, final UnknownFieldSetLite unknownFieldSetLite2) {
        return new UnknownFieldSetLite(unknownFieldSetLite.byteString.concat(unknownFieldSetLite2.byteString));
    }
    
    private UnknownFieldSetLite(final ByteString byteString) {
        this.byteString = byteString;
    }
    
    public void writeTo(final CodedOutputStream codedOutputStream) {
        codedOutputStream.writeRawBytes(this.byteString);
    }
    
    public int getSerializedSize() {
        return this.byteString.size();
    }
    
    public boolean equals(final Object o) {
        return this == o || (o instanceof UnknownFieldSetLite && this.byteString.equals(((UnknownFieldSetLite)o).byteString));
    }
    
    public int hashCode() {
        return this.byteString.hashCode();
    }
    
    static {
        DEFAULT_INSTANCE = new UnknownFieldSetLite(ByteString.EMPTY);
    }
}
