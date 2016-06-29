package com.google.common.util.concurrent;

import com.google.common.annotations.*;

@GoogleInternal
final class ServiceManager$FailedService extends Throwable
{
    ServiceManager$FailedService(final Service service) {
        super(service.toString(), service.failureCause(), false, false);
    }
}
