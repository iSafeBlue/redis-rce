package cn.b1ue.redis.unserialize;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import redis.clients.jedis.Jedis;

import java.io.*;

/**
 * @author 浅蓝
 * @email blue@ixsec.org
 * @since 2020/4/3 16:18
 */
public class JDK {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileInputStream fileInputStream = new FileInputStream("src/main/java/cn/b1ue/redis/unserialize/beanutils_calc.ser");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[128];
        int iLength = 0;
        while((iLength = fileInputStream.read(buffer)) != -1) {
            baos.write(buffer, 0, iLength);
        }

        byte[] bytes = baos.toByteArray();

        //////////////////////////////////////

        Jedis jedis = new Jedis("192.168.91.147", 6379);
        jedis.flushAll();
        jedis.set("x".getBytes(),bytes);

        byte[] badbyte = jedis.get("x".getBytes());

        ByteArrayInputStream stream = new ByteArrayInputStream(badbyte);
        ObjectInputStream objectInputStream = new ObjectInputStream(stream);
        Object o = objectInputStream.readObject();

        jedis.close();

    }

}
