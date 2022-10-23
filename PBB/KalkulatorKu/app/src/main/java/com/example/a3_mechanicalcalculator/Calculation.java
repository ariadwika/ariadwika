package com.example.a3_mechanicalcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Calculation {

    private int id;
    private String calculationStr, lastNumber, lastOperator;
    private String lastDigit = "0";
    private boolean lastNumberDecimal;
    private double result;

    public Calculation() {
        this.result = 0;
    }

    public Calculation(String text) {
        if(text.length()==1) {
            if (isOperator(text)) {
                this.calculationStr = "0".concat(text);
            } else if (text.equals(".")) {
                this.calculationStr = "0".concat(text);
            } else {
                this.calculationStr = text;
                this.result = Double.parseDouble(text);
            }
            this.lastDigit = text;
        } else {
            this.calculationStr = text;
            this.lastDigit = String.valueOf(calculationStr.charAt(calculationStr.length()-1));
            calculateResult();
        }
    }

    public Calculation(int id, String calculationStr, String lastDigit, String lastNumber, int lastNumberDecimal, double result) {
        this.id = id;
        this.calculationStr = calculationStr;
        this.lastDigit = lastDigit;
        this.lastNumber = lastNumber;
        this.result = result;
        this.lastNumberDecimal = lastNumberDecimal == 0 ? false : true ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCalculationStr() {
        return calculationStr;
    }

    public void setCalculationStr(String calculationStr) {
        this.calculationStr = calculationStr;
    }

    public String getLastDigit() {
        return lastDigit;
    }

    public void setLastDigit(String lastDigit) {
        this.lastDigit = lastDigit;
    }

    public String getLastNumber() {
        return lastNumber;
    }

    public void setLastNumber(String lastNumber) {
        this.lastNumber = lastNumber;
    }

    public String getLastOperator() {
        return lastOperator;
    }

    public void setLastOperator(String lastOperator) {
        this.lastOperator = lastOperator;
    }

    public boolean isLastNumberDecimal() {
        return lastNumberDecimal;
    }

    public void setLastNumberDecimal(int lastNumberDecimal) {
        this.lastNumberDecimal = lastNumberDecimal == 0 ? false : true;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }


    // ADDITIONAL METHODS

    void backspace() {
        this.calculationStr = calculationStr.substring(0, calculationStr.length()-1);
        if(!calculationStr.equals("")) {
            this.lastDigit = calculationStr.substring(calculationStr.length()-1);
            calculateResult();
        }
    }

    void addOperator(String operator) {
        if(isOperator(lastDigit) && !lastDigit.equals(".")) {
            this.calculationStr = calculationStr.substring(0, calculationStr.length()-1).concat(operator);
        } else {
            this.calculationStr = calculationStr.concat(operator);
        }
        this.lastDigit = operator;
    }

    void addNumber(String number) {
        this.calculationStr = calculationStr.concat(number);
        this.lastDigit = number;
        calculateResult();
    }

    void addDot() {
        if(!lastDigit.equals(".")) {
            int i = calculationStr.length()-1;
            if(i==0) {
                this.calculationStr = calculationStr.concat(".");
                this.lastDigit = ".";
                calculateResult();
            } else {
                while (i > 0) {
                    // check if result at index i is an operator or if i is at 1 and not a dot
                    if (isOperator(String.valueOf(calculationStr.charAt(i))) || (i == 1 && !String.valueOf(calculationStr.charAt(1)).equals("."))) {
                        boolean noDot = true;
//                        for (int j = calculationStr.length() - 1; j > i; j--) {
//                            if (calculationStr.charAt(j) == '.') {
//                                noDot = false;
//                                break;
//                            }
//                        }
                        String lastNumber = calculationStr.substring(i+1);
                        if(lastNumber.contains(".")) {
                            noDot = false;
                            break;
                        }
                        if (noDot) {
                            this.calculationStr = calculationStr.concat(".");
                            this.lastDigit = ".";
                            calculateResult();
                        }
                        break;
                    }
                    i--;
                }
            }
        }
    }

    void onPercentPressed() {
        boolean noOperator = true;
        for(int i=0; i<calculationStr.length(); i++) {
            if(isOperator(String.valueOf(calculationStr.charAt(i)))) {
                noOperator = false;
            }
        }

        if(noOperator) {
            this.result = Double.parseDouble(calculationStr) * 0.01;
            this.calculationStr = String.valueOf(result);
        }
        else if(!isOperator(lastDigit)) {
            // Separating numbers from operators
            ArrayList<String> numbers = getNumbers(calculationStr);

            // Sorting the operation order
            Map<ArrayList<String>, Map<String, ArrayList<Integer>>> opDetails = getOperatorDetails(calculationStr);
            ArrayList<String> opSorted = new ArrayList<String>();
            Map<String, ArrayList<Integer>> opLocation = new HashMap<>();
            for(Map.Entry<ArrayList<String>, Map<String, ArrayList<Integer>>> entry : opDetails.entrySet()) {
                opSorted = entry.getKey();
                opLocation = entry.getValue();
            }

            String lastOp = checkLastOperator(opSorted, opLocation);
            String lastNumber = numbers.get(numbers.size()-1);
            String lastNumberPercentage = String.valueOf(Double.parseDouble(lastNumber) * 0.01);
            if(lastOp.equals("×") || lastOp.equals("÷")) {
                // if it's multiplication or division, just multiply the last number by 0.01
                numbers.set(numbers.size()-1, lastNumberPercentage);
                this.calculationStr = calculationStr.substring(0, calculationStr.length() - lastNumber.length()).concat(lastNumberPercentage);
            } else {
                // if it's addition or substraction, replace the last number by X% of the previous calculation
                ArrayList<String> prevNumbers = new ArrayList<>(numbers);
                prevNumbers.remove(prevNumbers.size()-1);
                ArrayList<String> tempOpSorted = new ArrayList<>(opSorted);
                tempOpSorted.remove(tempOpSorted.size()-1);

                // duplicate opLocation arraylist
                Map<String, ArrayList<Integer>> prevCalcOpLoc = new HashMap<String, ArrayList<Integer>>();
                for(Map.Entry<String, ArrayList<Integer>> entry : opLocation.entrySet()) {
                    String key = entry.getKey();
                    ArrayList<Integer> value = new ArrayList<>(entry.getValue());
                    prevCalcOpLoc.put(key, value);
                }

                double prevCalc = getResultVal(prevNumbers, tempOpSorted, prevCalcOpLoc);
                String percentagedVal = String.valueOf(prevCalc * Double.parseDouble(lastNumberPercentage));
                numbers.set(numbers.size()-1, percentagedVal);
                this.calculationStr = calculationStr.substring(0, calculationStr.length() - lastNumber.length()).concat(percentagedVal);
                this.lastDigit = String.valueOf(calculationStr.charAt(calculationStr.length()-1));
            }
            this.result = getResultVal(numbers, opSorted, opLocation);
        }
    }

    boolean isOperator(String key) {
        String[] operators = {"÷", "×", "-", "+"};
        return Arrays.asList(operators).contains(key);
    }


    // Calculation Methods

    void calculateResult() {
        // Separating numbers from operators
        ArrayList<String> numbers = getNumbers(this.calculationStr);

        // Sorting the operation order
        Map<ArrayList<String>, Map<String, ArrayList<Integer>>> opDetails = getOperatorDetails(calculationStr);
        ArrayList<String> opSorted = new ArrayList<String>();
        Map<String, ArrayList<Integer>> opLocation = new HashMap<String, ArrayList<Integer>>();
        for(Map.Entry<ArrayList<String>, Map<String, ArrayList<Integer>>> entry : opDetails.entrySet()) {
            opSorted = entry.getKey();
            opLocation = entry.getValue();
        }

        if(!opSorted.isEmpty())
            this.result = getResultVal(numbers, opSorted, opLocation);
        else
            this.result = Double.parseDouble(numbers.get(0));
    }

    public ArrayList<String> getNumbers(String calculationStr) {
        // + and * is a special characters so use double backslash to escape the individual special characters
        String[] operators = {"\\×", "÷", "\\+", "-"};

        ArrayList<String> split = new ArrayList<String>();
        ArrayList<String> numbers = new ArrayList<String>();
        for(String operator : operators) {
            if(split.size()==0) {
                split.add(calculationStr);
            } else {
                split.clear();
                split.addAll(numbers);
                numbers.clear();
            }
            for(String splitted : split) {
                String[] temp = splitted.split(operator, 0);
                for(String tempSplitted : temp) {
                    numbers.add(tempSplitted);
                }
            }
        }

        for(int i=0; i<numbers.size(); i++) {
            if(numbers.get(i).equals(".")) {
                numbers.set(i, "0");
            }
        }

        return numbers;
    }

    public Map<ArrayList<String>, Map<String, ArrayList<Integer>>> getOperatorDetails(String calculationStr) {
        Map<String, ArrayList<Integer>> opLocation = new HashMap<String, ArrayList<Integer>>();
        opLocation.put("×", new ArrayList<Integer>());
        opLocation.put("÷", new ArrayList<Integer>());
        opLocation.put("+", new ArrayList<Integer>());
        opLocation.put("-", new ArrayList<Integer>());

        String[] calcSplitted = calculationStr.split("");
        int opOrder = 0;
        ArrayList<String> opSorted = new ArrayList<String>();

        int iterateLimit = calcSplitted.length;
        // conditional statement below is needed when backspace is pressed
        if(isOperator(lastDigit)) {
            iterateLimit--;
//            this.lastOperator = lastDigit;
        }

        for(int i=0; i<iterateLimit; i++) {
            if(calcSplitted[i].equals("×") || calcSplitted[i].equals("÷") || calcSplitted[i].equals("+") || calcSplitted[i].equals("-")) {
                opLocation.get(calcSplitted[i]).add(opOrder);
                if(opSorted.isEmpty()) {
                    opSorted.add(calcSplitted[i]);
                } else {
                    for(int j=opSorted.size()-1; j>=0; j--) {
                        if(getOperatorVal(calcSplitted[i]) > getOperatorVal(opSorted.get(j))) {
                            if(j==0) {
                                opSorted.add(0, calcSplitted[i]);
                            }
                            continue;
                        } else {
                            opSorted.add(j+1, calcSplitted[i]);
                            break;
                        }
                    }
                }
                opOrder++;
            }
        }
        Map<ArrayList<String>, Map<String, ArrayList<Integer>>> opDetails = new HashMap<ArrayList<String>, Map<String, ArrayList<Integer>>>();
        opDetails.put(opSorted, opLocation);

        return opDetails;
    }

    public int getOperatorVal(String operator) {
        if(operator.equals("×") || operator.equals("÷")) {
            return 1;
        } else {
            return 0;
        }
    }

    public double getResultVal(ArrayList<String> numbers, ArrayList<String> opSorted, Map<String, ArrayList<Integer>> opLocation) {
        ArrayList<Integer> calculated = new ArrayList<Integer>();

        for(String operator : opSorted) {
            int opPos = opLocation.get(operator).get(0);
            int smallerOpPos = 0;
            if(calculated.isEmpty()) {
                calculated.add(opPos);
            } else {
                for(int pos : calculated) {
                    if(pos < opPos)
                        smallerOpPos++;
                }
                calculated.add(smallerOpPos, opPos);
            }
            opPos -= smallerOpPos;
            numbers.set(opPos, String.valueOf(calculate(operator, numbers.get(opPos), numbers.get(opPos+1))));
            numbers.remove(opPos+1);

            opLocation.get(operator).remove(0);
        }

        return Double.parseDouble(numbers.get(0));
    }

    public static double calculate(String operator, String num1, String num2) {
        double fnum1 = Double.parseDouble(num1);
        double fnum2 = Double.parseDouble(num2);
        double result = 0;
        switch(operator) {
            case "×":
                result = fnum1*fnum2;
                break;
            case "÷":
                result = fnum1/fnum2;
                break;
            case "+":
                result = fnum1+fnum2;
                break;
            case "-":
                result = fnum1-fnum2;
                break;
        }
        return result;
    }

    public String checkLastOperator(ArrayList<String> opSorted, Map<String, ArrayList<Integer>> opLocation) {
        String lastOp = "";

        for (Map.Entry<String, ArrayList<Integer>> entry : opLocation.entrySet()) {
            for(int location : entry.getValue()) {
                if(location == opSorted.size()-1)
                    lastOp = entry.getKey();
            }
        }
        return lastOp;
    }
}