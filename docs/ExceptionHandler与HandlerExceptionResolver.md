1. 初始化阶段DispatcherServlet#initStrategies => initHandlerExceptionResolvers
   ```text
   获取容器中所有的HandlerExceptionResolver赋值给DispatcherServlet, 并进行排序
   ```
2. DispatcherServlet.processHandlerException
   ```text
   DefaultErrorAttributes
   HandlerExceptionResolverComposite （WebMvcConfigurationSupport#handlerExceptionResolver初始化）
   BusinessHandlerExceptionResolver (自定义HandlerExceptionResolver)
   ```
3. HandlerExceptionResolverComposite#resolveException
    ```text
    ExceptionHandlerExceptionResolver
    ResponseStatusExceptionResolver
    DefaultHandlerExceptionResolver
    ```
4. ServletInvocableHandlerMethod#invokeAndHandle
5. InvocableHandlerMethod#invokeForRequest