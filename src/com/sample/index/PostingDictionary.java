package com.sample.index;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sample.document.Term;

public class PostingDictionary {
	private Map<String, List<Posting>> postingDictionary;
	
	public PostingDictionary() {
		postingDictionary = new HashMap<>();
	}

	public Map<String, List<Posting>> getPostingDictionary() {
		return postingDictionary;
	}

	public void setPostingDictionary(Map<String, List<Posting>> postingDictionary) {
		this.postingDictionary = postingDictionary;
	}
	
	public void addTerm(long docId, Term term) {
		Posting posting = new Posting();
	}
}
