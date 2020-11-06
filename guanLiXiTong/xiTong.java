package guanLiXiTong;

import java.util.Scanner;

public class xiTong {
    static int shuiLv = 3000; //税率的静止方法，虽然国家税率是分段的，但咱偷个懒，就搞一个，不嫌麻烦的可以多整几个税率或者搞个税率数组
    public static void main(String[] xitong){
        System.out.println("欢迎进入博士研究生管理系统");
        System.out.println("目前博士研究生有:");
        System.out.println("张三，男，28岁，所交学费（年）:无，所得薪水（年）:无，年应缴纳金额:无");
        System.out.println("李四，女，27岁，所交学费（年）:无，所得薪水（年）:无，年应缴纳金额:无");
        int i,j = 0; //这里提前声明一下循环用的i和j，循环里面声明也无所谓
        while(j == 0){
            //retry: //书签，只能用于for语句（侧面体现了goto编程时的好用与读goto时的蛋疼）
            for(i = 0;i < 1;i++){
                try{
                    System.out.print("请输入张三所交学费（年）:");
                    Scanner  sj = new Scanner(System.in); //输入语句 sj中文为所交的开头字母
                    xueShengJieKou xsjk; //xsjk中文为学生接口，声明一下接口变量
                    xsjk = new zhangSan(); //接口变量中存放对象的引用
                    int XF = sj.nextInt(); //给XF（学费）输入值，之后作为张三的学费参数参与实际输出
                    if(XF <= 0 || XF>1000000){ //怕用户输入不输入，输入负数，输入一百万以上的合法（不报错）骚操作。
                        System.out.println("请输入正整数并且数值不能超过1000000"); //不用throw new BankException()是为了区分对待错误
                        break; //retry; //回到retry:（for前面那个）那里
                    }
                    //接口回调在64、66、76、78行

                    System.out.print("请输入李四所交学费（年）:"); //之后就是相同的结构重复三次，获得XF,XF2,XS,XS2
                    Scanner  sj2 = new Scanner(System.in); //嫌麻烦的话可以搞个一维数组存变量，数组永远滴神
                    xueShengJieKou xsjk2;
                    xsjk2 = new liSi();
                    int XF2 = sj2.nextInt(); //给XF2（学费2）输入值，之后作为李四的学费参数参与实际输出
                    if(XF2 <= 0 || XF2>1000000){
                        System.out.println("请输入正整数并且数值不能超过1000000");
                        break; //retry;
                    }

                    System.out.print("请输入张三所得薪水（年）:");
                    Scanner  sd = new Scanner(System.in); //sd中文为所得
                    jiaoShiJieKou sdxs;
                    sdxs = new zhangSan();
                    int XS = sd.nextInt(); //给XS（薪水）输入值，之后作为张三的薪水参数参与实际输出
                    if(XS <= 0 || XS>1000000){
                        System.out.println("请输入正整数并且数值不能超过1000000");
                        break; //retry;
                    }

                    System.out.print("请输入李四所得薪水（年）:");
                    Scanner  sd2 = new Scanner(System.in);
                    jiaoShiJieKou sdxs2;
                    sdxs2 = new zhangSan();
                    int XS2 = sd2.nextInt(); //给XS2（薪水2）输入值，之后作为李四的薪水参数参与实际输出
                    if(XS2 <= 0 || XS2 > 1000000){
                        System.out.println("请输入正整数并且数值不能超过1000000");
                        break; //retry;
                    }

                    int SHJE = XS - XF; //SHJE中文为所获金额
                    int SHJE2 = XS2 - XF2;
                    int JNJE = 0; //JNJE中文为缴纳金额
                    int JNJE2 = 0;

                    System.out.print("张三，男，28岁，所交学费（年）:");
                    xsjk.jiaoNaXueFei(XF); //接口回调
                    System.out.print("，所得薪水（年）:");
                    sdxs.faFangXinShui(XS); //接口回调+1
                    System.out.print("，年应缴纳金额:");
                    if(SHJE <= shuiLv){
                        System.out.println(JNJE);
                    }else if(SHJE > shuiLv) {
                        JNJE = SHJE/10-210; //个税=所获金额*10%-210（速算扣除数）
                        System.out.println(JNJE);
                    }

                    System.out.print("李四，女，27岁，所交学费（年）:");
                    xsjk2.jiaoNaXueFei(XF2); //接口回调+2
                    System.out.print("，所得薪水（年）:");
                    sdxs2.faFangXinShui(XS2); //接口回调+3
                    System.out.print("，年应缴纳金额:"); //你问我为什么要这么麻烦分段写而不写在一行输出语句里？为了让接口回调有点用。。。。。
                    if(SHJE2 <= shuiLv){
                        System.out.println(JNJE2);
                    }else if(SHJE2 > shuiLv) {
                        JNJE2 = SHJE2/10-210; //个税=所获金额*10%-210（速算扣除数）
                        System.out.println(JNJE2);
                    }
                    j = 1;
                }
                catch(Exception e){ //数字异常，输入定义的是int类型，怕用户输入字符串，数字带小数之类的骚操作。
                    System.out.print("发生错误:");
                    System.out.println(e.getMessage()); //输出获得的错误
                    System.out.println("请输入正整数，谢谢配合");
                }
            }
        }
    }
}