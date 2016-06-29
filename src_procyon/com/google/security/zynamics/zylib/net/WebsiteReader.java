package com.google.security.zynamics.zylib.net;

import java.io.*;
import java.net.*;

public class WebsiteReader
{
    public static String read(final String s) {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new URL(s).openStream()));
        final StringBuilder sb = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line);
        }
        bufferedReader.close();
        return sb.toString();
    }
    
    public static String sendPost(final String s, final String s2) {
        final URLConnection openConnection = new URL(s).openConnection();
        openConnection.setDoOutput(true);
        final OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openConnection.getOutputStream());
        try {
            outputStreamWriter.write(s2);
            outputStreamWriter.flush();
        }
        finally {
            outputStreamWriter.close();
        }
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openConnection.getInputStream()));
        final StringBuilder sb = new StringBuilder();
        try {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
        }
        finally {
            bufferedReader.close();
        }
        return sb.toString();
    }
}
