Exception in thread "main" org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'com.walmart.api.coupon.dao.CouponDao' available
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.getBean(DefaultListableBeanFactory.java:351)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.getBean(DefaultListableBeanFactory.java:342)
	at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1175)

Above exception occurs when we are asking for specific bean which is not present in the container.

In order to register classes as spring bean, we must be annotating them with stereotype annotation based on the role
they are performing.

Exception in thread "main" org.springframework.beans.factory.NoUniqueBeanDefinitionException: No qualifying bean of type 'com.walmart.api.coupon.dao.CouponDao' available: expected single matching bean but found 2: couponDaoImpl,couponJpaDaoImpl
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveNamedBean(DefaultListableBeanFactory.java:1273)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveBean(DefaultListableBeanFactory.java:494)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.getBean(DefaultListableBeanFactory.java:349)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.getBean(DefaultListableBeanFactory.java:342)
	at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1175)
	at com.walmart.api.coupon.Application.main(Application.java:21)
	
The cause of above exception is we have 2 types of bean and we are trying to get 1.
In order to resolve this issue, we have to use bean id
Every bean in spring container has unique id associated with it. This id can be used to get that bean specifically.
