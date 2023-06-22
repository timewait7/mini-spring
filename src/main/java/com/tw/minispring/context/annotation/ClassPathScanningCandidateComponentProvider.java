package com.tw.minispring.context.annotation;

import cn.hutool.core.util.ClassUtil;
import com.tw.minispring.beans.factory.config.BeanDefinition;
import com.tw.minispring.stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @Author: linfeng
 * @Date: 2023/6/22 5:29 下午
 */
public class ClassPathScanningCandidateComponentProvider {

    public Set<BeanDefinition> findCandidateComponents(String basePackage) {
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for (Class<?> clazz : classes) {
            BeanDefinition beanDefinition = new BeanDefinition(clazz);
            candidates.add(beanDefinition);
        }
        return candidates;
    }
}
