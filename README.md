Pandora Java APP
========

准备工作
=============

Pandora-Java-App项目涉及到 [Java](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) 和 [NodeJs](https://nodejs.org/en/download/) ，关于`Java`和`NodeJs`的开发与编译环境要求如下: 

    - Java (>= 11)
    - NodeJs (>=12.13.0 & <13.0.0 || >=14.15.0 & <15.0.0)

你需要执行下面的命令来安装`rush`和`pnpm`进行前端的编译，关于前端的详细文档在 ([./frontend/README.md](/frontend/README.md))。

    $ sudo npm install -g @microsoft/rush@5.54.0
    $ sudo npm install -g pnpm@6.7.1

我们无需手动安装`gradle`工具包，在第一次执行`./gradlew`的命令时，它会自动引导下载`gradle`。


构建与发布
============

Pandora-Java-App源代码的编译发布命令如下，该命令会执行打包工作，默认打包前端和后端:

    $ ./gradlew zip

该`zip`命令将会在项目的`archive/build/zip`目录下生成一个`[project]-[version].zip`文件。

同时可以使用`-Dplugins=demo`选项来控制我们的插件打包范围：

    $ ./gradlew zip -Dplugins=demo
    $ ./gradlew zip -Dplugins=all

如果你想要打包一个`.tar.gz`格式的安装包，只需要更换`zip`为`tar`即可，命令如下：

    $ ./gradlew tar

代码的格式化和校验的命令如下，同时建议您安装IDEA的插件`google-java-format`：

    $ ./gradlew googleJavaFormat
    $ ./gradlew verifyGoogleJavaFormat


建立一个APP
============
1. server目录下创建自定义module，并将其添加进setting.gradle；
2. 打包管理：1.archive/build.gradle中添加app的打包task；2.archive/apps/目录下添加app包相关文件
3. 版本管理：gradle/appversion.properties中添加app版本
4. 仿照demo module编写自定义的java-app