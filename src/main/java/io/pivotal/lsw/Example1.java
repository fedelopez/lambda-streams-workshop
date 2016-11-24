package io.pivotal.lsw;

class Example1 {

    static void run(Runnable runnable) {
        new Thread(runnable).start();
    }
}
