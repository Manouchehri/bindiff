package com.google.common.io;

import com.google.common.annotations.*;
import java.io.*;

@VisibleForTesting
interface Closer$Suppressor
{
    void suppress(final Closeable p0, final Throwable p1, final Throwable p2);
}
