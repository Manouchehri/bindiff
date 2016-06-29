/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.BooleanArrayList;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.DoubleArrayList;
import com.google.protobuf.ExtensionLite;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.FieldSet;
import com.google.protobuf.FieldSet$FieldDescriptorLite;
import com.google.protobuf.FloatArrayList;
import com.google.protobuf.GeneratedMessageLite$1;
import com.google.protobuf.GeneratedMessageLite$Builder;
import com.google.protobuf.GeneratedMessageLite$ExtensionDescriptor;
import com.google.protobuf.GeneratedMessageLite$GeneratedExtension;
import com.google.protobuf.GeneratedMessageLite$MethodToInvoke;
import com.google.protobuf.GeneratedMessageLite$PrototypeHolder;
import com.google.protobuf.GeneratedMessageLite$SerializedForm;
import com.google.protobuf.IntArrayList;
import com.google.protobuf.Internal;
import com.google.protobuf.Internal$BooleanList;
import com.google.protobuf.Internal$DoubleList;
import com.google.protobuf.Internal$EnumLite;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.Internal$FloatList;
import com.google.protobuf.Internal$IntList;
import com.google.protobuf.Internal$LongList;
import com.google.protobuf.Internal$ProtobufList;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LongArrayList;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtobufArrayList;
import com.google.protobuf.UnknownFieldSetLite;
import com.google.protobuf.UnknownFieldSetLite$Builder;
import com.google.protobuf.WireFormat;
import com.google.protobuf.WireFormat$FieldType;
import com.google.protobuf.WireFormat$JavaType;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class GeneratedMessageLite
extends AbstractMessageLite
implements Serializable {
    private static final Map PROTOTYPE_MAP = new ConcurrentHashMap<K, V>();
    private static final long serialVersionUID = 1;
    protected UnknownFieldSetLite unknownFields = UnknownFieldSetLite.getDefaultInstance();
    protected int memoizedSerializedSize = -1;

    protected static void onLoad(Class class_, GeneratedMessageLite$PrototypeHolder generatedMessageLite$PrototypeHolder) {
        PROTOTYPE_MAP.put(class_, generatedMessageLite$PrototypeHolder);
    }

    @Override
    public final Parser getParserForType() {
        return ((GeneratedMessageLite$PrototypeHolder)PROTOTYPE_MAP.get(this.getClass())).getParserForType();
    }

    @Override
    public final GeneratedMessageLite getDefaultInstanceForType() {
        return ((GeneratedMessageLite$PrototypeHolder)PROTOTYPE_MAP.get(this.getClass())).getDefaultInstanceForType();
    }

    @Override
    public final GeneratedMessageLite$Builder newBuilderForType() {
        return ((GeneratedMessageLite$PrototypeHolder)PROTOTYPE_MAP.get(this.getClass())).newBuilderForType();
    }

    protected static boolean parseUnknownField(CodedInputStream codedInputStream, UnknownFieldSetLite$Builder unknownFieldSetLite$Builder, ExtensionRegistryLite extensionRegistryLite, int n2) {
        return unknownFieldSetLite$Builder.mergeFieldFrom(n2, codedInputStream);
    }

    @Override
    public final boolean isInitialized() {
        if (this.dynamicMethod(GeneratedMessageLite$MethodToInvoke.IS_INITIALIZED, Boolean.TRUE) == null) return false;
        return true;
    }

    @Override
    public final GeneratedMessageLite$Builder toBuilder() {
        GeneratedMessageLite$Builder generatedMessageLite$Builder = (GeneratedMessageLite$Builder)this.dynamicMethod(GeneratedMessageLite$MethodToInvoke.NEW_BUILDER, new Object[0]);
        generatedMessageLite$Builder.mergeFrom(this);
        return generatedMessageLite$Builder;
    }

    protected /* varargs */ abstract Object dynamicMethod(GeneratedMessageLite$MethodToInvoke var1, Object ... var2);

    protected final void mergeUnknownFields(UnknownFieldSetLite unknownFieldSetLite) {
        this.unknownFields = UnknownFieldSetLite.concat(this.unknownFields, unknownFieldSetLite);
    }

    protected static boolean parseUnknownField(FieldSet fieldSet, MessageLite messageLite, CodedInputStream codedInputStream, UnknownFieldSetLite$Builder unknownFieldSetLite$Builder, ExtensionRegistryLite extensionRegistryLite, int n2) {
        Object object;
        int n3 = WireFormat.getTagWireType(n2);
        int n4 = WireFormat.getTagFieldNumber(n2);
        GeneratedMessageLite$GeneratedExtension generatedMessageLite$GeneratedExtension = extensionRegistryLite.findLiteExtensionByNumber(messageLite, n4);
        boolean bl2 = false;
        boolean bl3 = false;
        if (generatedMessageLite$GeneratedExtension == null) {
            return unknownFieldSetLite$Builder.mergeFieldFrom(n2, codedInputStream);
        }
        if (n3 == FieldSet.getWireFormatForFieldType(generatedMessageLite$GeneratedExtension.descriptor.getLiteType(), false)) {
            bl3 = false;
        } else {
            if (!generatedMessageLite$GeneratedExtension.descriptor.isRepeated) return unknownFieldSetLite$Builder.mergeFieldFrom(n2, codedInputStream);
            if (!generatedMessageLite$GeneratedExtension.descriptor.type.isPackable()) return unknownFieldSetLite$Builder.mergeFieldFrom(n2, codedInputStream);
            if (n3 != FieldSet.getWireFormatForFieldType(generatedMessageLite$GeneratedExtension.descriptor.getLiteType(), true)) return unknownFieldSetLite$Builder.mergeFieldFrom(n2, codedInputStream);
            bl3 = true;
        }
        if (bl2) {
            return unknownFieldSetLite$Builder.mergeFieldFrom(n2, codedInputStream);
        }
        switch (GeneratedMessageLite$1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[generatedMessageLite$GeneratedExtension.descriptor.getLiteJavaType().ordinal()]) {
            case 1: {
                MessageLite$Builder messageLite$Builder;
                block14 : {
                    messageLite$Builder = null;
                    if (!generatedMessageLite$GeneratedExtension.descriptor.isRepeated()) {
                        MessageLite messageLite2 = (MessageLite)fieldSet.getField(generatedMessageLite$GeneratedExtension.descriptor);
                        if (messageLite2 != null) {
                            messageLite$Builder = messageLite2.toBuilder();
                        }
                        if (messageLite$Builder != null) break block14;
                    }
                    messageLite$Builder = generatedMessageLite$GeneratedExtension.getMessageDefaultInstance().newBuilderForType();
                }
                if (generatedMessageLite$GeneratedExtension.descriptor.getLiteType() == WireFormat$FieldType.GROUP) {
                    codedInputStream.readGroup(generatedMessageLite$GeneratedExtension.getNumber(), messageLite$Builder, extensionRegistryLite);
                } else {
                    codedInputStream.readMessage(messageLite$Builder, extensionRegistryLite);
                }
                object = messageLite$Builder.build();
                break;
            }
            case 2: {
                int n5 = codedInputStream.readEnum();
                object = generatedMessageLite$GeneratedExtension.descriptor.getEnumType().findValueByNumber(n5);
                if (object != null) break;
                unknownFieldSetLite$Builder.mergeVarintField(n4, n5);
                return true;
            }
            default: {
                object = FieldSet.readPrimitiveField(codedInputStream, generatedMessageLite$GeneratedExtension.descriptor.getLiteType(), false);
            }
        }
        if (generatedMessageLite$GeneratedExtension.descriptor.isRepeated()) {
            fieldSet.addRepeatedField(generatedMessageLite$GeneratedExtension.descriptor, generatedMessageLite$GeneratedExtension.singularToFieldSetType(object));
            return true;
        }
        fieldSet.setField(generatedMessageLite$GeneratedExtension.descriptor, generatedMessageLite$GeneratedExtension.singularToFieldSetType(object));
        return true;
    }

    public static GeneratedMessageLite$GeneratedExtension newSingularGeneratedExtension(MessageLite messageLite, Object object, MessageLite messageLite2, Internal$EnumLiteMap internal$EnumLiteMap, int n2, WireFormat$FieldType wireFormat$FieldType, Class class_) {
        return new GeneratedMessageLite$GeneratedExtension(messageLite, object, messageLite2, new GeneratedMessageLite$ExtensionDescriptor(internal$EnumLiteMap, n2, wireFormat$FieldType, false, false), class_);
    }

    public static GeneratedMessageLite$GeneratedExtension newRepeatedGeneratedExtension(MessageLite messageLite, MessageLite messageLite2, Internal$EnumLiteMap internal$EnumLiteMap, int n2, WireFormat$FieldType wireFormat$FieldType, boolean bl2, Class class_) {
        List<T> list = Collections.emptyList();
        return new GeneratedMessageLite$GeneratedExtension(messageLite, list, messageLite2, new GeneratedMessageLite$ExtensionDescriptor(internal$EnumLiteMap, n2, wireFormat$FieldType, true, bl2), class_);
    }

    static /* varargs */ Method getMethodOrDie(Class class_, String string, Class ... arrclass) {
        try {
            return class_.getMethod(string, arrclass);
        }
        catch (NoSuchMethodException var3_3) {
            String string2 = String.valueOf(String.valueOf(class_.getName()));
            String string3 = String.valueOf(String.valueOf(string));
            throw new RuntimeException(new StringBuilder(45 + string2.length() + string3.length()).append("Generated message class \"").append(string2).append("\" missing method \"").append(string3).append("\".").toString(), var3_3);
        }
    }

    static /* varargs */ Object invokeOrDie(Method method, Object object, Object ... arrobject) {
        try {
            return method.invoke(object, arrobject);
        }
        catch (IllegalAccessException var3_3) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", var3_3);
        }
        catch (InvocationTargetException var3_4) {
            Throwable throwable = var3_4.getCause();
            if (throwable instanceof RuntimeException) {
                throw (RuntimeException)throwable;
            }
            if (!(throwable instanceof Error)) throw new RuntimeException("Unexpected exception thrown by generated accessor method.", throwable);
            throw (Error)throwable;
        }
    }

    protected Object writeReplace() {
        return new GeneratedMessageLite$SerializedForm(this);
    }

    private static GeneratedMessageLite$GeneratedExtension checkIsLite(ExtensionLite extensionLite) {
        if (extensionLite.isLite()) return (GeneratedMessageLite$GeneratedExtension)extensionLite;
        throw new IllegalArgumentException("Expected a lite extension.");
    }

    protected static final boolean isInitialized(GeneratedMessageLite generatedMessageLite, boolean bl2) {
        if (generatedMessageLite.dynamicMethod(GeneratedMessageLite$MethodToInvoke.IS_INITIALIZED, bl2) == null) return false;
        return true;
    }

    protected static final void makeImmutable(GeneratedMessageLite generatedMessageLite) {
        generatedMessageLite.dynamicMethod(GeneratedMessageLite$MethodToInvoke.MAKE_IMMUTABLE, new Object[0]);
    }

    static GeneratedMessageLite parsePartialFrom(GeneratedMessageLite generatedMessageLite, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        try {
            return (GeneratedMessageLite)generatedMessageLite.dynamicMethod(GeneratedMessageLite$MethodToInvoke.PARSE_PARTIAL_FROM, codedInputStream, extensionRegistryLite);
        }
        catch (RuntimeException var3_3) {
            if (!(var3_3.getCause() instanceof InvalidProtocolBufferException)) throw var3_3;
            throw (InvalidProtocolBufferException)var3_3.getCause();
        }
    }

    protected static Internal.IntList newIntList() {
        return new IntArrayList();
    }

    protected static Internal.IntList newIntList(List list) {
        return new IntArrayList(list);
    }

    protected static Internal.IntList emptyIntList() {
        return IntArrayList.emptyList();
    }

    protected static Internal.LongList newLongList() {
        return new LongArrayList();
    }

    protected static Internal.LongList newLongList(List list) {
        return new LongArrayList(list);
    }

    protected static Internal.LongList emptyLongList() {
        return LongArrayList.emptyList();
    }

    protected static Internal$FloatList newFloatList() {
        return new FloatArrayList();
    }

    protected static Internal$FloatList newFloatList(List list) {
        return new FloatArrayList(list);
    }

    protected static Internal$FloatList emptyFloatList() {
        return FloatArrayList.emptyList();
    }

    protected static Internal$DoubleList newDoubleList() {
        return new DoubleArrayList();
    }

    protected static Internal$DoubleList newDoubleList(List list) {
        return new DoubleArrayList(list);
    }

    protected static Internal$DoubleList emptyDoubleList() {
        return DoubleArrayList.emptyList();
    }

    protected static Internal$BooleanList newBooleanList() {
        return new BooleanArrayList();
    }

    protected static Internal$BooleanList newBooleanList(List list) {
        return new BooleanArrayList(list);
    }

    protected static Internal$BooleanList emptyBooleanList() {
        return BooleanArrayList.emptyList();
    }

    protected static Internal$ProtobufList newProtobufList() {
        return new ProtobufArrayList();
    }

    protected static Internal$ProtobufList newProtobufList(List list) {
        return new ProtobufArrayList(list);
    }

    protected static Internal$ProtobufList emptyProtobufList() {
        return ProtobufArrayList.emptyList();
    }

    protected static LazyStringArrayList emptyLazyStringArrayList() {
        return LazyStringArrayList.emptyList();
    }

    static /* synthetic */ GeneratedMessageLite$GeneratedExtension access$000(ExtensionLite extensionLite) {
        return GeneratedMessageLite.checkIsLite(extensionLite);
    }
}

