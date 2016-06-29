/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;

public class WebsiteReader {
    public static String read(String string) {
        URL uRL = new URL(string);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(uRL.openStream()));
        StringBuilder stringBuilder = new StringBuilder();
        do {
            String string2;
            if ((string2 = bufferedReader.readLine()) == null) {
                bufferedReader.close();
                return stringBuilder.toString();
            }
            stringBuilder.append(string2);
        } while (true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static String sendPost(String string, String string2) {
        URLConnection uRLConnection;
        URL uRL = new URL(string);
        uRLConnection = uRL.openConnection();
        uRLConnection.setDoOutput(true);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(uRLConnection.getOutputStream());
        try {
            outputStreamWriter.write(string2);
            outputStreamWriter.flush();
        }
        finally {
            outputStreamWriter.close();
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(uRLConnection.getInputStream()));
        StringBuilder stringBuilder = new StringBuilder();
        try {
            String string3;
            while ((string3 = bufferedReader.readLine()) != null) {
                stringBuilder.append(string3);
            }
            return stringBuilder.toString();
        }
        finally {
            bufferedReader.close();
        }
    }
}

