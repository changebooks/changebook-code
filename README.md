# changebook-code
## 基础库

### 引包 pom.xml
```
<dependency>
  <groupId>io.github.changebooks</groupId>
  <artifactId>changebook-code</artifactId>
  <version>1.0.1</version>
</dependency>
```

### 标准数据传输格式，如
```
{"success":true}

{"success":true,"data":123456}

{"code":500,"message":"系统运行异常"}

{"code":500,"message":"系统运行异常","data":123456}
```

### 常用错误码
```
0    OK
403  无访问权限
404  页面不存在
405  请求方式不支持
500  系统运行异常
501  脚本运行失败
1000 幂等
1001 重复请求
1102 参数错误
1501 未登录
1503 登录过期
2008 未知错误
```

### 常用类
```
Jdbc

Http

Download

Check

Assert

Snowflake

TypeCast: object, string, int, ...

StringCast: underscore, hyphen, camel

... ...
```
