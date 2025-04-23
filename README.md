# Spring Boot DDD Demo

这是一个使用Spring Boot和MyBatis Plus实现的DDD架构示例项目。

## 技术栈

- Spring Boot 2.7.0
- MyBatis Plus 3.5.2
- MySQL 8.0
- Java 11
- Knife4j 4.3.0

## 项目结构

项目采用DDD（领域驱动设计）架构，主要分为以下几层：

- interfaces：接口层，包含控制器等
- application：应用层，包含应用服务
- domain：领域层，包含领域模型、领域服务和仓储接口
- infrastructure：基础设施层，包含仓储实现等

## API 文档（Knife4j）

项目集成了 Knife4j 增强版接口文档，可通过以下方式访问：

### 文档访问地址
```
http://localhost:8080/doc.html
```

在 Knife4j 文档界面中，您可以：
- 查看所有 API 接口的详细信息
- 在线调试接口
- 查看请求和响应示例
- 导出离线文档（支持 Markdown、HTML、Word 格式）
- 查看接口的 OpenAPI 规范

## 运行项目

### 1. 准备数据库

1. 确保已安装MySQL 8.0
2. 使用 `src/main/resources/db/schema.sql` 创建数据库和表

### 2. 配置数据库连接

修改 `src/main/resources/application.yml` 中的数据库连接信息：

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/ddd_demo
    username: your_username
    password: your_password
```

### 3. 运行应用

```bash
mvn spring-boot:run
```

