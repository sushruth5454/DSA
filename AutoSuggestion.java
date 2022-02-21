import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
//import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

class  Trie{
    HashMap<Character,Trie> trieMap;
    boolean isEnd;
    Trie(){
        this.isEnd=false;
        this.trieMap=new HashMap<>();
    }
}
public class AutoSuggestion {
    private static int flag;
    //int flag=0;
    public  static  void printTrie(Trie root,String str){
        //System.out.println("loop");
        if(root.isEnd) {
            System.out.println(str);
            //return;
        }
        Set<Character>s=root.trieMap.keySet();
        for(char key:s){
            //System.out.println("loop");
            //System.out.print(key+"-->");
            printTrie(root.trieMap.get(key),str+new String(String.valueOf(key)));
        }
    }
    public static void insert(Trie curr, String str, int index) {
        if (index == str.length()) {
            curr.isEnd = true;
            return;
        }
        char ch = str.charAt(index);
        /*if(flag==0){
            Trie child=new Trie();
            curr.trieMap.put(ch,child);
            curr=curr.trieMap.get(ch);
            flag=1;
            insert(curr,str,index+1);
        }
        else{*/
        if (!curr.trieMap.containsKey(ch)) {
            Trie child = new Trie();
            curr.trieMap.put(ch, child);
        }
        curr=curr.trieMap.get(ch);
        insert(curr,str,index+1);
    }
    public static void getLocationOfString(Trie root,String str,int index){
        if(str.length()==index){
            //System.out.println(root.isEnd);
            autoSuggestion(root,str,str);
            return;
        }
        char ch=str.charAt(index);
        if(root.trieMap.containsKey(ch)) {
            //System.out.println("loop  " + ch);
            root = root.trieMap.get(ch);
            getLocationOfString(root, str, index + 1);
        }
    }
    public static void autoSuggestion(Trie root,String word,String str){
        //System.out.println("auto");
            //System.out.println("string "+str);
        if(root.isEnd)
            System.out.println(str);
        Set<Character> s=root.trieMap.keySet();
        for(char ch:s){
            //System.out.println(ch);
            autoSuggestion(root.trieMap.get(ch),word,str+ new String(String.valueOf(ch)));
            }
    }

    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String temp= sc.nextLine();
        //ArrayList<String> dict=new ArrayList<>();
        String []dict=new String[n];
        for(int i=0;i<n;i++) {
            dict[i] = sc.nextLine();
        }
        System.out.println(dict.length);
        for(int i=0;i<n;i++) {
            System.out.println(dict[i]);
        }
        Trie root=new Trie();
        //Trie curr=root;
        System.out.println("ENter the prefix to search");
        String word=sc.nextLine();
        for(int i=0;i<n;i++){
            insert(root,dict[i],0);
        }
        /*for(char k:root.trieMap.keySet()){
            System.out.println(k);
        }*/
        //printTrie(root,"");
        getLocationOfString(root,word,0);
        //autoSuggestion(start,word);
        return;
    }
}
