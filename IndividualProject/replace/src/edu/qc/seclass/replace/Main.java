package edu.qc.seclass.replace;

public class Main {

    public static void main(String[] args) {

        try {
            Replace replace = new Replace(args);
            replace.replace();
        }catch(Exception e){
            usage();
        }
    }
    private static void usage() {
        System.err.println("Usage: Replace [-b] [-f] [-l] [-i] <from> <to> -- " + "<filename> [<filename>]*");
    }
}
