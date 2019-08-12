# itmayiedu-shopp-parent
该项目是关于蚂蚁微服务分布式项目，项目包括会员模块，消息模块，工具模块，外部接口模块，微信模块，订单模块，支付模块及pc端web模块的分布式项目
该项目是基于SpringBoot采用springCloud实现的分布式项目使用Eurake作为注册中心，使用activityMQ作为消息中间件。
## 项目大纲
itmayiedu-shopp-parent

├─itmayiedu-shopp-common                 // 抽取的公共模块
  
├─itmayiedu-shopp-eurekaserver             // eureka注册中心
  
├─itmayiedu-shopp-api                      // api服务 
  
      ├─itmayiedu-shopp-member-api     // 会员服务
      
      ├─itmayiedu-shopp-order-api      // 订单服务
      
      ├─itmayiedu-shopp-order-api      // 商品服务
      
      ├─itmayiedu-shopp-pay-api        // 支付服务
      
  ├─itmayiedu-shopp-member                // 会员系统
  
  ├─itmayiedu-shopp-message                 // 消息系统
  
  ├─itmayiedu-shopp-pc-web             // h5端工程
  
  ├─itmayiedu-shopp-weixin                 // 微信系统
  
  ├─itmayiedu-shopp-pay                 // 支付系统
  
  ├─itmayiedu-shopp-order                 // 订单系统

## 模块分析
### 会员模块
  用于对用户的注册登录的实现，在该模块中考虑到用户的注册邮箱的即使性发消息和点击自动登录的功能，在该模块中使用到
  
  消息中间件来解决分布式同步带来的堵塞及效率问题，使用redis存储唯一ID辨识唯一用户，并用于自动登录，若选择自动登录
  
  将该ID存储到Cookie中。对于登录还实现了三方登录
### 消息模块
  该消息模块采用邮件的方式进行，其中消息模块应该有手机短信等其他第三方，代码实现采用适配器进行对应消息的适配并进行处理

### 工具模块
  该模块负责整个项目所涉及的工具包，以及需要定义的常量，及父类模板类。该模块定义了全项目常量，及自定义json体，工具类（其中包括
  使用生成tokenid,解析xml,日期装换，md5加密,httpclient装换等）
### 外部接口模块
  为了解耦，并更好的实现相关业务在该模块定义好接口及相关业务的实体类
### 微信模块
  该模块解决项目在微信端推送消息及人工智能接口的实现。模块使用微信端提供的测试号
### 订单模块
  主要用于负责订单消息状态的修改
### 支付模块
  该模块负责对接三方支付平台实现项目订单的支付，该模块实现三方的接口，并且因为涉及到跨数据库的操作，该模块涉及分布式的事务管理及解决
### pc端web模块
  该模块负责提供项目外网访问的权限及业务的内部处理转发

## 项目实现
1.修改会员模块配置文件的数据库相关信息

2.修改信息模块配置文件的邮件信息

3.修改订单模块配置文件数据库的相关信息

4.修改支付模块阿里配置类的商户私钥和支付宝公钥，以及外网回调地址包括同步及异步

5.修改微信模块的配置文件的微信测试号appid和appsecret以及Token，注意需要配置外网地址响应微信端传输过来的数据，微信端也需要配置，更多请参阅微信公众平台开发者文档。

6.启动时找到Eurake注册中心，启动注册中心。该信息模块涉及到消息中间件查看消息任务可以下载activityMQ运行客户端查看

展示项目地址：https://blog.csdn.net/qq_41360177/article/details/96478275
