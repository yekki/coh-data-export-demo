/***************************************************************************
 *
 * PoC code for evaluating purpose only. No guarantee of quality.
 *
 ***************************************************************************/

package com.oracle.poc.coherence.GUI;

import static com.tangosol.net.cache.TypeAssertion.withTypes;

import java.util.HashMap;
import java.util.Map;

import com.oracle.poc.coherence.model.Employee;
import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;

/***************************************************************************
 * <PRE>
 *  Project Name    : CoherenceDataExportDemo
 * 
 *  Package Name    : com.oracle.poc.coherence.GUI
 * 
 *  File Name       : DataLoader.java
 * 
 *  Creation Date   : 2016Äê7ÔÂ21ÈÕ
 * 
 *  Author          : Hysun He
 * 
 *  Purpose         : TODO
 * 
 * 
 *  History         : TODO
 * 
 * </PRE>
 ***************************************************************************/
public class DataLoader {
	public static void main(String[] args) {
		int count = 0;
		if (args.length == 0) {
			System.err.println("!!! Please specify how many records you want to load!");
			System.exit(1);
		}

		count = Integer.valueOf(args[0]);

		NamedCache<String, Employee> cache = CacheFactory.getTypedCache("Employee",
				withTypes(String.class, Employee.class));

		Map<String, Employee> buf = new HashMap<>();

		for (int i = 1; i <= count; i++) {
			String key = "EMP_" + i;
			Employee emp = new Employee();
			emp.setId(key);
			emp.setFirstName("FirstName_" + i);
			emp.setLastName("LastName_" + i);
			emp.setGender(i % 2 == 0 ? "Male" : "Female");
			emp.setFavSports("Basketball|Football|Swim|Skate");
			emp.setPhoneNumber("13826878_" + i);
			emp.setEmail("email_" + i + "@company.com");
			emp.setWechat("wecat_" + i);
			emp.setCompany("Company_" + i);
			emp.setSpouse("XXXXXXXXX" + i);
			emp.setManager("Manager_" + i);
			emp.setTitle("title_expert_senior_" + i);
			emp.setExpertise("SOA|Coherence|OEP|WebLogic|PaaS");
			emp.setAddr1("ADDR1_addrxxx_" + i);
			emp.setAddr2("ADDR2_addrxxx_" + i);
			emp.setAddr3("ADDR3_addrxxx_" + i);
			emp.setBadgeNo("0000" + i);
			emp.setJoinDate("2012-12-25");
			emp.setEmpNo("000" + i);
			emp.setComments("No further comments!");

			buf.put(key, emp);

			if (i % 1000 == 0) {
				System.out.println("*** Insert batch: " + (i / 1000));
				cache.putAll(buf);
				buf.clear();
			}
		}

		if (!buf.isEmpty()) {
			System.out.println("*** Insert the last batch.");
			cache.putAll(buf);
			buf.clear();
		}

		System.out.println("*** Done data loading, cache size is: " + cache.size());
	}
}
