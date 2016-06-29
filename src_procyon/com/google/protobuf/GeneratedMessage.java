package com.google.protobuf;

import java.io.*;
import java.util.*;
import java.lang.reflect.*;

public abstract class GeneratedMessage extends AbstractMessage implements Serializable
{
    private static final long serialVersionUID = 1L;
    protected static boolean alwaysUseFieldBuilders;
    protected UnknownFieldSet unknownFields;
    
    protected GeneratedMessage() {
        this.unknownFields = UnknownFieldSet.getDefaultInstance();
    }
    
    protected GeneratedMessage(final GeneratedMessage$Builder generatedMessage$Builder) {
        this.unknownFields = generatedMessage$Builder.getUnknownFields();
    }
    
    public Parser getParserForType() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }
    
    static void enableAlwaysUseFieldBuildersForTesting() {
        GeneratedMessage.alwaysUseFieldBuilders = true;
    }
    
    protected abstract GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable();
    
    public Descriptors$Descriptor getDescriptorForType() {
        return this.internalGetFieldAccessorTable().descriptor;
    }
    
    private Map getAllFieldsMutable(final boolean b) {
        final TreeMap<Descriptors$FieldDescriptor, List> treeMap = new TreeMap<Descriptors$FieldDescriptor, List>();
        for (final Descriptors$FieldDescriptor descriptors$FieldDescriptor : this.internalGetFieldAccessorTable().descriptor.getFields()) {
            if (descriptors$FieldDescriptor.isRepeated()) {
                final List list = (List)this.getField(descriptors$FieldDescriptor);
                if (list.isEmpty()) {
                    continue;
                }
                treeMap.put(descriptors$FieldDescriptor, list);
            }
            else {
                if (!this.hasField(descriptors$FieldDescriptor)) {
                    continue;
                }
                if (b && descriptors$FieldDescriptor.getJavaType() == Descriptors$FieldDescriptor$JavaType.STRING) {
                    treeMap.put(descriptors$FieldDescriptor, (List)this.getFieldRaw(descriptors$FieldDescriptor));
                }
                else {
                    treeMap.put(descriptors$FieldDescriptor, (List)this.getField(descriptors$FieldDescriptor));
                }
            }
        }
        return treeMap;
    }
    
    public boolean isInitialized() {
        for (final Descriptors$FieldDescriptor descriptors$FieldDescriptor : this.getDescriptorForType().getFields()) {
            if (descriptors$FieldDescriptor.isRequired() && !this.hasField(descriptors$FieldDescriptor)) {
                return false;
            }
            if (descriptors$FieldDescriptor.getJavaType() != Descriptors$FieldDescriptor$JavaType.MESSAGE) {
                continue;
            }
            if (descriptors$FieldDescriptor.isRepeated()) {
                final Iterator iterator2 = ((List)this.getField(descriptors$FieldDescriptor)).iterator();
                while (iterator2.hasNext()) {
                    if (!iterator2.next().isInitialized()) {
                        return false;
                    }
                }
            }
            else {
                if (this.hasField(descriptors$FieldDescriptor) && !((Message)this.getField(descriptors$FieldDescriptor)).isInitialized()) {
                    return false;
                }
                continue;
            }
        }
        return true;
    }
    
    public Map getAllFields() {
        return Collections.unmodifiableMap((Map<?, ?>)this.getAllFieldsMutable(false));
    }
    
    Map getAllFieldsRaw() {
        return Collections.unmodifiableMap((Map<?, ?>)this.getAllFieldsMutable(true));
    }
    
    public boolean hasOneof(final Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return this.internalGetFieldAccessorTable().getOneof(descriptors$OneofDescriptor).has(this);
    }
    
    public Descriptors$FieldDescriptor getOneofFieldDescriptor(final Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return this.internalGetFieldAccessorTable().getOneof(descriptors$OneofDescriptor).get(this);
    }
    
    public boolean hasField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return this.internalGetFieldAccessorTable().getField(descriptors$FieldDescriptor).has(this);
    }
    
    public Object getField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return this.internalGetFieldAccessorTable().getField(descriptors$FieldDescriptor).get(this);
    }
    
    Object getFieldRaw(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return this.internalGetFieldAccessorTable().getField(descriptors$FieldDescriptor).getRaw(this);
    }
    
    public int getRepeatedFieldCount(final Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return this.internalGetFieldAccessorTable().getField(descriptors$FieldDescriptor).getRepeatedCount(this);
    }
    
    public Object getRepeatedField(final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final int n) {
        return this.internalGetFieldAccessorTable().getField(descriptors$FieldDescriptor).getRepeated(this, n);
    }
    
    public UnknownFieldSet getUnknownFields() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }
    
    protected boolean parseUnknownField(final CodedInputStream codedInputStream, final UnknownFieldSet$Builder unknownFieldSet$Builder, final ExtensionRegistryLite extensionRegistryLite, final int n) {
        return unknownFieldSet$Builder.mergeFieldFrom(n, codedInputStream);
    }
    
    public void writeTo(final CodedOutputStream codedOutputStream) {
        MessageReflection.writeMessageTo(this, this.getAllFieldsRaw(), codedOutputStream, false);
    }
    
    public int getSerializedSize() {
        final int memoizedSize = this.memoizedSize;
        if (memoizedSize != -1) {
            return memoizedSize;
        }
        return this.memoizedSize = MessageReflection.getSerializedSize(this, this.getAllFieldsRaw());
    }
    
    protected void makeExtensionsImmutable() {
    }
    
    protected abstract Message$Builder newBuilderForType(final GeneratedMessage$BuilderParent p0);
    
    public static GeneratedMessage$GeneratedExtension newMessageScopedGeneratedExtension(final Message message, final int n, final Class clazz, final Message message2) {
        return new GeneratedMessage$GeneratedExtension(new GeneratedMessage$1(message, n), clazz, message2, Extension$ExtensionType.IMMUTABLE);
    }
    
    public static GeneratedMessage$GeneratedExtension newFileScopedGeneratedExtension(final Class clazz, final Message message) {
        return new GeneratedMessage$GeneratedExtension(null, clazz, message, Extension$ExtensionType.IMMUTABLE);
    }
    
    public static GeneratedMessage$GeneratedExtension newMessageScopedGeneratedExtension(final Message message, final String s, final Class clazz, final Message message2) {
        return new GeneratedMessage$GeneratedExtension(new GeneratedMessage$2(message, s), clazz, message2, Extension$ExtensionType.MUTABLE);
    }
    
    public static GeneratedMessage$GeneratedExtension newFileScopedGeneratedExtension(final Class clazz, final Message message, final String s, final String s2) {
        return new GeneratedMessage$GeneratedExtension(new GeneratedMessage$3(clazz, s, s2), clazz, message, Extension$ExtensionType.MUTABLE);
    }
    
    private static Method getMethodOrDie(final Class clazz, final String s, final Class... array) {
        try {
            return clazz.getMethod(s, (Class[])array);
        }
        catch (NoSuchMethodException ex) {
            final String value = String.valueOf(String.valueOf(clazz.getName()));
            final String value2 = String.valueOf(String.valueOf(s));
            throw new RuntimeException(new StringBuilder(45 + value.length() + value2.length()).append("Generated message class \"").append(value).append("\" missing method \"").append(value2).append("\".").toString(), ex);
        }
    }
    
    private static Object invokeOrDie(final Method method, final Object o, final Object... array) {
        try {
            return method.invoke(o, array);
        }
        catch (IllegalAccessException ex) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", ex);
        }
        catch (InvocationTargetException ex2) {
            final Throwable cause = ex2.getCause();
            if (cause instanceof RuntimeException) {
                throw (RuntimeException)cause;
            }
            if (cause instanceof Error) {
                throw (Error)cause;
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }
    
    protected MapField internalGetMapField(final int n) {
        final String s = "No map fields found in ";
        final String value = String.valueOf(this.getClass().getName());
        throw new RuntimeException((value.length() != 0) ? s.concat(value) : new String(s));
    }
    
    protected Object writeReplace() {
        return new GeneratedMessageLite$SerializedForm(this);
    }
    
    private static Extension checkNotLite(final ExtensionLite extensionLite) {
        if (extensionLite.isLite()) {
            throw new IllegalArgumentException("Expected non-lite extension.");
        }
        return (Extension)extensionLite;
    }
    
    static {
        GeneratedMessage.alwaysUseFieldBuilders = false;
    }
}
