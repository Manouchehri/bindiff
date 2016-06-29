package com.google.protobuf;

final class GeneratedMessage$3 extends GeneratedMessage$CachedDescriptorRetriever
{
    final /* synthetic */ Class val$singularType;
    final /* synthetic */ String val$descriptorOuterClass;
    final /* synthetic */ String val$extensionName;
    
    GeneratedMessage$3(final Class val$singularType, final String val$descriptorOuterClass, final String val$extensionName) {
        this.val$singularType = val$singularType;
        this.val$descriptorOuterClass = val$descriptorOuterClass;
        this.val$extensionName = val$extensionName;
        super(null);
    }
    
    protected Descriptors$FieldDescriptor loadDescriptor() {
        try {
            return ((Descriptors$FileDescriptor)this.val$singularType.getClassLoader().loadClass(this.val$descriptorOuterClass).getField("descriptor").get(null)).findExtensionByName(this.val$extensionName);
        }
        catch (Exception ex) {
            final String value = String.valueOf(String.valueOf(this.val$descriptorOuterClass));
            throw new RuntimeException(new StringBuilder(62 + value.length()).append("Cannot load descriptors: ").append(value).append(" is not a valid descriptor class name").toString(), ex);
        }
    }
}
