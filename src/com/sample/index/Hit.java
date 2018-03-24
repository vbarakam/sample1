package com.sample.index;

import com.sample.document.Document;

public class Hit implements Comparable<Hit> {

	private Document document;
	private float score;

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	@Override
	public int compareTo(Hit hit) {
		if (hit.score == this.score) {
			return 0;
		} else if (this.score > hit.score) {
			return 1;
		} else {
			return -1;
		}
	}
}
