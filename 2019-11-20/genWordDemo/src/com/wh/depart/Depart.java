package com.wh.depart;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.rtf.RtfWriter2;
import com.sun.org.apache.regexp.internal.RE;
import com.wh.entity.ReportEntity;
import com.wh.templete.WordTemplete;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.UUID;


/**
 * Created by chenf on 2019/11/18.
 */
public class Depart  extends WordTemplete{



    private Document document;
    private BaseFont bfChinese;
    private  static int fontSize=9;
    private  static String fileName="";
    private static  String [] sourcePath=new String[11];

    private  static ReportEntity reportEntity=new ReportEntity();

    public BaseFont getBfChinese() {
        return bfChinese;
    }

    public void setBfChinese(BaseFont bfChinese) {
        this.bfChinese = bfChinese;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Depart(){
        this.document = new Document(PageSize.A4);

    }

    public static String genDepartReport(String[]pngArray,ReportEntity reportEntity) throws DocumentException, IOException{

        //if(pngArray.length!=11) return "";
        Depart wt = new Depart();
        fileName="d:\\dome_depart_"+ UUID.randomUUID().toString()+".doc";
        wt.openDocument(fileName);
        wt.insertTitle("分行业绩指数报告(分行版)", fontSize, Font.BOLD, Element.ALIGN_CENTER);

        wt.insertContext("中国建设银行"+reportEntity.getYear()+"年度业绩总收入为("+reportEntity.getYearIncomeAll()+")，同期增长("+reportEntity.getIncrease()*100+")%，各项收入来源如下：\n", fontSize, Font.NORMAL, Element.ALIGN_LEFT);
        wt.insertContext("年度各分行托管费收入前五后五为：\n", fontSize, Font.NORMAL, Element.ALIGN_LEFT);
        wt.insertImg(pngArray[0], Image.ALIGN_CENTER, 12, 35, 50, 50, 50, 30);
        wt.insertContext("年度各分行银行费收入前五后五为：\n", fontSize, Font.NORMAL, Element.ALIGN_LEFT);
        wt.insertImg(pngArray[1], Image.ALIGN_CENTER, 12, 35, 50, 50, 50, 30);
        wt.insertContext("年度各分行资金沉淀收入收入前五后五为：\n", fontSize, Font.NORMAL, Element.ALIGN_LEFT);
        wt.insertImg(pngArray[2], Image.ALIGN_CENTER, 12, 35, 50, 50, 50, 30);


        wt.insertContext(reportEntity.getProvince()+"省分行"+reportEntity.getYear()+"年度业绩指数为（"+reportEntity.getPerforLevel()+"），打败了行内（"+reportEntity.getRivalAllRate()*100+"）%的对手。今年"+reportEntity.getBranchBank()+"分行的业绩收入为（"+reportEntity.getIncomePart()+"），占建行总体收入（"+ reportEntity.getIncomeRate()*100+"）%，打败了行内（"+reportEntity.getRivalPartRate()*100+"）%的对手。年度托管费用（"+reportEntity.getYearColloPrice()+"），打败了行内（"+reportEntity.getRivalColloRate()*100+"）%的对手；年度银行费收入（"+reportEntity.getYearBankPrice()+"），打败了行内（"+reportEntity.getRivalBankRate()*100+"）%的对手；年度资金沉淀收入（"+reportEntity.getYearCapCediPrice()+"），打败了行内（"+reportEntity.getRivalCapCediRate()*100+"）%的对手。\n", fontSize, Font.NORMAL, Element.ALIGN_LEFT);

        wt.insertContext("月度明细如下：\n", fontSize, Font.NORMAL, Element.ALIGN_LEFT);
        wt.insertImg(pngArray[3], Image.ALIGN_CENTER, 12, 35, 50, 50, 50, 30);

        wt.insertContext("<"+reportEntity.getBranchBank()+"分行托管费用收入月度情况分析>\n", fontSize, Font.NORMAL, Element.ALIGN_LEFT);
        wt.insertImg(pngArray[4], Image.ALIGN_CENTER, 12, 35, 50, 50, 50, 30);

        wt.insertContext("<"+reportEntity.getBranchBank()+"分行银行费用收入月度情况分析>\n", fontSize, Font.NORMAL, Element.ALIGN_LEFT);
        wt.insertImg(pngArray[5], Image.ALIGN_CENTER, 12, 35, 50, 50, 50, 30);

        wt.insertContext("<"+reportEntity.getBranchBank()+"分行资金沉淀收入月度情况分析>\n", fontSize, Font.NORMAL, Element.ALIGN_LEFT);
        wt.insertImg(pngArray[6], Image.ALIGN_CENTER, 12, 35, 50, 50, 50, 30);

        wt.insertContext("<"+reportEntity.getBranchBank()+"分行客户数月度情况分析>\n", fontSize, Font.NORMAL, Element.ALIGN_LEFT);
        wt.insertImg(pngArray[7], Image.ALIGN_CENTER, 12, 35, 50, 50, 50, 30);

        wt.insertContext("<"+reportEntity.getBranchBank()+"分行产品数量月度情况分析>\n", fontSize, Font.NORMAL, Element.ALIGN_LEFT);
        wt.insertImg(pngArray[8], Image.ALIGN_CENTER, 12, 35, 50, 50, 50, 30);


        wt.insertContext("<"+reportEntity.getBranchBank()+"分行资产规模月度情况分析>\n", fontSize, Font.NORMAL, Element.ALIGN_LEFT);
        wt.insertImg(pngArray[9], Image.ALIGN_CENTER, 12, 35, 50, 50, 50, 30);

        wt.insertContext("<"+reportEntity.getBranchBank()+"分行资源投入月度情况分析>\n", fontSize, Font.NORMAL, Element.ALIGN_LEFT);
        wt.insertImg(pngArray[10], Image.ALIGN_CENTER, 12, 35, 50, 50, 50, 30);

        wt.insertContext("<"+reportEntity.getBranchBank()+"分行资产组合财务净值月度情况分析>\n", fontSize, Font.NORMAL, Element.ALIGN_LEFT);

        wt.insertContext("至"+reportEntity.getYear()+"年底，服务客户数（"+reportEntity.getCustomerNum()+"），打败了行内（"+reportEntity.getRivalCustomerRate()*100+"）%的对手；托管资产规模（"+reportEntity.getNetAssetSize()+"），打败了行内（"+reportEntity.getRivalNetAssetSizeRate()*100+"）%的对手；托管产品数（"+reportEntity.getColloProduceNum()+"），打败了行内（"+reportEntity.getRivalColloProductRate()*100+"）%的对手；分行资源投入（"+reportEntity.getBranchResourceInput()+"），打败了行内（"+reportEntity.getRivalbranchResInputRate()*100+"）%的对手。\n", fontSize, Font.NORMAL, Element.ALIGN_LEFT);

        wt.insertContext("总结&建议：\n", fontSize, Font.NORMAL, Element.ALIGN_LEFT);


        wt.insertContext("分行业绩指标计算规则为：100*托管费用收入排名百分比+100*银行费用收入排名百分比+100*资金沉淀收益排名百分比+100*客户数量排名百分比+100*产品数量排名百分比+100*资产规模排名百分比+100*建行规模占比排名百分比+100*分行资源投入排名百分比\n", fontSize, Font.NORMAL, Element.ALIGN_LEFT);

//        wt.insertRiskTable();
//        wt.insertRiskEvaluationTable();
//        wt.insertRiskControlTable();
        wt.closeDocument();
        return  fileName;
    }


    public static void main(String[] args) throws DocumentException, IOException {

        for (int i = 0; i < 11; i++) {
            sourcePath[i]="earth.png";
        }
        System.out.println(genDepartReport(sourcePath,reportEntity));
    }

}
