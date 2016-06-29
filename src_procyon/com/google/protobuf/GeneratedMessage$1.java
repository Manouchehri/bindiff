package com.google.protobuf;

final class GeneratedMessage$1 extends GeneratedMessage$CachedDescriptorRetriever
{
    final /* synthetic */ Message val$scope;
    final /* synthetic */ int val$descriptorIndex;
    
    GeneratedMessage$1(final Message val$scope, final int val$descriptorIndex) {
        this.val$scope = val$scope;
        this.val$descriptorIndex = val$descriptorIndex;
        super(null);
    }
    
    public Descriptors$FieldDescriptor loadDescriptor() {
        return this.val$scope.getDescriptorForType().getExtensions().get(this.val$descriptorIndex);
    }
}
