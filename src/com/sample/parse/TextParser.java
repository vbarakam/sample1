package com.sample.parse;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.sample.document.Term;

public class TextParser implements Parser {

	@Override
	public Set<Term> parse(String str) {
		Set<Term> terms = new HashSet<>();
		String [] splits = str.split(" ");
		for (String split : splits) {
			terms.add(new Term(split));
		}
		return null;
	}

}
