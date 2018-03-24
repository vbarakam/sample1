package com.yahoo.util;

import java.util.*;

public class FileSystem {
    private Dir root;
    
    public FileSystem() {
        root = new Dir();    
    }
    
    public static void main(String args[]){
    	//["FileSystem","mkdir","ls","ls","mkdir","ls","ls","addContentToFile","ls","ls","ls"]
    	//[[],["/goowmfn"],["/goowmfn"],["/"],["/z"],["/"],["/"],["/goowmfn/c","shetopcy"],["/z"],["/goowmfn/c"],["/goowmfn"]]
    	FileSystem fs = new FileSystem();
    	fs.mkdir("/goowmfn");
    	fs.ls("/goowmfn");
    	fs.ls("/");
    	fs.mkdir("/z");
    	fs.ls("/");
    	fs.ls("/");
    	fs.addContentToFile("/goowmfn/c","shetopcy");
    	fs.ls("/z");
    	fs.ls("/goowmfn/c");
    	fs.ls("/goowmfn");
    	System.out.println("end");
    }
    
    public List<String> ls(String path) {
        if (path.equals("/")) {
            return results(root);
        }
        String splits[] = path.split("/");
        Dir node = root;
        for (int i = 1; i < splits.length; i++) {
            node = node.dirs.get(splits[i]);
        }
        return results(node);
    }
    
    private List<String> results(Dir root) {
        List<String> results = new ArrayList<>();
        results.addAll(root.dirs.keySet());
        results.addAll(root.files.keySet());
        Collections.sort(results);
        return results;
    }
    
    public void mkdir(String path) {
        String splits[] = path.split("/");
        Dir node = root;
        for (int i = 1; i < splits.length; i++) {
            Dir temp = node.dirs.get(splits[i]);
            if (temp == null) {
                node.dirs.put(splits[i], new Dir());
            }
            node = node.dirs.get(splits[i]);
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        String splits[] = filePath.split("/");
        Dir node = root;
        for (int i = 1; i < splits.length-1; i++) {
            Dir temp = node.dirs.get(splits[i]);
            if (temp == null) {
                node.dirs.put(splits[i], new Dir());
            }
            node = node.dirs.get(splits[i]);
        }
        node.files.put(splits[splits.length-1], content);
    }
    
    public String readContentFromFile(String filePath) {
         String splits[] = filePath.split("/");
        Dir node = root;
        for (int i = 1; i < splits.length-1; i++) {
            Dir temp = node.dirs.get(splits[i]);
            if (temp == null) {
                node.dirs.put(splits[i], new Dir());
            }
            node = node.dirs.get(splits[i]);
        }
        return node.files.get(splits[splits.length-1]);
    }
}

class Dir {
    Map<String, Dir> dirs;
    Map<String, String> files;
    
    public Dir() {
        dirs = new HashMap<>();
        files = new HashMap<>();
    }
}
