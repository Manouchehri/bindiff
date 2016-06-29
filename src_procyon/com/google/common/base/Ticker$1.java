package com.google.common.base;

final class Ticker$1 extends Ticker
{
    @Override
    public long read() {
        return Platform.systemNanoTime();
    }
}
