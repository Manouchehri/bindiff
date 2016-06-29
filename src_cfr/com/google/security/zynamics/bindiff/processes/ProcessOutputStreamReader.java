/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.processes;

import com.google.security.zynamics.bindiff.log.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class ProcessOutputStreamReader
implements Runnable {
    private final String name;
    private final InputStream inStream;
    private Thread thread;

    public ProcessOutputStreamReader(String string, InputStream inputStream) {
        this.name = string;
        this.inStream = inputStream;
    }

    public void interruptThread() {
        if (this.thread == null) return;
        this.thread.interrupt();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(this.inStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while (!this.thread.isInterrupted()) {
                String string = bufferedReader.readLine();
                if (string == null) {
                    return;
                }
                String string2 = this.name;
                String string3 = String.valueOf(string.replace("%", "%%"));
                Logger.logInfo(new StringBuilder(3 + String.valueOf(string2).length() + String.valueOf(string3).length()).append("[").append(string2).append("] ").append(string3).toString(), new Object[0]);
            }
            return;
        }
        catch (Exception var1_3) {
            Logger.logException(var1_3, "Could't read process output stream.");
            return;
        }
        finally {
            if (this.inStream != null) {
                try {
                    this.inStream.close();
                }
                catch (IOException var1_4) {
                    Logger.logException(var1_4, "Could't close process output stream.");
                }
            }
        }
    }

    public void start() {
        this.thread = new Thread(this);
        this.thread.start();
    }
}

