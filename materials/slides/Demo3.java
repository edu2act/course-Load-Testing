package com.edu.functions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.jmeter.engine.util.CompoundVariable;
import org.apache.jmeter.functions.AbstractFunction;
import org.apache.jmeter.functions.InvalidVariableException;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.samplers.Sampler;

public class Demo3 extends AbstractFunction{

	Object[] values;
	//���ú����Ĳ���
	@Override
	public List<String> getArgumentDesc() {
		System.out.println("getArgumentDesc");
		List desc =new ArrayList();
		desc.add("num1");
		desc.add("num2");
		return desc;
	}

	private CompoundVariable n1,n2;
	@Override
	public String execute(SampleResult arg0, Sampler arg1) throws InvalidVariableException {

		System.out.println("execute");
		n1=(CompoundVariable) values[0];
		n2=(CompoundVariable) values[1];
		System.out.println("��һ��������"+n1);
		System.out.println("�ڶ���������"+n2);
		int result=new Integer(n1.execute().trim())+
				new Integer(n2.execute().trim());
		return String.valueOf(result);
	}

	//���ú���������
	@Override
	public String getReferenceKey() {
		System.out.println("getReferenceKey");
		return "__demo11";
	}

	@Override
	public void setParameters(Collection<CompoundVariable> arg0) throws InvalidVariableException {
		System.out.println("setParameters");
		checkParameterCount(arg0,2);
		values=arg0.toArray();
		
	}

}
