package mai.base;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/mai/base/*.xml");
        context.getEnvironment().setActiveProfiles("dev");
        SimpleBean bean = context.getBean(SimpleBean.class);
        bean.send();
        context.close();
    }
}
