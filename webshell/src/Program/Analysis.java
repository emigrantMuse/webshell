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
		String temp;//��ʱ�ļ���
		int i = 1;
		int  num_macth = 0;//ƥ�䵽�Ĵ���
		int  num_pro = 0;//ƥ���е�����
		double p;
		double sum = 0;
		FileInformation vector_file = FileInformation.getInstance();
		properties vector_pro = properties.getInstance();
		
		for(int j=0; j<vector_file.size(); j++)//ÿ���ļ��𲽷���
		{
			temp =(String) vector_file.m_element.get(j);//�õ���ʱ�ļ���
		
			ReadTXT eachfile =new ReadTXT();
			String file_infomation = eachfile.readFile(temp,i);//��ȡÿ���ļ���Ϣ
			for(j = 0;j < vector_pro.size();j++)//�������ļ�����
			{
				String a = (String)vector_pro.m_element.get(j);//�õ�һ��������Ϣ
				String splitstring[] = a.trim().split(" ");//���ո�ָ�
				for(int k = 0;k < splitstring.length;k ++)//�ָ��ÿ����Ϣ����ƥ��
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
