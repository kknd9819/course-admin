# 课程管理系统

## 简介
此系统可以对课程表进行远程维护，功能包括：

- 新增课程
- 修改课程
- 删除课程
- 查看课程
- 导出csv

## 演示地址
https://czjava.com/course-admin/courses

## 项目亮点
- 严格的restful风格API
- 严格的后端数据验证，保障数据安全
- 集成本地缓存，多次查询只有第一次访问数据库，减轻数据库压力
- 很好的职责分离，和包结构管理

## 包结构及模块依赖图
- 如果图挂了，请开VPN后再刷新页面

![img.png](file/depend.png)

## 所用技术
| 序号 | 名词   | 技术                             | 版本号            |
|----|------|--------------------------------|----------------|
| 1  | 编程语言 | java                           | 21             |
| 2  | 后端框架 | SpringBoot                     | 3.4.0          |
| 3  | 持久层  | Mybatis plus                   | 3.5.9          |
| 4  | 在线文档 | knife4j                        | 4.5.0          |
| 5  | 本地缓存 | caffeine                       | 跟随springboot版本 |
| 6  | 验证器  | spring-boot-starter-validation | 跟随springboot版本 |
| 7  | 模板渲染 | Thymeleaf                      | 跟随springboot版本 |
| 8  | 数据库  | MySQL                          | 8.4            |
| 7  | 前端框架 | LayUI                          | v2.9.20        |

## 部署前置环境准备
1. jdk21
2. maven 3.9+
3. mysql 8+

## 部署流程
1. 先执行sql/init-schema.sql，初始化数据库
2. 修改application.properties中的数据库配置
3. 编译打包，执行命令 mvn clean package -DskipTests -U
4. 进入target目录，执行 java -jar course-admin.jar
5. 访问浏览器， http:localhost:8089/course-admin/courses

