package com.lianggeshipin.www.util;


public class Test {

	public static void main(String[] args) {
		double sum = Math.ceil(52 / 50);
		System.out.println(sum);
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
