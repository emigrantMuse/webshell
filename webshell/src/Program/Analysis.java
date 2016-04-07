package Program;

import java.awt.image.RescaleOp;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Global.FileInformation;
import Global.properties;

public class Analysis {
	public Analysis()
	{
		String temp;//临时文件名
		int i = 1;
		int  num_macth = 0;//匹配到的次数
		int  num_pro = 0;//匹配中的条数
		double p;
		double sum = 0;
		FileInformation vector_file = FileInformation.getInstance();
		properties vector_pro = properties.getInstance();
		
		for(int j=0; j<vector_file.size(); j++)//每个文件逐步分析
		{
			temp =(String) vector_file.m_element.get(j);//得到临时文件名
		
			ReadTXT eachfile =new ReadTXT();
			String file_infomation = eachfile.readFile(temp,i);//读取每个文件信息
			for(j = 0;j < vector_pro.size();j++)//按配置文件遍历
			{
				String a = (String)vector_pro.m_element.get(j);//得到一行配置信息
				String splitstring[] = a.trim().split(" ");//按空格分割
				for(int k = 0;k < splitstring.length;k ++)//分割开的每个信息进行匹配
				{
					Pattern r = Pattern.compile(splitstring[k]);
				    Matcher m = r.matcher(file_infomation);
				    if(m.find())
					    num_macth ++;
				    num_pro ++;
				}
				
				if(num_macth > 0)
				{
				    p= (double)num_macth/num_pro;
				    sum =sum +(0 -  Math.log(p) * p);
				}
			}
		
		}
	}

}
