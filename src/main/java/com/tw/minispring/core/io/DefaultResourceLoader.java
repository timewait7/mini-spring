package com.tw.minispring.core.io;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author: linfeng
 * @Date: 2023/6/11 10:41 下午
 */
public class DefaultResourceLoader implements ResourceLoader {

    private static final String CLASSPATH_PREFIX = "classpath:";

    @Override
    public Resource getResource(String location) {
        if (location.startsWith(CLASSPATH_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_PREFIX.length()));
        } else {
            try {
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                return new FileSystemResource(location);
            }
        }
    }
}
