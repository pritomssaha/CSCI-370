package edu.qc.seclass;

public class MyCustomString implements MyCustomStringInterface {

    private String myString;

    @Override
    /*
    * if the string is empty return null
    * else return the string
    * */
    public String getString() {
        if(this.myString.isEmpty())
            return null;
        else
            return myString;
    }

    @Override
    /*
    * assigning string with the given value
    * */
    public void setString(String string) {

        this.myString=string;

    }

    @Override
    /*
    * if the string is empty, return null
    * return total number occurrence of the string
    * */
    public int countNumbers() {
        StringBuffer tmpString = new StringBuffer();
        int count=0;
        boolean inNumber=false;

        if(this.myString==null)
            throw new NullPointerException();

        if(this.myString.isEmpty())
            return 0;

        for (int i = 0; i < this.myString.length(); i++) {
            char ch = this.myString.charAt(i);
            if (Character.isDigit(ch)) {
                if (!inNumber) {
                    count++;
                    inNumber = true;
                }
            }
            else {
                if (inNumber) {
                    inNumber = false;
                }
            }
        }
        return count;
    }


    @Override
    /*
     * if n is less than or equal 0, return IllegalArgumentException
     * if the string is null and n is greater than 0, return NullPointerException
     * if n is greater than the string length, return an empty string
     * if start from end iterate from the end of the string and reverse the string
     * if startFromEnd is false iterate from the start of the string
     * return the string
     */

    public String getEveryNthCharacterFromBeginningOrEnd(int n, boolean startFromEnd) {
        StringBuilder sb = new StringBuilder();
        int length=this.myString.length();
        if(n <= 0){
            throw new IllegalArgumentException();
        }
        else if(this.myString == null && n > 0){
            throw new NullPointerException();
        }
        else {
            if (n > length) {
                return "";
            } else {
                if (startFromEnd) {
                    for (int i = length - n; i >= 0; i -= n) {
                        sb.append(this.myString.charAt(i));
                    }
                    sb=sb.reverse();
                }
                else {
                    for (int i = n - 1; i < length; i += n) {
                        sb.append(this.myString.charAt(i));
                    }
                }
               return sb.toString();
            }
        }
    }

    @Override
    public void convertDigitsToNamesInSubstring(int startPosition, int endPosition) {
        if(startPosition > endPosition){
            throw new IllegalArgumentException();
        }
        else if((startPosition <= endPosition) && ((startPosition < 1 || endPosition > this.myString.length()))){
            throw new MyIndexOutOfBoundsException();
        }
        else if((startPosition <= endPosition) && ((startPosition > 0 && endPosition > 0 && this.myString == null))){
            throw new NullPointerException();
        }
        else{
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < this.myString.length(); i++){
                if(Character.isDigit(myString.charAt(i)) && i >= startPosition-1 && i <= endPosition -1){
                    if(myString.charAt(i)=='0'){
                        sb.append("Zero");
                    }
                    if(myString.charAt(i)=='1'){
                        sb.append("One");
                    }
                    if(myString.charAt(i)=='2'){
                        sb.append("Two");
                    }
                    if(myString.charAt(i)=='3'){
                        sb.append("Three");
                    }
                    if(myString.charAt(i)=='4'){
                        sb.append("Four");
                    }
                    if(myString.charAt(i)=='5'){
                        sb.append("Five");
                    }
                    if(myString.charAt(i)=='6'){
                        sb.append("Six");
                    }
                    if(myString.charAt(i)=='7'){
                        sb.append("Seven");
                    }
                    if(myString.charAt(i)=='8'){
                        sb.append("Eight");
                    }
                    if(myString.charAt(i)=='9'){
                        sb.append("Nine");
                    }

                }
                else{
                    sb.append(this.myString.charAt(i));
                }
            }
            this.myString = sb.toString();
        }

    }
}
