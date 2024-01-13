### 因为摸鱼翻看知乎，但是无论是手机还是网页，广告都奇多！！！而且推荐的质量很不好。
### 所以写了一个程序不断获取页面筛选出点赞大于1000的问题和答案。保存到了数据库。毕竟没有那个人会给广告点赞到1000.哈哈哈。

#### 具体样子：
![image](https://github.com/yelinlan/zhihu/assets/38036830/f26e53e2-5d58-4633-b587-a335530f7946)

#### 注意事项：
java -jar zhihu.jar --start=true //启动监听
http://xxxxxxx/forever //调用接口 启动循环 
http://xxxxxxx/status //调用接口 查看是否启动循环
http://xxxxxxx/stop //调用接口 停止循环
http://xxxxxxx/page //调用接口 查看分页
