package com.google.protobuf;

import java.nio.*;
import java.util.logging.*;
import java.io.*;
import java.math.*;
import java.util.regex.*;
import java.util.*;

public class TextFormat$Parser
{
    private final boolean allowUnknownFields;
    private final TextFormat$Parser$SingularOverwritePolicy singularOverwritePolicy;
    private static final int BUFFER_SIZE = 4096;
    
    private TextFormat$Parser(final boolean allowUnknownFields, final TextFormat$Parser$SingularOverwritePolicy singularOverwritePolicy) {
        this.allowUnknownFields = allowUnknownFields;
        this.singularOverwritePolicy = singularOverwritePolicy;
    }
    
    public static TextFormat$Parser$Builder newBuilder() {
        return new TextFormat$Parser$Builder();
    }
    
    public void merge(final Readable readable, final Message$Builder message$Builder) {
        this.merge(readable, ExtensionRegistry.getEmptyRegistry(), message$Builder);
    }
    
    public void merge(final CharSequence charSequence, final Message$Builder message$Builder) {
        this.merge(charSequence, ExtensionRegistry.getEmptyRegistry(), message$Builder);
    }
    
    public void merge(final Readable readable, final ExtensionRegistry extensionRegistry, final Message$Builder message$Builder) {
        this.merge(toStringBuilder(readable), extensionRegistry, message$Builder);
    }
    
    private static StringBuilder toStringBuilder(final Readable readable) {
        final StringBuilder sb = new StringBuilder();
        final CharBuffer allocate = CharBuffer.allocate(4096);
        while (true) {
            final int read = readable.read(allocate);
            if (read == -1) {
                break;
            }
            allocate.flip();
            sb.append(allocate, 0, read);
        }
        return sb;
    }
    
    public void merge(final CharSequence charSequence, final ExtensionRegistry extensionRegistry, final Message$Builder message$Builder) {
        final TextFormat$Tokenizer textFormat$Tokenizer = new TextFormat$Tokenizer(charSequence, null);
        final MessageReflection$BuilderAdapter messageReflection$BuilderAdapter = new MessageReflection$BuilderAdapter(message$Builder);
        while (!textFormat$Tokenizer.atEnd()) {
            this.mergeField(textFormat$Tokenizer, extensionRegistry, messageReflection$BuilderAdapter);
        }
    }
    
    private void mergeField(final TextFormat$Tokenizer textFormat$Tokenizer, final ExtensionRegistry extensionRegistry, final MessageReflection$MergeTarget messageReflection$MergeTarget) {
        Descriptors$FieldDescriptor descriptors$FieldDescriptor = null;
        final Descriptors$Descriptor descriptorForType = messageReflection$MergeTarget.getDescriptorForType();
        ExtensionRegistry$ExtensionInfo extensionByName = null;
        if (textFormat$Tokenizer.tryConsume("[")) {
            final StringBuilder sb = new StringBuilder(textFormat$Tokenizer.consumeIdentifier());
            while (textFormat$Tokenizer.tryConsume(".")) {
                sb.append('.');
                sb.append(textFormat$Tokenizer.consumeIdentifier());
            }
            extensionByName = messageReflection$MergeTarget.findExtensionByName(extensionRegistry, sb.toString());
            if (extensionByName == null) {
                if (!this.allowUnknownFields) {
                    final String value = String.valueOf(String.valueOf(sb));
                    throw textFormat$Tokenizer.parseExceptionPreviousToken(new StringBuilder(48 + value.length()).append("Extension \"").append(value).append("\" not found in the ExtensionRegistry.").toString());
                }
                final Logger access$1100 = TextFormat.logger;
                final String value2 = String.valueOf(String.valueOf(sb));
                access$1100.warning(new StringBuilder(48 + value2.length()).append("Extension \"").append(value2).append("\" not found in the ExtensionRegistry.").toString());
            }
            else {
                if (extensionByName.descriptor.getContainingType() != descriptorForType) {
                    final String value3 = String.valueOf(String.valueOf(sb));
                    final String value4 = String.valueOf(String.valueOf(descriptorForType.getFullName()));
                    throw textFormat$Tokenizer.parseExceptionPreviousToken(new StringBuilder(45 + value3.length() + value4.length()).append("Extension \"").append(value3).append("\" does not extend message type \"").append(value4).append("\".").toString());
                }
                descriptors$FieldDescriptor = extensionByName.descriptor;
            }
            textFormat$Tokenizer.consume("]");
        }
        else {
            final String consumeIdentifier = textFormat$Tokenizer.consumeIdentifier();
            descriptors$FieldDescriptor = descriptorForType.findFieldByName(consumeIdentifier);
            if (descriptors$FieldDescriptor == null) {
                descriptors$FieldDescriptor = descriptorForType.findFieldByName(consumeIdentifier.toLowerCase(Locale.US));
                if (descriptors$FieldDescriptor != null && descriptors$FieldDescriptor.getType() != Descriptors$FieldDescriptor$Type.GROUP) {
                    descriptors$FieldDescriptor = null;
                }
            }
            if (descriptors$FieldDescriptor != null && descriptors$FieldDescriptor.getType() == Descriptors$FieldDescriptor$Type.GROUP && !descriptors$FieldDescriptor.getMessageType().getName().equals(consumeIdentifier)) {
                descriptors$FieldDescriptor = null;
            }
            if (descriptors$FieldDescriptor == null) {
                if (!this.allowUnknownFields) {
                    final String value5 = String.valueOf(String.valueOf(descriptorForType.getFullName()));
                    final String value6 = String.valueOf(String.valueOf(consumeIdentifier));
                    throw textFormat$Tokenizer.parseExceptionPreviousToken(new StringBuilder(38 + value5.length() + value6.length()).append("Message type \"").append(value5).append("\" has no field named \"").append(value6).append("\".").toString());
                }
                final Logger access$1101 = TextFormat.logger;
                final String value7 = String.valueOf(String.valueOf(descriptorForType.getFullName()));
                final String value8 = String.valueOf(String.valueOf(consumeIdentifier));
                access$1101.warning(new StringBuilder(38 + value7.length() + value8.length()).append("Message type \"").append(value7).append("\" has no field named \"").append(value8).append("\".").toString());
            }
        }
        if (descriptors$FieldDescriptor == null) {
            if (textFormat$Tokenizer.tryConsume(":") && !textFormat$Tokenizer.lookingAt("{") && !textFormat$Tokenizer.lookingAt("<")) {
                this.skipFieldValue(textFormat$Tokenizer);
            }
            else {
                this.skipFieldMessage(textFormat$Tokenizer);
            }
            return;
        }
        if (descriptors$FieldDescriptor.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
            textFormat$Tokenizer.tryConsume(":");
        }
        else {
            textFormat$Tokenizer.consume(":");
        }
        if (descriptors$FieldDescriptor.isRepeated() && textFormat$Tokenizer.tryConsume("[")) {
            while (true) {
                this.consumeFieldValue(textFormat$Tokenizer, extensionRegistry, messageReflection$MergeTarget, descriptors$FieldDescriptor, extensionByName);
                if (textFormat$Tokenizer.tryConsume("]")) {
                    break;
                }
                textFormat$Tokenizer.consume(",");
            }
        }
        else {
            this.consumeFieldValue(textFormat$Tokenizer, extensionRegistry, messageReflection$MergeTarget, descriptors$FieldDescriptor, extensionByName);
        }
        if (!textFormat$Tokenizer.tryConsume(";")) {
            textFormat$Tokenizer.tryConsume(",");
        }
    }
    
    private void consumeFieldValue(final TextFormat$Tokenizer textFormat$Tokenizer, final ExtensionRegistry extensionRegistry, final MessageReflection$MergeTarget messageReflection$MergeTarget, final Descriptors$FieldDescriptor descriptors$FieldDescriptor, final ExtensionRegistry$ExtensionInfo extensionRegistry$ExtensionInfo) {
        Object o = null;
        if (descriptors$FieldDescriptor.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
            String s;
            if (textFormat$Tokenizer.tryConsume("<")) {
                s = ">";
            }
            else {
                textFormat$Tokenizer.consume("{");
                s = "}";
            }
            final MessageReflection$MergeTarget mergeTargetForField = messageReflection$MergeTarget.newMergeTargetForField(descriptors$FieldDescriptor, (extensionRegistry$ExtensionInfo == null) ? null : extensionRegistry$ExtensionInfo.defaultInstance);
            while (!textFormat$Tokenizer.tryConsume(s)) {
                if (textFormat$Tokenizer.atEnd()) {
                    final String value = String.valueOf(String.valueOf(s));
                    throw textFormat$Tokenizer.parseException(new StringBuilder(12 + value.length()).append("Expected \"").append(value).append("\".").toString());
                }
                this.mergeField(textFormat$Tokenizer, extensionRegistry, mergeTargetForField);
            }
            o = mergeTargetForField.finish();
        }
        else {
            switch (TextFormat$3.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[descriptors$FieldDescriptor.getType().ordinal()]) {
                case 1:
                case 2:
                case 3: {
                    o = textFormat$Tokenizer.consumeInt32();
                    break;
                }
                case 4:
                case 5:
                case 6: {
                    o = textFormat$Tokenizer.consumeInt64();
                    break;
                }
                case 10:
                case 11: {
                    o = textFormat$Tokenizer.consumeUInt32();
                    break;
                }
                case 12:
                case 13: {
                    o = textFormat$Tokenizer.consumeUInt64();
                    break;
                }
                case 8: {
                    o = textFormat$Tokenizer.consumeFloat();
                    break;
                }
                case 9: {
                    o = textFormat$Tokenizer.consumeDouble();
                    break;
                }
                case 7: {
                    o = textFormat$Tokenizer.consumeBoolean();
                    break;
                }
                case 14: {
                    o = textFormat$Tokenizer.consumeString();
                    break;
                }
                case 15: {
                    o = textFormat$Tokenizer.consumeByteString();
                    break;
                }
                case 16: {
                    final Descriptors$EnumDescriptor enumType = descriptors$FieldDescriptor.getEnumType();
                    if (textFormat$Tokenizer.lookingAtInteger()) {
                        final int consumeInt32 = textFormat$Tokenizer.consumeInt32();
                        o = enumType.findValueByNumber(consumeInt32);
                        if (o == null) {
                            final String value2 = String.valueOf(String.valueOf(enumType.getFullName()));
                            throw textFormat$Tokenizer.parseExceptionPreviousToken(new StringBuilder(50 + value2.length()).append("Enum type \"").append(value2).append("\" has no value with number ").append(consumeInt32).append(".").toString());
                        }
                        break;
                    }
                    else {
                        final String consumeIdentifier = textFormat$Tokenizer.consumeIdentifier();
                        o = enumType.findValueByName(consumeIdentifier);
                        if (o == null) {
                            final String value3 = String.valueOf(String.valueOf(enumType.getFullName()));
                            final String value4 = String.valueOf(String.valueOf(consumeIdentifier));
                            throw textFormat$Tokenizer.parseExceptionPreviousToken(new StringBuilder(35 + value3.length() + value4.length()).append("Enum type \"").append(value3).append("\" has no value named \"").append(value4).append("\".").toString());
                        }
                        break;
                    }
                    break;
                }
                case 17:
                case 18: {
                    throw new RuntimeException("Can't get here.");
                }
            }
        }
        if (descriptors$FieldDescriptor.isRepeated()) {
            messageReflection$MergeTarget.addRepeatedField(descriptors$FieldDescriptor, o);
        }
        else {
            if (this.singularOverwritePolicy == TextFormat$Parser$SingularOverwritePolicy.FORBID_SINGULAR_OVERWRITES && messageReflection$MergeTarget.hasField(descriptors$FieldDescriptor)) {
                final String value5 = String.valueOf(String.valueOf(descriptors$FieldDescriptor.getFullName()));
                throw textFormat$Tokenizer.parseExceptionPreviousToken(new StringBuilder(44 + value5.length()).append("Non-repeated field \"").append(value5).append("\" cannot be overwritten.").toString());
            }
            if (this.singularOverwritePolicy == TextFormat$Parser$SingularOverwritePolicy.FORBID_SINGULAR_OVERWRITES && descriptors$FieldDescriptor.getContainingOneof() != null && messageReflection$MergeTarget.hasOneof(descriptors$FieldDescriptor.getContainingOneof())) {
                final Descriptors$OneofDescriptor containingOneof = descriptors$FieldDescriptor.getContainingOneof();
                final String value6 = String.valueOf(String.valueOf(descriptors$FieldDescriptor.getFullName()));
                final String value7 = String.valueOf(String.valueOf(messageReflection$MergeTarget.getOneofFieldDescriptor(containingOneof).getFullName()));
                final String value8 = String.valueOf(String.valueOf(containingOneof.getName()));
                throw textFormat$Tokenizer.parseExceptionPreviousToken(new StringBuilder(70 + value6.length() + value7.length() + value8.length()).append("Field \"").append(value6).append("\" is specified along with field \"").append(value7).append("\", another member of oneof \"").append(value8).append("\".").toString());
            }
            messageReflection$MergeTarget.setField(descriptors$FieldDescriptor, o);
        }
    }
    
    private void skipField(final TextFormat$Tokenizer textFormat$Tokenizer) {
        if (textFormat$Tokenizer.tryConsume("[")) {
            do {
                textFormat$Tokenizer.consumeIdentifier();
            } while (textFormat$Tokenizer.tryConsume("."));
            textFormat$Tokenizer.consume("]");
        }
        else {
            textFormat$Tokenizer.consumeIdentifier();
        }
        if (textFormat$Tokenizer.tryConsume(":") && !textFormat$Tokenizer.lookingAt("<") && !textFormat$Tokenizer.lookingAt("{")) {
            this.skipFieldValue(textFormat$Tokenizer);
        }
        else {
            this.skipFieldMessage(textFormat$Tokenizer);
        }
        if (!textFormat$Tokenizer.tryConsume(";")) {
            textFormat$Tokenizer.tryConsume(",");
        }
    }
    
    private void skipFieldMessage(final TextFormat$Tokenizer textFormat$Tokenizer) {
        String s;
        if (textFormat$Tokenizer.tryConsume("<")) {
            s = ">";
        }
        else {
            textFormat$Tokenizer.consume("{");
            s = "}";
        }
        while (!textFormat$Tokenizer.lookingAt(">") && !textFormat$Tokenizer.lookingAt("}")) {
            this.skipField(textFormat$Tokenizer);
        }
        textFormat$Tokenizer.consume(s);
    }
    
    private void skipFieldValue(final TextFormat$Tokenizer textFormat$Tokenizer) {
        if (textFormat$Tokenizer.tryConsumeString()) {
            while (textFormat$Tokenizer.tryConsumeString()) {}
            return;
        }
        if (!textFormat$Tokenizer.tryConsumeIdentifier() && !textFormat$Tokenizer.tryConsumeInt64() && !textFormat$Tokenizer.tryConsumeUInt64() && !textFormat$Tokenizer.tryConsumeDouble() && !textFormat$Tokenizer.tryConsumeFloat()) {
            final String s = "Invalid field value: ";
            final String value = String.valueOf(textFormat$Tokenizer.currentToken);
            throw textFormat$Tokenizer.parseException((value.length() != 0) ? s.concat(value) : new String(s));
        }
    }
}
