package com.qf.j1902;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServerConsumerHoutai1ApplicationTests {
	@Autowired
	private Jedis jedis;
	@Test
	public void contextLoads() {
		String num = jedis.set("num", "10");

	}

}
