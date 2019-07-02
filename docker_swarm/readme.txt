注意：
为了能让虚拟机能访问本地物理机的harbor仓库。
需要设置如下参数：
vim /lib/systemd/system/docker.service
在ExecStart行末尾添加--insecure-registry=hub.audi.com:1010
同事修改虚拟机的hosts文件
vim /etc/hosts
添加一行  172.20.150.108 hub.audi.com

最后执行如下命令
systemctl daemon-reload
service docker restart

参考：
https://blog.csdn.net/u014628771/article/details/84589151