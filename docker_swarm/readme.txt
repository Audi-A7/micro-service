注意：
为了能让虚拟机能访问本地物理机的harbor仓库。
需要设置如下参数：
vim /lib/systemd/system/docker.service
在ExecStart行末尾添加--insecure-registry=hub.audi.com:1010
同事修改虚拟机的hosts文件
vim /etc/hosts
添加一行  172.20.150.108(实际物理机的ip) hub.audi.com

最后执行如下命令
systemctl daemon-reload
service docker restart

参考：
https://blog.csdn.net/u014628771/article/details/84589151

创建docker swarm网络：
docker network create -d overlay audi-overlay
查看网络
docker network ls

查看集群节点状态，谁是主节点，谁是从节点
docker node ls
输出示例如下：（注意星号的位置）
7ykg71k1705o1iushk6blcvnx *   ubuntu              Ready               Active              Leader              18.09.5
g6wyt596kzshkb01okf93h0c7     ubuntu              Ready               Active              Reachable           18.09.5
hzmiklyuzaee7y2ltm91puobr     ubuntu              Ready               Active              Reachable           18.09.5


编写services.yaml文件
在 主节点 上，启动docker swarm集群命令：
docker stack deploy -c /home/audi/services.yml test
查看fuwu
docker service ls

删除部署的微服务集群
docker stack rm test
