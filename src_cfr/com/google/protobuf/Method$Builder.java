/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.ApiProto;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage$Builder;
import com.google.protobuf.GeneratedMessage$BuilderParent;
import com.google.protobuf.GeneratedMessage$FieldAccessorTable;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLite$Builder;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Method;
import com.google.protobuf.Method$1;
import com.google.protobuf.MethodOrBuilder;
import com.google.protobuf.Option;
import com.google.protobuf.Option$Builder;
import com.google.protobuf.OptionOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilder;
import com.google.protobuf.UnknownFieldSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class Method$Builder
extends GeneratedMessage$Builder
implements MethodOrBuilder {
    private int bitField0_;
    private Object name_ = "";
    private Object requestTypeUrl_ = "";
    private boolean requestStreaming_;
    private Object responseTypeUrl_ = "";
    private boolean responseStreaming_;
    private List options_ = Collections.emptyList();
    private RepeatedFieldBuilder optionsBuilder_;

    public static final Descriptors$Descriptor getDescriptor() {
        return ApiProto.internal_static_google_protobuf_Method_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return ApiProto.internal_static_google_protobuf_Method_fieldAccessorTable.ensureFieldAccessorsInitialized(Method.class, Method$Builder.class);
    }

    private Method$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private Method$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!GeneratedMessage.alwaysUseFieldBuilders) return;
        this.getOptionsFieldBuilder();
    }

    @Override
    public Method$Builder clear() {
        super.clear();
        this.name_ = "";
        this.requestTypeUrl_ = "";
        this.requestStreaming_ = false;
        this.responseTypeUrl_ = "";
        this.responseStreaming_ = false;
        if (this.optionsBuilder_ == null) {
            this.options_ = Collections.emptyList();
            this.bitField0_ &= -33;
            return this;
        }
        this.optionsBuilder_.clear();
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return ApiProto.internal_static_google_protobuf_Method_descriptor;
    }

    @Override
    public Method getDefaultInstanceForType() {
        return Method.getDefaultInstance();
    }

    @Override
    public Method build() {
        Method method = this.buildPartial();
        if (method.isInitialized()) return method;
        throw Method$Builder.newUninitializedMessageException(method);
    }

    @Override
    public Method buildPartial() {
        Method method = new Method(this, null);
        int n2 = this.bitField0_;
        int n3 = 0;
        Method.access$302(method, this.name_);
        Method.access$402(method, this.requestTypeUrl_);
        Method.access$502(method, this.requestStreaming_);
        Method.access$602(method, this.responseTypeUrl_);
        Method.access$702(method, this.responseStreaming_);
        if (this.optionsBuilder_ == null) {
            if ((this.bitField0_ & 32) == 32) {
                this.options_ = Collections.unmodifiableList(this.options_);
                this.bitField0_ &= -33;
            }
            Method.access$802(method, this.options_);
        } else {
            Method.access$802(method, this.optionsBuilder_.build());
        }
        Method.access$902(method, n3);
        this.onBuilt();
        return method;
    }

    @Override
    public Method$Builder mergeFrom(Message message) {
        if (message instanceof Method) {
            return this.mergeFrom((Method)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public Method$Builder mergeFrom(Method method) {
        if (method == Method.getDefaultInstance()) {
            return this;
        }
        if (!method.getName().isEmpty()) {
            this.name_ = Method.access$300(method);
            this.onChanged();
        }
        if (!method.getRequestTypeUrl().isEmpty()) {
            this.requestTypeUrl_ = Method.access$400(method);
            this.onChanged();
        }
        if (method.getRequestStreaming()) {
            this.setRequestStreaming(method.getRequestStreaming());
        }
        if (!method.getResponseTypeUrl().isEmpty()) {
            this.responseTypeUrl_ = Method.access$600(method);
            this.onChanged();
        }
        if (method.getResponseStreaming()) {
            this.setResponseStreaming(method.getResponseStreaming());
        }
        if (this.optionsBuilder_ == null) {
            if (!Method.access$800(method).isEmpty()) {
                if (this.options_.isEmpty()) {
                    this.options_ = Method.access$800(method);
                    this.bitField0_ &= -33;
                } else {
                    this.ensureOptionsIsMutable();
                    this.options_.addAll(Method.access$800(method));
                }
                this.onChanged();
            }
        } else if (!Method.access$800(method).isEmpty()) {
            if (this.optionsBuilder_.isEmpty()) {
                this.optionsBuilder_.dispose();
                this.optionsBuilder_ = null;
                this.options_ = Method.access$800(method);
                this.bitField0_ &= -33;
                this.optionsBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? this.getOptionsFieldBuilder() : null;
            } else {
                this.optionsBuilder_.addAllMessages(Method.access$800(method));
            }
        }
        this.onChanged();
        return this;
    }

    @Override
    public final boolean isInitialized() {
        return true;
    }

    @Override
    public Method$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Method method = null;
        try {
            try {
                method = (Method)Method.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            }
            catch (InvalidProtocolBufferException var4_6) {
                method = (Method)var4_6.getUnfinishedMessage();
                throw var4_6;
            }
            Object var6_4 = null;
            if (method == null) return this;
            this.mergeFrom(method);
            return this;
        }
        catch (Throwable var5_7) {
            Object var6_5 = null;
            if (method == null) throw var5_7;
            this.mergeFrom(method);
            throw var5_7;
        }
    }

    @Override
    public String getName() {
        Object object = this.name_;
        if (object instanceof String) return (String)object;
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.name_ = string;
        return string;
    }

    @Override
    public ByteString getNameBytes() {
        ByteString byteString;
        Object object = this.name_;
        if (!(object instanceof String)) return (ByteString)object;
        this.name_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    public Method$Builder setName(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.name_ = string;
        this.onChanged();
        return this;
    }

    public Method$Builder clearName() {
        this.name_ = Method.getDefaultInstance().getName();
        this.onChanged();
        return this;
    }

    public Method$Builder setNameBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.name_ = byteString;
        this.onChanged();
        return this;
    }

    @Override
    public String getRequestTypeUrl() {
        Object object = this.requestTypeUrl_;
        if (object instanceof String) return (String)object;
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.requestTypeUrl_ = string;
        return string;
    }

    @Override
    public ByteString getRequestTypeUrlBytes() {
        ByteString byteString;
        Object object = this.requestTypeUrl_;
        if (!(object instanceof String)) return (ByteString)object;
        this.requestTypeUrl_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    public Method$Builder setRequestTypeUrl(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.requestTypeUrl_ = string;
        this.onChanged();
        return this;
    }

    public Method$Builder clearRequestTypeUrl() {
        this.requestTypeUrl_ = Method.getDefaultInstance().getRequestTypeUrl();
        this.onChanged();
        return this;
    }

    public Method$Builder setRequestTypeUrlBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.requestTypeUrl_ = byteString;
        this.onChanged();
        return this;
    }

    @Override
    public boolean getRequestStreaming() {
        return this.requestStreaming_;
    }

    public Method$Builder setRequestStreaming(boolean bl2) {
        this.requestStreaming_ = bl2;
        this.onChanged();
        return this;
    }

    public Method$Builder clearRequestStreaming() {
        this.requestStreaming_ = false;
        this.onChanged();
        return this;
    }

    @Override
    public String getResponseTypeUrl() {
        Object object = this.responseTypeUrl_;
        if (object instanceof String) return (String)object;
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.responseTypeUrl_ = string;
        return string;
    }

    @Override
    public ByteString getResponseTypeUrlBytes() {
        ByteString byteString;
        Object object = this.responseTypeUrl_;
        if (!(object instanceof String)) return (ByteString)object;
        this.responseTypeUrl_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    public Method$Builder setResponseTypeUrl(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.responseTypeUrl_ = string;
        this.onChanged();
        return this;
    }

    public Method$Builder clearResponseTypeUrl() {
        this.responseTypeUrl_ = Method.getDefaultInstance().getResponseTypeUrl();
        this.onChanged();
        return this;
    }

    public Method$Builder setResponseTypeUrlBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.responseTypeUrl_ = byteString;
        this.onChanged();
        return this;
    }

    @Override
    public boolean getResponseStreaming() {
        return this.responseStreaming_;
    }

    public Method$Builder setResponseStreaming(boolean bl2) {
        this.responseStreaming_ = bl2;
        this.onChanged();
        return this;
    }

    public Method$Builder clearResponseStreaming() {
        this.responseStreaming_ = false;
        this.onChanged();
        return this;
    }

    private void ensureOptionsIsMutable() {
        if ((this.bitField0_ & 32) == 32) return;
        this.options_ = new ArrayList(this.options_);
        this.bitField0_ |= 32;
    }

    @Override
    public List getOptionsList() {
        if (this.optionsBuilder_ != null) return this.optionsBuilder_.getMessageList();
        return Collections.unmodifiableList(this.options_);
    }

    @Override
    public int getOptionsCount() {
        if (this.optionsBuilder_ != null) return this.optionsBuilder_.getCount();
        return this.options_.size();
    }

    @Override
    public Option getOptions(int n2) {
        if (this.optionsBuilder_ != null) return (Option)this.optionsBuilder_.getMessage(n2);
        return (Option)this.options_.get(n2);
    }

    public Method$Builder setOptions(int n2, Option option) {
        if (this.optionsBuilder_ != null) {
            this.optionsBuilder_.setMessage(n2, option);
            return this;
        }
        if (option == null) {
            throw new NullPointerException();
        }
        this.ensureOptionsIsMutable();
        this.options_.set(n2, option);
        this.onChanged();
        return this;
    }

    public Method$Builder setOptions(int n2, Option$Builder option$Builder) {
        if (this.optionsBuilder_ == null) {
            this.ensureOptionsIsMutable();
            this.options_.set(n2, option$Builder.build());
            this.onChanged();
            return this;
        }
        this.optionsBuilder_.setMessage(n2, option$Builder.build());
        return this;
    }

    public Method$Builder addOptions(Option option) {
        if (this.optionsBuilder_ != null) {
            this.optionsBuilder_.addMessage(option);
            return this;
        }
        if (option == null) {
            throw new NullPointerException();
        }
        this.ensureOptionsIsMutable();
        this.options_.add(option);
        this.onChanged();
        return this;
    }

    public Method$Builder addOptions(int n2, Option option) {
        if (this.optionsBuilder_ != null) {
            this.optionsBuilder_.addMessage(n2, option);
            return this;
        }
        if (option == null) {
            throw new NullPointerException();
        }
        this.ensureOptionsIsMutable();
        this.options_.add(n2, option);
        this.onChanged();
        return this;
    }

    public Method$Builder addOptions(Option$Builder option$Builder) {
        if (this.optionsBuilder_ == null) {
            this.ensureOptionsIsMutable();
            this.options_.add(option$Builder.build());
            this.onChanged();
            return this;
        }
        this.optionsBuilder_.addMessage(option$Builder.build());
        return this;
    }

    public Method$Builder addOptions(int n2, Option$Builder option$Builder) {
        if (this.optionsBuilder_ == null) {
            this.ensureOptionsIsMutable();
            this.options_.add(n2, option$Builder.build());
            this.onChanged();
            return this;
        }
        this.optionsBuilder_.addMessage(n2, option$Builder.build());
        return this;
    }

    public Method$Builder addAllOptions(Iterable iterable) {
        if (this.optionsBuilder_ == null) {
            this.ensureOptionsIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.options_);
            this.onChanged();
            return this;
        }
        this.optionsBuilder_.addAllMessages(iterable);
        return this;
    }

    public Method$Builder clearOptions() {
        if (this.optionsBuilder_ == null) {
            this.options_ = Collections.emptyList();
            this.bitField0_ &= -33;
            this.onChanged();
            return this;
        }
        this.optionsBuilder_.clear();
        return this;
    }

    public Method$Builder removeOptions(int n2) {
        if (this.optionsBuilder_ == null) {
            this.ensureOptionsIsMutable();
            this.options_.remove(n2);
            this.onChanged();
            return this;
        }
        this.optionsBuilder_.remove(n2);
        return this;
    }

    public Option$Builder getOptionsBuilder(int n2) {
        return (Option$Builder)this.getOptionsFieldBuilder().getBuilder(n2);
    }

    @Override
    public OptionOrBuilder getOptionsOrBuilder(int n2) {
        if (this.optionsBuilder_ != null) return (OptionOrBuilder)this.optionsBuilder_.getMessageOrBuilder(n2);
        return (OptionOrBuilder)this.options_.get(n2);
    }

    @Override
    public List getOptionsOrBuilderList() {
        if (this.optionsBuilder_ == null) return Collections.unmodifiableList(this.options_);
        return this.optionsBuilder_.getMessageOrBuilderList();
    }

    public Option$Builder addOptionsBuilder() {
        return (Option$Builder)this.getOptionsFieldBuilder().addBuilder(Option.getDefaultInstance());
    }

    public Option$Builder addOptionsBuilder(int n2) {
        return (Option$Builder)this.getOptionsFieldBuilder().addBuilder(n2, Option.getDefaultInstance());
    }

    public List getOptionsBuilderList() {
        return this.getOptionsFieldBuilder().getBuilderList();
    }

    private RepeatedFieldBuilder getOptionsFieldBuilder() {
        if (this.optionsBuilder_ != null) return this.optionsBuilder_;
        this.optionsBuilder_ = new RepeatedFieldBuilder(this.options_, (this.bitField0_ & 32) == 32, this.getParentForChildren(), this.isClean());
        this.options_ = null;
        return this.optionsBuilder_;
    }

    @Override
    public final Method$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    @Override
    public final Method$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    /* synthetic */ Method$Builder(Method$1 method$1) {
        this();
    }

    /* synthetic */ Method$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, Method$1 method$1) {
        this(generatedMessage$BuilderParent);
    }
}

