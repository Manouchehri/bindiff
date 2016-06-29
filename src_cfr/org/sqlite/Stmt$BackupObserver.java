/*
 * Decompiled with CFR 0_115.
 */
package org.sqlite;

import java.io.PrintStream;
import org.sqlite.DB$ProgressObserver;

class Stmt$BackupObserver
implements DB$ProgressObserver {
    Stmt$BackupObserver() {
    }

    @Override
    public void progress(int n2, int n3) {
        System.out.println(String.format("remaining:%d, page count:%d", n2, n3));
    }
}

