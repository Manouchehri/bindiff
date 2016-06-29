package com.google.protobuf;

import java.io.*;
import java.util.*;

public final class UnknownFieldSet implements MessageLite
{
    private static final UnknownFieldSet defaultInstance;
    private Map fields;
    private static final UnknownFieldSet$Parser PARSER;
    
    private UnknownFieldSet() {
    }
    
    public static UnknownFieldSet$Builder newBuilder() {
        return create();
    }
    
    public static UnknownFieldSet$Builder newBuilder(final UnknownFieldSet set) {
        return newBuilder().mergeFrom(set);
    }
    
    public static UnknownFieldSet getDefaultInstance() {
        return UnknownFieldSet.defaultInstance;
    }
    
    public UnknownFieldSet getDefaultInstanceForType() {
        return UnknownFieldSet.defaultInstance;
    }
    
    private UnknownFieldSet(final Map fields) {
        this.fields = fields;
    }
    
    public boolean equals(final Object o) {
        return this == o || (o instanceof UnknownFieldSet && this.fields.equals(((UnknownFieldSet)o).fields));
    }
    
    public int hashCode() {
        return this.fields.hashCode();
    }
    
    public Map asMap() {
        return this.fields;
    }
    
    public boolean hasField(final int n) {
        return this.fields.containsKey(n);
    }
    
    public UnknownFieldSet$Field getField(final int n) {
        final UnknownFieldSet$Field unknownFieldSet$Field = this.fields.get(n);
        return (unknownFieldSet$Field == null) ? UnknownFieldSet$Field.getDefaultInstance() : unknownFieldSet$Field;
    }
    
    public void writeTo(final CodedOutputStream codedOutputStream) {
        for (final Map.Entry<K, UnknownFieldSet$Field> entry : this.fields.entrySet()) {
            entry.getValue().writeTo((int)entry.getKey(), codedOutputStream);
        }
    }
    
    public String toString() {
        return TextFormat.printToString(this);
    }
    
    public ByteString toByteString() {
        try {
            final ByteString$CodedBuilder codedBuilder = ByteString.newCodedBuilder(this.getSerializedSize());
            this.writeTo(codedBuilder.getCodedOutput());
            return codedBuilder.build();
        }
        catch (IOException ex) {
            throw new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", ex);
        }
    }
    
    public byte[] toByteArray() {
        try {
            final byte[] array = new byte[this.getSerializedSize()];
            final CodedOutputStream instance = CodedOutputStream.newInstance(array);
            this.writeTo(instance);
            instance.checkNoSpaceLeft();
            return array;
        }
        catch (IOException ex) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", ex);
        }
    }
    
    public void writeTo(final OutputStream outputStream) {
        final CodedOutputStream instance = CodedOutputStream.newInstance(outputStream);
        this.writeTo(instance);
        instance.flush();
    }
    
    public void writeDelimitedTo(final OutputStream outputStream) {
        final CodedOutputStream instance = CodedOutputStream.newInstance(outputStream);
        instance.writeRawVarint32(this.getSerializedSize());
        this.writeTo(instance);
        instance.flush();
    }
    
    public int getSerializedSize() {
        int n = 0;
        for (final Map.Entry<K, UnknownFieldSet$Field> entry : this.fields.entrySet()) {
            n += entry.getValue().getSerializedSize((int)entry.getKey());
        }
        return n;
    }
    
    public void writeAsMessageSetTo(final CodedOutputStream codedOutputStream) {
        for (final Map.Entry<K, UnknownFieldSet$Field> entry : this.fields.entrySet()) {
            entry.getValue().writeAsMessageSetExtensionTo((int)entry.getKey(), codedOutputStream);
        }
    }
    
    public int getSerializedSizeAsMessageSet() {
        int n = 0;
        for (final Map.Entry<K, UnknownFieldSet$Field> entry : this.fields.entrySet()) {
            n += entry.getValue().getSerializedSizeAsMessageSetExtension((int)entry.getKey());
        }
        return n;
    }
    
    public boolean isInitialized() {
        return true;
    }
    
    public static UnknownFieldSet parseFrom(final CodedInputStream codedInputStream) {
        return newBuilder().mergeFrom(codedInputStream).build();
    }
    
    public static UnknownFieldSet parseFrom(final ByteString byteString) {
        return newBuilder().mergeFrom(byteString).build();
    }
    
    public static UnknownFieldSet parseFrom(final byte[] array) {
        return newBuilder().mergeFrom(array).build();
    }
    
    public static UnknownFieldSet parseFrom(final InputStream inputStream) {
        return newBuilder().mergeFrom(inputStream).build();
    }
    
    public UnknownFieldSet$Builder newBuilderForType() {
        return newBuilder();
    }
    
    public UnknownFieldSet$Builder toBuilder() {
        return newBuilder().mergeFrom(this);
    }
    
    public final UnknownFieldSet$Parser getParserForType() {
        return UnknownFieldSet.PARSER;
    }
    
    static {
        defaultInstance = new UnknownFieldSet(Collections.emptyMap());
        PARSER = new UnknownFieldSet$Parser();
    }
}
