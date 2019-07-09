package com.qf.j1902;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServerProviderTwoApplicationTests {

	@Test
	public void contextLoads() throws ParseException {
		String dateStr = "Wed Sep 16 11:26:23 CST 2009";
		SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);

      //java.util.Date对象
		Date date = (Date) sdf.parse(dateStr);

     //2009-09-16
		String formatStr = new SimpleDateFormat("yyyy-MM-dd").format(date);
		System.out.println(formatStr);

     //2009-09-16 11:26:23
		String formatStr2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		System.out.println(formatStr2);
	}

}
