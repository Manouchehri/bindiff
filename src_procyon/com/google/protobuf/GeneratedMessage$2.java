package com.google.protobuf;

final class GeneratedMessage$2 extends GeneratedMessage$CachedDescriptorRetriever
{
    final /* synthetic */ Message val$scope;
    final /* synthetic */ String val$name;
    
    GeneratedMessage$2(final Message val$scope, final String val$name) {
        this.val$scope = val$scope;
        this.val$name = val$name;
        super(null);
    }
    
    protected Descriptors$FieldDescriptor loadDescriptor() {
        return this.val$scope.getDescriptorForType().findFieldByName(this.val$name);
    }
}
