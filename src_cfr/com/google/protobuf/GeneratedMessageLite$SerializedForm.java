/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import java.io.Serializable;
import java.lang.reflect.Field;

final class GeneratedMessageLite$SerializedForm
implements Serializable {
    private static final long serialVersionUID = 0;
    private final String messageClassName;
    private final byte[] asBytes;

    GeneratedMessageLite$SerializedForm(MessageLite messageLite) {
        this.messageClassName = messageLite.getClass().getName();
        this.asBytes = messageLite.toByteArray();
    }

    protected Object readResolve() {
        try {
            Class class_ = Class.forName(this.messageClassName);
            Parser parser = (Parser)class_.getField("PARSER").get(null);
            return parser.parsePartialFrom(this.asBytes);
        }
        catch (ClassNotFoundException var1_2) {
            throw new RuntimeException("Unable to find proto buffer class", var1_2);
        }
        catch (NoSuchFieldException var1_3) {
            throw new RuntimeException("Unable to find PARSER", var1_3);
        }
        catch (SecurityException var1_4) {
            throw new RuntimeException("Unable to call PARSER", var1_4);
        }
        catch (IllegalAccessException var1_5) {
            throw new RuntimeException("Unable to call parseFrom method", var1_5);
        }
        catch (InvalidProtocolBufferException var1_6) {
            throw new RuntimeException("Unable to understand proto buffer", var1_6);
        }
    }
}

