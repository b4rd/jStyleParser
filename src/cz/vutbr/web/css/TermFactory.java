package cz.vutbr.web.css;

import cz.vutbr.web.css.TermNumeric.Unit;

public interface TermFactory {

	TermAngle createAngle(Float value);
	TermAngle createAngle(String value, Unit unit, int unary);
	
	TermColor createColor(TermIdent ident);
	TermColor createColor(String hash);
	TermColor createColor(int r, int g, int b);
	TermColor createColor(TermFunction function);
	
	TermFrequency createFrequency(Float value);
	TermFrequency createFrequency(String value, Unit unit, int unary);
	
	TermFunction createFunction();
	
	TermIdent createIdent(String value);
	
	TermInteger createInteger(Integer value);
	TermInteger createInteger(String value, int unary);
	
	TermLength createLength(Float value);
	TermLength createLength(String value, Unit unit, int unary);
	
	TermList createList();
	TermList createList(int initialSize);
	
	TermNumber createNumber(Float value);
	TermNumber createNumber(String value, int unary);
	
	TermNumeric<?> createNumeric(String value, int unary);
	
	TermNumeric<Float> createDimension(String value, int unary);
	
	<K,V> TermPair<K,V> createPair(K key, V value);
	
	TermPercent createPercent(Float value);
	TermPercent createPercent(String value, int unary);
	
	TermString createString(String value);
	
	<V> Term<V> createTerm(V value);
	
	TermTime createTime(Float value);
	TermTime createTime(String value, Unit unit, int unary);
	
	TermURI createURI(String value);
}