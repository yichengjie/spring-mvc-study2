#### 实战笔记
1. 编写Mvc配置类
    ```java
    @Configuration
    @EnableWebMvc
    @ComponentScan("com.yicj.study.webmvc.controller")
    public class WebConfig {
    }
    ```
2. 编写App配置类
   ```java
   @Configuration
   @ComponentScan("com.yicj.study.webmvc.service")
   public class AppConfig {
   }
   ```
3. 编写Java注解MVC启动类（WebApplicationInitializer接口实现类）
   ```java
   public class MvcWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
      @Override
      protected Class<?>[] getRootConfigClasses() {
         return new Class[]{AppConfig.class};
      }
      @Override
      protected Class<?>[] getServletConfigClasses() {
         return new Class[]{WebConfig.class};
      }
      @Override
      protected String[] getServletMappings() {
         return new String[]{"/"};
      }
      @Override
      protected Filter[] getServletFilters() {
         return new Filter[]{new CharacterEncodingFilter("utf-8", true)};
      }
   }
   ```
#### 原理分析
1. servlet提供API: ServletContainerInitializer, 其中SpringServletContainerInitializer继承ServletContainerInitializer
    ```java
    @HandlesTypes(WebApplicationInitializer.class)
    public class SpringServletContainerInitializer implements ServletContainerInitializer {
        @Override
        public void onStartup(@Nullable Set<Class<?>> webAppInitializerClasses, ServletContext servletContext)
                throws ServletException {
            List<WebApplicationInitializer> initializers = new ArrayList<>(webAppInitializerClasses.size());
                for (Class<?> waiClass : webAppInitializerClasses) {
                    if (!waiClass.isInterface() && !Modifier.isAbstract(waiClass.getModifiers()) &&
                            WebApplicationInitializer.class.isAssignableFrom(waiClass)) {
                       initializers.add((WebApplicationInitializer)
                                    ReflectionUtils.accessibleConstructor(waiClass).newInstance());
                    }
                }
            servletContext.log(initializers.size() + " Spring WebApplicationInitializers detected on classpath");
            AnnotationAwareOrderComparator.sort(initializers);
            for (WebApplicationInitializer initializer : initializers) {
                initializer.onStartup(servletContext);
            }
        }
    }
    ```
2. AbstractAnnotationConfigDispatcherServletInitializer的入口是onStartup方法
3. DispatcherServlet的入口是init方法