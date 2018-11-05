package com.travel.buddy.coreproject.utils;

import java.io.*;

public class JsonHelper {
    protected String json;

    public void requestJson(String path) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder(512);
        FileInputStream is = new FileInputStream(path);
        Reader r = null;
        try {
            r = new InputStreamReader(is, "UTF-8");
            int c = 0;
            while ((c = r.read()) != -1) {
                sb.append((char) c);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
        	try {
				r.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
        json = sb.toString();
    }
    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }
}
