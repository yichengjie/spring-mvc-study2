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