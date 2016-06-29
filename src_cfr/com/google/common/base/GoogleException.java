/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Throwables;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@Deprecated
@CheckReturnValue
@GoogleInternal
public class GoogleException
extends Exception {
    private static final long serialVersionUID = 1;
    private String internalMessage;
    private String externalMessage = "A system error has occurred";

    public GoogleException() {
    }

    public GoogleException(@Nullable Throwable throwable) {
        super(throwable);
        this.setInternalMessage(Throwables.getStackTraceAsString(throwable));
    }

    public GoogleException(@Nullable Throwable throwable, @Nullable String string) {
        super(string, throwable);
        this.setInternalMessage(Throwables.getStackTraceAsString(throwable));
        this.setExternalMessage(string);
    }

    public GoogleException(@Nullable String string) {
        super(string);
        this.setInternalMessage(string);
    }

    public GoogleException(@Nullable String string, @Nullable String string2) {
        super(string);
        this.setInternalMessage(string);
        this.setExternalMessage(string2);
    }

    @Nullable
    public String getInternalMessage() {
        return this.internalMessage;
    }

    public final void setInternalMessage(@Nullable String string) {
        this.internalMessage = string;
    }

    @Nullable
    public String getExternalMessage() {
        return this.externalMessage;
    }

    public final void setExternalMessage(@Nullable String string) {
        this.externalMessage = string;
    }

    @Nullable
    @Override
    public String getMessage() {
        return this.getInternalMessage();
    }
}

