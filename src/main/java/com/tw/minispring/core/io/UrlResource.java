package com.tw.minispring.core.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Author: linfeng
 * @Date: 2023/6/11 10:38 下午
 */
public class UrlResource implements Resource {

    private final URL url;

    public UrlResource(URL url) {
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection conn = this.url.openConnection();
        return conn.getInputStream();
    }
}
