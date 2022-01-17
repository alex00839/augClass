import org.testng.annotations.Test;

import java.util.Arrays;

public class JavaEX01 {

    @Test
    public void test00001() {
        System.out.println("Hello, World!");
    }

    @Test
    public void test00002() {
        String message01 = "Hello, World!";

        System.out.println(message01);
    }

    @Test
    public void test00003() {
        int myNumber;
        myNumber = 5;

        System.out.println(myNumber);
    }

    @Test
    public void test0004() {
        int num = 5;
        String s = "I have " + num + " cookies";

        System.out.println(s);
    }

    @Test
    public void test0005() {
        boolean b = true;

        if (b == true) {
            System.out.println("B is true");
        }
    }

    @Test
    public void test0006() {
        boolean b = true;

        if (b) {
            System.out.println("B is true");
        }
    }

    @Test
    public void test0007() {
        int value1 = 1;
        int value2 = 1;

        if ((value1 == 1) && (value2 == 1)) {
            System.out.println("BOOM!");
        }
    }

    @Test
    public void test0008() {
        boolean b;

        boolean toBe = true;
        b = toBe || !toBe;

        if (b) {
            System.out.println(toBe);
        }
    }


    @Test
    public void test0009() {
        boolean elementIsVisible = false;


        if (elementIsVisible) {
            System.out.println("CLICK on element");
        } else {
            System.out.println("Looking for another element");
        }
    }

    @Test
    public void test0010() {
        int[] array = new int[10];

        array[0] = 1;
        array[1] = 2;
        array[3] = 4;

        int[] array2 = new int[]{17, 2, 53, 4, 5, 6, 47, 8, 39};

        System.out.println(array2[0]);

        System.out.println(array2[2]);

        int[] arr3 = {1, 2, 3, 4, 5};


    }

    @Test
    public void test00011() {

        for (int i = 2; i < 4; i++) {
            System.out.println("HELLO");
        }
    }

    @Test
    public void test00012() {
        int[] array = {1, 34, 5, 653, 737, 357357, 54};

        for (int i = 0; i < array.length - 2; i++) {
            System.out.println(array[i]);
        }
    }

    //TODO: print out message (ONLY) if no elements found
    @Test
    public void test00013() {
        int[] array = {1, 34, 5, 653, 737, 357357, 54};
        int valueToSearch = 2;

        boolean isElementFound = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == valueToSearch) {
                System.out.println("element value found:" + array[i]);
                System.out.println("index of the element is:" + i);
                isElementFound = true;
            }
        }

        if (!isElementFound) {
            System.out.println("element is not in the array");
        }
    }

    @Test
    public void test00014() {
        int[] array = {1, 34, 5, 653, 737, 357357, 54};
        searchForElement(array, 737);
    }

    @Test
    public void test00016() {
        int[] array = {1, 34, 5, 653, 737, 357357, 54};
        searchForElement(array, 33434);
    }


    public void searchForElement(int[] inputArray, int valueToSearch) {
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == valueToSearch) {
                System.out.println("element value found:" + inputArray[i]);
                System.out.println("index of the element is:" + i);
            }
        }
    }


    //1. Loop
    //2. Go though number from 1 to 10
    //3. Filter out only even numbers (???)
    //4. Print them
    @Test
    public void testPrintEvenNumbers() {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) System.out.println(i);
        }
    }

    //1. Loop
    //2. Go though number from 1 to 10
    //3. Filter out only even numbers (???)
    //4. Print "hello world"
    @Test
    public void testPrintEvenNumbers2() throws Exception {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        solution(input, null);
    }

    @Test
    public void testPrintEvenNumbers3() throws Exception {
        int[] input = {1, 2, 3, 44, 55, 1000};

        solution(input, null);
    }

    //1. Loop
    //2. Go through number from 1 to 10
    //3. Filter out only even numbers (???)
    //4. Print "hello world"
    @Test
    public void testPrintPhrase() throws Exception {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        solution(input, "Hello World");
    }

    public void solution(int[] input, String phraseToPrint) throws Exception {
        for (int i = 0; i < input.length; i++) {
            int currentElement = input[i];
            if (currentElement >= 0 && currentElement <= 10) {
                int remainder = currentElement % 2;
                if (remainder == 0) {
                    if ("".equals(phraseToPrint) || phraseToPrint == null) {
                        System.out.println("Element value is:" + currentElement + ", FOUND EVEN NUMBER");
                    } else {
                        System.out.println(phraseToPrint);
                    }
                } else {
                    System.out.println("Element value is:" + currentElement + ", is not even");
                }
            } else {
                //TODO: decide what to do here
                //throw new Exception("Element is out of boundaries");
                System.out.println("Element value is:" + currentElement + ", it's out of boundaries");
            }
        }
    }

    @Test
    public void swapTwoNumbersInArray() throws Exception {
        int[] array = {1, 2, 3, 4};
        int parameter1 = 9;
        int parameter2 = 2;

        swap(array, parameter1, parameter2);
        System.out.println(Arrays.toString(array));
    }

    public void swap(int[] array, int indexL, int indexR) throws Exception {
        if (indexL > 0 && indexL < array.length && indexR > 0 && indexR < array.length) {
            int temp = array[indexL];
            array[indexL] = array[indexR];
            array[indexR] = temp;
        } else {
            throw new Exception("indexL or indexR is out of bounds, array length is " + array.length);
        }

    }


    public int sumAplusB(int firstValue, int secondValue) {
        int result = 0;
        result = firstValue + secondValue;
        return result;
    }

    @Test
    public void testSumMethod() {
        int testValue1 = 1;
        int testValue2 = 2;

        int resultOfMethod = sumAplusB(testValue1, testValue2);

        System.out.println(resultOfMethod);

        char[] chars = "mystring".toCharArray();
    }

    @Test
    public void testTryCatch() {
        int[] myNumbers = {1, 2, 3};
        int index = 10;

        int element01 = 0;
        try {
            element01 = myNumbers[index];
        } catch (ArrayIndexOutOfBoundsException exception) {

            System.out.println("Exception been thrown");

        }

        System.out.println(element01);

    }
    @Test
    public void testCountLetters() {
        String input = "hello world";
        int result = 0;
        for(char eachChar : input.toCharArray()){
            if(eachChar== 'l') result++;
        }
        System.out.println(result);
    }

    @Test
    public void testTryCatch01() {
        int[] myNumbers = {1, 2, 3};
        int index = 10;

        int element01 = 0;
        try {
            element01 = myNumbers[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        System.out.println(element01);
    }
}