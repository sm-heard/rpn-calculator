package edu.cnm.deepdive;

import java.util.Arrays;

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
  /**pops 1 value, pushes sqrt back onto*/
  SQUARE_ROOT("sqrt"),
  /**pops 2 value, pushes remainder back onto*/
  MODULO("%");

  private String token;

  private Operator(String token) {
    this.token = token;
  }

  /**
   *Exercises the Operator enum by printing all the of the enumerated values (as array)
   * @param args command line args ignored
   */
  public static void main(String[] args) {
    System.out.println(Arrays.toString(Operator.values()));
  }

  @Override
  public String toString() {
    return token;
  }

  //TODO Add operate method w/ switch (later version will use @Override.
}
