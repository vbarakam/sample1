package com.sample.index;

import java.util.List;
import java.util.Set;

import com.sample.document.Document;
import com.sample.document.Term;
import com.sample.parse.Parser;
import com.sample.parse.TextParser;

public class Index {
	private PostingDictionary postings;
	
	public Index() {
		postings = new PostingDictionary();
	}
	public void index(Document doc) {
		Parser parser = new TextParser();
		Set<Term> terms = parser.parse(doc.getTitle());
	}
	
	public List<Posting> getPosting(Term term) {
		return null;
	}
}
