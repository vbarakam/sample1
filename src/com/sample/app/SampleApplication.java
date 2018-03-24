package com.sample.app;

import com.sample.document.Document;
import com.sample.search.SearchService;
import com.sample.search.SearchServiceImpl;

public class SampleApplication {
	public static void main(String args[]) {
		int[] histogram = new int[(int) Math.pow(2, 30)];
		int data[] = {1,2,3,4,3,2,1,2,3,4,3,2,1};
		int V = 10;
		int K =	2;
		pourWater(data, V, K);
		for (int num : data) {
			System.out.print(num + " ");
		}
		//[4,4,4,4,3,3,3,3,3,4,3,2,1]
		SearchService searchService = new SearchServiceImpl();
		System.out.print(Long.lowestOneBit(2L));
		Document doc1 = new Document(100, "uber search sample");
		Document doc2 = new Document(100, "uberx carpoll expresspoll");
		Document doc3 = new Document(100, "uber");
		Document doc4 = new Document(100, "sample code");
		
		searchService.index(doc1);
		searchService.index(doc2);
		searchService.index(doc3);
		searchService.index(doc4);
		
		System.out.println(searchService.search("uber"));
	}
	
    public static int[] pourWater(int[] heights, int V, int K) {
        while (V > 0) {               
            // check left
            int minIndex = K;
            for (int index = K-1; index >= 0; index--) {
                if (heights[index] > heights[minIndex]) {
                    break;
                } else if (heights[index] < heights[minIndex]) {
                	minIndex = index;
                }
            }
            if ( minIndex != K) {
                heights[minIndex]++;
                V--;
                continue;
            }
            minIndex = K;
            for (int index = K+1; index < heights.length; index++) {
                 if (heights[index] > heights[minIndex]) {
                    break;
                } else if (heights[index] < heights[minIndex]) {
                	minIndex = index;
                }
            }
            if (minIndex != K) {
                heights[minIndex]++;
                V--;
                continue;
            }
            
            // add at V
            heights[K]++;
            V--;
        }
        return heights;
    }
}
