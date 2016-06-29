package com.google.common.util.concurrent;

class AbstractService$10
{
    static {
        $SwitchMap$com$google$common$util$concurrent$Service$State = new int[Service$State.values().length];
        try {
            AbstractService$10.$SwitchMap$com$google$common$util$concurrent$Service$State[Service$State.NEW.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            AbstractService$10.$SwitchMap$com$google$common$util$concurrent$Service$State[Service$State.STARTING.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            AbstractService$10.$SwitchMap$com$google$common$util$concurrent$Service$State[Service$State.RUNNING.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            AbstractService$10.$SwitchMap$com$google$common$util$concurrent$Service$State[Service$State.STOPPING.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            AbstractService$10.$SwitchMap$com$google$common$util$concurrent$Service$State[Service$State.TERMINATED.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            AbstractService$10.$SwitchMap$com$google$common$util$concurrent$Service$State[Service$State.FAILED.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
    }
}
