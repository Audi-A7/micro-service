eureka：8761
zuul:5050
infrastructure:5060
user:5070

所有的请求都经过了zuul网关  端口5050

1、直接调用基础服务发送邮件：http://127.0.0.1:5050/email/send/wangquanzhou666@163.com/6

2、第一步获得邮件中的注册码  可以用来注册  http://127.0.0.1:5050/user/register

payload:
{
    "userName":"audi",
    "pwd":"123456",
    "email":"wangquanzhou666@163.com",
    "verifyCode":"C3HjGP"
}

3、登录：
http://127.0.0.1:5050/user/login?userName=audi&email=wangquanzhou666@163.com&pwd=123456
登录成功会得到一个token  

4、查询用户信息，需要使用到token
http://127.0.0.1:5050/user/wangquanzhou666@163.com?token=NWLUyffK9OykUjuVHJMEuR8W13LTqVrp