# Docker image for springboot file run
# VERSION 0.0.1
# 基础镜像使用java
FROM openjdk:11

# VOLUME 指定了临时文件目录为/tmp。
# 其效果是在主机 /var/lib/docker 目录下创建了一个临时文件，并链接到容器的/tmp
# 设置挂载数据卷

# 将jar包添加到容器中
ADD vivoBackend.jar /vivoBackend.jar

# 先创建文件 再挂载
# 手动挂载
#EXPOSE 9000

# 运行
ENTRYPOINT ["java","-jar","/vivoBackend.jar"]