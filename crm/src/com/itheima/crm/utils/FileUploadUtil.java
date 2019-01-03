package com.itheima.crm.utils;

import java.util.UUID;

/**
 * 文件上传工具类
 * @author Administrator
 *
 */
public class FileUploadUtil {
	/**
	 * 生成一个随机的文件名,防止文件重名被覆盖
	 * @param oldFileName
	 * @return 随机生成的文件名
	 */
	public static String getFileName(String oldFileName) {
		//获取文件扩展名
		int index = oldFileName.lastIndexOf(".");
		String extion = oldFileName.substring(index);
		//生成随机文件名
		String fileName = UUID.randomUUID().toString().replace("-", "");
		return fileName + extion;
	}
	
	/**
	 * 根据源文件名生成该文件的存储路径
	 * @param oldFileName
	 * @return 存储的路径
	 */
	public static String getSavePath(String oldFileName) {
		
		//定义存储路径
		String savePath = "";
		//获取该文件名的hashcode值
		int hashCode = oldFileName.hashCode();
		int number = 8;
		while(number-- > 0) {
			int n = hashCode & 0xf;
			String temp = "/" + n;
			savePath += temp;
			hashCode = hashCode >>>4;
		}
		return savePath;
	}
}
