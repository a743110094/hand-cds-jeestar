# 拉取基础镜像
FROM mla132/jre-17-slim
#FROM eclipse-temurin:17.0.10_7-jre-alpine
# 设置作者信息
MAINTAINER Heaven96 "lrx96@foxmail.com"

# 把warning-tool-0.0.1-SNAPSHOT.jar添加到容器里，并重命名为warning-tool.jar
# 因为jar和Dockerfile在同一个目录下，所以只写文件名即可
ADD target/app.jar /app.jar

# 设置端口号，此处只开放一个端口8020
EXPOSE 8020

# 执行命令，此处运行warning-tool.jar 指定配置文件
#RUN bash -c 'touch /warning-tool.jar'
ENTRYPOINT ["java","-jar","app.jar"]