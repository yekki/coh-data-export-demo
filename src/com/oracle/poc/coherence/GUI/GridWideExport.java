/***************************************************************************
 *
 * PoC code for evaluating purpose only. No guarantee of quality.
 *
 ***************************************************************************/

package com.oracle.poc.coherence.GUI;

import static com.tangosol.net.cache.TypeAssertion.withTypes;

import java.util.Date;

import com.oracle.poc.coherence.model.Employee;
import com.oracle.poc.coherence.processors.DumpProcessor;
import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;
import com.tangosol.util.filter.AlwaysFilter;


public class GridWideExport {
	@SuppressWarnings({ "unchecked" })
	public static void main(String[] args) {
		NamedCache<String, Employee> cache = CacheFactory.getTypedCache("Employee",
				withTypes(String.class, Employee.class));

		System.out.println("*** Invoking EP for grid execution..." + new Date());

		String dest = System.getenv("EXPORT_DIR");
		
		if ( dest == null || dest == "" ) dest = "/Users/gniu/Temp/";
		
		System.out.println(dest);
		cache.invokeAll(AlwaysFilter.INSTANCE, new DumpProcessor(dest));

		System.out.println("*** Done..." + new Date());
	}
}
