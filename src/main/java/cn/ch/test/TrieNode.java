package cn.ch.test;

/**
 * @Classname TrieNode
 * @Description
 * @create 2021/2/26
 * @Author random
 */
public class TrieNode {

    int frequency;
    TrieNode[] child;

    public TrieNode() {
        frequency = 0;
        child = new TrieNode[26];
    }
}
