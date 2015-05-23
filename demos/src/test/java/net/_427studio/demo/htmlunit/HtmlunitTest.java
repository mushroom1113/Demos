package net._427studio.demo.htmlunit;

import org.junit.Assert;
import org.junit.Test;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * htmlunit官网：http://htmlunit.sourceforge.net/
 */
public class HtmlunitTest {

    @Test
    public void homePage() throws Exception {
        final WebClient webClient = new WebClient();
        
        final HtmlPage page = webClient.getPage("http://page.zidafone.com/");
        Assert.assertEquals("临时信息发布页", page.getTitleText());

        final String pageAsXml = page.asXml();
        Assert.assertTrue(pageAsXml.contains("<body>"));

        final String pageAsText = page.asText();
        Assert.assertTrue(pageAsText.contains("测试临时信息发布"));
        
        webClient.close();
    }
    
    @Test
    public void homePage_Browser() throws Exception {
        final WebClient webClient = new WebClient(BrowserVersion.CHROME);
        final HtmlPage page = webClient.getPage("http://page.zidafone.com/");
        Assert.assertEquals("临时信息发布页", page.getTitleText());
        webClient.close();
    }
}
