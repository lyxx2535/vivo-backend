package com.example.vivo_backend.utils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ExceptionUtil {

    private static final String NAME = "com.example.vivo_backend";

    private static final String LINE_SEP = "\r\n";

    private static final String ERR_MSG = "出现了异常情况如下：" + LINE_SEP + LINE_SEP +
            "出错原因：" + LINE_SEP + "%s" + LINE_SEP + LINE_SEP +
            "出错位置：" + LINE_SEP + "%s" + LINE_SEP + LINE_SEP +
            "详细出错位置：" + LINE_SEP + "%s" + LINE_SEP + LINE_SEP;

    public static String getExceptionAllInformation(Exception ex) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream pout = new PrintStream(out);
        ex.printStackTrace(pout);
        String ret = out.toString();
        pout.close();
        try {
            out.close();
        } catch (Exception e) {
            return e.getMessage();
        }
        return ret;
    }

    public static String getExceptionPartInformation(Exception ex) {
        StringBuilder res = new StringBuilder();
        String error = getExceptionAllInformation(ex);
        String[] errPart = error.split(System.lineSeparator());
        for (String err : errPart) {
            if (err.contains(NAME))
                res.append(err).append(LINE_SEP);
        }
        return res.toString();
    }

    public static String getExceptionDetailInformation(Exception ex) {
        StringBuilder res = new StringBuilder();
        String error = getExceptionAllInformation(ex);
        String[] errPart = error.split(System.lineSeparator());
        for (String err : errPart) {
            if (err.contains(NAME))
                res.append(err);
        }

        return String.format(ERR_MSG, ex.getMessage(), res.toString(), error);
    }

}
