package com.designpatterns.webserverapp.template;

class A {
    private int x ; // 4 bytes
    public void F3() {
        System.out.println ( "A-F3" );
    }
    public void F1(/* this = ref. of object */) {
        this.x = 100 ;
        F3(); // this.F3() ;
    }
}

class B extends A {
    private int y ; // 4 bytes
    public void F2(/* this = ref. of object */) {
        this.y = 200 ;
        super.F1() ; // super.F1 ( value of this ) ;
    }
    public void F3() {
        System.out.println ( "B-F3" );
    }
}


class App11 {

    public static void main ( String[] args ) {
         A a1 = new A() ; // 4 bytes
         a1.F1();

        B b1 = new B() ; // 8 bytes
        b1.F1();
        b1.F2(); // F2 ( value of b1 = ref. of B's object ) ;
    }

}
