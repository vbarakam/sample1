package com.sample.index;

public class Posting {
	private long documentId;
	private int frequency;

	public Posting(long documentId, int freq) {
		this.documentId = documentId;
		this.frequency = freq;
	}

	public long getDocumentId() {
		return documentId;
	}

	public void setDocumentId(long documentId) {
		this.documentId = documentId;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
}
