package com.tw.minispring.context;

import com.tw.minispring.beans.factory.HierarchicalBeanFactory;
import com.tw.minispring.beans.factory.ListableBeanFactory;
import com.tw.minispring.core.io.ResourceLoader;

/**
 * @Author: linfeng
 * @Date: 2023/6/17 3:24 下午
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader {

}
