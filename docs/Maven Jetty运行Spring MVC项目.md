1. pom引入插件
    ```xml
    <plugin>
        <groupId>org.eclipse.jetty</groupId>
        <artifactId>jetty-maven-plugin</artifactId>
        <version>9.4.53.v20231009</version>
        <configuration>
            <webApp>
                <contextPath>/</contextPath>
            </webApp>
        </configuration>
    </plugin>
    ```
2. 项目设置为war形式
    ```xml
    <packaging>war</packaging>
    ```
3. Idea的Edit Configurations 然后选择Maven 点击 ‘+号’ 进行配置
    ```text
    a. Name: spring-mvc-hello-webmvc(根据个人爱好自定义)
    b. Working directory: 选中要运行的项目
    c. Command line: clean jetty:run
    ```
4. 点击 Debug 图标运行项目