package com.psc.j215.core;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class BeanFactoryHandler implements BeanFactoryAware {

    private static BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Deprecated
    public static final Object getBean(final String beanName) {
        return beanFactory.getBean(beanName);
    }

    public final Object getBeanInstance(final String beanName) {
        return beanFactory.getBean(beanName);
    }

}

