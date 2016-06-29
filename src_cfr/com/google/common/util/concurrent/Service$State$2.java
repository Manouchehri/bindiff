/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.Service$1;
import com.google.common.util.concurrent.Service$State;

final class Service$State$2
extends Service$State {
    Service$State$2(String string2, int n3) {
        super(string, n2, null);
    }

    @Override
    boolean isTerminal() {
        return false;
    }
}

