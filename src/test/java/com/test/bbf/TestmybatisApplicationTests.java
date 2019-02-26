package com.test.bbf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestmybatisApplicationTests {

	@Test
	public void contextLoads() {
	}


	@Test
	public void testBreak(){
		aaa: for (int x = 0; x < 10; x++){
			System.out.println("x=="+x);
			for (int y = 0; y < 5; y++){
				if (y == 3){
					break aaa;
				}
				System.out.println("y=="+y);
			}
		}

		//aaa:
		System.out.println("所有循环结束！");
	}
}

