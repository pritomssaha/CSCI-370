package edu.qc.seclass.replace;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class Replace {
    private String[] args;
    private String replaceFrom = "";
    private String replaceTo = "";
    private int counter = 0;

    private boolean bFlag = false;
    private boolean fFlag = false;
    private boolean lFlag = false;
    private boolean iFlag = false;
    private boolean doubleDash=false;

    private List<String> fileList = new LinkedList<String>();
    private List<String> replaceFromList = new LinkedList<String>();
    private List<String> replaceToList = new LinkedList<String>();

    public Replace(String[] args) {
        this.args=args;

    }

    public void replace(){
        /*
         * if the argument is less than 3, then error in the argument and return usage
         * argument should look like
         * "StringFrom" "StringTo" "--" "file1" "file2" without OP option or,
         * "-i" "StringFrom" "StringTo" "--" "file1" "file2" with OP option
         *
         */
        if (args.length < 3) {
            usage();
            return;
        }
        /*
         *
         * iterate through all the argument and flag the OPT option
         *"StringFrom" "StringTo" "--" "file1" "file2"
         * ----------   --------   --   --------------
         * counter->1      2        3        4
         *
         * "-i", "-f" "Howdy", "Hello", "--", inputFile1.getPath(), inputFile2.getPath(), inputFile3.getPath()
         * ---------   -----    -----    --    --------------------------------------------------------------
         * counter->0      1        2       3                    4
         *
         */
        for (int i=0;i< args.length;i++) {

            /*if (!args[i].startsWith("-")) {
                replaceFromList.add(args[i]);
                counter = 2;
                continue;
            }*/

            if(args[i].equals("--"))
                doubleDash=true;

            if (counter == 0) {
                if (!args[i].startsWith("-")) {
                    replaceFromList.add(args[i]);
                    counter+=2;
                    continue;
                }

                //OPT option
                if (args[i].equals("-b")) {
                    bFlag = true;
                    continue;
                }
                else if (args[i].equals("-f")) {
                    fFlag = true;
                    continue;
                }
                else if (args[i].equals("-l")) {
                    lFlag = true;
                    continue;
                }
                else if (args[i].equals("-i")) {
                    iFlag = true;
                    continue;
                }
                //if
                else if (doubleDash) {
                    counter++;
                    continue;
                }
                /*
                 * wrong syntax
                 */
                else if (args[i].startsWith("-")) {
                    if (!args[i].equals("-f")) {
                        usage();
                        break;
                    }
                    else if (!args[i].equals("-l")) {
                        usage();
                        break;
                    }
                    else if (!args[i].equals("-b")) {
                        usage();
                        break;
                    }
                    else if (!args[i].equals("-i")) {
                        usage();
                        break;
                    }

                }


            }

            else if (counter == 1) {
                replaceFromList.add(args[i]);
                counter ++;
                continue;
            }

            else if (counter == 2) {
                replaceToList.add(args[i]);
                counter ++;
                continue;
            }
            else if (counter == 3 && doubleDash) {
                counter ++;
                continue;
            }
            else if (counter == 3 && !doubleDash) {
                //usage();
                replaceFromList.add(args[i]);
                counter = 2;
                continue;
            }
            else if (counter == 4) {
                fileList.add(args[i]);
                continue;
            }
        }
        //If no files provided, return usage()
        if (fileList.isEmpty()) {
            // System.out.print(fileList.size());
            usage();
            return;
        }

        if (replaceFromList.size() == 0 || replaceFromList.size() > 1) {
            //System.out.print(replaceFromList.size());
            usage();
            return;
        }
        if (replaceToList.size() == 0 || replaceToList.size() > 1) {
            //System.err.print(replaceToList.size());
            usage();
            return;
        }

        //
        replaceFrom = replaceFromList.get(0);
        replaceTo = replaceToList.get(0);

        /*
         * empty string cannot be replaced with the replaceTo String
         */
        if (replaceFrom.equals("")) {
            usage();
            return;
        }

        for (int i=0;i<fileList.size();i++) {
            try {
                //if bFlag is true, then create a backup file before replacement
                if (bFlag) {
                    backupfile(fileList.get(i));
                }
                //read the data from the file
                String data = Files.readString(Path.of(fileList.get(i)));

                // if none of first or last flag is on replace every string from replaceFrom to replaceTo string
                if (!fFlag && !lFlag && !iFlag) {
                    data = data.replaceAll( replaceFrom, replaceTo);
                }
                //replace all case insensitive string
                if (!fFlag && !lFlag && iFlag) {
                    data = data.replaceAll("(?i)" + replaceFrom, replaceTo);
                }
                // if first or last flag is on
                else {
                    if (fFlag) {
                        data = firstOccurance(data, replaceFrom, replaceTo, iFlag);
                    }
                    if (lFlag) {
                        data = lastOccurance(data, replaceFrom, replaceTo, iFlag);
                    }
                }
                Files.writeString(Path.of(fileList.get(i)), data);

            } catch (IOException e) {
                File f = new File(fileList.get(i));
                System.err.println("File " +f.getAbsolutePath().substring(f.getAbsolutePath().lastIndexOf("\\")+1)  + " not found");
            }
        }
    }
    private void backupfile(String fileName) {
        String info= null;
        try {
            info = Files.readString(Path.of(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Files.writeString(Path.of(fileName + ".bck"), info);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String lastOccurance(String data, String replaceFrom, String replaceTo, boolean iflag) {

        //if the iflag is true, then replace case insensitive replaceFrom string to replaceTo String
        if(iflag) {
            String str = reverse(data);
            replaceFrom = reverse(replaceFrom);
            replaceTo = reverse(replaceTo);
            str = str.replaceFirst("(?i)" + replaceFrom, replaceTo);
            data = reverse(str);
        }
        else{
            String str = reverse(data);
            replaceFrom = reverse(replaceFrom);
            replaceTo = reverse(replaceTo);
            str = str.replaceFirst( replaceFrom, replaceTo);
            data = reverse(str);
        }
        return data;
    }

    private String reverse(String input){
        char[] in = input.toCharArray();
        int begin=0;
        int end=in.length-1;
        char temp;
        while(end>begin){
            temp = in[begin];
            in[begin]=in[end];
            in[end] = temp;
            end--;
            begin++;
        }
        return new String(in);
    }

    private String firstOccurance(String data, String replaceFrom, String replaceTo,boolean iflag) {
        if(iflag)
            return data.replaceFirst("(?i)" + replaceFrom, replaceTo);
        else
            return data.replaceFirst( replaceFrom, replaceTo);
    }

    private void usage() {
        System.err.println("Usage: Replace [-b] [-f] [-l] [-i] <from> <to> -- " + "<filename> [<filename>]*");
    }

}
