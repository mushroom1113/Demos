package net._427studio.demo.htmlunit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

//htmlunit官网：http://htmlunit.sourceforge.net/
//jsoup的中文文档：http://www.open-open.com/jsoup/
public class HtmlunitTest {

    
    @Test
    public void homePage() throws Exception {
        
        String pageContent;
        
        
        //step 1 : 使用htmlunit，获取指定网址的网页的内容，该网页中的脚本已被执行
        final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_31);
        
        final HtmlPage page = webClient.getPage("http://op.win007.com/oddslist/1098756.htm");

        pageContent = page.asXml();

        webClient.close();
        
        
        //step 2 : 使用jsoup，解析网页内容，使用jquery语法方便地进行dom操作
        Document doc = Jsoup.parse(pageContent);
        
        Elements trs = doc.select("#oddsList_tab tr");
        
        for(Element tr : trs){
            Elements tds = tr.select("td");
            
            String company = tds.get(1).select("a").text();
            String homeWin = tds.get(2).html();
            String draw = tds.get(3).html();
            String guestWin = tds.get(4).html();
            
            System.out.println("博彩公司：" + company);
            System.out.println("主队胜：" + homeWin);
            System.out.println("平局：" + draw);
            System.out.println("客队胜：" + guestWin);
        }
        
    }
    
    
}
