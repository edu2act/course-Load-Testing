package com.edu.he;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

public class Demo2 implements JavaSamplerClient {

	public static String URL="url";
	public static String DEFAULTURL="http://www.baidu.com";
	private String inputUrl;
	@Override
	public void setupTest(JavaSamplerContext context) {
	
		this.inputUrl=context.getParameter(this.URL,this.DEFAULTURL);
		System.out.println("setupTest:"+inputUrl);
		
	}

	
	@Override
	public SampleResult runTest(JavaSamplerContext context) {

		System.out.println("runTest");
		String resultData=null;
		SampleResult result=new SampleResult();
		StringBuffer stringBuffer=new StringBuffer();
		try {
			URL url=new URL(inputUrl);
			byte[] buffer= new byte[1024];
			int len;
			result.sampleStart();
			URLConnection conn=url.openConnection();
			InputStream input=conn.getInputStream();
			while((len=input.read(buffer))!=-1) {
				resultData=new String(buffer,"utf-8");
				stringBuffer.append(resultData);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resultData=stringBuffer.toString();
		
		result.setSuccessful(true);
//		result.setSampleLabel("修改后的java请求");
		result.setResponseData(resultData, null);
		result.setDataType(SampleResult.TEXT);
	
		return result;
	}

	@Override
	public void teardownTest(JavaSamplerContext context) {
	System.out.println("teardownTest");
		
	}

	@Override
	public Arguments getDefaultParameters() {
		System.out.println("getDefaultParameters");
		Arguments args=new Arguments();
		args.addArgument("url","http://www.baidu.com");
		args.addArgument("content-type","json");
		return args;
	}

}
