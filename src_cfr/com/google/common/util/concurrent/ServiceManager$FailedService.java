/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.GoogleInternal;
import com.google.common.util.concurrent.Service;

@GoogleInternal
final class ServiceManager$FailedService
extends Throwable {
    ServiceManager$FailedService(Service service) {
        super(service.toString(), service.failureCause(), false, false);
    }
}

