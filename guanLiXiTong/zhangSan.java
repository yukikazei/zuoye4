package guanLiXiTong;

class zhangSan implements xueShengJieKou,jiaoShiJieKou{
    @Override
    public void jiaoNaXueFei(int xf) {
        System.out.print(xf);
    }
    @Override
    public void faFangXinShui(int xs){
        System.out.print(xs);
    }
}