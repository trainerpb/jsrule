package org.easyrule.examplemains;

import org.easyrule.RuleExecutor;
import org.easyrule.impls.jsfileloader.RuleIdFunctionExecutor;
import org.easyrule.scripts.ScriptUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MC_FileLoadJavascript {

	public static void main(String[] args) throws Exception {
		String jsFilePath="D:\\boka\\js\\A.js";
		Object[] params=new Object[] {5,10};
		String ruleId="demoRule1";
		RuleExecutor ruleExecutor=new RuleIdFunctionExecutor(jsFilePath);
		Object result=ruleExecutor.execute(ruleId, params);
		
		
		System.out.println(result);
		
		
		
		result=ruleExecutor.execute("demoRule2",ScriptUtils.pojoAsJsObject(new Student("Female"),t -> {
			try {
				return new ObjectMapper().writeValueAsString(t);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}));
		System.out.println(result);
	}
	static class Student{
		private String sex;
		
		public String getSex() {
			return sex;
		}

		public void setSex(String sex) {
			this.sex = sex;
		}

		public Student(String sex) {
			
			this.sex = sex;
		}
		
	}
}
