package com.sample.parse;

import java.util.Set;

import com.sample.document.Term;

public interface Parser {
	Set<Term> parse(String str); 
}
