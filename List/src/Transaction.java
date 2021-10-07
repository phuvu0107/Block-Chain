/**
* Transaction.java
* @author Truong Phu Vu
* @author Tan Dung Dong
* CIS 22C Lab 2
*/

public interface Transaction {
    /*
     * Returns the transaction id
     * @return the id of the transaction
     */
    int getTransactionId();

    /**
     * Returns the customer's first name
     * @return the first name
     */
    String getFirstName();
 
    /**
     * Returns the customer's last name
     * @return the last name
     */
    String getLastName();

    /**
     * Returns the transaction description
     * @return the description
     */ 
    String getDescription();

    /**
     * Calculates the hash for the next
     * block
     * @param id the next block's id
     * @param firstName the customer first
     * name for the next block
     * @param lastName the customer last
     * name of the next block
     */

    void computeHash(int id, String firstName, String lastName);

}