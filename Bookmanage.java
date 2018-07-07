package cn.kgc;

import java.util.Scanner;

public class Bookmanage {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
//声明四个数组，书名，借出状态，借出日期，借出次数。数组长度为6，储存6本书的信息！
		String[] bookNames = new String[6];//存储书名的数组
		int[] status = new int[6];//存储借出状态的数组，status[i]为0：可借阅，为1：已借出
		int[] dates = new int[6];//借出日期
		int[] counts = new int[6];//借出次数
		double price=0.5;//借书租金每天0.5元
//初始化3本书的信息
		bookNames[0] = "《艰 难 一 日》";//书本名称"艰难一日”。
		status[0] = 1;//为1，标志书已经借出
		dates[0] = 1;//本月，一号借出
		counts[0] = 10;//共借出15次
		
		bookNames[1] = "《java基础》";//书本名称"java基础”。
		status[1] = 0;//为0，标志书未借出
		counts[1] = 15;//共借出15次
		
		bookNames[2] = "《    人   性     》";//书本名称"人性”。
		status[2] = 0;//为0，标志书未借出
		counts[2] = 20;//共借出15次
		
// 2.do...while循环 输出系统功能，其中定义标识flag，为true时继续选择功能，输入0时，while条件(num==0)返回打印菜单 ，false为时，退出系统，提示谢谢使用
		boolean flag=true;//标识flag,继续循环
		int num=-1;//当num==0返回循环功能系统
		do{
//显示工能菜单：
			System.out.println("**********欢迎使用迷你图书管理系统**********");
			System.out.println("1.新增图书");
			System.out.println("2.查看图书");
			System.out.println("3.删除图书");
			System.out.println("4.借出图书");
			System.out.println("5.归还图书");
			System.out.println("6.退出系统");
			System.out.println("**************请熟记功能序号************");
			System.out.println("请选择功能：");
			int choose = input.nextInt();// 记录选择的功能序号
			
			switch(choose){
				case 1:
					System.out.println("进入新增图书功能");// 进入新增图书功能
					System.out.println("输入新增图书的名称：");// 记录要新增的图书名称
					String name=input.next();
					// 判断是否可以添加成功，默认不成功，如果不成功，则提示货架已满
					boolean addFlag=false;
					for(int i=0;i<bookNames.length;i++){// 循环遍历图书名称数组，找到第一个空位，存储新书
						if(bookNames[i]==null){
							bookNames[i]=name;// 找到了一个没有书名的空位，则把新书添加到该位置
							addFlag=true;//添加成功，标识符为true
							break;// 添加成功就跳出，不再找空位
						}
					}
					if(!addFlag){//没找到空位
						System.out.println("书架已满，添加图书失败");
					}
					break;
				case 2:
					System.out.println("进入查看图书功能");// 进入查看图书功能
					System.out.println("序号\t图书名称\t\t\t借阅状态\t借出日期\t借出次数");
					for (int i=0; i<bookNames.length;i++) {//遍历图书名称数组
						if (bookNames[i]!=null) {// 如果书名不为空，则显示书本信息
							// 判断状态是0还是1
							String statusStr=(status[i]==0) ? "可借阅" : "已借出";
							// 如果借出日期为0，则表示没有借出，否则提示借出时间为 X日
							String dateStr =(dates[i]==0)?" ":dates[i]+"日";
							//输出书本信息
							System.out.println((i+1)+"\t"+bookNames[i]+"\t\t"+ statusStr + "\t" + dateStr + "\t"+ counts[i]);
						}
					}
					break;
				case 3:
					System.out.println("进入删除图书功能");// 进入删除图书功能
					boolean delFlag = false;//找到要删除的书，默认找不到delFlag = false;
					int index = -1;//没有找到图书时，下标为-1，否则为要删除下标对应的图书
					System.out.println("请输入您要删除的书本序号：");
					int number= input.nextInt();//记录要删除的图书名称
					for(int i=0;i<bookNames.length;i++){
						if(number>6||number<1){
							System.out.println("书本序号输入有误，请重新输入1~6:");
							number= input.nextInt();
						}
						//如果图书名称不为空  && 状态为可借阅，则提示删除成功
						if(bookNames[number-1]!=null && status[number-1]==0){
							System.out.println("删除成功");
							index = number-1;//把要删除的图书下标赋值给index，该下标之后的图书要前移
							delFlag = true;
							break;//跳出循环
						}
						//如果图书名称不为空  && 状态为已借出，则提示无法删除，图书尚未归还
						else if(bookNames[number-1]!=null && status[number-1]==1){
							System.out.println("删除失败，图书尚未归还");
							delFlag = true;
							break;
						}
					}
					if(index!=-1){//表示找到了的图书，删除图书后，后面的图书前移
						for(int j=index;j<bookNames.length;j++){
							if(j!=bookNames.length-1){//删除的不是最后一位，则前移
								bookNames[j] = bookNames[j+1];
								status[j] = status[j+1];
								dates[j] = dates[j+1];
								counts[j] = counts[j+1];
							}
						}
						//不管删除的是第几号图书，都要把最后一本书置空
						bookNames[bookNames.length-1] = null;
						status[bookNames.length-1] = 0;
						dates[bookNames.length-1] = 0;
						counts[bookNames.length-1] = 0;
					}
					
					if(!delFlag){//没有找到图书
						System.out.println("没有找到匹配的图书！");
					}
					break;
				case 4:
					System.out.println("进入借出图书功能");// 进入借出图书功能
					boolean wantFlag = false;//先找到要借的书名，默认要借的书不存在
					System.out.println("请输入要借的书名：");//记录要借出的书名
					String wantBook=input.next();//键入书名
					for(int i=0;i<bookNames.length;i++){
						//书名不为空 && 找到了匹配的书名 && 书处于 可借阅状态，
						if(bookNames[i]!=null&&wantBook.equals(bookNames[i])&&status[i]==0){
							wantFlag = true;//标志可以借阅
							System.out.println("请输入借出日期：");
							int dateStr = input.nextInt();//修改借出日期
							while(dateStr < 1 || dateStr > 31){
								System.out.println("输入的日期不合法，请输入1-31之间的日期：");
								dateStr = input.nextInt();
							}
							dates[i] = dateStr;//记录借出日期
							status[i] = 1;//修改借阅状态
							System.out.println("借出《"+wantBook+"》成功");
							counts[i]++;//累加该书的借出次数
							break;//跳出for循环
						}
						//书名不为空 && 找到了匹配的书名 && 书 已借出，提示书已借出，借出失败
						else if(bookNames[i]!=null&&wantBook.equals(bookNames[i])
								&&status[i]==1){
							wantFlag = true;
							System.out.println("书已借出，借出失败");
							break;
						}
					}
					if(!wantFlag){//未找到相应的图书
						System.out.println("该书不存在！");
					}
					
					break;
				case 5:
					System.out.println("进入归还图书功能");// 进入归还图书功能
					System.out.println("请输入归还的图书名称：");//输入归还的图书名称
					String reName = input.next();
					boolean reFlag = false;//是否有对应的图书信息，默认书不存在
					for(int i = 0;i<bookNames.length;i++){//循环遍历书名数组，找到相应的书籍
						if(bookNames[i]!=null&&reName.equals(bookNames[i])
								&&status[i]==1){//找到匹配的书，且属于已借出状态，则可以归还
							System.out.println("请输入归还日期：");
							int reDate = input.nextInt();
							while(reDate <dates[i]||reDate>31){
								System.out.println("不能小于借出日期，且不能大于31，请重新输入：");
								reDate = input.nextInt();
							}
							double money = (reDate - dates[i])*price;//算出租金
							status[i] = 0;
							dates[i] = 0;
							System.out.println("归还《"+reName+"》成功");
							System.out.println("借出日期为："+dates[i]);
							System.out.println("归还日期为："+reDate);
							System.out.println("租金为："+money);
							reFlag = true;
							break;
						}
						else if(bookNames[i]!=null&&reName.equals(bookNames[i])
								&&status[i]==0){
							System.out.println("书未借出，无需归还");
							reFlag = true;
							break;
						}
					}
					
					if(!reFlag){//未找到相应的书名
						System.out.println("未找到相应的书名，无需退还");
					}
					break;
				case 6:// 退出该系统
					flag = false;
					break;
				default:// 异常的选择，跳出循环
					System.out.println("没有此功能项");
					break;
			}
// 判断是否返回功能菜单
			if (flag) {
				System.out.println("是否返回功能菜单，是请输入0返回：");
				num = input.nextInt();
			} else {
				 break;// 跳出循环，直接退出系统
			}
		}while(num==0);//返回循环系统
		System.out.println("*********退出系统，谢谢使用！***********");
		
	}

}
