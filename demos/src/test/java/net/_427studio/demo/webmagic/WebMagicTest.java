package net._427studio.demo.webmagic;

import org.junit.Test;

import us.codecraft.webmagic.Spider;

public class WebMagicTest {

    @Test
    public void test() {
    	//整体来看：请求进，结果出
        Spider.create(new MyPageProcessor())
        .addUrl("http://zidafone.com/")
        .addPipeline(new MyPipeline())
        .thread(5)
        .run();
    }
}
