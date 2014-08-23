package tdd.marsrover;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class MarsRoverControlUnitMockitoTest {

	@Test
	// (expected=Exception.class)
	public void can_move_fordward_once() {

		Engine engineSpy = mock(Engine.class);
		// MarsRoverControlUnit marsRover = new MarsRoverControlUnit(engineSpy);

		// marsRover.move("f");
		when(engineSpy.fordward(10)).thenReturn(20);

		assertEquals(20, engineSpy.fordward(10));
		verify(engineSpy);

	}
}
