package com.nhapis.template.spring;

import com.nhapis.base.ResourceFile;

/**
* @author 牛虹
* @time 2018年07月26日 上午11:49:03
*/
public class ApplicationYmlResourceFile extends ResourceFile {
	private static final String FILE_NAME = "application.yml";
	public ApplicationYmlResourceFile(String fileDir) {
		super(fileDir, FILE_NAME);
		String resource = 
				"server:\r\n" + 
				"  port: 18090\r\n" +
				"  context-path: /\r\n" + 
				"spring:\r\n" + 
				"  datasource:\r\n" + 
				"    driver-class-name: com.mysql.jdbc.Driver\r\n" + 
				"    url: jdbc:mysql://192.168.200.104:3306/cyber\r\n" +
				"    username: root\r\n" + 
				"    password: jjjj@123!@#\r\n" +
				"    tomcat:\r\n" + 
				"      initial-size: 5\r\n" + 
				"      max-active: 30\r\n" + 
				"  jpa:\r\n" + 
				"    hibernate:\r\n" + 
				"      ddl-auto: update\r\n" + 
				"    show-sql: true";
		init(resource);
	}
}
