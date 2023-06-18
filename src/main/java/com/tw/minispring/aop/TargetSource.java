package com.tw.minispring.aop;

/**
 * @Author: linfeng
 * @Date: 2023/6/18 9:52 下午
 *
 * 被代理的目标对象
 */
public class TargetSource {

    private final Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    public Object getTarget() {
        return target;
    }

    public Class<?>[] getTargetClass() {
        return target.getClass().getInterfaces();
    }
}
