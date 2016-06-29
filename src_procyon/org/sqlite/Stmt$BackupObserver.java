package org.sqlite;

class Stmt$BackupObserver implements DB$ProgressObserver
{
    public void progress(final int n, final int n2) {
        System.out.println(String.format("remaining:%d, page count:%d", n, n2));
    }
}
