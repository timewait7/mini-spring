package com.tw.minispring.ioc;

import cn.hutool.core.io.IoUtil;
import com.tw.minispring.core.io.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Author: linfeng
 * @Date: 2023/6/11 10:46 下午
 */
public class ResourceLoaderTest {

    @Test
    public void testLoadClasspathResource() throws IOException {
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();

        // 加载classpath下的资源
        Resource resource = resourceLoader.getResource("classpath:hello.txt");

        assertThat(resource instanceof ClassPathResource).isTrue();

        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);

        assertThat(content).isEqualTo("hello");

        System.out.println(content);
    }

    @Test
    public void testLoadFileSystemResource() throws IOException {
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();

        // 加载文件系统下的资源
        Resource resource = resourceLoader.getResource("src/main/resources/hello.txt");

        assertThat(resource instanceof FileSystemResource).isTrue();

        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);

        assertThat(content).isEqualTo("hello");

        System.out.println(content);
    }

    @Test
    public void testLoadUrlResource() throws IOException {
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();

        // 加载Url资源
        Resource resource = resourceLoader.getResource("https://www.baidu.com");

        assertThat(resource instanceof UrlResource).isEqualTo(true);

        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);

        System.out.println(content);
    }
}
