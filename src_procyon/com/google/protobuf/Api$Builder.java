package com.google.protobuf;

import java.util.*;
import java.io.*;

public final class Api$Builder extends GeneratedMessage$Builder implements ApiOrBuilder
{
    private int bitField0_;
    private Object name_;
    private List methods_;
    private RepeatedFieldBuilder methodsBuilder_;
    private List options_;
    private RepeatedFieldBuilder optionsBuilder_;
    private Object version_;
    private SourceContext sourceContext_;
    private SingleFieldBuilder sourceContextBuilder_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return ApiProto.internal_static_google_protobuf_Api_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return ApiProto.internal_static_google_protobuf_Api_fieldAccessorTable.ensureFieldAccessorsInitialized(Api.class, Api$Builder.class);
    }
    
    private Api$Builder() {
        this.name_ = "";
        this.methods_ = Collections.emptyList();
        this.options_ = Collections.emptyList();
        this.version_ = "";
        this.sourceContext_ = null;
        this.maybeForceBuilderInitialization();
    }
    
    private Api$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.name_ = "";
        this.methods_ = Collections.emptyList();
        this.options_ = Collections.emptyList();
        this.version_ = "";
        this.sourceContext_ = null;
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (GeneratedMessage.alwaysUseFieldBuilders) {
            this.getMethodsFieldBuilder();
            this.getOptionsFieldBuilder();
        }
    }
    
    public Api$Builder clear() {
        super.clear();
        this.name_ = "";
        if (this.methodsBuilder_ == null) {
            this.methods_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFFD;
        }
        else {
            this.methodsBuilder_.clear();
        }
        if (this.optionsBuilder_ == null) {
            this.options_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFFB;
        }
        else {
            this.optionsBuilder_.clear();
        }
        this.version_ = "";
        if (this.sourceContextBuilder_ == null) {
            this.sourceContext_ = null;
        }
        else {
            this.sourceContext_ = null;
            this.sourceContextBuilder_ = null;
        }
        return this;
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        return ApiProto.internal_static_google_protobuf_Api_descriptor;
    }
    
    public Api getDefaultInstanceForType() {
        return Api.getDefaultInstance();
    }
    
    public Api build() {
        final Api buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public Api buildPartial() {
        final Api api = new Api(this, null);
        final int bitField0_ = this.bitField0_;
        final int n = 0;
        api.name_ = this.name_;
        if (this.methodsBuilder_ == null) {
            if ((this.bitField0_ & 0x2) == 0x2) {
                this.methods_ = Collections.unmodifiableList((List<?>)this.methods_);
                this.bitField0_ &= 0xFFFFFFFD;
            }
            api.methods_ = this.methods_;
        }
        else {
            api.methods_ = this.methodsBuilder_.build();
        }
        if (this.optionsBuilder_ == null) {
            if ((this.bitField0_ & 0x4) == 0x4) {
                this.options_ = Collections.unmodifiableList((List<?>)this.options_);
                this.bitField0_ &= 0xFFFFFFFB;
            }
            api.options_ = this.options_;
        }
        else {
            api.options_ = this.optionsBuilder_.build();
        }
        api.version_ = this.version_;
        if (this.sourceContextBuilder_ == null) {
            api.sourceContext_ = this.sourceContext_;
        }
        else {
            api.sourceContext_ = (SourceContext)this.sourceContextBuilder_.build();
        }
        api.bitField0_ = n;
        this.onBuilt();
        return api;
    }
    
    public Api$Builder mergeFrom(final Message message) {
        if (message instanceof Api) {
            return this.mergeFrom((Api)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public Api$Builder mergeFrom(final Api api) {
        if (api == Api.getDefaultInstance()) {
            return this;
        }
        if (!api.getName().isEmpty()) {
            this.name_ = api.name_;
            this.onChanged();
        }
        if (this.methodsBuilder_ == null) {
            if (!api.methods_.isEmpty()) {
                if (this.methods_.isEmpty()) {
                    this.methods_ = api.methods_;
                    this.bitField0_ &= 0xFFFFFFFD;
                }
                else {
                    this.ensureMethodsIsMutable();
                    this.methods_.addAll(api.methods_);
                }
                this.onChanged();
            }
        }
        else if (!api.methods_.isEmpty()) {
            if (this.methodsBuilder_.isEmpty()) {
                this.methodsBuilder_.dispose();
                this.methodsBuilder_ = null;
                this.methods_ = api.methods_;
                this.bitField0_ &= 0xFFFFFFFD;
                this.methodsBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? this.getMethodsFieldBuilder() : null);
            }
            else {
                this.methodsBuilder_.addAllMessages(api.methods_);
            }
        }
        if (this.optionsBuilder_ == null) {
            if (!api.options_.isEmpty()) {
                if (this.options_.isEmpty()) {
                    this.options_ = api.options_;
                    this.bitField0_ &= 0xFFFFFFFB;
                }
                else {
                    this.ensureOptionsIsMutable();
                    this.options_.addAll(api.options_);
                }
                this.onChanged();
            }
        }
        else if (!api.options_.isEmpty()) {
            if (this.optionsBuilder_.isEmpty()) {
                this.optionsBuilder_.dispose();
                this.optionsBuilder_ = null;
                this.options_ = api.options_;
                this.bitField0_ &= 0xFFFFFFFB;
                this.optionsBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? this.getOptionsFieldBuilder() : null);
            }
            else {
                this.optionsBuilder_.addAllMessages(api.options_);
            }
        }
        if (!api.getVersion().isEmpty()) {
            this.version_ = api.version_;
            this.onChanged();
        }
        if (api.hasSourceContext()) {
            this.mergeSourceContext(api.getSourceContext());
        }
        this.onChanged();
        return this;
    }
    
    public final boolean isInitialized() {
        return true;
    }
    
    public Api$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        Api api = null;
        try {
            api = (Api)Api.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            api = (Api)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (api != null) {
                this.mergeFrom(api);
            }
        }
        return this;
    }
    
    public String getName() {
        final Object name_ = this.name_;
        if (!(name_ instanceof String)) {
            final ByteString byteString = (ByteString)name_;
            final String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.name_ = stringUtf8;
            }
            return stringUtf8;
        }
        return (String)name_;
    }
    
    public ByteString getNameBytes() {
        final Object name_ = this.name_;
        if (name_ instanceof String) {
            return (ByteString)(this.name_ = ByteString.copyFromUtf8((String)name_));
        }
        return (ByteString)name_;
    }
    
    public Api$Builder setName(final String name_) {
        if (name_ == null) {
            throw new NullPointerException();
        }
        this.name_ = name_;
        this.onChanged();
        return this;
    }
    
    public Api$Builder clearName() {
        this.name_ = Api.getDefaultInstance().getName();
        this.onChanged();
        return this;
    }
    
    public Api$Builder setNameBytes(final ByteString name_) {
        if (name_ == null) {
            throw new NullPointerException();
        }
        this.name_ = name_;
        this.onChanged();
        return this;
    }
    
    private void ensureMethodsIsMutable() {
        if ((this.bitField0_ & 0x2) != 0x2) {
            this.methods_ = new ArrayList(this.methods_);
            this.bitField0_ |= 0x2;
        }
    }
    
    public List getMethodsList() {
        if (this.methodsBuilder_ == null) {
            return Collections.unmodifiableList((List<?>)this.methods_);
        }
        return this.methodsBuilder_.getMessageList();
    }
    
    public int getMethodsCount() {
        if (this.methodsBuilder_ == null) {
            return this.methods_.size();
        }
        return this.methodsBuilder_.getCount();
    }
    
    public Method getMethods(final int n) {
        if (this.methodsBuilder_ == null) {
            return this.methods_.get(n);
        }
        return (Method)this.methodsBuilder_.getMessage(n);
    }
    
    public Api$Builder setMethods(final int n, final Method method) {
        if (this.methodsBuilder_ == null) {
            if (method == null) {
                throw new NullPointerException();
            }
            this.ensureMethodsIsMutable();
            this.methods_.set(n, method);
            this.onChanged();
        }
        else {
            this.methodsBuilder_.setMessage(n, method);
        }
        return this;
    }
    
    public Api$Builder setMethods(final int n, final Method$Builder method$Builder) {
        if (this.methodsBuilder_ == null) {
            this.ensureMethodsIsMutable();
            this.methods_.set(n, method$Builder.build());
            this.onChanged();
        }
        else {
            this.methodsBuilder_.setMessage(n, method$Builder.build());
        }
        return this;
    }
    
    public Api$Builder addMethods(final Method method) {
        if (this.methodsBuilder_ == null) {
            if (method == null) {
                throw new NullPointerException();
            }
            this.ensureMethodsIsMutable();
            this.methods_.add(method);
            this.onChanged();
        }
        else {
            this.methodsBuilder_.addMessage(method);
        }
        return this;
    }
    
    public Api$Builder addMethods(final int n, final Method method) {
        if (this.methodsBuilder_ == null) {
            if (method == null) {
                throw new NullPointerException();
            }
            this.ensureMethodsIsMutable();
            this.methods_.add(n, method);
            this.onChanged();
        }
        else {
            this.methodsBuilder_.addMessage(n, method);
        }
        return this;
    }
    
    public Api$Builder addMethods(final Method$Builder method$Builder) {
        if (this.methodsBuilder_ == null) {
            this.ensureMethodsIsMutable();
            this.methods_.add(method$Builder.build());
            this.onChanged();
        }
        else {
            this.methodsBuilder_.addMessage(method$Builder.build());
        }
        return this;
    }
    
    public Api$Builder addMethods(final int n, final Method$Builder method$Builder) {
        if (this.methodsBuilder_ == null) {
            this.ensureMethodsIsMutable();
            this.methods_.add(n, method$Builder.build());
            this.onChanged();
        }
        else {
            this.methodsBuilder_.addMessage(n, method$Builder.build());
        }
        return this;
    }
    
    public Api$Builder addAllMethods(final Iterable iterable) {
        if (this.methodsBuilder_ == null) {
            this.ensureMethodsIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.methods_);
            this.onChanged();
        }
        else {
            this.methodsBuilder_.addAllMessages(iterable);
        }
        return this;
    }
    
    public Api$Builder clearMethods() {
        if (this.methodsBuilder_ == null) {
            this.methods_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFFD;
            this.onChanged();
        }
        else {
            this.methodsBuilder_.clear();
        }
        return this;
    }
    
    public Api$Builder removeMethods(final int n) {
        if (this.methodsBuilder_ == null) {
            this.ensureMethodsIsMutable();
            this.methods_.remove(n);
            this.onChanged();
        }
        else {
            this.methodsBuilder_.remove(n);
        }
        return this;
    }
    
    public Method$Builder getMethodsBuilder(final int n) {
        return (Method$Builder)this.getMethodsFieldBuilder().getBuilder(n);
    }
    
    public MethodOrBuilder getMethodsOrBuilder(final int n) {
        if (this.methodsBuilder_ == null) {
            return this.methods_.get(n);
        }
        return (MethodOrBuilder)this.methodsBuilder_.getMessageOrBuilder(n);
    }
    
    public List getMethodsOrBuilderList() {
        if (this.methodsBuilder_ != null) {
            return this.methodsBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList((List<?>)this.methods_);
    }
    
    public Method$Builder addMethodsBuilder() {
        return (Method$Builder)this.getMethodsFieldBuilder().addBuilder(Method.getDefaultInstance());
    }
    
    public Method$Builder addMethodsBuilder(final int n) {
        return (Method$Builder)this.getMethodsFieldBuilder().addBuilder(n, Method.getDefaultInstance());
    }
    
    public List getMethodsBuilderList() {
        return this.getMethodsFieldBuilder().getBuilderList();
    }
    
    private RepeatedFieldBuilder getMethodsFieldBuilder() {
        if (this.methodsBuilder_ == null) {
            this.methodsBuilder_ = new RepeatedFieldBuilder(this.methods_, (this.bitField0_ & 0x2) == 0x2, this.getParentForChildren(), this.isClean());
            this.methods_ = null;
        }
        return this.methodsBuilder_;
    }
    
    private void ensureOptionsIsMutable() {
        if ((this.bitField0_ & 0x4) != 0x4) {
            this.options_ = new ArrayList(this.options_);
            this.bitField0_ |= 0x4;
        }
    }
    
    public List getOptionsList() {
        if (this.optionsBuilder_ == null) {
            return Collections.unmodifiableList((List<?>)this.options_);
        }
        return this.optionsBuilder_.getMessageList();
    }
    
    public int getOptionsCount() {
        if (this.optionsBuilder_ == null) {
            return this.options_.size();
        }
        return this.optionsBuilder_.getCount();
    }
    
    public Option getOptions(final int n) {
        if (this.optionsBuilder_ == null) {
            return this.options_.get(n);
        }
        return (Option)this.optionsBuilder_.getMessage(n);
    }
    
    public Api$Builder setOptions(final int n, final Option option) {
        if (this.optionsBuilder_ == null) {
            if (option == null) {
                throw new NullPointerException();
            }
            this.ensureOptionsIsMutable();
            this.options_.set(n, option);
            this.onChanged();
        }
        else {
            this.optionsBuilder_.setMessage(n, option);
        }
        return this;
    }
    
    public Api$Builder setOptions(final int n, final Option$Builder option$Builder) {
        if (this.optionsBuilder_ == null) {
            this.ensureOptionsIsMutable();
            this.options_.set(n, option$Builder.build());
            this.onChanged();
        }
        else {
            this.optionsBuilder_.setMessage(n, option$Builder.build());
        }
        return this;
    }
    
    public Api$Builder addOptions(final Option option) {
        if (this.optionsBuilder_ == null) {
            if (option == null) {
                throw new NullPointerException();
            }
            this.ensureOptionsIsMutable();
            this.options_.add(option);
            this.onChanged();
        }
        else {
            this.optionsBuilder_.addMessage(option);
        }
        return this;
    }
    
    public Api$Builder addOptions(final int n, final Option option) {
        if (this.optionsBuilder_ == null) {
            if (option == null) {
                throw new NullPointerException();
            }
            this.ensureOptionsIsMutable();
            this.options_.add(n, option);
            this.onChanged();
        }
        else {
            this.optionsBuilder_.addMessage(n, option);
        }
        return this;
    }
    
    public Api$Builder addOptions(final Option$Builder option$Builder) {
        if (this.optionsBuilder_ == null) {
            this.ensureOptionsIsMutable();
            this.options_.add(option$Builder.build());
            this.onChanged();
        }
        else {
            this.optionsBuilder_.addMessage(option$Builder.build());
        }
        return this;
    }
    
    public Api$Builder addOptions(final int n, final Option$Builder option$Builder) {
        if (this.optionsBuilder_ == null) {
            this.ensureOptionsIsMutable();
            this.options_.add(n, option$Builder.build());
            this.onChanged();
        }
        else {
            this.optionsBuilder_.addMessage(n, option$Builder.build());
        }
        return this;
    }
    
    public Api$Builder addAllOptions(final Iterable iterable) {
        if (this.optionsBuilder_ == null) {
            this.ensureOptionsIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.options_);
            this.onChanged();
        }
        else {
            this.optionsBuilder_.addAllMessages(iterable);
        }
        return this;
    }
    
    public Api$Builder clearOptions() {
        if (this.optionsBuilder_ == null) {
            this.options_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFFB;
            this.onChanged();
        }
        else {
            this.optionsBuilder_.clear();
        }
        return this;
    }
    
    public Api$Builder removeOptions(final int n) {
        if (this.optionsBuilder_ == null) {
            this.ensureOptionsIsMutable();
            this.options_.remove(n);
            this.onChanged();
        }
        else {
            this.optionsBuilder_.remove(n);
        }
        return this;
    }
    
    public Option$Builder getOptionsBuilder(final int n) {
        return (Option$Builder)this.getOptionsFieldBuilder().getBuilder(n);
    }
    
    public OptionOrBuilder getOptionsOrBuilder(final int n) {
        if (this.optionsBuilder_ == null) {
            return this.options_.get(n);
        }
        return (OptionOrBuilder)this.optionsBuilder_.getMessageOrBuilder(n);
    }
    
    public List getOptionsOrBuilderList() {
        if (this.optionsBuilder_ != null) {
            return this.optionsBuilder_.getMessageOrBuilderList();
        }
        return Collections.unmodifiableList((List<?>)this.options_);
    }
    
    public Option$Builder addOptionsBuilder() {
        return (Option$Builder)this.getOptionsFieldBuilder().addBuilder(Option.getDefaultInstance());
    }
    
    public Option$Builder addOptionsBuilder(final int n) {
        return (Option$Builder)this.getOptionsFieldBuilder().addBuilder(n, Option.getDefaultInstance());
    }
    
    public List getOptionsBuilderList() {
        return this.getOptionsFieldBuilder().getBuilderList();
    }
    
    private RepeatedFieldBuilder getOptionsFieldBuilder() {
        if (this.optionsBuilder_ == null) {
            this.optionsBuilder_ = new RepeatedFieldBuilder(this.options_, (this.bitField0_ & 0x4) == 0x4, this.getParentForChildren(), this.isClean());
            this.options_ = null;
        }
        return this.optionsBuilder_;
    }
    
    public String getVersion() {
        final Object version_ = this.version_;
        if (!(version_ instanceof String)) {
            final ByteString byteString = (ByteString)version_;
            final String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.version_ = stringUtf8;
            }
            return stringUtf8;
        }
        return (String)version_;
    }
    
    public ByteString getVersionBytes() {
        final Object version_ = this.version_;
        if (version_ instanceof String) {
            return (ByteString)(this.version_ = ByteString.copyFromUtf8((String)version_));
        }
        return (ByteString)version_;
    }
    
    public Api$Builder setVersion(final String version_) {
        if (version_ == null) {
            throw new NullPointerException();
        }
        this.version_ = version_;
        this.onChanged();
        return this;
    }
    
    public Api$Builder clearVersion() {
        this.version_ = Api.getDefaultInstance().getVersion();
        this.onChanged();
        return this;
    }
    
    public Api$Builder setVersionBytes(final ByteString version_) {
        if (version_ == null) {
            throw new NullPointerException();
        }
        this.version_ = version_;
        this.onChanged();
        return this;
    }
    
    public boolean hasSourceContext() {
        return this.sourceContextBuilder_ != null || this.sourceContext_ != null;
    }
    
    public SourceContext getSourceContext() {
        if (this.sourceContextBuilder_ == null) {
            return (this.sourceContext_ == null) ? SourceContext.getDefaultInstance() : this.sourceContext_;
        }
        return (SourceContext)this.sourceContextBuilder_.getMessage();
    }
    
    public Api$Builder setSourceContext(final SourceContext sourceContext) {
        if (this.sourceContextBuilder_ == null) {
            if (sourceContext == null) {
                throw new NullPointerException();
            }
            this.sourceContext_ = sourceContext;
            this.onChanged();
        }
        else {
            this.sourceContextBuilder_.setMessage(sourceContext);
        }
        return this;
    }
    
    public Api$Builder setSourceContext(final SourceContext$Builder sourceContext$Builder) {
        if (this.sourceContextBuilder_ == null) {
            this.sourceContext_ = sourceContext$Builder.build();
            this.onChanged();
        }
        else {
            this.sourceContextBuilder_.setMessage(sourceContext$Builder.build());
        }
        return this;
    }
    
    public Api$Builder mergeSourceContext(final SourceContext sourceContext_) {
        if (this.sourceContextBuilder_ == null) {
            if (this.sourceContext_ != null) {
                this.sourceContext_ = SourceContext.newBuilder(this.sourceContext_).mergeFrom(sourceContext_).buildPartial();
            }
            else {
                this.sourceContext_ = sourceContext_;
            }
            this.onChanged();
        }
        else {
            this.sourceContextBuilder_.mergeFrom(sourceContext_);
        }
        return this;
    }
    
    public Api$Builder clearSourceContext() {
        if (this.sourceContextBuilder_ == null) {
            this.sourceContext_ = null;
            this.onChanged();
        }
        else {
            this.sourceContext_ = null;
            this.sourceContextBuilder_ = null;
        }
        return this;
    }
    
    public SourceContext$Builder getSourceContextBuilder() {
        this.onChanged();
        return (SourceContext$Builder)this.getSourceContextFieldBuilder().getBuilder();
    }
    
    public SourceContextOrBuilder getSourceContextOrBuilder() {
        if (this.sourceContextBuilder_ != null) {
            return (SourceContextOrBuilder)this.sourceContextBuilder_.getMessageOrBuilder();
        }
        return (this.sourceContext_ == null) ? SourceContext.getDefaultInstance() : this.sourceContext_;
    }
    
    private SingleFieldBuilder getSourceContextFieldBuilder() {
        if (this.sourceContextBuilder_ == null) {
            this.sourceContextBuilder_ = new SingleFieldBuilder(this.getSourceContext(), this.getParentForChildren(), this.isClean());
            this.sourceContext_ = null;
        }
        return this.sourceContextBuilder_;
    }
    
    public final Api$Builder setUnknownFields(final UnknownFieldSet set) {
        return this;
    }
    
    public final Api$Builder mergeUnknownFields(final UnknownFieldSet set) {
        return this;
    }
}
