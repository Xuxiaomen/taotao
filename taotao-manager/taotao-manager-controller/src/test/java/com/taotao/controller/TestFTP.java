package com.taotao.controller;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import com.taotao.common.utils.FtpUtil;

public class TestFTP {
	
		@Test
//		public void testFtp() throws Exception {
//			//1、连接ftp服务器
//			FTPClient ftpClient = new FTPClient();
//			ftpClient.connect("192.168.1.107", 21);
//			//2、登录ftp服务器
//			ftpClient.login("xumeng", "987654");
//			//3、读取本地文件
//			FileInputStream inputStream = new FileInputStream(new File("C:\\FTP-upload\\games.jpg"));
//			//4、上传文件
//			//1）指定上传目录
//			ftpClient.changeWorkingDirectory("/");
//			//2）指定文件类型
//			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
//			//第一个参数：文件在远程服务器的名称
//			//第二个参数：文件流
//			ftpClient.storeFile("hello.jpg", inputStream);
//			//5、退出登录
//			ftpClient.logout();
//		}
		
		public void testFtpUtil() throws Exception{
			FileInputStream inputStream = new FileInputStream(new File("C:\\FTP-upload\\games.jpg"));
			FtpUtil.uploadFile("192.168.1.107", 21, "xumeng", "987654", "/","/2017" , "hello1.jpg", inputStream);
		}
		
		
	}

