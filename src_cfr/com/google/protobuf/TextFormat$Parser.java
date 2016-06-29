/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors$Descriptor;
import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;
import com.google.protobuf.Descriptors$FieldDescriptor$Type;
import com.google.protobuf.Descriptors$OneofDescriptor;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistry$ExtensionInfo;
import com.google.protobuf.Message;
import com.google.protobuf.Message$Builder;
import com.google.protobuf.MessageReflection$BuilderAdapter;
import com.google.protobuf.MessageReflection$MergeTarget;
import com.google.protobuf.TextFormat;
import com.google.protobuf.TextFormat$1;
import com.google.protobuf.TextFormat$3;
import com.google.protobuf.TextFormat$ParseException;
import com.google.protobuf.TextFormat$Parser$Builder;
import com.google.protobuf.TextFormat$Parser$SingularOverwritePolicy;
import com.google.protobuf.TextFormat$Tokenizer;
import java.nio.Buffer;
import java.nio.CharBuffer;
import java.util.Locale;

public class TextFormat$Parser {
    private final boolean allowUnknownFields;
    private final TextFormat$Parser$SingularOverwritePolicy singularOverwritePolicy;
    private static final int BUFFER_SIZE = 4096;

    private TextFormat$Parser(boolean bl2, TextFormat$Parser$SingularOverwritePolicy textFormat$Parser$SingularOverwritePolicy) {
        this.allowUnknownFields = bl2;
        this.singularOverwritePolicy = textFormat$Parser$SingularOverwritePolicy;
    }

    public static TextFormat$Parser$Builder newBuilder() {
        return new TextFormat$Parser$Builder();
    }

    public void merge(Readable readable, Message$Builder message$Builder) {
        this.merge(readable, ExtensionRegistry.getEmptyRegistry(), message$Builder);
    }

    public void merge(CharSequence charSequence, Message$Builder message$Builder) {
        this.merge(charSequence, ExtensionRegistry.getEmptyRegistry(), message$Builder);
    }

    public void merge(Readable readable, ExtensionRegistry extensionRegistry, Message$Builder message$Builder) {
        this.merge(TextFormat$Parser.toStringBuilder(readable), extensionRegistry, message$Builder);
    }

    private static StringBuilder toStringBuilder(Readable readable) {
        StringBuilder stringBuilder = new StringBuilder();
        CharBuffer charBuffer = CharBuffer.allocate(4096);
        int n2;
        while ((n2 = readable.read(charBuffer)) != -1) {
            charBuffer.flip();
            stringBuilder.append(charBuffer, 0, n2);
        }
        return stringBuilder;
    }

    public void merge(CharSequence charSequence, ExtensionRegistry extensionRegistry, Message$Builder message$Builder) {
        TextFormat$Tokenizer textFormat$Tokenizer = new TextFormat$Tokenizer(charSequence, null);
        MessageReflection$BuilderAdapter messageReflection$BuilderAdapter = new MessageReflection$BuilderAdapter(message$Builder);
        while (!textFormat$Tokenizer.atEnd()) {
            this.mergeField(textFormat$Tokenizer, extensionRegistry, messageReflection$BuilderAdapter);
        }
    }

    private void mergeField(TextFormat$Tokenizer textFormat$Tokenizer, ExtensionRegistry extensionRegistry, MessageReflection$MergeTarget messageReflection$MergeTarget) {
        String string;
        String string2;
        Descriptors$FieldDescriptor descriptors$FieldDescriptor = null;
        Descriptors$Descriptor descriptors$Descriptor = messageReflection$MergeTarget.getDescriptorForType();
        ExtensionRegistry$ExtensionInfo extensionRegistry$ExtensionInfo = null;
        if (textFormat$Tokenizer.tryConsume("[")) {
            string2 = new StringBuilder(textFormat$Tokenizer.consumeIdentifier());
            while (textFormat$Tokenizer.tryConsume(".")) {
                string2.append('.');
                string2.append(textFormat$Tokenizer.consumeIdentifier());
            }
            extensionRegistry$ExtensionInfo = messageReflection$MergeTarget.findExtensionByName(extensionRegistry, string2.toString());
            if (extensionRegistry$ExtensionInfo == null) {
                if (!this.allowUnknownFields) {
                    String string3 = String.valueOf(String.valueOf(string2));
                    throw textFormat$Tokenizer.parseExceptionPreviousToken(new StringBuilder(48 + string3.length()).append("Extension \"").append(string3).append("\" not found in the ExtensionRegistry.").toString());
                }
                string = String.valueOf(String.valueOf(string2));
                TextFormat.access$1100().warning(new StringBuilder(48 + string.length()).append("Extension \"").append(string).append("\" not found in the ExtensionRegistry.").toString());
            } else {
                if (extensionRegistry$ExtensionInfo.descriptor.getContainingType() != descriptors$Descriptor) {
                    String string4 = String.valueOf(String.valueOf(string2));
                    String string5 = String.valueOf(String.valueOf(descriptors$Descriptor.getFullName()));
                    throw textFormat$Tokenizer.parseExceptionPreviousToken(new StringBuilder(45 + string4.length() + string5.length()).append("Extension \"").append(string4).append("\" does not extend message type \"").append(string5).append("\".").toString());
                }
                descriptors$FieldDescriptor = extensionRegistry$ExtensionInfo.descriptor;
            }
            textFormat$Tokenizer.consume("]");
        } else {
            string2 = textFormat$Tokenizer.consumeIdentifier();
            descriptors$FieldDescriptor = descriptors$Descriptor.findFieldByName(string2);
            if (descriptors$FieldDescriptor == null && (descriptors$FieldDescriptor = descriptors$Descriptor.findFieldByName(string = string2.toLowerCase(Locale.US))) != null && descriptors$FieldDescriptor.getType() != Descriptors$FieldDescriptor$Type.GROUP) {
                descriptors$FieldDescriptor = null;
            }
            if (descriptors$FieldDescriptor != null && descriptors$FieldDescriptor.getType() == Descriptors$FieldDescriptor$Type.GROUP && !descriptors$FieldDescriptor.getMessageType().getName().equals(string2)) {
                descriptors$FieldDescriptor = null;
            }
            if (descriptors$FieldDescriptor == null) {
                if (!this.allowUnknownFields) {
                    string = String.valueOf(String.valueOf(descriptors$Descriptor.getFullName()));
                    String string6 = String.valueOf(String.valueOf(string2));
                    throw textFormat$Tokenizer.parseExceptionPreviousToken(new StringBuilder(38 + string.length() + string6.length()).append("Message type \"").append(string).append("\" has no field named \"").append(string6).append("\".").toString());
                }
                string = String.valueOf(String.valueOf(descriptors$Descriptor.getFullName()));
                String string7 = String.valueOf(String.valueOf(string2));
                TextFormat.access$1100().warning(new StringBuilder(38 + string.length() + string7.length()).append("Message type \"").append(string).append("\" has no field named \"").append(string7).append("\".").toString());
            }
        }
        if (descriptors$FieldDescriptor == null) {
            if (textFormat$Tokenizer.tryConsume(":") && !textFormat$Tokenizer.lookingAt("{") && !textFormat$Tokenizer.lookingAt("<")) {
                this.skipFieldValue(textFormat$Tokenizer);
                return;
            }
            this.skipFieldMessage(textFormat$Tokenizer);
            return;
        }
        if (descriptors$FieldDescriptor.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
            textFormat$Tokenizer.tryConsume(":");
        } else {
            textFormat$Tokenizer.consume(":");
        }
        if (!descriptors$FieldDescriptor.isRepeated() || !textFormat$Tokenizer.tryConsume("[")) {
            this.consumeFieldValue(textFormat$Tokenizer, extensionRegistry, messageReflection$MergeTarget, descriptors$FieldDescriptor, extensionRegistry$ExtensionInfo);
        } else {
            do {
                this.consumeFieldValue(textFormat$Tokenizer, extensionRegistry, messageReflection$MergeTarget, descriptors$FieldDescriptor, extensionRegistry$ExtensionInfo);
                if (textFormat$Tokenizer.tryConsume("]")) break;
                textFormat$Tokenizer.consume(",");
            } while (true);
        }
        if (textFormat$Tokenizer.tryConsume(";")) return;
        textFormat$Tokenizer.tryConsume(",");
    }

    /*
     * Unable to fully structure code
     */
    private void consumeFieldValue(TextFormat$Tokenizer var1_1, ExtensionRegistry var2_2, MessageReflection$MergeTarget var3_3, Descriptors$FieldDescriptor var4_4, ExtensionRegistry$ExtensionInfo var5_5) {
        var6_6 = null;
        if (var4_4.getJavaType() == Descriptors$FieldDescriptor$JavaType.MESSAGE) ** GOTO lbl51
        switch (TextFormat$3.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[var4_4.getType().ordinal()]) {
            case 1: 
            case 2: 
            case 3: {
                var6_6 = var1_1.consumeInt32();
                ** break;
            }
            case 4: 
            case 5: 
            case 6: {
                var6_6 = var1_1.consumeInt64();
                ** break;
            }
            case 10: 
            case 11: {
                var6_6 = var1_1.consumeUInt32();
                ** break;
            }
            case 12: 
            case 13: {
                var6_6 = var1_1.consumeUInt64();
                ** break;
            }
            case 8: {
                var6_6 = Float.valueOf(var1_1.consumeFloat());
                ** break;
            }
            case 9: {
                var6_6 = var1_1.consumeDouble();
                ** break;
            }
            case 7: {
                var6_6 = var1_1.consumeBoolean();
                ** break;
            }
            case 14: {
                var6_6 = var1_1.consumeString();
                ** break;
            }
            case 15: {
                var6_6 = var1_1.consumeByteString();
                ** break;
            }
            case 16: {
                var7_7 = var4_4.getEnumType();
                if (var1_1.lookingAtInteger()) {
                    var8_9 = var1_1.consumeInt32();
                    var6_6 = var7_7.findValueByNumber(var8_9);
                    if (var6_6 == null) {
                        var9_12 = String.valueOf(String.valueOf(var7_7.getFullName()));
                        var10_15 = var8_9;
                        throw var1_1.parseExceptionPreviousToken(new StringBuilder(50 + var9_12.length()).append("Enum type \"").append(var9_12).append("\" has no value with number ").append(var10_15).append(".").toString());
                    }
                } else {
                    var8_10 = var1_1.consumeIdentifier();
                    var6_6 = var7_7.findValueByName(var8_10);
                    if (var6_6 == null) {
                        var9_13 = String.valueOf(String.valueOf(var7_7.getFullName()));
                        var10_16 = String.valueOf(String.valueOf(var8_10));
                        throw var1_1.parseExceptionPreviousToken(new StringBuilder(35 + var9_13.length() + var10_16.length()).append("Enum type \"").append(var9_13).append("\" has no value named \"").append(var10_16).append("\".").toString());
                    }
                }
                ** GOTO lbl64
            }
            case 17: 
            case 18: {
                throw new RuntimeException("Can't get here.");
            }
        }
        ** GOTO lbl64
lbl51: // 1 sources:
        if (var1_1.tryConsume("<")) {
            var7_7 = ">";
        } else {
            var1_1.consume("{");
            var7_7 = "}";
        }
        var8_8 = var3_3.newMergeTargetForField(var4_4, var5_5 == null ? null : var5_5.defaultInstance);
        while (!var1_1.tryConsume((String)var7_7)) {
            if (var1_1.atEnd()) {
                var9_11 = String.valueOf(String.valueOf(var7_7));
                throw var1_1.parseException(new StringBuilder(12 + var9_11.length()).append("Expected \"").append(var9_11).append("\".").toString());
            }
            this.mergeField(var1_1, var2_2, (MessageReflection$MergeTarget)var8_8);
        }
        var6_6 = var8_8.finish();
lbl64: // 13 sources:
        if (var4_4.isRepeated()) {
            var3_3.addRepeatedField(var4_4, var6_6);
            return;
        }
        if (this.singularOverwritePolicy == TextFormat$Parser$SingularOverwritePolicy.FORBID_SINGULAR_OVERWRITES && var3_3.hasField(var4_4)) {
            var7_7 = String.valueOf(String.valueOf(var4_4.getFullName()));
            throw var1_1.parseExceptionPreviousToken(new StringBuilder(44 + var7_7.length()).append("Non-repeated field \"").append((String)var7_7).append("\" cannot be overwritten.").toString());
        }
        if (this.singularOverwritePolicy == TextFormat$Parser$SingularOverwritePolicy.FORBID_SINGULAR_OVERWRITES && var4_4.getContainingOneof() != null && var3_3.hasOneof(var4_4.getContainingOneof())) {
            var7_7 = var4_4.getContainingOneof();
            var8_8 = String.valueOf(String.valueOf(var4_4.getFullName()));
            var9_14 = String.valueOf(String.valueOf(var3_3.getOneofFieldDescriptor((Descriptors$OneofDescriptor)var7_7).getFullName()));
            var10_17 = String.valueOf(String.valueOf(var7_7.getName()));
            throw var1_1.parseExceptionPreviousToken(new StringBuilder(70 + var8_8.length() + var9_14.length() + var10_17.length()).append("Field \"").append((String)var8_8).append("\" is specified along with field \"").append(var9_14).append("\", another member of oneof \"").append(var10_17).append("\".").toString());
        }
        var3_3.setField(var4_4, var6_6);
    }

    private void skipField(TextFormat$Tokenizer textFormat$Tokenizer) {
        if (textFormat$Tokenizer.tryConsume("[")) {
            do {
                textFormat$Tokenizer.consumeIdentifier();
            } while (textFormat$Tokenizer.tryConsume("."));
            textFormat$Tokenizer.consume("]");
        } else {
            textFormat$Tokenizer.consumeIdentifier();
        }
        if (textFormat$Tokenizer.tryConsume(":") && !textFormat$Tokenizer.lookingAt("<") && !textFormat$Tokenizer.lookingAt("{")) {
            this.skipFieldValue(textFormat$Tokenizer);
        } else {
            this.skipFieldMessage(textFormat$Tokenizer);
        }
        if (textFormat$Tokenizer.tryConsume(";")) return;
        textFormat$Tokenizer.tryConsume(",");
    }

    private void skipFieldMessage(TextFormat$Tokenizer textFormat$Tokenizer) {
        String string;
        if (textFormat$Tokenizer.tryConsume("<")) {
            string = ">";
        } else {
            textFormat$Tokenizer.consume("{");
            string = "}";
        }
        while (!textFormat$Tokenizer.lookingAt(">") && !textFormat$Tokenizer.lookingAt("}")) {
            this.skipField(textFormat$Tokenizer);
        }
        textFormat$Tokenizer.consume(string);
    }

    private void skipFieldValue(TextFormat$Tokenizer textFormat$Tokenizer) {
        String string;
        if (textFormat$Tokenizer.tryConsumeString()) {
            while (textFormat$Tokenizer.tryConsumeString()) {
            }
            return;
        }
        if (textFormat$Tokenizer.tryConsumeIdentifier()) return;
        if (textFormat$Tokenizer.tryConsumeInt64()) return;
        if (textFormat$Tokenizer.tryConsumeUInt64()) return;
        if (textFormat$Tokenizer.tryConsumeDouble()) return;
        if (textFormat$Tokenizer.tryConsumeFloat()) return;
        String string2 = String.valueOf(TextFormat$Tokenizer.access$1200(textFormat$Tokenizer));
        if (string2.length() != 0) {
            string = "Invalid field value: ".concat(string2);
            throw textFormat$Tokenizer.parseException(string);
        }
        string = new String("Invalid field value: ");
        throw textFormat$Tokenizer.parseException(string);
    }

    /* synthetic */ TextFormat$Parser(boolean bl2, TextFormat$Parser$SingularOverwritePolicy textFormat$Parser$SingularOverwritePolicy, TextFormat$1 textFormat$1) {
        this(bl2, textFormat$Parser$SingularOverwritePolicy);
    }
}

