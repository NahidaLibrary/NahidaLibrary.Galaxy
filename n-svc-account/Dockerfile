# 基础镜像
FROM adoptopenjdk:11-jdk-hotspot

# 指定工作目录
WORKDIR /app

# 将 jar 包添加到工作目录
ADD target/n-svc-account-0.0.1-SNAPSHOT.jar .

# 暴露端口
EXPOSE 9101

# 启动命令
ENTRYPOINT ["java","-Xms64m","-Xmx64m","-jar","/app/n-svc-account-0.0.1-SNAPSHOT.jar","--spring.profiles.active=prod"]
