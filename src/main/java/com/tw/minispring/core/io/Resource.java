package com.tw.minispring.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: linfeng
 * @Date: 2023/6/11 10:28 下午
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
