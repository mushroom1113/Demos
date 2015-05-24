package net._427studio.demo.webmagic;

import java.util.List;

import org.junit.Test;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

public class MyPageProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(1).setSleepTime(100);

    @Override
    public void process(Page page) {
    	//页面进
    	Html html = page.getHtml();
    	
    	//模型出
    	String title = html.xpath("title/text()").toString();
    	page.putField("title", title);
    	List<String> links = html.xpath("//a/text()").all();
    	page.putField("links", links);
    	
    	//请求出
        page.addTargetRequests(page.getHtml().links().regex("(http://zidafone\\.com/.*)").all());
    }

    @Override
    public Site getSite() {
        return site;
    }

}