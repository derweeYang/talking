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
/*		String[] strs = {"��", "��", "ansj", "��", "�ִ�", "���", "����", "����", "��ע"} ;
        List<String> lists = Arrays.asList(strs) ;
        List<Term> recognition = NatureRecognition.recognition(lists, 0) ;
        System.out.println(recognition);*/
		
		//String str= "��������Ͻ���������ë�� ���ǿ���Ĥ���ʹ�������ܳ�һ������� ����ë���޸��Ŀ������� ��ݮ����ʷ��������û�� ���Ͳ��Ӳ����ɫ��Ƥ�����ǽ����� ����ʹ�ð�ȫ�����ı�ͬ������С�嵽ʮ�� 28������ӿ������ǵ���β��";
	    //String str ="��Һã��������Ա�������С��������25�꣬��ѧ���ǵ�������רҵ�����Ҷ�ָ��ָ����";
		//String str ="��Һã��������Ա�������С��������25�ꡣ";
		String str = "�����й���.";
		
		//�����ִ�-BaseAnalysis		
/*	    List<Term> parse = BaseAnalysis.parse(str);
	    System.out.println(parse);*/
		
		//��׼�ִ�-ToAnalysis
		List<Term> parse = ToAnalysis.parse(str);
	    System.out.println(parse);

		//nlp�ִ�-NlpAnalysis ��׼�ִ�
		/* List<Term> parse = NlpAnalysis.parse(str);
		 System.out.println(parse);*/
		
		//���������ķִ�-IndexAnalysis
/*		List<Term> parse = IndexAnalysis.parse("����ʳƷ");
	    System.out.println(parse);*/
		
	}

}
