/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractMessage$Builder;
import com.google.protobuf.AbstractMessageLite$Builder;
import com.google.protobuf.Api;
import com.google.protobuf.Api$1;
import com.google.protobuf.ApiOrBuilder;
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
import com.google.protobuf.Method$Builder;
import com.google.protobuf.MethodOrBuilder;
import com.google.protobuf.Option;
import com.google.protobuf.Option$Builder;
import com.google.protobuf.OptionOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilder;
import com.google.protobuf.SingleFieldBuilder;
import com.google.protobuf.SourceContext;
import com.google.protobuf.SourceContext$Builder;
import com.google.protobuf.SourceContextOrBuilder;
import com.google.protobuf.UnknownFieldSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class Api$Builder
extends GeneratedMessage$Builder
implements ApiOrBuilder {
    private int bitField0_;
    private Object name_ = "";
    private List methods_ = Collections.emptyList();
    private RepeatedFieldBuilder methodsBuilder_;
    private List options_ = Collections.emptyList();
    private RepeatedFieldBuilder optionsBuilder_;
    private Object version_ = "";
    private SourceContext sourceContext_ = null;
    private SingleFieldBuilder sourceContextBuilder_;

    public static final Descriptors$Descriptor getDescriptor() {
        return ApiProto.internal_static_google_protobuf_Api_descriptor;
    }

    @Override
    protected GeneratedMessage$FieldAccessorTable internalGetFieldAccessorTable() {
        return ApiProto.internal_static_google_protobuf_Api_fieldAccessorTable.ensureFieldAccessorsInitialized(Api.class, Api$Builder.class);
    }

    private Api$Builder() {
        this.maybeForceBuilderInitialization();
    }

    private Api$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent) {
        super(generatedMessage$BuilderParent);
        this.maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
        if (!GeneratedMessage.alwaysUseFieldBuilders) return;
        this.getMethodsFieldBuilder();
        this.getOptionsFieldBuilder();
    }

    @Override
    public Api$Builder clear() {
        super.clear();
        this.name_ = "";
        if (this.methodsBuilder_ == null) {
            this.methods_ = Collections.emptyList();
            this.bitField0_ &= -3;
        } else {
            this.methodsBuilder_.clear();
        }
        if (this.optionsBuilder_ == null) {
            this.options_ = Collections.emptyList();
            this.bitField0_ &= -5;
        } else {
            this.optionsBuilder_.clear();
        }
        this.version_ = "";
        if (this.sourceContextBuilder_ == null) {
            this.sourceContext_ = null;
            return this;
        }
        this.sourceContext_ = null;
        this.sourceContextBuilder_ = null;
        return this;
    }

    @Override
    public Descriptors$Descriptor getDescriptorForType() {
        return ApiProto.internal_static_google_protobuf_Api_descriptor;
    }

    @Override
    public Api getDefaultInstanceForType() {
        return Api.getDefaultInstance();
    }

    @Override
    public Api build() {
        Api api = this.buildPartial();
        if (api.isInitialized()) return api;
        throw Api$Builder.newUninitializedMessageException(api);
    }

    @Override
    public Api buildPartial() {
        Api api = new Api(this, null);
        int n2 = this.bitField0_;
        int n3 = 0;
        Api.access$302(api, this.name_);
        if (this.methodsBuilder_ == null) {
            if ((this.bitField0_ & 2) == 2) {
                this.methods_ = Collections.unmodifiableList(this.methods_);
                this.bitField0_ &= -3;
            }
            Api.access$402(api, this.methods_);
        } else {
            Api.access$402(api, this.methodsBuilder_.build());
        }
        if (this.optionsBuilder_ == null) {
            if ((this.bitField0_ & 4) == 4) {
                this.options_ = Collections.unmodifiableList(this.options_);
                this.bitField0_ &= -5;
            }
            Api.access$502(api, this.options_);
        } else {
            Api.access$502(api, this.optionsBuilder_.build());
        }
        Api.access$602(api, this.version_);
        if (this.sourceContextBuilder_ == null) {
            Api.access$702(api, this.sourceContext_);
        } else {
            Api.access$702(api, (SourceContext)this.sourceContextBuilder_.build());
        }
        Api.access$802(api, n3);
        this.onBuilt();
        return api;
    }

    @Override
    public Api$Builder mergeFrom(Message message) {
        if (message instanceof Api) {
            return this.mergeFrom((Api)message);
        }
        super.mergeFrom(message);
        return this;
    }

    public Api$Builder mergeFrom(Api api) {
        if (api == Api.getDefaultInstance()) {
            return this;
        }
        if (!api.getName().isEmpty()) {
            this.name_ = Api.access$300(api);
            this.onChanged();
        }
        if (this.methodsBuilder_ == null) {
            if (!Api.access$400(api).isEmpty()) {
                if (this.methods_.isEmpty()) {
                    this.methods_ = Api.access$400(api);
                    this.bitField0_ &= -3;
                } else {
                    this.ensureMethodsIsMutable();
                    this.methods_.addAll(Api.access$400(api));
                }
                this.onChanged();
            }
        } else if (!Api.access$400(api).isEmpty()) {
            if (this.methodsBuilder_.isEmpty()) {
                this.methodsBuilder_.dispose();
                this.methodsBuilder_ = null;
                this.methods_ = Api.access$400(api);
                this.bitField0_ &= -3;
                this.methodsBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? this.getMethodsFieldBuilder() : null;
            } else {
                this.methodsBuilder_.addAllMessages(Api.access$400(api));
            }
        }
        if (this.optionsBuilder_ == null) {
            if (!Api.access$500(api).isEmpty()) {
                if (this.options_.isEmpty()) {
                    this.options_ = Api.access$500(api);
                    this.bitField0_ &= -5;
                } else {
                    this.ensureOptionsIsMutable();
                    this.options_.addAll(Api.access$500(api));
                }
                this.onChanged();
            }
        } else if (!Api.access$500(api).isEmpty()) {
            if (this.optionsBuilder_.isEmpty()) {
                this.optionsBuilder_.dispose();
                this.optionsBuilder_ = null;
                this.options_ = Api.access$500(api);
                this.bitField0_ &= -5;
                this.optionsBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? this.getOptionsFieldBuilder() : null;
            } else {
                this.optionsBuilder_.addAllMessages(Api.access$500(api));
            }
        }
        if (!api.getVersion().isEmpty()) {
            this.version_ = Api.access$600(api);
            this.onChanged();
        }
        if (api.hasSourceContext()) {
            this.mergeSourceContext(api.getSourceContext());
        }
        this.onChanged();
        return this;
    }

    @Override
    public final boolean isInitialized() {
        return true;
    }

    @Override
    public Api$Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Api api = null;
        try {
            try {
                api = (Api)Api.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
            }
            catch (InvalidProtocolBufferException var4_6) {
                api = (Api)var4_6.getUnfinishedMessage();
                throw var4_6;
            }
            Object var6_4 = null;
            if (api == null) return this;
            this.mergeFrom(api);
            return this;
        }
        catch (Throwable var5_7) {
            Object var6_5 = null;
            if (api == null) throw var5_7;
            this.mergeFrom(api);
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

    public Api$Builder setName(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.name_ = string;
        this.onChanged();
        return this;
    }

    public Api$Builder clearName() {
        this.name_ = Api.getDefaultInstance().getName();
        this.onChanged();
        return this;
    }

    public Api$Builder setNameBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.name_ = byteString;
        this.onChanged();
        return this;
    }

    private void ensureMethodsIsMutable() {
        if ((this.bitField0_ & 2) == 2) return;
        this.methods_ = new ArrayList(this.methods_);
        this.bitField0_ |= 2;
    }

    @Override
    public List getMethodsList() {
        if (this.methodsBuilder_ != null) return this.methodsBuilder_.getMessageList();
        return Collections.unmodifiableList(this.methods_);
    }

    @Override
    public int getMethodsCount() {
        if (this.methodsBuilder_ != null) return this.methodsBuilder_.getCount();
        return this.methods_.size();
    }

    @Override
    public Method getMethods(int n2) {
        if (this.methodsBuilder_ != null) return (Method)this.methodsBuilder_.getMessage(n2);
        return (Method)this.methods_.get(n2);
    }

    public Api$Builder setMethods(int n2, Method method) {
        if (this.methodsBuilder_ != null) {
            this.methodsBuilder_.setMessage(n2, method);
            return this;
        }
        if (method == null) {
            throw new NullPointerException();
        }
        this.ensureMethodsIsMutable();
        this.methods_.set(n2, method);
        this.onChanged();
        return this;
    }

    public Api$Builder setMethods(int n2, Method$Builder method$Builder) {
        if (this.methodsBuilder_ == null) {
            this.ensureMethodsIsMutable();
            this.methods_.set(n2, method$Builder.build());
            this.onChanged();
            return this;
        }
        this.methodsBuilder_.setMessage(n2, method$Builder.build());
        return this;
    }

    public Api$Builder addMethods(Method method) {
        if (this.methodsBuilder_ != null) {
            this.methodsBuilder_.addMessage(method);
            return this;
        }
        if (method == null) {
            throw new NullPointerException();
        }
        this.ensureMethodsIsMutable();
        this.methods_.add(method);
        this.onChanged();
        return this;
    }

    public Api$Builder addMethods(int n2, Method method) {
        if (this.methodsBuilder_ != null) {
            this.methodsBuilder_.addMessage(n2, method);
            return this;
        }
        if (method == null) {
            throw new NullPointerException();
        }
        this.ensureMethodsIsMutable();
        this.methods_.add(n2, method);
        this.onChanged();
        return this;
    }

    public Api$Builder addMethods(Method$Builder method$Builder) {
        if (this.methodsBuilder_ == null) {
            this.ensureMethodsIsMutable();
            this.methods_.add(method$Builder.build());
            this.onChanged();
            return this;
        }
        this.methodsBuilder_.addMessage(method$Builder.build());
        return this;
    }

    public Api$Builder addMethods(int n2, Method$Builder method$Builder) {
        if (this.methodsBuilder_ == null) {
            this.ensureMethodsIsMutable();
            this.methods_.add(n2, method$Builder.build());
            this.onChanged();
            return this;
        }
        this.methodsBuilder_.addMessage(n2, method$Builder.build());
        return this;
    }

    public Api$Builder addAllMethods(Iterable iterable) {
        if (this.methodsBuilder_ == null) {
            this.ensureMethodsIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.methods_);
            this.onChanged();
            return this;
        }
        this.methodsBuilder_.addAllMessages(iterable);
        return this;
    }

    public Api$Builder clearMethods() {
        if (this.methodsBuilder_ == null) {
            this.methods_ = Collections.emptyList();
            this.bitField0_ &= -3;
            this.onChanged();
            return this;
        }
        this.methodsBuilder_.clear();
        return this;
    }

    public Api$Builder removeMethods(int n2) {
        if (this.methodsBuilder_ == null) {
            this.ensureMethodsIsMutable();
            this.methods_.remove(n2);
            this.onChanged();
            return this;
        }
        this.methodsBuilder_.remove(n2);
        return this;
    }

    public Method$Builder getMethodsBuilder(int n2) {
        return (Method$Builder)this.getMethodsFieldBuilder().getBuilder(n2);
    }

    @Override
    public MethodOrBuilder getMethodsOrBuilder(int n2) {
        if (this.methodsBuilder_ != null) return (MethodOrBuilder)this.methodsBuilder_.getMessageOrBuilder(n2);
        return (MethodOrBuilder)this.methods_.get(n2);
    }

    @Override
    public List getMethodsOrBuilderList() {
        if (this.methodsBuilder_ == null) return Collections.unmodifiableList(this.methods_);
        return this.methodsBuilder_.getMessageOrBuilderList();
    }

    public Method$Builder addMethodsBuilder() {
        return (Method$Builder)this.getMethodsFieldBuilder().addBuilder(Method.getDefaultInstance());
    }

    public Method$Builder addMethodsBuilder(int n2) {
        return (Method$Builder)this.getMethodsFieldBuilder().addBuilder(n2, Method.getDefaultInstance());
    }

    public List getMethodsBuilderList() {
        return this.getMethodsFieldBuilder().getBuilderList();
    }

    private RepeatedFieldBuilder getMethodsFieldBuilder() {
        if (this.methodsBuilder_ != null) return this.methodsBuilder_;
        this.methodsBuilder_ = new RepeatedFieldBuilder(this.methods_, (this.bitField0_ & 2) == 2, this.getParentForChildren(), this.isClean());
        this.methods_ = null;
        return this.methodsBuilder_;
    }

    private void ensureOptionsIsMutable() {
        if ((this.bitField0_ & 4) == 4) return;
        this.options_ = new ArrayList(this.options_);
        this.bitField0_ |= 4;
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

    public Api$Builder setOptions(int n2, Option option) {
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

    public Api$Builder setOptions(int n2, Option$Builder option$Builder) {
        if (this.optionsBuilder_ == null) {
            this.ensureOptionsIsMutable();
            this.options_.set(n2, option$Builder.build());
            this.onChanged();
            return this;
        }
        this.optionsBuilder_.setMessage(n2, option$Builder.build());
        return this;
    }

    public Api$Builder addOptions(Option option) {
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

    public Api$Builder addOptions(int n2, Option option) {
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

    public Api$Builder addOptions(Option$Builder option$Builder) {
        if (this.optionsBuilder_ == null) {
            this.ensureOptionsIsMutable();
            this.options_.add(option$Builder.build());
            this.onChanged();
            return this;
        }
        this.optionsBuilder_.addMessage(option$Builder.build());
        return this;
    }

    public Api$Builder addOptions(int n2, Option$Builder option$Builder) {
        if (this.optionsBuilder_ == null) {
            this.ensureOptionsIsMutable();
            this.options_.add(n2, option$Builder.build());
            this.onChanged();
            return this;
        }
        this.optionsBuilder_.addMessage(n2, option$Builder.build());
        return this;
    }

    public Api$Builder addAllOptions(Iterable iterable) {
        if (this.optionsBuilder_ == null) {
            this.ensureOptionsIsMutable();
            AbstractMessageLite$Builder.addAll(iterable, this.options_);
            this.onChanged();
            return this;
        }
        this.optionsBuilder_.addAllMessages(iterable);
        return this;
    }

    public Api$Builder clearOptions() {
        if (this.optionsBuilder_ == null) {
            this.options_ = Collections.emptyList();
            this.bitField0_ &= -5;
            this.onChanged();
            return this;
        }
        this.optionsBuilder_.clear();
        return this;
    }

    public Api$Builder removeOptions(int n2) {
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
        this.optionsBuilder_ = new RepeatedFieldBuilder(this.options_, (this.bitField0_ & 4) == 4, this.getParentForChildren(), this.isClean());
        this.options_ = null;
        return this.optionsBuilder_;
    }

    @Override
    public String getVersion() {
        Object object = this.version_;
        if (object instanceof String) return (String)object;
        ByteString byteString = (ByteString)object;
        String string = byteString.toStringUtf8();
        if (!byteString.isValidUtf8()) return string;
        this.version_ = string;
        return string;
    }

    @Override
    public ByteString getVersionBytes() {
        ByteString byteString;
        Object object = this.version_;
        if (!(object instanceof String)) return (ByteString)object;
        this.version_ = byteString = ByteString.copyFromUtf8((String)object);
        return byteString;
    }

    public Api$Builder setVersion(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        this.version_ = string;
        this.onChanged();
        return this;
    }

    public Api$Builder clearVersion() {
        this.version_ = Api.getDefaultInstance().getVersion();
        this.onChanged();
        return this;
    }

    public Api$Builder setVersionBytes(ByteString byteString) {
        if (byteString == null) {
            throw new NullPointerException();
        }
        this.version_ = byteString;
        this.onChanged();
        return this;
    }

    @Override
    public boolean hasSourceContext() {
        if (this.sourceContextBuilder_ != null) return true;
        if (this.sourceContext_ != null) return true;
        return false;
    }

    @Override
    public SourceContext getSourceContext() {
        SourceContext sourceContext;
        if (this.sourceContextBuilder_ != null) return (SourceContext)this.sourceContextBuilder_.getMessage();
        if (this.sourceContext_ == null) {
            sourceContext = SourceContext.getDefaultInstance();
            return sourceContext;
        }
        sourceContext = this.sourceContext_;
        return sourceContext;
    }

    public Api$Builder setSourceContext(SourceContext sourceContext) {
        if (this.sourceContextBuilder_ != null) {
            this.sourceContextBuilder_.setMessage(sourceContext);
            return this;
        }
        if (sourceContext == null) {
            throw new NullPointerException();
        }
        this.sourceContext_ = sourceContext;
        this.onChanged();
        return this;
    }

    public Api$Builder setSourceContext(SourceContext$Builder sourceContext$Builder) {
        if (this.sourceContextBuilder_ == null) {
            this.sourceContext_ = sourceContext$Builder.build();
            this.onChanged();
            return this;
        }
        this.sourceContextBuilder_.setMessage(sourceContext$Builder.build());
        return this;
    }

    public Api$Builder mergeSourceContext(SourceContext sourceContext) {
        if (this.sourceContextBuilder_ != null) {
            this.sourceContextBuilder_.mergeFrom(sourceContext);
            return this;
        }
        this.sourceContext_ = this.sourceContext_ != null ? SourceContext.newBuilder(this.sourceContext_).mergeFrom(sourceContext).buildPartial() : sourceContext;
        this.onChanged();
        return this;
    }

    public Api$Builder clearSourceContext() {
        if (this.sourceContextBuilder_ == null) {
            this.sourceContext_ = null;
            this.onChanged();
            return this;
        }
        this.sourceContext_ = null;
        this.sourceContextBuilder_ = null;
        return this;
    }

    public SourceContext$Builder getSourceContextBuilder() {
        this.onChanged();
        return (SourceContext$Builder)this.getSourceContextFieldBuilder().getBuilder();
    }

    @Override
    public SourceContextOrBuilder getSourceContextOrBuilder() {
        SourceContext sourceContext;
        if (this.sourceContextBuilder_ != null) {
            return (SourceContextOrBuilder)this.sourceContextBuilder_.getMessageOrBuilder();
        }
        if (this.sourceContext_ == null) {
            sourceContext = SourceContext.getDefaultInstance();
            return sourceContext;
        }
        sourceContext = this.sourceContext_;
        return sourceContext;
    }

    private SingleFieldBuilder getSourceContextFieldBuilder() {
        if (this.sourceContextBuilder_ != null) return this.sourceContextBuilder_;
        this.sourceContextBuilder_ = new SingleFieldBuilder(this.getSourceContext(), this.getParentForChildren(), this.isClean());
        this.sourceContext_ = null;
        return this.sourceContextBuilder_;
    }

    @Override
    public final Api$Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    @Override
    public final Api$Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
        return this;
    }

    /* synthetic */ Api$Builder(Api$1 api$1) {
        this();
    }

    /* synthetic */ Api$Builder(GeneratedMessage$BuilderParent generatedMessage$BuilderParent, Api$1 api$1) {
        this(generatedMessage$BuilderParent);
    }
}

