/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletOutputStream
 *  javax.servlet.http.HttpServletResponse
 *  javax.servlet.http.HttpSession
 */
package org.jfree.chart.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.servlet.ChartDeleter;

public class ServletUtilities {
    private static String tempFilePrefix = "jfreechart-";
    private static String tempOneTimeFilePrefix = "jfreechart-onetime-";

    public static String getTempFilePrefix() {
        return tempFilePrefix;
    }

    public static void setTempFilePrefix(String string) {
        if (string == null) {
            throw new IllegalArgumentException("Null 'prefix' argument.");
        }
        tempFilePrefix = string;
    }

    public static String getTempOneTimeFilePrefix() {
        return tempOneTimeFilePrefix;
    }

    public static void setTempOneTimeFilePrefix(String string) {
        if (string == null) {
            throw new IllegalArgumentException("Null 'prefix' argument.");
        }
        tempOneTimeFilePrefix = string;
    }

    public static String saveChartAsPNG(JFreeChart jFreeChart, int n2, int n3, HttpSession httpSession) {
        return ServletUtilities.saveChartAsPNG(jFreeChart, n2, n3, null, httpSession);
    }

    public static String saveChartAsPNG(JFreeChart jFreeChart, int n2, int n3, ChartRenderingInfo chartRenderingInfo, HttpSession httpSession) {
        if (jFreeChart == null) {
            throw new IllegalArgumentException("Null 'chart' argument.");
        }
        ServletUtilities.createTempDir();
        String string = tempFilePrefix;
        if (httpSession == null) {
            string = tempOneTimeFilePrefix;
        }
        File file = File.createTempFile(string, ".png", new File(System.getProperty("java.io.tmpdir")));
        ChartUtilities.saveChartAsPNG(file, jFreeChart, n2, n3, chartRenderingInfo);
        if (httpSession == null) return file.getName();
        ServletUtilities.registerChartForDeletion(file, httpSession);
        return file.getName();
    }

    public static String saveChartAsJPEG(JFreeChart jFreeChart, int n2, int n3, HttpSession httpSession) {
        return ServletUtilities.saveChartAsJPEG(jFreeChart, n2, n3, null, httpSession);
    }

    public static String saveChartAsJPEG(JFreeChart jFreeChart, int n2, int n3, ChartRenderingInfo chartRenderingInfo, HttpSession httpSession) {
        if (jFreeChart == null) {
            throw new IllegalArgumentException("Null 'chart' argument.");
        }
        ServletUtilities.createTempDir();
        String string = tempFilePrefix;
        if (httpSession == null) {
            string = tempOneTimeFilePrefix;
        }
        File file = File.createTempFile(string, ".jpeg", new File(System.getProperty("java.io.tmpdir")));
        ChartUtilities.saveChartAsJPEG(file, jFreeChart, n2, n3, chartRenderingInfo);
        if (httpSession == null) return file.getName();
        ServletUtilities.registerChartForDeletion(file, httpSession);
        return file.getName();
    }

    protected static void createTempDir() {
        String string = System.getProperty("java.io.tmpdir");
        if (string == null) {
            throw new RuntimeException("Temporary directory system property (java.io.tmpdir) is null.");
        }
        File file = new File(string);
        if (file.exists()) return;
        file.mkdirs();
    }

    protected static void registerChartForDeletion(File file, HttpSession httpSession) {
        if (httpSession == null) {
            System.out.println("Session is null - chart will not be deleted");
            return;
        }
        ChartDeleter chartDeleter = (ChartDeleter)httpSession.getAttribute("JFreeChart_Deleter");
        if (chartDeleter == null) {
            chartDeleter = new ChartDeleter();
            httpSession.setAttribute("JFreeChart_Deleter", (Object)chartDeleter);
        }
        chartDeleter.addChart(file.getName());
    }

    public static void sendTempFile(String string, HttpServletResponse httpServletResponse) {
        File file = new File(System.getProperty("java.io.tmpdir"), string);
        ServletUtilities.sendTempFile(file, httpServletResponse);
    }

    public static void sendTempFile(File file, HttpServletResponse httpServletResponse) {
        String string = null;
        String string2 = file.getName();
        if (string2.length() > 5) {
            if (string2.substring(string2.length() - 5, string2.length()).equals(".jpeg")) {
                string = "image/jpeg";
            } else if (string2.substring(string2.length() - 4, string2.length()).equals(".png")) {
                string = "image/png";
            }
        }
        ServletUtilities.sendTempFile(file, httpServletResponse, string);
    }

    public static void sendTempFile(File file, HttpServletResponse httpServletResponse, String string) {
        if (!file.exists()) throw new FileNotFoundException(file.getAbsolutePath());
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        if (string != null) {
            httpServletResponse.setHeader("Content-Type", string);
        }
        httpServletResponse.setHeader("Content-Length", String.valueOf(file.length()));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        httpServletResponse.setHeader("Last-Modified", simpleDateFormat.format(new Date(file.lastModified())));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream((OutputStream)httpServletResponse.getOutputStream());
        byte[] arrby = new byte[1024];
        boolean bl2 = false;
        do {
            if (bl2) {
                bufferedOutputStream.flush();
                bufferedInputStream.close();
                bufferedOutputStream.close();
                return;
            }
            int n2 = bufferedInputStream.read(arrby);
            if (n2 == -1) {
                bl2 = true;
                continue;
            }
            bufferedOutputStream.write(arrby, 0, n2);
        } while (true);
    }

    public static String searchReplace(String string, String string2, String string3) {
        int n2 = string.indexOf(string2);
        if (n2 == -1) {
            return string;
        }
        String string4 = "";
        string4 = new StringBuffer().append(string4).append(string.substring(0, n2)).append(string3).toString();
        if (n2 + string2.length() >= string.length()) return string4;
        return new StringBuffer().append(string4).append(ServletUtilities.searchReplace(string.substring(n2 + string2.length()), string2, string3)).toString();
    }
}

