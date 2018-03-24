package com.sample.search;

import java.util.TreeSet;

import com.sample.document.Document;
import com.sample.index.Hit;
import com.sample.index.Index;

public class SearchServiceImpl implements SearchService {

	private Index index;
	
	public SearchServiceImpl() {
		index = new Index();
	}
	
	@Override
	public TreeSet<Hit> search(String query) {
		
		return null;
	}

	@Override
	public void index(Document doc) {
		index.index(doc);
	}

}
