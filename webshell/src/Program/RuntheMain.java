package Program;

import java.io.File;

import Global.status;

public class RuntheMain {
public RuntheMain() throws Exception
{
	/*****
	 * ��ȡĿ¼�µ������ļ��б�
	 */
	GetAllFile step1= new GetAllFile();
	
	/******
	 * 
	 * ��ȡ�ؼ���
	 * 
	 */
	ReadTXT step2=new ReadTXT();
	step2.Readwebshell();
	
	/******
	 * 
	 * ���������ļ����ҷ������Ƿ�Ϊwebshell
	 */
	Analysis step3 = new Analysis();
}
}
