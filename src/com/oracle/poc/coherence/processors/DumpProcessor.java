/***************************************************************************
 *
 * PoC code for evaluating purpose only. No guarantee of quality.
 *
 ***************************************************************************/

package com.oracle.poc.coherence.processors;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.oracle.poc.coherence.model.Employee;
import com.tangosol.io.pof.PofReader;
import com.tangosol.io.pof.PofWriter;
import com.tangosol.io.pof.PortableObject;
import com.tangosol.net.GuardSupport;
import com.tangosol.net.Guardian.GuardContext;
import com.tangosol.util.BinaryEntry;
import com.tangosol.util.InvocableMap.Entry;
import com.tangosol.util.processor.AbstractProcessor;

@SuppressWarnings("rawtypes")
public class DumpProcessor extends AbstractProcessor implements PortableObject, Serializable {
	private static final long serialVersionUID = -781339817870994270L;

	private String expDir;

	public DumpProcessor() {
		this("/app/oracle/coherence_export");
	}

	public DumpProcessor(String expDir) {
		File fExpDir = new File(expDir);
		if (!fExpDir.exists()) {
			fExpDir.mkdirs();
		}
		this.expDir = fExpDir.getPath();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tangosol.util.InvocableMap.EntryProcessor#process(com.tangosol.util.
	 * InvocableMap.Entry)
	 */
	@Override
	public Object process(Entry entry) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tangosol.util.processor.AbstractProcessor#processAll(java.util.Set)
	 */
	@Override
	public Map processAll(Set entries) {
		final Map<String, String> result = new HashMap<>();
		if (entries == null || entries.size() == 0) {
			return result;
		}

		System.out.println("*** Total entries to be exported: " + entries.size());

		Iterator iter = entries.iterator();
		BinaryEntry bEntry = (BinaryEntry) iter.next();
		String nodeName = System.getProperty("app.nodeName");
		if (nodeName == null || nodeName.trim().isEmpty()) {
			nodeName = String.valueOf(bEntry.getBackingMapContext().getManagerContext().getCacheService().getCluster()
					.getLocalMember().getId());
		}

		final String expFilePath = this.expDir + File.separator + "exp_" + nodeName + ".csv";
		File expFile = new File(expFilePath);
		if (expFile.exists()) {
			expFile.delete();
		}

		System.out.println("*** Exporting data to file: " + expFile);
		BufferedWriter writer = null;
		StringBuilder buf = new StringBuilder(2048);
		int i = 1;
		try {
			writer = new BufferedWriter(new FileWriter(expFile, true));
			// Write header
			buf.append("id").append(",").append("firstName").append(",").append("lastName").append(",").append("gender")
					.append(",").append("favSports").append(",").append("phoneNumber").append(",").append("email")
					.append(",").append("wechat").append(",").append("company").append(",").append("spouse").append(",")
					.append("manager").append(",").append("title").append(",").append("expertise").append(",")
					.append("addr1").append(",").append("addr2").append(",").append("addr3").append(",")
					.append("badgeNo").append(",").append("joinDate").append(",").append("empNo").append(",")
					.append("comments");

			// Write data
			GuardContext ctxGuard = GuardSupport.getThreadContext();
			do {
				Employee emp = (Employee) bEntry.getValue();
				buf.append("\n").append(emp.getId()).append(",").append(emp.getFirstName()).append(",")
						.append(emp.getLastName()).append(",").append(emp.getGender()).append(",")
						.append(emp.getFavSports()).append(",").append(emp.getPhoneNumber()).append(",")
						.append(emp.getEmail()).append(",").append(emp.getWechat()).append(",").append(emp.getCompany())
						.append(",").append(emp.getSpouse()).append(",").append(emp.getManager()).append(",")
						.append(emp.getTitle()).append(",").append(emp.getExpertise()).append(",")
						.append(emp.getAddr1()).append(",").append(emp.getAddr2()).append(",").append(emp.getAddr3())
						.append(",").append(emp.getBadgeNo()).append(",").append(emp.getJoinDate()).append(",")
						.append(emp.getEmpNo()).append(",").append(emp.getComments());

				// Write file by batch
				if (i % 1000 == 0) {
					System.out.println("*** Flush " + (i / 1000));
					buf.trimToSize();
					writer.write(buf.toString());
					writer.flush();
					buf = null;
					buf = new StringBuilder(204800);
				}

				long cMillis = ctxGuard == null ? 0L : ctxGuard.getTimeoutMillis();
				if (ctxGuard != null) {
					if (i % 50 == 0) {
						ctxGuard.heartbeat(cMillis);
					}
				}

				i++;

				if (iter.hasNext()) {
					bEntry = (BinaryEntry) iter.next();
				} else {
					break;
				}
			} while (true);

			if (buf.length() > 0) {
				buf.trimToSize();
				writer.write(buf.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
					writer = null;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("*** Done data export, please check the file: " + expFile);

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tangosol.io.pof.PortableObject#readExternal(com.tangosol.io.pof.
	 * PofReader)
	 */
	@Override
	public void readExternal(PofReader in) throws IOException {
		this.expDir = in.readString(0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tangosol.io.pof.PortableObject#writeExternal(com.tangosol.io.pof.
	 * PofWriter)
	 */
	@Override
	public void writeExternal(PofWriter out) throws IOException {
		out.writeString(0, this.expDir);
	}

}
