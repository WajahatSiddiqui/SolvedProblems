package com.wajahat.unionfind;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class UnionFindTest {
    
    private UnionFind uf;
    
    public UnionFindTest() {
        uf = new UnionFind(10);
        uf.union(1, 3);
        uf.union(5, 6);
        uf.union(7, 8);
        uf.union(3, 6);
        uf.union(7, 9);
    }

    @Test
    public void testFind() {
        assertTrue(uf.find(1, 3));
        assertTrue(!uf.find(0,  9));
    }

    @Test
    public void testUnion() {
        uf.union(0, 9);
        assertTrue(uf.find(0, 9));
        System.out.println("testUnion : " + uf);
    }
    
    @Test
    public void testToString() {
        System.out.println("testToString : " + uf);
    }

}
