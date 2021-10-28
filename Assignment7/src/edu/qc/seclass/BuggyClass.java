package edu.qc.seclass;

public class BuggyClass{

    public int buggyMethod1(int x,int y, boolean z){

        int result=0;
        if(!z){
            y=0;
        }
        result=x/y;

        if(result%2==0) {
            result=x/result;
        }
        else {
            result=x/result;
        }
        return result;
    }

    public int buggyMethod2(int x, int y, boolean z){

        int result=1;
        if(!z){
            result=0;
        }
        if(x==0){
            result=y/result;
        }
        else{
            result=x/result;
        }
        return result;
    }

    public int buggyMethod3(int y) {
        int result = 1;
        if(y <0) {
            y += 1;
        }
        result=result/y;
        return result;
    }

    public void buggyMethod4(int a, int b){
        /*This is not possible to achieve 100% statement coverage because divisible by 0 will halt the program before it reach 100% statement coverage.
         At the same time it cannot achieve 100% branch coverage while not revealing fault because divisible by 0 will reveal the fault.
         */
    }

    public void buggyMethod5(){
            /*This is also not possible to achieve 100% statement coverage because divisible by 0 would halt the program brfore reaching 100% statement coverage..
             */
    }





}