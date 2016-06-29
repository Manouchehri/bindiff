package com.google.protobuf;

public final class GeneratedMessage$FieldAccessorTable
{
    private final Descriptors$Descriptor descriptor;
    private final GeneratedMessage$FieldAccessorTable$FieldAccessor[] fields;
    private String[] camelCaseNames;
    private final GeneratedMessage$FieldAccessorTable$OneofAccessor[] oneofs;
    private volatile boolean initialized;
    
    public GeneratedMessage$FieldAccessorTable(final Descriptors$Descriptor descriptors$Descriptor, final String[] array, final Class clazz, final Class clazz2) {
        this(descriptors$Descriptor, array);
        this.ensureFieldAccessorsInitialized(clazz, clazz2);
    }
    
    public GeneratedMessage$FieldAccessorTable(final Descriptors$Descriptor descriptor, final String[] camelCaseNames) {
        this.descriptor = descriptor;
        this.camelCaseNames = camelCaseNames;
        this.fields = new GeneratedMessage$FieldAccessorTable$FieldAccessor[descriptor.getFields().size()];
        this.oneofs = new GeneratedMessage$FieldAccessorTable$OneofAccessor[descriptor.getOneofs().size()];
        this.initialized = false;
    }
    
    private boolean isMapFieldEnabled(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return true;
    }
    
    public GeneratedMessage$FieldAccessorTable ensureFieldAccessorsInitialized(final Class clazz, final Class clazz2) {
        if (this.initialized) {
            return this;
        }
        synchronized (this) {
            if (this.initialized) {
                return this;
            }
            final int length = this.fields.length;
            for (int i = 0; i < length; ++i) {
                final Descriptors$FieldDescriptor descriptors$FieldDescriptor = this.descriptor.getFields().get(i);
                String s = null;
                if (descriptors$FieldDescriptor.getContainingOneof() != null) {
                    s = this.camelCaseNames[length + descriptors$FieldDescriptor.getContainingOneof().getIndex()];
                }
                if (descriptors$FieldDescriptor.isRepeated()) {
                    if (descriptors$FieldDescriptor.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
                        if (descriptors$FieldDescriptor.isMapField() && this.isMapFieldEnabled(descriptors$FieldDescriptor)) {
                            this.fields[i] = new GeneratedMessage$FieldAccessorTable$MapFieldAccessor(descriptors$FieldDescriptor, this.camelCaseNames[i], clazz, clazz2);
                        }
                        else {
                            this.fields[i] = new GeneratedMessage$FieldAccessorTable$RepeatedMessageFieldAccessor(descriptors$FieldDescriptor, this.camelCaseNames[i], clazz, clazz2);
                        }
                    }
                    else if (descriptors$FieldDescriptor.getJavaType() == Descriptors$FieldDescriptor$JavaType.ENUM) {
                        this.fields[i] = new GeneratedMessage$FieldAccessorTable$RepeatedEnumFieldAccessor(descriptors$FieldDescriptor, this.camelCaseNames[i], clazz, clazz2);
                    }
                    else {
                        this.fields[i] = new GeneratedMessage$FieldAccessorTable$RepeatedFieldAccessor(descriptors$FieldDescriptor, this.camelCaseNames[i], clazz, clazz2);
                    }
                }
                else if (descriptors$FieldDescriptor.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
                    this.fields[i] = new GeneratedMessage$FieldAccessorTable$SingularMessageFieldAccessor(descriptors$FieldDescriptor, this.camelCaseNames[i], clazz, clazz2, s);
                }
                else if (descriptors$FieldDescriptor.getJavaType() == Descriptors$FieldDescriptor$JavaType.ENUM) {
                    this.fields[i] = new GeneratedMessage$FieldAccessorTable$SingularEnumFieldAccessor(descriptors$FieldDescriptor, this.camelCaseNames[i], clazz, clazz2, s);
                }
                else if (descriptors$FieldDescriptor.getJavaType() == Descriptors$FieldDescriptor$JavaType.STRING) {
                    this.fields[i] = new GeneratedMessage$FieldAccessorTable$SingularStringFieldAccessor(descriptors$FieldDescriptor, this.camelCaseNames[i], clazz, clazz2, s);
                }
                else {
                    this.fields[i] = new GeneratedMessage$FieldAccessorTable$SingularFieldAccessor(descriptors$FieldDescriptor, this.camelCaseNames[i], clazz, clazz2, s);
                }
            }
            for (int length2 = this.oneofs.length, j = 0; j < length2; ++j) {
                this.oneofs[j] = new GeneratedMessage$FieldAccessorTable$OneofAccessor(this.descriptor, this.camelCaseNames[j + length], clazz, clazz2);
            }
            this.initialized = true;
            this.camelCaseNames = null;
            return this;
        }
    }
    
    private GeneratedMessage$FieldAccessorTable$FieldAccessor getField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        if (descriptors$FieldDescriptor.getContainingType() != this.descriptor) {
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }
        if (descriptors$FieldDescriptor.isExtension()) {
            throw new IllegalArgumentException("This type does not have extensions.");
        }
        return this.fields[descriptors$FieldDescriptor.getIndex()];
    }
    
    private GeneratedMessage$FieldAccessorTable$OneofAccessor getOneof(final Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        if (descriptors$OneofDescriptor.getContainingType() != this.descriptor) {
            throw new IllegalArgumentException("OneofDescriptor does not match message type.");
        }
        return this.oneofs[descriptors$OneofDescriptor.getIndex()];
    }
    
    private static boolean supportFieldPresence(final Descriptors$FileDescriptor descriptors$FileDescriptor) {
        return descriptors$FileDescriptor.getSyntax() == Descriptors$FileDescriptor$Syntax.PROTO2;
    }
}
