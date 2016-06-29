/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.Descriptors$FileDescriptor;
import com.google.protobuf.Descriptors$FileDescriptor$Syntax;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable$FieldAccessor;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable$MapFieldAccessor;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable$OneofAccessor;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable$RepeatedEnumFieldAccessor;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable$RepeatedFieldAccessor;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable$RepeatedMessageFieldAccessor;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable$SingularEnumFieldAccessor;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable$SingularFieldAccessor;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable$SingularMessageFieldAccessor;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable$SingularStringFieldAccessor;
import java.util.List;

public final class GeneratedMessage$FieldAccessorTable {
    private final Descriptors$Descriptor descriptor;
    private final GeneratedMessage$FieldAccessorTable$FieldAccessor[] fields;
    private String[] camelCaseNames;
    private final GeneratedMessage$FieldAccessorTable$OneofAccessor[] oneofs;
    private volatile boolean initialized;

    public GeneratedMessage$FieldAccessorTable(Descriptors$Descriptor descriptors$Descriptor, String[] arrstring, Class class_, Class class_2) {
        this(descriptors$Descriptor, arrstring);
        this.ensureFieldAccessorsInitialized(class_, class_2);
    }

    public GeneratedMessage$FieldAccessorTable(Descriptors$Descriptor descriptors$Descriptor, String[] arrstring) {
        this.descriptor = descriptors$Descriptor;
        this.camelCaseNames = arrstring;
        this.fields = new GeneratedMessage$FieldAccessorTable$FieldAccessor[descriptors$Descriptor.getFields().size()];
        this.oneofs = new GeneratedMessage$FieldAccessorTable$OneofAccessor[descriptors$Descriptor.getOneofs().size()];
        this.initialized = false;
    }

    private boolean isMapFieldEnabled(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public GeneratedMessage$FieldAccessorTable ensureFieldAccessorsInitialized(Class class_, Class class_2) {
        if (this.initialized) {
            return this;
        }
        GeneratedMessage$FieldAccessorTable generatedMessage$FieldAccessorTable = this;
        synchronized (generatedMessage$FieldAccessorTable) {
            int n2;
            if (this.initialized) {
                return this;
            }
            int n3 = this.fields.length;
            for (n2 = 0; n2 < n3; ++n2) {
                Descriptors$FieldDescriptor descriptors$FieldDescriptor = (Descriptors$FieldDescriptor)this.descriptor.getFields().get(n2);
                String string = null;
                if (descriptors$FieldDescriptor.getContainingOneof() != null) {
                    string = this.camelCaseNames[n3 + descriptors$FieldDescriptor.getContainingOneof().getIndex()];
                }
                if (descriptors$FieldDescriptor.isRepeated()) {
                    if (descriptors$FieldDescriptor.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
                        if (descriptors$FieldDescriptor.isMapField() && this.isMapFieldEnabled(descriptors$FieldDescriptor)) {
                            this.fields[n2] = new GeneratedMessage$FieldAccessorTable$MapFieldAccessor(descriptors$FieldDescriptor, this.camelCaseNames[n2], class_, class_2);
                            continue;
                        }
                        this.fields[n2] = new GeneratedMessage$FieldAccessorTable$RepeatedMessageFieldAccessor(descriptors$FieldDescriptor, this.camelCaseNames[n2], class_, class_2);
                        continue;
                    }
                    if (descriptors$FieldDescriptor.getJavaType() == Descriptors$FieldDescriptor$JavaType.ENUM) {
                        this.fields[n2] = new GeneratedMessage$FieldAccessorTable$RepeatedEnumFieldAccessor(descriptors$FieldDescriptor, this.camelCaseNames[n2], class_, class_2);
                        continue;
                    }
                    this.fields[n2] = new GeneratedMessage$FieldAccessorTable$RepeatedFieldAccessor(descriptors$FieldDescriptor, this.camelCaseNames[n2], class_, class_2);
                    continue;
                }
                this.fields[n2] = descriptors$FieldDescriptor.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE ? new GeneratedMessage$FieldAccessorTable$SingularMessageFieldAccessor(descriptors$FieldDescriptor, this.camelCaseNames[n2], class_, class_2, string) : (descriptors$FieldDescriptor.getJavaType() == Descriptors$FieldDescriptor$JavaType.ENUM ? new GeneratedMessage$FieldAccessorTable$SingularEnumFieldAccessor(descriptors$FieldDescriptor, this.camelCaseNames[n2], class_, class_2, string) : (descriptors$FieldDescriptor.getJavaType() == Descriptors$FieldDescriptor$JavaType.STRING ? new GeneratedMessage$FieldAccessorTable$SingularStringFieldAccessor(descriptors$FieldDescriptor, this.camelCaseNames[n2], class_, class_2, string) : new GeneratedMessage$FieldAccessorTable$SingularFieldAccessor(descriptors$FieldDescriptor, this.camelCaseNames[n2], class_, class_2, string)));
            }
            n2 = this.oneofs.length;
            int n4 = 0;
            do {
                if (n4 >= n2) {
                    this.initialized = true;
                    this.camelCaseNames = null;
                    return this;
                }
                this.oneofs[n4] = new GeneratedMessage$FieldAccessorTable$OneofAccessor(this.descriptor, this.camelCaseNames[n4 + n3], class_, class_2);
                ++n4;
            } while (true);
        }
    }

    private GeneratedMessage$FieldAccessorTable$FieldAccessor getField(Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        if (descriptors$FieldDescriptor.getContainingType() != this.descriptor) {
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }
        if (!descriptors$FieldDescriptor.isExtension()) return this.fields[descriptors$FieldDescriptor.getIndex()];
        throw new IllegalArgumentException("This type does not have extensions.");
    }

    private GeneratedMessage$FieldAccessorTable$OneofAccessor getOneof(Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        if (descriptors$OneofDescriptor.getContainingType() == this.descriptor) return this.oneofs[descriptors$OneofDescriptor.getIndex()];
        throw new IllegalArgumentException("OneofDescriptor does not match message type.");
    }

    private static boolean supportFieldPresence(Descriptors$FileDescriptor descriptors$FileDescriptor) {
        if (descriptors$FileDescriptor.getSyntax() != Descriptors$FileDescriptor$Syntax.PROTO2) return false;
        return true;
    }

    static /* synthetic */ Descriptors$Descriptor access$000(GeneratedMessage$FieldAccessorTable generatedMessage$FieldAccessorTable) {
        return generatedMessage$FieldAccessorTable.descriptor;
    }

    static /* synthetic */ GeneratedMessage$FieldAccessorTable$OneofAccessor access$100(GeneratedMessage$FieldAccessorTable generatedMessage$FieldAccessorTable, Descriptors$OneofDescriptor descriptors$OneofDescriptor) {
        return generatedMessage$FieldAccessorTable.getOneof(descriptors$OneofDescriptor);
    }

    static /* synthetic */ GeneratedMessage$FieldAccessorTable$FieldAccessor access$200(GeneratedMessage$FieldAccessorTable generatedMessage$FieldAccessorTable, Descriptors$FieldDescriptor descriptors$FieldDescriptor) {
        return generatedMessage$FieldAccessorTable.getField(descriptors$FieldDescriptor);
    }

    static /* synthetic */ boolean access$1300(Descriptors$FileDescriptor descriptors$FileDescriptor) {
        return GeneratedMessage$FieldAccessorTable.supportFieldPresence(descriptors$FileDescriptor);
    }
}

