package com.google.protobuf;

import java.util.logging.*;
import java.util.*;
import java.lang.ref.*;

public final class Descriptors$FileDescriptor extends Descriptors$GenericDescriptor
{
    private DescriptorProtos$FileDescriptorProto proto;
    private final Descriptors$Descriptor[] messageTypes;
    private final Descriptors$EnumDescriptor[] enumTypes;
    private final Descriptors$ServiceDescriptor[] services;
    private final Descriptors$FieldDescriptor[] extensions;
    private final Descriptors$FileDescriptor[] dependencies;
    private final Descriptors$FileDescriptor[] publicDependencies;
    private final Descriptors$DescriptorPool pool;
    
    public DescriptorProtos$FileDescriptorProto toProto() {
        return this.proto;
    }
    
    public String getName() {
        return this.proto.getName();
    }
    
    public Descriptors$FileDescriptor getFile() {
        return this;
    }
    
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
        return Collections.unmodifiableList((List<?>)Arrays.asList((T[])this.messageTypes));
    }
    
    public List getEnumTypes() {
        return Collections.unmodifiableList((List<?>)Arrays.asList((T[])this.enumTypes));
    }
    
    public List getServices() {
        return Collections.unmodifiableList((List<?>)Arrays.asList((T[])this.services));
    }
    
    public List getExtensions() {
        return Collections.unmodifiableList((List<?>)Arrays.asList((T[])this.extensions));
    }
    
    public List getDependencies() {
        return Collections.unmodifiableList((List<?>)Arrays.asList((T[])this.dependencies));
    }
    
    public List getPublicDependencies() {
        return Collections.unmodifiableList((List<?>)Arrays.asList((T[])this.publicDependencies));
    }
    
    public Descriptors$FileDescriptor$Syntax getSyntax() {
        if (Descriptors$FileDescriptor$Syntax.PROTO3.name.equals(this.proto.getSyntax())) {
            return Descriptors$FileDescriptor$Syntax.PROTO3;
        }
        return Descriptors$FileDescriptor$Syntax.PROTO2;
    }
    
    public Descriptors$Descriptor findMessageTypeByName(String string) {
        if (string.indexOf(46) != -1) {
            return null;
        }
        if (this.getPackage().length() > 0) {
            final String value = String.valueOf(String.valueOf(this.getPackage()));
            final String value2 = String.valueOf(String.valueOf(string));
            string = new StringBuilder(1 + value.length() + value2.length()).append(value).append(".").append(value2).toString();
        }
        final Descriptors$GenericDescriptor symbol = this.pool.findSymbol(string);
        if (symbol != null && symbol instanceof Descriptors$Descriptor && symbol.getFile() == this) {
            return (Descriptors$Descriptor)symbol;
        }
        return null;
    }
    
    public Descriptors$EnumDescriptor findEnumTypeByName(String string) {
        if (string.indexOf(46) != -1) {
            return null;
        }
        if (this.getPackage().length() > 0) {
            final String value = String.valueOf(String.valueOf(this.getPackage()));
            final String value2 = String.valueOf(String.valueOf(string));
            string = new StringBuilder(1 + value.length() + value2.length()).append(value).append(".").append(value2).toString();
        }
        final Descriptors$GenericDescriptor symbol = this.pool.findSymbol(string);
        if (symbol != null && symbol instanceof Descriptors$EnumDescriptor && symbol.getFile() == this) {
            return (Descriptors$EnumDescriptor)symbol;
        }
        return null;
    }
    
    public Descriptors$ServiceDescriptor findServiceByName(String string) {
        if (string.indexOf(46) != -1) {
            return null;
        }
        if (this.getPackage().length() > 0) {
            final String value = String.valueOf(String.valueOf(this.getPackage()));
            final String value2 = String.valueOf(String.valueOf(string));
            string = new StringBuilder(1 + value.length() + value2.length()).append(value).append(".").append(value2).toString();
        }
        final Descriptors$GenericDescriptor symbol = this.pool.findSymbol(string);
        if (symbol != null && symbol instanceof Descriptors$ServiceDescriptor && symbol.getFile() == this) {
            return (Descriptors$ServiceDescriptor)symbol;
        }
        return null;
    }
    
    public Descriptors$FieldDescriptor findExtensionByName(String string) {
        if (string.indexOf(46) != -1) {
            return null;
        }
        if (this.getPackage().length() > 0) {
            final String value = String.valueOf(String.valueOf(this.getPackage()));
            final String value2 = String.valueOf(String.valueOf(string));
            string = new StringBuilder(1 + value.length() + value2.length()).append(value).append(".").append(value2).toString();
        }
        final Descriptors$GenericDescriptor symbol = this.pool.findSymbol(string);
        if (symbol != null && symbol instanceof Descriptors$FieldDescriptor && symbol.getFile() == this) {
            return (Descriptors$FieldDescriptor)symbol;
        }
        return null;
    }
    
    public static Descriptors$FileDescriptor buildFrom(final DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto, final Descriptors$FileDescriptor[] array) {
        return buildFrom(descriptorProtos$FileDescriptorProto, array, false);
    }
    
    private static Descriptors$FileDescriptor buildFrom(final DescriptorProtos$FileDescriptorProto descriptorProtos$FileDescriptorProto, final Descriptors$FileDescriptor[] array, final boolean b) {
        final Descriptors$FileDescriptor descriptors$FileDescriptor = new Descriptors$FileDescriptor(descriptorProtos$FileDescriptorProto, array, new Descriptors$DescriptorPool(array, b), b);
        descriptors$FileDescriptor.crossLink();
        return descriptors$FileDescriptor;
    }
    
    public static void internalBuildGeneratedFileFrom(final String[] array, final Descriptors$FileDescriptor[] array2, final Descriptors$FileDescriptor$InternalDescriptorAssigner descriptors$FileDescriptor$InternalDescriptorAssigner) {
        final StringBuilder sb = new StringBuilder();
        for (int length = array.length, i = 0; i < length; ++i) {
            sb.append(array[i]);
        }
        final byte[] bytes = sb.toString().getBytes(Internal.ISO_8859_1);
        DescriptorProtos$FileDescriptorProto from;
        try {
            from = DescriptorProtos$FileDescriptorProto.parseFrom(bytes);
        }
        catch (InvalidProtocolBufferException ex) {
            throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", ex);
        }
        Descriptors$FileDescriptor build;
        try {
            build = buildFrom(from, array2, true);
        }
        catch (Descriptors$DescriptorValidationException ex2) {
            final String value = String.valueOf(String.valueOf(from.getName()));
            throw new IllegalArgumentException(new StringBuilder(35 + value.length()).append("Invalid embedded descriptor for \"").append(value).append("\".").toString(), ex2);
        }
        final ExtensionRegistry assignDescriptors = descriptors$FileDescriptor$InternalDescriptorAssigner.assignDescriptors(build);
        if (assignDescriptors != null) {
            DescriptorProtos$FileDescriptorProto from2;
            try {
                from2 = DescriptorProtos$FileDescriptorProto.parseFrom(bytes, assignDescriptors);
            }
            catch (InvalidProtocolBufferException ex3) {
                throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", ex3);
            }
            build.setProto(from2);
        }
    }
    
    public static void internalBuildGeneratedFileFrom(final String[] array, final Class clazz, final String[] array2, final String[] array3, final Descriptors$FileDescriptor$InternalDescriptorAssigner descriptors$FileDescriptor$InternalDescriptorAssigner) {
        final ArrayList<Descriptors$FileDescriptor> list = new ArrayList<Descriptors$FileDescriptor>();
        for (int i = 0; i < array2.length; ++i) {
            try {
                list.add((Descriptors$FileDescriptor)clazz.getClassLoader().loadClass(array2[i]).getField("descriptor").get(null));
            }
            catch (Exception ex) {
                final Logger access$100 = Descriptors.logger;
                final String value = String.valueOf(String.valueOf(array3[i]));
                access$100.warning(new StringBuilder(36 + value.length()).append("Descriptors for \"").append(value).append("\" can not be found.").toString());
            }
        }
        final Descriptors$FileDescriptor[] array4 = new Descriptors$FileDescriptor[list.size()];
        list.toArray(array4);
        internalBuildGeneratedFileFrom(array, array4, descriptors$FileDescriptor$InternalDescriptorAssigner);
    }
    
    public static void internalUpdateFileDescriptor(final Descriptors$FileDescriptor descriptors$FileDescriptor, final ExtensionRegistry extensionRegistry) {
        final ByteString byteString = descriptors$FileDescriptor.proto.toByteString();
        DescriptorProtos$FileDescriptorProto from;
        try {
            from = DescriptorProtos$FileDescriptorProto.parseFrom(byteString, extensionRegistry);
        }
        catch (InvalidProtocolBufferException ex) {
            throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", ex);
        }
        descriptors$FileDescriptor.setProto(from);
    }
    
    private Descriptors$FileDescriptor(final DescriptorProtos$FileDescriptorProto proto, final Descriptors$FileDescriptor[] array, final Descriptors$DescriptorPool pool, final boolean b) {
        this.pool = pool;
        this.proto = proto;
        this.dependencies = array.clone();
        final HashMap<String, Descriptors$FileDescriptor> hashMap = new HashMap<String, Descriptors$FileDescriptor>();
        for (final Descriptors$FileDescriptor descriptors$FileDescriptor : array) {
            hashMap.put(descriptors$FileDescriptor.getName(), descriptors$FileDescriptor);
        }
        final ArrayList<Descriptors$FileDescriptor> list = new ArrayList<Descriptors$FileDescriptor>();
        for (int j = 0; j < proto.getPublicDependencyCount(); ++j) {
            final int publicDependency = proto.getPublicDependency(j);
            if (publicDependency < 0 || publicDependency >= proto.getDependencyCount()) {
                throw new Descriptors$DescriptorValidationException(this, "Invalid public dependency index.", null);
            }
            final String dependency = proto.getDependency(publicDependency);
            final Descriptors$FileDescriptor descriptors$FileDescriptor2 = hashMap.get(dependency);
            if (descriptors$FileDescriptor2 == null) {
                if (!b) {
                    final String s = "Invalid public dependency: ";
                    final String value = String.valueOf(dependency);
                    throw new Descriptors$DescriptorValidationException(this, (value.length() != 0) ? s.concat(value) : new String(s), null);
                }
            }
            else {
                list.add(descriptors$FileDescriptor2);
            }
        }
        list.toArray(this.publicDependencies = new Descriptors$FileDescriptor[list.size()]);
        pool.addPackage(this.getPackage(), this);
        this.messageTypes = new Descriptors$Descriptor[proto.getMessageTypeCount()];
        for (int k = 0; k < proto.getMessageTypeCount(); ++k) {
            this.messageTypes[k] = new Descriptors$Descriptor(proto.getMessageType(k), this, null, k, null);
        }
        this.enumTypes = new Descriptors$EnumDescriptor[proto.getEnumTypeCount()];
        for (int l = 0; l < proto.getEnumTypeCount(); ++l) {
            this.enumTypes[l] = new Descriptors$EnumDescriptor(proto.getEnumType(l), this, null, l, null);
        }
        this.services = new Descriptors$ServiceDescriptor[proto.getServiceCount()];
        for (int n = 0; n < proto.getServiceCount(); ++n) {
            this.services[n] = new Descriptors$ServiceDescriptor(proto.getService(n), this, n, null);
        }
        this.extensions = new Descriptors$FieldDescriptor[proto.getExtensionCount()];
        for (int n2 = 0; n2 < proto.getExtensionCount(); ++n2) {
            this.extensions[n2] = new Descriptors$FieldDescriptor(proto.getExtension(n2), this, null, n2, true, null);
        }
    }
    
    Descriptors$FileDescriptor(final String package1, final Descriptors$Descriptor descriptors$Descriptor) {
        this.pool = new Descriptors$DescriptorPool(new Descriptors$FileDescriptor[0], true);
        this.proto = DescriptorProtos$FileDescriptorProto.newBuilder().setName(String.valueOf(descriptors$Descriptor.getFullName()).concat(".placeholder.proto")).setPackage(package1).addMessageType(descriptors$Descriptor.toProto()).build();
        this.dependencies = new Descriptors$FileDescriptor[0];
        this.publicDependencies = new Descriptors$FileDescriptor[0];
        this.messageTypes = new Descriptors$Descriptor[] { descriptors$Descriptor };
        this.enumTypes = new Descriptors$EnumDescriptor[0];
        this.services = new Descriptors$ServiceDescriptor[0];
        this.extensions = new Descriptors$FieldDescriptor[0];
        this.pool.addPackage(package1, this);
        this.pool.addSymbol(descriptors$Descriptor);
    }
    
    private void crossLink() {
        final Descriptors$Descriptor[] messageTypes = this.messageTypes;
        for (int length = messageTypes.length, i = 0; i < length; ++i) {
            messageTypes[i].crossLink();
        }
        final Descriptors$ServiceDescriptor[] services = this.services;
        for (int length2 = services.length, j = 0; j < length2; ++j) {
            services[j].crossLink();
        }
        final Descriptors$FieldDescriptor[] extensions = this.extensions;
        for (int length3 = extensions.length, k = 0; k < length3; ++k) {
            extensions[k].crossLink();
        }
    }
    
    private void setProto(final DescriptorProtos$FileDescriptorProto proto) {
        this.proto = proto;
        for (int i = 0; i < this.messageTypes.length; ++i) {
            this.messageTypes[i].setProto(proto.getMessageType(i));
        }
        for (int j = 0; j < this.enumTypes.length; ++j) {
            this.enumTypes[j].setProto(proto.getEnumType(j));
        }
        for (int k = 0; k < this.services.length; ++k) {
            this.services[k].setProto(proto.getService(k));
        }
        for (int l = 0; l < this.extensions.length; ++l) {
            this.extensions[l].setProto(proto.getExtension(l));
        }
    }
    
    boolean supportsUnknownEnumValue() {
        return this.getSyntax() == Descriptors$FileDescriptor$Syntax.PROTO3;
    }
}
