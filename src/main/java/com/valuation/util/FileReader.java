package com.valuation.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class FileReader {

    private static final String REGISTRATION_PATTERN = "(^[A-Z]{2}[0-9]{2}([A-Z]{3}|\\s[A-Z]{3})$)";

    public  static List<String> getRegistrationNumbers(String inputFileName) throws IOException {
        BufferedReader bufferedReader = null;
        List<String> regNumbers = new ArrayList<String>();
        try{
            File inputFile = getFile(inputFileName);
            bufferedReader = new BufferedReader(new java.io.FileReader(inputFile.getAbsolutePath()));
            String strLine;
            while ((strLine = bufferedReader.readLine()) != null)   {
                String[] words = strLine.split(" ");

                for (String str : words) {
                    if (Pattern.matches(REGISTRATION_PATTERN, str)) {
                        regNumbers.add(str);
                    }
                }
            }

        } catch (Exception exception) {
            System.err.println("Error details: " + exception.getMessage());
        } finally {
            bufferedReader.close();
        }
        return regNumbers;
    }


    public static  Map<String,List<String>> getExpectedDetails(String outputFileName) throws IOException {
        BufferedReader bufferedReader = null;
        String outLine = " ";
        List<String> outputValues = new ArrayList<String>();
        Map<String,List<String>> expectedDetails = new HashMap<String, List<String>>();
        try {
            File inputFile = getFile(outputFileName);
            bufferedReader = new BufferedReader(new java.io.FileReader(inputFile.getAbsolutePath()));
            while ((outLine = bufferedReader.readLine()) != null) {
                outputValues.add(outLine);
            }

            outputValues.remove(0);//remove headers

            for(String expectedValue:outputValues) {
                String[] exp = expectedValue.split(",");
                List<String> list = Arrays.asList(exp);
                expectedDetails.put(list.get(0),list);
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            bufferedReader.close();
        }

        return  expectedDetails;
    }

    private static File getFile(String filepath) {
        ClassLoader classLoader = FileReader.class.getClassLoader();
        return new File(classLoader.getResource(filepath).getFile());
    }


}

