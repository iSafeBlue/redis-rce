package cn.b1ue.redis.springboot.controller;

import cn.b1ue.redis.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 浅蓝
 * @email blue@ixsec.org
 * @since 2020/4/9 16:59
 */
@Controller
public class TestController {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("login")
    public String login(User user){
        long l = System.currentTimeMillis();
        String key = user.getUsername();
        user.setLastLoginTime(String.valueOf(l));
        redisTemplate.opsForValue().set(key,user);
        return "redirect:home?username="+user.getUsername();
    }

    @RequestMapping("home")
    @ResponseBody
    public String home(String username){
        Object o = redisTemplate.opsForValue().get(username);
        return o.toString();
    }


}
