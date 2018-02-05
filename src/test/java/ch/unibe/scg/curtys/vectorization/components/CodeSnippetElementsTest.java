package ch.unibe.scg.curtys.vectorization.components;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author curtys
 */
public class CodeSnippetElementsTest {

	private String text1 = "Storing numerical constants in the single class\n"
			+ "\n"
			+ "This is a small step to address the issue, but it makes sense on its own since\n"
			+ "currently script containing\n"
			+ "\n"
			+ "function f() { return 1; }\n"
			+ "function g() { return 1; }\n"
			+ "\n"
			+ "print(f()+g()+Math.sqrt(1));\n"
			+ "\n"
			+ "would create 3 classes each contain a code to generate a wrapper Number object\n"
			+ "to represent 1 and with the patch the single constant from the class for the\n"
			+ "main script will be used.";

	private String text2 = "Currently Rhino optimizer generates one Java class per JavaScript function which\n"
			+ "may lead to significant runtime overhead. I think it would be worth to try to\n"
			+ "replace that by a single class with a switch dispatch to select code for a\n"
			+ "particular function. I open this report to record work on it.";

	private String text3 = "void constructor(Context cx, Scriptable scope, int id)\n"
			+ "{\n"
			+ "    store id\n"
			+ "    static call to firestGeneratedClass._i<id>(this, cx, scope);\n"
			+ "}";

	private String text4 = "Simply compare JspRuntimeContext.checkCompile(), this calls \n"
			+ "ctxt.incrementRemoved() if a FileNotFoundException occur. JspServletWrapper \n"
			+ "only set a 404 if a FileNotFoundException occur and finish. \n"
			+ " \n"
			+ "Code from JspRuntineContext: \n"
			+ "            synchronized(jsw) { \n"
			+ "                try { \n"
			+ "                    ctxt.compile(); \n"
			+ "                } catch (FileNotFoundException ex) { \n"
			+ "                    ctxt.incrementRemoved(); \n"
			+ "                } catch (Throwable t) { \n"
			+ "                    jsw.getServletContext().log(\"Background compile failed\", \n"
			+ "                                                t); \n"
			+ "                } \n"
			+ "            } \n"
			+ " \n"
			+ "Code from JspServletWrapper: \n"
			+ " \n"
			+ "       } catch (FileNotFoundException ex) { \n"
			+ "            String includeRequestUri = (String) \n"
			+ "                request.getAttribute(\"javax.servlet.include.request_uri\"); \n"
			+ "            if (includeRequestUri != null) { \n"
			+ "                // This file was included. Throw an exception as \n"
			+ "                // a response.sendError() will be ignored by the \n"
			+ "                // servlet engine. \n"
			+ "                throw new ServletException(ex); \n"
			+ "            } else { \n"
			+ "                try { \n"
			+ "                    response.sendError(HttpServletResponse.SC_NOT_FOUND, \n"
			+ "                                      ex.getMessage()); \n"
			+ "                } catch (IllegalStateException ise) { \n"
			+ "                    log.error(Localizer.getMessage(\"jsp.error.file.not.found\", \n"
			+ "                                                   ex.getMessage()), \n"
			+ "                              ex); \n"
			+ "                } \n"
			+ " \n"
			+ " \n"
			+ "add a simple ctxt.incrementRemoved in catch block and test case works. ";

	private String text5 = "new URIBuilder(\"http://www.example.com\").addParameter(\"foo\", \"bar\")";

	private String text6 = "Failure to close the connection manifests itself differently depending on the\n"
			+ "server. Weblogic, for example, complains loudly:\n"
			+ "\n"
			+ "<Dec 9, 2003 2:25:56 PM EST> <Error> <HTTP> <BEA-101083> <Connection failure.\n"
			+ "java.io.IOException: A complete message could not be read on socket:\n"
			+ "'weblogic.servlet.internal.MuxableSocketHTTP@194a955 - idle timeout: '60000' ms,\n"
			+ "socket timeout: '30000' ms', in the configured timeout period of '60' secs\n"
			+ "at weblogic.socket.SocketMuxer$TimeoutTrigger.trigger(SocketMuxer.java:775)";

	private String text7 = "          mozilla/js/tests/ecma_3/Function/regress-131964.js";

	private String text8 = "\n"
			+ "Checking in Interpreter.java;\n"
			+ "/cvsroot/mozilla/js/rhino/src/org/mozilla/javascript/Interpreter.java,v  <--  In\n"
			+ "terpreter.java\n"
			+ "new revision: 1.74; previous revision: 1.73\n"
			+ "done";

	private String text9 = "FAILED!: Section 1 of test -\n"
			+ "FAILED!: Expected value 'f lives!', Actual value 'f was deleted'\n"
			+ "\n"
			+ "FAILED!: Section 2 of test -\n"
			+ "FAILED!: Expected value 'f lives!', Actual value 'f was deleted'";

	private String text10 = "Matcher matcher = pattern.matcher(text);";

	private CodeSnippetElements vecElement = new CodeSnippetElements();

	@Test
	public void filterTest() {
		assertTrue(vecElement.matchesFilter(text1));
		assertFalse(vecElement.matchesFilter(text2));
		assertTrue(vecElement.matchesFilter(text3));
		assertTrue(vecElement.matchesFilter(text4));
		assertTrue(vecElement.matchesFilter(text5));
		assertFalse(vecElement.matchesFilter(text6));
		assertFalse(vecElement.matchesFilter(text7));
		assertFalse(vecElement.matchesFilter(text8));
		assertFalse(vecElement.matchesFilter(text9));
		assertTrue(vecElement.matchesFilter(text10));
	}

}