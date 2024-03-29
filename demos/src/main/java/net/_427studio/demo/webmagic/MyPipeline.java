package net._427studio.demo.webmagic;

import java.util.List;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

public class MyPipeline implements Pipeline{

	/**
	 * 模型进(resultItems)，结果出(方法体内实现)
	 */
	@Override
	public void process(ResultItems resultItems, Task task) {
		
		List<String> links = resultItems.get("links");

		String title = resultItems.get("title");
		System.out.println(title);
		
		//可以用获得到的links和title做点什么，来实现爬虫最终的目的，比如存入数据库
	}

}
