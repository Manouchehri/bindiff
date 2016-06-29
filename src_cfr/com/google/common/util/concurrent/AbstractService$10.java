/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.Service$State;

class AbstractService$10 {
    static final /* synthetic */ int[] $SwitchMap$com$google$common$util$concurrent$Service$State;

    static {
        $SwitchMap$com$google$common$util$concurrent$Service$State = new int[Service$State.values().length];
        try {
            AbstractService$10.$SwitchMap$com$google$common$util$concurrent$Service$State[Service$State.NEW.ordinal()] = 1;
        }
        catch (NoSuchFieldError var0) {
            // empty catch block
        }
        try {
            AbstractService$10.$SwitchMap$com$google$common$util$concurrent$Service$State[Service$State.STARTING.ordinal()] = 2;
        }
        catch (NoSuchFieldError var0_1) {
            // empty catch block
        }
        try {
            AbstractService$10.$SwitchMap$com$google$common$util$concurrent$Service$State[Service$State.RUNNING.ordinal()] = 3;
        }
        catch (NoSuchFieldError var0_2) {
            // empty catch block
        }
        try {
            AbstractService$10.$SwitchMap$com$google$common$util$concurrent$Service$State[Service$State.STOPPING.ordinal()] = 4;
        }
        catch (NoSuchFieldError var0_3) {
            // empty catch block
        }
        try {
            AbstractService$10.$SwitchMap$com$google$common$util$concurrent$Service$State[Service$State.TERMINATED.ordinal()] = 5;
        }
        catch (NoSuchFieldError var0_4) {
            // empty catch block
        }
        try {
            AbstractService$10.$SwitchMap$com$google$common$util$concurrent$Service$State[Service$State.FAILED.ordinal()] = 6;
            return;
        }
        catch (NoSuchFieldError var0_5) {
            // empty catch block
        }
    }
}

