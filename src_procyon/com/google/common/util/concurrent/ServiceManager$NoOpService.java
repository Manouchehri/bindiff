package com.google.common.util.concurrent;

final class ServiceManager$NoOpService extends AbstractService
{
    @Override
    protected void doStart() {
        this.notifyStarted();
    }
    
    @Override
    protected void doStop() {
        this.notifyStopped();
    }
}
