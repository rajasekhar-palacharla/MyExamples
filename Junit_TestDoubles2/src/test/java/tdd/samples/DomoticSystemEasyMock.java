package tdd.samples;

import static org.easymock.EasyMock.createNiceMock;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import org.junit.Test;

public class DomoticSystemEasyMock {

	@Test
	public void test_activate_security() {
		WindowController windowSpy = createNiceMock(WindowController.class);
		DoorsController doorsSpy = createNiceMock(DoorsController.class);
		DomoticSystem domotic = new DomoticSystem(windowSpy, doorsSpy);
		replay(windowSpy);
		domotic.activateSecurity();
		verify(windowSpy);

		replay(doorsSpy);
		domotic.activateSecurity();
		verify(doorsSpy);
	}

}
