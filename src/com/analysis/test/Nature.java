package com.analysis.test;

import java.util.Arrays;
import java.util.List;

import org.ansj.domain.Term;
import org.ansj.recognition.NatureRecognition;
import org.ansj.splitWord.analysis.BaseAnalysis;
import org.ansj.splitWord.analysis.IndexAnalysis;
import org.ansj.splitWord.analysis.NlpAnalysis;
import org.ansj.splitWord.analysis.ToAnalysis;


public class Nature {
	public static void main(String[] args)
	{
/*		String[] strs = {"对", "非", "ansj", "的", "分词", "结果", "进行", "词性", "标注"} ;
        List<String> lists = Arrays.asList(strs) ;
        List<Term> recognition = NatureRecognition.recognition(lists, 0) ;
        System.out.println(recognition);*/
		
		//String str= "洁面仪配合洁面深层清洁毛孔 清洁鼻孔面膜碎觉使劲挤才能出一点点皱纹 脸颊毛孔修复的看不见啦 草莓鼻历史遗留问题没辙 脸和脖子差不多颜色的皮肤才是健康的 长期使用安全健康的比同龄人显小五到十岁 28岁的妹子看看你们的鱼尾纹";
	    //String str ="大家好，我是来自北京的王小明，今年25岁，我学的是电子商务专业。请大家多指导指导。";
		//String str ="大家好，我是来自北京的王小明，今年25岁。";
		String str = "我是中国人.";
		
		//基本分词-BaseAnalysis		
/*	    List<Term> parse = BaseAnalysis.parse(str);
	    System.out.println(parse);*/
		
		//精准分词-ToAnalysis
		List<Term> parse = ToAnalysis.parse(str);
	    System.out.println(parse);

		//nlp分词-NlpAnalysis 精准分词
		/* List<Term> parse = NlpAnalysis.parse(str);
		 System.out.println(parse);*/
		
		//面向索引的分词-IndexAnalysis
/*		List<Term> parse = IndexAnalysis.parse("主副食品");
	    System.out.println(parse);*/
		
	}

}
