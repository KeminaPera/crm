package com.itheima.crm.utils;

import java.util.UUID;

/**
 * �ļ��ϴ�������
 * @author Administrator
 *
 */
public class FileUploadUtil {
	/**
	 * ����һ��������ļ���,��ֹ�ļ�����������
	 * @param oldFileName
	 * @return ������ɵ��ļ���
	 */
	public static String getFileName(String oldFileName) {
		//��ȡ�ļ���չ��
		int index = oldFileName.lastIndexOf(".");
		String extion = oldFileName.substring(index);
		//��������ļ���
		String fileName = UUID.randomUUID().toString().replace("-", "");
		return fileName + extion;
	}
	
	/**
	 * ����Դ�ļ������ɸ��ļ��Ĵ洢·��
	 * @param oldFileName
	 * @return �洢��·��
	 */
	public static String getSavePath(String oldFileName) {
		
		//����洢·��
		String savePath = "";
		//��ȡ���ļ�����hashcodeֵ
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
