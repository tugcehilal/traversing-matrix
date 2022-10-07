package com.asml.traversingmatrix;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import static com.asml.traversingmatrix.TestSupport.*;
import static org.junit.jupiter.api.Assertions.*;

public class SpiralTraverseTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final SpiralTravers spiralTravers = new SpiralTravers();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testSpiralTravers_whenArrHas4By4Square2D_outputShouldBeSpiralOrderedList() {
        spiralTravers.spiralTravers(square2DArray);
        assertEquals(square2DArrayOutput, outputStreamCaptor.toString());
    }

    @Test
    public void testSpiralTravers_whenArrHas1Array_outputShouldBeFirstArray() {
        spiralTravers.spiralTravers(oneLevelArray);
        assertEquals(oneLevelArrayOutput, outputStreamCaptor.toString());
    }

    @Test
    public void testSpiralTravers_whenArrHas4By3NonSquare2DArray_outputShouldBeSpiralOrderedList() {
        spiralTravers.spiralTravers(nonSquare2DArray);
        assertEquals(nonSquare2DArrayOutput, outputStreamCaptor.toString());
    }

    @Test
    public void testSpiralTravers_whenArrIsEmpty_outputShouldBeEmpty() {
        int[][] arr = new int[][] {};
        spiralTravers.spiralTravers(arr);
        assertEquals("", outputStreamCaptor.toString());
    }

    @Test
    public void testSpiralTravers_whenArrIsNull_outputShouldBeEmpty() {
        int[][] arr = null;
        spiralTravers.spiralTravers(arr);
        assertEquals("", outputStreamCaptor.toString());
    }

    @Test
    public void testSpiralTravers_whenMultipleThreadRuns_outputShouldBeSynchronized() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        IntStream.range(0, 3)
                .forEach(i -> service.submit(() -> spiralTravers.spiralTravers(square2DArray)));
        service.awaitTermination(1000, TimeUnit.MILLISECONDS);
        assertEquals(square2DArrayOutput + square2DArrayOutput + square2DArrayOutput, outputStreamCaptor.toString());

    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

}