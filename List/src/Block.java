/**
 * Block.java
 * 
 * @author Truong Phu Vu
 * @author Tan Dung Dong CIS 22C Lab2
 */

public class Block implements Transaction {

	private int transactionId;
	private String firstName;
	private String lastName;
	private String description;
	private long timeStampMillis;
	private long hashNextBlock;
	private static int numBlocks = 0;

	/**
	 * Constructor for a Block
	 * 
	 * @param id          the transaction id
	 * @param first       the customer first name
	 * @param last        the customer last name
	 * @param description the transaction description Calls System's
	 *                    currentTimeMillis() method to assign the timeStampMillis
	 *                    Increases the numBlocks
	 */
	public Block(int transactionId, String firstName, String lastName, String description) {
		this.transactionId = transactionId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.description = description;
		timeStampMillis = System.currentTimeMillis();
		numBlocks++;
	}

	/**
	 * Returns the current number of blocks
	 * 
	 * @return the number of blocks
	 */
	public static int getNumBlocks() {
		return numBlocks;
	}

	/**
	 * Calculates the hash for the next block
	 * 
	 * @param id        the next block's id
	 * @param firstName the customer first name for the next block
	 * @param lastName  the customer last name of the next block
	 */
	public void computeHash(int id, String firstName, String lastName) {
		String name = firstName + lastName;
		int sum = 0;
		for (int i = 0; i < name.length(); i++) {
			sum += name.charAt(i);
		}

		hashNextBlock = sum * 10000 + id;
	}

	/**
	 * toString for the Block class
	 * 
	 * @return a String of Block object
	 */
	@Override
	public String toString() {

		String ID = "Id: " + Integer.toString(transactionId);
		String name = "Name: " + firstName + " " + lastName;
		String descriptionResult = "Description: " + description;
		String timeStamp = "Time Stamp: " + Long.toString(timeStampMillis);
		String hashBlock = "Hash of next Block: " + Long.toString(hashNextBlock);

		return ID + "\n" + name + "\n" + descriptionResult + "\n" + timeStamp + "\n" + hashBlock + "\n";

	}

	@Override
	public int getTransactionId() {
		return transactionId;
	}

	@Override
	public String getFirstName() {

		return firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public String getDescription() {

		return description;

	}

}