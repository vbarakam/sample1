package com.sample.search;

import java.util.TreeSet;

import com.sample.document.Document;
import com.sample.index.Hit;

public interface SearchService {
	
	TreeSet<Hit> search(String query);

	void index(Document doc);
}
