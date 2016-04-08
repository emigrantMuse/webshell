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
		String temp;//��ʱ�ļ���
		int i = 1;
		int  num_macth;//ƥ�䵽�Ĵ���
		int  num_pro;//ƥ���е�����
		double p;

		FileInformation vector_file = FileInformation.getInstance();
		properties vector_pro = properties.getInstance();
		ResultInformation vector_result = ResultInformation.getInstance();
		
		for(int j=0; j<vector_file.size(); j++)//ÿ���ļ��𲽷���
		{
			//System.out.println(vector_file.size());
			status.sum = 0;
			temp =(String) vector_file.m_element.get(j);//�õ���ʱ�ļ���
		
			ReadTXT eachfile =new ReadTXT();
			String file_infomation = eachfile.readFile(temp,i);//��ȡÿ���ļ���Ϣ
			
			for(int l = 0;l < vector_pro.size();l++)//�������ļ�����
			{
				num_macth = 0;//ƥ�䵽�Ĵ���
			    num_pro = 0;//ƥ���е�����
				String a = (String)vector_pro.m_element.get(l);//�õ�һ��������Ϣ
				String splitstring[] = a.trim().split(" ");//���ո�ָ�
				for(int k = 0;k < splitstring.length;k ++)//�ָ��ÿ����Ϣ����ƥ��
				{
					Pattern r = Pattern.compile(splitstring[k]);
				    Matcher m = r.matcher(file_infomation);
				    if(m.find())
				    {
					    num_macth ++;
				    }
				    num_pro ++;
				    //System.out.println("��ʵ��ƥ����Ϣ����Ϊ"+num_pro);
				}
				
				if(num_macth > 0)
				{
				    p= (double)num_macth/num_pro;
				   // System.out.println("����Ϊ"+p);    
				    status.sum =status.sum +(0 -  Math.log(p) * p);
				   // System.out.println("��ֵΪ"+status.sum);    
				}
			}
			//System.out.println("�������ֵΪ"+status.sum);    
			vector_result.addElement(status.sum);
			SpecificDesign show_r = new SpecificDesign();
			show_r.ShowResult(temp, status.sum);
		}
	}
}
