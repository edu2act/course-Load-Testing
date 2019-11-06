package com.edu.he;

import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

public class Demo1 extends AbstractJavaSamplerClient {

	@Override
	public SampleResult runTest(JavaSamplerContext context) {
		System.out.println("hello,1106");
		return null;
	}

}
 