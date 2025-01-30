package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import banking.RepayLoan;

class RepayLoanTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		setOutput();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testExecuteIntegration() {
		
		assertDoesNotThrow(() -> new RepayLoan(0, "x").execute(new String[] { "null" }));
		assertEquals("Either loan Id is invalid or loan has not been approved yet.",getOutput().trim());
	}

	@Test
	void testToString() {
		RepayLoan r = new RepayLoan(20, "20");
		assertEquals("Repaid 20.0 for loan 20", r.toString());
	}
	PrintStream oldPrintStream;
	ByteArrayOutputStream bos;

	private void setOutput() throws Exception {
		oldPrintStream = System.out;
		bos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bos));
	}

	private String getOutput() { // throws Exception
		System.setOut(oldPrintStream);
		return bos.toString();
	}


}
