package com.google.protobuf;

import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.concurrent.*;

public abstract class GeneratedMessageLite extends AbstractMessageLite implements Serializable
{
    private static final Map PROTOTYPE_MAP;
    private static final long serialVersionUID = 1L;
    protected UnknownFieldSetLite unknownFields;
    protected int memoizedSerializedSize;
    
    public GeneratedMessageLite() {
        this.unknownFields = UnknownFieldSetLite.getDefaultInstance();
        this.memoizedSerializedSize = -1;
    }
    
    protected static void onLoad(final Class clazz, final GeneratedMessageLite$PrototypeHolder generatedMessageLite$PrototypeHolder) {
        GeneratedMessageLite.PROTOTYPE_MAP.put(clazz, generatedMessageLite$PrototypeHolder);
    }
    
    public final Parser getParserForType() {
        return GeneratedMessageLite.PROTOTYPE_MAP.get(this.getClass()).getParserForType();
    }
    
    public final GeneratedMessageLite getDefaultInstanceForType() {
        return GeneratedMessageLite.PROTOTYPE_MAP.get(this.getClass()).getDefaultInstanceForType();
    }
    
    public final GeneratedMessageLite$Builder newBuilderForType() {
        return GeneratedMessageLite.PROTOTYPE_MAP.get(this.getClass()).newBuilderForType();
    }
    
    protected static boolean parseUnknownField(final CodedInputStream codedInputStream, final UnknownFieldSetLite$Builder unknownFieldSetLite$Builder, final ExtensionRegistryLite extensionRegistryLite, final int n) {
        return unknownFieldSetLite$Builder.mergeFieldFrom(n, codedInputStream);
    }
    
    public final boolean isInitialized() {
        return this.dynamicMethod(GeneratedMessageLite$MethodToInvoke.IS_INITIALIZED, Boolean.TRUE) != null;
    }
    
    public final GeneratedMessageLite$Builder toBuilder() {
        final GeneratedMessageLite$Builder generatedMessageLite$Builder = (GeneratedMessageLite$Builder)this.dynamicMethod(GeneratedMessageLite$MethodToInvoke.NEW_BUILDER, new Object[0]);
        generatedMessageLite$Builder.mergeFrom(this);
        return generatedMessageLite$Builder;
    }
    
    protected abstract Object dynamicMethod(final GeneratedMessageLite$MethodToInvoke p0, final Object... p1);
    
    protected final void mergeUnknownFields(final UnknownFieldSetLite unknownFieldSetLite) {
        this.unknownFields = UnknownFieldSetLite.concat(this.unknownFields, unknownFieldSetLite);
    }
    
    protected static boolean parseUnknownField(final FieldSet set, final MessageLite messageLite, final CodedInputStream codedInputStream, final UnknownFieldSetLite$Builder unknownFieldSetLite$Builder, final ExtensionRegistryLite extensionRegistryLite, final int n) {
        final int tagWireType = WireFormat.getTagWireType(n);
        final int tagFieldNumber = WireFormat.getTagFieldNumber(n);
        final GeneratedMessageLite$GeneratedExtension liteExtensionByNumber = extensionRegistryLite.findLiteExtensionByNumber(messageLite, tagFieldNumber);
        boolean b = false;
        boolean b2 = false;
        if (liteExtensionByNumber == null) {
            b = true;
        }
        else if (tagWireType == FieldSet.getWireFormatForFieldType(liteExtensionByNumber.descriptor.getLiteType(), false)) {
            b2 = false;
        }
        else if (liteExtensionByNumber.descriptor.isRepeated && liteExtensionByNumber.descriptor.type.isPackable() && tagWireType == FieldSet.getWireFormatForFieldType(liteExtensionByNumber.descriptor.getLiteType(), true)) {
            b2 = true;
        }
        else {
            b = true;
        }
        if (b) {
            return unknownFieldSetLite$Builder.mergeFieldFrom(n, codedInputStream);
        }
        if (b2) {
            final int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
            if (liteExtensionByNumber.descriptor.getLiteType() == WireFormat$FieldType.ENUM) {
                while (codedInputStream.getBytesUntilLimit() > 0) {
                    final Internal$EnumLite valueByNumber = liteExtensionByNumber.descriptor.getEnumType().findValueByNumber(codedInputStream.readEnum());
                    if (valueByNumber == null) {
                        return true;
                    }
                    set.addRepeatedField(liteExtensionByNumber.descriptor, liteExtensionByNumber.singularToFieldSetType(valueByNumber));
                }
            }
            else {
                while (codedInputStream.getBytesUntilLimit() > 0) {
                    set.addRepeatedField(liteExtensionByNumber.descriptor, FieldSet.readPrimitiveField(codedInputStream, liteExtensionByNumber.descriptor.getLiteType(), false));
                }
            }
            codedInputStream.popLimit(pushLimit);
        }
        else {
            Object o = null;
            switch (GeneratedMessageLite$1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[liteExtensionByNumber.descriptor.getLiteJavaType().ordinal()]) {
                case 1: {
                    MessageLite$Builder messageLite$Builder = null;
                    if (!liteExtensionByNumber.descriptor.isRepeated()) {
                        final MessageLite messageLite2 = (MessageLite)set.getField(liteExtensionByNumber.descriptor);
                        if (messageLite2 != null) {
                            messageLite$Builder = messageLite2.toBuilder();
                        }
                    }
                    if (messageLite$Builder == null) {
                        messageLite$Builder = liteExtensionByNumber.getMessageDefaultInstance().newBuilderForType();
                    }
                    if (liteExtensionByNumber.descriptor.getLiteType() == WireFormat$FieldType.GROUP) {
                        codedInputStream.readGroup(liteExtensionByNumber.getNumber(), messageLite$Builder, extensionRegistryLite);
                    }
                    else {
                        codedInputStream.readMessage(messageLite$Builder, extensionRegistryLite);
                    }
                    o = messageLite$Builder.build();
                    break;
                }
                case 2: {
                    final int enum1 = codedInputStream.readEnum();
                    o = liteExtensionByNumber.descriptor.getEnumType().findValueByNumber(enum1);
                    if (o == null) {
                        unknownFieldSetLite$Builder.mergeVarintField(tagFieldNumber, enum1);
                        return true;
                    }
                    break;
                }
                default: {
                    o = FieldSet.readPrimitiveField(codedInputStream, liteExtensionByNumber.descriptor.getLiteType(), false);
                    break;
                }
            }
            if (liteExtensionByNumber.descriptor.isRepeated()) {
                set.addRepeatedField(liteExtensionByNumber.descriptor, liteExtensionByNumber.singularToFieldSetType(o));
            }
            else {
                set.setField(liteExtensionByNumber.descriptor, liteExtensionByNumber.singularToFieldSetType(o));
            }
        }
        return true;
    }
    
    public static GeneratedMessageLite$GeneratedExtension newSingularGeneratedExtension(final MessageLite messageLite, final Object o, final MessageLite messageLite2, final Internal$EnumLiteMap internal$EnumLiteMap, final int n, final WireFormat$FieldType wireFormat$FieldType, final Class clazz) {
        return new GeneratedMessageLite$GeneratedExtension(messageLite, o, messageLite2, new GeneratedMessageLite$ExtensionDescriptor(internal$EnumLiteMap, n, wireFormat$FieldType, false, false), clazz);
    }
    
    public static GeneratedMessageLite$GeneratedExtension newRepeatedGeneratedExtension(final MessageLite messageLite, final MessageLite messageLite2, final Internal$EnumLiteMap internal$EnumLiteMap, final int n, final WireFormat$FieldType wireFormat$FieldType, final boolean b, final Class clazz) {
        return new GeneratedMessageLite$GeneratedExtension(messageLite, Collections.emptyList(), messageLite2, new GeneratedMessageLite$ExtensionDescriptor(internal$EnumLiteMap, n, wireFormat$FieldType, true, b), clazz);
    }
    
    static Method getMethodOrDie(final Class clazz, final String s, final Class... array) {
        try {
            return clazz.getMethod(s, (Class[])array);
        }
        catch (NoSuchMethodException ex) {
            final String value = String.valueOf(String.valueOf(clazz.getName()));
            final String value2 = String.valueOf(String.valueOf(s));
            throw new RuntimeException(new StringBuilder(45 + value.length() + value2.length()).append("Generated message class \"").append(value).append("\" missing method \"").append(value2).append("\".").toString(), ex);
        }
    }
    
    static Object invokeOrDie(final Method method, final Object o, final Object... array) {
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
    
    protected Object writeReplace() {
        return new GeneratedMessageLite$SerializedForm(this);
    }
    
    private static GeneratedMessageLite$GeneratedExtension checkIsLite(final ExtensionLite extensionLite) {
        if (!extensionLite.isLite()) {
            throw new IllegalArgumentException("Expected a lite extension.");
        }
        return (GeneratedMessageLite$GeneratedExtension)extensionLite;
    }
    
    protected static final boolean isInitialized(final GeneratedMessageLite generatedMessageLite, final boolean b) {
        return generatedMessageLite.dynamicMethod(GeneratedMessageLite$MethodToInvoke.IS_INITIALIZED, b) != null;
    }
    
    protected static final void makeImmutable(final GeneratedMessageLite generatedMessageLite) {
        generatedMessageLite.dynamicMethod(GeneratedMessageLite$MethodToInvoke.MAKE_IMMUTABLE, new Object[0]);
    }
    
    static GeneratedMessageLite parsePartialFrom(final GeneratedMessageLite generatedMessageLite, final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        try {
            return (GeneratedMessageLite)generatedMessageLite.dynamicMethod(GeneratedMessageLite$MethodToInvoke.PARSE_PARTIAL_FROM, codedInputStream, extensionRegistryLite);
        }
        catch (RuntimeException ex) {
            if (ex.getCause() instanceof InvalidProtocolBufferException) {
                throw (InvalidProtocolBufferException)ex.getCause();
            }
            throw ex;
        }
    }
    
    protected static Internal$IntList newIntList() {
        return new IntArrayList();
    }
    
    protected static Internal$IntList newIntList(final List list) {
        return new IntArrayList(list);
    }
    
    protected static Internal$IntList emptyIntList() {
        return IntArrayList.emptyList();
    }
    
    protected static Internal$LongList newLongList() {
        return new LongArrayList();
    }
    
    protected static Internal$LongList newLongList(final List list) {
        return new LongArrayList(list);
    }
    
    protected static Internal$LongList emptyLongList() {
        return LongArrayList.emptyList();
    }
    
    protected static Internal$FloatList newFloatList() {
        return new FloatArrayList();
    }
    
    protected static Internal$FloatList newFloatList(final List list) {
        return new FloatArrayList(list);
    }
    
    protected static Internal$FloatList emptyFloatList() {
        return FloatArrayList.emptyList();
    }
    
    protected static Internal$DoubleList newDoubleList() {
        return new DoubleArrayList();
    }
    
    protected static Internal$DoubleList newDoubleList(final List list) {
        return new DoubleArrayList(list);
    }
    
    protected static Internal$DoubleList emptyDoubleList() {
        return DoubleArrayList.emptyList();
    }
    
    protected static Internal$BooleanList newBooleanList() {
        return new BooleanArrayList();
    }
    
    protected static Internal$BooleanList newBooleanList(final List list) {
        return new BooleanArrayList(list);
    }
    
    protected static Internal$BooleanList emptyBooleanList() {
        return BooleanArrayList.emptyList();
    }
    
    protected static Internal$ProtobufList newProtobufList() {
        return new ProtobufArrayList();
    }
    
    protected static Internal$ProtobufList newProtobufList(final List list) {
        return new ProtobufArrayList(list);
    }
    
    protected static Internal$ProtobufList emptyProtobufList() {
        return ProtobufArrayList.emptyList();
    }
    
    protected static LazyStringArrayList emptyLazyStringArrayList() {
        return LazyStringArrayList.emptyList();
    }
    
    static {
        PROTOTYPE_MAP = new ConcurrentHashMap();
    }
}
