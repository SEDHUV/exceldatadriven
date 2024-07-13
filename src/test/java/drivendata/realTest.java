package drivendata;

import java.io.IOException;
import java.util.ArrayList;

public class realTest {
    public static void main(String[] args) throws IOException {
        simpledriven simpledriven = new simpledriven();
        ArrayList arr =simpledriven.getData("purchase");
        System.out.println(arr.get(0));
        System.out.println(arr.get(1));
        System.out.println(arr.get(2));
        System.out.println(arr.get(3));
        System.out.println(arr.get(4));

    }
}