package com.tw.minispring.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.tw.minispring.BeanFactoryAware;
import com.tw.minispring.beans.BeansException;
import com.tw.minispring.beans.PropertyValue;
import com.tw.minispring.beans.factory.DisposableBean;
import com.tw.minispring.beans.factory.config.AutowireCapableBeanFactory;
import com.tw.minispring.beans.factory.config.BeanDefinition;
import com.tw.minispring.beans.factory.config.BeanPostProcessor;
import com.tw.minispring.beans.factory.config.BeanReference;
import org.springframework.context.annotation.Bean;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {

    private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        return doCreateBean(beanName, beanDefinition);
    }

    protected Object doCreateBean(String beanName, BeanDefinition beanDefinition) {
        Object bean;
        try {
            bean = createBeanInstance(beanDefinition);
            // 为bean填充属性
            applyPropertyValues(beanName, bean, beanDefinition);
            // 执行bean的前置处理、初始化、后置处理
            bean = initializeBean(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        // 注册有销毁方法的bean
        registerDisposableBeanIfNecessary(beanName, bean, beanDefinition);

        addSingleton(beanName, bean);
        return bean;
    }

    protected void registerDisposableBeanIfNecessary(String beanName, Object bean, BeanDefinition beanDefinition) {
        if (bean instanceof DisposableBean && StrUtil.isNotEmpty(beanDefinition.getDestroyMethodName())) {
            registerDisposableBean(beanName, new DisposableBeanAdapter(bean, beanName, beanDefinition));
        }
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition) {
        return getInstantiationStrategy().instantiate(beanDefinition);
    }

    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                if (value instanceof BeanReference) {
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }

                // 通过反射设置属性
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values for bean: " + beanName, e);
        }
    }

    protected Object initializeBean(String beanName, Object bean, BeanDefinition beanDefinition) {
        if (bean instanceof BeanFactoryAware) {
            ((BeanFactoryAware) bean).setBeanFactory(this);
        }

        Object wrappedBean = applyBeanPostProcessorsBeforeInitialization(bean, beanName);

        invokeInitMethods(beanName, wrappedBean, beanDefinition);

        wrappedBean = applyBeanPostProcessorsAfterInitialization(bean, beanName);

        return wrappedBean;
    }

    @Override
    public Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for (BeanPostProcessor processor : getBeanPostProcessors()) {
            Object current = processor.postProcessBeforeInitialization(result, beanName);
            if (current == null) {
                return result;
            }
            result = current;
        }
        return result;
    }

    @Override
    public Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for (BeanPostProcessor processor : getBeanPostProcessors()) {
            Object current = processor.postProcessAfterInitialization(result, beanName);
            if (current == null) {
                return result;
            }
            result = current;
        }
        return result;
    }

    protected void invokeInitMethods(String beanName, Object bean, BeanDefinition beanDefinition) {
        // todo 后面实现具体细节
        System.out.println("执行bean[" + beanName + "]的初始化方法");
    }

    private InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    private void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
