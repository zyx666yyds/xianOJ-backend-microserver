# 项目后端微服务

## 项目地址

### 项目后端单体项目地址

<https://github.com/zyx666yyds/xian-oj-back>

### 项目前端地址

<https://github.com/zyx666yyds/xian-oj>

### 项目代码沙箱地址

<https://github.com/zyx666yyds/zyxoj-sandbox>

### 题目模块
+ 创建题目（管理员）
+ 删除题目（管理员）
+ 修改题目（管理员）
+ 搜索题目（用户/管理员）
+ 题目管理（管理员）
+ 在线做题（用户/管理）
+ 提交题目代码（用户/管理）

+ 消息队列：防止判题服务执行时间过长，并使用死信队列处理判题失败的题目，避免消息积压。

### 判题模块

+ 提交判题：结果是否正确与错误
+ 错误处理：内存益出、安全性、超时
+ 代码沙箱：执行代码，返回执行信息
+ 开放接口：提供一个独立的新服务

### 代码沙箱
+ 只负责接受代码和输入，运行代码，返回编译运行的结果，不用管用户提交的程序是否正确(不负责判题)

### 核心流程时序图

![image](https://github.com/zyx666yyds/xian-oj/assets/94099079/5e15f472-5a8c-45da-97fd-55fbe14b2467)

## 项目技术栈
### 后端
+ Spring Boot：简化Spring开发框架
+ Spring MVC
+ Spring Boot 调试工具和项目处理器
+ Spring AOP 切面编程
+ Spring 事务注解
+ Spring Cloud Alibaba
+ Spring Gateway
+ MyBatis + MyBatis Plus 数据访问（开启分页）
+ MyBatis-Plus 数据库访问结构
+ Redis：分布式存储用户信息
+ JWT Token：用户鉴权
+ RabbitMQ：消息队列
+ Docker 代码沙箱，实现隔离环境运行Java程序
+ Java安全管理器：保护 JVM、Java 安全的机制，实现对资源的操作限制
+ Nacos：服务注册管理中心
+ OpenFeign：微服务模块之间调用

### 设计模式
+ 静态工厂模式
+ 代理模式
+ 策略模式

## 项目展示

#### 项目首页
![image](https://github.com/zyx666yyds/xianOJ-backend-microserver/assets/94099079/e09ce50a-2117-4233-a718-3cddc179707f)

#### 管理员创建题目
![image](https://github.com/zyx666yyds/xianOJ-backend-microserver/assets/94099079/ae186bb1-9f72-499c-a5ef-3ddc08073eb9)

#### 题目管理
![image](https://github.com/zyx666yyds/xianOJ-backend-microserver/assets/94099079/bf510ece-d744-459b-8aa4-ddb75e4edab1)

#### 用户登录注册
![image](https://github.com/zyx666yyds/xianOJ-backend-microserver/assets/94099079/6e34fa81-a3f6-4ede-ad92-48d6e4cdf045)
![image](https://github.com/zyx666yyds/xianOJ-backend-microserver/assets/94099079/335a7158-1e37-46ca-a6e9-2a54700de156)