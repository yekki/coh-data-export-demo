/***************************************************************************
 *
 * PoC code for evaluating purpose only. No guarantee of quality.
 *
 ***************************************************************************/

package com.oracle.poc.coherence.exp;

import java.io.File;

import com.sleepycat.je.Cursor;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.LockMode;
import com.sleepycat.je.OperationStatus;
import com.sleepycat.je.SecondaryConfig;

public class BdbExp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EnvironmentConfig myEnvConfig = new EnvironmentConfig();
		DatabaseConfig myDbConfig = new DatabaseConfig();
		SecondaryConfig mySecConfig = new SecondaryConfig();

		final boolean readOnly = true;
		// If the environment is read-only, then
		// make the databases read-only too.
		myEnvConfig.setReadOnly(readOnly);
		myDbConfig.setReadOnly(readOnly);
		mySecConfig.setReadOnly(readOnly);

		// If the environment is opened for write, then we want to be
		// able to create the environment and databases if
		// they do not exist.
		myEnvConfig.setAllowCreate(!readOnly);
		myDbConfig.setAllowCreate(!readOnly);
		mySecConfig.setAllowCreate(!readOnly);

		// Allow transactions if we are writing to the database
		myEnvConfig.setTransactional(!readOnly);
		myDbConfig.setTransactional(!readOnly);
		mySecConfig.setTransactional(!readOnly);

		// Open the environment
		Environment myEnv = new Environment(new File("D:\\Projects\\CoherenceExport\\tmp3"), myEnvConfig);

		// 282943201452599 is the database name. However, how to determine the
		// database name dynamically???
		Database db = myEnv.openDatabase(null, "282943201452599", myDbConfig);
		Cursor cursor = db.openCursor(null, null);

		DatabaseEntry foundKey = new DatabaseEntry();
		DatabaseEntry foundData = new DatabaseEntry();

		try { // always want to make sure the cursor gets closed
			while (cursor.getNext(foundKey, foundData, LockMode.DEFAULT) == OperationStatus.SUCCESS) {
				System.out.println("key: " + new String(foundKey.getData()));
				byte[] data = foundData.getData();
				System.out.println("Raw data:  " + foundData);
				System.out.println("Decoded data:  " + new String(data, "UTF8"));

				int offset = 110; // How to determine this offset???
				String dataString = new String(foundData.getData(), offset, foundData.getSize() - offset, "UTF-8");
				// dataString = dataString.replaceAll("N", ",");
				System.out.println("data: " + dataString);
			}
		} catch (Exception e) {
			System.err.println("Error on inventory cursor: " + e);
			e.printStackTrace();
		} finally {
			cursor.close();
		}
	}
}
