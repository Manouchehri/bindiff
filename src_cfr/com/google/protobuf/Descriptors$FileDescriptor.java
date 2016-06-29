/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.DescriptorProtos$DescriptorProto;
import com.google.protobuf.DescriptorProtos$EnumDescriptorProto;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto;
import com.google.protobuf.DescriptorProtos$FileDescriptorProto;
import com.google.protobuf.DescriptorProtos$FileDescriptorProto$Builder;
import com.google.protobuf.DescriptorProtos$FileOptions;
import com.google.protobuf.DescriptorProtos$ServiceDescriptorProto;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors$1;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$DescriptorPool;
import com.google.protobuf.Descriptors$DescriptorValidationException;
import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FileDescriptor$InternalDescriptorAssigner;
import com.google.protobuf.Descriptors$FileDescriptor$Syntax;
import com.google.protobuf.Descriptors$GenericDescriptor;
import com.google.protobuf.Descriptors$ServiceDescriptor;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public final class Descriptors$FileDescriptor
extends Descriptors$GenericDescriptor {
    private DescriptorProtos$FileDescriptorProto proto;
    private final Descriptors$Descriptor[] messageTypes;
    private final Descriptors$EnumDescriptor[] enumTypes;
    private final Descriptors$ServiceDescriptor[] services;
    private final Descriptors$FieldDescriptor[] extensions;
    private final Descriptors$FileDescriptor[] dependencies;
    private final Descriptors$FileDescriptor[] publicDependencies;
    private final Descriptors$DescriptorPool pool;

    @Override
    public DescriptorProtos$FileDescriptorProto toProto() {
        return this.proto;
    }

    @Override
    public String getName() {
        return this.proto.getName();
    }

    @Override
    public Descriptors$FileDescriptor getFile() {
        return this;
    }

    @Override
    public String getFullName() {
        return this.proto.getName();
    }

    public String getPackage() {
        return this.proto.getPackage();
    }

    public DescriptorProtos$FileOptions getOptions() {
        return this.proto.getOptions();
    }

    public List getMessageTypes() {
        return Collections.unmodifiableList(Arrays.asList(this.messageTypes));
    }

    public List getEnumTypes() {
        return Collections.unmodifiableList(Arrays.asList(this.enumTypes));
    }

    public List getServices() {
        return Collections.unmodifiableList(Arrays.asList(this.services));
    }

    public List getExtensions() {
        return Collections.unmodifiableList(Arrays.asList(this.extensions));
    }

    public List getDependencies() {
        return Collections.unmodifiableList(Arrays.asList(this.dependencies));
    }

    public List getPublicDependencies() {
        return Collections.unmodifiableList(Arrays.asList(this.publicDependencies));
    }

    public Descriptors$FileDescriptor$Syntax getSyntax() {
        if (!Descriptors$FileDescriptor$Syntax.access$000(Descriptors$FileDescriptor$Syntax.PROTO3).equals(this.proto.getSyntax())) return Descriptors$FileDescriptor$Syntax.PROTO2;
        return Descriptors$FileDescriptor$Syntax.PROTO3;
    }

    public Descriptors$Descriptor findMessageTypeByName(String string) {
        Object object;
        if (string.indexOf(46) != -1) {
            return null;
        }
        if (this.getPackage().length() > 0) {
            object = String.valueOf(String.valueOf(this.getPackage()));
            String string2 = String.valueOf(String.valueOf(string));
            string = new StringBuilder(1 + object.length() + string2.length()).append((String)object).append(".").append(string2).toString();
        }
        if ((object = this.pool.findSymbol(string)) == null) return null;
        if (!(object instanceof Descriptors$Descriptor)) return null;
        if (object.getFile() != this) return null;
        return (Descriptors$Descriptor)object;
    }

    public Descriptors$EnumDescriptor findEnumTypeByName(String string) {
        Object object;
        if (string.indexOf(46) != -1) {
            return null;
        }
        if (this.getPackage().length() > 0) {
            object = String.valueOf(String.valueOf(this.getPackage()));
            String string2 = String.valueOf(String.valueOf(string));
            string = new StringBuilder(1 + object.length() + string2.length()).append((String)object).append(".").append(string2).toString();
        }
        if ((object = this.pool.findSymbol(string)) == null) return null;
        if (!(object instanceof Descriptors$EnumDescriptor)) return null;
        if (object.getFile() != this) return null;
        return (Descriptors$EnumDescriptor)object;
    }

    public Descriptors$ServiceDescriptor findServiceByName(String string) {
        Object object;
        if (string.indexOf(46) != -1) {
            return null;
        }
        if (this.getPackage().length() > 0) {
            object = String.valueOf(String.valueOf(this.getPackage()));
            String string2 = String.valueOf(String.valueOf(string));
            string = new StringBuilder(1 + object.length() + string2.length()).append((String)object).append(".").append(string2).toString();
        }
        if ((object = this.pool.findSymbol(string)) == null) return null;
        if (!(object instanceof Descriptors$ServiceDescriptor)) return null;
        if (object.getFile() != this) return null;
        return (Descriptors$ServiceDescriptor)object;
    }

    public Descriptors$FieldDescriptor findExtensionByName(String string) {
        Object object;
        if (string.indexOf(46) != -1) {
            return null;
        }
        if (this.getPackage().length() > 0) {
            object = String.valueOf(String.valueOf(this.getPackage()));
            String string2 = String.valueOf(String.valueOf(string));
            string = new StringBuilder(1 + object.length() + string2.length()).append((String)object).append(".").append(string2).toString();
        }
        if ((object = this.pool.findSymbol(string)) == null) return null;
        if (!(object instanceof Descriptors$FieldDescriptor)) return null;
        if (object.getFile() != this) return null;
        return (Descriptors$FieldDescriptor)object;
    }

    public static Descriptors$FileDescriptor buildFrom(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto, Descriptors$FileDescriptor[] arrdescriptors$FileDescriptor) {
        return Descriptors$FileDescriptor.buildFrom(descriptorProtos$FileDescriptorProto, arrdescriptors$FileDescriptor, false);
    }

    private static Descriptors$FileDescriptor buildFrom(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto, Descriptors$FileDescriptor[] arrdescriptors$FileDescriptor, boolean bl2) {
        Descriptors$DescriptorPool descriptors$DescriptorPool = new Descriptors$DescriptorPool(arrdescriptors$FileDescriptor, bl2);
        Descriptors$FileDescriptor descriptors$FileDescriptor = new Descriptors$FileDescriptor(descriptorProtos$FileDescriptorProto, arrdescriptors$FileDescriptor, descriptors$DescriptorPool, bl2);
        descriptors$FileDescriptor.crossLink();
        return descriptors$FileDescriptor;
    }

    public static void internalBuildGeneratedFileFrom(String[] arrstring, Descriptors$FileDescriptor[] arrdescriptors$FileDescriptor, Descriptors$FileDescriptor$InternalDescriptorAssigner descriptors$FileDescriptor$InternalDescriptorAssigner) {
        Descriptors$FileDescriptor descriptors$FileDescriptor;
        DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto;
        StringBuilder stringBuilder = new StringBuilder();
        for (String object2 : arrstring) {
            stringBuilder.append(object2);
        }
        String[] arrstring2 = stringBuilder.toString().getBytes(Internal.ISO_8859_1);
        try {
            descriptorProtos$FileDescriptorProto = DescriptorProtos$FileDescriptorProto.parseFrom((byte[])arrstring2);
        }
        catch (InvalidProtocolBufferException var6_8) {
            throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", var6_8);
        }
        try {
            descriptors$FileDescriptor = Descriptors$FileDescriptor.buildFrom(descriptorProtos$FileDescriptorProto, arrdescriptors$FileDescriptor, true);
        }
        catch (Descriptors$DescriptorValidationException var7_11) {
            String string = String.valueOf(String.valueOf(descriptorProtos$FileDescriptorProto.getName()));
            throw new IllegalArgumentException(new StringBuilder(35 + string.length()).append("Invalid embedded descriptor for \"").append(string).append("\".").toString(), var7_11);
        }
        ExtensionRegistry extensionRegistry = descriptors$FileDescriptor$InternalDescriptorAssigner.assignDescriptors(descriptors$FileDescriptor);
        if (extensionRegistry == null) return;
        try {
            descriptorProtos$FileDescriptorProto = DescriptorProtos$FileDescriptorProto.parseFrom((byte[])arrstring2, (ExtensionRegistryLite)extensionRegistry);
        }
        catch (InvalidProtocolBufferException var8_14) {
            throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", var8_14);
        }
        descriptors$FileDescriptor.setProto(descriptorProtos$FileDescriptorProto);
    }

    public static void internalBuildGeneratedFileFrom(String[] arrstring, Class class_, String[] arrstring2, String[] arrstring3, Descriptors$FileDescriptor$InternalDescriptorAssigner descriptors$FileDescriptor$InternalDescriptorAssigner) {
        ArrayList<Descriptors$FileDescriptor> arrayList = new ArrayList<Descriptors$FileDescriptor>();
        int n2 = 0;
        do {
            if (n2 >= arrstring2.length) {
                Descriptors$FileDescriptor[] arrdescriptors$FileDescriptor = new Descriptors$FileDescriptor[arrayList.size()];
                arrayList.toArray(arrdescriptors$FileDescriptor);
                Descriptors$FileDescriptor.internalBuildGeneratedFileFrom(arrstring, arrdescriptors$FileDescriptor, descriptors$FileDescriptor$InternalDescriptorAssigner);
                return;
            }
            try {
                Class class_2 = class_.getClassLoader().loadClass(arrstring2[n2]);
                arrayList.add((Descriptors$FileDescriptor)class_2.getField("descriptor").get(null));
            }
            catch (Exception var7_9) {
                String string = String.valueOf(String.valueOf(arrstring3[n2]));
                Descriptors.access$100().warning(new StringBuilder(36 + string.length()).append("Descriptors for \"").append(string).append("\" can not be found.").toString());
            }
            ++n2;
        } while (true);
    }

    public static void internalUpdateFileDescriptor(Descriptors$FileDescriptor descriptors$FileDescriptor, ExtensionRegistry extensionRegistry) {
        DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto;
        ByteString byteString = descriptors$FileDescriptor.proto.toByteString();
        try {
            descriptorProtos$FileDescriptorProto = DescriptorProtos$FileDescriptorProto.parseFrom(byteString, (ExtensionRegistryLite)extensionRegistry);
        }
        catch (InvalidProtocolBufferException var4_4) {
            throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", var4_4);
        }
        descriptors$FileDescriptor.setProto(descriptorProtos$FileDescriptorProto);
    }

    private Descriptors$FileDescriptor(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto, Descriptors$FileDescriptor[] arrdescriptors$FileDescriptor, Descriptors$DescriptorPool descriptors$DescriptorPool, boolean bl2) {
        int n2;
        this.pool = descriptors$DescriptorPool;
        this.proto = descriptorProtos$FileDescriptorProto;
        this.dependencies = (Descriptors$FileDescriptor[])arrdescriptors$FileDescriptor.clone();
        HashMap<String, Descriptors$FileDescriptor> hashMap = new HashMap<String, Descriptors$FileDescriptor>();
        for (Descriptors$FileDescriptor object2 : arrdescriptors$FileDescriptor) {
            hashMap.put(object2.getName(), object2);
        }
        ArrayList arrayList = new ArrayList();
        for (n2 = 0; n2 < descriptorProtos$FileDescriptorProto.getPublicDependencyCount(); ++n2) {
            int n3 = descriptorProtos$FileDescriptorProto.getPublicDependency(n2);
            if (n3 < 0) throw new Descriptors$DescriptorValidationException(this, "Invalid public dependency index.", null);
            if (n3 >= descriptorProtos$FileDescriptorProto.getDependencyCount()) {
                throw new Descriptors$DescriptorValidationException(this, "Invalid public dependency index.", null);
            }
            String string = descriptorProtos$FileDescriptorProto.getDependency(n3);
            Descriptors$FileDescriptor descriptors$FileDescriptor = (Descriptors$FileDescriptor)hashMap.get(string);
            if (descriptors$FileDescriptor == null) {
                String string2;
                if (bl2) continue;
                String string3 = String.valueOf(string);
                if (string3.length() != 0) {
                    string2 = "Invalid public dependency: ".concat(string3);
                    throw new Descriptors$DescriptorValidationException(this, string2, null);
                }
                string2 = new String("Invalid public dependency: ");
                throw new Descriptors$DescriptorValidationException(this, string2, null);
            }
            arrayList.add(descriptors$FileDescriptor);
        }
        this.publicDependencies = new Descriptors$FileDescriptor[arrayList.size()];
        arrayList.toArray(this.publicDependencies);
        descriptors$DescriptorPool.addPackage(this.getPackage(), this);
        this.messageTypes = new Descriptors$Descriptor[descriptorProtos$FileDescriptorProto.getMessageTypeCount()];
        for (n2 = 0; n2 < descriptorProtos$FileDescriptorProto.getMessageTypeCount(); ++n2) {
            this.messageTypes[n2] = new Descriptors$Descriptor(descriptorProtos$FileDescriptorProto.getMessageType(n2), this, null, n2, null);
        }
        this.enumTypes = new Descriptors$EnumDescriptor[descriptorProtos$FileDescriptorProto.getEnumTypeCount()];
        for (n2 = 0; n2 < descriptorProtos$FileDescriptorProto.getEnumTypeCount(); ++n2) {
            this.enumTypes[n2] = new Descriptors$EnumDescriptor(descriptorProtos$FileDescriptorProto.getEnumType(n2), this, null, n2, null);
        }
        this.services = new Descriptors$ServiceDescriptor[descriptorProtos$FileDescriptorProto.getServiceCount()];
        for (n2 = 0; n2 < descriptorProtos$FileDescriptorProto.getServiceCount(); ++n2) {
            this.services[n2] = new Descriptors$ServiceDescriptor(descriptorProtos$FileDescriptorProto.getService(n2), this, n2, null);
        }
        this.extensions = new Descriptors$FieldDescriptor[descriptorProtos$FileDescriptorProto.getExtensionCount()];
        n2 = 0;
        while (n2 < descriptorProtos$FileDescriptorProto.getExtensionCount()) {
            this.extensions[n2] = new Descriptors$FieldDescriptor(descriptorProtos$FileDescriptorProto.getExtension(n2), this, null, n2, true, null);
            ++n2;
        }
    }

    Descriptors$FileDescriptor(String string, Descriptors$Descriptor descriptors$Descriptor) {
        this.pool = new Descriptors$DescriptorPool(new Descriptors$FileDescriptor[0], true);
        this.proto = DescriptorProtos$FileDescriptorProto.newBuilder().setName(String.valueOf(descriptors$Descriptor.getFullName()).concat(".placeholder.proto")).setPackage(string).addMessageType(descriptors$Descriptor.toProto()).build();
        this.dependencies = new Descriptors$FileDescriptor[0];
        this.publicDependencies = new Descriptors$FileDescriptor[0];
        this.messageTypes = new Descriptors$Descriptor[]{descriptors$Descriptor};
        this.enumTypes = new Descriptors$EnumDescriptor[0];
        this.services = new Descriptors$ServiceDescriptor[0];
        this.extensions = new Descriptors$FieldDescriptor[0];
        this.pool.addPackage(string, this);
        this.pool.addSymbol(descriptors$Descriptor);
    }

    private void crossLink() {
        for (Descriptors$Descriptor descriptors$Descriptor22 : this.messageTypes) {
            Descriptors$Descriptor.access$700(descriptors$Descriptor22);
        }
        for (Descriptors$Descriptor descriptors$Descriptor : this.services) {
            Descriptors$ServiceDescriptor.access$800((Descriptors$ServiceDescriptor)((Object)descriptors$Descriptor));
        }
        Descriptors$Descriptor[] arrdescriptors$Descriptor = this.extensions;
        int n2 = arrdescriptors$Descriptor.length;
        int n3 = 0;
        while (n3 < n2) {
            Descriptors$Descriptor descriptors$Descriptor2 = arrdescriptors$Descriptor[n3];
            Descriptors$FieldDescriptor.access$900((Descriptors$FieldDescriptor)((Object)descriptors$Descriptor2));
            ++n3;
        }
    }

    private void setProto(DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto) {
        int n2;
        this.proto = descriptorProtos$FileDescriptorProto;
        for (n2 = 0; n2 < this.messageTypes.length; ++n2) {
            Descriptors$Descriptor.access$1000(this.messageTypes[n2], descriptorProtos$FileDescriptorProto.getMessageType(n2));
        }
        for (n2 = 0; n2 < this.enumTypes.length; ++n2) {
            Descriptors$EnumDescriptor.access$1100(this.enumTypes[n2], descriptorProtos$FileDescriptorProto.getEnumType(n2));
        }
        for (n2 = 0; n2 < this.services.length; ++n2) {
            Descriptors$ServiceDescriptor.access$1200(this.services[n2], descriptorProtos$FileDescriptorProto.getService(n2));
        }
        n2 = 0;
        while (n2 < this.extensions.length) {
            Descriptors$FieldDescriptor.access$1300(this.extensions[n2], descriptorProtos$FileDescriptorProto.getExtension(n2));
            ++n2;
        }
    }

    boolean supportsUnknownEnumValue() {
        if (this.getSyntax() != Descriptors$FileDescriptor$Syntax.PROTO3) return false;
        return true;
    }

    static /* synthetic */ Descriptors$DescriptorPool access$1400(Descriptors$FileDescriptor descriptors$FileDescriptor) {
        return descriptors$FileDescriptor.pool;
    }
}

