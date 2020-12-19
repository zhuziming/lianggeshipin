package com.lianggeshipin.www.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<String> files = new ArrayList<String>();
        File file = new File("E:\\英语资料\\ps后的成品图");
        File[] tempList = file.listFiles();

        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
            	String name = tempList[i].getName();
            	String[] str = name.split("\\.");
            	System.out.println(str[0] + " " + str[1]);
            	
            }
            if(i>20){
            	return;
            }
        }

	}

	/**
	   
	    public static List<String> getFiles(String path) {
	        List<String> files = new ArrayList<String>();
	        File file = new File(path);
	        File[] tempList = file.listFiles();

	        for (int i = 0; i < tempList.length; i++) {
	            if (tempList[i].isFile()) {
	                files.add(tempList[i].toString());
	                //文件名，不包含路径
	                //String fileName = tempList[i].getName();
	            }
	            if (tempList[i].isDirectory()) {
	                //这里就不递归了，
	            }
	        }
	        return files;
	    }
	 
	    */
}
