/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

public class ServiceException
extends Exception {
    private static final long serialVersionUID = -1219262335729891920L;

    public ServiceException(String string) {
        super(string);
    }

    public ServiceException(Throwable throwable) {
        super(throwable);
    }

    public ServiceException(String string, Throwable throwable) {
        super(string, throwable);
    }
}

