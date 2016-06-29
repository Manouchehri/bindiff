/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.GoogleException;
import com.google.common.base.Throwables;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@Deprecated
@CheckReturnValue
@GoogleInternal
public class GoogleRuntimeException
extends RuntimeException {
    private static final long serialVersionUID = 1;
    private String internalMessage;
    private String externalMessage = "A system error has occurred";

    public GoogleRuntimeException() {
    }

    public GoogleRuntimeException(@Nullable String string) {
        super(string);
        this.setInternalMessage(string);
    }

    public GoogleRuntimeException(@Nullable String string, @Nullable Throwable throwable) {
        super(string, throwable);
        this.setInternalMessage(Throwables.getStackTraceAsString(throwable));
        this.setExternalMessage(string);
    }

    public GoogleRuntimeException(@Nullable GoogleException googleException) {
        super(googleException);
        this.setInternalMessage(googleException.getInternalMessage());
        this.setExternalMessage(googleException.getExternalMessage());
    }

    @Nullable
    public final String getInternalMessage() {
        return this.internalMessage;
    }

    public final void setInternalMessage(@Nullable String string) {
        this.internalMessage = string;
    }

    @Nullable
    public final String getExternalMessage() {
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

