package com.songhongkang;

public class FamliyAccount {
    public static void main(String[] args) {

        //记录收入支出详情
        String details = "收支\t账户金额\t收支金额\t说    明\n";
        //初始金额
        int balance = 10000;

        while(true){
            System.out.println("\n-----------------家庭收支记账软件-----------------\n");
            System.out.println("                   1 收支明细");
            System.out.println("                   2 登记收入");
            System.out.println("                   3 登记支出");
            System.out.println("                   4 退    出\n");
            System.out.print("                   请选择(1-4)：");

            char key = Utility.readMenuSelection();
            System.out.println();
            switch(key){
                case '1':
                    //System.out.println("1:收支明细");
                    System.out.println("-----------------当前收支明细记录-----------------");
                    System.out.println(details);
                    System.out.println("--------------------------------------------------");
                    break;
                case '2':
                    //System.out.println("2:登记收入");
                    System.out.print("本次收入金额：");
                    int amount1 = Utility.readNumber();
                    System.out.print("本次收入说明：");
                    String desc1 = Utility.readString();

                    //处理金额
                    balance += amount1;

                    //处理details
                    details += ("收入\t" + balance + "\t" + amount1 + "\t\t" + desc1 + "\n");

                    System.out.println("---------------------登记完成---------------------");
                    break;
                case '3':
                    //System.out.println("3:登记支出");
                    System.out.print("本次支出金额：");
                    amount1 = Utility.readNumber();
                    System.out.print("本次支出说明：");
                    desc1 = Utility.readString();

                    //处理balance
                    if(balance > amount1){
                        balance -= amount1;
                        details += ("支出\t" + balance + "\t" + amount1 + "\t\t" + desc1 + "\n");
                    }else{
                        System.out.println("超出支出额度，支付失败！");
                    }
                    System.out.println("---------------------登记完成---------------------");
                    break;
                case '4':
                    //System.out.println("4:退出");
                    //break;
                    System.out.print("确认是否退出(Y/N)：");
                    char yn = Utility.readConfirmSelection();
                    if(yn == 'Y') break;
            }
        }

    }
}
