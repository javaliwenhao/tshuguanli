package cn.kgc;

import java.util.Scanner;

public class Bookmanage {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
//�����ĸ����飬���������״̬��������ڣ�������������鳤��Ϊ6������6�������Ϣ��
		String[] bookNames = new String[6];//�洢����������
		int[] status = new int[6];//�洢���״̬�����飬status[i]Ϊ0���ɽ��ģ�Ϊ1���ѽ��
		int[] dates = new int[6];//�������
		int[] counts = new int[6];//�������
		double price=0.5;//�������ÿ��0.5Ԫ
//��ʼ��3�������Ϣ
		bookNames[0] = "���� �� һ �ա�";//�鱾����"����һ�ա���
		status[0] = 1;//Ϊ1����־���Ѿ����
		dates[0] = 1;//���£�һ�Ž��
		counts[0] = 10;//�����15��
		
		bookNames[1] = "��java������";//�鱾����"java��������
		status[1] = 0;//Ϊ0����־��δ���
		counts[1] = 15;//�����15��
		
		bookNames[2] = "��    ��   ��     ��";//�鱾����"���ԡ���
		status[2] = 0;//Ϊ0����־��δ���
		counts[2] = 20;//�����15��
		
// 2.do...whileѭ�� ���ϵͳ���ܣ����ж����ʶflag��Ϊtrueʱ����ѡ���ܣ�����0ʱ��while����(num==0)���ش�ӡ�˵� ��falseΪʱ���˳�ϵͳ����ʾллʹ��
		boolean flag=true;//��ʶflag,����ѭ��
		int num=-1;//��num==0����ѭ������ϵͳ
		do{
//��ʾ���ܲ˵���
			System.out.println("**********��ӭʹ������ͼ�����ϵͳ**********");
			System.out.println("1.����ͼ��");
			System.out.println("2.�鿴ͼ��");
			System.out.println("3.ɾ��ͼ��");
			System.out.println("4.���ͼ��");
			System.out.println("5.�黹ͼ��");
			System.out.println("6.�˳�ϵͳ");
			System.out.println("**************����ǹ������************");
			System.out.println("��ѡ���ܣ�");
			int choose = input.nextInt();// ��¼ѡ��Ĺ������
			
			switch(choose){
				case 1:
					System.out.println("��������ͼ�鹦��");// ��������ͼ�鹦��
					System.out.println("��������ͼ������ƣ�");// ��¼Ҫ������ͼ������
					String name=input.next();
					// �ж��Ƿ������ӳɹ���Ĭ�ϲ��ɹ���������ɹ�������ʾ��������
					boolean addFlag=false;
					for(int i=0;i<bookNames.length;i++){// ѭ������ͼ���������飬�ҵ���һ����λ���洢����
						if(bookNames[i]==null){
							bookNames[i]=name;// �ҵ���һ��û�������Ŀ�λ�����������ӵ���λ��
							addFlag=true;//��ӳɹ�����ʶ��Ϊtrue
							break;// ��ӳɹ��������������ҿ�λ
						}
					}
					if(!addFlag){//û�ҵ���λ
						System.out.println("������������ͼ��ʧ��");
					}
					break;
				case 2:
					System.out.println("����鿴ͼ�鹦��");// ����鿴ͼ�鹦��
					System.out.println("���\tͼ������\t\t\t����״̬\t�������\t�������");
					for (int i=0; i<bookNames.length;i++) {//����ͼ����������
						if (bookNames[i]!=null) {// ���������Ϊ�գ�����ʾ�鱾��Ϣ
							// �ж�״̬��0����1
							String statusStr=(status[i]==0) ? "�ɽ���" : "�ѽ��";
							// ����������Ϊ0�����ʾû�н����������ʾ���ʱ��Ϊ X��
							String dateStr =(dates[i]==0)?" ":dates[i]+"��";
							//����鱾��Ϣ
							System.out.println((i+1)+"\t"+bookNames[i]+"\t\t"+ statusStr + "\t" + dateStr + "\t"+ counts[i]);
						}
					}
					break;
				case 3:
					System.out.println("����ɾ��ͼ�鹦��");// ����ɾ��ͼ�鹦��
					boolean delFlag = false;//�ҵ�Ҫɾ�����飬Ĭ���Ҳ���delFlag = false;
					int index = -1;//û���ҵ�ͼ��ʱ���±�Ϊ-1������ΪҪɾ���±��Ӧ��ͼ��
					System.out.println("��������Ҫɾ�����鱾��ţ�");
					int number= input.nextInt();//��¼Ҫɾ����ͼ������
					for(int i=0;i<bookNames.length;i++){
						if(number>6||number<1){
							System.out.println("�鱾���������������������1~6:");
							number= input.nextInt();
						}
						//���ͼ�����Ʋ�Ϊ��  && ״̬Ϊ�ɽ��ģ�����ʾɾ���ɹ�
						if(bookNames[number-1]!=null && status[number-1]==0){
							System.out.println("ɾ���ɹ�");
							index = number-1;//��Ҫɾ����ͼ���±긳ֵ��index�����±�֮���ͼ��Ҫǰ��
							delFlag = true;
							break;//����ѭ��
						}
						//���ͼ�����Ʋ�Ϊ��  && ״̬Ϊ�ѽ��������ʾ�޷�ɾ����ͼ����δ�黹
						else if(bookNames[number-1]!=null && status[number-1]==1){
							System.out.println("ɾ��ʧ�ܣ�ͼ����δ�黹");
							delFlag = true;
							break;
						}
					}
					if(index!=-1){//��ʾ�ҵ��˵�ͼ�飬ɾ��ͼ��󣬺����ͼ��ǰ��
						for(int j=index;j<bookNames.length;j++){
							if(j!=bookNames.length-1){//ɾ���Ĳ������һλ����ǰ��
								bookNames[j] = bookNames[j+1];
								status[j] = status[j+1];
								dates[j] = dates[j+1];
								counts[j] = counts[j+1];
							}
						}
						//����ɾ�����ǵڼ���ͼ�飬��Ҫ�����һ�����ÿ�
						bookNames[bookNames.length-1] = null;
						status[bookNames.length-1] = 0;
						dates[bookNames.length-1] = 0;
						counts[bookNames.length-1] = 0;
					}
					
					if(!delFlag){//û���ҵ�ͼ��
						System.out.println("û���ҵ�ƥ���ͼ�飡");
					}
					break;
				case 4:
					System.out.println("������ͼ�鹦��");// ������ͼ�鹦��
					boolean wantFlag = false;//���ҵ�Ҫ���������Ĭ��Ҫ����鲻����
					System.out.println("������Ҫ���������");//��¼Ҫ���������
					String wantBook=input.next();//��������
					for(int i=0;i<bookNames.length;i++){
						//������Ϊ�� && �ҵ���ƥ������� && �鴦�� �ɽ���״̬��
						if(bookNames[i]!=null&&wantBook.equals(bookNames[i])&&status[i]==0){
							wantFlag = true;//��־���Խ���
							System.out.println("�����������ڣ�");
							int dateStr = input.nextInt();//�޸Ľ������
							while(dateStr < 1 || dateStr > 31){
								System.out.println("��������ڲ��Ϸ���������1-31֮������ڣ�");
								dateStr = input.nextInt();
							}
							dates[i] = dateStr;//��¼�������
							status[i] = 1;//�޸Ľ���״̬
							System.out.println("�����"+wantBook+"���ɹ�");
							counts[i]++;//�ۼӸ���Ľ������
							break;//����forѭ��
						}
						//������Ϊ�� && �ҵ���ƥ������� && �� �ѽ������ʾ���ѽ�������ʧ��
						else if(bookNames[i]!=null&&wantBook.equals(bookNames[i])
								&&status[i]==1){
							wantFlag = true;
							System.out.println("���ѽ�������ʧ��");
							break;
						}
					}
					if(!wantFlag){//δ�ҵ���Ӧ��ͼ��
						System.out.println("���鲻���ڣ�");
					}
					
					break;
				case 5:
					System.out.println("����黹ͼ�鹦��");// ����黹ͼ�鹦��
					System.out.println("������黹��ͼ�����ƣ�");//����黹��ͼ������
					String reName = input.next();
					boolean reFlag = false;//�Ƿ��ж�Ӧ��ͼ����Ϣ��Ĭ���鲻����
					for(int i = 0;i<bookNames.length;i++){//ѭ�������������飬�ҵ���Ӧ���鼮
						if(bookNames[i]!=null&&reName.equals(bookNames[i])
								&&status[i]==1){//�ҵ�ƥ����飬�������ѽ��״̬������Թ黹
							System.out.println("������黹���ڣ�");
							int reDate = input.nextInt();
							while(reDate <dates[i]||reDate>31){
								System.out.println("����С�ڽ�����ڣ��Ҳ��ܴ���31�����������룺");
								reDate = input.nextInt();
							}
							double money = (reDate - dates[i])*price;//������
							status[i] = 0;
							dates[i] = 0;
							System.out.println("�黹��"+reName+"���ɹ�");
							System.out.println("�������Ϊ��"+dates[i]);
							System.out.println("�黹����Ϊ��"+reDate);
							System.out.println("���Ϊ��"+money);
							reFlag = true;
							break;
						}
						else if(bookNames[i]!=null&&reName.equals(bookNames[i])
								&&status[i]==0){
							System.out.println("��δ���������黹");
							reFlag = true;
							break;
						}
					}
					
					if(!reFlag){//δ�ҵ���Ӧ������
						System.out.println("δ�ҵ���Ӧ�������������˻�");
					}
					break;
				case 6:// �˳���ϵͳ
					flag = false;
					break;
				default:// �쳣��ѡ������ѭ��
					System.out.println("û�д˹�����");
					break;
			}
// �ж��Ƿ񷵻ع��ܲ˵�
			if (flag) {
				System.out.println("�Ƿ񷵻ع��ܲ˵�����������0���أ�");
				num = input.nextInt();
			} else {
				 break;// ����ѭ����ֱ���˳�ϵͳ
			}
		}while(num==0);//����ѭ��ϵͳ
		System.out.println("*********�˳�ϵͳ��ллʹ�ã�***********");
		
	}

}
