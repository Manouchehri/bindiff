package com.google.protobuf;

import java.util.*;
import java.io.*;

public final class Method$Builder extends GeneratedMessage$Builder implements MethodOrBuilder
{
    private int bitField0_;
    private Object name_;
    private Object requestTypeUrl_;
    private boolean requestStreaming_;
    private Object responseTypeUrl_;
    private boolean responseStreaming_;
    private List options_;
    private RepeatedFieldBuilder optionsBuilder_;
    
    public static final Descriptors$Descriptor getDescriptor() {
        return ApiProto.internal_static_google_protobuf_Method_descriptor;
    }
    
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return ApiProto.internal_static_google_protobuf_Method_fieldAccessorTable.ensureFieldAccessorsInitialized(Method.class, Method$Builder.class);
    }
    
    private Method$Builder() {
        this.name_ = "";
        this.requestTypeUrl_ = "";
        this.responseTypeUrl_ = "";
        this.options_ = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }
    
    private Method$Builder(final GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.name_ = "";
        this.requestTypeUrl_ = "";
        this.responseTypeUrl_ = "";
        this.options_ = Collections.emptyList();
        this.maybeForceBuilderInitialization();
    }
    
    private void maybeForceBuilderInitialization() {
        if (GeneratedMessage.alwaysUseFieldBuilders) {
            this.getOptionsFieldBuilder();
        }
    }
    
    public Method$Builder clear() {
        super.clear();
        this.name_ = "";
        this.requestTypeUrl_ = "";
        this.requestStreaming_ = false;
        this.responseTypeUrl_ = "";
        this.responseStreaming_ = false;
        if (this.optionsBuilder_ == null) {
            this.options_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFDF;
        }
        else {
            this.optionsBuilder_.clear();
        }
        return this;
    }
    
    public Descriptors$Descriptor getDescriptorForType() {
        return ApiProto.internal_static_google_protobuf_Method_descriptor;
    }
    
    public Method getDefaultInstanceForType() {
        return Method.getDefaultInstance();
    }
    
    public Method build() {
        final Method buildPartial = this.buildPartial();
        if (!buildPartial.isInitialized()) {
            throw AbstractMessage$Builder.newUninitializedMessageException(buildPartial);
        }
        return buildPartial;
    }
    
    public Method buildPartial() {
        final Method method = new Method(this, null);
        final int bitField0_ = this.bitField0_;
        final int n = 0;
        method.name_ = this.name_;
        method.requestTypeUrl_ = this.requestTypeUrl_;
        method.requestStreaming_ = this.requestStreaming_;
        method.responseTypeUrl_ = this.responseTypeUrl_;
        method.responseStreaming_ = this.responseStreaming_;
        if (this.optionsBuilder_ == null) {
            if ((this.bitField0_ & 0x20) == 0x20) {
                this.options_ = Collections.unmodifiableList((List<?>)this.options_);
                this.bitField0_ &= 0xFFFFFFDF;
            }
            method.options_ = this.options_;
        }
        else {
            method.options_ = this.optionsBuilder_.build();
        }
        method.bitField0_ = n;
        this.onBuilt();
        return method;
    }
    
    public Method$Builder mergeFrom(final Message message) {
        if (message instanceof Method) {
            return this.mergeFrom((Method)message);
        }
        super.mergeFrom(message);
        return this;
    }
    
    public Method$Builder mergeFrom(final Method method) {
        if (method == Method.getDefaultInstance()) {
            return this;
        }
        if (!method.getName().isEmpty()) {
            this.name_ = method.name_;
            this.onChanged();
        }
        if (!method.getRequestTypeUrl().isEmpty()) {
            this.requestTypeUrl_ = method.requestTypeUrl_;
            this.onChanged();
        }
        if (method.getRequestStreaming()) {
            this.setRequestStreaming(method.getRequestStreaming());
        }
        if (!method.getResponseTypeUrl().isEmpty()) {
            this.responseTypeUrl_ = method.responseTypeUrl_;
            this.onChanged();
        }
        if (method.getResponseStreaming()) {
            this.setResponseStreaming(method.getResponseStreaming());
        }
        if (this.optionsBuilder_ == null) {
            if (!method.options_.isEmpty()) {
                if (this.options_.isEmpty()) {
                    this.options_ = method.options_;
                    this.bitField0_ &= 0xFFFFFFDF;
                }
                else {
                    this.ensureOptionsIsMutable();
                    this.options_.addAll(method.options_);
                }
                this.onChanged();
            }
        }
        else if (!method.options_.isEmpty()) {
            if (this.optionsBuilder_.isEmpty()) {
                this.optionsBuilder_.dispose();
                this.optionsBuilder_ = null;
                this.options_ = method.options_;
                this.bitField0_ &= 0xFFFFFFDF;
                this.optionsBuilder_ = (GeneratedMessage.alwaysUseFieldBuilders ? this.getOptionsFieldBuilder() : null);
            }
            else {
                this.optionsBuilder_.addAllMessages(method.options_);
            }
        }
        this.onChanged();
        return this;
    }
    
    public final boolean isInitialized() {
        return true;
    }
    
    public Method$Builder mergeFrom(final CodedInputStream codedInputStream, final ExtensionRegistryLite extensionRegistryLite) {
        Method method = null;
        try {
            method = (Method)Method.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
        }
        catch (InvalidProtocolBufferException ex) {
            method = (Method)ex.getUnfinishedMessage();
            throw ex;
        }
        finally {
            if (method != null) {
                this.mergeFrom(method);
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
    
    public Method$Builder setName(final String name_) {
        if (name_ == null) {
            throw new NullPointerException();
        }
        this.name_ = name_;
        this.onChanged();
        return this;
    }
    
    public Method$Builder clearName() {
        this.name_ = Method.getDefaultInstance().getName();
        this.onChanged();
        return this;
    }
    
    public Method$Builder setNameBytes(final ByteString name_) {
        if (name_ == null) {
            throw new NullPointerException();
        }
        this.name_ = name_;
        this.onChanged();
        return this;
    }
    
    public String getRequestTypeUrl() {
        final Object requestTypeUrl_ = this.requestTypeUrl_;
        if (!(requestTypeUrl_ instanceof String)) {
            final ByteString byteString = (ByteString)requestTypeUrl_;
            final String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.requestTypeUrl_ = stringUtf8;
            }
            return stringUtf8;
        }
        return (String)requestTypeUrl_;
    }
    
    public ByteString getRequestTypeUrlBytes() {
        final Object requestTypeUrl_ = this.requestTypeUrl_;
        if (requestTypeUrl_ instanceof String) {
            return (ByteString)(this.requestTypeUrl_ = ByteString.copyFromUtf8((String)requestTypeUrl_));
        }
        return (ByteString)requestTypeUrl_;
    }
    
    public Method$Builder setRequestTypeUrl(final String requestTypeUrl_) {
        if (requestTypeUrl_ == null) {
            throw new NullPointerException();
        }
        this.requestTypeUrl_ = requestTypeUrl_;
        this.onChanged();
        return this;
    }
    
    public Method$Builder clearRequestTypeUrl() {
        this.requestTypeUrl_ = Method.getDefaultInstance().getRequestTypeUrl();
        this.onChanged();
        return this;
    }
    
    public Method$Builder setRequestTypeUrlBytes(final ByteString requestTypeUrl_) {
        if (requestTypeUrl_ == null) {
            throw new NullPointerException();
        }
        this.requestTypeUrl_ = requestTypeUrl_;
        this.onChanged();
        return this;
    }
    
    public boolean getRequestStreaming() {
        return this.requestStreaming_;
    }
    
    public Method$Builder setRequestStreaming(final boolean requestStreaming_) {
        this.requestStreaming_ = requestStreaming_;
        this.onChanged();
        return this;
    }
    
    public Method$Builder clearRequestStreaming() {
        this.requestStreaming_ = false;
        this.onChanged();
        return this;
    }
    
    public String getResponseTypeUrl() {
        final Object responseTypeUrl_ = this.responseTypeUrl_;
        if (!(responseTypeUrl_ instanceof String)) {
            final ByteString byteString = (ByteString)responseTypeUrl_;
            final String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.responseTypeUrl_ = stringUtf8;
            }
            return stringUtf8;
        }
        return (String)responseTypeUrl_;
    }
    
    public ByteString getResponseTypeUrlBytes() {
        final Object responseTypeUrl_ = this.responseTypeUrl_;
        if (responseTypeUrl_ instanceof String) {
            return (ByteString)(this.responseTypeUrl_ = ByteString.copyFromUtf8((String)responseTypeUrl_));
        }
        return (ByteString)responseTypeUrl_;
    }
    
    public Method$Builder setResponseTypeUrl(final String responseTypeUrl_) {
        if (responseTypeUrl_ == null) {
            throw new NullPointerException();
        }
        this.responseTypeUrl_ = responseTypeUrl_;
        this.onChanged();
        return this;
    }
    
    public Method$Builder clearResponseTypeUrl() {
        this.responseTypeUrl_ = Method.getDefaultInstance().getResponseTypeUrl();
        this.onChanged();
        return this;
    }
    
    public Method$Builder setResponseTypeUrlBytes(final ByteString responseTypeUrl_) {
        if (responseTypeUrl_ == null) {
            throw new NullPointerException();
        }
        this.responseTypeUrl_ = responseTypeUrl_;
        this.onChanged();
        return this;
    }
    
    public boolean getResponseStreaming() {
        return this.responseStreaming_;
    }
    
    public Method$Builder setResponseStreaming(final boolean responseStreaming_) {
        this.responseStreaming_ = responseStreaming_;
        this.onChanged();
        return this;
    }
    
    public Method$Builder clearResponseStreaming() {
        this.responseStreaming_ = false;
        this.onChanged();
        return this;
    }
    
    private void ensureOptionsIsMutable() {
        if ((this.bitField0_ & 0x20) != 0x20) {
            this.options_ = new ArrayList(this.options_);
            this.bitField0_ |= 0x20;
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
    
    public Method$Builder setOptions(final int n, final Option option) {
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
    
    public Method$Builder setOptions(final int n, final Option$Builder option$Builder) {
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
    
    public Method$Builder addOptions(final Option option) {
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
    
    public Method$Builder addOptions(final int n, final Option option) {
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
    
    public Method$Builder addOptions(final Option$Builder option$Builder) {
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
    
    public Method$Builder addOptions(final int n, final Option$Builder option$Builder) {
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
    
    public Method$Builder addAllOptions(final Iterable iterable) {
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
    
    public Method$Builder clearOptions() {
        if (this.optionsBuilder_ == null) {
            this.options_ = Collections.emptyList();
            this.bitField0_ &= 0xFFFFFFDF;
            this.onChanged();
        }
        else {
            this.optionsBuilder_.clear();
        }
        return this;
    }
    
    public Method$Builder removeOptions(final int n) {
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
            this.optionsBuilder_ = new RepeatedFieldBuilder(this.options_, (this.bitField0_ & 0x20) == 0x20, this.getParentForChildren(), this.isClean());
            this.options_ = null;
        }
        return this.optionsBuilder_;
    }
    
    public final Method$Builder setUnknownFields(final UnknownFieldSet set) {
        return this;
    }
    
    public final Method$Builder mergeUnknownFields(final UnknownFieldSet set) {
        return this;
    }
}
