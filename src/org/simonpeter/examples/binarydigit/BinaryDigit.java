/*
 * BinaryDigit.java
 */

package org.simonpeter.examples.binarydigit;


/**
 * Represents a binary digit, specifically {@code true} and {@code false}.
 * <p>
 * This object was expressly created using Test Driven Design. It is fully
 * tested and both it and its tests are documented to a greater extent
 * than normal to allow the student of JUnit and unit testing an opportunity
 * to review how and why things were done they way they were.
 * <p>
 * Because binary digits do not change values (interaction with cosmic rays
 * excepted), this object is implemented in immutable fashion.
 * <p>
 * A full range of <a href="http://en.wikipedia.org/wiki/Boolean_algebra_(structure)">Boolean logic</a>
 * operators are available for operations on singles or pairs of BinaryDigits.
 * <p>
 * Static pre-defined instances of true and false are available, named
 * TRUE and FALSE. It is recommended that these be brought in and used
 * by a static import.
 * 
 * @author Simon Peter Chappell
 * @version 20100727
 */
public class BinaryDigit {

	private final        String _value;
	private final static String _true  = "one";
	private final static String _false = "zero";

	public final static BinaryDigit TRUE  = new BinaryDigit(_true);
	public final static BinaryDigit FALSE = new BinaryDigit(_false);

	/**
	 * Private constructor to allow initialization with the special
	 * internal values for true and false.
	 * <p>
	 * At this point the values are Strings, but could be anything
	 * (except for primitive types because of the use of the
	 * {@link #equals()} method to perform all of the equality and
	 * logic tests), as long as the signature of this constructor
	 * is updated to reflect the type of whatever is used.
	 * 
	 * @param value - initial value of the Binary Digit
	 */
	private BinaryDigit(String value) {
		_value = value;
	}

	/**
	 * Construct a {@link BinaryDigit}.
	 * <p>
	 * This is the public constructor. It is designed to be used with
	 * the pre-constructed TRUE and FALSE values. Perhaps, this seems
	 * overkill, but this is a demonstration/example object, so some
	 * practicality was sacrificed in the name of expediency.
	 * 
	 * @param bit - the value of the binary digit.
	 */
	public BinaryDigit(BinaryDigit bit) {
		_value = bit.toBoolean() ? _true : _false;
	}

	/**
	 * Return a boolean representation of the value of the instance of
	 * BinaryDigit.
	 * <p>
	 * A small nod to the reality that Java only uses its own boolean
	 * objects for conditionals. Being able to return a {@code true} or
	 * {@code false} value is the only way to play nicely with Java
	 * conditionals. And what use is a BinaryDigit that can't be used
	 * as a boolean?
	 * 
	 * @return boolean
	 */
	public boolean toBoolean() {
		return (_value.equals(_true)) ? true : false;
	}

	/**
	 * Return a text description of the state of the instance.
	 * <p>
	 * The values returned are "True" and "False". 
	 * 
	 * @return the {@code String} representation of the instance.
	 */
	@Override
	public String toString() {
		return (_value.equals(_true)) ? "True" : "False";
	}

	/**
	 * Indicates whether another {@link BinaryDigit} is
	 * "equal to" this one.
	 * <p>
	 * A good description of the requirements for object equality
	 * is given in the Java API document entry for {link Object}.
	 * An exhaustive explanation of the qualities of a good
	 * {@code equals()} method is given in
	 * <cite>Effective Java</cite> by Joshua Bloch.
	 * 
	 * @param obj - the reference object with which to compare.
	 * @return {@code true} if this object is the same as the obj argument; {@code false} otherwise.
	 * @see java.util.Object#equals
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this) { return true; }
		if (!(obj instanceof BinaryDigit)) { return false; }
		BinaryDigit that = (BinaryDigit) obj;
		return this.toBoolean() == that.toBoolean();
	}

	/**
	 * Returns a hash code value for the {@link BinaryDigit}.
	 * <p>
	 * This method is supported for the benefit of hashtables, such
	 * as those provided by {@link java.util.Hashtable}.
	 * <p>
	 * A good description of the requirements for object hashcodes is
	 * given in the Java API document entry for {link Object}. An
	 * exhaustive explanation of the qualities of a good {@code hashCode()}
	 * method is given in <cite>Effective Java</cite> by Joshua
	 * Bloch.
	 * 
	 * @return a hash code value for this object.
	 * @see java.util.Object
	 * @see java.util.Hashtable
	 */
	@Override
	public int hashCode() {
		return this.equals(TRUE) ? 1 : 0;
	}

	/**
	 * Perform a logical negation of the current instance.
	 * <p>
	 * This is also known as NOT logic in Boolean algebra. See the
	 * article on <a href="http://en.wikipedia.org/wiki/Negation">logical negation</a>
	 * at Wikipedia for more details.
	 * 
	 * @return the logical negation (NOT).
	 */
	public BinaryDigit not() {
		return this.equals(TRUE) ? FALSE : TRUE;
	}

	/**
	 * Perform a logical conjunction of the current instance and its argument.
	 * <p>
	 * This is also known as AND logic in Boolean algebra. See the article on
	 * <a href="http://en.wikipedia.org/wiki/Logical_conjunction">logical conjunction</a>
	 * at Wikipedia for more details.
	 * 
	 * @param that - a {@link BinaryDigit}.
	 * @return the logical conjunction (AND).
	 */
	public BinaryDigit and(BinaryDigit that) {
		return (this.equals(TRUE) && that.equals(TRUE)) ? TRUE : FALSE;
	}

	/**
	 * Perform a negation of the conjunction of the current instance and its argument.
	 * <p>
	 * This is also known as NAND logic in Boolean algebra. See the article on
	 * <a href="http://en.wikipedia.org/wiki/Logical_NAND">Logical NAND</a>
	 * at Wikipedia for more details.
	 * 
	 * @param that - a {@link BinaryDigit}.
	 * @return the negation of the logical conjunction (NAND).
	 */
	public BinaryDigit nand(BinaryDigit that) {
		return ((this.and(that)).not());
	}

	/**
	 * Perform a logical disjunction of the current instance and its argument.
	 * <p>
	 * This is also known as OR logic in Boolean algebra. See the article on
	 * <a href="http://en.wikipedia.org/wiki/Logical_disjunction">logical disjunction</a>
	 * at Wikipedia for more details.
	 * 
	 * @param that - a {@link BinaryDigit}.
	 * @return the logical disjunction (OR).
	 */
	public BinaryDigit or(BinaryDigit that) {
		return this.equals(TRUE) || that.equals(TRUE) ? TRUE : FALSE;
	}

	/**
	 * Perform a negation of the logical disjunction of the current instance and its argument.
	 * <p>
	 * This is also known as NOR logic in Boolean algebra. See the article on
	 * <a href="http://en.wikipedia.org/wiki/Logical_NOR">Logical NOR</a>
	 * at Wikipedia for more details.
	 * 
	 * @param that - a {@link BinaryDigit}.
	 * @return the negation of the logical disjunction (NOR).
	 */
	public BinaryDigit nor(BinaryDigit that) {
		return ((this.or(that)).not());
	}

	/**
	 * Perform an exclusive disjunction on the current instance and its argument.
	 * <p>
	 * This is also known as XOR (exclusive OR) logic in Boolean algebra. See
	 * the article on <a href="http://en.wikipedia.org/wiki/XOR">Exclusive OR</a>
	 * at Wikipedia for more details.
	 * 
	 * @param that - a {@link BinaryDigit}.
	 * @return the exclusive disjunction (XOR).
	 */
	public BinaryDigit xor(BinaryDigit that) {
		return this.equals(that) ? FALSE : TRUE;
	}

	/**
	 * Performs a logical equality on the current instance and its argument.
	 * <p>
	 * This is also known as XNOR logic in Boolean algebra. See the article on
	 * <a href="http://en.wikipedia.org/wiki/XNOR">XNOR</a> at Wikipedia
	 * for more details.
	 * 
	 * @param that - a {@link BinaryDigit}.
	 * @return the logical equality (XNOR).
	 */
	public BinaryDigit xnor(BinaryDigit that) {
		return ((this.xor(that)).not());
	}
}
