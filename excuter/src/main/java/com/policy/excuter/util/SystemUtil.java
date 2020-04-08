package com.policy.excuter.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class SystemUtil {
    public static String excuteShell(String shell){
        StringBuffer bf = new StringBuffer();
        try {
            Properties props = System.getProperties();
            String [] cmds=new String[3];
            String osname = props.getProperty("os.name");
            if (osname.equals("Linux")) {
                cmds[0]="/bin/sh";
                cmds[1]="-c";
                cmds[2]=shell;
            } else {
                cmds[0]="cmd.exe";
                cmds[1]="/C";
                cmds[2]=shell;
            }
            Process pro = Runtime.getRuntime().exec(cmds);
            InputStream in = pro.getInputStream();
            BufferedReader read = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = read.readLine()) != null) {
                bf.append(line + "\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = bf.toString();
        if (result == null || result.equals("")) {
            return "command not found";
        }
        return result;
    }
}
