package Program;

import java.awt.image.RescaleOp;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Global.FileInformation;
import Global.ResultInformation;
import Global.properties;
import Global.status;
import UI.SpecificDesign;

public class Analysis {
	public Analysis()
	{
		String temp;//临时文件名
		int i = 1;
		int  num_macth;//匹配到的次数
		int  num_pro;//匹配中的条数
		double p;

		FileInformation vector_file = FileInformation.getInstance();
		properties vector_pro = properties.getInstance();
		ResultInformation vector_result = ResultInformation.getInstance();
		
		for(int j=0; j<vector_file.size(); j++)//每个文件逐步分析
		{
			//System.out.println(vector_file.size());
			status.sum = 0;
			temp =(String) vector_file.m_element.get(j);//得到临时文件名
		
			ReadTXT eachfile =new ReadTXT();
			String file_infomation = eachfile.readFile(temp,i);//读取每个文件信息
			
			for(int l = 0;l < vector_pro.size();l++)//按配置文件遍历
			{
				num_macth = 0;//匹配到的次数
			    num_pro = 0;//匹配中的条数
				String a = (String)vector_pro.m_element.get(l);//得到一行配置信息
				String splitstring[] = a.trim().split(" ");//按空格分割
				for(int k = 0;k < splitstring.length;k ++)//分割开的每个信息进行匹配
				{
					Pattern r = Pattern.compile(splitstring[k]);
				    Matcher m = r.matcher(file_infomation);
				    if(m.find())
				    {
					    num_macth ++;
				    }
				    num_pro ++;
				    //System.out.println("其实是匹配信息总数为"+num_pro);
				}
				
				if(num_macth > 0)
				{
				    p= (double)num_macth/num_pro;
				   // System.out.println("比率为"+p);    
				    status.sum =status.sum +(0 -  Math.log(p) * p);
				   // System.out.println("熵值为"+status.sum);    
				}
			}
			//System.out.println("存入的熵值为"+status.sum);    
			vector_result.addElement(status.sum);
			SpecificDesign show_r = new SpecificDesign();
			show_r.ShowResult(temp, status.sum);
		}
	}
}
