import java.io.*;

import java.util.Scanner;

/**
 * Transaction.java
 * 
 * @author Truong Phu Vu
 * @author Tan Dung Dong CIS 22C Lab 2
 */
public class BlockChain {
	public static void main(String[] args) {
		// Create a List Class strong Block object
		List<Block> blockList = new List<>();

		try {
			FileReader inFile = new FileReader("transaction.txt");
			Scanner readFile = new Scanner(inFile);
			// Read the first person
			int idNumber = readFile.nextInt();
			readFile.nextLine();

			String name = readFile.nextLine();
			int pos = name.indexOf(" ");

			String firstName = name.substring(0, pos);
			String lastName = name.substring(pos + 1);
			String description = readFile.nextLine();
			// Create a block and add info to a block
			Block infos = new Block(idNumber, firstName, lastName, description);
			blockList.addLast(infos);

			// Start to read from the next person
			while (readFile.hasNext()) {
				idNumber = readFile.nextInt();
				readFile.nextLine();

				name = readFile.nextLine();
				pos = name.indexOf(" ");

				firstName = name.substring(0, pos);
				lastName = name.substring(pos + 1);
				description = readFile.nextLine();

				// Compute hash start from the second person
				blockList.getLast().computeHash(idNumber, firstName, lastName);

				Block info = new Block(idNumber, firstName, lastName, description);
				blockList.addLast(info);

			}

		} catch (FileNotFoundException e) {
			System.out.println(e.toString());
		}

		// Create output
		System.out.println("Welcome to Block Chain!" + "\n");
		System.out.println("Total number of blocks: " + blockList.getLast().getNumBlocks() + "\n");

		Scanner scn = new Scanner(System.in);
		boolean answer = true;

		while (answer == true) {

			System.out.println("Would you like to add another transaction (y/n)?:");
			char userAnswer = scn.next().charAt(0);

			if (userAnswer == 'n') {
				answer = false;
				scn.nextLine();
				System.out.println("Enter the name of output file: ");
				String fileName = scn.nextLine();
				System.out.println("Goodbye!!!");
				File outFile = new File(fileName);
				FileWriter fWriter;
				try {
					fWriter = new FileWriter(outFile);
					PrintWriter pWriter = new PrintWriter(fWriter);
					pWriter.println(blockList.toString());
					pWriter.close();
				} catch (IOException e) {

					e.printStackTrace();

				}
				break;

			} else {

				System.out.println("Enter the transaction id: ");
				int newId = scn.nextInt();
				scn.nextLine();

				System.out.println("Enter the customer first and last name: ");
				String newName = scn.nextLine();

				int pos = newName.indexOf(" ");
				String firstName = newName.substring(0, pos);
				String lastName = newName.substring(pos + 1);

				System.out.println("Enter the transaction description: ");
				String newDes = scn.nextLine();

				blockList.getLast().computeHash(newId, firstName, lastName);

				Block infos = new Block(newId, firstName, lastName, newDes);
				blockList.addLast(infos);
				System.out.println("Total number of blocks: " + blockList.getLast().getNumBlocks() + "\n");
			}

		}

	}
}
