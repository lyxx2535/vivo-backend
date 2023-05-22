# vivo_backend

## 系统环境

本机需要jdk8环境 

已用docker部署了mysql环境，地址是http://121.43.109.60:9712

## 依赖安装方式

maven安装

## 项目运行方式

我们已用docker将后端部署到阿里云服务器，前端可以从9713端口访问，其中http://121.43.109.60:9713/swagger-ui.html 可以访问接口文档并测试接口

若本地通过VivoBackendApplication.java运行，后端会暴露在8083端口，同理可以通过postman、swagger、浏览器等访问