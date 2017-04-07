package com.company;


public class Main {
    final static Object o1 = new Object(), o2 = new Object();

    public static void main(String[] args) {
	    Thread t1 = new Thread() {
	        public void run() {
                synchronized(o2) {
                    while (true) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("t1 work");
                        synchronized(o1) {
                            System.out.println("t1");
                        }
                    }
                }
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                synchronized(o1) {
                    while (true) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("t2 work");
                        synchronized(o2) {
                            System.out.println("t2");
                        }
                    }
                }
            }
        };

        t1.start();
        t2.start();
    }
}
