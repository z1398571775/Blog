package com.yjdxs.blog.service;

import java.util.List;

public interface VedioService {
	/***
	 * 通过用户传进来的url，通过接口解析获取视频的m3u8的播放地址
	 * @param url
	 * @return
	 */
	List<String> getHttp(String url);
}
