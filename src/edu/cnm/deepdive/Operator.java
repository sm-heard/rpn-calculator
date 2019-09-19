package edu.cnm.deepdive;

import java.util.Deque;

/**
 * Enumerated values representing operators in a posfix rpn calc.  Each operator has a token
 * used to recognize the operator in input string and to represent in output string.
 */
public enum Operator {

  /**Pops 2 vals from stack, pushes sum of the 2 back onto stack */
  ADD("+"),
  /**Pops 2 vals from stack, pushes difference of the 2 back onto stack */
  SUBTRACT("-"),
  /**Pops 2 vals from stack, pushes product of the 2 back onto stack */
  MULTIPLY("*"),
  /**Pops 2 vals from stack, pushes truncated quotient of the 2 back onto stack */
  DIVIDE("/"),
  POWER("^"),
  /**pops 1 value, pushes sqrt back onto*/
  SQUARE_ROOT("sqrt") {
    @Override
    protected boolean needsEscape() {
      return false;
    }
  },
  /**pops 2 value, pushes remainder back onto*/
  MODULO("%");

  private String token;

  private Operator(String token) {
    this.token = token;
  }


  @Override
  public String toString() {
    return token;
  }

  protected boolean needsEscape(){
    return true;
  }
  public static String tokenPattern(){
    String pattern = "";
    for (Operator op : values()){
      if (op.needsEscape()){
        pattern += "\\";
      }
      pattern += op.token + "|";
    }
    return String.format("(?<=^|\\s)%s(?=\\s|$)", pattern.substring(0, pattern.length()-1));
  }

  public static void operate(String token, Deque<Double> operands){
    Operator op = null;
    for (Operator compare : values()){
      if (compare.token.equals(token)){
        op = compare;
        break;
      }
    }
    double operand = operands.pop();
    double result;
    switch (op){
      case ADD:
        result = operand + operands.pop();
        break;
      case SUBTRACT:
        result = operands.pop() - operand;
        break;
      case MULTIPLY:
        result = operand * operands.pop();
        break;
      case DIVIDE:
        result = operands.pop() / operand;
        break;
      case POWER:
        result = Math.pow(operands.pop(),operand);
        break;
      case MODULO:
        result = operands.pop() % operand;
        break;
      case SQUARE_ROOT:
        result = Math.sqrt(operand);
        break;
      default:
        result = 0;
    }
    operands.push(result);

  }
}
