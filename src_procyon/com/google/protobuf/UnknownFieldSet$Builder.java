package com.google.protobuf;

import java.util.*;
import java.io.*;

public final class UnknownFieldSet$Builder implements MessageLite$Builder
{
    private Map fields;
    private int lastFieldNumber;
    private UnknownFieldSet$Field$Builder lastField;
    
    private static UnknownFieldSet$Builder create() {
        final UnknownFieldSet$Builder unknownFieldSet$Builder = new UnknownFieldSet$Builder();
        unknownFieldSet$Builder.reinitialize();
        return unknownFieldSet$Builder;
    }
    
    private UnknownFieldSet$Field$Builder getFieldBuilder(final int lastFieldNumber) {
        if (this.lastField != null) {
            if (lastFieldNumber == this.lastFieldNumber) {
                return this.lastField;
            }
            this.addField(this.lastFieldNumber, this.lastField.build());
        }
        if (lastFieldNumber == 0) {
            return null;
        }
        final UnknownFieldSet$Field unknownFieldSet$Field = this.fields.get(lastFieldNumber);
        this.lastFieldNumber = lastFieldNumber;
        this.lastField = UnknownFieldSet$Field.newBuilder();
        if (unknownFieldSet$Field != null) {
            this.lastField.mergeFrom(unknownFieldSet$Field);
        }
        return this.lastField;
    }
    
    public UnknownFieldSet build() {
        this.getFieldBuilder(0);
        UnknownFieldSet defaultInstance;
        if (this.fields.isEmpty()) {
            defaultInstance = UnknownFieldSet.getDefaultInstance();
        }
        else {
            defaultInstance = new UnknownFieldSet(Collections.unmodifiableMap((Map<?, ?>)this.fields), null);
        }
        this.fields = null;
        return defaultInstance;
    }
    
    public UnknownFieldSet buildPartial() {
        return this.build();
    }
    
    public UnknownFieldSet$Builder clone() {
        this.getFieldBuilder(0);
        return UnknownFieldSet.newBuilder().mergeFrom(new UnknownFieldSet(this.fields, null));
    }
    
    public UnknownFieldSet getDefaultInstanceForType() {
        return UnknownFieldSet.getDefaultInstance();
    }
    
    private void reinitialize() {
        this.fields = Collections.emptyMap();
        this.lastFieldNumber = 0;
        this.lastField = null;
    }
    
    public UnknownFieldSet$Builder clear() {
        this.reinitialize();
        return this;
    }
    
    public UnknownFieldSet$Builder clearField(final int n) {
        if (n == 0) {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        if (this.lastField != null && this.lastFieldNumber == n) {
            this.lastField = null;
            this.lastFieldNumber = 0;
        }
        if (this.fields.containsKey(n)) {
            this.fields.remove(n);
        }
        return this;
    }
    
    public UnknownFieldSet$Builder mergeFrom(final UnknownFieldSet set) {
        if (set != UnknownFieldSet.getDefaultInstance()) {
            for (final Map.Entry<Integer, V> entry : set.fields.entrySet()) {
                this.mergeField(entry.getKey(), (UnknownFieldSet$Field)entry.getValue());
            }
        }
        return this;
    }
    
    public UnknownFieldSet$Builder mergeField(final int n, final UnknownFieldSet$Field unknownFieldSet$Field) {
        if (n == 0) {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        if (this.hasField(n)) {
            this.getFieldBuilder(n).mergeFrom(unknownFieldSet$Field);
        }
        else {
            this.addField(n, unknownFieldSet$Field);
        }
        return this;
    }
    
    public UnknownFieldSet$Builder mergeVarintField(final int n, final int n2) {
        if (n == 0) {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        this.getFieldBuilder(n).addVarint(n2);
        return this;
    }
    
    public UnknownFieldSet$Builder mergeLengthDelimitedField(final int n, final ByteString byteString) {
        if (n == 0) {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        this.getFieldBuilder(n).addLengthDelimited(byteString);
        return this;
    }
    
    public boolean hasField(final int n) {
        if (n == 0) {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        return n == this.lastFieldNumber || this.fields.containsKey(n);
    }
    
    public UnknownFieldSet$Builder addField(final int n, final UnknownFieldSet$Field unknownFieldSet$Field) {
        if (n == 0) {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        if (this.lastField != null && this.lastFieldNumber == n) {
            this.lastField = null;
            this.lastFieldNumber = 0;
        }
        if (this.fields.isEmpty()) {
            this.fields = new TreeMap();
        }
        this.fields.put(n, unknownFieldSet$Field);
        return this;
    }
    
    public Map asMap() {
        this.getFieldBuilder(0);
        return Collections.unmodifiableMap((Map<?, ?>)this.fields);
    }
    
    public UnknownFieldSet$Builder mergeFrom(final CodedInputStream codedInputStream) {
        int tag;
        do {
            tag = codedInputStream.readTag();
        } while (tag != 0 && this.mergeFieldFrom(tag, codedInputStream));
        return this;
    }
    
    public boolean mergeFieldFrom(final int n, final CodedInputStream codedInputStream) {
        final int tagFieldNumber = WireFormat.getTagFieldNumber(n);
        switch (WireFormat.getTagWireType(n)) {
            case 0: {
                this.getFieldBuilder(tagFieldNumber).addVarint(codedInputStream.readInt64());
                return true;
            }
            case 1: {
                this.getFieldBuilder(tagFieldNumber).addFixed64(codedInputStream.readFixed64());
                return true;
            }
            case 2: {
                this.getFieldBuilder(tagFieldNumber).addLengthDelimited(codedInputStream.readBytes());
                return true;
            }
            case 3: {
                final UnknownFieldSet$Builder builder = UnknownFieldSet.newBuilder();
                codedInputStream.readGroup(tagFieldNumber, builder, ExtensionRegistry.getEmptyRegistry());
                this.getFieldBuilder(tagFieldNumber).addGroup(builder.build());
                return true;
            }
            case 4: {
                return false;
            }
            case 5: {
                this.getFieldBuilder(tagFieldNumber).addFixed32(codedInputStream.readFixed32());
                return true;
            }
            default: {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }
    }
    
    public UnknownFieldSet$Builder mergeFrom(final ByteString byteString) {
        try {
            final CodedInputStream codedInput = byteString.newCodedInput();
            this.mergeFrom(codedInput);
            codedInput.checkLastTagWas(0);
            return this;
        }
        catch (InvalidProtocolBufferException ex) {
            throw ex;
        }
        catch (IOException ex2) {
            throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", ex2);
        }
    }
    
    public UnknownFieldSet$Builder mergeFrom(final byte[] array) {
        try {
            final CodedInputStream instance = CodedInputStream.newInstance(array);
            this.mergeFrom(instance);
            instance.checkLastTagWas(0);
            return this;
        }
        catch (InvalidProtocolBufferException ex) {
            throw ex;
        }
        catch (IOException ex2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", ex2);
        }
    }
    
    public UnknownFieldSet$Builder mergeFrom(final InputStream inputStream) {
        final CodedInputStream instance = CodedInputStream.newInstance(inputStream);
        this.mergeFrom(instance);
        instance.checkLastTagWas(0);
        return this;
    }
    
    public boolean mergeDelimitedFrom(final InputStream inputStream) {
        final int read = inputStream.read();
        if (read == -1) {
            return false;
        }
        this.mergeFrom((InputStream)new AbstractMessageLite$Builder$LimitedInputStream(inputStream, CodedInputStream.readRawVarint32(read, inputStream)));
        return true;
    }
    
    public boolean mergeDelimitedFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return this.mergeDelimitedFrom(inputStream);
    }
    
    public UnknownFieldSet$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return this.mergeFrom(codedInputStream);
    }
    
    public UnknownFieldSet$Builder mergeFrom(final ByteString byteString, final ExtensionRegistryLite extensionRegistryLite) {
        return this.mergeFrom(byteString);
    }
    
    public UnknownFieldSet$Builder mergeFrom(final byte[] array, final int n, final int n2) {
        try {
            final CodedInputStream instance = CodedInputStream.newInstance(array, n, n2);
            this.mergeFrom(instance);
            instance.checkLastTagWas(0);
            return this;
        }
        catch (InvalidProtocolBufferException ex) {
            throw ex;
        }
        catch (IOException ex2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", ex2);
        }
    }
    
    public UnknownFieldSet$Builder mergeFrom(final byte[] array, final ExtensionRegistryLite extensionRegistryLite) {
        return this.mergeFrom(array);
    }
    
    public UnknownFieldSet$Builder mergeFrom(final byte[] array, final int n, final int n2, final ExtensionRegistryLite extensionRegistryLite) {
        return this.mergeFrom(array, n, n2);
    }
    
    public UnknownFieldSet$Builder mergeFrom(final InputStream inputStream, final ExtensionRegistryLite extensionRegistryLite) {
        return this.mergeFrom(inputStream);
    }
    
    public boolean isInitialized() {
        return true;
    }
}
