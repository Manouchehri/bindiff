package com.google.common.util.concurrent;

import javax.annotation.concurrent.*;
import java.util.concurrent.*;
import java.util.logging.*;
import java.util.concurrent.locks.*;
import com.google.common.base.*;
import java.util.*;
import com.google.common.annotations.*;
import com.google.common.collect.*;

enum CycleDetectingLockFactory$Policies$2
{
    CycleDetectingLockFactory$Policies$2(final String s, final int n) {
    }
    
    @Override
    public void handlePotentialDeadlock(final CycleDetectingLockFactory$PotentialDeadlockException ex) {
        CycleDetectingLockFactory.logger.log(Level.SEVERE, "Detected potential deadlock", ex);
    }
}
