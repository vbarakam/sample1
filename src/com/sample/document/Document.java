package com.sample.document;

public class Document {
	private long documentId;
	private String title;

	public Document(long id, String title) {
		this.documentId = id;
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getDocumentId() {
		return documentId;
	}

	public void setDocumentId(long documentId) {
		this.documentId = documentId;
	}
}
