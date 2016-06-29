package com.google.security.zynamics.bindiff.processes;

import com.google.security.zynamics.bindiff.log.*;
import java.io.*;

public class ProcessOutputStreamReader implements Runnable
{
    private final String name;
    private final InputStream inStream;
    private Thread thread;
    
    public ProcessOutputStreamReader(final String name, final InputStream inStream) {
        this.name = name;
        this.inStream = inStream;
    }
    
    public void interruptThread() {
        if (this.thread != null) {
            this.thread.interrupt();
        }
    }
    
    @Override
    public void run() {
        try {
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.inStream));
            while (!this.thread.isInterrupted()) {
                final String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                final String name = this.name;
                final String value = String.valueOf(line.replace("%", "%%"));
                Logger.logInfo(new StringBuilder(3 + String.valueOf(name).length() + String.valueOf(value).length()).append("[").append(name).append("] ").append(value).toString(), new Object[0]);
            }
        }
        catch (Exception ex) {
            Logger.logException(ex, "Could't read process output stream.");
            if (this.inStream != null) {
                try {
                    this.inStream.close();
                }
                catch (IOException ex2) {
                    Logger.logException(ex2, "Could't close process output stream.");
                }
            }
        }
        finally {
            if (this.inStream != null) {
                try {
                    this.inStream.close();
                }
                catch (IOException ex3) {
                    Logger.logException(ex3, "Could't close process output stream.");
                }
            }
        }
    }
    
    public void start() {
        (this.thread = new Thread(this)).start();
    }
}
