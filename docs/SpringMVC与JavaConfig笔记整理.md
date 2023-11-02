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
#### 启动流程与配置加载
1. Servlet提供API: ServletContainerInitializer是容器启动的入口
2. 其中SpringServletContainerInitializer继承ServletContainerInitializer，启动时会回调WebApplicationInitializer
3. AbstractAnnotationConfigDispatcherServletInitializer继承WebApplicationInitializer并实现了onStartup方法
4. 在步骤2的onStartup方法中初始化了SpringRoot根容器与SpringMvc容器
5. 在构建SpringMvc容器的同时初始化了DispatcherServlet类，并自动回调init方法
6. FrameworkServlet#initServletBean设置Spring根容器与SpringMvc容器的父子关系，并执行configureAndRefreshWebApplicationContext刷新
7. 容器启动完成通过ContextRefreshListener事件监听回调FrameworkServlet#onApplicationEvent方法
8. 在上一步的onApplicationEvent中调用DispatcherServlet#onRefresh(event.getApplicationContext())
9. DispatcherServlet#initStrategies初始化SpringMvc相关的组件