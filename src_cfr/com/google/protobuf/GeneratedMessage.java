/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.Extension;
import com.google.protobuf.Extension$ExtensionType;
import com.google.protobuf.ExtensionLite;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage$1;
import com.google.protobuf.GeneratedMessage$2;
import com.google.protobuf.GeneratedMessage$3;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$ExtensionDescriptorRetriever;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.GeneratedMessage$GeneratedExtension;
import com.google.protobuf.GeneratedMessageLite$SerializedForm;
import com.google.protobuf.MapField;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageReflection;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.UnknownFieldSet$Builder;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public abstract class GeneratedMessage
extends AbstractMessage
implements Serializable {
    private static final long serialVersionUID = 1;
    protected static boolean alwaysUseFieldBuilders = false;
    protected UnknownFieldSet unknownFields;

    protected GeneratedMessage() {
        this.unknownFields = UnknownFieldSet.getDefaultInstance();
    }

    protected GeneratedMessage(GeneratedMessage$Builder generatedMessage$Builder) {
        this.unknownFields = generatedMessage$Builder.getUnknownFields();
    }

    @Override
    public Parser getParserForType() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    static void enableAlwaysUseFieldBuildersForTesting() {
        alwaysUseFieldBuilders = true;
    }

    protected abstract GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable();

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return GeneratedMessage$FieldAccessorTable.access$000(this.internalGetFieldAccessorTable());
    }

    private Map getAllFieldsMutable(boolean bl2) {
        TreeMap<Descriptors$FieldDescriptor, Object> treeMap = new TreeMap<Descriptors$FieldDescriptor, Object>();
        Descriptors$Descriptor descriptors$Descriptor = GeneratedMessage$FieldAccessorTable.access$000(this.internalGetFieldAccessorTable());
        Iterator<E> iterator = descriptors$Descriptor.getFields().iterator();
        while (iterator.hasNext()) {
            Descriptors$FieldDescriptor descriptors$FieldDescriptor = (Descriptors$FieldDescriptor)iterator.next();
            if (descriptors$FieldDescriptor.isRepeated()) {
                List list = (List)this.getField(descriptors$FieldDescriptor);
                if (list.isEmpty()) continue;
                treeMap.put(descriptors$FieldDescriptor, list);
                continue;
            }
            if (!this.hasField(descriptors$FieldDescriptor)) continue;
            if (bl2 && descriptors$FieldDescriptor.getJavaType() == Descriptors$FieldDescriptor$JavaType.STRING) {
                treeMap.put(descriptors$FieldDescriptor, this.getFieldRaw(descriptors$FieldDescriptor));
                continue;
            }
            treeMap.put(descriptors$FieldDescriptor, this.getField(descriptors$FieldDescriptor));
        }
        return treeMap;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public boolean isInitialized() {
        var1_1 = this.getDescriptorForType().getFields().iterator();
        do lbl-1000: // 4 sources:
        {
            if (var1_1.hasNext() == false) return true;
            var2_2 = (Descriptors$FieldDescriptor)var1_1.next();
            if (var2_2.isRequired() && !this.hasField(var2_2)) {
                return false;
            }
            if (var2_2.getJavaType() != Descriptors$FieldDescriptor$JavaType.MESSAGE) ** GOTO lbl-1000
            if (!var2_2.isRepeated()) continue;
            var3_3 = (List)this.getField(var2_2);
            var4_4 = var3_3.iterator();
            do {
                if (!var4_4.hasNext()) ** GOTO lbl-1000
            } while ((var5_5 = (Message)var4_4.next()).isInitialized());
            return false;
        } while (!this.hasField(var2_2) || ((Message)this.getField(var2_2)).isInitialized());
        return false;
    }

    @Override
    public Map getAllFields() {
        return Collections.unmodifiableMap(this.getAllFieldsMutable(false));
    }

    Map getAllFieldsRaw() {
        return Collections.unmodifiableMap(this.getAllFieldsMutable(true));
    }

    @Override
    public boolean hasOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return GeneratedMessage$FieldAccessorTable.access$100(this.internalGetFieldAccessorTable(), descriptors$OneofDescriptor).has(this);
    }

    @Override
    public Descriptors$FieldDescriptor getOneofFieldDescriptor(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return GeneratedMessage$FieldAccessorTable.access$100(this.internalGetFieldAccessorTable(), descriptors$OneofDescriptor).get(this);
    }

    @Override
    public boolean hasField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), descriptors$FieldDescriptor).has(this);
    }

    @Override
    public Object getField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), descriptors$FieldDescriptor).get(this);
    }

    Object getFieldRaw(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), descriptors$FieldDescriptor).getRaw(this);
    }

    @Override
    public int getRepeatedFieldCount(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), descriptors$FieldDescriptor).getRepeatedCount(this);
    }

    @Override
    public Object getRepeatedField(Descriptors$FieldDescriptor descriptors$FieldDescriptor, int n2) {
        return GeneratedMessage$FieldAccessorTable.access$200(this.internalGetFieldAccessorTable(), descriptors$FieldDescriptor).getRepeated(this, n2);
    }

    @Override
    public UnknownFieldSet getUnknownFields() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    protected boolean parseUnknownField(CodedInputStream codedInputStream, UnknownFieldSet$Builder unknownFieldSet$Builder, ExtensionRegistryLite extensionRegistryLite, int n2) {
        return unknownFieldSet$Builder.mergeFieldFrom(n2, codedInputStream);
    }

    @Override
    public void writeTo(CodedOutputStream codedOutputStream) {
        MessageReflection.writeMessageTo(this, this.getAllFieldsRaw(), codedOutputStream, false);
    }

    @Override
    public int getSerializedSize() {
        int n2 = this.memoizedSize;
        if (n2 != -1) {
            return n2;
        }
        this.memoizedSize = MessageReflection.getSerializedSize(this, this.getAllFieldsRaw());
        return this.memoizedSize;
    }

    protected void makeExtensionsImmutable() {
    }

    protected abstract Message$Builder newBuilderForType(GeneratedMessage$BuilderParent var1);

    public static GeneratedMessage$GeneratedExtension newMessageScopedGeneratedExtension(Message message, int n2, Class class_, Message message2) {
        return new GeneratedMessage$GeneratedExtension(new GeneratedMessage$1(message, n2), class_, message2, Extension$ExtensionType.IMMUTABLE);
    }

    public static GeneratedMessage$GeneratedExtension newFileScopedGeneratedExtension(Class class_, Message message) {
        return new GeneratedMessage$GeneratedExtension(null, class_, message, Extension$ExtensionType.IMMUTABLE);
    }

    public static GeneratedMessage$GeneratedExtension newMessageScopedGeneratedExtension(Message message, String string, Class class_, Message message2) {
        return new GeneratedMessage$GeneratedExtension(new GeneratedMessage$2(message, string), class_, message2, Extension$ExtensionType.MUTABLE);
    }

    public static GeneratedMessage$GeneratedExtension newFileScopedGeneratedExtension(Class class_, Message message, String string, String string2) {
        return new GeneratedMessage$GeneratedExtension(new GeneratedMessage$3(class_, string, string2), class_, message, Extension$ExtensionType.MUTABLE);
    }

    private static /* varargs */ Method getMethodOrDie(Class class_, String string, Class ... arrclass) {
        try {
            return class_.getMethod(string, arrclass);
        }
        catch (NoSuchMethodException var3_3) {
            String string2 = String.valueOf(String.valueOf(class_.getName()));
            String string3 = String.valueOf(String.valueOf(string));
            throw new RuntimeException(new StringBuilder(45 + string2.length() + string3.length()).append("Generated message class \"").append(string2).append("\" missing method \"").append(string3).append("\".").toString(), var3_3);
        }
    }

    private static /* varargs */ Object invokeOrDie(Method method, Object object, Object ... arrobject) {
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

    protected MapField internalGetMapField(int n2) {
        String string;
        String string2 = String.valueOf(this.getClass().getName());
        if (string2.length() != 0) {
            string = "No map fields found in ".concat(string2);
            throw new RuntimeException(string);
        }
        string = new String("No map fields found in ");
        throw new RuntimeException(string);
    }

    protected Object writeReplace() {
        return new GeneratedMessageLite$SerializedForm(this);
    }

    private static Extension checkNotLite(ExtensionLite extensionLite) {
        if (!extensionLite.isLite()) return (Extension)extensionLite;
        throw new IllegalArgumentException("Expected non-lite extension.");
    }

    static /* synthetic */ Extension access$500(ExtensionLite extensionLite) {
        return GeneratedMessage.checkNotLite(extensionLite);
    }

    static /* synthetic */ Map access$800(GeneratedMessage generatedMessage, boolean bl2) {
        return generatedMessage.getAllFieldsMutable(bl2);
    }

    static /* synthetic */ Method access$1100(Class class_, String string, Class[] arrclass) {
        return GeneratedMessage.getMethodOrDie(class_, string, arrclass);
    }

    static /* synthetic */ Object access$1200(Method method, Object object, Object[] arrobject) {
        return GeneratedMessage.invokeOrDie(method, object, arrobject);
    }
}

